package org.sopt.sample.util

import android.content.Context
import android.content.SharedPreferences
import org.sopt.sample.presentation.login.SignInActivity

object SOPTSharedPreferences {
    //SharedPreference에서 사용하는 key값
    private const val STORAGE_KEY = "USER_AUTH"
    private const val AUTO_LOGIN_KEY = "AUTO_LOGIN"
    private lateinit var preferences: SharedPreferences

    fun init(context: Context) {
        preferences = context.getSharedPreferences(STORAGE_KEY, Context.MODE_PRIVATE)
    }

    fun getAutoLogin(context: Context): Boolean {
        val preferences = context.getSharedPreferences(STORAGE_KEY, Context.MODE_PRIVATE)
        return preferences.getBoolean(AUTO_LOGIN_KEY,false)
    }

    fun setAutoLogin(context: Context,value: Boolean) {
        val preferences = context.getSharedPreferences(STORAGE_KEY, Context.MODE_PRIVATE)
        preferences.edit()  //파일 작성을 위한 edit
            .putBoolean(AUTO_LOGIN_KEY, value) //put 으로 autologin어쩌고 파일을 건드릴 수 있삼
            .apply()    //모든 작성이 끝나면 apply혹은 commit
    }

    fun removeLogin(context: Context){
        val preferences = context.getSharedPreferences(STORAGE_KEY,Context.MODE_PRIVATE)
        preferences.edit()
            .remove(AUTO_LOGIN_KEY)
            .apply()
    }

    fun setLogout(context: Context) {
        preferences = context.getSharedPreferences(STORAGE_KEY, Context.MODE_PRIVATE)
        preferences.edit()
            .remove(AUTO_LOGIN_KEY) //key값에 해당하는 value 삭제
            .clear()    //모든 값을 지울 때 사용
            .apply()
    }

}