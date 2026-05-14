import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.savedstate.read
import coil3.ImageLoader
import coil3.PlatformContext
import coil3.compose.setSingletonImageLoaderFactory
import coil3.request.crossfade
import coil3.util.DebugLogger
import di.networkModule
import experience_detaills.data.di.experienceDataModule
import experience_detaills.presentation.ExperienceDetailsScreen
import experience_detaills.presentation.di.experienceDetailsPresentationDi
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
                    startDestination = "home",
                    modifier = Modifier.fillMaxSize().padding(paddingValues)
                ) {
                    composable(route = "home") {
                        HomeScreen(
                            onNavigateToExperienceDetails = { id ->
                                navController.navigate("experience_details/$id")
                            }
                        )
                    }
                    composable(
                        route = "experience_details/{id}",
                        arguments = listOf(
                            navArgument("id") {
                                type = NavType.StringType
                                nullable = false
                            }
                        )
                    ) { backStackEntry ->
                        ExperienceDetailsScreen(
                            onNavigateUp = navController::navigateUp,
                            experienceId = backStackEntry.arguments?.read { getString("id") }
                        )
                    }
                }
            }
        }
    })
}

internal expect fun openUrl(url: String?)