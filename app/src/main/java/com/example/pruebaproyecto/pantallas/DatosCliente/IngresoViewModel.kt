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


    fun signIn(edad:String,
               estatura:String,
               peso:String,
               sexo:String,
               name:String,
               apellido:String,
               domicilio:String,
               email:String,
               password:String) =
        viewModelScope.launch{
            var errorMessage = ""
            if(edad.isBlank() || estatura.isBlank()||peso.isBlank()||sexo.isBlank()) {
                errorMessage="Por favor llene los campos"
            } else
                if(edad.toInt()>120 || estatura.toInt()>300||peso.toInt()>500){
                errorMessage="Por favor introduzca valores validos"
            }
            if (errorMessage != ""){
                state.value = state.value.copy(errorMessage = errorMessage )
            }
            else{
                try {
                    //Creamos el usueario y despues lo loggeamos
                    state.value = state.value.copy(displayProgressBar = true)
                    val result = withContext(Dispatchers.IO) {
                        auth.createUserWithEmailAndPassword(email, password).await()
                    }
                    val result2 = withContext(Dispatchers.IO){
                        auth.signInWithEmailAndPassword(email,password).await()
                    }
                    // User creation successful
                    state.value = state.value.copy(displayProgressBar = false)
                    state.value = state.value.copy(succesRegister = true)
                } catch (e: Exception) {
                    // User creation failed
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