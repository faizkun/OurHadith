package com.faizdev.ourhadith.items

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PerawiItem(perawi: String, hadithTotal: Int, goToHadith: () -> Unit) {

        Card(
            modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth()
                .height(177.dp),
            
            colors = CardDefaults.cardColors(Color.White),
            elevation = CardDefaults.cardElevation(4.dp),
            onClick = {goToHadith()}
        ) {
            Column(
                modifier = Modifier
                    .padding(17.dp),

                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
                ) {
                Text(
                    text = perawi,
                    fontSize = 19.sp,
                    fontWeight = FontWeight.Bold,
                )

                Text(
                    text = "${hadithTotal.toString()} Hadith"
                )
            }
        }

}


@Preview
@Composable
fun PerawiPv() {
    PerawiItem("Bukhari",177013) {}
}