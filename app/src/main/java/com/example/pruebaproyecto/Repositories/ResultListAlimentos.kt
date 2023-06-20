package com.example.pruebaproyecto.Repositories

sealed class ResultListAlimentos<T>(
    val data: T? = null,
    val message:String? = null
){
    class Success<T>(data: T?):ResultListAlimentos<T>(data)

    class Error<T>(message: String?,data: T?=null):ResultListAlimentos<T>(data,message)

    class Loading<T>(data: T?=null):ResultListAlimentos<T>(data)

}