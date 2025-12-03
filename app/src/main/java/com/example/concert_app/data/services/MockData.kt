package com.example.concert_app.data.services

import com.example.concert_app.models.toUi

object MockData {

    val mockConcerts = listOf(
        ConcertDto(
            id = "c1",
            title = "The Weeknd",
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
