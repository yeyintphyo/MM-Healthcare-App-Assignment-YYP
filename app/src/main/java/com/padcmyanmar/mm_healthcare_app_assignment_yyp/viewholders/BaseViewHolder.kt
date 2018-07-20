package com.padcmyanmar.mm_healthcare_app_assignment_yyp.viewholders

import android.support.v7.widget.RecyclerView
import android.view.View

abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
    protected var mData: T? = null

    init {
        itemView.setOnClickListener(this)
    }

    abstract fun bindData(data: T);
}