package com.padcmyanmar.mm_healthcare_app_assignment_yyp.data.models

import com.padcmyanmar.mm_healthcare_app_assignment_yyp.data.vos.HealthcareInfoVO
import com.padcmyanmar.mm_healthcare_app_assignment_yyp.delegates.HealthcareInfoDelegate
import com.padcmyanmar.mm_healthcare_app_assignment_yyp.events.SuccessGetHealthcareInfoEvent
import com.padcmyanmar.mm_healthcare_app_assignment_yyp.network.HealthcareInfoDataAgent
import com.padcmyanmar.mm_healthcare_app_assignment_yyp.network.RetrofitHCInfoDataAgentImpl
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class HealthcareInfoModel {

    companion object {
        private val accessToken = "b002c7e1a528b7cb460933fc2875e916"
        private var INSTANCE: HealthcareInfoModel? = null
        fun getInstance(): HealthcareInfoModel {
            if (INSTANCE == null) {
                INSTANCE = HealthcareInfoModel()
            }

            val i = INSTANCE
            return i!!
        }
    }

    private var mHCInfoData: HashMap<String, HealthcareInfoVO> = HashMap()
    private var hcInfoDataAgent: HealthcareInfoDataAgent? = null

    private constructor() {
        hcInfoDataAgent = RetrofitHCInfoDataAgentImpl.getInstance()
        EventBus.getDefault().register(this)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onSuccessGetHealthInfo(event: SuccessGetHealthcareInfoEvent) {
        setHealthInfoDataRepo(event.healthcareInfoList)
    }

    fun setHealthInfoDataRepo(mHealthList: List<HealthcareInfoVO>) {

        for (healthCare: HealthcareInfoVO in mHealthList) {
            mHCInfoData[healthCare.id] = healthCare
        }
    }

    fun getHealthInfoById(id: String): HealthcareInfoVO? {

        return mHCInfoData[id]
    }

    fun loadHealthCareInfo() {

        hcInfoDataAgent!!.loadHealthcareInfo(accessToken)
    }
}