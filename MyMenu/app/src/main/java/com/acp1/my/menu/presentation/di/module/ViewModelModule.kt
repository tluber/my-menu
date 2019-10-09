package com.acp1.my.menu.presentation.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import com.acp1.my.menu.presentation.di.base.ViewModelKey
import com.acp1.my.menu.presentation.ui.access.MenuViewModel
import com.acp1.my.menu.utils.AppViewModelFactory

@Suppress("unused")
@Module
abstract class ViewModelModule {

    //@Bind es simil a provider, devuelve la interfaz y recibe una implementación de la misma (esto obliga a que la clase sea abstracta).

    //Injecta este objeto en un Map usando ViewModelKey como key y el Provider como value.
    // El provider va a crear el objeto

    @Binds
    abstract fun bindViewModelFactory(factory: AppViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MenuViewModel::class)
    abstract fun bindMenuViewModel(menuViewModel: MenuViewModel): ViewModel

}
