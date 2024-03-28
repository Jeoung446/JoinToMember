package com.example.jointhemember

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val idvv = findViewById<EditText>(R.id.idEidtTextView)

        val password = findViewById<EditText>(R.id.passwordEidtTextView)

//        idvv.setText(intent.getStringExtra("ida")) 원래 코드
//        password.setText(intent.getStringExtra("pas"))

        // 로그인 성공
        val login = findViewById<Button>(R.id.loginButton)
        var intent1 = Intent(this, HomeActivity::class.java)
        login.setOnClickListener {
            if (idvv.text.isEmpty() || password.text.isEmpty()) {
                Toast.makeText(this, "다시입력해주세요", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "로그인에 성공했습니다", Toast.LENGTH_SHORT).show()
                // 성공 화면으로 이동
                // intent putExtra, 작성
                var str = idvv.text.toString()
                intent1.putExtra("id", str)
                startActivity(intent1)
            }
        }
        // 회원가입 이동
        val join = findViewById<Button>(R.id.joinButton)
        join.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            // startActivity(intent)
            resultLauncher.launch(intent)
        }

        resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->		// it -> result
                if (result.resultCode == RESULT_OK) {
                    val id = result.data?.getStringExtra("ida") ?: ""				// 아이디 수신 혹은 ""
                    val passworda = result.data?.getStringExtra("pas") ?: ""	// 비밀번호 수신 혹은 ""

                    idvv.setText(id)					// 아이디에 입력
                    password.setText(passworda)     // 비밀번호에 입력
                }
            }
    }
}