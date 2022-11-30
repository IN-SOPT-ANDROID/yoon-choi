package org.sopt.sample.presentation.login

class CheckUserInfo {
    fun userId(id: String): Boolean = (id.length in 6..10)

    fun userPw(pw: String): Boolean = (pw.length in 9..11)
}