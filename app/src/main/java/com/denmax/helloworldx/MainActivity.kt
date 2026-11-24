
package com.denmax.helloworldx

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val green = Color(0xFF79A86A)
            val white = Color(0xFFFFFFFF)
            val grey = Color(0xFF797D80)
            val yellow = Color(0xFFC9B458)

            val characters = "Hello World!"
                .filter { it.isLetter() }
                .uppercase()

            val firstRow = characters.take(5)
            val secondRow = characters.takeLast(5)

            Column(
                modifier = Modifier
                    .padding(top = 48.dp)
                    .fillMaxWidth()
                    .background(white)
                    .padding(8.dp),

                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                // First Row - HELLO
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    for ((index, char) in firstRow.withIndex()) {

                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .aspectRatio(1f)
                                .background(
                                    if (index == 2 || index == 4)
                                        yellow
                                    else
                                        grey
                                ),
                            contentAlignment = Alignment.Center
                        ) {

                            Text(
                                text = char.toString(),
                                color = white,
                                fontSize = 24.sp,
                                fontWeight = FontWeight.ExtraBold
                            )
                        }
                    }
                }

                // Second Row - WORLD
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    for (char in secondRow) {

                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .aspectRatio(1f)
                                .background(green),

                            contentAlignment = Alignment.Center
                        ) {

                            Text(
                                text = char.toString(),
                                color = white,
                                fontSize = 24.sp,
                                fontWeight = FontWeight.ExtraBold
                            )
                        }
                    }
                }
            }
        }
    }
}
