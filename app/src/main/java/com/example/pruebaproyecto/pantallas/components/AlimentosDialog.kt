package com.example.pruebaproyecto.pantallas.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.pruebaproyecto.pantallas.DatosAlimentacion.ListaAlimentos
import com.example.pruebaproyecto.pantallas.MainNavScreen.MainNavState

@Composable
fun AlimentosDialog(
    onDissmis : () -> Unit,
    updateAlimentos:() -> Unit,
    state: MainNavState
) {
   Dialog(
       onDismissRequest = { onDissmis() },
       properties = DialogProperties(
           usePlatformDefaultWidth = false
       )
       ) {
       ListaAlimentos(onClick = { updateAlimentos() }, state = state)
   }
}