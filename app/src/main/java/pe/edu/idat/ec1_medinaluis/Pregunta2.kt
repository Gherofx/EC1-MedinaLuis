package pe.edu.idat.ec1_medinaluis

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Pregunta2(){

    Box(modifier = Modifier
        .fillMaxSize()
        .padding(top = 25.dp)){

        var numero1 by rememberSaveable {
            mutableStateOf("")
        }

        var numero2 by rememberSaveable {
            mutableStateOf("")
        }
        var calculandon by rememberSaveable {
            mutableStateOf("")
        }



        Column {
            Text(text = "CALCULANDO NUMEROS",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                style = TextStyle(fontSize = 40.sp,
                fontWeight = FontWeight.Bold)
            )
            MySpace(16)
            OutlinedTextField(value = numero1,
                onValueChange = {numero1=it},
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Ingrese Primer Numero")},
                maxLines =1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            MySpace(16)
            OutlinedTextField(value = numero2,
                onValueChange = {numero2=it},
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Ingrese Segundo Numero")},
                maxLines =1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            MySpace(16)
            Button(onClick = {
                calculandon= calculando(numero1.toInt(),numero2.toInt())
            },
                modifier = Modifier.fillMaxWidth()) {
                Text(text = "CALCULAR NUMERO")
            }
            Text(text = calculandon, style = TextStyle(fontWeight = FontWeight.Bold, color = Color.Black))

        }
    }

}

fun calculando(numero1:Int,numero2:Int):String{
    var resultado=""
    var valor=0

    if(numero1==numero2){
        valor=numero1*numero2
    }else if(numero1>numero2){
        valor=numero1-numero2
    }else{
        valor=numero1+numero2
    }

    resultado="El resultado del calculo es $valor"

    return resultado
}

