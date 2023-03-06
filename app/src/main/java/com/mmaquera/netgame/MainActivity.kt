package com.mmaquera.netgame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.mmaquera.netgame.ui.navigation.Navigation
import com.mmaquera.netgame.ui.theme.NetGameTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NetGameTheme {
                //LoginScreen()
                Navigation()
            }
        }
    }
}
