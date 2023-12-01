package com.waveofmymind.account.global.error

import org.springframework.http.HttpStatus

enum class ErrorCode(
    val message: String,

    val code: HttpStatus
) {
    ACCOUNT_EXISTS("해당 유저는 이미 계좌가 존재합니다.", HttpStatus.CONFLICT)
}
