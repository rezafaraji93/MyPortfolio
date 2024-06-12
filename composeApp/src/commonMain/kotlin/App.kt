import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import component.DescriptionComponent
import component.ExperienceItem
import component.LinkIcon
import component.TitleComponent
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

@Composable
@Preview
fun App() {
    AppTheme {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            brush = Brush.horizontalGradient(
                                listOf(
                                    Color(0XFF6a11cb),
                                    Color(0XFF2575fc)
                                )
                            )
                        )
                        .padding(horizontal = 20.dp)
                        .padding(top = 100.dp, bottom = 40.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Image(
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(200.dp)
                            .border(
                                width = 4.dp,
                                color = Color.White,
                                shape = CircleShape
                            ),
                        painter = painterResource(Res.drawable.my_img),
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = stringResource(Res.string.my_name),
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = stringResource(Res.string.android_developer),
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Button(
                        content = {
                            Text(text = stringResource(Res.string.view_cv))
                        },
                        onClick = {
                            openUrl(MY_RESUME_URL)
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Blue,
                            contentColor = Color.White
                        ),
                        modifier = Modifier.height(48.dp).clip(RoundedCornerShape(8.dp))
                    )
                    Spacer(Modifier.height(24.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        LinkIcon(
                            linkType = LinkType.LinkedIn
                        )
                        LinkIcon(
                            linkType = LinkType.Github
                        )
                    }
                }
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
        }
    }
}

internal expect fun openUrl(url: String?)