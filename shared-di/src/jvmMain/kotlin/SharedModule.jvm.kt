import di.localDesktopDataModule
import org.koin.dsl.module

actual val localModule = module {
    includes(localDesktopDataModule)
}