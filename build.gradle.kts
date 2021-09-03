group = "com.github.DenPeshkov"
version = "1.0-SNAPSHOT"
description = "AlgorithmsAndDataStructures"

plugins {
    java
    id("net.ltgt.errorprone") version "2.0.2"
    id("com.diffplug.spotless") version "5.14.3"
}

repositories {
    mavenCentral()
}

dependencies {
    errorprone("com.google.errorprone:error_prone_core:2.9.0")
}

java.sourceCompatibility = JavaVersion.VERSION_16
java.targetCompatibility = JavaVersion.VERSION_16

spotless {
    java {
        target("src/*/java/**/*.java")

        importOrder()
        removeUnusedImports()

        googleJavaFormat("1.11.0")
    }
}