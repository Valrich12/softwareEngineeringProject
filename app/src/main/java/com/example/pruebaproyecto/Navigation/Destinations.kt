package com.example.pruebaproyecto.Navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Destinations(
    val route: String,
    val arguments: List<NamedNavArgument>
)
{
    object Login: Destinations("login", emptyList())
    object Register: Destinations("register", emptyList())
    object Datos: Destinations("datos", emptyList())
    object MainScreen: Destinations(
        "main",
        listOf(
            navArgument("name"){type = NavType.StringType},
            navArgument("apellido"){type = NavType.StringType},
            navArgument("domicilio"){type = NavType.StringType},
            navArgument("email"){type = NavType.StringType},
            navArgument("password"){type = NavType.StringType},
        )
    )
}
