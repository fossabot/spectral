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

/**
 * Represents current operating system platforms.
 */
enum class Platform {

    WINDOWS,

    MACOS,

    LINUX,

    OTHER;

    companion object {

        /**
         * Gets the current operating system platform.
         *
         * @return Platform
         */
        fun current(): Platform {
            val os = System.getProperty("os.name", "generic").toUpperCase()
            return when {
                os.contains("MAC") || os.contains("DARWIN") -> MACOS
                os.contains("WIN") -> WINDOWS
                os.contains("NUX") || os.contains("NIX") -> LINUX
                else -> OTHER
            }
        }
    }
}