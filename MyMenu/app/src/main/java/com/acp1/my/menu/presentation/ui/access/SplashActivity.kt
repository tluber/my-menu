package com.acp1.my.menu.presentation.ui.access

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.acp1.my.menu.R
import com.acp1.my.menu.presentation.ui.base.BaseActivity

class SplashActivity : BaseActivity() {

    private val TAG: String = "SPLASH_ACT"

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, SplashActivity::class.java)
        }
    }

    private val splashTime = 1000L // 2 seconds
    private lateinit var mHandler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        mHandler = Handler()

        mHandler.postDelayed({
            goToMenu()
        }, splashTime)
    }

    private fun goToMenu() {
        startActivity(MyMenuActivity.newIntent(this))
        finish()
    }
}
