package ru.izhxx.ecommerceconcept.activities

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import ru.izhxx.ecommerceconcept.R

class SplashActivity: AppCompatActivity(R.layout.activity_splash) {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}