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

package org.spectral.client.directory

import org.spectral.util.SpectralPaths
import java.nio.file.Files
import java.nio.file.Path

/**
 * Represents a directory resolved for the current system platform.
 */
class PlatformDirectory(basePath: String) : Creatable {

    /**
     * The platform resolved path of this directory.
     */
    val path: Path = SpectralPaths.basePath.resolve(basePath)

    override fun exists(): Boolean {
        return Files.exists(this.path)
    }

    override fun create() {
        Files.createDirectories(this.path)
    }

}