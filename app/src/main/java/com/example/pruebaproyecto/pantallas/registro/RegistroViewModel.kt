package com.example.pruebaproyecto.pantallas.registro

import android.util.Patterns
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel


class RegistroViewModel: ViewModel() {

    var state: MutableState<RegisterState> = mutableStateOf(RegisterState())

    fun registerFirstCheck(name:String,apellido:String,domicilio:String,email:String,password:String,confirmPass:String)
        {
            var errorMessage = ""
            if(name.isBlank()||apellido.isBlank()||domicilio.isBlank()||email.isBlank() || password.isBlank()||confirmPass.isBlank()) {
                errorMessage="Por favor llene todos los campos"
            } else
                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                errorMessage="El email no esta en un formato correcto"
            }else
                if(password != confirmPass){
                    errorMessage="Las contraseñas no coinciden"
                }
            if (errorMessage != ""){
                state.value = state.value.copy(errorMessage = errorMessage )
            }else{
                state.value = state.value.copy(name = name, apellido=apellido, domicilio = domicilio,email=email,password=password)
                state.value = state.value.copy(succesFirstCheck = true)
            }
        }
    fun hideErrorDialog(){
        state.value = state.value.copy(
            errorMessage = ""
        )
    }





}