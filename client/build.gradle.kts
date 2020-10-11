plugins {
    kotlin("kapt")
    openjfx
    application
}

description = "Spectral Client"

application {
    mainClassName = "org.spectral.client.launcher.Launcher"
}

tasks.withType<JavaExec> {
    main = application.mainClassName
    workingDir = rootProject.projectDir
}

dependencies {
    kapt(Library.daggerCompiler)
    implementation(Library.dagger)
    implementation(Library.glassfish)
    implementation(Library.clikt)
    implementation(Library.spectralLauncher)
    implementation(Library.tornadofx)
}

val runtimeClasspath by configurations

val copyCompiledJar = tasks.register("copyCompiledJar", Copy::class) {
    description = "Copies the compiled client jar to deps/ folder."
    group = "spectral"

    into("$projectDir/deps")
    from(tasks.getByName("jar"))
}

val copyDependencyJars = tasks.register("copyDependencyJars", Copy::class) {
    description = "Copies all runtime dependency jars to deps/ folder."
    group = "spectral"

    doFirst {
        file("$projectDir/deps").deleteRecursively()
    }

    into("$projectDir/deps")
    from(runtimeClasspath)

    finalizedBy(copyCompiledJar)
}

javafx {
    version = "11"
    modules = listOf("javafx.base", "javafx.fxml", "javafx.graphics", "javafx.controls", "javafx.swing")
}

val generateManifest = tasks.create("generateManifest", JavaExec::class) {
    description = "Generates a manifest.xml for this client project."
    group = "spectral"

    dependsOn(copyDependencyJars)

    main = "org.spectral.client.launcher.task.GenerateManifest"
    classpath = sourceSets["main"].runtimeClasspath
    args = listOf("https://archive.spectralpowered.org/latest/", "org.spectral.client.launcher.ClientLauncher", "${project.version}", "deps/", "bin/")
    workingDir = projectDir
}