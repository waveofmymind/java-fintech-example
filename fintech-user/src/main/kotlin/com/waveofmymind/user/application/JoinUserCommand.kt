package com.waveofmymind.user.application

import com.waveofmymind.user.domain.User

data class JoinUserCommand(
    private val name: String,
    val email: String,
    private val password: String,
    private val phoneNumber: String
) {
    fun toEntity() = User.from(
        name = name,
        email = email,
        password = password,
        phoneNumber = phoneNumber
    )
}
