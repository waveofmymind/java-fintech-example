package com.waveofmymind.user.global.error

import com.waveofmymind.account.global.error.ErrorCode

sealed class BusinessException(
    errorCode: ErrorCode
) : RuntimeException(errorCode.message)

class UserNotFoundException(
    errorCode: ErrorCode = ErrorCode.USER_NOT_FOUND
) : BusinessException(errorCode)
