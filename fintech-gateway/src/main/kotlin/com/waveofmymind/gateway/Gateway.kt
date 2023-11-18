package com.waveofmymind.gateway

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.RestController

@RestController
@SpringBootApplication
class Gateway

fun main(args: Array<String>) {
    runApplication<Gateway>(*args)
}
