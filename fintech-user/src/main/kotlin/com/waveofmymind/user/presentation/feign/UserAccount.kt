package com.waveofmymind.user.presentation.feign

data class UserAccount(
    val id: Long,
    val userId: Long,
    val name: String,
    val accountNumber: String,
    val balance: Long
)
