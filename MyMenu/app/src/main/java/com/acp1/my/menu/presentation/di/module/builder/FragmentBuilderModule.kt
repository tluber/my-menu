package com.acp1.my.menu.presentation.di.module.builder

import dagger.Module


@Suppress("unused")
@Module
abstract class FragmentBuilderModule {

    //Generates an AndroidInjector for the return type of this method
    // Crea un Injector para el tipo que se retorna, lo que va a permitir luego inyectar
    // Las dependencias a la activity

//    @ContributesAndroidInjector
//    abstract fun contributeBarbersFragment(): BarbersFragment

}