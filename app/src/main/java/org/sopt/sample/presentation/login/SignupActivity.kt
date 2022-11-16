package org.sopt.sample.presentation.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import org.sopt.sample.data.remote.ServicePool
import org.sopt.sample.data.remote.signup.RequestSignUp
import org.sopt.sample.data.remote.signup.ResponseSignUp
import org.sopt.sample.databinding.ActivitySignupBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding
    private val viewModel: SignUpViewModel by viewModels()
    private val signUpService = ServicePool.authService

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
                    initServer()

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
            finish()
        }
    }

    private fun initServer() {
        signUpService.postSignUp(
            RequestSignUp(
                binding.edtInputId.text.toString(),
                binding.edtInputPassword.text.toString(),
                binding.edtInputMbti.text.toString()
            )
        ).enqueue(object : Callback<ResponseSignUp> {
            override fun onResponse(
                call: Call<ResponseSignUp>,
                response: Response<ResponseSignUp>
            ) {
                if (response.isSuccessful) {
//                    val intent = Intent(this@SignupActivity, MainActivity::class.java)
//                    startActivity(intent)
//                    Log.d("signupActivity", "onResponse: ")
                    passingIntent()
                } else {
                    Log.d("signupActivity", "onSuccess에서 fail: $response ")
                }
            }

            override fun onFailure(call: Call<ResponseSignUp>, t: Throwable) {
                Log.d("signupActivity", "onFailure: ")
            }
        })
    }
}

