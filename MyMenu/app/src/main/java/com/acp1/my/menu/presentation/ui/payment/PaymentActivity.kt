package com.acp1.my.menu.presentation.ui.payment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.acp1.my.menu.R
import com.acp1.my.menu.data.local.model.Payment
import com.acp1.my.menu.presentation.ui.base.BaseActivity
import com.acp1.my.menu.utils.extensions.gone
import com.acp1.my.menu.utils.extensions.setupSnackbar
import com.acp1.my.menu.utils.extensions.setupToast
import com.acp1.my.menu.utils.extensions.visible
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_payment.*
import javax.inject.Inject

class PaymentActivity : BaseActivity() {

    private val TAG: String = "PAYMENT_ACT"

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, PaymentActivity::class.java)
        }
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var paymentViewModel: PaymentViewModel
    private val paymentAdapter = PaymentAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        paymentViewModel =
            ViewModelProvider(this, viewModelFactory).get(PaymentViewModel::class.java)

        setupToolbar(toolbar, R.string.payments)
        setSupportActionBar(toolbar)
        addBackButton(toolbar)

        paymentsRecyclerView.layoutManager = LinearLayoutManager(this)
        paymentsRecyclerView.adapter = paymentAdapter

        setupListeners()
        setupObservers()

        paymentViewModel.getPayments()
    }

    private fun setupListeners() {

    }

    private fun setupObservers() {

        paymentViewModel.dataLoading.observe(this, Observer<Boolean> { loading ->
            when (loading) {
                true -> loadingContentView.visible(true)
                false -> loadingContentView.gone(true)
            }
        })

        paymentViewModel.payments.observe(this, Observer<List<Payment>> { list ->
            paymentAdapter.refresh(list)
        })

        mainView.setupSnackbar(this, paymentViewModel.snackBarMessage, Snackbar.LENGTH_LONG)
        mainView.setupToast(this, paymentViewModel.toastMessage, Toast.LENGTH_LONG)
    }
}
