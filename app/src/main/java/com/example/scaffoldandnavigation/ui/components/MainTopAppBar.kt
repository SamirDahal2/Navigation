import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import com.example.scaffoldandnavigation.viewmodel.MainViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopAppBar(viewModel: MainViewModel, navController: NavController) {
    val title by viewModel.title.collectAsState()

    var expanded by remember { mutableStateOf(false) }

    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary
        ),
        title = { Text(text = title) },  // Now using ViewModel's title
        navigationIcon = {
            IconButton(onClick = { /* Open menu */ }) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "Open menu")
            }
        },
        actions = {
            IconButton(onClick = { expanded = !expanded }) {
                Icon(imageVector = Icons.Filled.MoreVert, contentDescription = "Open submenu")
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                DropdownMenuItem(
                    text = { Text("Info") },
                    onClick = {
                        viewModel.title("Info Screen")  // Update title when navigating
                        navController.navigate("info")
                    }
                )
                DropdownMenuItem(
                    text = { Text("Settings") },
                    onClick = {
                        viewModel.title("Settings Screen")  // Update title when navigating
                        navController.navigate("settings")
                    }
                )
            }
        }
    )
}