package org.sopt.sample.presentation.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import org.sopt.sample.data.remote.ApiFactory
import org.sopt.sample.data.remote.ServicePool
import org.sopt.sample.data.remote.login.RequestLogin
import org.sopt.sample.data.remote.login.ResponseLogin
import org.sopt.sample.databinding.ActivitySigninBinding
import org.sopt.sample.presentation.MainActivity
import org.sopt.sample.presentation.mypage.MypageActivity
import org.sopt.sample.util.SOPTSharedPreferences
import org.sopt.sample.util.defaultSnackbar
import org.sopt.sample.util.shortToast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySigninBinding
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>
    private var id: String? = null
    private var password: String? = null
    private var mbti: String? = null
    private val loginService = ServicePool.authService

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySigninBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setResult()
        clickSignUp()
        clickLogin()
    }

    private fun setResult() {
        resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult())
            { result ->
                resultLaunchSignup(result)
            }
    }


    private fun resultLaunchSignup(result: ActivityResult) {
        if (result.resultCode == Activity.RESULT_OK) {
            binding.root.defaultSnackbar("회원가입이 완료되었습니다.")
            result.data?.let {  //result.data 가 null이면 let함수가 실행되지 않음
                id = it.getStringExtra("id")
                password = it.getStringExtra("pw")
                mbti = it.getStringExtra("mbti")
                binding.edtInputId.setText(id)
                binding.edtPassword.setText(password)
            }
        }
    }

    private fun clickSignUp() {
        binding.btnSignup.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            resultLauncher.launch(intent)
        }
    }

    private fun loginService() {
//        loginService.postLogin(
//            RequestLogin(
//                binding.edtInputId.text.toString(),
//                binding.edtPassword.text.toString()
//            )
//        ).enqueue(object : Callback<ResponseLogin> {
//            override fun onResponse(call: Call<ResponseLogin>, response: Response<ResponseLogin>) {
//                startActivity(MainActivity)
//            }
//
//            override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {
//                Toast.makeText(this@SignInActivity, "서버통신 error", Toast.LENGTH_SHORT).show()
//            }
//        })
    }

    private fun clickLogin() {
        binding.btnLogin.setOnClickListener {
            shortToast("로그인 버튼 눌렀는디;")
            val edtId = binding.edtInputId.text.toString()
            val edtPw = binding.edtPassword.text.toString()
//            if (edtId == id && edtPw == password) {
//                shortToast("로그인에 성공했습니다.")
//                val intent = Intent(this, MainActivity::class.java)
//                goToMypage()
//                startActivity(intent)
//            } else if (edtId.isEmpty() && edtPw.isEmpty()
//            ) {
//                shortToast("값이 입력되지 않았습니다.")
//            } else {
//                shortToast("회원가입이랑 정보가 다릅니다.")
//            }
            loginService.postLogin(
                RequestLogin(
                    edtId,
                    edtPw
                )
            ).enqueue(object : Callback<ResponseLogin> {
                override fun onResponse(
                    call: Call<ResponseLogin>,
                    response: Response<ResponseLogin>
                ) {
                    if (response.isSuccessful) {
                        val intent = Intent(this@SignInActivity, MainActivity::class.java)
                        goToMypage()
                        startActivity(intent)
                        Log.d("signinActivity", "onResponse: ")
                    }else{
                        Log.d("signinActivity", "onSuccess에서 fail: ")
                    }
                }

                override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {
                    Log.d("signinActivity", "onFailure: ")
                }
            })
        }
    }

    private fun goToMypage() {
        val mypageIntent = Intent(this, MypageActivity::class.java)
        mypageIntent.putExtra("id", id)
        mypageIntent.putExtra("mbti", mbti)
    }

    private fun initClickEvent() {
        binding.cbtnAutoLogin.setOnClickListener {
            binding.cbtnAutoLogin.isChecked = !binding.cbtnAutoLogin.isChecked
            SOPTSharedPreferences.setAutoLogin(this, binding.cbtnAutoLogin.isChecked)
        }
    }

    companion object {   //key값 전달을 위한
        const val ID = "id"
        const val pw = "pw"
        const val MBTI = "mbti"
    }
}
