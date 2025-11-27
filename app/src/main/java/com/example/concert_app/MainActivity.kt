package com.example.concert_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.concert_app.Screens.DetalleScreen
//import com.example.concert_app.Screens.FavoritosScreen
import com.example.concert_app.Screens.InicioScreen
import com.example.concert_app.Screens.PerfilScreen
import com.example.concert_app.ui.theme.ConcertappTheme
import com.example.concert_app.ui.theme.Detalle
import com.example.concert_app.ui.theme.Favoritos
import com.example.concert_app.ui.theme.Inicio
import com.example.concert_app.ui.theme.Perfil
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.concert_app.Screens.PurchaseConfirmedScreen
import com.example.concert_app.Screens.PurchaseScreen
import com.example.concert_app.viewmodels.DetalleViewModel
import com.example.concert_app.viewmodels.FavoritosViewModel
import com.example.concert_app.viewmodels.InicioViewModel
import com.example.concert_app.viewmodels.PerfilViewModel
import com.example.concert_app.ui.theme.Purchase
import com.example.concert_app.ui.theme.PurchaseConfirmed

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ConcertappTheme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = Inicio,
                        modifier = Modifier.padding(innerPadding)
                    ){
                        composable<Inicio> {
                            val viewModel: InicioViewModel = viewModel()
                            InicioScreen(navController = navController, viewModel = viewModel)
                        }

                        composable<Detalle> { backStackEntry ->
                            val args = backStackEntry.toRoute<Detalle>()
                            val viewModel: DetalleViewModel = viewModel()
                            DetalleScreen(args.id, navController = navController, viewModel = viewModel)
                        }

                        composable<Favoritos> {
                            val viewModel: FavoritosViewModel = viewModel()
                            //FavoritosScreen(navController = navController, viewModel = viewModel)
                        }

                        composable<Perfil> {
                            val viewModel: PerfilViewModel = viewModel()
                            PerfilScreen(navController = navController, viewModel = viewModel)
                        }

                        composable<Purchase> {
                            PurchaseScreen(
                                navController = navController,
                                price = 50.0 // puedes pasar el precio real desde Detalle
                            )
                        }

                        composable<PurchaseConfirmed> {
                            PurchaseConfirmedScreen(navController = navController)
                        }



                    }
                }
            }
        }
    }
}


//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    ConcertappTheme {
//        InicioScreen(navController = rememberNavController(), viewModel { })
//    }
//}