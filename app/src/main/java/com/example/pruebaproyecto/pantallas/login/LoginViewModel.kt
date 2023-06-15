package com.example.pruebaproyecto.pantallas.login

import android.util.Patterns
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch
import java.lang.Exception

class LoginViewModel: ViewModel() {

    val state: MutableState<LoginState> = mutableStateOf(LoginState())

    private val auth: FirebaseAuth = Firebase.auth


    fun login(email:String,password:String)
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
                auth.signInWithEmailAndPassword(email,password)
                    .addOnCompleteListener{task ->
                        if (task.isSuccessful){
                            state.value = state.value.copy(displayProgressBar = false)
                            state.value = state.value.copy(succesLogin = true)
                        }
                        else{
                            state.value = state.value.copy(displayProgressBar = false)
                            errorMessage = "${task.result}"
                            state.value = state.value.copy(succesLogin = false)
                        }
                    }

            }catch (e:Exception){
                errorMessage = "${e.message}"
                state.value = state.value.copy(succesLogin = false)
            }
        }

    }
    fun hideErrorDialog(){
        state.value = state.value.copy(
            errorMessage = ""
        )
    }





}