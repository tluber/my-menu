package com.acp1.my.menu.presentation.ui.suggest

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
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

        button.setOnClickListener {
            when (fieldsAreNotEmpty()) {
                true -> suggestionViewModel.makeSuggestion(
                    nameEditText.text.toString(),
                    emailEditText.text.toString(),
                    commentEditText.text.toString()
                )
                false -> makeDialog()
            }
        }
    }

    private fun setupObservers() {

        suggestionViewModel.dataLoading.observe(this, Observer<Boolean> { loading ->
            when (loading) {
                true -> loadingContentView.visible(true)
                false -> loadingContentView.gone(true)
            }
        })

        suggestionViewModel.success.observe(this, Observer<Boolean> {suggestRecorded ->
            when (suggestRecorded) {
                true -> clearFields()
            }
        })

        mainView.setupSnackbar(this, suggestionViewModel.snackBarMessage, Snackbar.LENGTH_LONG)
        mainView.setupToast(this, suggestionViewModel.toastMessage, Toast.LENGTH_LONG)
    }

    private fun fieldsAreNotEmpty(): Boolean {
        return (nameEditText.text.isNotEmpty() &&
                emailEditText.text.isNotEmpty() &&
                commentEditText.text.isNotEmpty())
    }

    private fun clearFields() {
        nameEditText.text.clear()
        emailEditText.text.clear()
        commentEditText.text.clear()
    }

    private fun makeDialog() {

        val builder = AlertDialog.Builder(this)

        with(builder) {
            setTitle(R.string.alert)
            setMessage(R.string.empty_content)
            setPositiveButton(
                R.string.button_ok,
                DialogInterface.OnClickListener(function = finishClick)
            )
        }
        val alert = builder.create()
        alert.show()
    }

    private val finishClick = { dialog: DialogInterface, which: Int ->
        dialog.dismiss()
    }
}
