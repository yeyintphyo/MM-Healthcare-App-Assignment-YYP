package com.padcmyanmar.mm_healthcare_app_assignment_yyp.network

import com.padcmyanmar.mm_healthcare_app_assignment_yyp.network.response.GetHealthInfoResponse
import com.padcmyanmar.mm_healthcare_app_assignment_yyp.utils.CommonConstants
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface HCInfoApi {
    @FormUrlEncoded
    @POST(CommonConstants.API_GET_HCINFO)
    fun loadHCInfos(
            @Field(CommonConstants.PARAM_ACCESS_TOKEN) accessToken: String) : Call<GetHealthInfoResponse>
}