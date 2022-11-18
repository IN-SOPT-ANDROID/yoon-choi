package org.sopt.sample.data.remote.home

import kotlinx.serialization.Serializable
import org.sopt.sample.data.RepoData

@Serializable
data class ResponseHomeUser(
    val data: List<RepoData>,
    val page: Int,
    val per_page: Int,
    val support: Support,
    val total: Int,
    val total_pages: Int
) {
//    @Serializable
//    data class Data(
//        val avatar: String,
//        val email: String,
//        val first_name: String,
//        val id: Int,
//        val last_name: String
//    )

    @Serializable
    data class Support(
        val text: String,
        val url: String
    )
}