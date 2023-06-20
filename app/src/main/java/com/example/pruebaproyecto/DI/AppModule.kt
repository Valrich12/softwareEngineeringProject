package com.example.pruebaproyecto.DI


import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideFirestoreInstance() = FirebaseFirestore.getInstance()

    @Provides
    @Singleton
    @Named("clientData")
    fun provideClientDataList(
        firestore: FirebaseFirestore
    ) = firestore.collection("clientData")

    @Provides
    @Singleton
    @Named("listAlimentos")
    fun provideAlimentosList(
        firestore: FirebaseFirestore
    ) = firestore.collection("listAlimentos")


}