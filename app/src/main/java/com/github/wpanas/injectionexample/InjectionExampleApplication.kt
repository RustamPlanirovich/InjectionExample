package com.github.wpanas.injectionexample

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class InjectionExampleApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val appComponent = DaggerAppComponent.builder()
            .build()

        appComponent.inject(this)

        return appComponent
    }
}