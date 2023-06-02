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

        layout(){}

    }
}

@LayoutScopeMarker
@Immutable

object GramsGraphScope {
    @Stable

}



class  GramsGraphParentData(
    val cantidad: Float,
    val offset: Float,
) : ParentDataModifier {
    override fun Density.modifyParentData(parentData: Any?) = this@GramsGraphParentData
}