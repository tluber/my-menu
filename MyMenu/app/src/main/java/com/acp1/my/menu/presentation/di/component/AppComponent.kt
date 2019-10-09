package com.acp1.my.menu.presentation.di.component

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import com.acp1.my.menu.AppApplication
import com.acp1.my.menu.presentation.di.module.AppModule
import com.acp1.my.menu.presentation.di.module.ApplicationModule
import com.acp1.my.menu.presentation.di.module.DataModule
import com.acp1.my.menu.presentation.di.module.builder.ActivityBuilderModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityBuilderModule::class,
        ApplicationModule::class,
        DataModule::class]
)
interface AppComponent : AndroidInjector<AppApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: AppApplication): Builder

        fun build(): AppComponent
    }

}

