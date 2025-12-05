package com.example.concert_app.data.services

import com.example.concert_app.models.toUi

object MockData {

    val mockConcerts = listOf(
        ConcertDto(
            id = "c1",
            title = "The Weeknd",
            dateUtc = "2023-08-25T02:00:00Z",
            timeLocal = "21:00",
            genre = "Pop",
            imageUrl = "https://offloadmedia.feverup.com/guadalajarasecreta.com/wp-content/uploads/2023/03/07033324/Untitled-1200-×-800-px-11-1024x683.png", // ⭐ FUNCIONA
            priceMin = 85,
            priceMax = 250,
            currency = "USD",
            isSoldOut = false,
            artistId = "a1",
            artistName = "The Weeknd",
            venueId = "v1",
            city = "Los Angeles",
            country = "USA",
            createdAt = "",
            updatedAt = ""
            artist = "The Weeknd",
            date = "2023-08-25T02:00:00Z",
            venue = "Los Angeles, USA",
            price = 85,
            imageUrl = "https://offloadmedia.feverup.com/guadalajarasecreta.com/wp-content/uploads/2023/03/07033324/Untitled-1200-×-800-px-11-1024x683.png",
            description = "Concierto de The Weeknd en Los Angeles."
        ),
        ConcertDto(
            id = "c2",
            title = "Billie Eilish",
            dateUtc = "2023-08-30T02:00:00Z",
            timeLocal = "20:30",
            genre = "Indie Pop",
            imageUrl = "https://media.revistagq.com/photos/608a6889235a5910299c8f00/16:9/w_1535,h_863,c_limit/Billie%20Eilish_cover%20album%20Happier%20Than%20Ever.jpg", // ⭐ FUNCIONA
            priceMin = 40,
            priceMax = 180,
            currency = "USD",
            isSoldOut = false,
            artistId = "a2",
            artistName = "Billie Eilish",
            venueId = "v2",
            city = "New York",
            country = "USA",
            createdAt = "",
            updatedAt = ""
            artist = "Billie Eilish",
            date = "2023-08-30T02:00:00Z",
            venue = "New York, USA",
            price = 40,
            imageUrl = "https://media.revistagq.com/photos/608a6889235a5910299c8f00/16:9/w_1535,h_863,c_limit/Billie%20Eilish_cover%20album%20Happier%20Than%20Ever.jpg",
            description = "Concierto de Billie Eilish en New York."
        ),
        ConcertDto(
            id = "c3",
            title = "Olivia Rodrigo",
            dateUtc = "2023-09-10T02:00:00Z",
            timeLocal = "19:30",
            genre = "Pop",
            imageUrl = "https://alafuga.com.mx/wp-content/uploads/2024/11/466756098_999566952215701_7864512927852471147_n.jpg", // ⭐ FUNCIONA
            priceMin = 50,
            priceMax = 200,
            currency = "USD",
            isSoldOut = false,
            artistId = "a3",
            artistName = "Olivia Rodrigo",
            venueId = "v3",
            city = "Chicago",
            country = "USA",
            createdAt = "",
            updatedAt = ""
            artist = "Olivia Rodrigo",
            date = "2023-09-10T02:00:00Z",
            venue = "Chicago, USA",
            price = 50,
            imageUrl = "https://alafuga.com.mx/wp-content/uploads/2024/11/466756098_999566952215701_7864512927852471147_n.jpg",
            description = "Concierto de Olivia Rodrigo en Chicago."
        ),
        ConcertDto(
            id = "c4",
            title = "Harry Styles",
            dateUtc = "2023-09-20T02:00:00Z",
            timeLocal = "20:00",
            genre = "Pop Rock",
            imageUrl = "https://media.glamour.mx/photos/61e8474ca94d3e47feca5178/3:2/w_2997,h_1998,c_limit/harry-styles-en-mexico-concierto.jpg", // ⭐ FUNCIONA
            priceMin = 70,
            priceMax = 210,
            currency = "USD",
            isSoldOut = false,
            artistId = "a4",
            artistName = "Harry Styles",
            venueId = "v4",
            city = "London",
            country = "UK",
            createdAt = "",
            updatedAt = ""
            artist = "Harry Styles",
            date = "2023-09-20T02:00:00Z",
            venue = "London, UK",
            price = 70,
            imageUrl = "https://media.glamour.mx/photos/61e8474ca94d3e47feca5178/3:2/w_2997,h_1998,c_limit/harry-styles-en-mexico-concierto.jpg",
            description = "Concierto de Harry Styles en London."
        ),
        ConcertDto(
            id = "c5",
            title = "Foo Fighters",
            dateUtc = "2023-10-12T02:00:00Z",
            timeLocal = "22:00",
            genre = "Rock",
            imageUrl = "https://www.rocktotal.com/wp-content/uploads/2015/04/foo-fighters.jpg", // ⭐ FUNCIONA
            priceMin = 60,
            priceMax = 160,
            currency = "USD",
            isSoldOut = false,
            artistId = "a5",
            artistName = "Foo Fighters",
            venueId = "v5",
            city = "Seattle",
            country = "USA",
            createdAt = "",
            updatedAt = ""
        ),

        // ⭐ Extras para tener 10 elementos
        ConcertDto(
            id = "c6",
            title = "Shawn Mendes",
            dateUtc = "2023-10-18T02:00:00Z",
            timeLocal = "21:30",
            genre = "Pop",
            imageUrl = "https://www.telemadrid.es/2025/05/29/noticias/cultura/_2783731702_49493410_1300x731.jpg", // ⭐ FUNCIONA
            priceMin = 45,
            priceMax = 140,
            currency = "USD",
            isSoldOut = false,
            artistId = "a6",
            artistName = "Shawn Mendes",
            venueId = "v6",
            city = "Toronto",
            country = "CA",
            createdAt = "",
            updatedAt = ""
            artist = "Foo Fighters",
            date = "2023-10-12T02:00:00Z",
            venue = "Seattle, USA",
            price = 60,
            imageUrl = "https://www.rocktotal.com/wp-content/uploads/2015/04/foo-fighters.jpg",
            description = "Concierto de Foo Fighters en Seattle."
        ),
        ConcertDto(
            id = "c6",
            title = "Shawn Mendes",
            artist = "Shawn Mendes",
            date = "2023-10-18T02:00:00Z",
            venue = "Toronto, CA",
            price = 45,
            imageUrl = "https://www.telemadrid.es/2025/05/29/noticias/cultura/_2783731702_49493410_1300x731.jpg",
            description = "Concierto de Shawn Mendes en Toronto."
        ),
        ConcertDto(
            id = "c7",
            title = "Blackpink",
            dateUtc = "2023-11-03T02:00:00Z",
            timeLocal = "20:00",
            genre = "K-Pop",
            imageUrl = "https://static.styletc.com/images/cover/43/199843/md-9dd85c0e3691a033e06c534ed42c269a.png", // ⭐ FUNCIONA
            priceMin = 90,
            priceMax = 300,
            currency = "USD",
            isSoldOut = false,
            artistId = "a7",
            artistName = "Blackpink",
            venueId = "v7",
            city = "Seoul",
            country = "KR",
            createdAt = "",
            updatedAt = ""
            artist = "Blackpink",
            date = "2023-11-03T02:00:00Z",
            venue = "Seoul, KR",
            price = 90,
            imageUrl = "https://static.styletc.com/images/cover/43/199843/md-9dd85c0e3691a033e06c534ed42c269a.png",
            description = "Concierto de Blackpink en Seoul."
        ),
        ConcertDto(
            id = "c8",
            title = "Taylor Swift",
            dateUtc = "2023-11-21T02:00:00Z",
            timeLocal = "19:00",
            genre = "Pop",
            imageUrl = "https://cdn-3.expansion.mx/dims4/default/da6ac7b/2147483647/strip/true/crop/3000x2000+0+0/resize/1200x800!/format/webp/quality/60/?url=https%3A%2F%2Fcdn-3.expansion.mx%2Ff6%2Fdf%2Fcc497c20407cb4c51c268572913a%2Ftaylor-swift-super-bowl.jpg", // ⭐ FUNCIONA
            priceMin = 120,
            priceMax = 800,
            currency = "USD",
            isSoldOut = false,
            artistId = "a8",
            artistName = "Taylor Swift",
            venueId = "v8",
            city = "Tokyo",
            country = "JP",
            createdAt = "",
            updatedAt = ""
            artist = "Taylor Swift",
            date = "2023-11-21T02:00:00Z",
            venue = "Tokyo, JP",
            price = 120,
            imageUrl = "https://cdn-3.expansion.mx/dims4/default/da6ac7b/2147483647/strip/true/crop/3000x2000+0+0/resize/1200x800!/format/webp/quality/60/?url=https%3A%2F%2Fcdn-3.expansion.mx%2Ff6%2Fdf%2Fcc497c20407cb4c51c268572913a%2Ftaylor-swift-super-bowl.jpg",
            description = "Concierto de Taylor Swift en Tokyo."
        ),
        ConcertDto(
            id = "c9",
            title = "Travis Scott",
            dateUtc = "2023-12-01T02:00:00Z",
            timeLocal = "22:30",
            genre = "Hip Hop",
            imageUrl = "https://pagesix.com/wp-content/uploads/sites/3/2022/04/Travis-Scott-concert_02.jpg?quality=75&strip=all&w=1200", // ⭐ FUNCIONA
            priceMin = 70,
            priceMax = 220,
            currency = "USD",
            isSoldOut = false,
            artistId = "a9",
            artistName = "Travis Scott",
            venueId = "v9",
            city = "Houston",
            country = "USA",
            createdAt = "",
            updatedAt = ""
            artist = "Travis Scott",
            date = "2023-12-01T02:00:00Z",
            venue = "Houston, USA",
            price = 70,
            imageUrl = "https://pagesix.com/wp-content/uploads/sites/3/2022/04/Travis-Scott-concert_02.jpg?quality=75&strip=all&w=1200",
            description = "Concierto de Travis Scott en Houston."
        ),
        ConcertDto(
            id = "c10",
            title = "Dua Lipa",
            dateUtc = "2023-12-15T02:00:00Z",
            timeLocal = "20:00",
            genre = "Pop",
            imageUrl = "https://cdn.amxinfra.com/unotv/images/2025/11/dua-lipa-llega-a-cdmx-con-gira-y-con-su-taqueria-oficial-103316-1024x576.jpg", // ⭐ FUNCIONA
            priceMin = 80,
            priceMax = 260,
            currency = "USD",
            isSoldOut = false,
            artistId = "a10",
            artistName = "Dua Lipa",
            venueId = "v10",
            city = "Paris",
            country = "FR",
            createdAt = "",
            updatedAt = ""
            artist = "Dua Lipa",
            date = "2023-12-15T02:00:00Z",
            venue = "Paris, FR",
            price = 80,
            imageUrl = "https://cdn.amxinfra.com/unotv/images/2025/11/dua-lipa-llega-a-cdmx-con-gira-y-con-su-taqueria-oficial-103316-1024x576.jpg",
            description = "Concierto de Dua Lipa en Paris."
        )
    )

    val mockConcertsUi = mockConcerts.map { it.toUi() }

}
