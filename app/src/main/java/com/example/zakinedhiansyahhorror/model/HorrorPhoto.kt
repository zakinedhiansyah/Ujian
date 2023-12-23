/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.zakinedhiansyahhorror.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
Data class ini digunakan untuk mendefinisikan  ID, judul, ID IMDb, dan URL gambar.
 */
@Serializable
data class HorrorPhoto(
    val id: Int,
    val title : String,
    val imdbId : String,
    @SerialName(value = "posterURL")
    val imgSrc: String
)