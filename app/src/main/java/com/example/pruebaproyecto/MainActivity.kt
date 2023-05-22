package com.example.pruebaproyecto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pruebaproyecto.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme{
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {

                }
            }
        }
    }
}
@Composable
fun ComponentTest(){
    FloatingActionButton(
            modifier = Modifier.size(72.dp),
            contentColor = MaterialTheme.colorScheme.inversePrimary,
            onClick = { /*TODO*/ }) {
        Icon(
            modifier = Modifier.size(42.dp),
            imageVector = Icons.Default.ArrowForward,
            contentDescription = "forward Icon",

        )
    }
}
@Composable
@Preview
fun ButtonPreview(){
    AppTheme {
        ComponentTest()
    }
}



