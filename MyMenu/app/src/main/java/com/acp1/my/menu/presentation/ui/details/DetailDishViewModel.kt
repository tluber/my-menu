package com.acp1.my.menu.presentation.ui.details

import com.acp1.my.menu.data.repository.UserRepository
import com.acp1.my.menu.presentation.ui.base.BaseViewModel
import javax.inject.Inject

class DetailDishViewModel
@Inject constructor(private val userRepository: UserRepository) : BaseViewModel(){

    private val TAG: String = "DETAIL_DISH_VM"
}