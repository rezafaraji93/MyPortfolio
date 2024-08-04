@file:OptIn(KoinExperimentalAPI::class)

package experience_detaills.presentation

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
import experience_detaills.presentation.component.AboutCompanySection
import experience_detaills.presentation.component.ExperienceHeaderSection
import experience_detaills.presentation.component.ExperienceImageGallery
import experience_detaills.presentation.component.ExperienceResponsibilitiesSection
import myportfolio.composeapp.generated.resources.Res
import myportfolio.composeapp.generated.resources.arrow_back
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.core.parameter.parametersOf

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
            ExperienceHeaderSection(experience = successState.data.experience)
            HorizontalDivider(
                modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp),
                thickness = 2.dp,
                color = MaterialTheme.colorScheme.secondary
            )
            AboutCompanySection(
                companyDescription = successState.data.experience?.aboutCompany ?: ""
            )
            Spacer(modifier = Modifier.height(40.dp))
            ExperienceImageGallery(
                modifier = Modifier.fillMaxWidth(),
                images = successState.data.experience?.images
            )
            Spacer(modifier = Modifier.height(40.dp))
            ExperienceResponsibilitiesSection(
                responsibilities = successState.data.experience?.responsibilities
            )
        }
    }, onRetry = viewModel::onRetry
    )

}