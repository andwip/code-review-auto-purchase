package com.koinwork.test.ui.autopurchase

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.koinwork.test.BaseActivity
import com.koinwork.test.MainApp
import com.koinwork.test.R
import com.koinwork.test.databinding.ActivityAutoPurchaseBinding
import com.koinwork.test.ui.autopurchase.adapter.GradeAdapter
import com.koinwork.test.ui.autopurchase.model.GradeModel
import kotlinx.android.synthetic.main.inner_grade.view.*
import javax.inject.Inject

class AutoPurchaseActivity : BaseActivity(), AutoPurchaseView {

    @Inject
    lateinit var presenter: AutoPurchasePresenter

    @Inject
    lateinit var gradeAdapter: GradeAdapter

    private lateinit var binding: ActivityAutoPurchaseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainApp.create(application).provides().inject(activity = this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_auto_purchase)
        binding.apply { binding.setPresenter = presenter }
        presenter.set(this)

        onClickItem()

        binding.cardExpnadable.setOnExpandedListener { view, isExpanded ->
            Toast.makeText(applicationContext, if (isExpanded) "Expanded!" else "Collapsed!", Toast.LENGTH_SHORT).show()

            view.rc_grade.apply {
                this.layoutManager = LinearLayoutManager(context)
                this.isNestedScrollingEnabled = false
                this.setHasFixedSize(true)
                this.adapter = gradeAdapter
            }

            gradeAdapter.isEmptyAdapter(presenter.isEmptyData())
        }
    }

    private fun onClickItem() {
        gradeAdapter.getItem { item, _ ->
            if (item is GradeModel) {

            }
        }
    }

}