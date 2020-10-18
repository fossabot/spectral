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
import org.spectral.launcher.SpectralLauncher
import org.spectral.util.SpectralPaths
import org.tinylog.kotlin.Logger
import java.net.URI

/**
 * The spectral launcher implementation.
 */
class Launcher : AbstractLauncher() {

    /**
     * The dependency injector component.
     */
    val component = DaggerSpectralComponent.create()

    /**
     * The main spectral object singleton instance.
     */
    val spectral = component.spectral

    /**
     * Invoked when the launcher hands off the launch logic to
     * this client.
     */
    override fun onLaunch() {
        /*
         * Create any missing data directories.
         */
        this.initDirectories()

        /*
         * Download the latest Jagex Config
         */
        this.initJavConfig()

        /*
         * Download the latest Jagex Gamepack
         */
        this.downloadGamepack()

        //this.complete()
    }

    /**
     * Invoked when the launch is completed.
     */
    override fun onComplete() {
        Logger.info("Completed launch sequence. Starting Spectral client.")

        /*
         * Start the spectral client.
         */
        spectral.start()
    }

    private fun initDirectories() {
        Logger.info("Initializing data directories.")

        this.addProgress(0.1)
        this.updateStatus("Scanning data directories...")

        DirectoryManager.verify(true)
    }

    private fun initJavConfig() {
        Logger.info("Fetching latest JAV_CONFIG.")

        this.addProgress(0.1)
        this.updateStatus("Fetching Jagex JAV_CONFIG...")

        /*
         * Parse the jav config from the singleton object.
         */
        component.javConfig.parse()
    }

    private fun downloadGamepack() {
        Logger.info("Downloading latest Jagex gamepack.")

        val uri = URI.create("http://oldschool1.runescape.com/gamepack.jar")
        val path = SpectralPaths.basePath.resolve("gamepack").resolve("gamepack.jar")

        /*
         * Start the download.
         */
        GamepackDownloader.downloadGamepack(uri, path, this)
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val launcher = Launcher()

            /*
             * Start the spectral launcher with a declared
             * launcher implementation.
             */
            SpectralLauncher.launch(launcher)
        }
    }
}