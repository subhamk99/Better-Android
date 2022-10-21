package com.example.better

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.better.ui.theme.BetterTheme

class ActivityItemModel(activityName: String, startDate: String) {
    var activityName: String;
    var startDate: String;

    init {
        this.activityName = activityName
        this.startDate = startDate
    }
}

val activities: MutableList<ActivityItemModel> = mutableListOf();

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
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
        color = Color(0xFF222222)
    ) {
        activities.add(ActivityItemModel("Gym", "2022-05-28"))
        activities.add(ActivityItemModel("Coding", "2017-10-18"))
        activities.add(ActivityItemModel("Sleep", "2022-10-28"))
        activities.add(ActivityItemModel("Book", "2021-11-20"))
        activities.add(ActivityItemModel("Anime", "2020-11-27"))
        activities.add(ActivityItemModel("Running", "1999-03-05"))
        Column(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.TopCenter)
                .background(Color.Black)
                .padding(horizontal = 8.dp),
        ) {
            Navbar()
            ButtonToggleRow()
            AddActivityRow()
            ActivityList(activities)
        }
    }
}


@Composable
fun ColumnScope.ButtonToggleRow() {
    var selected = remember {
        mutableStateOf(true)
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .background(Color(0xFF222222)),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            onClick = { selected.value = !selected.value },
            colors = ButtonDefaults.buttonColors(
                disabledContentColor = Color.Black,
                disabledBackgroundColor = Color(0xFF00D2E3),
                backgroundColor = Color(0xFF222222),
                contentColor = Color(0xFF670EFD)
            ),
            enabled = !selected.value,
            modifier = Modifier
                .padding(3.dp)
                .weight(1f)
        ) {
            Text(text = "Goal")
        }
        Button(
            onClick = { selected.value = !selected.value },
            colors = ButtonDefaults.buttonColors(
                disabledContentColor = Color.Black,
                disabledBackgroundColor = Color(0xFF00D2E3),
                backgroundColor = Color(0xFF222222),
                contentColor = Color(0xFF670EFD)
            ),
            enabled = selected.value,
            modifier = Modifier
                .padding(3.dp)
                .weight(1f)
        ) {
            Text(text = "Activity")
        }
    }
}


@Composable
fun ColumnScope.AddActivityRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .background(Color(0xFF222222)),
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

@Composable
fun ColumnScope.ActivityList(
    activityList: MutableList<ActivityItemModel>
) {
    LazyColumn(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        items(activityList) { activity: ActivityItemModel ->
            ActivityItem(activityName = activity.activityName, startDate = activity.startDate)
        }
    }
}

@Composable
fun ColumnScope.ActivityItem(
    activityName: String,
    startDate: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(vertical = 10.dp)
    ) {
        Column(
            modifier = Modifier
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xFF00D2E3),
                            Color(0xFF670EFD)
                        )
                    )
                )
        ) {

            var trackActivity = remember {
                mutableStateOf(false)
            }
            var buttonIcon =
                if (!trackActivity.value) R.drawable.ic_baseline_play_circle_24 else R.drawable.ic_baseline_pause_circle_24
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = activityName,
                    color = Color.White,
                    fontSize = 33.sp,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.padding(start = 20.dp)
                )
                Image(
                    painter = painterResource(id = buttonIcon),
                    contentDescription = "pause_play",
                    Modifier
                        .padding(end = 20.dp)
                        .clickable(onClick = { trackActivity.value = !trackActivity.value })
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_outline_calendar_today_24),
                        contentDescription = "calendar_icon",
                        modifier = Modifier.padding(
                            start = 22.dp, end = 6.dp
                        )
                    )
                    Text(
                        text = "$startDate", color = Color.White,
                        fontWeight = FontWeight.Bold, fontFamily = FontFamily.Monospace,
                        modifier = Modifier.padding(top = 3.dp)
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_outline_calendar_today_24),
                        contentDescription = "calendar_icon",
                        modifier = Modifier.padding(
                            start = 22.dp, end = 6.dp
                        )
                    )
                    Text(
                        text = "$startDate", color = Color.White,
                        fontWeight = FontWeight.Bold, fontFamily = FontFamily.Monospace,
                        modifier = Modifier.padding(top = 3.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun ColumnScope.Navbar() {
    Row(modifier = Modifier.fillMaxWidth()) {

    }
}
