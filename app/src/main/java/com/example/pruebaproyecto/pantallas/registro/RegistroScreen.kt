package com.example.pruebaproyecto.pantallas.registro

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.pruebaproyecto.pantallas.components.CustomTextField
import com.example.pruebaproyecto.pantallas.components.EventDialog
import com.example.pruebaproyecto.ui.theme.AppTheme
import com.example.pruebaproyecto.ui.theme.md_theme_light_primaryContainer

@Composable
fun RegistroScreen(
    state: RegisterState,
    onNextRegister : (String,String,String,String,String,String) -> Unit,
    onBack : () -> Unit,
    onDissmisDialog:() ->Unit
) {
    val nameValue = remember{mutableStateOf("")}
    val apellidoValue = remember{mutableStateOf("")}
    val domicilioValue = remember{mutableStateOf("")}
    val correoValue = remember{mutableStateOf("")}
    val passwordValue = remember{mutableStateOf("")}
    val confirmValue = remember{mutableStateOf("")}
    var passwordVisibility by remember { mutableStateOf(false) }
    var confirmVisibility by remember { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            ConstraintLayout() {
                val (title,inputs,button) = createRefs()

             Row (
                    modifier = Modifier.constrainAs(title){},
                    verticalAlignment =  Alignment.CenterVertically
             ){
                 IconButton(
                     onClick = {
                         onBack()
                     })
                 {
                     Icon(
                         imageVector = Icons.Default.ArrowBack,
                         contentDescription = "Back Icon",
                         tint = MaterialTheme.colorScheme.primary
                     )
                 }

                 Text(
                     text = "Crea una Cuenta",
                     style = MaterialTheme.typography.headlineMedium,
                     color = MaterialTheme.colorScheme.onBackground
                 )
                }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
                    .constrainAs(inputs) {
                        top.linkTo(title.bottom, margin = 70.dp)
                    },
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                CustomTextField(
                    textFieldValue = nameValue,
                    textLabel = "Nombre",
                    textPlaceHolder = "Nombre",
                    keyboardType = KeyboardType.Text,
                    keyboardActions = KeyboardActions(
                        onNext = {
                            focusManager.moveFocus(FocusDirection.Down)
                        }
                    ),
                    imeAction = ImeAction.Next
                )
                CustomTextField(
                    textFieldValue = apellidoValue,
                    textLabel = "Apellido",
                    textPlaceHolder = "Apellido",
                    keyboardType = KeyboardType.Text,
                    keyboardActions = KeyboardActions(
                        onNext = {
                            focusManager.moveFocus(FocusDirection.Down)
                        }
                    ),
                    imeAction = ImeAction.Next
                )
                CustomTextField(
                    textFieldValue = domicilioValue,
                    textLabel = "Domicilio",
                    textPlaceHolder = "Domicilio",
                    keyboardType = KeyboardType.Text,
                    keyboardActions = KeyboardActions(
                        onNext = {
                            focusManager.moveFocus(FocusDirection.Down)
                        }
                    ),
                    imeAction = ImeAction.Next
                )
                CustomTextField(
                    textFieldValue = correoValue,
                    textLabel = "Email",
                    textPlaceHolder = "Email",
                    keyboardType = KeyboardType.Email,
                    keyboardActions = KeyboardActions(
                        onNext = {
                            focusManager.moveFocus(FocusDirection.Down)
                        }
                    ),
                    imeAction = ImeAction.Next
                )
                CustomTextField(
                    textFieldValue = passwordValue,
                    textLabel = "Contraseña" ,
                    textPlaceHolder = "Contraseña" ,
                    keyboardType = KeyboardType.Password,
                    keyboardActions = KeyboardActions(
                        onNext =  {
                            focusManager.moveFocus(FocusDirection.Down)
                        }
                    ) ,
                    imeAction = ImeAction.Next,
                    trailingIcon = {
                        IconButton(
                            onClick = {
                                passwordVisibility = !passwordVisibility
                            }
                        ) {
                            Icon(
                                imageVector = if(passwordVisibility){
                                    Icons.Default.Visibility
                                }else{
                                    Icons.Default.VisibilityOff
                                },
                                contentDescription = "IconoPassword"
                            )
                        }
                    },
                    visualTransformation = if(passwordVisibility){
                        VisualTransformation.None
                    }else{
                        PasswordVisualTransformation()
                    }
                )

                CustomTextField(
                    textFieldValue = confirmValue,
                    textLabel = "Confirmar Contraseña" ,
                    textPlaceHolder = "Contraseña" ,
                    keyboardType = KeyboardType.Password,
                    keyboardActions = KeyboardActions(
                        onDone =  {
                            focusManager.clearFocus()
                            onNextRegister(
                                nameValue.value,
                                apellidoValue.value,
                                domicilioValue.value,
                                correoValue.value,
                                passwordValue.value,
                                confirmValue.value)
                        }
                    ) ,
                    imeAction = ImeAction.Done,
                    trailingIcon = {
                        IconButton(
                            onClick = {
                                confirmVisibility = !confirmVisibility
                            }
                        ) {
                            Icon(
                                imageVector = if(confirmVisibility){
                                    Icons.Default.Visibility
                                }else{
                                    Icons.Default.VisibilityOff
                                },
                                contentDescription = "IconoPassword"
                            )
                        }
                    },
                    visualTransformation = if(confirmVisibility){
                        VisualTransformation.None
                    }else{
                        PasswordVisualTransformation()
                    },
                    errorCheck = passwordValue.value != confirmValue.value
                )

            }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .constrainAs(button) {
                            top.linkTo(inputs.bottom, margin = 70.dp)
                        },
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Spacer(modifier = Modifier.height(16.dp))
                    ElevatedButton(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {
                                onNextRegister(
                                    nameValue.value,
                                    apellidoValue.value,
                                    domicilioValue.value,
                                    correoValue.value,
                                    passwordValue.value,
                                    confirmValue.value
                                )},
                        colors = ButtonDefaults.elevatedButtonColors(
                            containerColor = md_theme_light_primaryContainer,
                            contentColor = Color.Black
                        )
                        ) {
                        Text("Siguiente")
                    }
                }
            }
        }
    }
    if(state.errorMessage != ""){
        EventDialog(errorMessage = state.errorMessage, onDissmis = onDissmisDialog)
    }
}

