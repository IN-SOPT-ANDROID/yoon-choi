package org.sopt.sample.presentation.main.home

import android.util.Log
import androidx.lifecycle.ViewModel
import org.sopt.sample.data.remote.home.ResponseHomeUser

class HomeViewModel() : ViewModel() {
    val userList = mutableListOf<ResponseHomeUser>()

    override fun onCleared() {
        super.onCleared()
        Log.i("HomeViewModel", "HomeViewModel destroyed!")
    }
}
