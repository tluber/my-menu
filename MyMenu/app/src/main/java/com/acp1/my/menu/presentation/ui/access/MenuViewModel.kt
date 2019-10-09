package com.acp1.my.menu.presentation.ui.access

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
                Dish("Papas Fritas"),
                Dish("Papas Fritas"),
                Dish("Papas Fritas"),
                Dish("Papas Fritas"),
                Dish("Papas Fritas"),
                Dish("Papas Fritas"),
                Dish("Papas Fritas"),
                Dish("Papas Fritas"),
                Dish("Papas Fritas"),
                Dish("Papas Fritas"),
                Dish("Papas Fritas"),
                Dish("Papas Fritas"),
                Dish("Papas Fritas")
            )
        ),
        Category(
            0, "Minutas", listOf(
                Dish("Papas Fritas"),
                Dish("Papas Fritas"),
                Dish("Papas Fritas"),
                Dish("Papas Fritas"),
                Dish("Papas Fritas"),
                Dish("Papas Fritas"),
                Dish("Papas Fritas"),
                Dish("Papas Fritas"),
                Dish("Papas Fritas"),
                Dish("Papas Fritas"),
                Dish("Papas Fritas"),
                Dish("Papas Fritas"),
                Dish("Papas Fritas")
            )
        ),
        Category(
            0, "Pastas", listOf(
                Dish("Papas Fritas"),
                Dish("Papas Fritas"),
                Dish("Papas Fritas"),
                Dish("Papas Fritas"),
                Dish("Papas Fritas"),
                Dish("Papas Fritas"),
                Dish("Papas Fritas"),
                Dish("Papas Fritas"),
                Dish("Papas Fritas"),
                Dish("Papas Fritas"),
                Dish("Papas Fritas"),
                Dish("Papas Fritas"),
                Dish("Papas Fritas")
            )
        ),
        Category(
            0, "Bebidas", listOf(
                Dish("Papas Fritas"),
                Dish("Papas Fritas"),
                Dish("Papas Fritas"),
                Dish("Papas Fritas"),
                Dish("Papas Fritas"),
                Dish("Papas Fritas"),
                Dish("Papas Fritas"),
                Dish("Papas Fritas"),
                Dish("Papas Fritas"),
                Dish("Papas Fritas"),
                Dish("Papas Fritas"),
                Dish("Papas Fritas"),
                Dish("Papas Fritas")
            )
        )
    )
}