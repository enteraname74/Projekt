package com.github.enteraname74.projekt.di

import org.koin.dsl.module
import sharedModule

val appModule = module {
    includes(viewModelModule, sharedModule)
}