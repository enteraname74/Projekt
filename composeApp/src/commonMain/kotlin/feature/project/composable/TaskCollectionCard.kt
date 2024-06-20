package com.github.enteraname74.projekt.feature.project.composable

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text2.input.rememberTextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coreui.button.PktIconButton
import coreui.card.PktCard
import coreui.card.PktCardColors
import coreui.spec.IconSpec
import coreui.textfield.PktTextField
import coreui.theme.PktTheme
import coreui.theme.UiConst
import model.Task
import model.TaskCollection

@Composable
fun TaskCollectionCard(
    modifier: Modifier = Modifier,
    taskCollection: TaskCollection,
    onTaskClicked: (task: Task) -> Unit,
    onDeleteClick: () -> Unit,
    onEditTitle: (title: String) -> Unit,
) {
    PktCard(
        colors = PktCardColors(
            containerColor = PktTheme.colorScheme.surfaceContainerLow,
            contentColor = PktTheme.colorScheme.onSurface,
        )
    ) {
        Column(
            modifier = modifier
                .padding(
                    vertical = UiConst.Spacing.small,
                    horizontal = UiConst.Spacing.medium,
                ),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Header(
                onDeleteClick = onDeleteClick,
                onEditTitle = onEditTitle,
                title = taskCollection.title,
            )
            LazyColumn {
                items(items = taskCollection.tasks) { task ->
                    TaskCard(
                        task = task,
                        onClick = { onTaskClicked(task) },
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun Header(
    onDeleteClick: () -> Unit,
    onEditTitle: (title: String) -> Unit,
    title: String,
) {
    val titleState = rememberTextFieldState(initialText = title)

    PktCard {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = UiConst.Spacing.small),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(UiConst.Spacing.small)
        ) {
            PktTextField(
                modifier = Modifier
                    .width(TaskCollectionTitleWidth),
                textState = titleState,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done,
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        onEditTitle(titleState.text.toString())
                    }
                ),
                singleLine = true
            )
            PktIconButton(
                onClick = onDeleteClick,
                iconSpec = IconSpec(
                    icon = Icons.Default.Delete,
                    size = UiConst.IconSize.small,
                    tint = PktTheme.colorScheme.error,
                )
            )
        }
    }
}
private val TaskCollectionTitleWidth: Dp = 200.dp
