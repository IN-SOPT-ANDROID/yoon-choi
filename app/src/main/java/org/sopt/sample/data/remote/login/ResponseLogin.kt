package org.sopt.sample.data.remote.login

import kotlinx.serialization.Serializable

@Serializable
data class ResponseLogin(
    val message: String,
    val status: Int,
    val result: Result

) {
    @Serializable
    data class Result(
        val id: Int,
        val name: String?,
        val profileImage: String?,
        val bio: String?,
        val email: String,
        val password: String
    )
}