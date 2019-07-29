package com.koinwork.test.deps

import com.koinwork.test.ui.autopurchase.AutoPurchaseActivity
import com.koinwork.test.ui.autopurchase.AutoPurchasePresenter
import com.koinwork.test.ui.createautopurchase.CreateAutoPurchaseActivity
import com.koinwork.test.ui.createautopurchase.CreateAutoPurchasePresenter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponents {

    fun inject(activity: AutoPurchaseActivity)
    fun inject(activity: CreateAutoPurchaseActivity)

    fun inject(presenter: AutoPurchasePresenter)
    fun inject(presenter: CreateAutoPurchasePresenter)
}