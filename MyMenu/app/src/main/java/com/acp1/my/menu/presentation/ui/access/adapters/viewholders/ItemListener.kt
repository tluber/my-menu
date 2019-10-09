package com.acp1.my.menu.presentation.ui.access.adapters.viewholders

import com.acp1.my.menu.data.local.model.Dish

interface ItemListener {
    fun showDish(dish: Dish)
}