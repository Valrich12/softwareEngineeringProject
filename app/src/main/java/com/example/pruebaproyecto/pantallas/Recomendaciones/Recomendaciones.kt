package com.example.pruebaproyecto.pantallas.Recomendaciones

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pruebaproyecto.clases.Alimento
import com.example.pruebaproyecto.clases.ClientData
import com.example.pruebaproyecto.pantallas.MainNavScreen.MainNavState
import com.example.pruebaproyecto.pantallas.components.CustomCards
import com.example.pruebaproyecto.ui.theme.AppTheme

@Composable
fun Recomendaciones(
    state:MainNavState
) {

    val recomendacionDesayuno = hacerRecomendacion(state.listAlimentos,state.clientData,1)
    val recomendacionColacion1 = hacerRecomendacion(state.listAlimentos,state.clientData,2)
    val recomendacionComida = hacerRecomendacion(state.listAlimentos,state.clientData,3)
    val recomendacionColacion2 = hacerRecomendacion(state.listAlimentos,state.clientData,4)
    val recomendacionCena = hacerRecomendacion(state.listAlimentos,state.clientData,5)


    Box(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background))
    {
        LazyColumn(
            modifier = Modifier.padding(16.dp)
        ) {
            item {
                Text(text = "Desayuno", fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onBackground)
                Spacer(modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp))
                LazyRow(){
                   recomendacionDesayuno.forEach(){alimento ->
                        item {
                            CustomCards(alimento = alimento) {
                            }
                            Spacer(modifier = Modifier
                                .fillMaxHeight()
                                .width(20.dp))
                        }    
                        
                    }
                }
                Spacer(modifier = Modifier
                    .fillMaxWidth()
                    .height(25.dp))
            }
            item {
                Text(text = "Primera Colación", fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onBackground)
                Spacer(modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp))
                LazyRow(){
                   recomendacionColacion1.forEach(){alimento ->
                        item {
                            CustomCards(alimento = alimento) {
                            }
                            Spacer(modifier = Modifier
                                .fillMaxHeight()
                                .width(20.dp))
                        }

                    }
                }
                Spacer(modifier = Modifier
                    .fillMaxWidth()
                    .height(25.dp))
            }
            item {
                Text(text = "Comida", fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onBackground)
                Spacer(modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp))
                LazyRow(){
                    recomendacionComida.forEach(){alimento ->
                        item {
                            CustomCards(alimento = alimento) {
                            }
                            Spacer(modifier = Modifier
                                .fillMaxHeight()
                                .width(20.dp))
                        }

                    }
                }
                Spacer(modifier = Modifier
                    .fillMaxWidth()
                    .height(25.dp))
            }
            item {
                Text(text = "Segunda Colación", fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onBackground)
                Spacer(modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp))
                LazyRow(){
                    recomendacionColacion2.forEach(){alimento ->
                        item {
                            CustomCards(alimento = alimento) {
                            }
                            Spacer(modifier = Modifier
                                .fillMaxHeight()
                                .width(20.dp))
                        }

                    }
                }
                Spacer(modifier = Modifier
                    .fillMaxWidth()
                    .height(25.dp))
            }
            item {
                Text(text = "Cena", fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onBackground)
                Spacer(modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp))
                LazyRow(){
                    recomendacionCena.forEach(){alimento ->
                        item {
                            CustomCards(alimento = alimento) {
                            }
                            Spacer(modifier = Modifier
                                .fillMaxHeight()
                                .width(20.dp))
                        }

                    }
                }
                Spacer(modifier = Modifier
                    .fillMaxWidth()
                    .height(25.dp))
            }
            item { 
                Spacer(modifier = Modifier.fillMaxWidth().height(120.dp))
            }

        }

    }
}
fun hacerRecomendacion(alimentos: List<Alimento>,clientData: ClientData,comida:Int):List<Alimento>{
    var multSup = 0.0f
    var multInf = 0.0f
    when(comida){
        1 -> {
            multSup =.20f
            multInf = 0.10f
        }
        2 -> {
            multSup =.10f
            multInf = 0.05f
        }
        3 -> {
            multSup =.33f
            multInf = 0.27f
        }
        4 -> {
            multSup =.10f
            multInf = 0.05f
        }
        5 -> {
            multSup =.30f
            multInf = 0.25f
        }
    }

    val carbsSuperior = (clientData.carbs*multSup).toInt()
    val carbsInferior = (clientData.carbs*multInf).toInt()

    val protSuperior = (clientData.proteinas*multSup).toInt()
    val protInferior = (clientData.proteinas*multInf).toInt()

    val grasaSuperior = (clientData.grasas*multSup).toInt()
    val grasaInferior = (clientData.grasas*multInf).toInt()
    if (comida == 1){
        Log.d("CARBS","CARBS= "+carbsInferior.toString()+"< "+carbsSuperior.toString())
        Log.d("CARBS","PROT= "+protInferior.toString()+"< "+protSuperior.toString())
        Log.d("CARBS","GRASA= "+grasaInferior.toString()+"< "+grasaSuperior.toString())
    }
    val recomendacion = alimentos.filter {
        (it.carbohidratos in carbsInferior..carbsSuperior) and (it.proteina in protInferior..protSuperior) and (it.grasa in grasaInferior..grasaSuperior)}

    return  recomendacion
}



