package com.example.pruebaproyecto.clases

data class AlimentoConsumed(
    val alimento: Alimento = Alimento(),
    val clientId: String = "",
    val date:String = ""
)
