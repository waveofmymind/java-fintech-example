package com.waveofmymind.user.global.error

sealed class BusinessException(
    errorCode: ErrorCode
) : RuntimeException(errorCode.message)

class UserNotFoundException(
    errorCode: ErrorCode = ErrorCode.USER_NOT_FOUND
) : BusinessException(errorCode)
