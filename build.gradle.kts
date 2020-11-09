import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "no.kartveit"
version = "1.0.0-SNAPSHOT"

val ktorVersion = "1.4.1"
val junitJupiterVersion = "5.6.0"
val kluentVersion = "1.61"
val logbackVersion = "1.2.3"
val logstashEncoderVersion = "5.1"

plugins {
    kotlin("jvm") version "1.4.10"
}

repositories {
    mavenCentral()
    jcenter()
}
dependencies {
    testImplementation(kotlin("test-junit5"))
    implementation(kotlin("stdlib"))

    implementation("io.ktor:ktor-server-netty:$ktorVersion")
    implementation("io.ktor:ktor-jackson:$ktorVersion")
    implementation("io.ktor:ktor-mustache:$ktorVersion")

    implementation("ch.qos.logback:logback-classic:$logbackVersion")
    implementation("net.logstash.logback:logstash-logback-encoder:$logstashEncoderVersion")

    testImplementation("org.amshove.kluent:kluent:$kluentVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitJupiterVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-params:$junitJupiterVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:$junitJupiterVersion")
    testImplementation("io.ktor:ktor-server-test-host:$ktorVersion") {
        exclude(group = "org.eclipse.jetty")
    }
}
tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "13"
}