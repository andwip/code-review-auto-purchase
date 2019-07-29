package com.koinwork.test.ui.createautopurchase

import android.content.Context
import com.koinwork.test.MainApp

class CreateAutoPurchasePresenter(val context: Context) {

    private lateinit var view: CreateAutoPurchaseView

    init {
        MainApp.create(context).provides().inject(presenter = this)
    }

    fun set(view: CreateAutoPurchaseView) {
        this.view = view
    }

}