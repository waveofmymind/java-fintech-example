package com.waveofmymind.user.config

import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Configuration

@Configuration
@EnableFeignClients(basePackages = ["com.waveofmymind.user.presentation.feign"])
class FeignConfig
