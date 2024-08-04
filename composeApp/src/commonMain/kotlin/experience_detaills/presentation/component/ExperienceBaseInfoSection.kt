package experience_detaills.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import component.MyAsyncImage
import core.domain.Experience

@Composable
fun ExperienceBaseInfoSection(
    modifier: Modifier = Modifier,
    experience: Experience?
) {



    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        MyAsyncImage(
            modifier = Modifier.width(120.dp),
            model = experience?.companyLogo
        )
        Text(
            text = experience?.companyName ?: "",
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            text = experience?.location ?: ""
        )
        Text(
            text = experience?.period ?: ""
        )

        Text(
            text = experience?.description ?: ""
        )

    }


}