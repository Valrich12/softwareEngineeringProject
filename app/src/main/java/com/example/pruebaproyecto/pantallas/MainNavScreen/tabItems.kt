package com.example.pruebaproyecto.pantallas.MainNavScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.pruebaproyecto.pantallas.DatosAlimentacion.IngresoAlimentos
import com.example.pruebaproyecto.pantallas.InformacionAlimentacion.InformacionAlimentacion
import com.example.pruebaproyecto.pantallas.Recomendaciones.Recomendaciones


typealias ComposableFun = @Composable () -> Unit
sealed class TabItem(var title:String,var screen: ComposableFun){
    object Recomendaciones : TabItem("Recomendaciones", {
            Recomendaciones()
    })
    object IngresoAlimentos : TabItem("Ingreso de Alimentos", {
            IngresoAlimentos()
    })
    object Graficas : TabItem("Seguimiento", {
            InformacionAlimentacion()

    })

}
