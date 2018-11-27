plugins {
    java
    application
    kotlin("jvm")
}

application.mainClassName = "AlfaMainKt"

dependencies {
    compile(kotlin("stdlib-jdk8"))
    testCompile(kotlin("test"))
    testCompile("junit", "junit", "4.12")
}