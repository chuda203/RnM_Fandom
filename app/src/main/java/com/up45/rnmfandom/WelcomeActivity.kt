package com.up45.rnmfandom

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

//        val textViewBase = findViewById<TextView>(R.id.tv_banner)
        val bannerOutline = findViewById<TextView>(R.id.tv_banner_outline)
        val messageOutline = findViewById<TextView>(R.id.tv_message_outline)

        // Atur outline pada textViewOutline
        bannerOutline.setShadowLayer(15f, 0f, 0f, Color.GREEN) // Ganti warna outline jika diperlukan
        messageOutline.setShadowLayer(15f, 0f, 0f, Color.GREEN) // Ganti warna outline jika diperlukan

        val btnNext = findViewById<Button>(R.id.bt_next)

        btnNext.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}