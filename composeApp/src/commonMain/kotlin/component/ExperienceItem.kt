package component

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.window.core.layout.WindowWidthSizeClass
import core.domain.Experience
import core.ui.autoHorizontalPadding
import myportfolio.composeapp.generated.resources.Res
import myportfolio.composeapp.generated.resources.read_more
import org.jetbrains.compose.resources.stringResource
import util.windowSize

@Composable
fun ExperienceItem(
    modifier: Modifier = Modifier,
    experience: Experience,
    onReadMore: (id: String) -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()

    val scale by animateFloatAsState(if (isHovered) 1.01f else 1f)
    val borderColor by animateColorAsState(
        if (isHovered) MaterialTheme.colorScheme.primary.copy(alpha = 0.5f)
        else Color.Transparent
    )

    Card(
        modifier = modifier
            .autoHorizontalPadding()
            .fillMaxWidth()
            .graphicsLayer {
                scaleX = scale
                scaleY = scale
            }
            .hoverable(interactionSource)
            .border(2.dp, borderColor, RoundedCornerShape(16.dp)),
        colors = CardDefaults.elevatedCardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 4.dp,
            hoveredElevation = 8.dp
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        when(windowSize()) {
            WindowWidthSizeClass.COMPACT -> {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp)
                ) {
                    ExperienceTitleSection(
                        logo = experience.companyLogo,
                        name = experience.companyName,
                        location = experience.location,
                        duration = experience.period,
                        title = experience.title
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    ExperienceDescription(
                        description = experience.summarizedDescription,
                        onReadMore = {
                            onReadMore(experience.id)
                        }
                    )
                    MyAsyncImage(
                        model = experience.images[0],
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 24.dp)
                            .clip(RoundedCornerShape(12.dp))
                    )
                }
            }
            else -> {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(24.dp),
                    horizontalArrangement = Arrangement.spacedBy(24.dp),
                ) {
                    Column(
                        modifier = Modifier
                            .weight(.6f)
                    ) {
                        ExperienceTitleSection(
                            logo = experience.companyLogo,
                            name = experience.companyName,
                            location = experience.location,
                            duration = experience.period,
                            title = experience.title
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        ExperienceDescription(
                            description = experience.description,
                            onReadMore = {
                                onReadMore(experience.id)
                            }
                        )
                    }
                    MyAsyncImage(
                        model = experience.images[0],
                        modifier = Modifier
                            .weight(.4f)
                            .heightIn(max = 400.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .align(Alignment.CenterVertically)
                    )
                }
            }
        }

    }
}

@Composable
private fun ExperienceTitleSection(
    modifier: Modifier = Modifier,
    logo: String?,
    title: String,
    name: String,
    location: String,
    duration: String
) {

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Box(modifier = Modifier.size(75.dp), contentAlignment = Alignment.Center) {
            MyAsyncImage(
                model = logo
            )
        }
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold
                )
            )
            Text(
                text = "$name - $location",
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                text = duration,
                style = MaterialTheme.typography.titleSmall,
                color = Color.Gray
            )
        }
    }

}

@Composable
fun ExperienceDescription(
    modifier: Modifier = Modifier,
    description: String,
    onReadMore: () -> Unit
) {

    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Box(
            modifier = Modifier
                .padding(12.dp)
                .size(8.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.onSurface)
        )
        Column(modifier = Modifier.fillMaxWidth().weight(1f)) {
            Text(
                text = description,
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = Modifier.height(16.dp))
            TextButton(
                content = {
                    Text(
                        text = stringResource(Res.string.read_more),
                        style = MaterialTheme.typography.bodyMedium,
                    )
                },
                onClick = onReadMore
            )
        }
    }

}