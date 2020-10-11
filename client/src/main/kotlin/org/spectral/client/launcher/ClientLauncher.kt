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
import org.spectral.client.SpectralComponent
import org.spectral.launcher.Launcher
import org.spectral.launcher.gui.LauncherApp
import org.tinylog.kotlin.Logger

class ClientLauncher : Launcher {


    /**
     * The spectral object instance.
     */
    private lateinit var spectral: Spectral

    /**
     * The spectral dependency injector component.
     */
    private lateinit var spectralComponent: SpectralComponent

    /**
     * The launcher javafx application.
     */
    override lateinit var launcherApp: LauncherApp

    override fun onLaunch() {

    }

    override fun onComplete() {
        /*
         * Setup everything needed before starting the spectral client.
         */
        Logger.info("Preparing Spectral Client.")

        /*
         * Create a spectral instance inside of a
         * dependency injected scope.
         */
        this.spectralComponent = DaggerSpectralComponent.create()
        this.spectral = this.spectralComponent.spectral

        /*
         * Start the spectral client.
         */
        this.spectral.start()
    }

    override fun updateProgress(progress: Double) {

    }

    override fun updateStatus(status: String) {

    }
}