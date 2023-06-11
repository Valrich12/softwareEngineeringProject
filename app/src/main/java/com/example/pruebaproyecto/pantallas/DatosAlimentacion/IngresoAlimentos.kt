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
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.pruebaproyecto.ui.theme.AppTheme

@Composable
fun IngresoAlimentos() {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background) ){
            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                Text(text = "Ingresa los Alimentos que Consumas Durante el Día", color = MaterialTheme.colorScheme.primary)
                Spacer(modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp))
                Box(modifier = Modifier.fillMaxWidth() ){
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "Macronutrientes Diarios",
                            textAlign = TextAlign.Center,
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.Bold,
                            )

                        Spacer(modifier = Modifier.fillMaxWidth().height(30.dp))

                        Row(horizontalArrangement = Arrangement.spacedBy(40.dp)) {
                            Box(modifier = Modifier.width(70.dp), contentAlignment = Alignment.Center) {
                                Text(text = "Energia",color = MaterialTheme.colorScheme.onBackground)
                            }
                            Box(modifier = Modifier.width(70.dp), contentAlignment = Alignment.Center) {
                                Text(text = "Proteina",color = MaterialTheme.colorScheme.onBackground)
                            }
                            Box(modifier = Modifier.width(70.dp), contentAlignment = Alignment.Center) {
                                Text(text = "Grasa",color = MaterialTheme.colorScheme.onBackground)
                            }
                        }

                        Spacer(modifier = Modifier.fillMaxWidth().height(20.dp))

                        Row(horizontalArrangement = Arrangement.spacedBy(40.dp)) {
                            Box(modifier = Modifier.width(70.dp), contentAlignment = Alignment.Center) {
                                Text(text = "560 kcal",color = MaterialTheme.colorScheme.onBackground)
                            }
                            Box(modifier = Modifier.width(70.dp), contentAlignment = Alignment.Center) {
                                Text(text = "60 gr",color = MaterialTheme.colorScheme.onBackground)
                            }
                            Box(modifier = Modifier.width(70.dp), contentAlignment = Alignment.Center) {
                                Text(text = "20 gr",color = MaterialTheme.colorScheme.onBackground)
                            }
                        }

                        Spacer(modifier = Modifier.fillMaxWidth().height(30.dp))

                        ElevatedButton(
                            modifier = Modifier.fillMaxWidth(),
                            onClick = { /*TODO*/ }) {
                            Text("Agregar Alimento")
                        }
                    }
                }



            }


    }


}

@Preview
@Composable
fun IngresoAlimentosPreview() {
    AppTheme {
        IngresoAlimentos()
    }
}