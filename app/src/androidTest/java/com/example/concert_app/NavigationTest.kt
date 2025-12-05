package com.example.concert_app

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Pruebas de UI para verificar los flujos de navegación.
 */
@RunWith(AndroidJUnit4::class)
class NavigationTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    /**
     * Prueba el flujo de navegación desde InicioScreen a DetalleScreen.
     */
    @Test
    fun navigateToDetailScreen_and_VerifyContent() {
        // PASO 1: Verificar que la pantalla de inicio se cargó correctamente.
        composeTestRule.onNodeWithText("Eventos Destacados")
            .assertExists("El título 'Eventos Destacados' debe estar presente en InicioScreen.")
            .performScrollTo()
            .assertIsDisplayed()

        // PASO 2: Intentar hacer clic en la primera tarjeta de destacados usando el TestTag.
        // CORRECCIÓN: Usamos [0] en lugar de .onFirst() para evitar errores de importación.
        val cards = composeTestRule.onAllNodes(hasTestTag("featured_card"))

        // Verificamos que al menos exista una tarjeta antes de intentar tocarla
        if (cards.fetchSemanticsNodes().isNotEmpty()) {
            cards[0].performClick()
        } else {
            throw AssertionError("No se encontraron tarjetas con el tag 'featured_card'")
        }

        // PASO 3: Verificar que la pantalla de detalle se haya cargado.
        composeTestRule.onNodeWithText("Live in Concert")
            .assertExists("El texto 'Live in Concert' debe estar presente en DetalleScreen.")
            .assertIsDisplayed()
    }

    /**
     * Prueba el flujo de retroceso desde la Pantalla de Detalle.
     */
    @Test
    fun navigateToDetailScreen_and_GoBack() {
        // 1. Navega a la pantalla de detalle (Usando [0] en lugar de onFirst)
        val cards = composeTestRule.onAllNodes(hasTestTag("featured_card"))
        if (cards.fetchSemanticsNodes().isNotEmpty()) {
            cards[0].performClick()
        }

        // 2. Verifica la presencia en la pantalla de detalle
        composeTestRule.onNodeWithText("Live in Concert")
            .assertExists()

        // 3. Simula el botón de retroceso (back button) del sistema Android.
        composeTestRule.activity.onBackPressedDispatcher.onBackPressed()

        // 4. Verifica que regresamos a la pantalla de inicio
        composeTestRule.onNodeWithText("Eventos Destacados")
            .assertExists("Debe regresar a la pantalla de Inicio.")
            .assertIsDisplayed()
    }
}