package com.example.concert_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.toRoute
import com.example.concert_app.Screens.DetalleScreen
import com.example.concert_app.Screens.InicioScreen
import com.example.concert_app.Screens.PerfilScreen
import com.example.concert_app.ui.theme.ConcertappTheme
import com.example.concert_app.ui.theme.Detalle
import com.example.concert_app.ui.theme.Favoritos
import com.example.concert_app.ui.theme.Inicio
import com.example.concert_app.ui.theme.Perfil
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.composable
import com.example.concert_app.Screens.PurchaseConfirmedScreen
import com.example.concert_app.Screens.PurchaseScreen
import com.example.concert_app.viewmodels.DetalleViewModel
import com.example.concert_app.viewmodels.FavoritosViewModel
import com.example.concert_app.viewmodels.InicioViewModel
import com.example.concert_app.viewmodels.PerfilViewModel
import com.example.concert_app.ui.theme.Purchase
import com.example.concert_app.ui.theme.PurchaseConfirmed

// IMPORTS DE ACCOMPANIST PARA ANIMACIONES
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ConcertappTheme {
                // CAMBIO: Usamos rememberAnimatedNavController
                val navController = rememberAnimatedNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // CAMBIO: Usamos AnimatedNavHost
                    AnimatedNavHost(
                        navController = navController,
                        startDestination = Inicio.toString(),
                        modifier = Modifier.padding(innerPadding)
                    ){
                        // Definición de las transiciones para cada ruta
                        composable<Inicio>(
                            enterTransition = { slideInFromRight() },
                            exitTransition = { slideOutToLeft() },
                            popEnterTransition = { slideInFromLeft() },
                            popExitTransition = { slideOutToRight() }
                        ) {
                            val viewModel: InicioViewModel = viewModel()
                            InicioScreen(navController = navController, viewModel = viewModel)
                        }

                        composable<Detalle>(
                            enterTransition = { slideInFromRight() },
                            exitTransition = { slideOutToLeft() },
                            popEnterTransition = { slideInFromLeft() },
                            popExitTransition = { slideOutToRight() }
                        ) { backStackEntry ->
                            val args = backStackEntry.toRoute<Detalle>()
                            val viewModel: DetalleViewModel = viewModel()
                            DetalleScreen(args.id, navController = navController, viewModel = viewModel)
                        }

                        composable<Favoritos>(
                            enterTransition = { slideInFromRight() },
                            exitTransition = { slideOutToLeft() },
                            popEnterTransition = { slideInFromLeft() },
                            popExitTransition = { slideOutToRight() }
                        ) {
                            val viewModel: FavoritosViewModel = viewModel()
                            //FavoritosScreen(navController = navController, viewModel = viewModel)
                        }

                        composable<Perfil>(
                            enterTransition = { slideInFromRight() },
                            exitTransition = { slideOutToLeft() },
                            popEnterTransition = { slideInFromLeft() },
                            popExitTransition = { slideOutToRight() }
                        ) {
                            val viewModel: PerfilViewModel = viewModel()
                            PerfilScreen(navController = navController, viewModel = viewModel)
                        }

                        composable<Purchase>(
                            enterTransition = { slideInFromRight() },
                            exitTransition = { slideOutToLeft() },
                            popEnterTransition = { slideInFromLeft() },
                            popExitTransition = { slideOutToRight() }
                        ) {
                            PurchaseScreen(
                                navController = navController,
                                price = 50.0 // puedes pasar el precio real desde Detalle
                            )
                        }

                        composable<PurchaseConfirmed>(
                            enterTransition = { slideInFromRight() },
                            exitTransition = { slideOutToLeft() },
                            popEnterTransition = { slideInFromLeft() },
                            popExitTransition = { slideOutToRight() }
                        ) {
                            PurchaseConfirmedScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}

// FUNCIONES AUXILIARES PARA DEFINIR LAS TRANSICIONES
private val animationDuration = 500 // 0.5 segundos

// Transición de entrada (cuando la pantalla aparece) deslizándose desde la derecha
private fun slideInFromRight(duration: Int = animationDuration): EnterTransition {
    return slideInHorizontally(animationSpec = tween(durationMillis = duration)) { fullWidth -> fullWidth }
}

// Transición de salida (cuando la pantalla desaparece) deslizándose hacia la izquierda
private fun slideOutToLeft(duration: Int = animationDuration): ExitTransition {
    return slideOutHorizontally(animationSpec = tween(durationMillis = duration)) { fullWidth -> -fullWidth }
}

// Transición de entrada (cuando la pantalla regresa, o "pop") deslizándose desde la izquierda
private fun slideInFromLeft(duration: Int = animationDuration): EnterTransition {
    return slideInHorizontally(animationSpec = tween(durationMillis = duration)) { fullWidth -> -fullWidth }
}

// Transición de salida (cuando la pantalla anterior vuelve, o "pop") deslizándose hacia la derecha
private fun slideOutToRight(duration: Int = animationDuration): ExitTransition {
    return slideOutHorizontally(animationSpec = tween(durationMillis = duration)) { fullWidth -> fullWidth }
}