@file:OptIn(ExperimentalLayoutApi::class)

package experience_detaills.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import component.MyAsyncImage
import myportfolio.composeapp.generated.resources.Res
import myportfolio.composeapp.generated.resources.gallery

@Composable
fun ExperienceImageGallery(
    modifier: Modifier = Modifier,
    images: List<String>?
) {

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        ExperienceSectionsTitle(title = Res.string.gallery)
        FlowRow(
            modifier = Modifier.fillMaxWidth().padding(vertical = 24.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            images?.forEach {
                MyAsyncImage(
                    modifier = Modifier.width(350.dp).clip(RoundedCornerShape(16.dp)),
                    model = it
                )
            }
        }
    }

}