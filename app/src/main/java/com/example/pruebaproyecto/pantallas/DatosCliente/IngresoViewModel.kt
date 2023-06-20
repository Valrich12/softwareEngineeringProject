package com.example.pruebaproyecto.pantallas.DatosCliente


import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pruebaproyecto.Repositories.clientRepository
import com.example.pruebaproyecto.clases.ClientData
import com.example.pruebaproyecto.clases.Recomendation
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Named


@HiltViewModel
class IngresoViewModel
    @Inject
    constructor(
        private val clientRepository: clientRepository,
    )
    : ViewModel() {

    val state: MutableState<IngresoState> = mutableStateOf(IngresoState())

    private val auth = Firebase.auth


    fun signIn(edad:String,
               estatura:String,
               peso:String,
               sexo:String,
               opcion:String,
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

                    //Creamos el usuario y despues lo loggeamos
                    state.value = state.value.copy(displayProgressBar = true)
                    val result = withContext(Dispatchers.IO) {
                        auth.createUserWithEmailAndPassword(email, password).await()
                    }
                    val result2 = withContext(Dispatchers.IO){
                        auth.signInWithEmailAndPassword(email,password).await()
                    }
                    auth.uid?.let { addClientData(it,edad.toFloat(),estatura.toFloat(),peso.toFloat(),sexo,opcion,name,apellido) }


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

    fun addClientData(
        clientId:String,
        edad:Float,
        estatura:Float,
        peso:Float,
        sexo:String,
        opcion: String,
        name:String,
        apellido:String,
    ){
        val recomendation = Recomendation(clientId)
        recomendation.createRecomendation(edad,sexo,peso,estatura,opcion)

        val clientData = ClientData(
            clientId,
            edad,
            estatura,
            peso,
            sexo,
            opcion,
            name,
            apellido,
            recomendation.carbs,
            recomendation.grasa,
            recomendation.proteina,
        )
        clientRepository.addClientData(clientData)
    }




}