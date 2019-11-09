package com.acp1.my.menu.data.mapper

import com.acp1.my.menu.data.local.model.*
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

fun TodayMenuDto.toTodaysMenu(): TodaysMenu {
    return TodaysMenu(
        starter = this.starter.toDish(),
        main = this.main.toDish(),
        price = this.price,
        dessert = this.dessert.toDish(),
        hasCoffee = this.hasCoffee
    )
}

fun OptionDto.toOption(): Option {
    return Option(
        id = this.id,
        name = this.name
    )
}