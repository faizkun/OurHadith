package com.faizdev.ourhadith.pages

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.faizdev.ourhadith.items.PerawiItem
import com.faizdev.ourhadith.ui.theme.satoshi


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeActivty() {
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

        Column(modifier = Modifier.padding(it)) {
            Spacer(modifier = Modifier.size(12.dp))
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    content = {
                        items(10){
                            PerawiItem(perawi = "Ibnu Majah", hadithTotal = 177013 )
                        }
                    })
        }

    }

}


@Preview
@Composable
fun HomePreview() {
    HomeActivty()

}