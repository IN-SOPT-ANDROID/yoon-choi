package org.sopt.sample.presentation.main.home

import android.util.Log
import androidx.lifecycle.ViewModel
import org.sopt.sample.R
import org.sopt.sample.data.RepoData

class HomeViewModel : ViewModel() {
    val mockRepoList = listOf<RepoData>(
        RepoData(
            image = null,
            title = null,
            description = null
        ),
        RepoData(
            image = R.drawable.nunu,
            title = "NuNu",
            description = "안드로이드 파트장"
        ),
        RepoData(
            image = R.drawable.murjun,
            title = "murjun",
            description = "안드로이드 차기 파트장"
        ),
        RepoData(
            image = R.drawable.kown,
            title = "Vixx",
            description = "안드로이드 연예인"
        ),
        RepoData(
            image = R.drawable.subin,
            title = "subin",
            description = "안드로이드 엄마"
        ),
        RepoData(
            image = R.drawable.dani,
            title = "dani",
            description = "금잔디 막둥이"
        ),
        RepoData(
            image = R.drawable.park,
            title = "hailey",
            description = "금잔디 비타민"
        ),
        RepoData(
            image = R.drawable.min,
            title = "min",
            description = "금잔디 열정맨"
        ),
        RepoData(
            image = R.drawable.myimage,
            title = "yoon",
            description = "금잔디 말광량이"
        )
    )

    override fun onCleared() {
        super.onCleared()
        Log.i("HomeViewModel", "HomeViewModel destroyed!")
    }
}
