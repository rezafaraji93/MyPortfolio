package home.presentation

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import component.DescriptionComponent
import component.ExperienceItem
import component.TitleComponent
import component.TopSection
import core.domain.HomeData
import myportfolio.composeapp.generated.resources.Res
import myportfolio.composeapp.generated.resources.about_me
import myportfolio.composeapp.generated.resources.experiences
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val viewModel = koinViewModel<HomeScreenViewModel>()
    val state by viewModel.homeState.collectAsState()
    Crossfade(
        state.isLoading
    ) { isLoading ->
        if (isLoading) {
            Box(
                modifier = modifier.fillMaxSize()
            ) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        } else {
            HomeScreenContent(data = state.homeData)
        }
    }

}

@Composable
fun HomeScreenContent(
    modifier: Modifier = Modifier, data: HomeData
) {
    LazyColumn(
        modifier = modifier.fillMaxSize()
    ) {
        item {
            TopSection(
                profilePicture = data.profilePicture,
                title = data.title,
                name = data.name,
                cvUrl = data.cvUrl,
                linkedInUrl = data.linkedinUrl,
                githubUrl = data.githubUrl
            )
        }
        item {
            Spacer(modifier = Modifier.height(40.dp))
            TitleComponent(
                title = stringResource(Res.string.about_me)

            )
            Spacer(modifier = Modifier.height(20.dp))
            DescriptionComponent(
                description = data.aboutMe
            )
        }
        item {
            Spacer(modifier = Modifier.height(40.dp))
            TitleComponent(
                title = stringResource(Res.string.experiences)
            )
        }
        items(data.experiences) { experience ->
            ExperienceItem(
                modifier = Modifier.padding(vertical = 8.dp), experience = experience
            )
        }
        item {
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}