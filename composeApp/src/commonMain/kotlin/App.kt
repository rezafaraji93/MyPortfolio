import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import myportfolio.composeapp.generated.resources.Res
import myportfolio.composeapp.generated.resources.my_img

@Composable
@Preview
fun App() {
    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        brush = Brush.horizontalGradient(
                            listOf(
                                Color(0XFF6a11cb),
                                Color(0XFF2575fc)
                            )
                        )
                    )
                    .padding(horizontal = 20.dp)
                    .padding(top = 100.dp, bottom = 40.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Image(
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(200.dp)
                        .border(
                            width = 4.dp,
                            color = Color.White,
                            shape = CircleShape
                        ),
                    painter = painterResource(Res.drawable.my_img),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Reza Faraji",
                    style = MaterialTheme.typography.h4,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Android Developer",
                    style = MaterialTheme.typography.h6,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(20.dp))
                Button(
                    content = {
                        Text(
                            text = "View CV"
                        )
                    },
                    onClick = {

                    },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Blue
                    ),
                    modifier = Modifier.clip(RoundedCornerShape(8.dp))
                )
            }

            Spacer(modifier = Modifier.height(40.dp))
            Text(
                text = "About Me",
                style = MaterialTheme.typography.body1.copy(
                    fontWeight = FontWeight.Bold
                ),
                color = Color(0XFF6a11cb)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Android Developer with 6 years of experience in designing, developing, testing, and maintaining cutting-edge Android apps for e-commerce and crypto exchange industries.\n" +
                        "Proficient in Kotlin and Jetpack Compose for native Android development, with expertise in Kotlin Multiplatform (KMP) for cross-platform applications.\n" +
                        "Contributed to the development of Bit24, a flagship crypto exchange app with over 500,000 users, and achieved notable improvements in efficiency and User Satisfaction.",
                style = MaterialTheme.typography.body1,
                modifier = Modifier.fillMaxWidth().padding(horizontal = 200.dp)
            )
            Spacer(modifier = Modifier.height(40.dp))
            Text(
                text = "Experiences",
                style = MaterialTheme.typography.body1.copy(
                    fontWeight = FontWeight.Bold
                ),
                color = Color(0XFF6a11cb)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(40.dp),

            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),

                    ) {

                    }
                }
            }
        }
    }
}