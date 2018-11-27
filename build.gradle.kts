import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import javax.inject.Inject

plugins {
    java
    kotlin("jvm") version "1.3.10"
    id("git-plugin")
}

group = "kug"
version = "1.0-SNAPSHOT"

//println(extra["token"])
apply(from = "plugin.gradle.kts")
println(extra["token"])

//tasks.whenTaskAdded{
//    println(this.name)
//}



allprojects {
    repositories {
        mavenCentral()
        mavenLocal()
    }
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

open class Echo @Inject constructor(
    private val message: String
) : DefaultTask(){

    @TaskAction
    fun echo() {
        println(message)
    }
}

tasks.create<Echo>("echoDuck", "------")

afterEvaluate{
//    println("coming from after evaluate")
}

//println("coming from evaluate")

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

