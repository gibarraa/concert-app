# Integration Test - ConcertApp

Fecha: 25 nov 2025

Se probó el flujo completo API → App:

- Llamadas reales a `https://concert-api-80uo.onrender.com/api/concerts`.
- Home muestra lista de conciertos desde la API.
- Pantalla de detalles consume el concierto individual.
- Manejo de estados:
  - Loading con `CircularProgressIndicator`.
  - Error con botón de "Reintentar".
  - Estado vacío cuando no hay conciertos.
- Cache local con Room: se muestran últimos conciertos guardados si falla la red.
