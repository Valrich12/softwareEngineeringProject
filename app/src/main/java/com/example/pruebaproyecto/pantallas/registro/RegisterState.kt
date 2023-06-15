package com.example.pruebaproyecto.pantallas.registro

data class RegisterState(
    val name: String = "",
    val apellido: String = "",
    val domicilio: String = "",
    val email: String = "",
    val password: String = "",
    var succesFirstCheck :Boolean=false,
    val errorMessage: String = ""
)
