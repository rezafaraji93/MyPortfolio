package home.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import core.domain.Project
import core.ui.autoHorizontalPadding
import util.windowSize

@Composable
fun ProjectsSection(
    modifier: Modifier = Modifier,
    projects: List<Project>
) {

    when(windowSize()) {
        WindowWidthSizeClass.Expanded -> {
            Row (
                modifier = modifier
                    .fillMaxWidth()
                    .autoHorizontalPadding(),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                projects.forEach { project ->
                    ProjectItem(
                        modifier = Modifier.weight(1f),
                        project = project
                    )
                }
            }
        }
        else -> {
            Column(
                modifier = modifier.fillMaxWidth().autoHorizontalPadding(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                projects.forEach { project ->
                    ProjectItem(
                        modifier = Modifier.fillMaxWidth(),
                        project = project
                    )
                }
            }
        }
    }


}