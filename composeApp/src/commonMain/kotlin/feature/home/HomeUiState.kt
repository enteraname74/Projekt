package com.github.enteraname74.projekt.feature.home

import model.Project

data class HomeUiState(
    val selectedProject: Project? = null,
    val isProjectManagementModalShown: Boolean = false,
)
