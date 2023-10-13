import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.0"
    id("com.github.johnrengelman.shadow") version "7.0.0" // shadowJar 플러그인
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.vertx:vertx-core:4.2.1")
    implementation("io.vertx:vertx-web:4.2.1")
    implementation("io.vertx:vertx-web-client:4.2.1")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-jdk8:1.5.2")
}

tasks {
    withType<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar> {
        archiveBaseName.set("my-api")
        archiveVersion.set("0.1.0")
        archiveClassifier.set("")
    }
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "MainKt" // 여기서 `com.example.MainVerticle`는 메인 클래스의 전체 이름을 나타냅니다.
    }
}