package com.waveofmymind.user.presentation

import com.waveofmymind.user.application.JoinUserCommand

data class JoinUserRequest(
    private val name: String,
    private val email: String,
    private val password: String
) {
    fun toCommand() = JoinUserCommand(
        name = name,
        email = email,
        password = password
    )
}
