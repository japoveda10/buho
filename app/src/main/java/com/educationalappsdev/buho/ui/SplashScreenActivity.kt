package com.educationalappsdev.buho.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.educationalappsdev.buho.MainActivity
import com.educationalappsdev.buho.R
import com.educationalappsdev.buho.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Loads animation
        val animation = AnimationUtils.loadAnimation(this, R.anim.animation)

        // Assign the animation to ivBuhoLogo
        binding.ivBuhoLogo.startAnimation(animation)

        // Create intent to move to MainActivity
        val intent = Intent(this, MainActivity::class.java)

        // Animation listener associated with animation
        animation.setAnimationListener(object : Animation.AnimationListener {
            // Code that will be executed when the animation starts
            override fun onAnimationStart(animation: Animation?) {

            }

            // Code that will be executed when the animation ends
            override fun onAnimationEnd(animation: Animation?) {
                startActivity(intent)
                finish()
            }

            // Code that will be executed when the animation repeats
            override fun onAnimationRepeat(animation: Animation?) {

            }

        })
    }
}