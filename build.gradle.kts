import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.1.6" apply false
    id("io.spring.dependency-management") version "1.1.4" apply false
    kotlin("jvm") version "1.9.20"
    kotlin("plugin.spring") version "1.9.20" apply false
    kotlin("plugin.jpa") version "1.9.20" apply false
    kotlin("kapt") version "1.9.20" apply false
}

repositories {
    mavenCentral()
}

subprojects {
    apply(plugin = "java")
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "org.jetbrains.kotlin.kapt")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")
    apply(plugin = "org.jetbrains.kotlin.plugin.jpa")
    apply(plugin = "kotlin-kapt")

    group = "com.waveofmymind"
    version = "0.0.1-SNAPSHOT"

    java.sourceCompatibility = JavaVersion.VERSION_17

    repositories {
        mavenCentral()
    }


    dependencies {
        implementation("org.springframework.kafka:spring-kafka")
        testImplementation("org.springframework.kafka:spring-kafka-test")

        // kotlin
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs += "-Xjsr305=strict"
            jvmTarget = "17"
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}

