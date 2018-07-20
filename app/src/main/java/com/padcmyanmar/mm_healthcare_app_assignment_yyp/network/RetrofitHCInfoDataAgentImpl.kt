package com.padcmyanmar.mm_healthcare_app_assignment_yyp.network

import com.google.gson.Gson
import com.padcmyanmar.mm_healthcare_app_assignment_yyp.events.ApiErrorEvent
import com.padcmyanmar.mm_healthcare_app_assignment_yyp.events.SuccessGetHealthcareInfoEvent
import com.padcmyanmar.mm_healthcare_app_assignment_yyp.network.response.GetHealthInfoResponse
import com.padcmyanmar.mm_healthcare_app_assignment_yyp.utils.CommonConstants
import okhttp3.OkHttpClient
import org.greenrobot.eventbus.EventBus
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitHCInfoDataAgentImpl: HealthcareInfoDataAgent {

    companion object {
        private var INSTANCE: RetrofitHCInfoDataAgentImpl? = null
        fun getInstance(): RetrofitHCInfoDataAgentImpl {
            if (INSTANCE == null) {
                INSTANCE = RetrofitHCInfoDataAgentImpl()
            }

            val i = INSTANCE
            return i!!
        }
    }

    private val mHCInfoApi: HCInfoApi

    private constructor() {//check sentence constructor for change
        val okHttpClient = OkHttpClient.Builder() //check sentence val
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build()

        val retrofit = Retrofit.Builder() //check sentence ::
                .baseUrl(CommonConstants.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .client(okHttpClient)
                .build()

        mHCInfoApi = retrofit.create(HCInfoApi::class.java)//check sentence ::
    }


    override fun loadHealthcareInfo(accessToken: String) {
        val responseCall = mHCInfoApi.loadHCInfos(accessToken)
        responseCall.enqueue(object : Callback<GetHealthInfoResponse> { //check sentence object :

            override fun onFailure(call: Call<GetHealthInfoResponse>?, t: Throwable?) {
                EventBus.getDefault().post(ApiErrorEvent(t!!.message.toString()))
            }

            override fun onResponse(call: Call<GetHealthInfoResponse>, response: Response<GetHealthInfoResponse>) {
                val hcInfoResponse: GetHealthInfoResponse? = response.body()
                if (hcInfoResponse != null
                        && hcInfoResponse.code == 200
                        && hcInfoResponse.healthcareInfoList!!.isNotEmpty()) { //check sentence isNotEmpty
                    EventBus.getDefault().post(SuccessGetHealthcareInfoEvent(hcInfoResponse.healthcareInfoList))
                } else {
                    if(hcInfoResponse != null)
                        EventBus.getDefault().post(ApiErrorEvent(hcInfoResponse.message))
                    else
                        EventBus.getDefault().post(ApiErrorEvent("Empty response in network call."))
                }
            }
        })
    }
}