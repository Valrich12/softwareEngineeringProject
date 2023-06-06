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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import com.example.pruebaproyecto.ui.theme.AppTheme
import kotlin.math.roundToInt
import android.util.Log
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun InfoGrafica(
    grHeader:   @Composable () -> Unit,
    nutrCounts: Int,
    nutrLabel:  @Composable (index:Int) -> Unit,
    nutrBar:    @Composable GramsGraphScope.(index:Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    val nutrLabels = @Composable{ repeat(nutrCounts){nutrLabel(it)} }
    val nutrBars = @Composable{ repeat(nutrCounts) { GramsGraphScope.nutrBar(it) } }
    Layout(
        contents = listOf(grHeader,nutrLabels,nutrBars),
        modifier = modifier.padding(bottom = 32.dp)
    ){
            (grHeaderMeasurables, nutrLabelsMeasurables, nutrBarsMeasurables),
            constraints,
        ->
        require(grHeaderMeasurables.size == 1){
            "grams Header should only emit one composable"
        }

        val grHeaderPlaceable = grHeaderMeasurables.first().measure(constraints)

        val nutrPlaceables = nutrLabelsMeasurables.map { measurable ->
            val placeable = measurable.measure(constraints)
            placeable
        }

        var totalHeight = grHeaderPlaceable.height

        val barPlaceables = nutrBarsMeasurables.map { measurable ->
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
    ): Modifier {
        return then(
          GramsGraphParentData(
              cantidad = cantidad
          )
      )
    }

}

class  GramsGraphParentData(
    val cantidad: Float,
) : ParentDataModifier {
    override fun Density.modifyParentData(parentData: Any?) = this@GramsGraphParentData
}



