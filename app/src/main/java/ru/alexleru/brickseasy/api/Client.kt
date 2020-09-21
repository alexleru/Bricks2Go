package ru.alexleru.brickseasy.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.alexleru.brickseasy.BASE_URL_REQUEST

object Client {
    val getClient: RequestsService
        get() {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL_REQUEST)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(RequestsService::class.java)
        }
}