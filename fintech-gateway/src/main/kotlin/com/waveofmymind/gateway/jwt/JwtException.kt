package com.waveofmymind.gateway.jwt

class JwtException(
    override val message: String
) : RuntimeException(message) {
}