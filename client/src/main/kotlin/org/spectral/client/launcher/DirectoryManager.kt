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

package org.spectral.client.launcher

import org.spectral.util.SpectralPaths
import java.nio.file.Files

object DirectoryManager {

    /**
     * The sub directories that need to exist for the client to run.
     */
    private val dirs = arrayOf("bin", "gamepack", "config", "plugins", "logs", "mappings")

    /**
     * Verifies that all of the directories exist.
     *
     * @param create Create missing directories. [Boolean]
     * @return Boolean
     */
    fun verify(create: Boolean = false): Boolean {
        dirs.forEach { dir ->
            val path = SpectralPaths.basePath.resolve(dir)

            if(!Files.exists(path)) {
                if(!create) {
                    return false
                } else {
                    Files.createDirectories(path)
                }
            }
        }

        return true
    }
}