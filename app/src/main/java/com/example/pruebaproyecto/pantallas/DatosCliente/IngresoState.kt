package com.example.pruebaproyecto.pantallas.DatosCliente

data class IngresoState(
    val succesRegister: Boolean = false,
    val displayProgressBar: Boolean = false,
    val errorMessage: String = ""
)
