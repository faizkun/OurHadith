package com.faizdev.ourhadith.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.unit.sp
import com.faizdev.ourhadith.items.HadithItem
import com.faizdev.ourhadith.items.PerawiItem
import com.faizdev.ourhadith.ui.theme.satoshi

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HadithActivity() {

    Scaffold(
        topBar = {
            TopAppBar(title = {

            })
        }
    ) {
        Column(modifier = Modifier.padding(it)) {
            Text(
                text = "Perawi: Ibnu Majah",
                modifier = Modifier.padding(start = 16.dp),
                fontSize = 24.sp
            )
            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn(content = {
                items(10) {
                    HadithItem(
                        noHadits = 1,
                        hadits = "Lorem ipsum dolor sit amet, consectetur adipiscing " +
                                "elit. Cras scelerisque justo vitae nisi pretium accumsan. " +
                                "Aliquam vitae ex metus. Phasellus non tortor vel orci " +
                                "pulvinar finibus a eu ligula. In bibendum pretium " +
                                "ullamcorper. Suspendisse potenti. Sed ex nibh, ultrices eget " +
                                "condimentum vitae, convallis a nibh.",
                        translate = "Lorem ipsum dolor sit amet, consectetur adipiscing " +
                                "elit. Cras scelerisque justo vitae nisi pretium accumsan. " +
                                "Aliquam vitae ex metus. Phasellus non tortor vel orci " +
                                "pulvinar finibus a eu ligula. In bibendum pretium " +
                                "ullamcorper. Suspendisse potenti. Sed ex nibh, ultrices eget " +
                                "condimentum vitae, convallis a nibh."
                    )
                }
            })
        }
    }
}


@Preview
@Composable
fun HadithActivityPrev() {
    HadithActivity()

}