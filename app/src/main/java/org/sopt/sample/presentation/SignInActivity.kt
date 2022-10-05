package org.sopt.sample.presentation

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import org.sopt.sample.databinding.ActivitySigninBinding
import org.sopt.sample.util.defaultSnackbar
import org.sopt.sample.util.shortToast

class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySigninBinding
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>
    private var id: String? = null
    private var password: String? = null
    private var mbti: String? = null
//    val mydata: Mydata = Mydata(id!!, mbti!!)

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

    private fun clickLogin() {
        binding.btnLogin.setOnClickListener {
            if (binding.edtInputId.text.toString() == id && binding.edtPassword.text.toString() == password) {
                shortToast("로그인에 성공했습니다.")
                val intent = Intent(this, MypageActivity::class.java)
                intent.putExtra("id", id)
                intent.putExtra("mbti", mbti)
                Log.d("signin", "clicklogin: $id  $mbti")
                startActivity(intent)
            } else if (binding.edtInputId.text.toString()
                    .isEmpty() && binding.edtPassword.text.toString().isEmpty()
            ) {
                shortToast("값이 입력되지 않았습니다.")
            } else {
                shortToast("회원가입이랑 정보가 다릅니다.")
            }
        }
    }
}
