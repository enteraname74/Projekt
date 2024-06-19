package com.github.enteraname74.projekt.feature.home.composable

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text2.input.rememberTextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Cancel
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coreui.button.PktIconButton
import coreui.spec.IconSpec
import coreui.textfield.PktTextField
import coreui.theme.PktTheme
import coreui.theme.UiConst

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProjectCreation(
    modifier: Modifier = Modifier,
    title: String = "",
    description: String = "",
    onDismiss: () -> Unit,
    onValidate: () -> Unit,
    onSetTitle: (String) -> Unit,
    onSetDescription: (String) -> Unit,
) {

    val titleState = rememberTextFieldState(initialText = title)
    val descriptionState = rememberTextFieldState(initialText = description)

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(UiConst.Spacing.large),
    ) {
        PktIconButton(
            onClick = onDismiss,
            iconSpec = IconSpec(
                icon = Icons.Rounded.Cancel,
                size = UiConst.IconSize.medium,
                tint = PktTheme.colorScheme.onSurface
            )
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(UiConst.Spacing.large),
            verticalArrangement = Arrangement.spacedBy(UiConst.Spacing.large),
        ) {
            PktTextField(
                modifier = Modifier.fillMaxWidth(),
                textState = titleState,
                label = "Title",
                singleLine = true,
            )
            PktTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(500.dp),
                textState = descriptionState,
                label = "Description"
            )
        }
    }
}