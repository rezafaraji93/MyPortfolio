package experience_detaills.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import myportfolio.composeapp.generated.resources.Res
import myportfolio.composeapp.generated.resources.about_company
import org.jetbrains.compose.resources.stringResource

@Composable
fun AboutCompanySection(
    modifier: Modifier = Modifier,
    companyDescription: String
) {

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start
    ) {
        ExperienceSectionsTitle(title = Res.string.about_company)
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = companyDescription,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onBackground
        )
    }

}