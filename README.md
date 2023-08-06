# List Jetpack Compose
# Kotlin
***
Proyecto Aplicaciones con Kotlin
## Tabla de Contenidos
* [Descripción del proyecto](#descripción-del-proyecto)
* [Estado del proyecto](#estado-del-proyecto)
* [Funcionalidades del proyecto](#Funcionalidades-del-proyecto)
* [Tecnologías utilizadas](#tecnologías-utilizadas)
* [Contacto](#contacto)

### Descripción
***
* Proyecto de elaboracion de listas con inyeccion de datos en Android Studio (Recomended version: Giraffe | 2022.3.1) con lenguaje Kotlin.
### Estado del proyecto
***
👷 Proyecto Finalizado 👷

### Funcionalidades del proyecto
***
* class MainActivity : ComponentActivity(): Esto define una clase llamada MainActivity que hereda de ComponentActivity, que es una clase base proporcionada por Android para las actividades de la aplicación.
  
* setContent { ... }: Aquí es donde se define el contenido de la interfaz de usuario de la actividad utilizando Jetpack Compose, en lugar de usar XML.
  
* MyApp2687386Theme: Aquí se aplica un tema llamado MyApp2687386Theme a la interfaz de usuario. Los temas en Compose permiten definir el aspecto.
  
* Surface(modifier = Modifier.fillMaxSize()) { ... }: Esto crea un componente de superficie que ocupa todo el tamaño disponible de la pantalla.
  
* Conversation(SampleData.conversationSample): Aquí se crea y muestra el contenido de la conversación en la interfaz de usuario. SampleData.conversationSample es un conjunto de datos que contiene unos mensajes que utilizaremos para recrear un tipo de Chat.
  
#### Funciones
***

* MessageCardLeft(msg: Message): Esta función componible se utiliza para mostrar una tarjeta de mensaje en el lado izquierdo de la conversación. Toma un objeto Message como argumento y define una fila (Row) que contiene el contenido del mensaje utilizando el composable MessageContentLeft.
  
* MessageCardRight(msg: Message): Similar a la función anterior, esta función componible muestra una tarjeta de mensaje, pero en el lado derecho de la conversación. También toma un objeto Message como argumento y utiliza un Row para presentar el contenido del mensaje mediante el composable MessageContentRight.
  
* MessageContentLeft(msg: Message) && MessageContentRight(msg: Message):
    * Esta función componible muestra el contenido de un mensaje en el lado izquierdo/derecho de la conversación.
    * El modifier es una propiedad clave que se utiliza para aplicar cambios o transformaciones visuales a los componibles.
    * Spacer: se agrega un espacio (Spacer) horizontal.
    * El contenido del mensaje es expandible haciendo clic en él. Se utiliza un estado (isExpanded).
* Conversation: Define una función componible que toma una lista de objetos Message como argumento. Representa una conversación de mensajes en la interfaz.
    * Box(modifier = Modifier.fillMaxSize()):Crea un contenedor Box que ocupa todo el espacio disponible en su contenedor padre. Esto se utiliza para establecer un fondo de pantalla para la conversación.
    * if (index % 2 == 0) { ... } else { ... }:Verifica si el índice del mensaje es par o impar para determinar si se debe mostrar a la izquierda o a la derecha de la conversación.
