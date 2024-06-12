package component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign

@Composable
fun TitleComponent(
    modifier: Modifier = Modifier,
    title: String
) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleMedium,
        color = Color(0XFF6a11cb),
        textAlign = TextAlign.Center,
        modifier = modifier.fillMaxWidth()
    )
}