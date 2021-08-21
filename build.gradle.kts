group = "com.github.DenPeshkov"
version = "1.0-SNAPSHOT"
description = "AlgorithmsAndDataStructures"

plugins {
    java
}

repositories {
    mavenCentral()
}

java.sourceCompatibility = JavaVersion.VERSION_16
java.targetCompatibility = JavaVersion.VERSION_16

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.withType<Test> {
    systemProperty("file.encoding", "UTF-8")
}

tasks.withType<Javadoc> {
    options.encoding = "UTF-8"
}