package com.example.pruebaproyecto.clases

class Recomendation(
    val clientID:String,
    var carbs: Float=0.0f,
    var proteina: Float=0.0f,
    var grasa:Float = 0.0f,
) {
     fun createRecomendation(edad:Float,sexo:String,peso:Float,estatura:Float,opcion:String){
       val  caloriasTotales = tmb(peso,estatura,edad,sexo)*1.55f
       this.proteina=peso*1.8f
       this.grasa = (caloriasTotales*0.25f)/9f
       this.carbs = (caloriasTotales-(proteina*4f)-(grasa*9f))/4f

     }

    fun tmb (peso: Float,estatura: Float,edad: Float,sexo: String):Float{
        if (sexo == "Masculino"){
            return 66 + (13.75f * peso ) + (5 * estatura) - (6.75f * edad)
        }else
        {
            return 65 + (9.56f * peso ) + (1.85f * estatura) - (4.68f * edad)
        }
    }
}