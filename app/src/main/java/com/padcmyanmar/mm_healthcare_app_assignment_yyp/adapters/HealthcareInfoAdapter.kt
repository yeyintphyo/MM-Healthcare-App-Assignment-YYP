package com.padcmyanmar.mm_healthcare_app_assignment_yyp.adapters

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.padcmyanmar.mm_healthcare_app_assignment_yyp.R
import com.padcmyanmar.mm_healthcare_app_assignment_yyp.data.vos.HealthcareInfoVO
import com.padcmyanmar.mm_healthcare_app_assignment_yyp.delegates.HealthcareInfoDelegate
import com.padcmyanmar.mm_healthcare_app_assignment_yyp.viewholders.BaseViewHolder
import com.padcmyanmar.mm_healthcare_app_assignment_yyp.viewholders.HealthcareInfoViewHolder


class HealthcareInfoAdapter : BaseRecyclerAdapter<HealthcareInfoViewHolder, HealthcareInfoVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<HealthcareInfoVO> {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view: View = layoutInflater.inflate(R.layout.view_holder_healthcare_info, parent, false)
        return HealthcareInfoViewHolder(view)
    }

}