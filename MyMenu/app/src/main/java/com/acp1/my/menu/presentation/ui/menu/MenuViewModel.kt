package com.acp1.my.menu.presentation.ui.menu

import com.acp1.my.menu.data.local.model.Category
import com.acp1.my.menu.data.local.model.Dish
import com.acp1.my.menu.data.repository.UserRepository
import com.acp1.my.menu.presentation.ui.base.BaseViewModel
import javax.inject.Inject

class MenuViewModel
@Inject constructor(private val userRepository: UserRepository) : BaseViewModel() {

    private val TAG: String = "MENU_VM"

    val list = listOf(
        Category(
            0, "Entradas", listOf(
                Dish("Papas Fritas", "$100", "Papas Fritas", "https://image.freepik.com/free-photo/french-fries_74190-4806.jpg"),
                Dish("Papas Fritas", "$100", "Papas Fritas", ""),
                Dish("Papas Fritas", "$100", "Papas Fritas", ""),
                Dish("Papas Fritas", "$100", "Papas Fritas", ""),
                Dish("Papas Fritas", "$100", "Papas Fritas", ""),
                Dish("Papas Fritas", "$100", "Papas Fritas", ""),
                Dish("Papas Fritas", "$100", "Papas Fritas", ""),
                Dish("Papas Fritas", "$100", "Papas Fritas", ""),
                Dish("Papas Fritas", "$100", "Papas Fritas", ""),
                Dish("Papas Fritas", "$100", "Papas Fritas", ""),
                Dish("Papas Fritas", "$100", "Papas Fritas", ""),
                Dish("Papas Fritas", "$100", "Papas Fritas", ""),
                Dish("Papas Fritas", "$100", "Papas Fritas", "")
            )
        ),
        Category(
            0, "Minutas", listOf(
                Dish("Papas Fritas", "$100", "Papas Fritas", ""),
                Dish("Papas Fritas", "$100", "Papas Fritas", ""),
                Dish("Papas Fritas", "$100", "Papas Fritas", ""),
                Dish("Papas Fritas", "$100", "Papas Fritas", ""),
                Dish("Papas Fritas", "$100", "Papas Fritas", ""),
                Dish("Papas Fritas", "$100", "Papas Fritas", ""),
                Dish("Papas Fritas", "$100", "Papas Fritas", ""),
                Dish("Papas Fritas", "$100", "Papas Fritas", ""),
                Dish("Papas Fritas", "$100", "Papas Fritas", ""),
                Dish("Papas Fritas", "$100", "Papas Fritas", ""),
                Dish("Papas Fritas", "$100", "Papas Fritas", ""),
                Dish("Papas Fritas", "$100", "Papas Fritas", ""),
                Dish("Papas Fritas", "$100", "Papas Fritas", "")
            )
        ),
        Category(
            0, "Pastas", listOf(
                Dish("Papas Fritas", "$100", "Papas Fritas", ""),
                Dish("Papas Fritas", "$100", "Papas Fritas", ""),
                Dish("Papas Fritas", "$100", "Papas Fritas", ""),
                Dish("Papas Fritas", "$100", "Papas Fritas", ""),
                Dish("Papas Fritas", "$100", "Papas Fritas", ""),
                Dish("Papas Fritas", "$100", "Papas Fritas", ""),
                Dish("Papas Fritas", "$100", "Papas Fritas", ""),
                Dish("Papas Fritas", "$100", "Papas Fritas", ""),
                Dish("Papas Fritas", "$100", "Papas Fritas", ""),
                Dish("Papas Fritas", "$100", "Papas Fritas", ""),
                Dish("Papas Fritas", "$100", "Papas Fritas", ""),
                Dish("Papas Fritas", "$100", "Papas Fritas", ""),
                Dish("Papas Fritas", "$100", "Papas Fritas", "")
            )
        ),
        Category(
            0, "Bebidas", listOf(
                Dish("Papas Fritas", "$100", "Papas Fritas", ""),
                Dish("Papas Fritas", "$100", "Papas Fritas", ""),
                Dish("Papas Fritas", "$100", "Papas Fritas", ""),
                Dish("Papas Fritas", "$100", "Papas Fritas", ""),
                Dish("Papas Fritas", "$100", "Papas Fritas", ""),
                Dish("Papas Fritas", "$100", "Papas Fritas", ""),
                Dish("Papas Fritas", "$100", "Papas Fritas", ""),
                Dish("Papas Fritas", "$100", "Papas Fritas", ""),
                Dish("Papas Fritas", "$100", "Papas Fritas", ""),
                Dish("Papas Fritas", "$100", "Papas Fritas", ""),
                Dish("Papas Fritas", "$100", "Papas Fritas", ""),
                Dish("Papas Fritas", "$100", "Papas Fritas", ""),
                Dish("Papas Fritas", "$100", "Papas Fritas", "")
            )
        )
    )
}