import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    val kotlinVersion = "1.9.21"
    id("org.springframework.boot") version "3.2.1"
    id("io.spring.dependency-management") version "1.1.4"
    kotlin("jvm") version kotlinVersion
    kotlin("plugin.spring") version kotlinVersion
    kotlin("plugin.jpa") version kotlinVersion

    // Java에서 사용하는 annotation을 kotlin에서도 사용하기 위해 kapt 플러그인 사용
    // kpat는 현재 maintenance mode(유지보수 모드)로 추가기능 지원하지 않고 있음
    // 대체재로 KSP가 있으나 아직 QueryDSL을 지원하지 않음
    kotlin("kapt") version kotlinVersion
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


    // QueryDSL
    //  - javax에서 jakarta로 변경
    implementation("com.querydsl:querydsl-jpa:5.0.0:jakarta")
    kapt("com.querydsl:querydsl-apt:5.0.0:jakarta")
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