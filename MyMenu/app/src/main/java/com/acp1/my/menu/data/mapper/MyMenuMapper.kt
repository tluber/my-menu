package com.acp1.my.menu.data.mapper

import com.acp1.my.menu.data.local.model.Payment
import com.acp1.my.menu.data.remote.model.dto.PaymentDto

fun PaymentDto.toPayment(): Payment {
    return Payment(
        id = this.id,
        name = this.name,
        picture = this.picture
    )
}