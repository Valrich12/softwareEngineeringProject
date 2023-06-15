package com.example.pruebaproyecto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.example.pruebaproyecto.Navigation.Destinations
import com.example.pruebaproyecto.pantallas.DatosCliente.IngresoDatos
import com.example.pruebaproyecto.pantallas.InformacionAlimentacion.InformacionAlimentacion
import com.example.pruebaproyecto.pantallas.MainNavScreen.MainNavScreen
import com.example.pruebaproyecto.pantallas.login.LoginScreen
import com.example.pruebaproyecto.pantallas.login.LoginViewModel
import com.example.pruebaproyecto.pantallas.registro.RegistroScreen
import com.example.pruebaproyecto.pantallas.registro.RegistroViewModel
import com.example.pruebaproyecto.ui.theme.AppTheme
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalAnimationApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //WindowCompat.setDecorFitsSystemWindows(window,false)
        setContent {
            AppTheme{
              val navController = rememberAnimatedNavController()

              BoxWithConstraints() {
                  AnimatedNavHost(
                      navController = navController ,
                      startDestination = Destinations.Login.route
                  ){
                        addLogin(navController)
                        addRegister(navController)
                        addDatos(navController)
                        addMain()
                  }
              }  
            }
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.addLogin(
    navController: NavController
){
    composable(
        route = Destinations.Login.route,
        enterTransition = {
                slideInHorizontally (
                    initialOffsetX = { 1000 },
                    animationSpec = tween(500)
                )
        },
        exitTransition = {
                slideOutHorizontally (
                    targetOffsetX =  { -1000 },
                    animationSpec = tween(500)
                )
        },
        popEnterTransition = {
                slideInHorizontally (
                initialOffsetX = { -1000 },
                animationSpec = tween(500))
        },
        popExitTransition = {
                slideOutHorizontally (
                    targetOffsetX =  { 1000 },
                    animationSpec = tween(500)
                )
        }
    ){
        val viewModel:LoginViewModel = hiltViewModel()
        if(viewModel.state.value.succesLogin){
            LaunchedEffect(key1 = Unit){
                navController.navigate(Destinations.MainScreen.route){
                    popUpTo(Destinations.Login.route){
                        inclusive = true
                    }
                }
            }
        }else{
            LoginScreen(
                state = viewModel.state.value,
                onLogin = viewModel::login,
                onNavigateToRegister = {
                    navController.navigate(Destinations.Register.route)
                },
                onDissmisDialog = viewModel::hideErrorDialog
            )
        }
    }
}
@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.addRegister(
    navController: NavController
){
    composable(
        route = Destinations.Register.route,
        enterTransition = {
            slideInHorizontally (
                initialOffsetX = { 1000 },
                animationSpec = tween(500)
            )
        },
        exitTransition = {
            slideOutHorizontally (
                targetOffsetX =  { -1000 },
                animationSpec = tween(500)
            )
        },
        popEnterTransition = {
            slideInHorizontally (
                initialOffsetX = { -1000 },
                animationSpec = tween(500))
        },
        popExitTransition = {
            slideOutHorizontally (
                targetOffsetX =  { 1000 },
                animationSpec = tween(500)
            )
        }
    ){
        val viewModel:RegistroViewModel = hiltViewModel()
            if(viewModel.state.value.succesFirstCheck){
                viewModel.state.value.succesFirstCheck =false
                LaunchedEffect(key1 = Unit){
                    navController.navigate(Destinations.Datos.route)
                }
            }else
            {
                RegistroScreen(
                    state = viewModel.state.value,
                    onNextRegister =
                    viewModel::registerFirstCheck
                    ,
                    onBack = {
                        navController.popBackStack()
                    },
                    onDissmisDialog = viewModel::hideErrorDialog
                )
            }
    }
}
@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.addDatos(
    navController: NavController
){
    composable(
        route = Destinations.Datos.route,
        enterTransition = {
            slideInHorizontally (
                initialOffsetX = { 1000 },
                animationSpec = tween(500)
            )
        },
        exitTransition = {
            slideOutHorizontally (
                targetOffsetX =  { -1000 },
                animationSpec = tween(500)
            )
        },
        popEnterTransition = {
            slideInHorizontally (
                initialOffsetX = { -1000 },
                animationSpec = tween(500))
        },
        popExitTransition = {
            slideOutHorizontally (
                targetOffsetX =  { 1000 },
                animationSpec = tween(500)
            )
        }
    ){
        IngresoDatos()
    }
}
@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.addMain(
){
    composable(
        route = Destinations.MainScreen.route
    ){
        MainNavScreen()
    }
}



@Composable
@Preview
fun mainPreview(){
    AppTheme {
        InformacionAlimentacion()
    }
}




