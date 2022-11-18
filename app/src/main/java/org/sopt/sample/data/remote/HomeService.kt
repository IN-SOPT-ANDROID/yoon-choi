package org.sopt.sample.data.remote

import org.sopt.sample.data.remote.home.ResponseHomeUser
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface HomeService {

    @GET("users")
    fun GetUser(
        @Query("page") page: Int
    ): Call<ResponseHomeUser>
}