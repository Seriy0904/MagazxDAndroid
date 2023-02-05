package dev.seriy0904.magazxd

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dev.seriy0904.magazxd.ui.theme.MagazxDTheme
import dev.seriy0904.magazxd.view.MagazxDApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MagazxDTheme {
                MagazxDApp()
            }
        }
    }
}