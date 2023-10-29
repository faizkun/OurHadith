package com.faizdev.ourhadith.items

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HadithItem(noHadits: Int, hadits: String, translate: String) {
    OutlinedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = noHadits.toString(),
                fontSize = 24.sp,
                color = Color.White,

                )

            Spacer(modifier = Modifier.height(16.dp))
            Text(text = hadits)

            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Artinya:", fontWeight = FontWeight.Bold)

            Text(text = translate)
        }
    }


}


@Preview
@Composable
fun HadithItemPrev() {
    HadithItem(
        1,
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris et ante " +
                "vel elit scelerisque lacinia eu ac odio. Vivamus ultrices augue nisl," +
                " non venenatis ante dapibus in. Suspendisse tortor nunc, condimentum " +
                "a est sit amet, varius posuere ipsum. Aenean eget nisi a erat " +
                "tristique eleifend vel sed leo. ",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris et ante " +
                "vel elit scelerisque lacinia eu ac odio. Vivamus ultrices augue nisl," +
                " non venenatis ante dapibus in. Suspendisse tortor nunc, condimentum " +
                "a est sit amet, varius posuere ipsum. Aenean eget nisi a erat " +
                "tristique eleifend vel sed leo. "
    )
}