package com.example.pruebaproyecto.pantallas.MainNavScreen

import com.example.pruebaproyecto.Repositories.ResultListAlimentos
import com.example.pruebaproyecto.clases.Alimento
import com.example.pruebaproyecto.clases.ClientData

data class MainNavState(
    val isLoading: Boolean = false,
    val clientData:ClientData = ClientData(),
    val listAlimentos: List<Alimento> = emptyList(),
    val error: String =""
)
