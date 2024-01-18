package com.up45.rnmfandom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import com.bumptech.glide.Glide

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val splashDuration = 5000L
        val splashImageView: ImageView = findViewById(R.id.splashImageView)

        Glide.with(this)
            .asGif()
            .load(R.drawable.splash)
            .into(splashImageView)

        Handler().postDelayed({
            // Pindah ke activity berikutnya setelah splashDuration
            val intent = Intent(this, WelcomeActivity::class.java)
            startActivity(intent)
            finish()
        }, splashDuration)

    }
}