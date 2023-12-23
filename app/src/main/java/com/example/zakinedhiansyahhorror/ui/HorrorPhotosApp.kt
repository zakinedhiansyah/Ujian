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

@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.zakinedhiansyahhorror.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.zakinedhiansyahhorror.R
import com.example.zakinedhiansyahhorror.ui.screens.HomeScreen
import com.example.zakinedhiansyahhorror.ui.screens.MarsViewModel





@Composable
// Tampilan awal Aplikasi
fun Beranda(navController: NavHostController) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
          Image(
                painter = painterResource(id = R.drawable.horror),
                contentDescription = "",
                modifier = Modifier.padding(20.dp)
            )
            Button(onClick = { navController.navigate("kedua") }) {
                Text("Lihat Daftar Film Horror") //navigasi untuk perpindah dari halaman beranda ke halaman berikutnya
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MarsPhotosApp() {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    val navController = rememberNavController()
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = { MarsTopAppBar(scrollBehavior = scrollBehavior) }
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        )
        {
            NavHost(
                navController = navController,
                startDestination = "awal"
            )
            {
                composable("awal"){
                    Beranda(navController)
                }
                composable("kedua"){
                    val marsViewModel: MarsViewModel =
                        viewModel(factory = MarsViewModel.Factory)
                    HomeScreen( navController,
                        marsUiState = marsViewModel.marsUiState,
                        retryAction = marsViewModel::getMarsPhotos
                    )
                }
            }
        }
    }
}
//Tampilan bar atas yang bertuliskan Judul aplikasi
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MarsTopAppBar(scrollBehavior: TopAppBarScrollBehavior, modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        scrollBehavior = scrollBehavior,
        title = {
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.headlineSmall,
                color = Color.Red
            )
        },
        modifier = modifier
    )
}
