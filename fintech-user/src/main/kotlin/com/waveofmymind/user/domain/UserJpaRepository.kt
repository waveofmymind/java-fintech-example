package com.waveofmymind.user.domain

import org.springframework.data.jpa.repository.JpaRepository

interface UserJpaRepository : JpaRepository<User, Long> {
    fun findByEmail(email: String): User?
}
