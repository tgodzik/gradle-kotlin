import org.gradle.api.Plugin
import org.gradle.api.Project
import java.io.File
import java.util.concurrent.TimeUnit
import kotlin.collections.List

class GitPlugin : Plugin<Project> {

    fun runCommand(command : List<String>, workingDir: File) : String{
        val process = ProcessBuilder(command)
            .directory(workingDir)
            .redirectOutput(ProcessBuilder.Redirect.PIPE)
            .redirectError(ProcessBuilder.Redirect.PIPE)
            .start()

            process.waitFor(60, TimeUnit.MINUTES)
        return process.inputStream.bufferedReader().readText()
    }

    override fun apply(project: Project) {
        project.task("status") {
            it.doLast {
                println(runCommand(listOf("git", "status"), project.projectDir))
            }
        }
    }
}