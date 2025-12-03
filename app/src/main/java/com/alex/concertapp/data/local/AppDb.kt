package com.alex.concertapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ConcertEntity::class], version = 1)
abstract class AppDb : RoomDatabase() {
    abstract fun concertDao(): ConcertDao
}
