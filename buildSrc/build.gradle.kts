plugins {
    java
    `java-gradle-plugin`
    kotlin("jvm") version "1.3.10"
}

repositories {
    mavenCentral()
}

dependencies {
    compileOnly(gradleApi())
    compile(kotlin("stdlib-jdk8"))
}

gradlePlugin {
    plugins {
        create("myPlugins") {
            id = "git-plugin"
            implementationClass = "GitPlugin"
        }
    }
}
