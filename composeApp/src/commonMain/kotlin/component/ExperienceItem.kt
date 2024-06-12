package component

import androidx.compose.foundation.Image
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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import model.Experience
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun ExperienceItem(
    modifier: Modifier = Modifier,
    experience: Experience
) {
    Card(
        modifier = modifier
            .padding(horizontal = 200.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 12.dp,
            hoveredElevation = 16.dp
        ),
        shape = RoundedCornerShape(24.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .weight(.5f)
                    .padding(20.dp)
            ) {
                ExperienceTitleSection(experience = experience)
                Spacer(modifier = Modifier.height(16.dp))
                ExperienceDescription(description = experience.description)
            }
            Image(
                painter = painterResource(experience.image),
                contentDescription = null,
                modifier = Modifier
                    .weight(.5f)
                    .padding(20.dp)
            )
        }
    }
}

@Composable
private fun ExperienceTitleSection(
    modifier: Modifier = Modifier,
    experience: Experience
) {

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Box(modifier = Modifier.size(75.dp), contentAlignment = Alignment.Center) {
            Image(
                painter = painterResource(experience.logo),
                contentDescription = null
            )
        }
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = stringResource(experience.title),
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = stringResource(experience.companyNameAndLocation),
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                text = stringResource(experience.duration),
                style = MaterialTheme.typography.titleSmall,
                color = Color.Gray
            )
        }
    }

}

@Composable
fun ExperienceDescription(
    modifier: Modifier = Modifier,
    description: StringResource
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
                .background(Color.Black)
        )
        Text(
            text = stringResource(description),
            modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.bodyLarge
        )
    }

}