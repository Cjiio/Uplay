package com.ulianla.uplay.activity.splash

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ulianla.uplay.activity.main.MainActivity
import com.ulianla.uplay.databinding.ActivitySplashBinding
import com.ulianla.uplay.utils.NightModeUtils

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //初始化主题模式
        NightModeUtils().initThemeMode(this)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //3秒后跳转到主页面
        binding.root.postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 1000)
    }
}