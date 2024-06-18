package com.github.enteraname74.projekt.feature.home.composable

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text2.input.TextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Cancel
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coreui.button.PktIconButton
import coreui.spec.IconSpec
import coreui.textfield.PktTextField
import coreui.theme.UiConst

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProjectCreation(
    modifier: Modifier = Modifier,
    onDismiss: () -> Unit,
    onValidate: () -> Unit,
    onSetTitle: (String) -> Unit,
    onSetDescription: (String) -> Unit,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(UiConst.Spacing.large),
    ) {
        PktIconButton(
            onClick = onDismiss,
            iconSpec = IconSpec(
                icon = Icons.Rounded.Cancel,
                size = UiConst.IconSize.medium,
                tint = MaterialTheme.colorScheme.onSecondary
            )
        )
        PktTextField(
            textState = TextFieldState(),
            label = "Title",
            singleLine = true,
        )
        PktTextField(
            textState = TextFieldState(),
            label = "Description"
        )
    }
}