package com.acp1.my.menu.presentation.ui.base

import androidx.appcompat.widget.Toolbar
import dagger.android.support.DaggerAppCompatActivity
import com.acp1.my.menu.R

abstract class BaseActivity : DaggerAppCompatActivity() {

    fun setupToolbar(toolbar: Toolbar, titleId: Int) {
        toolbar.title = resources.getString(titleId)
    }

    fun setupToolbar(toolbar: Toolbar, title: String) {
        toolbar.title = title
    }

    fun addBackButton(toolbar: Toolbar) {
        toolbar.setNavigationIcon(R.drawable.abc_ic_ab_back_material)
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    override fun onBackPressed() {
        finish()
    }

}