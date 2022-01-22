plugins {
    kotlin("jvm") version "1.3.61"
}

group = "ru.otus.kotlin22.first"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation(kotlin("test-junit"))
}