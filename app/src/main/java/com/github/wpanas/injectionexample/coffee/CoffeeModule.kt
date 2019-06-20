package com.github.wpanas.injectionexample.coffee

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CoffeeModule {
    @Provides
    @Singleton
    fun coffeeService() = CoffeeService()
}

class CoffeeService {
    fun prepareCoffee() = "Here! Espresso for you"
    fun fetchCoffee() = "espresso"
}

