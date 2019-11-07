package com.acp1.my.menu.data.mapper

import com.acp1.my.menu.data.local.model.Category
import com.acp1.my.menu.data.local.model.Dish
import com.acp1.my.menu.data.local.model.Filter
import com.acp1.my.menu.data.local.model.Payment
import com.acp1.my.menu.data.remote.model.dto.*

fun PaymentDto.toPayment(): Payment {
    return Payment(
        id = this.id,
        name = this.name,
        picture = this.picture
    )
}

fun CategoryDto.toCategory(): Category {
    return Category(
        id = this.id,
        title = this.name,
        items = this.dishes.map { it.toDish() }
    )
}

fun DishDto.toDish(): Dish {
    return Dish(
        id = this.id,
        name = this.name,
        picture = this.picture,
        price = this.price,
        description = this.description,
        filters = this.filters.map { it.toFilter() }
    )
}

fun FilterDto.toFilter(): Filter {
    return Filter(
        id = this.id,
        name = this.name
    )
}