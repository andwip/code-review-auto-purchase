package com.koinwork.test.ui.autopurchase

import android.content.Context
import com.koinwork.test.MainApp
import com.koinwork.test.ui.autopurchase.model.GradeModel

class AutoPurchasePresenter(val context: Context) {

    private lateinit var view: AutoPurchaseView

    init {
        MainApp.create(context).provides().inject(presenter = this)
    }

    fun set(view: AutoPurchaseView) {
        this.view = view
    }

    fun isEmptyData(): MutableList<GradeModel> {
        val emptyData: MutableList<GradeModel> = mutableListOf()
        repeat(1) {
            emptyData.add(
                GradeModel(0,"","","", mutableListOf())
            )
        }
        return emptyData
    }
}