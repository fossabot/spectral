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

/**
 * Responsible for verifying the directory structures have all
 * been created correctly on the local system.
 */
class DirectoryVerifier {

    /**
     * Checks if all base directories exist
     */
    fun createMissing() {
        dirs.map { PlatformDirectory(it) }.forEach { dir ->
            if(!dir.exists()) {
                dir.create()
            }
        }
    }

    companion object {

        /**
         * The sub directories which exist in the spectral data directory.
         */
        private val dirs = arrayOf("bin", "logs", "plugins", "mappings", "config")
    }
}