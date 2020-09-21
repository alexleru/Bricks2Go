package ru.alexleru.brickseasy.api

import retrofit2.Call
import retrofit2.http.GET
import ru.alexleru.brickseasy.api.models.Instruction

interface RequestsService {
    @GET("instructions")
    fun getInstructions(): Call<List<Instruction>>
}