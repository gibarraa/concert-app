# Final API Integration - ConcertApp

Fecha: 26 nov 2025

La app quedó integrada con la API real de conciertos:

- Endpoints usados:
  - `/api/concerts` para la lista de conciertos.
  - `/api/concerts/{id}` para el detalle.
- Se usan modelos de dominio `Concert` mapeados desde `ConcertDto`.
- Retrofit configurado con Moshi y OkHttpClient con timeouts y logging.
- Hilt configura:
  - `NetworkModule` (Retrofit, OkHttp, ConcertApi).
  - `DatabaseModule` (Room, DAOs).
  - `RepositoryModule` (ConcertRepositoryImpl).
- HomeScreen:
  - Eventos destacados y lista de próximos conciertos.
  - Imágenes con Coil.
  - Navegación a DetailsScreen.
- DetailsScreen:
  - Información del concierto, precio y botón de compra.
- Cache y favoritos:
  - Room guarda conciertos.
  - Se pueden leer favoritos desde la base local cuando falla la red.
