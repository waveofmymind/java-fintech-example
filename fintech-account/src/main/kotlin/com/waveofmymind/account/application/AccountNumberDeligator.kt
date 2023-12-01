package com.waveofmymind.account.application

private const val PHONE_NUMBER_DELIMITER = "-"
private const val DEPOSIT_ACCOUNT_PREFIX = "100"

object AccountNumberDeligator {

    fun generateAccountNumber(phoneNumber: String): String {
        val splitPhoneNumber = phoneNumber.drop(4).split(PHONE_NUMBER_DELIMITER)
        return DEPOSIT_ACCOUNT_PREFIX + "-${splitPhoneNumber.joinToString("-")}"
    }
}
