/*
 * This file was generated by the Gradle 'init' task.
 */

plugins {
    java
    `maven-publish`
}

repositories {
    mavenLocal()
    maven {
        url = uri("https://repo.maven.apache.org/maven2/")
    }
}

dependencies {
    implementation("org.slf4j:slf4j-api:2.0.1")
    implementation("ch.qos.logback:logback-classic:1.4.1")
    implementation("org.picocontainer:picocontainer:2.15")
    implementation("org.instilled:Dotter:0.0.1")
    testImplementation("junit:junit:4.13.2")
}

group = "org.instilled"
version = "0.0.1-SNAPSHOT"
description = "Hx"
java.sourceCompatibility = JavaVersion.VERSION_1_6

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
    }
}

tasks.withType<JavaCompile>() {
    options.encoding = "UTF-8"
}
