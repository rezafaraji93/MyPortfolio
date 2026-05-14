package home.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import component.BaseScreen
import component.DescriptionComponent
import component.ExperienceItem
import component.TitleComponent
import component.TopSection
import core.domain.BaseState
import home.presentation.component.ProjectsSection
import myportfolio.composeapp.generated.resources.Res
import myportfolio.composeapp.generated.resources.about_me
import myportfolio.composeapp.generated.resources.experiences
import myportfolio.composeapp.generated.resources.my_projects
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import util.appearanceAnimation

@Composable
fun HomeScreen(
    onNavigateToExperienceDetails: (String) -> Unit
) {
    val viewModel = koinViewModel<HomeScreenViewModel>()
    val state by viewModel.homeState.collectAsState()

    HomeScreenContent(
        baseState = state,
        onRetry = viewModel::onRetry,
        onNavigateToExperienceDetails = onNavigateToExperienceDetails
    )

}

@Composable
fun HomeScreenContent(
    modifier: Modifier = Modifier,
    baseState: BaseState<HomeState>,
    onRetry: () -> Unit,
    onNavigateToExperienceDetails: (String) -> Unit
) {

    BaseScreen(state = baseState, autoPadding = false, onRetry = onRetry, content = { state ->

        val data = state.data.homeData

        LazyColumn(
            modifier = modifier.fillMaxSize()
        ) {
            item {
                TopSection(
                    modifier = Modifier.appearanceAnimation(delayMillis = 100),
                    profilePicture = data.profilePicture,
                    title = data.title,
                    name = data.name,
                    cvUrl = data.cvUrl,
                    linkedInUrl = data.linkedinUrl,
                    githubUrl = data.githubUrl
                )
            }
            item {
                Spacer(modifier = Modifier.height(60.dp))
                Column(modifier = Modifier.appearanceAnimation(delayMillis = 300)) {
                    TitleComponent(
                        title = stringResource(Res.string.about_me)
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    DescriptionComponent(
                        description = data.aboutMe
                    )
                }
            }
            item {
                Spacer(modifier = Modifier.height(60.dp))
                TitleComponent(
                    modifier = Modifier.appearanceAnimation(delayMillis = 400),
                    title = stringResource(Res.string.experiences)
                )
            }
            items(data.experiences) { experience ->
                ExperienceItem(
                    modifier = Modifier
                        .padding(vertical = 12.dp)
                        .appearanceAnimation(delayMillis = 500),
                    experience = experience,
                    onReadMore = onNavigateToExperienceDetails
                )
            }
            item {
                Spacer(modifier = Modifier.height(60.dp))
                TitleComponent(
                    modifier = Modifier.appearanceAnimation(delayMillis = 600),
                    title = stringResource(Res.string.my_projects)
                )
            }
            item {
                Spacer(modifier = Modifier.height(24.dp))
                ProjectsSection(
                    modifier = Modifier.appearanceAnimation(delayMillis = 700),
                    projects = data.projects
                )
            }
            item { Spacer(modifier = Modifier.height(48.dp)) }

        }
    })

}
