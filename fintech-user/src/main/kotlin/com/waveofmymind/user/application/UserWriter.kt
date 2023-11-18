package com.waveofmymind.user.application

import com.waveofmymind.user.domain.UserJpaRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class UserWriter(
    private val userRepository: UserJpaRepository
) {
    fun joinUser(command: JoinUserCommand) {
        userRepository.save(command.toEntity())
    }
}
