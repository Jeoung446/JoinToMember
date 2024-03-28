package com.example.jointhemember

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random


class HomeActivity : AppCompatActivity() {
    // 사진이 랜덤으로 선택
    private val imageArray = arrayOf (
        R.drawable.profile,
        R.drawable.profile1,
        R.drawable.profile2,
        R.drawable.profile3,
        R.drawable.profile4
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val txt = findViewById<TextView>(R.id.txtGetData)
        val id = intent.getStringExtra("id")
        val btn = findViewById<ImageView>(R.id.imageBtn)
        setRandomImage(btn)

        txt.text = "아이디:${id}"

        val cancel = findViewById<Button>(R.id.cancelButton)
        cancel.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
    private fun setRandomImage(imageView : ImageView) {
        val random = (imageArray.indices).random()
        //indices : 최소 인덱스부터 최대인덱스까지 랜덤으로 불러옴.
        val randomImageResourceId = imageArray[random]
        imageView.setImageResource(randomImageResourceId)
        // setImageResource : ImageView의 이미지를 변경하기 위해 사용.
    }
}