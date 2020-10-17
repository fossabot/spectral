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

import org.spectral.client.DaggerSpectralComponent
import org.spectral.launcher.AbstractLauncher
import org.tinylog.kotlin.Logger

/**
 * The spectral launcher implementation.
 */
class Launcher : AbstractLauncher() {

    /**
     * Invoked when the launcher hands off the launch logic to
     * this client.
     */
    override fun onLaunch() {
        // TODO Launch stuff
        this.complete()
    }

    /**
     * Invoked when the launch is completed.
     */
    override fun onComplete() {
        Logger.info("Completed launch sequence. Starting Spectral client.")
        startSpectral()
    }

    companion object {

        private val component = DaggerSpectralComponent.create()
        private val spectral = component.spectral

        /**
         * Starts the spectral client.
         */
        internal fun startSpectral() {
            Logger.info("Preparing Spectral client...")

            /*
             * Start spectral
             */
            spectral.start()
        }

        @JvmStatic
        fun main(args: Array<String>) {
            this.startSpectral()
        }
    }
}