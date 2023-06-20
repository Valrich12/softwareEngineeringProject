package com.example.pruebaproyecto.pantallas.MainNavScreen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.pruebaproyecto.Repositories.clientRepository
import com.example.pruebaproyecto.clases.ClientData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainNavViewModel
@Inject
constructor(
    private val clientRepository: clientRepository
): ViewModel(){
    private val _state: MutableState<MainNavState> = mutableStateOf(MainNavState())
    val state: State<MainNavState> = _state
    private val auth: FirebaseAuth = Firebase.auth

    init {
        getClientData()
    }

    fun getClientData(){
        var clientData: ClientData
        _state.value = _state.value.copy(isLoading = true)
        if(auth.uid == null){
            _state.value=_state.value.copy(clientData = ClientData())
        }
        else{
            clientData =  clientRepository.getClientData("3Fj1CiTWPRZsum8cFKgblsLQbZK2")
            _state.value = _state.value.copy(clientData = clientData)
            _state.value = _state.value.copy(isLoading = false)
        }


    }
}