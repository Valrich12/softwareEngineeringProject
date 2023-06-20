package com.example.pruebaproyecto.clases


data class ClientData(
    val clientId: String="",
    val edad: Float=0.0f,
    val estatura:Float=0.0f,
    val peso: Float=0.0f,
    val sexo:String="",
    val opcion:String="",
    val nombre: String="",
    val apellido: String="",
    var carbs: Float=0.0f,
    var grasas:Float=0.0f,
    var proteinas: Float=0.0f
)