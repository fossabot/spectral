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

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.*
import com.github.ajalt.clikt.parameters.types.file
import java.io.File

/**
 * Responsible for parsing command line flags from the
 * main method into a usable context object.
 */
class CommandLineParser : CliktCommand(
    name = "Spectral Client",
    help = "An Open-Source Oldschool RuneScape Client",
    printHelpOnEmptyArgs = false,
    invokeWithoutSubcommand = true
) {

    /**
     * Verbose logging mode.
     * Default: false
     */
    private val verbose by option("-v", "--verbose", help = "Enable verbose logging mode.")
        .flag(default = false)

    /**
     * Developer mode.
     * Enables access to special development based tools in the client.
     * Default: false
     */
    private val developerMode by option("-d", "--developerMode", help = "Enable developer tools mode.")
        .flag(default = false)

    /**
     * Force a jar file to use as gamepack instead of downloading from jagex servers.
     * Default: null
     */
    private val forceGamepackFile by option("-g", "--gamepack", help = "Force the use of a gamepack Jar file.")
        .file(mustExist = true, canBeDir = false)

    /**
     * The Jagex URL to download client assets from during launch.
     * Default: http://oldschool1.runescape.com
     *
     * *NOTE* We probably should randomize the default as to not potentially
     * DDOS the oldschool1 codebase url if we have enough users using this client.
     */
    private val jagexUrl by option("-j", "--jagexUrl", help = "The URL to download assets from.")
        .default("http://oldschool1.runescape.com")

    /**
     * Invoke / run the command
     */
    override fun run() {
        /*
         * TODO. Build the context instance
         */
    }
}