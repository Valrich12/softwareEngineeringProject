package com.example.pruebaproyecto.Repositories

sealed class ResultClientData<T>(
    val data: T? = null,
    val message:String? = null
){
    class Success<T>(data: T?):ResultClientData<T>(data)

    class Error<T>(message: String?,data: T?=null):ResultClientData<T>(data,message)

    class Loading<T>(data: T?=null):ResultClientData<T>(data)

}
