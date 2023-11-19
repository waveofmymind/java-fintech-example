package com.waveofmymind.account.presentation

import com.waveofmymind.account.application.CreateAccountCommand

data class CreateAccountRequest(
    val userId: Long,
    val name: String,
    val password: String
) {
    fun toCommand() = CreateAccountCommand(userId, name, password)
}
