package com.example.pruebaproyecto.Repositories


import com.example.pruebaproyecto.clases.ClientData
import com.google.firebase.firestore.CollectionReference
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await



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

    fun getClientData(clientId:String):Flow<ResultClientData<ClientData>> = flow{
        try {
            emit(ResultClientData.Loading())
            val clientData = clientDataList.document(clientId+"_Data").get().await()
            val clientDataOb = clientData.toObject(ClientData::class.java)
            emit(ResultClientData.Success(data = clientDataOb))

        }catch (e: Exception){
            emit(ResultClientData.Error(message = e.localizedMessage?:"Error Desconocido"))
        }


    }




}