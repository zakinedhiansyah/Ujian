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
package com.example.zakinedhiansyahhorror.data

import com.example.zakinedhiansyahhorror.network.HorrorApiService
import retrofit2.Retrofit
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType

/**
 * Dependency Injection container at the application level.
 */
interface AppContainer {
    val marsPhotosRepository: MarsPhotosRepository
}

/**
class untuk mengelola URL untuk permintaan API dalam aplikasi.
 */
class DefaultAppContainer : AppContainer {
    private val baseUrl = "https://api.sampleapis.com/"

    /**
    untuk membuat objek Retrofit yang dikonfigurasi dengan URL , konverter factory untuk mengonversi respons ke format JSON
     */
    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    /**
     * Retrofit service object for creating api calls
     */
    private val retrofitService: HorrorApiService by lazy {
        retrofit.create(HorrorApiService::class.java)
    }

    /**
     * kode ini memberikan implementasi untuk repositori foto Mars, dan menggunakan NetworkMarsPhotosRepository
     */
    override val marsPhotosRepository: MarsPhotosRepository by lazy {
        NetworkMarsPhotosRepository(retrofitService)
    }
}
