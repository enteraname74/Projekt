package com.github.enteraname74.projekt.feature.home

import model.Project

data class HomeUiState(
    val projects: List<Project> = emptyList()
)
