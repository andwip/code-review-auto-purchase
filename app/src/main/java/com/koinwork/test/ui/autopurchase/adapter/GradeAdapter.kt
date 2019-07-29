package com.koinwork.test.ui.autopurchase.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.koinwork.test.R
import com.koinwork.test.common.Constanst.TYPE_CONTENT
import com.koinwork.test.common.Constanst.TYPE_EMPTY
import com.koinwork.test.databinding.ItemEmptyBinding
import com.koinwork.test.databinding.ItemGradeBinding
import com.koinwork.test.ui.autopurchase.model.GradeModel

class GradeAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var models: MutableList<GradeModel> = mutableListOf()

    private lateinit var listener: (Any, Int) -> Unit

    override fun getItemCount(): Int = models.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            TYPE_EMPTY -> EmptyViewHolder(
                DataBindingUtil.inflate(
                    layoutInflater, R.layout.item_empty,
                    parent, false
                ) as ItemEmptyBinding
            )
            TYPE_CONTENT -> GradeViewHolder(
                DataBindingUtil.inflate(
                    layoutInflater, R.layout.item_grade,
                    parent, false
                ) as ItemGradeBinding
            )
            else -> EmptyViewHolder(
                DataBindingUtil.inflate(
                    layoutInflater, R.layout.item_empty,
                    parent, false
                ) as ItemEmptyBinding
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, p1: Int) {
        when (holder) {
            is EmptyViewHolder -> holder.bindItem(models, p1)
            is GradeViewHolder -> holder.bindItem(models, p1)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (models[position].type) {
            TYPE_EMPTY -> TYPE_EMPTY
            TYPE_CONTENT -> TYPE_CONTENT
            else -> TYPE_CONTENT
        }
    }

    fun showData(models: MutableList<GradeModel>) {
        this.models = models
        notifyDataSetChanged()
    }

    fun getItem(listener: (Any, Int) -> Unit) {
        this.listener = listener
    }

    fun isEmptyAdapter(list: MutableList<GradeModel>) {
        this.models.addAll(list)
        notifyDataSetChanged()
    }

    private inner class EmptyViewHolder(val binding: ItemEmptyBinding) : RecyclerView.ViewHolder(binding.root) {

        init {

        }

        fun bindItem(model: MutableList<GradeModel>, position: Int) {
            val summary: GradeModel = model[position]
        }

        private fun getContext(): Context {
            return binding.root.context
        }
    }

    private inner class GradeViewHolder(val binding: ItemGradeBinding) : RecyclerView.ViewHolder(binding.root) {

        init {

        }

        fun bindItem(model: MutableList<GradeModel>, position: Int) {
            val summary: GradeModel = model[position]
        }

        private fun getContext(): Context {
            return binding.root.context
        }
    }

}