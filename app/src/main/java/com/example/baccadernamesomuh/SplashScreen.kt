package com.example.baccadernamesomuh

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CustomSplashScreen")
class SplashScreen : AppCompatActivity() {
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        init()

        progressbar()
    }

    private fun init() {
        progressBar = findViewById(R.id.progressBarId)
    }

    private fun progressbar() {

        lifecycleScope.launch {
            while (true) {
                delay(3000)

                var progressBarStatus = 100

                if (progressBarStatus < 100) {
                    progressBar.progress = progressBarStatus
                    progressBarStatus += 10

                } else {
                    var intent = Intent(this@SplashScreen, DashboardActivity::class.java)
                    startActivity(intent)
                    finish()
                    break
                }
            }
        }
    }
}