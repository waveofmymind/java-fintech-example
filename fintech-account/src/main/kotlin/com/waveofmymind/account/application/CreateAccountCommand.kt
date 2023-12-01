package com.waveofmymind.account.application

data class CreateAccountCommand(
    val userId: Long,
    val name: String,
    val password: String,
    val phoneNumber: String
)
