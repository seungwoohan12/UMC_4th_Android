package com.example.homework9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.homework9.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val WeatherAPI = retrofit.create(WeatherAPI::class.java)

        WeatherAPI.getWeather(37, 126, "API KEY").enqueue(object: Callback<WeatherResponse> {
            override fun onResponse(call: Call<WeatherResponse>, response: retrofit2.Response<WeatherResponse>) {
                val responseData = response.body()
                if(responseData != null) {
                    val list : List<WeatherDto> = responseData!!.weather!!
                    Log.d("Retrofit", "Response\nWeather: ${list}")
                }
                else {
                    Log.w("Retrofit", "Response Not Successful ${response.code()}")
                }
            }
            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                Log.e("Retrofit", "Error!", t)
            }
        })
    }
}