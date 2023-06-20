package com.example.pruebaproyecto.pantallas.Recomendaciones

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
import com.example.pruebaproyecto.pantallas.MainNavScreen.MainNavState
import com.example.pruebaproyecto.pantallas.components.CustomCards
import com.example.pruebaproyecto.ui.theme.AppTheme

@Composable
fun Recomendaciones(
    state:MainNavState
) {
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
                    state.listAlimentos.forEach(){alimento ->
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
                    state.listAlimentos.forEach(){alimento ->
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
                    state.listAlimentos.forEach(){alimento ->
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
                    state.listAlimentos.forEach(){alimento ->
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
                    state.listAlimentos.forEach(){alimento ->
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



