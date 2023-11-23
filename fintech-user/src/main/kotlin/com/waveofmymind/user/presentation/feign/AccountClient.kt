package com.waveofmymind.user.presentation.feign

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@FeignClient(name = "CreateAccountOpenFeign", url = "http://localhost:8082/accounts")
interface AccountClient {

    @PostMapping(consumes = ["application/json"])
    fun createAccount(
        @RequestBody
        request: CreateAccountRequest
    ): String

    @GetMapping("/{userId}")
    fun getAccount(
        @PathVariable userId: Long
    ): UserAccount
}
