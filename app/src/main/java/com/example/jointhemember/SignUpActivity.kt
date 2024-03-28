package com.example.jointhemember


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts


class SignUpActivity : AppCompatActivity() {

    private lateinit var ids: EditText
    private lateinit var pas: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        ids = findViewById(R.id.idEidtTextView2)
        pas = findViewById<EditText>(R.id.passwordEidtTextView2)
        val name = findViewById<EditText>(R.id.nameEidtTextView2)


        // 회원가입 성공
        val joins = findViewById<Button>(R.id.joinButton2)
        joins.setOnClickListener {
            if(ids.text.isEmpty() || pas.text.isEmpty() || name.text.isEmpty()) {
                Toast.makeText(this, "다시입력해주세요", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "회원가입에 성공했습니다", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
//                val message = ids.text.toString()
//                val textt = pas.text.toString()
//                intent.putExtra("ida", message)
//                intent.putExtra("pas", textt)
                intent.putExtra("ida", ids.text.toString())
                intent.putExtra("pas", pas.text.toString())
                setResult(RESULT_OK, intent)
//                startActivity(intent)
                finish()
            }
        }
    }
}
