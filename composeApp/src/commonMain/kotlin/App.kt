import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil3.ImageLoader
import coil3.PlatformContext
import coil3.annotation.ExperimentalCoilApi
import coil3.compose.setSingletonImageLoaderFactory
import coil3.request.crossfade
import coil3.util.DebugLogger
import di.networkModule
import home.data.di.homeDataModule
import home.presentation.HomeScreen
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication
import theme.AppTheme

fun getAsyncImageLoader(context: PlatformContext)=
    ImageLoader.Builder(context).crossfade(true).logger(DebugLogger()).build()

@OptIn(ExperimentalCoilApi::class)
@Composable
@Preview
fun App() {

    KoinApplication(
        application = {
            modules(networkModule, homeDataModule)
        }
    ) {

        setSingletonImageLoaderFactory { context ->
            getAsyncImageLoader(context)
        }

        val navController = rememberNavController()
        AppTheme {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                containerColor = MaterialTheme.colorScheme.background
            ) { paddingValues ->
                NavHost(
                    navController = navController,
                    startDestination = "Home",
                    modifier = Modifier.fillMaxSize().padding(paddingValues)
                ) {
                    composable(route = "Home") {
                        HomeScreen()
                    }
                }
            }

        }
    }
}

internal expect fun openUrl(url: String?)