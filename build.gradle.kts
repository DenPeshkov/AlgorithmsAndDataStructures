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

/*tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.compilerArgs.addAll(
        setOf(
            "--add-exports=jdk.compiler/com.sun.tools.javac.api=ALL-UNNAMED",
            "--add-exports=jdk.compiler/com.sun.tools.javac.file=ALL-UNNAMED",
            "--add-exports=jdk.compiler/com.sun.tools.javac.parser=ALL-UNNAMED",
            "--add-exports=jdk.compiler/com.sun.tools.javac.tree=ALL-UNNAMED",
            "--add-exports=jdk.compiler/com.sun.tools.javac.util=ALL-UNNAMED"
        )
    )
}*/

tasks.withType<Test> {
    systemProperty("file.encoding", "UTF-8")
}

tasks.withType<Javadoc> {
    options.encoding = "UTF-8"
}

spotless {
    java {
        target("src/*/java/**/*.java")

        importOrder()
        removeUnusedImports()

        googleJavaFormat("1.11.0")
    }
}