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
    val name: String,

    @NotNull
    val email: String,

    @NotNull
    val phoneNumber: String,

    @NotNull
    private val password: String,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    val id: Long = 0L
) {
    companion object {
        fun from(name: String, email: String, phoneNumber: String, password: String) =
            User(name, email, phoneNumber, password)
    }
}
