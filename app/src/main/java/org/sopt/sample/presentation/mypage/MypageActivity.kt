package org.sopt.sample.presentation.mypage

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import org.sopt.sample.R
import org.sopt.sample.data.Mydata
import org.sopt.sample.databinding.ActivityMypageBinding

class MypageActivity : AppCompatActivity() {
    lateinit var binding: ActivityMypageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_mypage)

        initText()
    }

    private fun initText() {
        val id = intent.getStringExtra("id")
        val mbti = intent.getStringExtra("mbti")
        binding.mydata = Mydata(id!!, mbti!!)
    }
}