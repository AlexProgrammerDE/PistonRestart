plugins {
    id("java")
    id("org.openrewrite.rewrite") version "latest.release"
}

group = "me.alexprogrammerde"
version = "1.0.0"

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

allprojects {
    repositories {
        mavenCentral()
    }
}

repositories {
    maven {
        url = uri("https://papermc.io/repo/repository/maven-public/")
    }
}

dependencies {
    compileOnly("com.destroystokyo.paper:paper-api:1.12.2-R0.1-SNAPSHOT")
    
    rewrite(platform("org.openrewrite.recipe:rewrite-recipe-bom:latest.release"))
    rewrite("org.openrewrite.recipe:rewrite-java")
}

rewrite {
    activeRecipe("org.openrewrite.java.ShortenFullyQualifiedTypeReferences")
}
