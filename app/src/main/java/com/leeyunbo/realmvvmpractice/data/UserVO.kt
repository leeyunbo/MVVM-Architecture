package com.leeyunbo.realmvvmpractice.data

import com.google.gson.annotations.SerializedName

data class UserVO(
    @SerializedName("accessId")
    var accessId: String,

    @SerializedName("nickname")
    var nickname: String,

    @SerializedName("level")
    var level: Int,

    @SerializedName("division")
    var division: Int,

    @SerializedName("matchType")
    var matchType: Int
)