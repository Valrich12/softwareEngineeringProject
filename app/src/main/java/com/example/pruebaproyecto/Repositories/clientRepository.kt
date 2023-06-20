package com.example.pruebaproyecto.Repositories

import com.example.pruebaproyecto.clases.ClientData
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.ktx.toObject

import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton


@Singleton
class clientRepository
@Inject
constructor(
   @Named("clientData") private val clientDataList: CollectionReference
)
{
    fun addClientData(clientData: ClientData){
        try {
            clientDataList.document(clientData.clientId+"_Data").set(clientData)
        }catch (e:Exception){
            e.printStackTrace()
        }
    }

    fun getClientData(clientId:String):ClientData{

        try {
            var clientData = ClientData()
            clientDataList.document("3Fj1CiTWPRZsum8cFKgblsLQbZK2_Data").get().addOnSuccessListener { documentSnapshot ->
                 clientData = documentSnapshot.toObject<ClientData>()!!
            }
            return  clientData

        }catch (e:Exception){
            e.printStackTrace()
            return ClientData()
        }
    }


}