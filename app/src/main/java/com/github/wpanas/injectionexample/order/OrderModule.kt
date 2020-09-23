package com.github.wpanas.injectionexample.order

import com.github.wpanas.injectionexample.coffee.CoffeeService
import com.github.wpanas.injectionexample.coffee.CoffeeTwoService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

//Модуль предоставляющий какие либо данные или удовлетворение зависимсоти при сборке
@Module
class OrderModule {

    //Провайдим наш класс OrderService с какой либо информацией
    @Provides
    //Singleton указывается для того чтобы экземпляр создавался всего один раз при старте
    //приложения, далее информация кэшируется и при новом забросе этой же информации берется
    //из кэша
    @Singleton
    fun orderService(coffeeService: CoffeeService) = OrderService(coffeeService)


    //Провайдим наш класс OrderServiceTwo с какой либо информацией
    @Provides
    //Singleton указывается для того чтобы экземпляр создавался всего один раз при старте
    //приложения, далее информация кэшируется и при новом забросе этой же информации берется
    //из кэша
    @Singleton
    fun orderTwoService(coffeeTwoService: CoffeeTwoService) = OrderServiceTwo(coffeeTwoService)
}

//Собственно наш класс OrderServiceTwo предоставлющий информацию или удовлетворяет зависимость.
class OrderServiceTwo(private val coffeeTwoService: CoffeeTwoService) {
    fun askTwoOrder() = "Would you like some ${coffeeTwoService.fetchCoffeeTwo()}?"
}

//Собственно наш класс OrderService предоставлющий информацию или удовлетворяет зависимость.
class OrderService(private val coffeeService: CoffeeService) {
    fun askForOrder() = "Would you like some ${coffeeService.fetchCoffee()}?"
}
