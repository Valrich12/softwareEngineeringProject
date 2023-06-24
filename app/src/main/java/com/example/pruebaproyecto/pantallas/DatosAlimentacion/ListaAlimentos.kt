package com.example.pruebaproyecto.pantallas.DatosAlimentacion

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pruebaproyecto.clases.Alimento
import com.example.pruebaproyecto.pantallas.MainNavScreen.MainNavState
import com.example.pruebaproyecto.ui.theme.AppTheme

var selectedItems =  mutableListOf<String>()
var tiposAlimento : HashMap<String, MutableList<Alimento>> = HashMap()

fun recibirAlimentos(
    listaAlimentos : List<Alimento>
){
        tiposAlimento = HashMap()
        listaAlimentos.forEach(){ alimento ->

            if(!tiposAlimento.contains(alimento.tipo))
                {
                    tiposAlimento.put(alimento.tipo,mutableListOf())
                    tiposAlimento.get(alimento.tipo)?.add(alimento)
            }
            else{
                tiposAlimento.get(alimento.tipo)?.add(alimento)
            }

        }


    /*
    tiposAlimento.put("Alimentos Solidos", mutableListOf())
    //var tiposAlimentos = mutableListOf<MutableList<Alimento>>()
    var alimento1 = Alimento("Alambre","Alimentos Solidos")
    var alimento2 = Alimento("Albóndigas","Alimentos Solidos")
    var alimento3 = Alimento("Alitas","Alimentos Solidos")
    var alimento4 = Alimento("Arroz","Alimentos Solidos")
    var alimento5 = Alimento("Bistec","Alimentos Solidos")
    var alimento6 = Alimento("Burritos","Alimentos Solidos")
    var alimento7 = Alimento("Carne Asada","Alimentos Solidos")
    var alimento8 = Alimento("Carne de cerdo","Alimentos Solidos")
    var alimento9 = Alimento("Carne de Res","Alimentos Solidos")
    var alimento10 = Alimento("Chilaquiles","Alimentos Solidos")
    var alimento11 = Alimento("Chiles Rellenos","Alimentos Solidos")
    var alimento12 = Alimento("Sushi","Alimentos Solidos")
    var alimento13 = Alimento("Tacos","Alimentos Solidos")
    var alimento14 = Alimento("Tamales","Alimentos Solidos")
    var alimento15 = Alimento("Tlacoyos","Alimentos Solidos")
    var alimento16 = Alimento("Tlayuda","Alimentos Solidos")
    var alimento17 = Alimento("Torta","Alimentos Solidos")
    var alimento18 = Alimento("Tostadas","Alimentos Solidos")
    var alimento19 = Alimento("Quesadillas","Alimentos Solidos")
    var alimento20 = Alimento("Sandwich","Alimentos Solidos")



    tiposAlimento.get(alimento1.tipo)?.add(alimento1)
    tiposAlimento.get(alimento2.tipo)?.add(alimento2)
    tiposAlimento.get(alimento3.tipo)?.add(alimento3)
    tiposAlimento.get(alimento4.tipo)?.add(alimento4)
    tiposAlimento.get(alimento5.tipo)?.add(alimento5)
    tiposAlimento.get(alimento6.tipo)?.add(alimento6)
    tiposAlimento.get(alimento7.tipo)?.add(alimento7)
    tiposAlimento.get(alimento8.tipo)?.add(alimento8)
    tiposAlimento.get(alimento9.tipo)?.add(alimento9)
    tiposAlimento.get(alimento10.tipo)?.add(alimento10)
    tiposAlimento.get(alimento11.tipo)?.add(alimento11)
    tiposAlimento.get(alimento12.tipo)?.add(alimento12)
    tiposAlimento.get(alimento13.tipo)?.add(alimento13)
    tiposAlimento.get(alimento14.tipo)?.add(alimento14)
    tiposAlimento.get(alimento15.tipo)?.add(alimento15)
    tiposAlimento.get(alimento16.tipo)?.add(alimento16)
    tiposAlimento.get(alimento17.tipo)?.add(alimento17)
    tiposAlimento.get(alimento18.tipo)?.add(alimento18)
    tiposAlimento.get(alimento19.tipo)?.add(alimento19)
    tiposAlimento.get(alimento20.tipo)?.add(alimento20)






    var alimento21 = Alimento("Caldo de Camaron","Caldos")
    var alimento22 = Alimento("Caldo de Pollo","Caldos")
    var alimento23 = Alimento("Caldo de Res","Caldos")
    var alimento24 = Alimento("Crema de Elote","Caldos")
    var alimento25 = Alimento("Pozole de Cerdo","Caldos")
    var alimento26 = Alimento("Pozole de Porllo","Caldos")
    var alimento27 = Alimento("Sopa","Caldos")

    tiposAlimento.get(alimento22.tipo)?.add(alimento22)
    tiposAlimento.get(alimento23.tipo)?.add(alimento23)
    tiposAlimento.get(alimento24.tipo)?.add(alimento24)
    tiposAlimento.get(alimento25.tipo)?.add(alimento25)
    tiposAlimento.get(alimento26.tipo)?.add(alimento26)
    tiposAlimento.get(alimento27.tipo)?.add(alimento27)
     */

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListaAlimentos(
     onClick: () -> Unit,
     state: MainNavState
) {
    recibirAlimentos(state.listAlimentos)
    var itemsLeft = 0
    var itemsCount = 0

    Card(
        modifier = Modifier
            .width(350.dp).height(750.dp),
        shape = RoundedCornerShape(30.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),

        ){

            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "Selecciona los alimentos que consumas",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Light
                ),
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(15.dp))
            LazyColumn() {
                for (key in tiposAlimento) {
                    item {
                        Text(
                            text = key.key,
                            style = MaterialTheme.typography.headlineSmall,
                            color = MaterialTheme.colorScheme.primary
                        )
                        itemsLeft = key.value.size - 1
                        itemsCount = 0
                        while (itemsLeft >= 0) {
                            var countRow = 3
                            Row() {
                                while (countRow > 0 && itemsLeft >= 0) {
                                    var isSelected by remember { mutableStateOf(false) }
                                    Box(
                                        modifier = Modifier.width(110.dp),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        var name = key.value[itemsCount].nombre
                                        isSelected = selectedItems.contains(name)
                                        FilterChip(
                                            modifier = Modifier
                                                .width(118.dp)
                                                .height(50.dp)
                                                .padding(2.dp),
                                            selected = isSelected,
                                            onClick = {
                                                isSelected = !isSelected
                                                if (isSelected) {
                                                    selectedItems.add(name)
                                                } else {
                                                    selectedItems.remove(name)
                                                }
                                            },
                                            label = {
                                                Text(text = key.value[itemsCount].nombre)
                                            },
                                            leadingIcon = if (isSelected) {
                                                {
                                                    Icon(
                                                        imageVector = Icons.Filled.Done,
                                                        contentDescription = "Localized Description",
                                                        modifier = Modifier.size(FilterChipDefaults.IconSize)
                                                    )
                                                }
                                            } else {
                                                null
                                            }
                                        )
                                    }

                                    countRow--
                                    itemsLeft--
                                    itemsCount++
                                }
                            }
                        }
                    }
                }
                item {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.CenterEnd
                    ) {
                        FloatingActionButton(
                            modifier = Modifier
                                .size(70.dp),

                            onClick = { onClick() }
                        ) {
                            Icon(
                                modifier = Modifier.size(42.dp),
                                imageVector = Icons.Default.ArrowForward,
                                contentDescription = "forward Icon"
                            )

                        }
                    }
                }
                item {
                    Spacer(modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp))
                }
            }
        }

    }

}
@Preview
@Composable
fun ListAlimentosPreview() {
    AppTheme() {
        Box(
            modifier = Modifier.fillMaxSize().background(Color.Black),
            contentAlignment = Alignment.Center
        )
        {
            ListaAlimentos(onClick = { /*TODO*/ }, state = MainNavState() )
        }

    }

}










