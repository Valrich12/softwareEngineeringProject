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
import com.example.pruebaproyecto.ui.theme.AppTheme

@Composable
fun IngresoDatos() {

    val edad = remember { mutableStateOf("") }
    val estatura = remember { mutableStateOf("") }
    val radioOptions = listOf("Masculino", "Femenino")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[0]) }

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
                        onClick = { /*TODO*/ })
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
                        .fillMaxSize()
                        .constrainAs(form){
                                    top.linkTo(desc.bottom)
                                    bottom.linkTo(nextButton.top)
                        },
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
                                        onNext = null
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
                                        onNext = null
                                    ),
                                    imeAction = ImeAction.Next,
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
                        Text(text = selectedOption)

                    }

                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .constrainAs(nextButton){
                                     bottom.linkTo(parent.bottom)
                        },
                    contentAlignment = Alignment.CenterEnd
                ) {
                    FloatingActionButton(
                        modifier = Modifier
                            .size(70.dp),

                        onClick = { /*TODO*/ }
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
}
@Composable
@Preview
fun DatosPreview(){
    AppTheme {
        IngresoDatos()
    }
}