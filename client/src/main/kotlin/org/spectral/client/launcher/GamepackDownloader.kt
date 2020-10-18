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

import org.spectral.launcher.AbstractLauncher
import org.tinylog.kotlin.Logger
import java.io.BufferedInputStream
import java.net.URI
import java.nio.file.Files
import java.nio.file.Path

/**
 * Responsible for downloading the gamepack JAR file listed
 * in the JavConfig.
 */
object GamepackDownloader {

    /**
     * Downloads a Jagex gamepack.
     *
     * @param uri URI
     * @param dir Path
     * @param callback Function1<AbstractLauncher, Unit>
     */
    fun downloadGamepack(uri: URI, path: Path, launcher: AbstractLauncher) {
        launcher.updateStatus("Download latest Jagex client...")
        launcher.updateProgress(0.0)

        /*
         * If the gamepack already exists on the local hard drive, delete it.
         */
        if(Files.exists(path)) {
            Logger.info("Deleting existing gamepack.jar from local disk.")
            Files.delete(path)
        }

        val input = BufferedInputStream(uri.toURL().openConnection().getInputStream())
        val output = Files.newOutputStream(path)

        val total = input.available()
        var downloaded = 0

        val buf = ByteArray(1024)
        var read: Int
        while(input.read(buf).also { read = it } != -1) {
            output.write(buf, 0, read)
            downloaded += read

            val progress = downloaded.toDouble() / total.toDouble()
            launcher.updateProgress(progress)
        }

        input.close()
        output.close()

        launcher.updateProgress(0.5)
        launcher.updateStatus("Completed download.")
    }
}