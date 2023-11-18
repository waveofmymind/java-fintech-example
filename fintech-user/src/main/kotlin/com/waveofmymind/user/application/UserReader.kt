package com.waveofmymind.user.application

import com.waveofmymind.user.domain.UserJpaRepository
import com.waveofmymind.user.presentation.UserResponse
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class UserReader(
    private val userRepository: UserJpaRepository
) {

    fun getUser(id: Long): UserResponse {
        val user = userRepository.findByIdOrNull(id) ?: throw IllegalArgumentException("유저를 찾지 못했습니다.")
        return UserResponse.from(user.id, user.name, user.email)
    }
}
