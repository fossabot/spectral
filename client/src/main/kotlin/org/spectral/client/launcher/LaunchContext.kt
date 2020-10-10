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

import java.io.File

/**
 * The context options set during the launch of the client.
 *
 * @property verbose Boolean
 * @property developerMode Boolean
 * @property forcedGamepackFile File?
 * @property jagexUrl String
 * @constructor
 */
data class LaunchContext(
    val verbose: Boolean,
    val developerMode: Boolean,
    val forcedGamepackFile: File?,
    val jagexUrl: String
)