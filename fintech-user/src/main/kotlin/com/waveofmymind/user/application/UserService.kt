package com.waveofmymind.user.application

import com.waveofmymind.user.presentation.UserResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
    private val userReader: UserReader,
    private val userWriter: UserWriter
) {

    @Transactional
    fun joinUser(command: JoinUserCommand) {
        userReader.getUserByEmail(command.email)?.let {
            throw IllegalArgumentException("이미 존재하는 이메일입니다.")
        }
        userWriter.joinUser(command)
    }

    @Transactional(readOnly = true)
    fun getUser(id: Long): UserResponse {
        return userReader.getUser(id)
    }
}
