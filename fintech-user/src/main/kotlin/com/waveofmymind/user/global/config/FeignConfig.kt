package com.waveofmymind.user.global.config

import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Configuration

@Configuration
@EnableFeignClients(basePackages = ["com.waveofmymind.user.presentation.feign"])
class FeignConfig
