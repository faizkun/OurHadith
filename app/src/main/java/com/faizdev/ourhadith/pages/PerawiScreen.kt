package com.faizdev.ourhadith.pages

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.faizdev.ourhadith.HadithComposeApplication
import com.faizdev.ourhadith.factory.ViewModelFactory
import com.faizdev.ourhadith.items.PerawiItem
import com.faizdev.ourhadith.pages.destinations.HadithScreenDestination
import com.faizdev.ourhadith.ui.theme.satoshi
import com.faizdev.state.PerawiState
import com.faizdev.viewmodel.PerawiViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator


@OptIn(ExperimentalMaterial3Api::class)
    @RootNavGraph(start = true)
    @Destination
    @Composable
    fun PerawiScreen(
    navigator: DestinationsNavigator,
    viewModel: PerawiViewModel = viewModel(
            factory = ViewModelFactory {
                PerawiViewModel(HadithComposeApplication.repository)
            }
        )
    ) {
        viewModel.getList()
        val perawiState by viewModel.getPerawi.collectAsStateWithLifecycle()
        Scaffold(
            topBar = {
                TopAppBar(title = {
                    Text(
                        text = "OurHadith.",
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontFamily = satoshi,
                    )
                })
            }
        ) {
            Spacer(modifier = Modifier.height(20.dp))

            when (val state = perawiState) {
                is PerawiState.Error -> {
                    Box(
                        modifier = Modifier.padding(it),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = state.message)
                    }
                }

                is PerawiState.Loading -> {
                    Box(
                        modifier = Modifier.padding(it),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }

                is PerawiState.Success -> {
                    Column(modifier = Modifier.padding(it)) {
                        LazyVerticalGrid(
                            columns = GridCells.Fixed(2),
                            content = {
                                items(state.list){
                                    PerawiItem(perawi = it.name, hadithTotal = it.total){
                                        navigator.navigate(
                                            HadithScreenDestination(
                                                navArgs = HadithListScreenNavArgs(it.slug)
                                            )
                                        )
                                    }
                                }
                            })
                    }
                }

                null -> {

                }
            }
        }
    }