package com.waveofmymind.account.presentation

import com.waveofmymind.account.application.CreateAccountCommand

data class CreateAccountRequest(
    val name: String,
    val password: String
) {
    fun toCommand(userId: Long) = CreateAccountCommand(userId, name, password)
}
