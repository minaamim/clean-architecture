import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.2.1"
    id("io.spring.dependency-management") version "1.1.4"
    id("com.google.cloud.tools.jib") version "3.4.0"    // official github: https://github.com/GoogleContainerTools/jib/tags
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

/*
    빌드방법
     - 빌드는 gitaction 또는 Jenkins를 통해 빌드한다.
     - 일반적인 gradle빌드와 동일하나 "build" 명령어 대신 "jib" 명령어를 사용한다
     - 명령어 예시: ./gradlew clean jib -x test
 */
jib {
    from {
        image = "eclipse-temurin:17" // 베이스 이미지 ( jdk 버전에 맞춰서 설정, "openjdk:17-jdk-slim-buster"도 무방 )
    }
    to {
        image = "johnpark0921/lotto-portfolio:tagname"  // Docker Image를 push할 DockerRegistry 경로 ( ${dockerId}/${projectName}:${version} )
    }
    // Docker Container 설정정보 ( optional )
    container {
        labels.set(
            mapOf(
                "maintainer" to "Teople팀 <mina> <yoonho>"
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