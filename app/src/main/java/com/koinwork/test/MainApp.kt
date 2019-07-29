package com.koinwork.test

import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex
import com.koinwork.test.deps.AppComponents
import com.koinwork.test.deps.AppModule
import com.koinwork.test.deps.DaggerAppComponents

open class MainApp: Application() {


    private var mainApp: MainApp = this@MainApp
    private lateinit var appComponents: AppComponents

    companion object {

        const val DEFAULT_LANGUAGE: String = "en"

        @Synchronized
        fun create(context: Context?): MainApp {
            return context?.applicationContext as MainApp
        }
    }

    override fun onCreate() {
        super.onCreate()
        MultiDex.install(mainApp)
        setAppComponents()
    }

    fun provides(): AppComponents {
        return appComponents
    }

    private fun setAppComponents() {
        this.appComponents = DaggerAppComponents.builder()
            .appModule(AppModule(mainApp))
            .build()
    }
}