package com.waveofmymind.account.application

data class FindAccountResponse(
    val id: Long,
    val userId: Long,
    val name: String,
    val accountNumber: String,
    val balance: Long
) {
    companion object {
        @JvmStatic
        fun from(
            id: Long,
            userId: Long,
            name: String,
            accountNumber: String,
            balance: Long
        ): FindAccountResponse {
            return FindAccountResponse(
                id,
                userId,
                name,
                accountNumber,
                balance
            )
        }
    }
}
