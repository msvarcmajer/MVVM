package hr.ferit.mvvm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import hr.ferit.mvvm.model.BMIModel

class BMIViewModel : ViewModel() {

    val bmiModel = BMIModel(weight = null, height = null, bmiResult = null)

    fun calculateBMI(weight: Float?, height: Float?): Float? {
        return if (weight != null && height != null && height > 0) {
            val bmi = weight / ((height / 100) * (height / 100))
            bmiModel.bmiResult = bmi
            bmi // Return calculated BMI
        } else {
            bmiModel.bmiResult = null
            null // Return null if weight or height is null or height is less than or equal to 0
        }
    }
}
