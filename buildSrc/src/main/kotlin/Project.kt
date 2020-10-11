import org.gradle.api.JavaVersion
import org.gradle.kotlin.dsl.version
import org.gradle.plugin.use.PluginDependenciesSpec
import org.gradle.plugin.use.PluginDependencySpec

/*
 * Copyright (C) 2020 Kyle Escobar
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

object Project {
    const val version = "1.0.0"
    const val kotlinVersion = "1.4.10"
    const val gradleVersion = "6.6.1"
    val jvmVersion = JavaVersion.VERSION_11.toString()
}

object Plugin {
    internal object Version {
        const val detekt = "1.14.1"
        const val openjfx = "0.0.9"
    }

    const val detekt = "io.gitlab.arturbosch.detekt"
    const val openjfx = "org.openjfx.javafxplugin"
}

object Library {
    private object Version {
        const val tinylog = "2.1.2"
        const val dagger = "2.29.1"
        const val glassfish = "3.1.1"
        const val spek = "2.0.13"
        const val mockk = "1.10.2"
        const val clikt = "2.8.0"
        const val spectralLauncher = "1.0.0"
        const val tornadofx = "1.7.20"
    }

    const val tinylogApi = "org.tinylog:tinylog-api-kotlin:${Version.tinylog}"
    const val tinylogImpl = "org.tinylog:tinylog-impl:${Version.tinylog}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Version.dagger}"
    const val dagger = "com.google.dagger:dagger:${Version.dagger}"
    const val glassfish = "org.glassfish:javax.annotation:${Version.glassfish}"
    const val spekDsl = "org.spekframework.spek2:spek-dsl-jvm:${Version.spek}"
    const val spekRunner = "org.spekframework.spek2:spek-runner-junit5:${Version.spek}"
    const val mockk = "io.mockk:mockk:${Version.mockk}"
    const val clikt = "com.github.ajalt:clikt:${Version.clikt}"
    const val spectralLauncher = "org.spectral.launcher:launcher:${Version.spectralLauncher}"
    const val tornadofx = "no.tornado:tornadofx:${Version.tornadofx}"
}

val PluginDependenciesSpec.detekt: PluginDependencySpec get() {
    return id(Plugin.detekt) version Plugin.Version.detekt
}

val PluginDependenciesSpec.openjfx: PluginDependencySpec get() {
    return id(Plugin.openjfx) version Plugin.Version.openjfx
}