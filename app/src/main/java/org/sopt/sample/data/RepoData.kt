package org.sopt.sample.data

import androidx.annotation.DrawableRes

data class RepoData(
    @DrawableRes var image: Int?,
    var title: String?,
    var description: String?
)
