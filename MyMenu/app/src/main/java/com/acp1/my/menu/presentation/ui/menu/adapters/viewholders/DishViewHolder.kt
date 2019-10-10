package com.acp1.my.menu.presentation.ui.menu.adapters.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.acp1.my.menu.data.local.model.Dish
import kotlinx.android.synthetic.main.item_dish.view.*

class DishViewHolder(itemView: View, private val listener: ItemListener?) :
    RecyclerView.ViewHolder(itemView) {

    init {
        itemView.setOnClickListener {
            val dish = itemView.tag
            if (dish is Dish) {
                listener?.showDish(dish)
            }
        }
    }

    fun bind(dish: Dish) {

        itemView.tag = dish
        itemView.dishNameTextView.text = dish.name
        itemView.priceTextView.text = dish.price
    }
}