package com.acp1.my.menu.presentation.ui.access.adapters.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.acp1.my.menu.data.local.model.Dish
import kotlinx.android.synthetic.main.item_dish.view.*

class DishViewHolder(itemView: View, private val listener: ItemListener?) :
    RecyclerView.ViewHolder(itemView) {

    fun bind(dish: Dish) {

        itemView.dishNameTextView.text = dish.name
    }
}