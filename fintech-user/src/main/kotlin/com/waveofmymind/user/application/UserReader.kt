package com.waveofmymind.user.application

import com.waveofmymind.user.domain.User
import com.waveofmymind.user.domain.UserJpaRepository
import com.waveofmymind.user.global.error.UserNotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class UserReader(
    private val userRepository: UserJpaRepository
) {

    fun getUser(id: Long): User = userRepository.findByIdOrNull(id) ?: throw UserNotFoundException()


    fun getUserByEmail(email: String): User? {
        return userRepository.findByEmail(email)
    }
}
