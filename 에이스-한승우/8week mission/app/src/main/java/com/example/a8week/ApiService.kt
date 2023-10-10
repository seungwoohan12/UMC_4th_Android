package com.example.a8week

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("app/users/email-check") // 메소드 쓰기 때문에 get
    fun getCheckEmail(
        @Query("email")email: String
    ): Call<Response>
} //api 호출하는 함수 다 만듬