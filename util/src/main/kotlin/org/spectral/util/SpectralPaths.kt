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

package org.spectral.util

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

/**
 * Contains resolved paths for spectral data folders depending on current platform.
 */
object SpectralPaths {

    /**
     * The base spectral directory path for the current platform.
     */
    val basePath: Path get() {
        this.resolvePath(Paths.get(""), Platform.current()).apply {
            if(!Files.exists(this)) {
                Files.createDirectories(this)
            }

            return this
        }
    }

    /**
     * Gets the base spectral data folder given a platform.
     *
     * @param platform Platform
     * @return Path
     */
    fun resolvePath(path: Path, platform: Platform): Path {
        return when(platform) {
            Platform.WINDOWS -> {
                Paths.get(System.getProperty("user.home"))
                    .resolve("AppData")
                    .resolve("Roaming")
                    .resolve("spectral")
                    .resolve(path.toString())
            }

            Platform.MACOS -> {
                Paths.get(System.getProperty("user.home"))
                    .resolve("Library")
                    .resolve("Application Support")
                    .resolve("spectral")
                    .resolve(path.toString())
            }

            else -> {
                Paths.get(System.getProperty("user.home"))
                    .resolve("spectral")
                    .resolve(".$path")
            }
        }
    }
}