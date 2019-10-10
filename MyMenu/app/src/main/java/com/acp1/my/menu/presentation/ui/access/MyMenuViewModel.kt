package com.acp1.my.menu.presentation.ui.access

import com.acp1.my.menu.data.repository.UserRepository
import com.acp1.my.menu.presentation.ui.base.BaseViewModel
import javax.inject.Inject

class MyMenuViewModel
@Inject constructor(private val userRepository: UserRepository) : BaseViewModel() {

    private val TAG: String = "MY_MENU_VM"
}