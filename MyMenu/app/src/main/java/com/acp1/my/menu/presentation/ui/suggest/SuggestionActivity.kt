package com.acp1.my.menu.presentation.ui.suggest

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.acp1.my.menu.R
import com.acp1.my.menu.presentation.ui.base.BaseActivity
import com.acp1.my.menu.utils.extensions.gone
import com.acp1.my.menu.utils.extensions.setupSnackbar
import com.acp1.my.menu.utils.extensions.setupToast
import com.acp1.my.menu.utils.extensions.visible
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_suggestion.*
import javax.inject.Inject

class SuggestionActivity : BaseActivity() {

    private val TAG: String = "SUGGESTION_ACT"

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, SuggestionActivity::class.java)
        }
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var suggestionViewModel: SuggestionViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_suggestion)

        suggestionViewModel =
            ViewModelProviders.of(this, viewModelFactory).get(SuggestionViewModel::class.java)

        setupToolbar(toolbar, R.string.suggestions)
        setSupportActionBar(toolbar)
        addBackButton(toolbar)

        setupListeners()
        setupObservers()
    }

    private fun setupListeners() {

    }

    private fun setupObservers() {

        suggestionViewModel.dataLoading.observe(this, Observer<Boolean> { loading ->
            when (loading) {
                true -> loadingContentView.visible(true)
                false -> loadingContentView.gone(true)
            }
        })

        mainView.setupSnackbar(this, suggestionViewModel.snackBarMessage, Snackbar.LENGTH_LONG)
        mainView.setupToast(this, suggestionViewModel.toastMessage, Toast.LENGTH_LONG)
    }
}
