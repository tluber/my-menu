package com.acp1.my.menu.presentation.ui.menu.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.acp1.my.menu.R
import com.acp1.my.menu.data.local.model.Category
import com.acp1.my.menu.presentation.ui.menu.adapters.viewholders.CategoryViewHolder
import com.acp1.my.menu.presentation.ui.menu.adapters.viewholders.ItemListener

class MenuAdapter(
    private var categoryList: List<Category> = listOf(),
    private val listener: ItemListener?
) :
    RecyclerView.Adapter<CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(viewType, parent, false)
        return CategoryViewHolder(view, listener)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(categoryList[position])
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.item_category
    }

    fun refresh(list: List<Category>) {
        categoryList = list
        notifyDataSetChanged()
    }

}