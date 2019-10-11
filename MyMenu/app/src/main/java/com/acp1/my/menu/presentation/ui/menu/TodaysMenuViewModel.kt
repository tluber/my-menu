package com.acp1.my.menu.presentation.ui.menu

import com.acp1.my.menu.data.local.model.TodaysMenu
import com.acp1.my.menu.data.repository.UserRepository
import com.acp1.my.menu.presentation.ui.base.BaseViewModel
import javax.inject.Inject

class TodaysMenuViewModel
@Inject constructor(private val userRepository: UserRepository) : BaseViewModel() {

    private val TAG: String = "TODAYS_MENU_VM"

    val menu = TodaysMenu("Papas Fritas.", "Papas Fritas.", "$500", true, false, "Sin opciones.")
}