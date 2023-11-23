package com.waveofmymind.account.presentation

import com.waveofmymind.account.application.AccountService
import com.waveofmymind.account.application.FindAccountResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/accounts")
class AccountController(
    private val accountService: AccountService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createAccount(
        @RequestBody request: CreateAccountRequest
    ): String {
        val accountId = accountService.createAccount(request.toCommand())
        return "계좌 생성 완료: $accountId"
    }

    @GetMapping("/{userId}")
    fun getAccount(
        @PathVariable userId: Long
    ): FindAccountResponse {
        return accountService.getAccount(userId)
    }
}
