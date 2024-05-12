package hr.ferit.mvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.Modifier
import hr.ferit.mvvm.view.BMICalculatorScreen
import hr.ferit.mvvm.view.BackgroundImage
import hr.ferit.mvvm.viewmodel.BMIViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BMICalculatorScreen(BMIViewModel())
            BackgroundImage(modifier = Modifier)
        }
    }
}
