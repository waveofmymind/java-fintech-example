package com.waveofmymind.user.global.error

import org.springframework.http.HttpStatus

enum class ErrorCode(
    val message: String,

    val code: HttpStatus
) {
    ACCOUNT_EXISTS("해당 유저는 이미 계좌가 존재합니다.", HttpStatus.CONFLICT),
    USER_NOT_FOUND("해당 유저를 찾을 수 없습니다.", HttpStatus.NOT_FOUND)


}