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
fun Pregunta3(){
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(top = 25.dp)){

        var numerol by rememberSaveable {
            mutableStateOf("")
        }
        var resultadol by rememberSaveable {
            mutableStateOf("")
        }

        Column {
            Text(text = "IMPRIMIR EL MES EN LETRAS",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                style = TextStyle(fontSize = 40.sp,
                    fontWeight = FontWeight.Bold)
            )
            MySpace(espacio = 16)
            OutlinedTextField(value = numerol,
                onValueChange = {numerol=it},
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Ingrese un Numero")},
                maxLines =1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            MySpace(16)
            Button(onClick = {
                resultadol= mesLetras(numerol.toInt())
            },
                modifier = Modifier.fillMaxWidth()) {
                Text(text = "MES EN LETRAS")
            }
            Text(text = resultadol, style = TextStyle(fontWeight = FontWeight.Bold, color = Color.Green))

        }

    }
}

fun mesLetras(numero1:Int):String{
    var resultado=""
    when (numero1) {
        1 -> resultado="Enero"
        2 -> resultado="Febrero"
        3 -> resultado="Marzo"
        4 -> resultado="Abril"
        5 -> resultado="Mayo"
        6 -> resultado="Junio"
        7 -> resultado="Julio"
        8 -> resultado="Agosto"
        9 -> resultado="Setiembre"
        10 -> resultado="Octubre"
        11 -> resultado="Noviembre"
        12 -> resultado="Diciembre"
        else -> resultado="Error: Solo hay 12 meses al año asi que digite porfavor del 1 al 12"
    }
    return resultado
}
