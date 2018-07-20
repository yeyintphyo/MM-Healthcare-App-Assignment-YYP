package com.padcmyanmar.mm_healthcare_app_assignment_yyp.network.response

import com.google.gson.annotations.SerializedName
import com.padcmyanmar.mm_healthcare_app_assignment_yyp.data.vos.HealthcareInfoVO

data class GetHealthInfoResponse(
        @SerializedName("code") val code: Int = 0,
        @SerializedName("message") val message: String = "",
        @SerializedName("healthcare-info") val healthcareInfoList: List<HealthcareInfoVO>? = null
){

    fun isResponseOK(): Boolean{
        return code == 200 && healthcareInfoList != null
    }
}