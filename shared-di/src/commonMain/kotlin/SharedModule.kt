import di.repositoryModule
import di.useCaseModule
import org.koin.core.module.Module
import org.koin.dsl.module

val sharedModule = module {
    includes(
        useCaseModule,
        repositoryModule,
        localModule,
    )
}

expect val localModule: Module