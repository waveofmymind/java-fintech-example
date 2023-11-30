package com.waveofmymind.gateway

import java.time.LocalDateTime

data class MainResponse(
    val message: String,
    val redirectUrl: String,
    val timestamp: LocalDateTime = LocalDateTime.now()
)