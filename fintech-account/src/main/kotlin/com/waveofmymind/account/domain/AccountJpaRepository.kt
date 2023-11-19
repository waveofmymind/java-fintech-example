package com.waveofmymind.account.domain

import org.springframework.data.jpa.repository.JpaRepository

interface AccountJpaRepository : JpaRepository<Account, Long> {
    fun findByUserIdAndName(userId: Long, name: String): Account?
}
