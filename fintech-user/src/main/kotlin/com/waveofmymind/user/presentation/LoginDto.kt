package com.waveofmymind.user.presentation

data class LoginUserRequest(
    val email: String,
    val password: String
) {
    fun toCommand() = LoginUserCommand(email, password)

}

data class LoginUserCommand(
    val email: String,
    val password: String
)
