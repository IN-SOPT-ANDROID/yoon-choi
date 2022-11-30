package org.sopt.sample.data.remote.signup

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestSignUp(
    @SerialName("email")
    val id: String,
    val password: String,
    @SerialName("name")
    val mbti: String
)
