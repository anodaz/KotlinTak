package com.anodaz.kotlintak

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import gr.net.maroulis.library.EasySplashScreen


class SplashScreen : AppCompatActivity() {
private val Timerr=4000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val easySplashScreenView = EasySplashScreen(this)
                .withFullScreen()
                .withSplashTimeOut(4000)
                .withBackgroundResource(android.R.color.holo_blue_dark).withHeaderText("Kotlin Tak")
                .withFooterText("Copyright 2018")
                .withBeforeLogoText("Created By ANODAZ")
                .withLogo(R.drawable.icon)
                .withAfterLogoText("Multiplayer game")

                .create()

        setContentView(easySplashScreenView)
        Handler().postDelayed({
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        },Timerr.toLong())
    }
}
