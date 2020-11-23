package es.vrivas.ejemplosapartado12sqliteroom.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Hotel::class], version = 1, exportSchema = false)
abstract class SGDB : RoomDatabase() {
    abstract val hotelDao: HotelDao
    companion object {
        @Volatile
        private var INSTANCE: SGDB? = null

        fun getInstance(context: Context): SGDB? {
            synchronized(this) {
                var instance = INSTANCE
                if( instance==null ) {
                    instance = Room.databaseBuilder(
                            context.applicationContext,
                            SGDB::class.java,
                            "db_hotel")
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build()
                    INSTANCE=instance
                }
                return instance

            }
        }
    }

}