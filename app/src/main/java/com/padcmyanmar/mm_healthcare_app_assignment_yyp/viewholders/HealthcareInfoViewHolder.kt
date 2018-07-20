package com.padcmyanmar.mm_healthcare_app_assignment_yyp.viewholders

import android.support.v7.widget.RecyclerView
import android.view.View
import com.bumptech.glide.Glide
import com.padcmyanmar.mm_healthcare_app_assignment_yyp.data.vos.HealthcareInfoVO
import com.padcmyanmar.mm_healthcare_app_assignment_yyp.delegates.HealthcareInfoDelegate
import kotlinx.android.synthetic.main.view_holder_healthcare_info.view.*

class HealthcareInfoViewHolder(itemView: View) : BaseViewHolder<HealthcareInfoVO>(itemView) {

    override fun bindData(data: HealthcareInfoVO) {
        mData = data

        itemView.tv_health_care_title.text = data.title

        Glide.with(itemView.context)
        .load(data.image)
        .into(itemView.iv_health_care_img)

    }

    override fun onClick(v: View?) {
    }

}