package com.github.wpanas.injectionexample.coffee

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

//Модуль предоставляющий какие либо данные или удовлетворение зависимсоти при сборке
@Module
class CoffeeModule {

    //Провайдим наш класс CoffeeService с какой либо информацией
    @Provides
    //Singleton указывается для того чтобы экземпляр создавался всего один раз при старте
    //приложения, далее информация кэшируется и при новом забросе этой же информации берется
    //из кэша
    @Singleton
    fun coffeeService() = CoffeeService()
}

//Собственно наш класс предоставлющий информацию или удовлетворяет зависимость.
class CoffeeService {
    fun prepareCoffee() = "Here! Espresso for you"
    fun fetchCoffee() = "espresso"
}

