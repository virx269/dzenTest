plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    testImplementation("com.codeborne:selenide:6.12.2")
    testImplementation("io.github.bonigarcia:webdrivermanager:5.6.2")
}

tasks.test {
    useJUnitPlatform()
}