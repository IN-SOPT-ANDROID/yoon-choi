package org.sopt.sample.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable

data class RepoData(
    @SerialName("avatar")
    val image: String,
    @SerialName("email")
    val description: String,
    @SerialName("first_name")
    val title: String,
    val id: Int,
    val last_name: String
)
