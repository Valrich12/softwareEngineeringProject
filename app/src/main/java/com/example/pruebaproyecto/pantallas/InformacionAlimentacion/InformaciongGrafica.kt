package com.example.pruebaproyecto.pantallas.InformacionAlimentacion


import androidx.compose.foundation.layout.LayoutScopeMarker
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.ParentDataModifier
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
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
            val barParentData = measurable.parentData as GramsGraphParentData
            val barWidth = (barParentData.cantidad * grHeaderPlaceable.width).roundToInt()

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
                val barParentData = barPlaceable.parentData as GramsGraphParentData
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
        cantitad: Float,
    ):Modifier{
      return then(
          GramsGraphParentData(
              cantidad = cantitad,
          )
      )
    }

}



class  GramsGraphParentData(
    val cantidad: Float,
) : ParentDataModifier {
    override fun Density.modifyParentData(parentData: Any?) = this@GramsGraphParentData
}