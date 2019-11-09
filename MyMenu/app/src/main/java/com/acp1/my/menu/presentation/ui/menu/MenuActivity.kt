package com.acp1.my.menu.presentation.ui.menu

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.acp1.my.menu.R
import com.acp1.my.menu.data.local.model.Category
import com.acp1.my.menu.data.local.model.Dish
import com.acp1.my.menu.data.local.model.DishType
import com.acp1.my.menu.presentation.ui.base.BaseActivity
import com.acp1.my.menu.presentation.ui.details.DetailDishActivity
import com.acp1.my.menu.presentation.ui.menu.adapters.MenuAdapter
import com.acp1.my.menu.presentation.ui.menu.adapters.viewholders.ItemListener
import com.acp1.my.menu.utils.extensions.gone
import com.acp1.my.menu.utils.extensions.setupSnackbar
import com.acp1.my.menu.utils.extensions.setupToast
import com.acp1.my.menu.utils.extensions.visible
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_menu.*
import javax.inject.Inject

class MenuActivity : BaseActivity() {

    private val TAG: String = "MENU_ACT"

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, MenuActivity::class.java)
        }
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var menuViewModel: MenuViewModel
    private val itemListener: ItemListener = (object :
        ItemListener {
        override fun showDish(dish: Dish) {
            startActivity(DetailDishActivity.newIntent(this@MenuActivity, dish))
        }
    })
    private val menuAdapter = MenuAdapter(listener = itemListener)
    private val filterList = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        menuViewModel =
            ViewModelProvider(this, viewModelFactory).get(MenuViewModel::class.java)

        setupToolbar(toolbar, R.string.menu)
        setSupportActionBar(toolbar)
        addBackButton(toolbar)

        menuRecyclerView.layoutManager =
            LinearLayoutManager(this)
        menuRecyclerView.adapter = menuAdapter

        setupListeners()
        setupObservers()
        setupSpinner()

        menuViewModel.getMenu()
    }

    private fun setupSpinner() {

        filterList.add(resources.getString(R.string.filtros))
        filterList.add(DishType.Veggie.type)
        filterList.add(DishType.Celiac.type)
        filterList.add(DishType.None.type)

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, filterList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        filterSpinner.adapter = adapter
        filterSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                when (filterList[position]) {
                    DishType.Veggie.type -> menuAdapter.applyFilter(DishType.Veggie)
                    DishType.Celiac.type -> menuAdapter.applyFilter(DishType.Celiac)
                    DishType.None.type -> menuAdapter.applyFilter(DishType.None)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Code to perform some action when nothing is selected
            }
        }

    }

    private fun setupListeners() {

    }

    private fun setupObservers() {

        menuViewModel.dataLoading.observe(this, Observer<Boolean> { loading ->
            when (loading) {
                true -> loadingContentView.visible(true)
                false -> loadingContentView.gone(true)
            }
        })

        menuViewModel.category.observe(this, Observer<List<Category>> { list ->

            menuAdapter.refresh(list)
        })

        mainView.setupSnackbar(this, menuViewModel.snackBarMessage, Snackbar.LENGTH_LONG)
        mainView.setupToast(this, menuViewModel.toastMessage, Toast.LENGTH_LONG)
    }
}
