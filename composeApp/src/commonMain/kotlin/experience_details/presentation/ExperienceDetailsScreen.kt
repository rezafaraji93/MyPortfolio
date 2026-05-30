@file:OptIn(KoinExperimentalAPI::class)

package experience_details.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import component.BaseScreen
import experience_details.presentation.component.AboutCompanySection
import experience_details.presentation.component.ExperienceHeaderSection
import experience_details.presentation.component.ExperienceImageGallery
import experience_details.presentation.component.ExperienceResponsibilitiesSection
import myportfolio.composeapp.generated.resources.Res
import myportfolio.composeapp.generated.resources.arrow_back
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.core.parameter.parametersOf
import util.appearanceAnimation

@Composable
fun ExperienceDetailsScreen(
    experienceId: String?, onNavigateUp: () -> Unit
) {

    val viewModel = koinViewModel<ExperienceDetailsViewModel> {
        parametersOf(experienceId)
    }
    val state by viewModel.state.collectAsState()

    BaseScreen(topBar = {
        Box(
            modifier = Modifier.fillMaxWidth().background(MaterialTheme.colorScheme.surface)
                .padding(16.dp)
        ) {
            IconButton(
                content = {
                    Icon(
                        painter = painterResource(Res.drawable.arrow_back),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                }, onClick = onNavigateUp, colors = IconButtonColors(
                    containerColor = MaterialTheme.colorScheme.secondaryContainer,
                    contentColor = MaterialTheme.colorScheme.onSecondaryContainer,
                    disabledContentColor = MaterialTheme.colorScheme.onSecondaryContainer.copy(
                        0.5f
                    ),
                    disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer.copy(
                        .5f
                    )
                )
            )
        }
    }, state = state, content = { successState ->
        Column(
            modifier = Modifier.fillMaxSize().padding(vertical = 24.dp)
                .verticalScroll(rememberScrollState())
        ) {
            ExperienceHeaderSection(
                modifier = Modifier.appearanceAnimation(delayMillis = 100),
                experience = successState.data.experience
            )
            HorizontalDivider(
                modifier = Modifier.fillMaxWidth().padding(vertical = 32.dp)
                    .appearanceAnimation(delayMillis = 100),
                thickness = 1.dp,
                color = MaterialTheme.colorScheme.outlineVariant
            )
            AboutCompanySection(
                modifier = Modifier.appearanceAnimation(delayMillis = 100),
                companyDescription = successState.data.experience?.aboutCompany ?: ""
            )
            Spacer(modifier = Modifier.height(48.dp))
            ExperienceImageGallery(
                modifier = Modifier.fillMaxWidth().appearanceAnimation(delayMillis = 100),
                images = successState.data.experience?.images
            )
            Spacer(modifier = Modifier.height(48.dp))
            ExperienceResponsibilitiesSection(
                modifier = Modifier.appearanceAnimation(delayMillis = 100),
                responsibilities = successState.data.experience?.responsibilities
            )
            Spacer(modifier = Modifier.height(48.dp))
        }
    }, onRetry = viewModel::onRetry
    )

}
