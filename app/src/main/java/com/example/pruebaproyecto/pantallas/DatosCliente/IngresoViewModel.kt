package com.example.pruebaproyecto.pantallas.DatosCliente

import android.util.Patterns
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import java.lang.Exception

class IngresoViewModel: ViewModel() {

    val state: MutableState<IngresoState> = mutableStateOf(IngresoState())

    private val auth: FirebaseAuth = Firebase.auth


    fun signIn(email:String,password:String)
    = viewModelScope.launch {
        var errorMessage = ""
        if(email.isBlank() || password.isBlank()) {
            errorMessage="Por favor llene los campos"
        } else
            if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            errorMessage="El email no esta en un formato correcto"
        }
        if (errorMessage != ""){
            state.value = state.value.copy(errorMessage = errorMessage )
        }
        else{
            try {
                state.value = state.value.copy(displayProgressBar = true)
                val result = withContext(Dispatchers.IO){
                    auth.signInWithEmailAndPassword(email,password).await()
                }
                state.value = state.value.copy(displayProgressBar = false)
                state.value = state.value.copy(succesLogin = true)
            }catch (e:Exception){
                errorMessage = "No se pudieron verificar tus credenciales o no hay una conexión a internet disponible"
                state.value = state.value.copy(displayProgressBar = false)
                state.value = state.value.copy(errorMessage = errorMessage )
            }
        }

    }
    fun hideErrorDialog(){
        state.value = state.value.copy(
            errorMessage = ""
        )
    }





}