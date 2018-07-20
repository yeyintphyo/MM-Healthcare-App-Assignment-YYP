package com.padcmyanmar.mm_healthcare_app_assignment_yyp.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import com.padcmyanmar.mm_healthcare_app_assignment_yyp.viewholders.BaseViewHolder

abstract class BaseRecyclerAdapter<VH, T> : RecyclerView.Adapter<BaseViewHolder<T>>() {

    protected var mData : List<T>? = null

    init {
        mData = ArrayList()
    }

    override fun getItemCount(): Int {
        return mData!!.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        holder.bindData(mData!![position])
    }

    fun setDataList(dataList : List<T>){
        mData = dataList
        notifyDataSetChanged()
    }
}