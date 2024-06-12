package component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DescriptionComponent(
    modifier: Modifier = Modifier,
    description: String
) {
    Text(
        text = description,
        style = MaterialTheme.typography.bodyLarge.copy(lineHeight = 32.sp),
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 200.dp)
    )
}