package com.example.pruebaproyecto.pantallas.InformacionAlimentacion



import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pruebaproyecto.ui.theme.AppTheme
import com.example.pruebaproyecto.ui.theme.md_theme_light_primaryContainer
import com.example.pruebaproyecto.ui.theme.md_theme_light_secondary

@Composable
fun GramsBar(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        GramsRoundedBar(
        )
    }
}

@Composable

private fun GramsRoundedBar(
){
   Spacer(modifier = Modifier
       .drawWithCache {
           val brush = Brush.verticalGradient(
               listOf(
                   md_theme_light_primaryContainer,
                   md_theme_light_secondary
               )
           )

           onDrawBehind {
               drawRoundRect(brush, cornerRadius = CornerRadius(5.dp.toPx()))
           }
       }
       .fillMaxWidth()
       .height(30.dp)
   )
}

@Preview
@Composable
fun BarPreview(){
    AppTheme {
      GramsBar()
    }
}