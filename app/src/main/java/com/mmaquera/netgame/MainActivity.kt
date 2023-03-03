package com.mmaquera.netgame

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.mmaquera.netgame.ui.navigation.Navigation
import com.mmaquera.netgame.ui.screen.LoginScreen
import com.mmaquera.netgame.ui.theme.NetgameTheme

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NetgameTheme {
                //LoginScreen()
                Navigation()
            }
        }
    }
}
