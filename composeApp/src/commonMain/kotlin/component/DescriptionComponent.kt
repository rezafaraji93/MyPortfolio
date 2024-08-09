
package component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import core.ui.autoHorizontalPadding

@Composable
fun DescriptionComponent(
    modifier: Modifier = Modifier,
    description: String
) {

    Text(
        text = description,
        style = MaterialTheme.typography.bodyLarge,
        modifier = modifier
            .fillMaxWidth()
            .autoHorizontalPadding()
    )
}