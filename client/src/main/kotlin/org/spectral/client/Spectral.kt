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

package org.spectral.client

import org.tinylog.kotlin.Logger
import javax.inject.Inject
import javax.inject.Singleton

/**
 * The main Spectral Client object.
 * This class is where all the magic starts.
 */
@Singleton
class Spectral @Inject constructor() {

    /**
     * The pre-start initialization.
     */
    private fun init() {
        Logger.info("Running pre-flight initialization.")

        /*
         * Spectral initialization stuff
         */

        Logger.info("Completed pre-flight initialization.")
    }

    /**
     * Start the spectral client.
     */
    fun start() {
        /*
         * Do pre-flight initialization
         */
        this.init()

        Logger.info("Starting client.")

        /*
         * Start the client.
         */
    }
}