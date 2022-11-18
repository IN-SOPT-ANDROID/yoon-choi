package org.sopt.sample.data.remote

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

object ApiFactory {
    val retrofitAuth: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("http://3.39.169.52:3000/")
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .build()
    }
    val retrofitUser: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://reqres.in/api/")
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .build()
    }

    inline fun <reified T> create(): T = retrofitAuth.create<T>(T::class.java)
}

object ServicePool {
    val authService = ApiFactory.create<AuthService>()
    val reqresService: HomeService = ApiFactory.retrofitUser.create(HomeService::class.java)
}
