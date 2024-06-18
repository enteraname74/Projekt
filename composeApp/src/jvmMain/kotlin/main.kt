import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import java.awt.Dimension
import com.github.enteraname74.projekt.ProjektApplication
import com.github.enteraname74.projekt.di.appModule
import org.koin.compose.KoinApplication

fun main() = application {
    LocalDatabaseInitializer().initDatabase()
    KoinApplication(
        application = {
            modules(appModule)
        }
    ) {
        Window(
            title = "Projekt",
            state = rememberWindowState(width = 800.dp, height = 600.dp),
            onCloseRequest = ::exitApplication,
        ) {
            window.minimumSize = Dimension(350, 600)
            ProjektApplication()
        }
    }
}