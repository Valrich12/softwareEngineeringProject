package com.example.pruebaproyecto.pantallas.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation

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
    visualTransformation: VisualTransformation = VisualTransformation.None
) {

    TextField(
        modifier = modifier.fillMaxWidth(),
        value = textFieldValue.value.take(maxChar?:40),
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