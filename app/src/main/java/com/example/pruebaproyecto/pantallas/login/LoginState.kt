package com.example.pruebaproyecto.pantallas.login

data class LoginState(
    val succesLogin: Boolean = false,
    val displayProgressBar: Boolean = false,
    val errorMessage: String = ""
)
