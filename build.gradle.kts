import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.2.1"
    id("io.spring.dependency-management") version "1.1.4"
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
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
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
//    implementation("org.springframework.cloud:spring-cloud-config-server") //구성 서버
//    implementation("org.springframework.cloud:spring-cloud-starter-bootstrap") //부트스트랩
//    implementation("org.springframework.cloud:spring-cloud-starter-vault-config") //볼트
    implementation("org.springframework.vault:spring-vault-core:3.1.0")
//    implementation("org.springframework.cloud:spring-cloud-starter-aws-parameter-store-config:2.2.6.RELEASE")
//    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

    //test
    testImplementation("com.ninja-squad:springmockk:3.1.1")
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