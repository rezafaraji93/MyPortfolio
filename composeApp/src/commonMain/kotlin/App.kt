import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import coil3.ImageLoader
import coil3.PlatformContext
import coil3.compose.setSingletonImageLoaderFactory
import coil3.request.crossfade
import coil3.util.DebugLogger
import core.Navigation
import di.networkModule
import experience_details.data.di.experienceDataModule
import experience_details.presentation.ExperienceDetailsScreen
import experience_details.presentation.di.experienceDetailsPresentationDi
import home.data.di.homeDataModule
import home.presentation.HomeScreen
import org.koin.compose.KoinApplication
import org.koin.dsl.koinConfiguration
import theme.AppTheme

fun getAsyncImageLoader(context: PlatformContext) =
    ImageLoader.Builder(context).crossfade(true).logger(DebugLogger()).build()

@Composable
fun App(
    onNavHostReady: suspend (NavController) -> Unit = {}
) {

    KoinApplication(configuration = koinConfiguration(declaration = {
        modules(
            networkModule,
            homeDataModule,
            experienceDataModule,
            experienceDetailsPresentationDi
        )
    }), content = {

        setSingletonImageLoaderFactory { context ->
            getAsyncImageLoader(context)
        }

        val navController = rememberNavController()

        LaunchedEffect(navController) {
            onNavHostReady(navController)
        }

        AppTheme {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                containerColor = MaterialTheme.colorScheme.background
            ) { paddingValues ->
                NavHost(
                    navController = navController,
                    startDestination = Navigation.HomeScreen,
                    modifier = Modifier.fillMaxSize().padding(paddingValues)
                ) {
                    composable<Navigation.HomeScreen> {
                        HomeScreen(
                            onNavigateToExperienceDetails = { id ->
                                navController.navigate("experience_details/$id")
                            }
                        )
                    }
                    composable<Navigation.ExperienceDetailsScreen> { backStackEntry ->
                        val experienceId = backStackEntry.toRoute<Navigation.ExperienceDetailsScreen>().id
                        ExperienceDetailsScreen(
                            onNavigateUp = navController::navigateUp,
                            experienceId = experienceId
                        )
                    }
                }
            }
        }
    })
}

internal expect fun openUrl(url: String?)