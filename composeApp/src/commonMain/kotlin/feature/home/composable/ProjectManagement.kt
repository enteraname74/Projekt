package com.github.enteraname74.projekt.feature.home.composable

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text2.input.rememberTextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import coreui.button.PktIconButton
import coreui.spec.IconSpec
import coreui.spec.TopBarAction
import coreui.textfield.PktTextField
import coreui.theme.PktTheme
import coreui.theme.UiConst
import coreui.topbar.PktTopBar
import model.Project
import org.jetbrains.compose.resources.stringResource
import projekt.composeapp.generated.resources.*
import java.util.*

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProjectManagement(
    modifier: Modifier = Modifier,
    project: Project?,
    onDismiss: () -> Unit,
    onDelete: (projectId: UUID) -> Unit,
    onValidate: (project: Project) -> Unit,
) {

    val titleState = rememberTextFieldState(initialText = project?.title.orEmpty())
    val descriptionState = rememberTextFieldState(initialText = project?.description.orEmpty())

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier),
        verticalArrangement = Arrangement.spacedBy(UiConst.Spacing.large),
    ) {
        Header(
            isCreatingProject = project == null,
            onDismiss = onDismiss,
            onValidate = {
                val projectToSave = project?.copy(
                    title = titleState.text.toString(),
                    description = descriptionState.text.toString()
                )
                    ?: Project(
                        title = titleState.text.toString(),
                        description = descriptionState.text.toString()
                    )
                onValidate(projectToSave)
            },
            canCreateProject = titleState.text.isNotBlank()
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(UiConst.Spacing.large),
            verticalArrangement = Arrangement.spacedBy(UiConst.Spacing.large),
        ) {
            PktTextField(
                modifier = Modifier.fillMaxWidth(),
                textState = titleState,
                label = stringResource(Res.string.homePage_projectManagement_titleField),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                )
            )
            PktTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(500.dp),
                textState = descriptionState,
                label = stringResource(Res.string.homePage_projectManagement_descriptionField),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done,
                )
            )
        }
        project?.let {
            DeleteButton(
                onDelete = { onDelete(it.id) }
            )
        }
    }
}

@Composable
private fun DeleteButton(
    onDelete: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        PktIconButton(
            onClick = onDelete,
            iconSpec = IconSpec(
                icon = Icons.Default.Delete,
                size = UiConst.Spacing.medium,
                tint = PktTheme.colorScheme.errorContainer,
            )
        )
    }
}

@Composable
private fun Header(
    isCreatingProject: Boolean,
    onDismiss: () -> Unit,
    onValidate: () -> Unit,
    canCreateProject: Boolean,
) {
    PktTopBar(
        leftAction = TopBarAction(
            onClick = onDismiss,
            icon = Icons.Default.Cancel,
        ),
        title = if (isCreatingProject) {
            stringResource(Res.string.homePage_projectManagement_create)
        } else {
            stringResource(Res.string.homePage_projectManagement_edit)
        },
        rightAction = if (canCreateProject) {
            TopBarAction(
                onClick = onValidate,
                icon = Icons.Default.Check,
            )
        } else {
            null
        }
    )
}