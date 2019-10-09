package com.acp1.my.menu.presentation.di.module.builder


import dagger.Module
import dagger.android.ContributesAndroidInjector
import com.acp1.my.menu.MainActivity
import com.acp1.my.menu.presentation.ui.access.MenuActivity

@Suppress("unused")
@Module
abstract class ActivityBuilderModule {

    //Generates an AndroidInjector for the return type of this method
    // Crea un Injector para el tipo que se retorna, lo que va a permitir luego inyectar
    // Las dependencias a la activity

    @ContributesAndroidInjector(modules = [FragmentBuilderModule::class])
    abstract fun contributeMainActivity(): MainActivity

    //Access
    @ContributesAndroidInjector(modules = [FragmentBuilderModule::class])
    abstract fun contributeMenuActivity(): MenuActivity

}
