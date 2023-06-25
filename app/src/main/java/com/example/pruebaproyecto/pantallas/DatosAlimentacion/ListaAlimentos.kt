package com.example.pruebaproyecto.pantallas.DatosAlimentacion

import android.util.Log
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
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.pruebaproyecto.Repositories.ResultListAlimentos
import com.example.pruebaproyecto.clases.Alimento
import com.example.pruebaproyecto.clases.AlimentoConsumed
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
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListaAlimentos(
     updateAlimento: (AlimentoConsumed) -> Unit,
     state: MainNavState,
     onDissmis: () -> Unit,
     getListAlimentosConsumed: () -> Unit
) {
    recibirAlimentos(state.listAlimentos)
    var itemsLeft = 0
    var itemsCount = 0

    Card(
        modifier = Modifier
            .width(370.dp)
            .height(750.dp),
        shape = RoundedCornerShape(30.dp)
    ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(15.dp),

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
                LazyColumn(
                     modifier = Modifier
                         .fillMaxWidth()
                         .height(600.dp)
                ) {
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
                                            modifier = Modifier.width(120.dp),
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
                        Spacer(modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp))
                    }
                }
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    FloatingActionButton(
                        modifier = Modifier
                            .size(70.dp),

                        onClick = {
                            selectedItems.forEach(){nombre->

                                val selectedItemsConsumed = state.listAlimentos.filter { it.nombre == nombre }

                                val alimentoConsumed = AlimentoConsumed(selectedItemsConsumed.first(),state.clientData.clientId)

                                updateAlimento(alimentoConsumed)
                            }
                            getListAlimentosConsumed()
                            selectedItems.clear()
                            onDissmis()
                        }
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

}











