package component

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import core.domain.Experience
import util.windowSize

@Composable
fun ExperienceItem(
    modifier: Modifier = Modifier,
    experience: Experience
) {

    val animatedHorizontalPadding by animateDpAsState(
        when (windowSize()) {
            WindowWidthSizeClass.Compact -> 20.dp
            WindowWidthSizeClass.Medium -> 48.dp
            else -> 200.dp
        }
    )

    Card(
        modifier = modifier
            .padding(horizontal = animatedHorizontalPadding)
            .fillMaxWidth(),
        colors = CardDefaults.elevatedCardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 12.dp,
            hoveredElevation = 16.dp
        ),
        shape = RoundedCornerShape(8.dp)
    ) {
        when(windowSize()) {
            WindowWidthSizeClass.Compact -> {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                ) {
                    ExperienceTitleSection(
                        logo = experience.companyLogo,
                        name = experience.companyName,
                        location = experience.location,
                        duration = experience.period,
                        title = experience.title
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    ExperienceDescription(description = experience.description)
                    MyAsyncImage(
                        model = experience.image,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp)
                            .clip(RoundedCornerShape(16.dp))
                    )
                }
            }
            else -> {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    Column(
                        modifier = Modifier
                            .weight(.5f)
                            .padding(20.dp)
                    ) {
                        ExperienceTitleSection(
                            logo = experience.companyLogo,
                            name = experience.companyName,
                            location = experience.location,
                            duration = experience.period,
                            title = experience.title
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        ExperienceDescription(description = experience.description)
                    }
                    MyAsyncImage(
                        model = experience.image,
                        modifier = Modifier
                            .weight(.4f)
                            .padding(20.dp)
                            .clip(RoundedCornerShape(16.dp))
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
    description: String
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
        Text(
            text = description,
            modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.bodyLarge
        )
    }

}