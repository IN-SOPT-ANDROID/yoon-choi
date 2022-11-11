package org.sopt.sample.presentation.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import org.sopt.sample.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding
    private val viewModel : SignUpViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        clickSignUp()
    }

    private fun clickSignUp() {
        with(binding) {
            btnSignup.setOnClickListener {
                if (edtInputId.length() in 6..10 && edtInputPassword.length() in 9..11) {
                    passingIntent()
                    finish()
                } else {
                    Snackbar.make(binding.root, "회원가입에 실패했습니다.", Snackbar.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun passingIntent() {
        val intent = Intent(this@SignupActivity, SignInActivity::class.java)
        with(binding) {
            //로그인화면 전환을 위한 intent
            intent.putExtra("id", edtInputId.text.toString())
            //signIn(로그인 화면)의 edtId부분에 정보를 넣어준다.
            intent.putExtra("pw", edtInputPassword.text.toString())
            intent.putExtra("mbti", edtInputMbti.text.toString())
            setResult(Activity.RESULT_OK, intent)
        }
    }
}
