package com.faizdev.ourhadith.items

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ContentCopy
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HadithItem(
    noHadith: Int, hadith: String, translate: String,perawiName: String

) {
    val clipboardManager = LocalClipboardManager.current
    val context = LocalContext.current


    OutlinedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

            Text(
                text = noHadith.toString(),
                fontSize = 24.sp,
                color = Color.White,


                )

            Spacer(modifier = Modifier.height(16.dp))
            Text(text = hadith)

            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Artinya:", fontWeight = FontWeight.Bold)

            Text(text = translate)
            Spacer(modifier = Modifier.size(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                IconButton(
                    onClick = {
                        val sendIntent : Intent = Intent().apply {
                            action = Intent.ACTION_SEND
                            putExtra(Intent.EXTRA_TEXT, "($noHadith)  $perawiName\n$hadith\n\nArtinya:\n$translate")
                            type =  "text/plain"
                        }

                        val shareIntent = Intent.createChooser(sendIntent, null)
                        context.startActivity(shareIntent)
                    }
                ) {
                    Icon(imageVector = Icons.Rounded.Share, contentDescription = "share_button")
                }
                IconButton(
                    onClick = {
                        clipboardManager.setText(
                            AnnotatedString(
                                "$noHadith$perawiName\n$hadith\n\nArtinya:\n$translate"
                            )
                        )
                        Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show()
                    }
                ) {
                    Icon(imageVector = Icons.Rounded.ContentCopy, contentDescription = "button_copy")
                }

            }
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
                "tristique eleifend vel sed leo. ",
        "Ibnu Majah"

    )
}