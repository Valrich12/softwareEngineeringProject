package com.example.pruebaproyecto.Repositories

import com.example.pruebaproyecto.clases.Alimento
import com.google.firebase.firestore.CollectionReference
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Singleton
class alimentosRepository
@Inject
constructor(
    @Named("listAlimentos") private val listAlimentos:CollectionReference
)
{
    fun getListAlimentos(): Flow<ResultListAlimentos<List<Alimento>>> = flow{
        try {
            emit(ResultListAlimentos.Loading<List<Alimento>>())
            val listAlimento = listAlimentos.get().await().map {document->
                document.toObject(Alimento::class.java)
            }
            emit(ResultListAlimentos.Success(data = listAlimento))

        }catch (e:Exception){
            emit(ResultListAlimentos.Error(message = e.localizedMessage?:"Error Desconocido"))
        }

    }
}