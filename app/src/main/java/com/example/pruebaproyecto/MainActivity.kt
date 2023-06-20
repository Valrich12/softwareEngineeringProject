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
import com.example.pruebaproyecto.pantallas.DatosAlimentacion.ListaAlimentos
import com.example.pruebaproyecto.pantallas.DatosCliente.IngresoDatos
import com.example.pruebaproyecto.pantallas.DatosCliente.IngresoViewModel
import com.example.pruebaproyecto.pantallas.InformacionAlimentacion.InformacionAlimentacion
import com.example.pruebaproyecto.pantallas.MainNavScreen.MainNavScreen
import com.example.pruebaproyecto.pantallas.MainNavScreen.MainNavViewModel
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
        if(viewModel.state.value.succesLogin || viewModel.auth.currentUser!=null){
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
        val name        = viewModel.state.value.name
        val apellido    = viewModel.state.value.apellido
        val domicilio   = viewModel.state.value.domicilio
        val email       = viewModel.state.value.email
        val password    = viewModel.state.value.password

        if(viewModel.state.value.succesFirstCheck){
            viewModel.state.value.succesFirstCheck =false
            LaunchedEffect(key1 = Unit){
                navController.navigate(
                    Destinations.Datos.route +"/$name"+"/$apellido"+"/$domicilio"+"/$email"+"/$password"
                )
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
        route = Destinations.Datos.route+"/{name}"+"/{apellido}"+"/{domicilio}"+"/{email}"+"/{password}",
        arguments = Destinations.Datos.arguments,
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
    ){backStackEntry->
        val name = backStackEntry.arguments?.getString("name")?:""
        val apellido = backStackEntry.arguments?.getString("apellido")?:""
        val domicilio = backStackEntry.arguments?.getString("domicilio")?:""
        val email = backStackEntry.arguments?.getString("email")?:""
        val password = backStackEntry.arguments?.getString("password")?:""
        val viewModel:IngresoViewModel = hiltViewModel()
        if(viewModel.state.value.succesRegister){
            LaunchedEffect(key1 = Unit){
                navController.navigate(Destinations.MainScreen.route){
                    popUpTo(Destinations.Login.route){
                        inclusive = true
                    }
                }
            }
        }else{
            IngresoDatos(
                name = name,
                apellido = apellido,
                domicilio = domicilio,
                email = email,
                password = password,
                state = viewModel.state.value,
                onRegister = viewModel::signIn
                ,
                onDissmisDialog = viewModel::hideErrorDialog,
                onBack = {
                    navController.popBackStack()
                }
            )
        }

    }
}
@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.addMain(
){
    composable(
        route = Destinations.MainScreen.route
    ){
        val viewModel:MainNavViewModel = hiltViewModel()
        val state = viewModel.state.value
        MainNavScreen(state = state)
    }
}







