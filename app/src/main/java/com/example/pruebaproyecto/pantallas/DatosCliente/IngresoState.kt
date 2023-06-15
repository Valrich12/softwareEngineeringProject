package com.example.pruebaproyecto.pantallas.DatosCliente

data class IngresoState(
    val succesLogin: Boolean = false,
    val displayProgressBar: Boolean = false,
    val errorMessage: String = ""
)
