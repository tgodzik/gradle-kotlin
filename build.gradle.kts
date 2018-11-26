import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import javax.inject.Inject

plugins {
    java
    application
    kotlin("jvm") version "1.3.10"
}

group = "kug"
version = "1.0-SNAPSHOT"

application.mainClassName = "MainKt"

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    compile(kotlin("stdlib-jdk8"))
    testCompile(kotlin("test"))
    testCompile("junit", "junit", "4.12")
}

task("calculate") {
    doLast {
        val result = 5 + 4
        println(result)
    }
}.dependsOn("run")

task<Copy>("copy") {
    from(file("src"))
    into(buildDir)
}

val copyDelegate by tasks.creating(Copy::class) {
    from(file("src"))
    into(buildDir)
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}