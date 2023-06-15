package com.example.pruebaproyecto.Navigation

import androidx.navigation.NamedNavArgument

sealed class Destinations(
    val route: String,
    val arguments: List<NamedNavArgument>
)
{
    object Login: Destinations("login", emptyList())
    object Register: Destinations("register", emptyList())
    object Datos: Destinations("datos", emptyList())
    object MainScreen: Destinations("main", emptyList())
}
