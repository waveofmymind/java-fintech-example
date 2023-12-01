package com.waveofmymind.account.global.error

sealed class BusinessException(
    errorCode: ErrorCode
) : RuntimeException(errorCode.message)

class AccountExistsException(
    errorCode: ErrorCode = ErrorCode.ACCOUNT_EXISTS
) : BusinessException(errorCode)
