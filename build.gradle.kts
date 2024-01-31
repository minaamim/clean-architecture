import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.2.1"
    id("io.spring.dependency-management") version "1.1.4"
    id("com.google.cloud.tools.jib") version "3.4.0"
    kotlin("jvm") version "1.9.21"
    kotlin("plugin.spring") version "1.9.21"
    kotlin("plugin.jpa") version "1.9.21"
}

group = "ddd.teople"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

ext {
    set("springCloudVersion", "2023.0.0")
}

dependencies {
    val kotestVersion = "5.8.0"
    val cucumberVersion = "7.11.1"

    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation ("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    implementation ("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation ("mysql:mysql-connector-java:8.0.33")
    runtimeOnly ("com.mysql:mysql-connector-j")

    //cache
    implementation("org.springframework.boot:spring-boot-starter-cache")
    implementation("com.github.ben-manes.caffeine:caffeine")
    implementation("io.github.microutils:kotlin-logging:3.0.5")

    //vault
    implementation("org.springframework.vault:spring-vault-core:3.1.0")

    //test
    testImplementation("com.ninja-squad:springmockk:3.1.1")

    // Kotest
    testImplementation("io.kotest:kotest-runner-junit5:$kotestVersion")
    testImplementation("io.kotest:kotest-assertions-core:$kotestVersion")
    implementation("io.kotest.extensions:kotest-extensions-spring:1.1.3")


    //cucumber
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.junit.platform:junit-platform-suite")
    testImplementation("io.cucumber:cucumber-java:$cucumberVersion")
    testImplementation("io.cucumber:cucumber-junit-platform-engine:$cucumberVersion")
    testImplementation("io.cucumber:cucumber-spring:$cucumberVersion")
    testImplementation("io.kotest:kotest-assertions-core:5.8.0")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:2023.0.0")
    }
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

tasks.named("compileJava") {
    inputs.files(tasks.named("processResources"))
}

jib {
    from {
        image = "eclips-temurin:17"
    }
    to {
        image = "mina5814/teople"
        auth {
            username = "teople"
            password = "dckr_pat_BHVcbLi6g8MFW8N-uLKx7FfXCaI"
        }
    }

    container {
        labels.set(
            mapOf(
                "maintainer" to "Teople <mina> <yoonho>"
            )
        )
        creationTime.set("USE_CURRENT_TIMESTAMP")
        environment = mapOf(
            "TZ" to "Asia/Seoul"
        )
        jvmFlags = listOf(
            "-Dsun.net.inetaddr.ttl=0",
            "-XX:+PrintCommandLineFlags",
            "-XX:+UseContainerSupport"
        )
    }
}