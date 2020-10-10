plugins {
    kotlin("kapt")
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