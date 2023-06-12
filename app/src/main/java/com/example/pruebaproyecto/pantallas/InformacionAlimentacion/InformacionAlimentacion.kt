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
import androidx.compose.ui.text.font.FontWeight
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
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)) {
        Column(Modifier.fillMaxWidth()) {
            Box(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.background)
                    .fillMaxSize()
                    ,

            ) {
                ConstraintLayout() {
                    val(graphProt,graphEner,graphGrasa,textoProt,textoEner,textoGras) = createRefs()


                    Box(
                        modifier = Modifier
                            .constrainAs(textoEner){
                                top.linkTo(parent.top, margin = 30.dp)
                                start.linkTo(parent.start, margin = 15.dp)
                            }
                    ) {
                        Text(text = "CARBOHIDRATOS", color = MaterialTheme.colorScheme.onBackground)
                    }
                    Box(
                        modifier = Modifier
                            .constrainAs(graphEner){
                                top.linkTo(textoEner.bottom)
                                start.linkTo(parent.start, margin = 30.dp)
                            },
                    ) {
                        InformacionEnergiaGraph()
                    }
                    Box(
                        modifier = Modifier
                            .constrainAs(textoProt){
                                top.linkTo(graphEner.bottom)
                                start.linkTo(parent.start, margin = 15.dp)
                            }
                    ) {
                        Text(text = "PROTEINA", color = MaterialTheme.colorScheme.onBackground)
                    }
                    Box(
                        modifier = Modifier
                            .constrainAs(graphProt){
                                top.linkTo(graphEner.bottom, margin = 20.dp)
                                start.linkTo(parent.start, margin = 30.dp)
                            }) {
                        InformacionProteinaGraph()
                    }
                    Box(
                        modifier = Modifier
                            .constrainAs(textoGras){
                                top.linkTo(graphProt.bottom)
                                start.linkTo(parent.start, margin = 15.dp)
                            }
                    ) {
                        Text(text = "GRASA", color = MaterialTheme.colorScheme.onBackground)
                    }
                    Box(
                        modifier = Modifier
                            .constrainAs(graphGrasa){
                                top.linkTo(graphProt.bottom, margin = 20.dp)
                                start.linkTo(parent.start, margin = 30.dp)
                            }) {
                        InformacionGrasaGraph()
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
    val labels = listOf<String>(fakeDataEnergia.tipoMacro+" Actuales", fakeDataEnergia.tipoMacro +" Recomendados")
    val cantidades = listOf<Int>(400,800,1200,1600,2000,2400,2800,3200)
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
                        cantidad = cantidadesBar[index] / 3200f
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
    val labels = listOf<String>(fakeDataProteina.tipoMacro+" \nActual", fakeDataProteina.tipoMacro +" Recomendada")
    val cantidades = listOf<Int>(20,40,60,80,100,120,140)
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
                        cantidad = cantidadesBar[index] / 140f
                    )
            )
        }
    )


}

@Composable
private fun InformacionGrasaGraph (
    modifier: Modifier=Modifier
) {
    val cantidadesBar = listOf<Float>(fakeDataGrasa.cantidadActual, fakeDataGrasa.cantidadRecomendada)
    val labels = listOf<String>(fakeDataGrasa.tipoMacro+" \nActual", fakeDataGrasa.tipoMacro +" Recomendada")
    val cantidades = listOf<Int>(20,40,60,80,100,120,140)
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
                        cantidad = cantidadesBar[index] / 140f
                    )
            )
        }
    )


}


@Composable

private fun graphLabel(labelText: String) {
    Box(modifier = Modifier
        .width(100.dp)
        .padding(end = 10.dp)){
        Text(
            text = labelText
            ,
            Modifier
                .height(30.dp),
            color = MaterialTheme.colorScheme.primary
            ,
            style = MaterialTheme.typography.bodySmall.copy(
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
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
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.bodySmall.copy(fontSize = 11.sp
                )
            )
            Spacer(modifier = Modifier
                .height(16.dp)
                .width(1.dp)
                .background(MaterialTheme.colorScheme.onBackground))
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


val fakeDataEnergia = InfoAlimentacion("Carbohidratos",900f,1600f)

val fakeDataProteina = InfoAlimentacion("Proteina",100f,73f)

val fakeDataGrasa = InfoAlimentacion("Grasa",80f,10f)