package com.maersk.androidmng

import com.google.firebase.database.IgnoreExtraProperties
import java.io.Serializable

@IgnoreExtraProperties
data class User(
    var username: String? = "",
    var email: String? = ""
):Serializable
