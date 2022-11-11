package org.sopt.sample.data.remote.login

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("api/user/signin")
    fun postLogin(
        @Body body: RequestLogin
    ): Call<ResponseLogin>

}