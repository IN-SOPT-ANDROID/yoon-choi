package org.sopt.sample.data.remote

import org.sopt.sample.data.remote.login.RequestLogin
import org.sopt.sample.data.remote.login.ResponseLogin
import org.sopt.sample.data.remote.signup.RequestSignUp
import org.sopt.sample.data.remote.signup.ResponseSignUp
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("api/user/signin")
    fun postLogin(
        @Body body: RequestLogin
    ): Call<ResponseLogin>

    @POST("api/user/signup")
    fun postSignUp(
        @Body body: RequestSignUp
    ): Call<ResponseSignUp>
}