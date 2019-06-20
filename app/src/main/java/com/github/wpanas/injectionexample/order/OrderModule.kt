package com.github.wpanas.injectionexample.order

import com.github.wpanas.injectionexample.coffee.CoffeeService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class OrderModule {
    @Provides
    @Singleton
    fun orderService(coffeeService: CoffeeService) = OrderService(coffeeService)
}

class OrderService(private val coffeeService: CoffeeService) {
    fun askForOrder() = "Would you like some ${coffeeService.fetchCoffee()}?"
}