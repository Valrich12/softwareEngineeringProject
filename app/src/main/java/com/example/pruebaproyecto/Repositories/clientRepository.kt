package com.example.pruebaproyecto.Repositories

import com.example.pruebaproyecto.clases.ClientData
import com.google.firebase.firestore.CollectionReference
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class clientRepository
@Inject
constructor(
    private val clientDataList: CollectionReference
)
{
    fun addClientData(clientData: ClientData){
        try {
            clientDataList.document().set(clientData)
        }catch (e:Exception){
            e.printStackTrace()
        }
    }
}