package com.waveofmymind.account.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Account(

    private val userId: Long,

    private val name: String,

    private val password: String,

    private val accountNumber: String,

    private val balance: Long,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L
) {
    companion object {
        @JvmStatic
        fun of(userId: Long, name: String, password: String, accountNumber: String): Account {
            return Account(userId, name, password, accountNumber, 0L)
        }
    }
}
