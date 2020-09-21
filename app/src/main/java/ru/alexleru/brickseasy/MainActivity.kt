package ru.alexleru.brickseasy

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.alexleru.brickseasy.api.RequestsService
import ru.alexleru.brickseasy.api.models.Instruction
import ru.alexleru.brickseasy.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    var instructions = ArrayList<Instruction>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        APP_ACTIVITY = this
        getResponse()
    }


    private fun getResponse() {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL_REQUEST)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(RequestsService::class.java)
        val call = service.getInstructions()
            call.enqueue(object : Callback<List<Instruction>> {
                override fun onResponse(
                    call: Call<List<Instruction>>,
                    response: Response<List<Instruction>>
                ) {
                    instructions.addAll(response.body()!!)
                }

                override fun onFailure(call: Call<List<Instruction>>, t: Throwable) {
                    Log.d("text", t.message)
                }

            })
    }
}