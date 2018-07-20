package com.padcmyanmar.mm_healthcare_app_assignment_yyp.data.vos

import com.google.gson.annotations.SerializedName

class HealthcareInfoVO(
        @SerializedName("id") val id: String = "",
        @SerializedName("title") val title: String = "",
        @SerializedName("image") val image: String = "",
        @SerializedName("author") val author: AuthorVO? = null,
        @SerializedName("short-description") val shortDescription: String = "",
        @SerializedName("published-date") val publishedDate: String = "",
        @SerializedName("complete-url") val completeUrl: String = ""
)