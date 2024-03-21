plugins {
    `java-library`
    `maven-publish`
    kotlin("jvm")
}

repositories {
    mavenLocal()
    maven {
        url = uri("https://repo.papermc.io/repository/maven-public/")
    }

    maven {
        url = uri("https://oss.sonatype.org/content/groups/public/")
    }

    maven {
        url = uri("https://repo.maven.apache.org/maven2/")
    }
    mavenCentral()
}

dependencies {
    compileOnly(libs.io.papermc.paper.paper.api)
    implementation(kotlin("stdlib-jdk8"))
}

group = "me.lutto"
version = "0.0.1"
description = "LuttoLib"

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
    }
}

tasks.withType<JavaCompile>() {
    options.encoding = "UTF-8"
}

tasks.withType<Javadoc>() {
    options.encoding = "UTF-8"
}

kotlin {
    jvmToolchain(21)
}