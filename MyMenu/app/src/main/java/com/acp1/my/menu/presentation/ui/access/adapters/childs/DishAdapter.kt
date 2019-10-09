package com.acp1.my.menu.presentation.ui.access.adapters.childs

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.acp1.my.menu.R
import com.acp1.my.menu.data.local.model.Dish
import com.acp1.my.menu.presentation.ui.access.adapters.viewholders.DishViewHolder
import com.acp1.my.menu.presentation.ui.access.adapters.viewholders.ItemListener

class DishAdapter(
    private var dishList: List<Dish> = listOf(),
    private val listener: ItemListener?
) :
    RecyclerView.Adapter<DishViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DishViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(viewType, parent, false)
        return DishViewHolder(
            view,
            listener
        )
    }

    override fun getItemCount(): Int {
        return dishList.size
    }

    override fun onBindViewHolder(holder: DishViewHolder, position: Int) {
        holder.bind(dishList[position])
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.item_dish
    }

}