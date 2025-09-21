plugins {
    id("java")
    id("fabric-loom") version "1.11-SNAPSHOT"
}

group = "com.github.dinomarlir"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    minecraft("com.mojang:minecraft:1.21.8")
    mappings(loom.officialMojangMappings())
    modImplementation("net.fabricmc:fabric-loader:0.17.2")
}

tasks.test {
    useJUnitPlatform()
}