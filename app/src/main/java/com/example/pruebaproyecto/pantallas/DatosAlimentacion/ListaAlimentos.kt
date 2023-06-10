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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Done
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pruebaproyecto.clases.Alimento
import com.example.pruebaproyecto.ui.theme.AppTheme

var selectedItems = mutableListOf<String>()
var tiposAlimento : HashMap<String, MutableList<Alimento>> = HashMap()

fun recibirAlimentos(){
    var prueba :String = "Prueba"
    //var tiposAlimentos = mutableListOf<MutableList<Alimento>>()
    var alimento1 = Alimento("Manzana","Frutas")
    var alimento2 = Alimento("Zanahoria","Verduras")
    var alimento3 = Alimento("Maiz","Cereales")
    var alimento4 = Alimento("Fresa","Frutas")
    var alimento5 = Alimento("Tomate","Verduras")
    var alimento6 = Alimento("Arroz","Cereales")
    var alimentoP = Alimento("Arroz","Cereales")
    val frutas = mutableListOf<Alimento>(alimento1,alimento4)
    val verduras = mutableListOf<Alimento>(alimento2,alimento5)
    val cereales = mutableListOf<Alimento>(alimento3,alimento6)
    val raices = mutableListOf<Alimento>(alimentoP)


    tiposAlimento.put(alimento1.tipo, frutas)
    tiposAlimento.put(alimento2.tipo, verduras)
    tiposAlimento.put(alimento3.tipo, cereales)
    tiposAlimento.put("Raices",raices)

    var alimento7 = Alimento("Pera","Frutas")
    var alimento8 = Alimento("Platano","Frutas")
    var alimento9 = Alimento("alimento9","Frutas")
    var alimento10 = Alimento("alimento10","Frutas")
    var alimento11 = Alimento("alimento11","Frutas")
    var alimento12 = Alimento("alimento12","Frutas")
    var alimento13 = Alimento("alimento13","Frutas")
    var alimento14 = Alimento("alimento14","Frutas")
    var alimento15 = Alimento("alimento15","Frutas")
    var alimento16 = Alimento("alimento16","Frutas")
    var alimento17 = Alimento("alimento17","Frutas")
    var alimento18 = Alimento("alimento18 ","Frutas")
    var alimento19 = Alimento("alimento19","Frutas")
    var alimento20 = Alimento("alimento20","Frutas")
    var alimento21 = Alimento("alimento21","Frutas")
    var alimento22 = Alimento("alimento22","Frutas")
    var alimento23 = Alimento("alimento23","Frutas")
    var alimento24 = Alimento("alimento24","Frutas")
    var alimento25 = Alimento("alimento25","Frutas")
    var alimento26 = Alimento("alimento26","Frutas")
    var alimento27 = Alimento("alimento27","Frutas")
    var alimento28 = Alimento("alimento28 ","Frutas")
    var alimento29 = Alimento("alimento29","Frutas")
    var alimento30 = Alimento("alimento30","Frutas")
    var alimento31 = Alimento("alimento31","Frutas")
    var alimento32 = Alimento("alimento32","Frutas")

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
    tiposAlimento.get(alimento21.tipo)?.add(alimento21)
    tiposAlimento.get(alimento22.tipo)?.add(alimento22)
    tiposAlimento.get(alimento23.tipo)?.add(alimento23)
    tiposAlimento.get(alimento24.tipo)?.add(alimento24)
    tiposAlimento.get(alimento25.tipo)?.add(alimento25)
    tiposAlimento.get(alimento26.tipo)?.add(alimento26)
    tiposAlimento.get(alimento27.tipo)?.add(alimento27)
    tiposAlimento.get(alimento28.tipo)?.add(alimento28)
    tiposAlimento.get(alimento29.tipo)?.add(alimento29)
    tiposAlimento.get(alimento30.tipo)?.add(alimento30)
    tiposAlimento.get(alimento31.tipo)?.add(alimento31)
    tiposAlimento.get(alimento32.tipo)?.add(alimento32)

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListaAlimentos() {
    recibirAlimentos()
    var itemsLeft = 0
    var itemsCount = 0

    Box(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize(),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),

        ){

            Row (
                verticalAlignment =  Alignment.CenterVertically
            ){
                IconButton(
                    onClick = { /*TODO*/ })
                {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back Icon",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
                Text(
                    text = "Seleccion de Alimentos ",
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "Selecciona los alimentos que consumes con regularidad",
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
                                        modifier = Modifier.width(122.dp),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        var name = key.value[itemsCount].nombre
                                        FilterChip(
                                            selected = isSelected,
                                            onClick = {
                                                isSelected = !isSelected
                                                if (isSelected) {
                                                    selectedItems.add(name)
                                                } else {
                                                    selectedItems.remove(name)
                                                }
                                            },
                                            label = { Text(text = key.value[itemsCount].nombre) },
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

                            onClick = { /*TODO*/ }
                        ) {
                            Icon(
                                modifier = Modifier.size(42.dp),
                                imageVector = Icons.Default.ArrowForward,
                                contentDescription = "forward Icon"
                            )

                        }
                    }
                }
            }

            selectedItems.forEach(){
                Text(text = it)
            }
        }

    }

}









