package com.example.final_tp.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "movie_table")
data class Movies (
  //esta va a ser la tabla que vamos a usar en la base de datos
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "movie")
    val movie: String,
    @ColumnInfo(name = "genre")
    val genre: String,
    @ColumnInfo(name = "duration")
    val duration:Int
  ): Serializable