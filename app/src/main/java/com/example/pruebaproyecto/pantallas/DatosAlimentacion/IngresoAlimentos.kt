package com.example.pruebaproyecto.pantallas.DatosAlimentacion

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ButtonDefaults.elevatedButtonColors
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedButton
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pruebaproyecto.clases.Alimento
import com.example.pruebaproyecto.clases.AlimentoConsumed
import com.example.pruebaproyecto.pantallas.MainNavScreen.MainNavState
import com.example.pruebaproyecto.ui.theme.md_theme_light_primaryContainer


@Composable
fun IngresoAlimentos(
    state:MainNavState,
    showAlimentos: () -> Unit,
    sumNutr: List<Int>,
    deleteAlimentoConsumed: (AlimentoConsumed) -> Unit
) {

    Box(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background) ){
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "Ingresa los Alimentos que Consumas Durante el Día",
                        color = MaterialTheme.colorScheme.primary
                    )
                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(20.dp)
                    )
                    Box(modifier = Modifier.fillMaxWidth()) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = "Macronutrientes Consumidos Hoy",
                                textAlign = TextAlign.Center,
                                color = MaterialTheme.colorScheme.primary,
                                fontWeight = FontWeight.Bold,
                            )

                            Spacer(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(30.dp)
                            )

                            Row(horizontalArrangement = Arrangement.spacedBy(30.dp)) {
                                Box(
                                    modifier = Modifier.width(110.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "Carbohidratos",
                                        color = MaterialTheme.colorScheme.onBackground
                                    )
                                }
                                Box(
                                    modifier = Modifier.width(110.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "Proteina",
                                        color = MaterialTheme.colorScheme.onBackground
                                    )
                                }
                                Box(
                                    modifier = Modifier.width(110.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "Grasa",
                                        color = MaterialTheme.colorScheme.onBackground
                                    )
                                }
                            }

                            Spacer(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(20.dp)
                            )

                            Row(horizontalArrangement = Arrangement.spacedBy(30.dp)) {
                                Box(
                                    modifier = Modifier.width(110.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = sumNutr[2].toString()+" kcal",
                                        color = MaterialTheme.colorScheme.onBackground
                                    )
                                }
                                Box(
                                    modifier = Modifier.width(110.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = sumNutr[0].toString()+" gr",
                                        color = MaterialTheme.colorScheme.onBackground
                                    )
                                }
                                Box(
                                    modifier = Modifier.width(110.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = sumNutr[1].toString()+" gr",
                                        color = MaterialTheme.colorScheme.onBackground
                                    )
                                }
                            }
                            Spacer(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(30.dp)
                            )
                            Divider()
                            Spacer(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(30.dp)
                            )
                            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                                Box(
                                    modifier = Modifier.width(70.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "Alimento",
                                        color = MaterialTheme.colorScheme.onBackground,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 14.sp
                                    )
                                }
                                Box(
                                    modifier = Modifier.width(95.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "Carbohidratos",
                                        color = MaterialTheme.colorScheme.onBackground,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 14.sp
                                    )
                                }
                                Box(
                                    modifier = Modifier.width(60.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "Proteina",
                                        color = MaterialTheme.colorScheme.onBackground,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 14.sp
                                    )
                                }
                                Box(
                                    modifier = Modifier.width(40.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "Grasa",
                                        color = MaterialTheme.colorScheme.onBackground,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 14.sp
                                    )
                                }
                                Box(
                                    modifier = Modifier.width(40.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "",
                                        color = MaterialTheme.colorScheme.onBackground,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 14.sp
                                    )
                                }

                            }
                            Spacer(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(15.dp)
                            )
                            LazyColumn(
                                modifier = Modifier.fillMaxWidth().height(300.dp),
                                horizontalAlignment = Alignment.CenterHorizontally) {
                                state.alimentosConsumed.forEach() { alimentoConsumed ->
                                    item {
                                        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                                            Box(
                                                modifier = Modifier
                                                    .width(70.dp)
                                                    .height(30.dp),
                                                contentAlignment = Alignment.Center
                                            ) {
                                                Text(
                                                    text = alimentoConsumed.alimento.nombre,
                                                    color = MaterialTheme.colorScheme.onBackground,
                                                    fontSize = 14.sp
                                                )
                                            }
                                            Box(
                                                modifier = Modifier
                                                    .width(95.dp)
                                                    .height(30.dp),
                                                contentAlignment = Alignment.Center
                                            ) {
                                                Text(
                                                    text = alimentoConsumed.alimento.carbohidratos.toString(),
                                                    color = MaterialTheme.colorScheme.onBackground,
                                                    fontSize = 14.sp
                                                )
                                            }
                                            Box(
                                                modifier = Modifier
                                                    .width(60.dp)
                                                    .height(30.dp),
                                                contentAlignment = Alignment.Center
                                            ) {
                                                Text(
                                                    text = alimentoConsumed.alimento.proteina.toString(),
                                                    color = MaterialTheme.colorScheme.onBackground,
                                                    fontSize = 14.sp
                                                )
                                            }
                                            Box(
                                                modifier = Modifier
                                                    .width(40.dp)
                                                    .height(30.dp),
                                                contentAlignment = Alignment.Center
                                            ) {
                                                Text(
                                                    text = alimentoConsumed.alimento.grasa.toString(),
                                                    color = MaterialTheme.colorScheme.onBackground,
                                                    fontSize = 14.sp
                                                )
                                            }
                                            Box(
                                                modifier = Modifier
                                                    .width(40.dp)
                                                    .height(30.dp),
                                                contentAlignment = Alignment.Center
                                            ) {
                                                IconButton(onClick = { deleteAlimentoConsumed(alimentoConsumed) }) {
                                                    Icon(
                                                        imageVector = Icons.Default.Delete,
                                                        contentDescription = "Icono Basura",
                                                        tint = MaterialTheme.colorScheme.onBackground
                                                    )
                                                }
                                            }

                                        }
                                        Spacer(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .height(5.dp)
                                        )
                                    }
                                }
                                item {
                                    Spacer(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(15.dp)
                                    )

                                }
                            }
                            ElevatedButton(
                                modifier = Modifier.fillMaxWidth(),
                                onClick = {
                                    showAlimentos()
                                },
                                colors = elevatedButtonColors(
                                    containerColor = md_theme_light_primaryContainer,
                                    contentColor = Color.Black
                                )
                            ) { Text("Agregar Alimento") }

                        }
                    }


                }

    }


}





