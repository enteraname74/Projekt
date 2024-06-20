package com.github.enteraname74.projekt.feature.project

import model.Project

sealed interface ProjectUiState {
    data object Loading : ProjectUiState
    data object Error : ProjectUiState
    data class Data(
        val project: Project,
        val isModalShown: Boolean,
    ) : ProjectUiState
}