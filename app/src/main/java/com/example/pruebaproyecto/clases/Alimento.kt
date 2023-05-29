package com.example.pruebaproyecto.clases

import java.util.jar.Attributes.Name

data class Alimento(
    val nombre: String,
    val tipo:String,
    val energia: Int = 0,
    val proteina: Int = 0,
    val grasa: Int = 0
)

