package com.example.pruebaproyecto.pantallas.DatosAlimentacion

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
    val frutas = mutableListOf<Alimento>(alimento1,alimento4)
    val verduras = mutableListOf<Alimento>(alimento2,alimento5)
    val cereales = mutableListOf<Alimento>(alimento3,alimento6)

    tiposAlimento.put(alimento1.tipo, frutas)
    tiposAlimento.put(alimento2.tipo, verduras)
    tiposAlimento.put(alimento3.tipo, cereales)

    var alimento7 = Alimento("Pera","Frutas")
    var alimento8 = Alimento("Platano","Frutas")

    tiposAlimento.get(alimento7.tipo)?.add(alimento7)
    tiposAlimento.get(alimento8.tipo)?.add(alimento8)

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IngresoAlimentos() {
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
                .padding(10.dp),

        ){
            for (key in tiposAlimento){
                Text(
                    text = key.key,
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.primary
                )
                itemsLeft = key.value.size - 1
                itemsCount = 0
                while (itemsLeft>=0) {
                    var countRow = 3
                        Row() {
                                while (countRow>0 && itemsLeft>=0){
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
                                                        if (isSelected){
                                                            selectedItems.add(name)
                                                        }else{
                                                            selectedItems.remove(name)
                                                        }
                                                      },
                                            label = { Text(text = key.value[itemsCount].nombre)},
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
            selectedItems.forEach(){
                Text(text = it)
            }
        }

    }

}








@Composable
@Preview
fun DatosPreview(){
    AppTheme {
        IngresoAlimentos()
    }
}
