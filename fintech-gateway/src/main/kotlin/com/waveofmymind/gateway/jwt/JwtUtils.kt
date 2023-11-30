package com.waveofmymind.gateway.jwt

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.interfaces.DecodedJWT
import org.springframework.stereotype.Component

@Component
object JwtVerifier {

    fun verify(token: String, secretKey: String): DecodedJWT {
        try {
            return JWT.require(Algorithm.HMAC256(secretKey))
                .build()
                .verify(token)
        } catch (e: Exception) {
            throw JwtException("토큰이 유효하지 않습니다.")
        }
    }
}
