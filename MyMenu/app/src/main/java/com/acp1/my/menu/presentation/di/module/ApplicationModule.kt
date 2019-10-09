package com.acp1.my.menu.presentation.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import com.acp1.my.menu.AppApplication
import com.acp1.my.menu.presentation.di.base.ApplicationContext

@Module
class ApplicationModule {

    //Importante: agregar la anotation @ApplicationContext donde se inyecta
    @Provides
    @ApplicationContext
    internal fun provideContext(appApplication: AppApplication): Context {
        return appApplication.applicationContext
    }

    @Provides
    internal fun provideApplication(appApplication: AppApplication): Application {
        return appApplication
    }
}