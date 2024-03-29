package com.acp1.my.menu.presentation.ui.access

import com.acp1.my.menu.data.repository.UserRepository
import com.acp1.my.menu.presentation.ui.base.BaseViewModel
import javax.inject.Inject

class MenuViewModel
@Inject constructor(private val userRepository: UserRepository) : BaseViewModel(){

    private val TAG: String = "MENU_VM"
}