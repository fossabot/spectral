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

package org.spectral.client.gui

import com.github.weisj.darklaf.LafManager
import org.tinylog.kotlin.Logger
import javax.inject.Inject
import javax.inject.Singleton
import javax.swing.ImageIcon
import javax.swing.JFrame
import javax.swing.SwingUtilities

/**
 * Represents the client window and various controls
 * that can be used with it.
 */
@Singleton
class ClientWindow @Inject constructor() {

    /**
     * Whether the client window has been created or not.
     */
    var created = false
        private set

    /**
     * The Java Swing window.
     */
    private lateinit var frame: JFrame

    /**
     * Creates and display the main Spectral client window.
     */
    fun create() {
        Logger.info("Creating root client window.")

        SwingUtilities.invokeLater {
            LafManager.install()

            /*
             * Build the Java Swing frame.
             */
            frame = JFrame("Spectral")
            frame.setSize(600, 400)

            /*
             * Set the frame icon
             */
            frame.iconImage = ImageIcon(javaClass.getResource("/images/app-icon.png")).image

            frame.setLocationRelativeTo(null)
            frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
            frame.isVisible = true
        }
    }
}