package com.example.pruebaproyecto.pantallas.InformacionAlimentacion

import android.graphics.fonts.FontStyle
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pruebaproyecto.clases.InfoAlimentacion
import com.example.pruebaproyecto.pantallas.InformacionAlimentacion.GramsGraphScope.gramsGraphBar
import com.example.pruebaproyecto.ui.theme.AppTheme
import java.time.DayOfWeek
import java.time.format.TextStyle
import java.util.Locale
import kotlin.math.ceil

@Composable
fun InformacionAlimentacion() {
    Column() {
        Box(
            modifier = Modifier.background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.Center
        ){
                InformacionAlimentacionGraph()
        }
    }

}

@Composable
private fun InformacionAlimentacionGraph () {
    val cantidadesBar = listOf<Float>(fakeData.cantidadRecomendada, fakeData.cantidadActual)
    val labels = listOf<String>(fakeData.tipoMacro+" Actual", fakeData.tipoMacro +" Recomendada")
    val cantidades = listOf<Int>(0,300,600,900,1200,1500,1800,2100,2400,2700,3000)
    InfoGrafica(
        grHeader ={CantidadHeader(cantidades)},
        nutrCounts = 2,
        nutrLabel = {index ->
                    graphLabel("hola")
        },
        nutrBar = {index ->
            GramsBar(
                modifier = Modifier
                    .gramsGraphBar(
                        cantidad = 300.5f
                    )
            )
        }
    )


}


@Composable

private fun graphLabel(labelText: String) {
    Text(
         text = labelText
        ,
        Modifier
            .height(24.dp)
            .padding(start = 8.dp, end = 24.dp),
        style = MaterialTheme.typography.bodyLarge,
        textAlign = TextAlign.Center
    )
}
@Composable
private fun CantidadHeader(cantidades:List<Int>){

    Row (
        modifier = Modifier.padding(bottom = 16.dp)

    ){
        cantidades.forEach{
            Text(
                text = "$it",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .width(20.dp)
                    .padding(vertical = 4.dp),
                style = MaterialTheme.typography.bodySmall.copy(
                    fontSize = 5.sp
                )
            )
        }


    }
}
@Preview
@Composable
fun InfoScreenPreview() {
    AppTheme {
            //graphLabel("Hola")
        // CantidadHeader(listOf<Int>(0,300,600,900,1200,1500,1800,2100,2400,2700,3000))
    }
}


val fakeData = InfoAlimentacion("Energia",900f,1600f)