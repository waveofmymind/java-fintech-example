package com.waveofmymind.account.presentation

data class CreateAccountRequest(
    val userId: Long,
    val name: String,
    val email: String
)
