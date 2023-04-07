package com.example.newsapicompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.newsapicompose.ui.theme.NewsApiComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val checked = mutableStateOf(true)
        setContent {
            HomeScreen(
                checked = checked,
                onCheckedChange = { newCheckedValue ->
                    checked.value = newCheckedValue
                },
                onCheckedChangeByText = {
                    checked.value = !checked.value
                }
            )
        }
    }
}

@Composable
fun HomeScreen(
    checked: State<Boolean>,
    onCheckedChange: (Boolean) -> Unit,
    onCheckedChangeByText: () -> Unit,
) {
    val checkedValue = checked.value
    Row(verticalAlignment = CenterVertically) {
        Checkbox(
            checked = checkedValue,
            onCheckedChange = onCheckedChange
        )
        Text(
            "Some checkbox text",
            fontSize = 18.sp,
            modifier = Modifier.clickable(onClick = onCheckedChangeByText)
        )
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NewsApiComposeTheme {
        Greeting("Android")
    }
}