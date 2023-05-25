package com.example.pruebaproyecto.pantallas.login



import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.pruebaproyecto.R
import com.example.pruebaproyecto.ui.theme.AppTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.example.pruebaproyecto.pantallas.components.CustomTextField


@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun LoginScreen(){
    val emailValue      = rememberSaveable{ mutableStateOf("") }
    val passwordValue   = rememberSaveable{ mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }
    val focusManager    = LocalFocusManager.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),

    ){
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp),
                contentAlignment = Alignment.Center,
            )
            {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Login Image",
                    modifier = Modifier
                        .size(200.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Inside

                )
            }


        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            ConstraintLayout{
                val surface = createRef()
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(400.dp)
                        .constrainAs(surface) {
                            bottom.linkTo(parent.bottom)
                        },
                    color = MaterialTheme.colorScheme.background,
                    shape = RoundedCornerShape(
                        topStartPercent = 8,
                        topEndPercent = 8
                    )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.SpaceEvenly
                    ) {

                        Text(
                            text =  "Bienvenido",
                            style = MaterialTheme.typography.headlineLarge,
                            color = MaterialTheme.colorScheme.primary,
                        )
                        Text(
                            text =  "Ingresar",
                            style = MaterialTheme.typography.headlineMedium.copy(
                                fontWeight = FontWeight.Thin
                            ),
                            color = MaterialTheme.colorScheme.primary,
                        )
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            CustomTextField(
                                textFieldValue = emailValue,
                                textLabel = "Email" ,
                                textPlaceHolder = "email@ejemplo.com" ,
                                keyboardType = KeyboardType.Email ,
                                keyboardActions = KeyboardActions(
                                    onNext = {
                                        focusManager.moveFocus(FocusDirection.Down)
                                    }
                                ) ,
                                imeAction = ImeAction.Next
                            )
                            CustomTextField(
                                textFieldValue = passwordValue,
                                textLabel = "Contraseña" ,
                                textPlaceHolder = "Contraseña" ,
                                keyboardType = KeyboardType.Password,
                                keyboardActions = KeyboardActions(
                                    onDone =  {
                                        focusManager.clearFocus()
                                    }
                                ) ,
                                imeAction = ImeAction.Done,
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

                        }
                        Spacer(modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp))
                        Column(
                            modifier = Modifier
                                .fillMaxWidth().height(70.dp),

                            ) {
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(160.dp)
                            ) {
                                Column(
                                    modifier = Modifier.fillMaxHeight(),
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    TextButton(
                                        onClick = { /*TODO*/ }
                                    ) {
                                        Text(text = "Crear una Cuenta")
                                    }
                                }
                                Column() {
                                    FloatingActionButton(
                                        modifier = Modifier
                                            .size(72.dp),

                                        onClick = { /*TODO*/ }
                                    ){
                                        Icon(
                                            modifier = Modifier.size(42.dp),
                                            imageVector = Icons.Default.ArrowForward,
                                            contentDescription = "forward Icon"
                                        )

                                    }
                                }
                            }


                        }

                    }


                }


            }
        }
    }
}

@Composable
@Preview
fun loginPreview(){
    AppTheme {
        LoginScreen()
    }
}