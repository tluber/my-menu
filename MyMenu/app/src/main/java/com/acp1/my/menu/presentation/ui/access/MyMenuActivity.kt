package com.acp1.my.menu.presentation.ui.access

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager.widget.PagerAdapter
import com.acp1.my.menu.R
import com.acp1.my.menu.presentation.ui.base.BaseActivity
import com.acp1.my.menu.presentation.ui.menu.MenuActivity
import com.acp1.my.menu.presentation.ui.menu.TodaysMenuActivity
import com.acp1.my.menu.presentation.ui.payment.PaymentActivity
import com.acp1.my.menu.presentation.ui.suggest.SuggestionActivity
import com.acp1.my.menu.utils.extensions.gone
import com.acp1.my.menu.utils.extensions.setupSnackbar
import com.acp1.my.menu.utils.extensions.setupToast
import com.acp1.my.menu.utils.extensions.visible
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_my_menu.*
import javax.inject.Inject

class MyMenuActivity : BaseActivity() {

    private val TAG: String = "MY_MENU_ACT"
    var images: Array<Int> = arrayOf(R.drawable.banner_promo, R.drawable.superville, R.drawable.noche_miercoles, R.drawable.macro)
    var adapter: PagerAdapter = SliderAdapter(this, images)

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, MyMenuActivity::class.java)
        }
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var myMenuViewModel: MyMenuViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_menu)

        myMenuViewModel =
            ViewModelProvider(this, viewModelFactory).get(MyMenuViewModel::class.java)

        setupToolbar(toolbar, R.string.app_name)
        setSupportActionBar(toolbar)

        setupListeners()
        setupObservers()
        viewpager.adapter = adapter
    }

    private fun setupListeners() {

        menuImageView.setOnClickListener {
            startActivity(MenuActivity.newIntent(this))
        }
        todayMenuImageView.setOnClickListener {
            startActivity(TodaysMenuActivity.newIntent(this))
        }
        suggestionsImageView.setOnClickListener {
            startActivity(SuggestionActivity.newIntent(this))
        }
        paymentImageView.setOnClickListener {
            startActivity(PaymentActivity.newIntent(this))
        }
    }

    private fun setupObservers() {

        myMenuViewModel.dataLoading.observe(this, Observer<Boolean> { loading ->
            when (loading) {
                true -> loadingContentView.visible(true)
                false -> loadingContentView.gone(true)
            }
        })

        mainView.setupSnackbar(this, myMenuViewModel.snackBarMessage, Snackbar.LENGTH_LONG)
        mainView.setupToast(this, myMenuViewModel.toastMessage, Toast.LENGTH_LONG)
    }
}
