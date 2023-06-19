package com.example.pruebaproyecto.clases


data class ClientData(
    val clientId: String,
    val edad: Float,
    val estatura:Float,
    val peso: Float,
    val sexo:String,
    val opcion:String,
    val nombre: String,
    val apellido: String,
    var carbs: Float,
    var grasas:Float,
    var proteinas: Float,
)