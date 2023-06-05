package com.example.pruebaproyecto.pantallas.InformacionAlimentacion


import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.draw.DrawResult
import androidx.compose.ui.draw.drawWithCache

import androidx.compose.ui.unit.dp

@Composable
fun GramsBar(
) {
    Column {
        GramsRoundedBar(
        )
    }
}

@Composable
private fun GramsRoundedBar(
){
   Spacer(modifier = Modifier
       .drawWithCache {
           val width = this.size.width
           val CornerRadiusPx = 10.dp.toPx()

       }
   )
}