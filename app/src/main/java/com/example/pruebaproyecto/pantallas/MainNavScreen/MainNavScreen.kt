package com.example.pruebaproyecto.pantallas.MainNavScreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.pruebaproyecto.R
import com.example.pruebaproyecto.clases.Alimento
import com.example.pruebaproyecto.clases.AlimentoConsumed
import com.example.pruebaproyecto.pantallas.DatosAlimentacion.IngresoAlimentos
import com.example.pruebaproyecto.pantallas.InformacionAlimentacion.InformacionAlimentacion
import com.example.pruebaproyecto.pantallas.Recomendaciones.Recomendaciones
import com.example.pruebaproyecto.pantallas.components.AlimentosDialog
import com.example.pruebaproyecto.pantallas.components.EventDialog
import com.example.pruebaproyecto.pantallas.components.LoadingDialog
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

fun sumNutr(
    alimentos:List<AlimentoConsumed>
):List<Int>{
    var nutrientes = mutableListOf<Int>()
    var proteina = 0
    var grasa = 0
    var carbs = 0
    alimentos.forEach(){ alimentoConsumed ->
        proteina += alimentoConsumed.alimento.proteina
        grasa += alimentoConsumed.alimento.grasa
        carbs += alimentoConsumed.alimento.carbohidratos
    }
    nutrientes.add(proteina)
    nutrientes.add(grasa)
    nutrientes.add(carbs)
    return nutrientes
}
@Composable
fun MainNavScreen(
    state: MainNavState,
    onDissmiss: () -> Unit,
    updateAlimentos: (AlimentoConsumed) -> Unit,
    getListAlimentoConsumed: ()->Unit,
    showAlimentos:()->Unit,
    deleteAlimentoConsumed: (AlimentoConsumed) -> Unit
) {
    var sumNutr = sumNutr(state.alimentosConsumed)
    val scope = rememberCoroutineScope()
    val tabs = listOf(
        TabItem("Recomendaciones", {Recomendaciones(state,updateAlimentos,getListAlimentoConsumed)}),
        TabItem("Ingreso de Alimentos", {IngresoAlimentos(state,showAlimentos,sumNutr,deleteAlimentoConsumed)}),
        TabItem("Seguimiento", {InformacionAlimentacion(state,sumNutr)}),
    )
    var pagerState = rememberPagerState()
    Box(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background)) {
        Column(modifier = Modifier.fillMaxSize() ) {
            ConstraintLayout() {
                val (header,tabsRow,content) = createRefs()
                Row (
                    modifier = Modifier
                        .padding(top = 16.dp, start = 16.dp)
                        .constrainAs(header) {
                            top.linkTo(parent.top)

                        },
                    verticalAlignment =  Alignment.CenterVertically
                ){
                    IconButton(
                        onClick = {

                        })
                    {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back Icon",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }

                    Text(
                        text = "Saludate",
                        style = MaterialTheme.typography.headlineMedium,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Spacer(modifier = Modifier.width(150.dp))
                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = "Login Image",
                        modifier = Modifier
                            .size(55.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Inside
                    )
                }
                Box(
                    modifier = Modifier
                        .constrainAs(tabsRow){
                            top.linkTo(header.bottom)
                        }
                ) {
                    ScrollableTabRow(
                        selectedTabIndex = pagerState.currentPage,
                        containerColor = MaterialTheme.colorScheme.background,
                        edgePadding = 0.dp
                    ) {
                        tabs.forEachIndexed{ index, tab ->
                            Tab(
                                selected = pagerState.currentPage == index,
                                onClick = {
                                    scope.launch {
                                        pagerState.animateScrollToPage(index)
                                    }
                                },
                                text={
                                    Text(text = tab.title, color = MaterialTheme.colorScheme.primary)
                                },
                            )
                        }
                    }
                }
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .constrainAs(content) {
                            top.linkTo(tabsRow.bottom, margin = 20.dp)
                        }){
                    TabsContent(
                        tabs = tabs,
                        pagerState = pagerState,

                        modifier = Modifier.fillMaxSize()
                    )
                }
            }


        }
        if(state.showListAlimentos ){
            AlimentosDialog(state = state, onDissmis = {onDissmiss()} , updateAlimentos = updateAlimentos, getListAlimentoConsumed = getListAlimentoConsumed)
        }else if (state.isLoading){
            LoadingDialog()
        }
    }


}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabsContent(tabs : List<TabItem>, pagerState: PagerState, modifier: Modifier) {
    HorizontalPager(count = tabs.size, state = pagerState, modifier = modifier) {page ->
        tabs[page].screen()
    }
    
}

