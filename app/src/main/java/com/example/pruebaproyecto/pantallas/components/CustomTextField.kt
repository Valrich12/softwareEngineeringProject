package com.example.pruebaproyecto.pantallas.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.example.pruebaproyecto.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    textFieldValue : MutableState<String>,
    textLabel : String,
    textPlaceHolder : String,
    maxChar:Int?=null,
    capitalization: KeyboardCapitalization = KeyboardCapitalization.None,
    keyboardType: KeyboardType,
    keyboardActions: KeyboardActions,
    imeAction: ImeAction,
    trailingIcon: @Composable()(()-> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    Outline: Boolean = false,
    errorCheck : Boolean = false
) {
if (Outline) {
    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        value = textFieldValue.value.take(maxChar ?: 40),
        onValueChange = { textFieldValue.value = it },
        label = { Text(text = textLabel) },
        placeholder = { Text(text = textPlaceHolder) },
        trailingIcon = trailingIcon,
        keyboardOptions = KeyboardOptions(
            capitalization = capitalization,
            keyboardType = keyboardType,
            imeAction = imeAction
        ),
        keyboardActions = keyboardActions,
        visualTransformation = visualTransformation,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent,
            textColor = MaterialTheme.colorScheme.secondary,
            unfocusedLabelColor = MaterialTheme.colorScheme.secondary,
            unfocusedIndicatorColor = MaterialTheme.colorScheme.secondary,
            unfocusedTrailingIconColor = MaterialTheme.colorScheme.secondary
        )
    )
}else{
    if(errorCheck){
        TextField(
            modifier = modifier.fillMaxWidth(),
            value = textFieldValue.value.take(maxChar ?: 40),
            onValueChange = { textFieldValue.value = it },
            label = { Text(text = textLabel) },
            placeholder = { Text(text = textPlaceHolder) },
            trailingIcon = trailingIcon,
            keyboardOptions = KeyboardOptions(
                capitalization = capitalization,
                keyboardType = keyboardType,
                imeAction = imeAction
            ),
            keyboardActions = keyboardActions,
            visualTransformation = visualTransformation,
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent,
                focusedLabelColor = MaterialTheme.colorScheme.error,
                focusedIndicatorColor = MaterialTheme.colorScheme.error,
                textColor = MaterialTheme.colorScheme.error,
                unfocusedLabelColor = MaterialTheme.colorScheme.error,
                unfocusedIndicatorColor = MaterialTheme.colorScheme.error,
                unfocusedTrailingIconColor = MaterialTheme.colorScheme.error
            ),
            supportingText = {Text(text = "Las contraseñas no coinciden", color = MaterialTheme.colorScheme.error)},

        )
    }else {
        TextField(
            modifier = modifier.fillMaxWidth(),
            value = textFieldValue.value.take(maxChar ?: 40),
            onValueChange = { textFieldValue.value = it },
            label = { Text(text = textLabel) },
            placeholder = { Text(text = textPlaceHolder) },
            trailingIcon = trailingIcon,
            keyboardOptions = KeyboardOptions(
                capitalization = capitalization,
                keyboardType = keyboardType,
                imeAction = imeAction
            ),
            keyboardActions = keyboardActions,
            visualTransformation = visualTransformation,
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent,
                textColor = MaterialTheme.colorScheme.secondary,
                unfocusedLabelColor = MaterialTheme.colorScheme.secondary,
                unfocusedIndicatorColor = MaterialTheme.colorScheme.secondary,
                unfocusedTrailingIconColor = MaterialTheme.colorScheme.secondary
            )
        )
    }
}
}
@Preview
@Composable

fun TextFieldsPreview(){
    var prueba = remember { mutableStateOf("") }
    AppTheme() {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)){
            CustomTextField(
                textFieldValue = prueba,
                textLabel = "Prueba" ,
                textPlaceHolder = "Prueba",
                keyboardType = KeyboardType.Text,
                keyboardActions = KeyboardActions(
                    onDone = null,
                ),
                imeAction = ImeAction.Done,
                errorCheck = true
            )
        }
    }

}

