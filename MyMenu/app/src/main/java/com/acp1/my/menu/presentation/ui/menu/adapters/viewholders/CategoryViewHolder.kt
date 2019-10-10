package com.acp1.my.menu.presentation.ui.menu.adapters.viewholders

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.acp1.my.menu.data.local.model.Category
import com.acp1.my.menu.presentation.ui.menu.adapters.childs.DishAdapter
import kotlinx.android.synthetic.main.item_category.view.*

class CategoryViewHolder(view: View, private val listener: ItemListener?) : RecyclerView.ViewHolder(view) {

    fun bind(category: Category) {

        val linearLayoutManager =
            LinearLayoutManager(itemView.dishRecyclerView.context)

        itemView.categoryTitleTextView.text = category.title

        itemView.dishRecyclerView.apply {
            layoutManager = linearLayoutManager
            adapter = DishAdapter(category.items, listener)
        }

    }
}