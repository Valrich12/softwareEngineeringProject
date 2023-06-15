package com.example.pruebaproyecto.pantallas.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.AlertDialog
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pruebaproyecto.ui.theme.AppTheme

@Composable
fun EventDialog(
    modifier: Modifier = Modifier,
    errorMessage: String,
    onDissmis: (() -> Unit)? = null
){
    AlertDialog(
        modifier = modifier,
        onDismissRequest = { onDissmis?.invoke() },
        title = {
            Text(
                "Error",
                style = TextStyle(
                    color = MaterialTheme.colorScheme.onSurface,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        },
        text = {
            Text(
                text = errorMessage,
                style = TextStyle(
                    color = MaterialTheme.colorScheme.onSurface,
                    fontSize = 16.sp
                )
            )
        },
        confirmButton = {

                TextButton(onClick = { onDissmis?.invoke() }) {
                    Text(text = "Aceptar", style = MaterialTheme.typography.bodyLarge, color = MaterialTheme.colorScheme.primary)
                }

        }
    )
}

@Preview
@Composable
fun EventiDialogPreview(){
    AppTheme() {
        EventDialog(errorMessage = "Prueba")
    }
}