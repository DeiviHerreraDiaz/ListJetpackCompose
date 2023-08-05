package co.edu.sena.myapp2687386

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import co.edu.sena.myapp2687386.ui.theme.MyApp2687386Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            MyApp2687386Theme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Conversation(SampleData.conversationSample)

                }
            }

        }
    }
}

// Clase de datos para representar un mensaje con un autor y un cuerpo
data class Message(val author: String, val body: String)

// Función Composable para mostrar una tarjeta de mensaje a la izquierda
@Composable
fun MessageCardLeft(msg: Message) {
    Row(
        modifier = Modifier
            .padding(all = 8.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Start
    ) {
        MessageContentLeft(msg)
    }
}

// Función Composable para mostrar una tarjeta de mensaje a la derecha
@Composable
fun MessageCardRight(msg: Message) {
    Row(
        modifier = Modifier
            .padding(all = 8.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.End
    ) {
        MessageContentRight(msg)
    }
}

// Función Composable para mostrar el contenido de un mensaje a la izquierda
@Composable
fun MessageContentLeft(msg: Message) {
    // Imagen del autor del mensaje
    Image(
        painter = painterResource(R.drawable.uribito),
        contentDescription = null,
        modifier = Modifier
            .size(60.dp)
            .border(1.5.dp, MaterialTheme.colorScheme.secondary, CircleShape)
            .clip(CircleShape)
    )

    Spacer(modifier = Modifier.width(30.dp))

    // Contenido del mensaje expandible al hacer clic
    var isExpanded by remember { mutableStateOf(false) }
    Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
        // Nombre del autor del mensaje
        Text(
            text = msg.author,
            color = MaterialTheme.colorScheme.secondary,
            style = MaterialTheme.typography.titleSmall
        )

        Spacer(modifier = Modifier.width(8.dp))

        // Cuerpo del mensaje dentro de una superficie con forma y sombra
        Surface(shape = MaterialTheme.shapes.medium, shadowElevation = 1.dp) {
            Text(
                text = msg.body,
                modifier = Modifier.padding(all = 4.dp),
                maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

// Función Composable para mostrar el contenido de un mensaje a la derecha
@Composable
fun MessageContentRight(msg: Message) {
    // Contenido del mensaje expandible al hacer clic
    var isExpanded by remember { mutableStateOf(false) }
    Row(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
        Column {
            // Nombre del autor del mensaje
            Text(
                text = msg.author,
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleSmall
            )

            Spacer(modifier = Modifier.width(8.dp))

            // Cuerpo del mensaje dentro de una superficie con forma y sombra
            Surface(shape = MaterialTheme.shapes.medium, shadowElevation = 1.dp) {
                Text(
                    text = msg.body,
                    modifier = Modifier.padding(all = 4.dp),
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }

        Spacer(modifier = Modifier.width(8.dp))

        // Imagen del autor del mensaje
        Image(
            painter = painterResource(R.drawable.marranito),
            contentDescription = null,
            modifier = Modifier
                .size(60.dp)
                .border(1.5.dp, MaterialTheme.colorScheme.secondary, CircleShape)
                .clip(CircleShape)
        )
    }
}


// Función Composable para mostrar una conversación con una lista de mensajes
@Composable
fun Conversation(messages: List<Message>) {

    // Fondo de pantalla

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.fondo),
            contentDescription = "",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )
        LazyColumn {
            itemsIndexed(messages) { index, message ->
                if (index % 2 == 0) {
                    // Mostrar el mensaje a la izquierda si el índice es par
                    MessageCardLeft(message)
                } else {
                    // Mostrar el mensaje a la derecha si el índice es impar
                    MessageCardRight(message)
                }
            }
        }
    }
}





