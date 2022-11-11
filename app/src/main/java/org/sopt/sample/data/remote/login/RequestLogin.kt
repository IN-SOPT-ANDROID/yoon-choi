package org.sopt.sample.data.remote.login

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable   //응답객체이므로
data class RequestLogin(
    @SerialName("email")
    val id: String,
    @SerialName("password")
    val pw: String
)
