package com.waveofmymind.account.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Account(

    val userId: Long,

    val name: String,

    val password: String,

    val accountNumber: String,

    val activeStatus: ActiveStatus = ActiveStatus.ACTIVE,

    val balance: Long,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L
) {
    companion object {
        @JvmStatic
        fun of(userId: Long, name: String, password: String, accountNumber: String): Account {
            return Account(userId, name, password, accountNumber, ActiveStatus.ACTIVE, 0L)
        }
    }
}
