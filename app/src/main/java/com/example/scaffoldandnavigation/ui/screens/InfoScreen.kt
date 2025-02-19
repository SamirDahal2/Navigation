
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.scaffoldandnavigation.viewmodel.MainViewModel

@Composable
fun InfoScreen(navController: NavController, viewModel: MainViewModel) {
    viewModel.title("Info Screen")  // Set the title using ViewModel

    Scaffold(
        topBar = { ScreenTopBar(viewModel, navController) }
    ) { innerPadding ->
        Text(text = "Info Screen", modifier = Modifier.padding(innerPadding))
    }
}
