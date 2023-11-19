package com.waveofmymind.user.presentation.feign

data class CreateAccountRequest(
    val userId: Long,
    val name: String,
    val email: String
)
