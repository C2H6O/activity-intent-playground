package net.doubov.testingactivityintents

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import net.doubov.testingactivityintents.ui.theme.TestingActivityIntentsTheme

class Activity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestingActivityIntentsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("${intent.getStringExtra("string1")} ${intent.getStringExtra("string2")}! ${intent.getStringExtra("string3")}")
                }
            }
        }
        if (savedInstanceState == null) {
            intent.putExtra("string3", "another one!!")
            println("LX+++ added string3!!")
        }
        println("LX+++ itent extras ${intent.extras}")
    }

    companion object {
        fun createIntent(context: Context, string1: String, string2: String): Intent =
            Intent(context, Activity2::class.java).apply {
                putExtra("string1", string1)
                putExtra("string2", string2)
            }
    }

}