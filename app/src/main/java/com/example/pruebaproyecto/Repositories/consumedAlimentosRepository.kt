package com.example.pruebaproyecto.Repositories

import com.example.pruebaproyecto.clases.AlimentoConsumed
import com.example.pruebaproyecto.clases.ClientData
import com.google.firebase.firestore.CollectionReference
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import java.time.LocalTime
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Singleton
class consumedAlimentosRepository
@Inject
constructor(
    @Named("consumedAlimentos") private val listAlimentos: CollectionReference
)
{
    fun addConsumedAlimentos(alimento: AlimentoConsumed){
        try {
            listAlimentos.document(alimento.alimento.nombre+"_"+alimento.clientId+"_"+alimento.date).set(alimento)
        }catch (e:Exception){
            e.printStackTrace()
        }
    }
    fun getConsumedAlimentos(clientData: ClientData): Flow<ResultListAlimentos<List<AlimentoConsumed>>> = flow{
        try {
            emit(ResultListAlimentos.Loading<List<AlimentoConsumed>>())
            val consumedAlimentos = listAlimentos.whereEqualTo("clientId",clientData.clientId).get().await().map {document->
                document.toObject(AlimentoConsumed::class.java)
            }
            emit(ResultListAlimentos.Success(data = consumedAlimentos))

        }catch (e:Exception){
            emit(ResultListAlimentos.Error(message = e.localizedMessage?:"Error Desconocido"))
        }

    }
    fun deleteConsumedAlimentos(alimento: AlimentoConsumed){

        try {
            val docref = listAlimentos.document(alimento.alimento.nombre+"_"+alimento.clientId+"_"+alimento.date)
            docref.delete()
        }catch (e: Exception){
            e.printStackTrace()        }
    }
}