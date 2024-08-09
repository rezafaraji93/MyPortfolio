package home.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import component.MyAsyncImage
import core.domain.Project
import myportfolio.composeapp.generated.resources.Res
import myportfolio.composeapp.generated.resources.github_link
import openUrl
import org.jetbrains.compose.resources.stringResource

@Composable
fun ProjectItem(
    modifier: Modifier = Modifier,
    project: Project
) {

    Card(
        modifier = modifier,
        colors = CardDefaults.elevatedCardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 12.dp,
            hoveredElevation = 16.dp
        ),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth().padding(20.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(
                text = project.title,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold
                )
            )
            Text(
                text = project.description,
                style = MaterialTheme.typography.bodyLarge
            )
            MyAsyncImage(
                model = project.imageUrl
            )
            TextButton(
                content = {
                    Text(
                        text = stringResource(Res.string.github_link),
                        style = MaterialTheme.typography.bodyMedium,
                    )
                },
                onClick = {
                    openUrl(project.link)
                }
            )
        }
    }



}