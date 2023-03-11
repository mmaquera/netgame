package com.mmaquera.netgame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.SideEffect
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.mmaquera.netgame.ui.navigation.Navigation
import com.mmaquera.netgame.ui.theme.NetGameTheme
import com.mmaquera.netgame.ui.theme.WhiteSmoke
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NetGameTheme {
                val systemUiController = rememberSystemUiController()

                SideEffect {
                    systemUiController.setStatusBarColor(
                        color = WhiteSmoke,
                        darkIcons = true
                    )
                }

                Navigation()
            }
        }
    }
}
