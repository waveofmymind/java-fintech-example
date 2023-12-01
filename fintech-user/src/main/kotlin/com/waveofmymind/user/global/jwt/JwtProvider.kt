package com.waveofmymind.user.global.jwt

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.waveofmymind.user.domain.User
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.Date

@Component
class JwtProvider {

    @Value("\${external.jwt.secret-key}")
    private lateinit var secretKey: String

    fun generateLoginToken(user: User): LoginToken {
        return LoginToken(
            accessToken = JWT.create()
                .withIssuer("waveofmymind")
                .withClaim("userId", user.id)
                .withClaim("email", user.email)
                .withClaim("name", user.name)
                .withExpiresAt(ACCESS_TOKEN_EXPIRED_DATE)
                .sign(Algorithm.HMAC256(secretKey))
        )
    }

    companion object {
        private val ACCESS_TOKEN_EXPIRED_DATE = Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 7)
    }
}