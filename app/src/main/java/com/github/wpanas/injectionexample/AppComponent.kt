package com.github.wpanas.injectionexample

import com.github.wpanas.injectionexample.coffee.CoffeeModule
import com.github.wpanas.injectionexample.order.OrderModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, ActivityProvider::class, CoffeeModule::class, OrderModule::class])
interface AppComponent : AndroidInjector<DaggerApplication>