package com.example.pruebaproyecto.pantallas.MainNavScreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.pruebaproyecto.R
import com.example.pruebaproyecto.ui.theme.AppTheme
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@Composable
fun MainNavScreen() {


    val scope = rememberCoroutineScope()
    val tabs = listOf(
        TabItem.Recomendaciones,
        TabItem.IngresoAlimentos,
        TabItem.Graficas,
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
    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabsContent(tabs : List<TabItem>, pagerState: PagerState, modifier: Modifier) {
    HorizontalPager(count = tabs.size, state = pagerState, modifier = modifier) {page ->
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