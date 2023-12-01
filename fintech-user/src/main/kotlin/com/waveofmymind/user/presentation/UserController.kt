package com.waveofmymind.user.presentation

import com.waveofmymind.user.application.UserService
import com.waveofmymind.user.global.jwt.LoginToken
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(
    private val userService: UserService
) {

    @PostMapping("/join")
    @ResponseStatus(HttpStatus.CREATED)
    fun join(@RequestBody request: JoinUserRequest) {
        userService.joinUser(request.toCommand())
    }

    @PostMapping("/login")
    fun login(@RequestBody request: LoginUserRequest): LoginToken {
        return userService.loginUser(request.toCommand())
    }

    @GetMapping
    fun getUser(@RequestHeader(X_AUTHORIZATION_ID) userId: String): UserResponse {
        println(userId)
        return userService.getUser(userId.toLong())
    }

    companion object {
        private const val X_AUTHORIZATION_ID = "X-Authorization-id"
    }
}
