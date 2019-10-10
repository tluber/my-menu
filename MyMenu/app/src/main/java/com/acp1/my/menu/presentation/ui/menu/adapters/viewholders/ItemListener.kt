package com.acp1.my.menu.presentation.ui.menu.adapters.viewholders

import com.acp1.my.menu.data.local.model.Dish

interface ItemListener {
    fun showDish(dish: Dish)
}