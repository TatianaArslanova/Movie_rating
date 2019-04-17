package com.example.movierating.di

import android.content.Context
import com.example.movierating.di.modules.RetrofitModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun appContext(app: Context): Builder

        fun build(): AppComponent
    }

}