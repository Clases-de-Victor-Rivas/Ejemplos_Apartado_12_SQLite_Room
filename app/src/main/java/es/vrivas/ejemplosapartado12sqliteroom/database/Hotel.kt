package es.vrivas.ejemplosapartado12sqliteroom.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabla_hotel")
data class Hotel(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,

    @ColumnInfo(name = "nombre")
    val nombre: String = "",

    @ColumnInfo(name = "localidad")
    var localidad: String = "",

    @ColumnInfo(name = "estrellas")
    var estrellas: Long = 0L
) {
    override fun toString(): String {
        return "- $nombre (${("*****" as String).substring(5-estrellas.toInt())}) - $localidad"
    }
}
