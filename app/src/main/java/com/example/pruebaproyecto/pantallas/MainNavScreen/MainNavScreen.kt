package com.example.pruebaproyecto.pantallas.MainNavScreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pruebaproyecto.ui.theme.AppTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainNavScreen() {

    var pagerState = rememberPagerState()
    val scope = rememberCoroutineScope()
    val tabs = listOf(
        TabItem.Graficas,
        TabItem.IngresoDatos,
        TabItem.Contacto,
    )
    Box(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background)) {
        Column(modifier = Modifier.fillMaxSize() ) {
            Box {
                TabRow(
                    selectedTabIndex = pagerState.currentPage,
                    containerColor = MaterialTheme.colorScheme.background
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
                            selectedContentColor = Color.Cyan
                        )
                    }
                }
            }
            Spacer(Modifier.fillMaxWidth().height(20.dp))
            Box(Modifier.fillMaxSize()){
                TabsContent(
                    tabs = tabs,
                    pagerState = pagerState,
                    modifier = Modifier.fillMaxSize()
                )
            }

        }
    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabsContent(tabs : List<TabItem>,pagerState: PagerState,modifier: Modifier) {
    HorizontalPager(pageCount = tabs.size, state = pagerState, modifier = modifier) {page ->
        tabs[page].screen()
    }
    
}

@Preview
@Composable

fun MainScreenPreview(){
    AppTheme {
        MainNavScreen()
    }
}