package com.dahlos.challengestarwars.core

import com.dahlos.challengestarwars.repository.WebService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


//object RetrofitHelper {
//
//    fun getRetrofit(): Retrofit {
//        return Retrofit.Builder()
//            .baseUrl(AppConstants.BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//    }
//}

object RetrofitClient {
    val webService by lazy {
        Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WebService::class.java)
    }
}