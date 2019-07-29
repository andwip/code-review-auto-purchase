package com.koinwork.test.deps

import android.app.Application
import android.content.Context
import com.koinwork.test.ui.autopurchase.AutoPurchasePresenter
import com.koinwork.test.ui.autopurchase.adapter.GradeAdapter
import com.koinwork.test.ui.createautopurchase.CreateAutoPurchasePresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val application: Application) {

    @Singleton
    @Provides
    fun provideContext(): Context {
        return application.applicationContext as Context
    }

    @Provides
    @Singleton
    fun provideAutoPurchasePresenter(context: Context): AutoPurchasePresenter {
        return AutoPurchasePresenter(context)
    }

    @Provides
    @Singleton
    fun provideCreateAutoPurchasePresenter(context: Context): CreateAutoPurchasePresenter {
        return CreateAutoPurchasePresenter(context)
    }

    @Provides
    @Singleton
    fun provideGradeAdapter(): GradeAdapter {
        return GradeAdapter()
    }
}