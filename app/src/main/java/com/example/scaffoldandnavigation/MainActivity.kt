package com.example.scaffoldandnavigation

import InfoScreen
import MainScreen
import SettingsScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.scaffoldandnavigation.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val viewModel: MainViewModel = viewModel()
                    ScaffoldApp(modifier = Modifier.padding(innerPadding), viewModel)
                }
            }
        }
    }
}

@Composable
fun ScaffoldApp(modifier: Modifier, viewModel: MainViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable(route = "home") {
            viewModel.title("Home Screen")
            MainScreen(navController, viewModel)
        }
        composable(route = "info") {
            viewModel.title("Info Screen")
            InfoScreen(navController, viewModel)
        }
        composable(route = "settings") {
            viewModel.title("Settings Screen")
            SettingsScreen(navController, viewModel)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MaterialTheme {
        ScaffoldApp(Modifier.fillMaxSize(), MainViewModel())
    }
}