package com.github.wpanas.injectionexample

import com.github.wpanas.injectionexample.coffee.CoffeeModule
import com.github.wpanas.injectionexample.coffee.CoffeeTwo
import com.github.wpanas.injectionexample.order.OrderModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

//Singleton указывается для того чтобы экземпляр создавался всего один раз при старте
//приложения, далее информация кэшируется и при новом забросе этой же информации берется
//из кэша
@Singleton
//Собираем все наши классы предоставлющие данные либо удовлетворяющие зависимости
//в массив modules
@Component(modules = [AndroidSupportInjectionModule::class, ActivityProvider::class,
    CoffeeModule::class, OrderModule::class, CoffeeTwo::class])
//Интерфейс создающий скрытый код для верной работы DI
interface AppComponent : AndroidInjector<DaggerApplication>