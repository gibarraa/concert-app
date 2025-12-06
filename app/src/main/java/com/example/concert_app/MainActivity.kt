package com.example.concert_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.concert_app.Screens.DetalleScreen
import com.example.concert_app.Screens.InicioScreen
import com.example.concert_app.Screens.PerfilScreen
import com.example.concert_app.Screens.PurchaseConfirmedScreen
import com.example.concert_app.Screens.PurchaseScreen
import com.example.concert_app.ui.theme.ConcertappTheme
import com.example.concert_app.ui.theme.Inicio
import com.example.concert_app.viewmodels.DetalleViewModel
import com.example.concert_app.viewmodels.FavoritosViewModel
import com.example.concert_app.viewmodels.InicioViewModel
import com.example.concert_app.viewmodels.PerfilViewModel
import com.example.concert_app.ui.theme.Detalle
import com.example.concert_app.ui.theme.Favoritos
import com.example.concert_app.ui.theme.Perfil
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
                        modifier = Modifier.padding(innerPadding),
                        // Transiciones Globales (Deslizamiento lateral tipo iPhone/Android)
                        enterTransition = {
                            slideInHorizontally(initialOffsetX = { 1000 }) + fadeIn()
                        },
                        exitTransition = {
                            slideOutHorizontally(targetOffsetX = { -1000 }) + fadeOut()
                        },
                        popEnterTransition = {
                            slideInHorizontally(initialOffsetX = { -1000 }) + fadeIn()
                        },
                        popExitTransition = {
                            slideOutHorizontally(targetOffsetX = { 1000 }) + fadeOut()
                        }
                    ) {

                        // 1. Pantalla de INICIO
                        composable<Inicio> {
                            val viewModel: InicioViewModel = viewModel()
                            InicioScreen(navController = navController, viewModel = viewModel)
                        }

                        // 2. Pantalla de DETALLE
                        composable<Detalle> { backStackEntry ->
                            val args = backStackEntry.toRoute<Detalle>()
                            val viewModel: DetalleViewModel = viewModel()
                            // Pasamos el ID recuperado de la ruta
                            DetalleScreen(
                                id = args.id,
                                navController = navController,
                                viewModel = viewModel
                            )
                        }

                        // 3. Pantalla de FAVORITOS (Pendiente o simulada)
                        composable<Favoritos> {
                            val viewModel: FavoritosViewModel = viewModel()
                            // Descomenta cuando tengas la pantalla lista
                            // FavoritosScreen(navController = navController, viewModel = viewModel)
                        }

                        // 4. Pantalla de PERFIL
                        composable<Perfil> {
                            val viewModel: PerfilViewModel = viewModel()
                            PerfilScreen(navController = navController, viewModel = viewModel)
                        }

                        // 5. Pantalla de COMPRA (Purchase)
                        composable<Purchase> { backStackEntry ->
                            // Recuperamos precio y fecha
                            val args = backStackEntry.toRoute<Purchase>()
                            PurchaseScreen(
                                navController = navController,
                                price = args.price,
                                date = args.date
                            )
                        }

                        composable<PurchaseConfirmed> { backStackEntry ->
                            val args = backStackEntry.toRoute<PurchaseConfirmed>()
                            PurchaseConfirmedScreen(
                                navController = navController,
                                date = args.date
                            )
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
