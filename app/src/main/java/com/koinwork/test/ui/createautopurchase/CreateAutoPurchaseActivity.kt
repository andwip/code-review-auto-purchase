package com.koinwork.test.ui.createautopurchase

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.koinwork.test.BaseActivity
import com.koinwork.test.MainApp
import com.koinwork.test.R
import com.koinwork.test.databinding.ActivityCreateAutoPurchaseBinding
import javax.inject.Inject

class CreateAutoPurchaseActivity : BaseActivity(), CreateAutoPurchaseView {

    @Inject
    lateinit var presenter: CreateAutoPurchasePresenter

    private lateinit var binding: ActivityCreateAutoPurchaseBinding

    companion object {
        fun create(): CreateAutoPurchaseActivity = CreateAutoPurchaseActivity()
    }

    fun start(context: Context, title: String, url: String) {
        val intent = Intent(context, CreateAutoPurchaseActivity::class.java)
        context.startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainApp.create(application).provides().inject(activity = this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_create_auto_purchase)
        binding.apply { binding.setPresenter = presenter }
        presenter.set(this)
    }
}