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

import com.github.weisj.darklaf.theme.Theme
import com.github.weisj.darklaf.theme.info.ColorToneRule
import com.github.weisj.darklaf.theme.info.PresetIconRule

/**
 * The theme class for the spectral Java Swing client window.
 */
class SpectralTheme : Theme() {

    override fun getResourcePath(): String {
        return "theme/"
    }

    override fun getPrefix(): String {
        return "spectral"
    }

    override fun getName(): String {
        return "Spectral"
    }

    override fun getLoaderClass(): Class<out Theme> {
        return SpectralTheme::class.java
    }

    override fun getColorToneRule(): ColorToneRule {
        return ColorToneRule.DARK
    }

    override fun getPresetIconRule(): PresetIconRule {
        return PresetIconRule.DARK
    }

    override fun supportsCustomAccentColor(): Boolean {
        return true
    }

    override fun supportsCustomSelectionColor(): Boolean {
        return true
    }

}