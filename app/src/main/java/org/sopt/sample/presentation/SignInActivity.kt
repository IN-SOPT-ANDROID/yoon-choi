package org.sopt.sample.presentation

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import org.sopt.sample.databinding.ActivitySigninBinding

class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySigninBinding
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>
    private var id: String? = null
    private var password: String? = null
    private var mbti: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySigninBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        clickSignUp()
        clickLogin()
    }

    val startForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult())
        { result ->
            resultLaunchSignup(result)
        }

    private fun resultLaunchSignup(result: ActivityResult) {
        if (result.resultCode == Activity.RESULT_OK) {
            Snackbar.make(binding.root, "회원가입이 완료되었습니다.", Snackbar.LENGTH_SHORT).show()
            result.data?.let {  //result.data 가 null이면 let함수가 실행되지 않음
                id = it.getStringExtra("id")
                password = it.getStringExtra("pw")
                mbti = it.getStringExtra("mbti")
                binding.edtInputId.setText(id)
                binding.edtPassword.setText(password)
            }
        }
    }

    private fun clickLogin() {
        binding.btnLogin.setOnClickListener {
            if (binding.edtInputId.text.toString() == id && binding.edtPassword.text.toString() == password) {
                Toast.makeText(this, "로그인에 성공했습니다.", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MypageActivity::class.java)
                intent.putExtra("id", id)
                intent.putExtra("mbti", mbti)
                startActivity(intent)
            } else if (binding.edtInputId.text.toString()
                    .isEmpty() && binding.edtPassword.text.toString().isEmpty()
            ) {
                Toast.makeText(this, "값이 입력되지 않았습니다..", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "회원가입이랑 정보가 다릅니다.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun clickSignUp() {
        binding.btnSignup.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startForResult.launch(intent)
        }
    }
}
