package component

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import core.domain.BaseState
import myportfolio.composeapp.generated.resources.Res
import myportfolio.composeapp.generated.resources.how_is_it_made
import myportfolio.composeapp.generated.resources.retry
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun <T> BaseScreen(
    modifier: Modifier = Modifier,
    topBar: @Composable () -> Unit = {},
    content: @Composable (state: BaseState.Success<T>) -> Unit = {},
    onRetry: () -> Unit,
    state: BaseState<T>
) {

    val windowSizeClass = calculateWindowSizeClass()
    val animatedHorizontalPadding by animateDpAsState(
        when (windowSizeClass.widthSizeClass) {
            WindowWidthSizeClass.Compact -> 20.dp
            WindowWidthSizeClass.Medium -> 48.dp
            else -> 200.dp
        }
    )

    Scaffold(
        modifier = modifier
            .fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            topBar()
        },
        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.surfaceContainer)
                    .padding(horizontal = 20.dp, vertical = 16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(Res.string.how_is_it_made),
                    style = MaterialTheme.typography.labelSmall.copy(
                        fontSize = 12.sp
                    )
                )
            }
        },
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(horizontal = animatedHorizontalPadding)
            ) {
                when (state) {
                    is BaseState.Error -> {
                        Column(
                            modifier = Modifier.align(Alignment.Center),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            Text(
                                text = state.message ?: "",
                                style = MaterialTheme.typography.bodyMedium
                            )
                            ElevatedButton(
                                content = {
                                    Text(
                                        text = stringResource(Res.string.retry)
                                    )
                                },
                                onClick = onRetry
                            )
                        }
                    }

                    is BaseState.Loading -> {
                        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                    }

                    is BaseState.Success -> content(state)
                }
            }
        }
    )

}