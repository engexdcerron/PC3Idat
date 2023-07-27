package com.eco.examen3_apis.retrofit

import com.eco.examen3_apis.model.DigimonCard
import retrofit2.http.GET

interface DigimonApi {
    @GET("api-public/getAllCards.php?sort=name&series=Digimon%20Card%20Game&sortdirection=asc")
    suspend fun getAllCards(): List<DigimonCard>
}