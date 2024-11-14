package com.example.final_tp.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

//esta va a ser la tabla que vamos a usar en la base de datos
@Entity(tableName = "user_table")
data class User (
  @PrimaryKey(autoGenerate = true)
  val id: Int,
  @ColumnInfo(name = "nombre")
  val name: String,
  @ColumnInfo(name = "apellido")
  val lastName: String,
  @ColumnInfo(name = "edad")
  val age:Int
  ): Serializable