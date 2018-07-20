package com.padcmyanmar.mm_healthcare_app_assignment_yyp.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import com.padcmyanmar.mm_healthcare_app_assignment_yyp.R
import com.padcmyanmar.mm_healthcare_app_assignment_yyp.adapters.HealthcareInfoAdapter
import com.padcmyanmar.mm_healthcare_app_assignment_yyp.data.models.HealthcareInfoModel
import com.padcmyanmar.mm_healthcare_app_assignment_yyp.delegates.HealthcareInfoDelegate
import com.padcmyanmar.mm_healthcare_app_assignment_yyp.events.ApiErrorEvent
import com.padcmyanmar.mm_healthcare_app_assignment_yyp.events.SuccessGetHealthcareInfoEvent
import kotlinx.android.synthetic.main.activity_mmhealthcare_list.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class MMHealthcareListActivity : BaseActivity(){

    private var mHCInfoAdater: HealthcareInfoAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mmhealthcare_list)
        rv_healthcare_list.layoutManager = LinearLayoutManager(applicationContext
                , LinearLayoutManager.VERTICAL
                , false)
        mHCInfoAdater = HealthcareInfoAdapter()
        rv_healthcare_list.adapter = mHCInfoAdater
        HealthcareInfoModel.getInstance().loadHealthCareInfo()
    }

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)

    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onSuccessGetHealthList(successEvent: SuccessGetHealthcareInfoEvent) {
        mHCInfoAdater!!.setDataList(successEvent.healthcareInfoList)

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onApiError(errorEvent: ApiErrorEvent) {
        Snackbar.make(rv_healthcare_list, "ERROR : " + errorEvent.errorMessage, Snackbar.LENGTH_INDEFINITE)
                .setAction("Action", null).show()
    }

}
