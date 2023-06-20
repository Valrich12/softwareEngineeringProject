package com.example.pruebaproyecto.pantallas.MainNavScreen

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pruebaproyecto.Repositories.ResultClientData
import com.example.pruebaproyecto.Repositories.ResultListAlimentos
import com.example.pruebaproyecto.Repositories.alimentosRepository
import com.example.pruebaproyecto.Repositories.clientRepository
import com.example.pruebaproyecto.clases.ClientData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainNavViewModel
@Inject
constructor(
    private val clientRepository: clientRepository,
    private val alimentosRepository: alimentosRepository
): ViewModel(){
    private val _state: MutableState<MainNavState> = mutableStateOf(MainNavState())
    val state: State<MainNavState> = _state
    val auth: FirebaseAuth = Firebase.auth

    init {
        getClientData()
        getlistAlimentos()
    }

    fun getClientData(){
        Log.d("ChecarUID", auth.uid.toString());
        clientRepository.getClientData(auth.uid.toString()).onEach {result ->
            when(result){
                is ResultClientData.Error -> {
                    _state.value = MainNavState(error = result.message?:"Error Inesperado")
                }
                is ResultClientData.Loading -> {
                    _state.value = MainNavState(isLoading = true)
                }
                is ResultClientData.Success -> {
                    _state.value = _state.value.copy(clientData = result.data?: ClientData())
                }
            }
        }.launchIn(viewModelScope)

    }
    fun getlistAlimentos(){
        Log.d("ChecarUID", auth.uid.toString());
        alimentosRepository.getListAlimentos().onEach {result ->
            when(result){
                is ResultListAlimentos.Error -> {
                    _state.value = MainNavState(error = result.message?:"Error Inesperado")
                }
                is ResultListAlimentos.Loading -> {
                    _state.value = MainNavState(isLoading = true)
                }
                is ResultListAlimentos.Success -> {
                    _state.value = _state.value.copy(listAlimentos = result.data?: emptyList())
                }
            }
        }.launchIn(viewModelScope)

    }
}