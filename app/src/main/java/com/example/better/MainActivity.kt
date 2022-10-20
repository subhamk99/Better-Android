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
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
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
                .wrapContentSize(Alignment.TopCenter)
                .background(Color.Black)
                .padding(horizontal = 8.dp)
                .border(12.dp, Color.Black, RoundedCornerShape(18.dp)),
        ) {
            ButtonToggleRow()
            AddActivityRow()
        }
    }
}

@Composable
fun RowScope.CustomToggleButton(
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

@Composable
fun ColumnScope.ButtonToggleRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .background(Color(0xFF222222))
            .border(8.dp, Color(0xFF222222), RoundedCornerShape(15.dp)),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        CustomToggleButton(
            buttonHandler = { /*TODO*/ },
            buttonState = true,
            buttonContent = "Goal"
        )
        CustomToggleButton(
            buttonHandler = { /*TODO*/ },
            buttonState = false,
            buttonContent = "Activity"
        )
    }
}

@Composable
fun ColumnScope.AddActivityRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .background(Color(0xFF222222))
            .border(8.dp, Color(0xFF222222), RoundedCornerShape(15.dp)),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.weight(1f),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Transparent,
                contentColor = Color.White
            )
        ) {
            Icon(
                Icons.Default.Add, null
            )
            Text(text = "Add new activity")
        }
    }
}