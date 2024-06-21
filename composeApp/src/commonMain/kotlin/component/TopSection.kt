@file:OptIn(ExperimentalMaterial3WindowSizeClassApi::class)

package component

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import model.LinkType
import myportfolio.composeapp.generated.resources.Res
import myportfolio.composeapp.generated.resources.android
import myportfolio.composeapp.generated.resources.android_developer
import myportfolio.composeapp.generated.resources.cmp
import myportfolio.composeapp.generated.resources.jetpack_compose
import myportfolio.composeapp.generated.resources.kmp
import myportfolio.composeapp.generated.resources.kotlin
import myportfolio.composeapp.generated.resources.my_img
import myportfolio.composeapp.generated.resources.my_name
import myportfolio.composeapp.generated.resources.view_cv
import openUrl
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import util.MY_RESUME_URL

@Composable
fun TopSection() {
    val messages = remember {
        listOf(Res.string.android, Res.string.kotlin, Res.string.jetpack_compose, Res.string.cmp, Res.string.kmp)
    }
    var currentMessageIndex by remember { mutableIntStateOf(0) }
    val currentMessage = messages[currentMessageIndex]

    LaunchedEffect(Unit) {
        while (true) {
            delay(3000)
            currentMessageIndex = (currentMessageIndex + 1) % messages.size
        }
    }
    val windowSizeClass = calculateWindowSizeClass()

    // Example of how to change the font size based on the screen width
    val fontSize = when (windowSizeClass.widthSizeClass) {
        WindowWidthSizeClass.Compact -> 48.sp
        WindowWidthSizeClass.Medium -> 90.sp
        else -> 180.sp
    }

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surface)
    ) {

        AnimatedContent(
            targetState = currentMessage,
            transitionSpec = {
                slideInVertically { height -> height } + fadeIn() togetherWith
                        slideOutVertically { height -> -height } + fadeOut()
            }, label = "currentMessageLabel",
            modifier = Modifier.matchParentSize()
        ) { targetMessage ->
            Text(
                text = stringResource(targetMessage),
                fontSize = fontSize,
                color = MaterialTheme.colorScheme.primary.copy(
                    alpha = 0.1f
                )
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
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
                        color = MaterialTheme.colorScheme.onBackground,
                        shape = CircleShape
                    ),
                painter = painterResource(Res.drawable.my_img),
                contentDescription = null
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = stringResource(Res.string.my_name),
                style = MaterialTheme.typography.headlineLarge.copy(
                    fontWeight = FontWeight.Bold
                ),
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = stringResource(Res.string.android_developer),
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontWeight = FontWeight.Bold
                ),
                color = MaterialTheme.colorScheme.primary
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
                    containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                    contentColor = MaterialTheme.colorScheme.onPrimary
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
}