package com.example.learningdiceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.mutableStateOf
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learningdiceroller.ui.theme.LearningDiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearningDiceRollerTheme {
                Surface (modifier = Modifier.fillMaxSize()) {
                    DiceButton(modifier = Modifier.background(Color(0xFFFAFAFA)).fillMaxSize().wrapContentSize(Alignment.Center))
                }
            }
        }
    }
}


@Composable
fun DiceButton(modifier: Modifier=Modifier){
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        var result by remember { mutableIntStateOf( 1) }
        val imageResource = when(result) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        val image= painterResource(imageResource)
        Image(
            painter = image,
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {result = (1..6).random()}) {
            Text(stringResource(R.string.roll), fontSize = 24.sp)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun DiceGame(){
    DiceButton(modifier = Modifier.background(Color(0xFFFAFAFA)).fillMaxSize().wrapContentSize(Alignment.Center))
}