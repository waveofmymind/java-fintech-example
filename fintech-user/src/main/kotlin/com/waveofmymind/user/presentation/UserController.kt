package com.waveofmymind.user.presentation

import com.waveofmymind.user.application.UserService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
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

    @GetMapping("/{userId}")
    fun getUser(@PathVariable userId: Long): UserResponse {
        return userService.getUser(userId)
    }

    @PostMapping("/{userId}/accounts")
    fun account(@PathVariable userId: Long) {
        userService.createAccount(userId)
    }
}
