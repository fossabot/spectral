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
import org.spectral.client.Spectral
import org.spectral.launcher.AbstractLauncher
import org.tinylog.kotlin.Logger

class Launcher : AbstractLauncher() {

    /**
     * The spectral dependency injector component.
     */
    internal val component = DaggerSpectralComponent.create()

    /**
     * The main spectral object singleton instance.
     */
    internal val spectral: Spectral = component.spectral

    override fun onLaunch() {
        Logger.info("Preparing the Spectral client.")

        /*
         * Do spectral client launch stuff here.
         */

        this.complete()
    }

    override fun onComplete() {
        Logger.info("Spectral launcher has completed. Starting client...")

        /*
         * Start the spectral client from the singleton [Spectral] instance.
         */
        spectral.start()
    }

    companion object {
        /**
         * Main static method for starting the spectral client.
         * @param args Array<String>
         */
        @JvmStatic
        fun main(args: Array<String>) {
            val launcher = Launcher()
            launcher.onLaunch()
        }
    }
}