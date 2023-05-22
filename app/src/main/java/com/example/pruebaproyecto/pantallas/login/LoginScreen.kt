package com.example.pruebaproyecto.pantallas.login


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.pruebaproyecto.R

@Composable

fun LoginScreen(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),

    ){
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Login Image",
            contentScale = ContentScale.Inside,
        )
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp),
                color = MaterialTheme.colorScheme.background,
                shape = RoundedCornerShape(
                    topStartPercent = 8,
                    topEndPercent = 8
                )
            ) {

            }
            FloatingActionButton(
                modifier = Modifier.size(72.dp),
                onClick = { /*TODO*/ }
            ){
                Icon(
                    modifier = Modifier.size(42.dp),
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "forward Icon"
                )

            }
        }
    }
}