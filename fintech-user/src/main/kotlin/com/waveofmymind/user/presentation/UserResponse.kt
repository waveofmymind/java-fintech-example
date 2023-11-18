package com.waveofmymind.user.presentation

data class UserResponse(
    val id: Long,
    val name: String,
    val email: String
) {
    companion object {
        @JvmStatic
        fun from(id: Long, name: String, email: String) = UserResponse(id, name, email)
    }
}
