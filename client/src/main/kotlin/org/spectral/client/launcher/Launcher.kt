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
 * Responsible for launching the Spectral Client.
 */
class Launcher : AbstractLauncher() {

    override fun onLaunch() {
        Logger.info("Preparing the Spectral client.")
    }

    override fun onComplete() {
        Logger.info("Spectral client has finished pre-flight launch.")

    }

    internal fun startClient() {
        val component = DaggerSpectralComponent.create()
        val spectral = component.spectral

        /*
         * Start the spectral client.
         */
        spectral.start()
    }

    companion object {
        /**
         * The JVM static entry into launching the spectral client.
         *
         * @param args Array<String>
         */
        @JvmStatic
        fun main(args: Array<String>) {
            Launcher().startClient()
        }
    }
}