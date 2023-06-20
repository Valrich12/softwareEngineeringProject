package com.example.pruebaproyecto.pantallas.MainNavScreen

import com.example.pruebaproyecto.clases.ClientData

data class MainNavState(
    val isLoading: Boolean = false,
    val clientData:ClientData = ClientData(),
    val error: String =""
)
