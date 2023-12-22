plugins {
    kotlin("jvm") version "1.9.21"
}

dependencies {
    implementation("org.junit.jupiter:junit-jupiter:5.10.1")
    testImplementation("io.kotest:kotest-runner-junit5:5.8.0")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.10.1")
}

tasks {
    wrapper {
        gradleVersion = "8.5"
    }
}
