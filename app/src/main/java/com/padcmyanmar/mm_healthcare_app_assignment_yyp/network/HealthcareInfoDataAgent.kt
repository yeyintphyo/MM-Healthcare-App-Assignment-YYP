package com.padcmyanmar.mm_healthcare_app_assignment_yyp.network

import com.padcmyanmar.mm_healthcare_app_assignment_yyp.data.vos.HealthcareInfoVO

interface HealthcareInfoDataAgent {
    fun loadHealthcareInfo(accessToken: String)
}