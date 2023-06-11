package com.example.pruebaproyecto.pantallas.DatosAlimentacion

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
                Spacer(modifier = Modifier.fillMaxWidth().height(40.dp))
                Box(modifier = Modifier.fillMaxWidth() ){
                    Column() {
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