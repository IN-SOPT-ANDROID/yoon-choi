package org.sopt.sample.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.sopt.sample.R
import org.sopt.sample.databinding.ActivityMypageBinding

class MypageActivity : AppCompatActivity() {
    lateinit var binding: ActivityMypageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMypageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initText()
    }

    private fun initText() {
        val id = intent.getStringExtra("id")
        val mbti = intent.getStringExtra("mbti")
        binding.tvMypageName.text = getString(R.string.home_name_is, id)
        binding.tvMypageMbti.text = getString(R.string.home_mbti_is, mbti)
    }
}