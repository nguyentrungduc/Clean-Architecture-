package com.example.cleanarchitecture.data.model

import com.example.cleanarchitecture.data.base.ModelEntity

open class Token(
    var token: String = "",
    var refreshToken: String = "",
    var expireIn: Long = 0
) : ModelEntity()