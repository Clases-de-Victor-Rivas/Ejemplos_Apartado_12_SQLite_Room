package es.vrivas.ejemplosapartado12sqliteroom.database

import androidx.room.*

@Dao
interface HotelDao {
    @Insert
    fun insert(hotel: Hotel)

    @Update
    fun update(hotel: Hotel)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateHoteles(hoteles: Array<Hotel>)

    @Delete
    fun delete(hoteles: Array<Hotel>)

    @Query("SELECT * from tabla_hotel WHERE id = :id")
    fun get( id: Long): Hotel?

    @Query("DELETE FROM tabla_hotel")
    fun clear()

    @Query("SELECT * FROM tabla_hotel ORDER BY id DESC")
    fun getAll(): List<Hotel>
}