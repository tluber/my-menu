package com.acp1.my.menu.presentation.di.module

import dagger.Module
import dagger.Provides
import com.acp1.my.menu.data.remote.ApiClient
import com.acp1.my.menu.data.remote.utils.ServiceGenerator
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule {

    //Aca van los providers de La BD, DAOs, RestApi, etc

    // Dos formas de declarar proveedore s de contenido:
    // @Provides: Se usa cuando necesitas crear la instancia del objeto a mano.
    // @Binds: Se define un metodo abstracto y dagger se encarga de implementarlo, basicamente se delega la tarea a dagger.

    @Singleton
    @Provides
    fun provideApiClient(): ApiClient {
        return ServiceGenerator.createService(ApiClient::class.java)
    }

}
