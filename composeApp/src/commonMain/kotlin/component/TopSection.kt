package component

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.window.core.layout.WindowWidthSizeClass
import model.LinkType
import myportfolio.composeapp.generated.resources.Res
import myportfolio.composeapp.generated.resources.view_cv
import openUrl
import org.jetbrains.compose.resources.stringResource
import util.windowSize

@Composable
fun TopSection(
    modifier: Modifier = Modifier,
    profilePicture: String?,
    title: String,
    name: String,
    cvUrl: String?,
    githubUrl: String?,
    linkedInUrl: String?
) {
    val windowSize = windowSize()
    
    val infiniteTransition = rememberInfiniteTransition(label = "backgroundMovement")
    
    val blob1OffsetX by infiniteTransition.animateFloat(
        initialValue = -100f,
        targetValue = 100f,
        animationSpec = infiniteRepeatable(
            animation = tween(7500, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ), label = "blob1OffsetX"
    )
    
    val blob1OffsetY by infiniteTransition.animateFloat(
        initialValue = -50f,
        targetValue = 50f,
        animationSpec = infiniteRepeatable(
            animation = tween(10000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ), label = "blob1OffsetY"
    )
    
    val blob2OffsetX by infiniteTransition.animateFloat(
        initialValue = 100f,
        targetValue = -100f,
        animationSpec = infiniteRepeatable(
            animation = tween(9000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ), label = "blob2OffsetX"
    )
    
    val blob2OffsetY by infiniteTransition.animateFloat(
        initialValue = 50f,
        targetValue = -50f,
        animationSpec = infiniteRepeatable(
            animation = tween(11000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ), label = "blob2OffsetY"
    )

    BoxWithConstraints(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
    ) {
        // --- Modern Mesh Gradient Background Layer ---
        Box(
            modifier = Modifier
                .matchParentSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.2f),
                            MaterialTheme.colorScheme.background
                        )
                    )
                )
        )

        // Decorative Gradient Blobs for "Mesh" effect
        Box(
            modifier = Modifier
                .size(300.dp)
                .offset(x = blob1OffsetX.dp, y = blob1OffsetY.dp)
                .blur(100.dp)
                .background(
                    Brush.radialGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.primary.copy(alpha = 0.15f),
                            Color.Transparent
                        )
                    )
                )
        )

        Box(
            modifier = Modifier
                .size(400.dp)
                .align(Alignment.BottomEnd)
                .offset(x = blob2OffsetX.dp, y = blob2OffsetY.dp)
                .blur(120.dp)
                .background(
                    Brush.radialGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.secondary.copy(alpha = 0.1f),
                            Color.Transparent
                        )
                    )
                )
        )

        // --- Main Content Layer ---
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(top = if (windowSize == WindowWidthSizeClass.COMPACT) 80.dp else 120.dp, bottom = 80.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Glassmorphism Container for Profile
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(32.dp))
                    .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.4f))
                    .border(
                        width = 1.dp,
                        brush = Brush.linearGradient(
                            listOf(
                                MaterialTheme.colorScheme.primary.copy(alpha = 0.2f),
                                Color.Transparent,
                                MaterialTheme.colorScheme.secondary.copy(alpha = 0.1f)
                            )
                        ),
                        shape = RoundedCornerShape(32.dp)
                    )
                    .padding(if (windowSize == WindowWidthSizeClass.COMPACT) 24.dp else 48.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    MyAsyncImage(
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(if (windowSize == WindowWidthSizeClass.COMPACT) 160.dp else 220.dp)
                            .border(
                                width = 4.dp,
                                color = MaterialTheme.colorScheme.background,
                                shape = CircleShape
                            ),
                        model = profilePicture,
                    )
                    Spacer(modifier = Modifier.height(32.dp))

                    Text(
                        text = name,
                        style = MaterialTheme.typography.headlineLarge.copy(
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = if (windowSize == WindowWidthSizeClass.COMPACT) 36.sp else 64.sp,
                            letterSpacing = (-1).sp
                        ),
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = title,
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.SemiBold,
                            fontSize = if (windowSize == WindowWidthSizeClass.COMPACT) 20.sp else 28.sp,
                            color = MaterialTheme.colorScheme.primary
                        )
                    )
                    Spacer(modifier = Modifier.height(40.dp))
                    Button(
                        content = {
                            Text(
                                text = stringResource(Res.string.view_cv),
                                style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Bold)
                            )
                        },
                        onClick = {
                            openUrl(cvUrl)
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary,
                            contentColor = MaterialTheme.colorScheme.onPrimary
                        ),
                        modifier = Modifier.height(52.dp).padding(horizontal = 16.dp),
                        shape = RoundedCornerShape(16.dp),
                        elevation = ButtonDefaults.buttonElevation(defaultElevation = 8.dp)
                    )
                    Spacer(Modifier.height(40.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(32.dp)
                    ) {
                        LinkIcon(
                            linkType = LinkType.LinkedIn(url = linkedInUrl)
                        )
                        LinkIcon(
                            linkType = LinkType.Github(url = githubUrl)
                        )
                    }
                }
            }
        }
    }
}
