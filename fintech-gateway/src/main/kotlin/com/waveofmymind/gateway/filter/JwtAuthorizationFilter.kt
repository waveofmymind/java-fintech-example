package com.waveofmymind.gateway.filter

import com.waveofmymind.gateway.jwt.JwtVerifier
import org.springframework.cloud.gateway.filter.GatewayFilter
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory
import org.springframework.http.HttpHeaders
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange

@Component
class JwtAuthenticationGatewayFilter : AbstractGatewayFilterFactory<
        JwtAuthenticationGatewayFilter.Config>(Config::class.java) {

    data class Config(
        var secretKey: String
    )

    override fun apply(config: Config): GatewayFilter {
        return GatewayFilter { exchange, chain ->
            val token = exchange.request.headers[HttpHeaders.AUTHORIZATION]?.get(0)?.substring(7)
            val decodedJwt = JwtVerifier.verify(token!!, config.secretKey)
            addAuthorizationHeader(exchange, decodedJwt.claims["id"].toString())
            chain.filter(exchange)
        }
    }

    private fun addAuthorizationHeader(exchange: ServerWebExchange, userId: String) {
        exchange.mutate().request(
            exchange.request.mutate().header("X-Authorization-id", userId).build()
        ).build()
    }
}
