package com.example.pruebaproyecto.pantallas.InformacionAlimentacion

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.pruebaproyecto.clases.InfoAlimentacion
import com.example.pruebaproyecto.ui.theme.AppTheme


@Composable
fun InformacionAlimentacion() {

    Box(
        modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background)) {
        Column(Modifier.fillMaxWidth()) {
            Box(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.background)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                ConstraintLayout() {
                    val(graphProt,graphEner,graphGrasa) = createRefs()
                    Box(
                        modifier = Modifier
                            .constrainAs(graphEner){
                                top.linkTo(parent.top)
                            }
                    ) {
                        InformacionEnergiaGraph()
                    }
                    Box(
                        modifier = Modifier
                            .constrainAs(graphProt){
                                top.linkTo(graphEner.bottom, margin = 20.dp)
                            }) {
                        InformacionProteinaGraph()
                    }

                }

            }
        }
    }
}

@Composable
private fun InformacionEnergiaGraph (
    modifier: Modifier = Modifier
) {
    val cantidadesBar = listOf<Float>(fakeDataEnergia.cantidadActual, fakeDataEnergia.cantidadRecomendada)
    val labels = listOf<String>(fakeDataEnergia.tipoMacro+" Actual", fakeDataEnergia.tipoMacro +" Recomendada")
    val cantidades = listOf<Int>(300,600,900,1200,1500,1800,2100,2400,2700,3000)
    InfoGrafica(
        grHeader ={CantidadHeader(cantidades)},
        nutrCounts = 2,
        nutrLabel = {index ->
                    graphLabel(labels[index])
        },
        nutrBar = {index ->
            GramsBar(
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .gramsGraphBar(
                        cantidad = cantidadesBar[index] / 3000f
                    )
            )
        }
    )


}

@Composable
private fun InformacionProteinaGraph (
        modifier: Modifier=Modifier
) {
    val cantidadesBar = listOf<Float>(fakeDataProteina.cantidadActual, fakeDataProteina.cantidadRecomendada)
    val labels = listOf<String>(fakeDataProteina.tipoMacro+" Actual", fakeDataProteina.tipoMacro +" Recomendada")
    val cantidades = listOf<Int>(10,20,30,40,50,60,70,80,90,100)
    InfoGrafica(
        grHeader ={CantidadHeader(cantidades)},
        nutrCounts = 2,
        nutrLabel = {index ->
            graphLabel(labels[index])
        },
        nutrBar = {index ->
            GramsBar(
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .gramsGraphBar(
                        cantidad = cantidadesBar[index] / 100f
                    )
            )
        }
    )


}


@Composable

private fun graphLabel(labelText: String) {
    Box(modifier = Modifier
        .width(70.dp)
        .padding(end = 3.dp)){
        Text(
            text = labelText
            ,
            Modifier
                .height(30.dp),
            style = MaterialTheme.typography.bodySmall.copy(
                fontSize = 10.sp
            ),

        )
    }

}
@Composable
private fun CantidadHeader(cantidades:List<Int>){

    Row (
        modifier = Modifier.padding(bottom = 5.dp),
        verticalAlignment = Alignment.CenterVertically

    ){
        cantidades.forEach{
            Text(
                text = "$it",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .width(30.dp)
                    .padding(vertical = 8.dp),
                style = MaterialTheme.typography.bodySmall.copy(fontSize = 11.sp
                )
            )
            Spacer(modifier = Modifier.height(16.dp).width(1.dp).background(Color.Black))
        }


    }
}
@Preview
@Composable
fun InfoScreenPreview() {
    AppTheme {
            //graphLabel("Hola")
        // CantidadHeader(listOf<Int>(0,300,600,900,1200,1500,1800,2100,2400,2700,3000))
        InformacionAlimentacion()
    }
}


val fakeDataEnergia = InfoAlimentacion("Energia",900f,1600f)

val fakeDataProteina = InfoAlimentacion("Proteina",90f,73f)