package experience_detaills.presentation.component

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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import myportfolio.composeapp.generated.resources.Res
import myportfolio.composeapp.generated.resources.my_responsibilities

@Composable
fun ExperienceResponsibilitiesSection(
    modifier: Modifier = Modifier, responsibilities: List<String>?
) {

    Column(modifier = modifier.fillMaxWidth()) {
        ExperienceSectionsTitle(title = Res.string.my_responsibilities)
        Spacer(modifier = Modifier.height(16.dp))
        responsibilities?.forEach {
            ResponsibilityItem(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp),
                responsibility = it
            )
        }
    }

}

@Composable
private fun ResponsibilityItem(
    modifier: Modifier = Modifier, responsibility: String
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Box(
            modifier = Modifier.padding(12.dp).size(8.dp).clip(CircleShape)
                .background(MaterialTheme.colorScheme.onSurface)
        )
        Text(
            text = responsibility, style = MaterialTheme.typography.bodyLarge, modifier = Modifier.weight(1f)
        )
    }
}