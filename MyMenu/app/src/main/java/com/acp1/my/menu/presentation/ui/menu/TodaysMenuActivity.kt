package com.acp1.my.menu.presentation.ui.menu

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.acp1.my.menu.R
import com.acp1.my.menu.data.local.model.TodaysMenu
import com.acp1.my.menu.presentation.ui.base.BaseActivity
import com.acp1.my.menu.utils.extensions.gone
import com.acp1.my.menu.utils.extensions.setupSnackbar
import com.acp1.my.menu.utils.extensions.setupToast
import com.acp1.my.menu.utils.extensions.visible
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_todays_menu.*
import javax.inject.Inject

class TodaysMenuActivity : BaseActivity() {

    private val TAG: String = "TODAYS_MENU_ACT"

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, TodaysMenuActivity::class.java)
        }
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var todaysMenuViewModel: TodaysMenuViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todays_menu)

        todaysMenuViewModel =
            ViewModelProviders.of(this, viewModelFactory).get(TodaysMenuViewModel::class.java)

        setupToolbar(toolbar, R.string.today_menu)
        setSupportActionBar(toolbar)
        addBackButton(toolbar)

        setupListeners()
        setupObservers()

        todaysMenuViewModel.getTodaysMenu()
    }

    private fun setupListeners() {

    }

    private fun setupObservers() {

        todaysMenuViewModel.dataLoading.observe(this, Observer<Boolean> { loading ->
            when (loading) {
                true -> loadingContentView.visible(true)
                false -> loadingContentView.gone(true)
            }
        })

        todaysMenuViewModel.menu.observe(this, Observer<List<TodaysMenu>> { list ->
            if (list.isNotEmpty()){
                val menu = list.first()
                starterTextView.text = menu.starter.name
                mainTextView.text = menu.main.name
                dessertTextView.text = menu.dessert.name
                when (menu.hasCoffee){
                    true -> coffeeTextView.text = resources.getString(R.string.yes)
                    false -> coffeeTextView.text = resources.getString(R.string.no)
                }
                priceTextView.text = "$${menu.price}"
            }
        })

        mainView.setupSnackbar(this, todaysMenuViewModel.snackBarMessage, Snackbar.LENGTH_LONG)
        mainView.setupToast(this, todaysMenuViewModel.toastMessage, Toast.LENGTH_LONG)
    }
}
