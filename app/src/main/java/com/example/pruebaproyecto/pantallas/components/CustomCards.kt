package com.example.pruebaproyecto.pantallas.components


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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pruebaproyecto.clases.Alimento
import com.example.pruebaproyecto.ui.theme.AppTheme
import com.example.pruebaproyecto.ui.theme.md_theme_light_primaryContainer

@Composable
fun CustomCards(alimento:Alimento,buttonAction:()-> Unit) {
    
    Card(
        modifier = Modifier.size(height = 160.dp, width = 170.dp)
    ) {
        Column(modifier = Modifier.padding(10.dp)) {
            Text(text=alimento.nombre,style= MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(10.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                Box(modifier = Modifier.width(85.dp)) {
                    Text(text="Carbohidratos:",style= MaterialTheme.typography.bodySmall)
                }
                Box(modifier = Modifier.width(60.dp)) {
                    Text(text=""+alimento.carbohidratos + " Kcal",style= MaterialTheme.typography.bodySmall)
                }
            }
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                Box(modifier = Modifier.width(85.dp)) {
                    Text(text="Proteinas:",style= MaterialTheme.typography.bodySmall)
                }
                Box(modifier = Modifier.width(60.dp)) {
                    Text(text=""+alimento.proteina + " gr",style= MaterialTheme.typography.bodySmall)
                }
            }
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                Box(modifier = Modifier.width(85.dp)) {
                    Text(text="Grasa:",style= MaterialTheme.typography.bodySmall)
                }
                Box(modifier = Modifier.width(60.dp)) {
                    Text(text=""+alimento.grasa + " gr",style= MaterialTheme.typography.bodySmall)
                }
            }
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(10.dp))
            ElevatedButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = buttonAction,
                colors = ButtonDefaults.elevatedButtonColors(
                    containerColor = md_theme_light_primaryContainer,
                    contentColor = Color.Black
                )
            ) {
                Text("Agregar Alimento", fontSize = 10.sp) }

        }

    }
    
    
}

@Preview
@Composable
fun CustomCardPreview() {
    AppTheme() {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.Center) {
            CustomCards(alimento = alimentoPrueba) {

            }
        }

    }

}

val alimentoPrueba = Alimento("Huevos","Alimento Solido",12,10,12)