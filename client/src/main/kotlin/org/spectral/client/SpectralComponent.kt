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

import dagger.Component
import javax.inject.Singleton

/**
 * The dependency injector component for creating an
 * instance of the spectral object to start the client.
 */
@Component(modules = [SpectralModule::class])
@Singleton
interface SpectralComponent {

    /**
     * The spectral object singleton instance.
     */
    val spectral: Spectral
}