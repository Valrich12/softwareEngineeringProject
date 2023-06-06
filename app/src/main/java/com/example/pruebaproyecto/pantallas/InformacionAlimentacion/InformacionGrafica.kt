package com.example.pruebaproyecto.pantallas.InformacionAlimentacion


import androidx.compose.foundation.layout.LayoutScopeMarker
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.ParentDataModifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import com.example.pruebaproyecto.pantallas.InformacionAlimentacion.GramsGraphScope.gramsGraphBar
import com.example.pruebaproyecto.ui.theme.AppTheme
import kotlin.math.roundToInt


@Composable
fun InfoGrafica(
    grHeader:   @Composable () -> Unit,
    nutrCounts: Int,
    nutrLabel:  @Composable (index:Int) -> Unit,
    nutrBar:    @Composable (index:Int) -> Unit,
    modifer: Modifier =Modifier
) {
    val nutrLabels = @Composable{
        repeat(nutrCounts){nutrLabel(it)}
    }
    val nutrBars = @Composable{
        repeat(nutrCounts){nutrBar(it)}
    }
    Layout(
        contents = listOf(grHeader,nutrLabels,nutrBars),
        modifier = modifer.padding(bottom = 32.dp)
    ){
            (grHeaderMeasurable, nutrLabelsMeasurable, nutrBarsMeasurable),
            constraints,
        ->
        require(grHeaderMeasurable.size == 1){}

        val grHeaderPlaceable = grHeaderMeasurable.first().measure(constraints)
        val nutrPlaceables = nutrLabelsMeasurable.map { measurable ->
            val placeable = measurable.measure(constraints)
            placeable
        }

        var totalHeight = grHeaderPlaceable.height

        val barPlaceables = nutrBarsMeasurable.map { measurable ->
            //val barParentData = measurable.parentData as GramsGraphParentData
            val barWidth = (300.5f * grHeaderPlaceable.width).roundToInt()

            val barPlaceable = measurable.measure(
                constraints.copy(
                    minWidth = barWidth,
                    maxWidth = barWidth
                )
            )
            totalHeight += barPlaceable.height
            barPlaceable
        }

        val totalWidth = nutrPlaceables.first().width + grHeaderPlaceable.width

        layout(totalWidth,totalHeight){
            val xPosition = nutrPlaceables.first().width
            var yPosition = grHeaderPlaceable.height

            grHeaderPlaceable.place(xPosition,0)

            barPlaceables.forEachIndexed{ index, barPlaceable ->
                barPlaceable.place(xPosition,yPosition)

                val nutrLabelPlaceable = nutrPlaceables[index]
                nutrLabelPlaceable.place(x = 0, y = yPosition)

                yPosition += barPlaceable.height
            }
        }

    }
}

@LayoutScopeMarker
@Immutable

object GramsGraphScope {
    @Stable
    fun Modifier.gramsGraphBar(
        cantidad: Float,
    ):Modifier{
      val cantidaddevuelta = cantidad
      return then(
          GramsGraphParentData(
              cantidad = cantidaddevuelta,
          )
      )
    }

}
@Preview
@Composable
fun graphPreview() {
    AppTheme() {
        InfoGrafica(
            grHeader = {
                       Row() {
                           Text(text = "1")
                           Text(text = "1")
                           Text(text = "1")
                           Text(text = "1")
                       }
            }, nutrCounts = 2, nutrLabel ={index ->
                Text(text = "Hola")
            },
            nutrBar ={ GramsBar(
                modifier = Modifier
                    .gramsGraphBar(
                        cantidad = 12f
                    )
            )}
        )


    }
}

class  GramsGraphParentData(
    val cantidad: Float,
) : ParentDataModifier {
    override fun Density.modifyParentData(parentData: Any?) = this@GramsGraphParentData
}

@Composable
private fun graphLabelPrueba(labelText: String) {
    Text(
        text = labelText
        ,
        Modifier
            .height(24.dp)
            .padding(start = 8.dp, end = 24.dp),
        style = MaterialTheme.typography.bodyLarge,
        textAlign = TextAlign.Center
    )
}