package com.boris.netgame.data.model.response

import com.google.gson.annotations.SerializedName

enum class Code {
    @SerializedName("0")
    SUCCESS,
    @SerializedName("1")
    ERROR
}