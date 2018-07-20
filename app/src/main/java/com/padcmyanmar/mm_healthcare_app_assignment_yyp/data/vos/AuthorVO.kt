package com.padcmyanmar.mm_healthcare_app_assignment_yyp.data.vos

import com.google.gson.annotations.SerializedName

class AuthorVO(
        @SerializedName("author-id") val authorId: String,
        @SerializedName("author-name") val authorName: String,
        @SerializedName("author-picture") val authorPicture: String
)