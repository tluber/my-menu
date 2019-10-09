package com.acp1.my.menu.presentation.ui.base

import androidx.appcompat.widget.Toolbar
import dagger.android.support.DaggerFragment
import com.acp1.my.menu.R


abstract class BaseFragment : DaggerFragment() {

    interface OnNavigationListener {
        fun onPushFragment(fragment: BaseFragment)
        fun onPopFragment()
    }

    protected var navigationListener: OnNavigationListener? = null

    override fun onDetach() {
        super.onDetach()
        navigationListener = null
    }

    fun setupToolbar(toolbar: Toolbar, titleId: Int) {
        toolbar.title = resources.getString(titleId)
    }

    fun addBackButton(toolbar: Toolbar) {
        toolbar.setNavigationIcon(R.drawable.abc_ic_ab_back_material)
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    fun onBackPressed() {
        navigationListener?.apply {
            onPopFragment()
        }
    }

}