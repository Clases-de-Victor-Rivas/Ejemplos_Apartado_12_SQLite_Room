package es.vrivas.ejemplosapartado12sqliteroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import es.vrivas.ejemplosapartado12sqliteroom.database.Hotel
import es.vrivas.ejemplosapartado12sqliteroom.database.SGDB

class MainActivity : AppCompatActivity() {
    var db: SGDB?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        db = SGDB.getInstance(this)
        borrar_hoteles()
        aniadir_hoteles()
    }

    fun borrar_hoteles() {
        db?.hotelDao?.clear()
    }

    fun aniadir_hoteles() {

        db?.hotelDao?.apply {
            insert( Hotel(0, "Hotel Azo", "Huelva", 4))
            insert( Hotel( 0, "Hotel Ito", "Cáceres", 3))
            insert( Hotel( 0, "Hotel Ucho", "Valladolid", 2))
        }
    }
}