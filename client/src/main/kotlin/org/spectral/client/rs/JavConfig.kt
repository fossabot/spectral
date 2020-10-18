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

package org.spectral.client.rs

import org.tinylog.kotlin.Logger
import java.net.URL
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Represents the Jagex parsed JAV_CONFIG parameters for launching
 * the client applet.
 */
@Singleton
class JavConfig @Inject constructor() {

    /**
     * The backing storage of parameters parsed from the remote URL.
     */
    private val params = mutableMapOf<String, String>()

    /**
     * Parses the data from a remote URL.
     *
     * @param url URL
     */
    fun parse(url: URL = URL(JAGEX_URL)) {
        Logger.info("Downloaing Jagex jav_config from '$JAGEX_URL'.")

        val lines = url.readText().split("\n")
        lines.forEach {
            var line = it
            if(line.startsWith("param=")) {
                line = line.substring(6)
            }
            val idx = line.indexOf("=")
            if(idx > -1) {
                params[line.substring(0, idx)] = line.substring(idx + 1)
            }
        }
    }

    /**
     * Gets a parameter with a given name.
     *
     * @param name String
     * @return String
     */
    operator fun get(name: String): String {
        return params[name] ?: throw NoSuchElementException("No parameter with name $name found.")
    }

    /**
     * Sets or add a parameter to this object.
     *
     * @param name String
     * @param value String
     */
    operator fun set(name: String, value: String) {
        params[name] = value
    }

    companion object {
        /**
         * The Jagex URL to download the config path from.
         */
        const val JAGEX_URL = "http://oldschool.runescape.com/"
    }
}