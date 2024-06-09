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
fun Pregunta1(){
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(top = 30.dp)){

        var indicadorv by rememberSaveable {
            mutableStateOf("")
        }

        var tasaa by rememberSaveable {
            mutableStateOf("")
        }
        var resultadoc by rememberSaveable {
            mutableStateOf("")
        }




        Column {
            Text(text = "CONTROL DE ALCOHOLEMIA",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                style = TextStyle(fontSize = 40.sp,
                fontWeight = FontWeight.Bold)
            )
            MySpace(16)
            OutlinedTextField(value = indicadorv,
                onValueChange = {indicadorv = it},
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Ingresar el indicador de vehículo")},
                maxLines =1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )
            MySpace(16)
            OutlinedTextField(value = tasaa,
                onValueChange = {tasaa = it},
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Ingresar la tasa de alcohol del conductor")},
                maxLines =1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
            )
            MySpace(16)
            Button(onClick = {
                resultadoc= resultadoControl(indicadorv,tasaa.toDouble())
                             },
                modifier = Modifier.fillMaxWidth()) {
                Text(text = "CALCULAR ALCOHOLEMIA")
            }
            Text(text = resultadoc, style = TextStyle(fontWeight = FontWeight.Bold, color = Color.Blue))



        }
    }

}

@Composable
fun MySpace(espacio: Int) {
    Spacer(modifier = Modifier.size(espacio.dp))
}

fun resultadoControl(indicador:String,tasa: Double):String{
    var resultado="NEGATIVO"

    if ((indicador=="C"||indicador=="A"||indicador=="M") && tasa>0.3){
        resultado= "POSITIVO: La tasa $tasa, ha excedido el límite permitido."
    }

    if (indicador=="T" && tasa>0.5){
        resultado= "POSITIVO: La tasa $tasa, ha excedido el límite permitido"
    }


    return resultado
}