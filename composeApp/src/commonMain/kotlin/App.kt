import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import component.DescriptionComponent
import component.ExperienceItem
import component.LinkIcon
import component.TitleComponent
import component.TopSection
import model.Experience
import model.LinkType
import myportfolio.composeapp.generated.resources.Res
import myportfolio.composeapp.generated.resources.about_me
import myportfolio.composeapp.generated.resources.about_me_description
import myportfolio.composeapp.generated.resources.android_developer
import myportfolio.composeapp.generated.resources.experiences
import myportfolio.composeapp.generated.resources.my_img
import myportfolio.composeapp.generated.resources.my_name
import myportfolio.composeapp.generated.resources.view_cv
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import theme.AppTheme
import util.MY_RESUME_URL

@OptIn(ExperimentalComposeUiApi::class)
@Composable
@Preview
fun App() {

    AppTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            containerColor = MaterialTheme.colorScheme.background
        ) { paddingValues ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                item {
                    TopSection()
                }
                item {
                    Spacer(modifier = Modifier.height(40.dp))
                    TitleComponent(
                        title = stringResource(Res.string.about_me)

                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    DescriptionComponent(
                        description = stringResource(Res.string.about_me_description)
                    )
                }
                item {
                    Spacer(modifier = Modifier.height(40.dp))
                    TitleComponent(
                        title = stringResource(Res.string.experiences)
                    )
                }
                item {
                    Spacer(modifier = Modifier.height(16.dp))
                    ExperienceItem(
                        experience = Experience.Bit24
                    )
                }
                item {
                    Spacer(modifier = Modifier.height(16.dp))
                    ExperienceItem(
                        experience = Experience.Raybit
                    )
                }
                item {
                    Spacer(modifier = Modifier.height(16.dp))
                    ExperienceItem(
                        experience = Experience.HopeSky
                    )
                }
                item {
                    Spacer(modifier = Modifier.height(24.dp))
                }
            }
        }

    }
}

internal expect fun openUrl(url: String?)