package com.acp1.my.menu.presentation.ui.payment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.acp1.my.menu.R
import com.acp1.my.menu.data.local.model.Payment
import com.acp1.my.menu.presentation.ui.menu.adapters.viewholders.ItemListener
import kotlinx.android.synthetic.main.item_payment.view.*

class PaymentAdapter(private var paymentList: List<Payment> = listOf()) :
    RecyclerView.Adapter<PaymentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(viewType, parent, false)
        return PaymentViewHolder(view)
    }

    override fun getItemCount(): Int {
        return paymentList.size
    }

    override fun onBindViewHolder(holder: PaymentViewHolder, position: Int) {
        holder.bind(paymentList[position])
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.item_payment
    }

    fun refresh(list: List<Payment>) {
        paymentList = list
        notifyDataSetChanged()
    }

}

class PaymentViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(payment: Payment) {
        itemView.tag = payment

        itemView.paymentTextView.text = payment.name
        itemView.paymentImage.setImageURI(payment.picture)
    }
}