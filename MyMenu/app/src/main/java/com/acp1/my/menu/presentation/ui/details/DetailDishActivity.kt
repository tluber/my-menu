package com.acp1.my.menu.presentation.ui.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.acp1.my.menu.Constants
import com.acp1.my.menu.R
import com.acp1.my.menu.data.local.model.Dish
import com.acp1.my.menu.presentation.ui.base.BaseActivity
import com.acp1.my.menu.utils.extensions.gone
import com.acp1.my.menu.utils.extensions.setupSnackbar
import com.acp1.my.menu.utils.extensions.setupToast
import com.acp1.my.menu.utils.extensions.visible
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_detail_dish.*
import javax.inject.Inject

class DetailDishActivity : BaseActivity() {

    private val TAG: String = "DETAIL_DISH_ACT"

    companion object {
        fun newIntent(context: Context, dish: Dish? = null): Intent {
            val intent = Intent(context, DetailDishActivity::class.java)
            dish?.apply {
                intent.putExtra(Constants.DETAIL, dish)
            }
            return intent
        }
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var detailDishViewModel: DetailDishViewModel
    private var dish: Dish? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_dish)

        detailDishViewModel =
            ViewModelProvider(this, viewModelFactory).get(DetailDishViewModel::class.java)

        dish = intent.getParcelableExtra<Dish>(Constants.DETAIL)?.apply { setupView(this) }

        setupListeners()
        setupObservers()
    }

    private fun setupView(dish: Dish) {

        setupToolbar(toolbar, dish.name)
        setSupportActionBar(toolbar)
        addBackButton(toolbar)

        nameTextView.text = dish.name
        descriptionTextView.text = dish.description
        priceTextView.text = "${resources.getString(R.string.peso)}${dish.price}"
        bannerImage.setImageURI(dish.picture)
    }

    private fun setupListeners() {

    }

    private fun setupObservers() {


        detailDishViewModel.dataLoading.observe(this, Observer<Boolean> { loading ->
            when (loading) {
                true -> loadingContentView.visible(true)
                false -> loadingContentView.gone(true)
            }
        })

        mainView.setupSnackbar(this, detailDishViewModel.snackBarMessage, Snackbar.LENGTH_LONG)
        mainView.setupToast(this, detailDishViewModel.toastMessage, Toast.LENGTH_LONG)
    }
}
