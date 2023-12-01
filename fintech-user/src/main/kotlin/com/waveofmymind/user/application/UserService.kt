package com.waveofmymind.user.application

import com.waveofmymind.user.global.error.UserNotFoundException
import com.waveofmymind.user.global.jwt.JwtProvider
import com.waveofmymind.user.global.jwt.LoginToken
import com.waveofmymind.user.presentation.LoginUserCommand
import com.waveofmymind.user.presentation.UserResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
    private val userReader: UserReader,
    private val userWriter: UserWriter,
    private val jwtProvider: JwtProvider
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
        val findUser = userReader.getUser(id)
        return UserResponse.from(findUser.id, findUser.email, findUser.name)
    }

    @Transactional(readOnly = true)
    fun loginUser(command: LoginUserCommand): LoginToken {
        val user = userReader.getUserByEmail(command.email) ?: throw UserNotFoundException()
        user.checkAuthenticity(command.password)
        return jwtProvider.generateLoginToken(user)
    }
}
