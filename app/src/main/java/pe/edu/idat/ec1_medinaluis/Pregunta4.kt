package pe.edu.idat.ec1_medinaluis

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Pregunta4(){
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(top = 40.dp)){

        var resultadod by rememberSaveable {
            mutableStateOf("")
        }

        Column {
            Text(text = "Impresion de Suma de Digitos del 23 al 99",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                style = TextStyle(fontSize = 40.sp,
                    fontWeight = FontWeight.Bold)
            )
            MySpace(espacio = 16)
            Button(onClick = {
                resultadod= sumad()
            },
                modifier = Modifier.fillMaxWidth()) {
                Text(text = "Imprimir")
            }
            Text(text = resultadod, style = TextStyle(fontWeight = FontWeight.Bold, color = Color.Magenta))

        }
    }
}
fun sumad():String{
    var resultado=""
    var valor=0
    for (numero in 23..99){
        val numeroCadena = numero.toString()

        for(char in numeroCadena){
            valor+=char.toString().toInt()
        }
    }
    resultado="La suma de los digitos de cada Numero del 23 al 99 es: $valor"
    return resultado
}