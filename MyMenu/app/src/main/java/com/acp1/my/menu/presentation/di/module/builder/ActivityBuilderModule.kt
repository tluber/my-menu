package com.acp1.my.menu.presentation.di.module.builder


import com.acp1.my.menu.MainActivity
import com.acp1.my.menu.presentation.ui.access.MyMenuActivity
import com.acp1.my.menu.presentation.ui.details.DetailDishActivity
import com.acp1.my.menu.presentation.ui.menu.MenuActivity
import com.acp1.my.menu.presentation.ui.menu.TodaysMenuActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class ActivityBuilderModule {

    //Generates an AndroidInjector for the return type of this method
    // Crea un Injector para el tipo que se retorna, lo que va a permitir luego inyectar
    // Las dependencias a la activity

    @ContributesAndroidInjector(modules = [FragmentBuilderModule::class])
    abstract fun contributeMainActivity(): MainActivity

    //MENU
    @ContributesAndroidInjector(modules = [FragmentBuilderModule::class])
    abstract fun contributeMyMenuActivity(): MyMenuActivity

    @ContributesAndroidInjector(modules = [FragmentBuilderModule::class])
    abstract fun contributeMenuActivity(): MenuActivity

    @ContributesAndroidInjector(modules = [FragmentBuilderModule::class])
    abstract fun contributeDetailDishActivity(): DetailDishActivity

    @ContributesAndroidInjector(modules = [FragmentBuilderModule::class])
    abstract fun contributeTodaysMenuActivity(): TodaysMenuActivity

}
