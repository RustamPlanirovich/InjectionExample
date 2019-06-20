package com.github.wpanas.injectionexample

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityProvider {
    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity
}