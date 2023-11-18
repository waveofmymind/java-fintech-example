package com.waveofmymind.user.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.jetbrains.annotations.NotNull

@Entity
@Table(name = "user")
class User(

    @NotNull
    private val name: String,

    @NotNull
    private val email: String,

    @NotNull
    private val password: String,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private val id: Long = 0L
) {
    companion object {
        fun from(name: String, email: String, password: String) = User(name, email, password)
    }
}
