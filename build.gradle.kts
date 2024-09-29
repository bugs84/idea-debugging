plugins {
    kotlin("jvm") version "2.0.20"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains:annotations:25.0.0")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}

// Configure the source sets to include both Java and Kotlin files in the same directory
sourceSets {
    main {
        java {
            srcDirs("src/main/kotlin")
        }
//        kotlin {
//            srcDirs("src/main/kotlin")
//        }
    }
    test {
        java {
            srcDirs("src/test/kotlin")
        }
//        kotlin {
//            srcDirs("src/test/kotlin")
//        }
    }
}