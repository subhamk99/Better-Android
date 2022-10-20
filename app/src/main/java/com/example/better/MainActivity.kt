package com.example.better

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.better.ui.theme.BetterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BetterTheme {
                BetterApp()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BetterApp() {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color.White
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
                .background(Color.Black)
                .padding(horizontal = 12.dp)
                .border(12.dp, Color.Black, RoundedCornerShape(18.dp)),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .background(Color(0xFF222222))
                    .border(8.dp, Color(0xFF222222), RoundedCornerShape(15.dp)),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                CustomButton(
                    buttonHandler = { /*TODO*/ },
                    buttonState = true,
                    buttonContent = "Goal"
                )
                CustomButton(
                    buttonHandler = { /*TODO*/ },
                    buttonState = false,
                    buttonContent = "Activity"
                )
            }
        }
    }
}

@Composable
fun RowScope.CustomButton(
    buttonHandler: () -> Unit,
    buttonState: Boolean,
    buttonContent: String
) {
    Button(
        onClick = { buttonHandler },
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.Black,
            backgroundColor = Color(0xFF00D2E3),
            disabledBackgroundColor = Color(0xFF222222),
            disabledContentColor = Color(0xFF670EFD)
        ),
        enabled = buttonState,
        modifier = Modifier
            .padding(3.dp)
            .weight(1f)
    ) {
        Text(text = buttonContent)
    }
}