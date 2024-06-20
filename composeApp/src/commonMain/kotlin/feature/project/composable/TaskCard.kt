package com.github.enteraname74.projekt.feature.project.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import coreui.card.PktCard
import coreui.card.PktCardColors
import coreui.text.PktText
import coreui.theme.PktTheme
import coreui.theme.UiConst
import model.Task

@Composable
fun TaskCard(
    modifier: Modifier = Modifier,
    task: Task,
    onClick: () -> Unit,
) {
    PktCard(
        onClick = onClick,
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(UiConst.Spacing.medium),
            verticalArrangement = Arrangement.spacedBy(UiConst.Spacing.medium)
        ) {
            PktText(
                text = task.title,
                style = PktTheme.typography.bodyBold,
            )
            if (task.description.isNotBlank()) {
                PktText(
                    text = task.description,
                    maxLines = 2,
                )
            }
            if (task.weight.isNotBlank()) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.End,
                ) {
                    PktCard(
                        colors = PktCardColors(
                            containerColor = PktTheme.colorScheme.primary,
                            contentColor = PktTheme.colorScheme.onPrimary,
                        )
                    ) {
                        PktText(
                            text = task.weight,
                            style = PktTheme.typography.bodyBold,
                        )
                    }
                }
            }
        }
    }
}