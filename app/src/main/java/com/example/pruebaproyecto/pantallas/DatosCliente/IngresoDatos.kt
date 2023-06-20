package com.example.pruebaproyecto.pantallas.DatosCliente

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.pruebaproyecto.pantallas.components.CustomTextField
import com.example.pruebaproyecto.pantallas.components.EventDialog
import com.example.pruebaproyecto.ui.theme.AppTheme

@Composable
fun IngresoDatos(
    state: IngresoState,
    onDissmisDialog:() -> Unit,
    onRegister:(String,String,String,String,String,String,String,String,String,String) -> Unit,
    onBack:()->Unit,
    name:String,
    apellido:String,
    domicilio:String,
    email:String,
    password:String
) {

    val edad = remember { mutableStateOf("") }
    val estatura = remember { mutableStateOf("") }
    val peso = remember{ mutableStateOf("") }

    val radioOptions = listOf("Masculino", "Femenino")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[0]) }

    val radioOptions2 = listOf("Mantener","Bajar","Aumentar")
    val (selectedOption2, onOptionSelected2) = remember { mutableStateOf(radioOptions2[0]) }

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
        ) {
            ConstraintLayout() {
                val (titulo,desc,form,nextButton) = createRefs()
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.constrainAs(titulo){}
                ) {
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
                        text = "Ingresa tus Datos",
                        style = MaterialTheme.typography.headlineMedium,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "Estos datos se utilizaran para realizar las recomendaciones",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Light
                    ),
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.constrainAs(desc){
                        top.linkTo(titulo.bottom)
                    }
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(600.dp)
                        .constrainAs(form) {
                            top.linkTo(desc.bottom)
                            bottom.linkTo(nextButton.top)
                        }
                        .background(MaterialTheme.colorScheme.background),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row(

                        ) {
                            Box(
                                modifier = Modifier
                                    .width(80.dp)
                            ) {
                                CustomTextField(
                                    textFieldValue = edad,
                                    textLabel = "Edad",
                                    textPlaceHolder = "Edad",
                                    keyboardType = KeyboardType.Decimal,
                                    keyboardActions = KeyboardActions(
                                        onNext = {
                                            focusManager.moveFocus(FocusDirection.Next)
                                        }
                                    ),
                                    imeAction = ImeAction.Next,
                                    Outline = true
                                )
                            }
                            Spacer(modifier = Modifier.width(40.dp))
                            Box(
                                modifier = Modifier
                                    .width(100.dp)
                            ) {
                                CustomTextField(
                                    textFieldValue = estatura,
                                    textLabel = "Estatura",
                                    textPlaceHolder = "cm",
                                    keyboardType = KeyboardType.Decimal,
                                    keyboardActions = KeyboardActions(
                                        onNext = {
                                            focusManager.moveFocus(FocusDirection.Next)
                                        }
                                    ),
                                    imeAction = ImeAction.Next,
                                    Outline = true
                                )
                            }
                            Spacer(modifier = Modifier.width(40.dp))
                            Box(
                                modifier = Modifier
                                    .width(80.dp)
                            ) {
                                CustomTextField(
                                    textFieldValue = peso,
                                    textLabel = "Peso",
                                    textPlaceHolder = "Kg",
                                    keyboardType = KeyboardType.Decimal,
                                    keyboardActions = KeyboardActions(
                                        onDone =  { focusManager.clearFocus()}
                                    ),
                                    imeAction = ImeAction.Done,
                                    Outline = true
                                )
                            }
                        }
                        Spacer(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                        )
                        Text(
                            text = "Sexo",
                            style = MaterialTheme.typography.headlineSmall.copy(
                                fontWeight = FontWeight.Light
                            ),
                            color = MaterialTheme.colorScheme.primary
                        )
                        Row(Modifier.selectableGroup()) {
                            radioOptions.forEach { text ->
                                Row(
                                    Modifier
                                        .height(56.dp)
                                        .selectable(
                                            selected = (text == selectedOption),
                                            onClick = { onOptionSelected(text) },
                                            role = Role.RadioButton
                                        )
                                        .padding(horizontal = 16.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    RadioButton(
                                        selected = (text == selectedOption),
                                        onClick = null // null recommended for accessibility with screenreaders
                                    )
                                    Text(
                                        text = text,
                                        style = MaterialTheme.typography.bodyLarge,
                                        color = MaterialTheme.colorScheme.onBackground,
                                        modifier = Modifier.padding(start = 16.dp)
                                    )
                                }
                            }
                        }
                        Spacer(modifier = Modifier.fillMaxWidth().height(50.dp))
                        Text(
                            text = "¿Qué es lo que desea lograr?",
                            style = MaterialTheme.typography.headlineSmall.copy(
                                fontWeight = FontWeight.Light
                            ),
                            color = MaterialTheme.colorScheme.primary
                        )
                        Column(Modifier.selectableGroup()) {
                            radioOptions2.forEach { text ->
                                Row(
                                    Modifier
                                        .height(56.dp)
                                        .selectable(
                                            selected = (text == selectedOption2),
                                            onClick = { onOptionSelected2(text) },
                                            role = Role.RadioButton
                                        )
                                        .padding(horizontal = 16.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    RadioButton(
                                        selected = (text == selectedOption2),
                                        onClick = null // null recommended for accessibility with screenreaders
                                    )
                                    Text(
                                        text = text+" Peso",
                                        style = MaterialTheme.typography.bodyLarge,
                                        color = MaterialTheme.colorScheme.onBackground,
                                        modifier = Modifier
                                    )
                                }
                            }
                        }
                    }

                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .constrainAs(nextButton) {
                            bottom.linkTo(parent.bottom)
                        },
                    contentAlignment = Alignment.CenterEnd
                ) {
                    if (state.displayProgressBar){
                        CircularProgressIndicator(
                            modifier = Modifier.size(70.dp),
                            color = MaterialTheme.colorScheme.primary,
                            strokeWidth = 6.dp
                        )
                    }else{
                        FloatingActionButton(
                            modifier = Modifier
                                .size(70.dp),

                            onClick = {
                                onRegister(edad.value,estatura.value,peso.value,selectedOption,selectedOption2,name,apellido,domicilio,email,password)
                            }
                        ) {
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
        if(state.errorMessage != ""){
            EventDialog(errorMessage = state.errorMessage, onDissmis = onDissmisDialog)

        }

    }
}
