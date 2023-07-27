package com.eco.examen3_apis.repository

import com.eco.examen3_apis.model.DigimonCard
import com.eco.examen3_apis.retrofit.DigimonApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DigimonRepository {
    private val digimonApi = Retrofit.Builder()
        .baseUrl("https://digimoncard.io/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(DigimonApi::class.java)

    suspend fun getAllCards(): List<DigimonCard> {
        return digimonApi.getAllCards()
    }
}