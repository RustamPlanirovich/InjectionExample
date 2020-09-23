package com.github.wpanas.injectionexample

import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
//Абстрактный класс который непосредственно проводит иньекцию в другие классы
//где это необходимо
abstract class ActivityProvider {
    @ContributesAndroidInjector
    //Класс куда инжектим данные
    abstract fun mainActivity(): MainActivity
}