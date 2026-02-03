# Texas Poker Trainer 🃏

Aplicación Android de entrenamiento para poker Texas Hold'em desarrollada como proyecto académico. Ayuda a los jugadores a tomar decisiones rápidas mejorando sus habilidades de juego preflop mediante práctica cronometrada.

## 📋 Descripción

Texas Poker Trainer es una aplicación educativa que simula situaciones de poker preflop donde el usuario recibe dos cartas y debe decidir rápidamente entre **Fold** (retirarse) o **Call** (seguir en la mano). La aplicación registra todas las decisiones para permitir un análisis posterior del rendimiento.

## ✨ Características

- **Autenticación de usuarios** mediante Firebase Authentication
- **Práctica cronometrada** con límite de tiempo para tomar decisiones
- **Registro de decisiones** persistente usando Room Database
- **Análisis de rendimiento** histórico de decisiones por pareja de cartas
- **API REST** integración con [Deck of Cards API](https://www.deckofcardsapi.com/)
- **Interfaz moderna** con Jetpack Compose y Material Design 3

## 🛠️ Tecnologías Utilizadas

### Core
- **Kotlin** - Lenguaje de programación principal
- **Jetpack Compose** - UI moderna y declarativa
- **Material Design 3** - Sistema de diseño

### Arquitectura y Componentes
- **Room Database** - Persistencia local de datos (decisiones y estadísticas)
- **Retrofit** - Cliente HTTP para consumir la API de Deck of Cards
- **Firebase Authentication** - Gestión de autenticación de usuarios
- **Coroutines & Flow** - Programación asíncrona y reactive streams
- **ViewModel & StateFlow** - Gestión de estado UI

### APIs Externas
- [Deck of Cards API](https://www.deckofcardsapi.com/) - Generación y distribución de cartas

## 📦 Requisitos Previos

- Android Studio Hedgehog o superior
- JDK 11 o superior
- SDK de Android mínimo: API 26 (Android 8.0)
- SDK de Android objetivo: API 36
- Cuenta de Firebase (para configurar Authentication)

## 🚀 Instalación

### 1. Clonar el repositorio

```bash
git clone https://github.com/tu-usuario/TexasPokerTrainer.git
cd TexasPokerTrainer
```

### 2. Configurar Firebase

1. Crea un proyecto en [Firebase Console](https://console.firebase.google.com/)
2. Añade una aplicación Android con el package name: `net.iessochoa.sergiocontreras.texaspokertrainer`
3. Descarga el archivo `google-services.json`
4. Coloca el archivo en el directorio `app/`
5. Habilita **Email/Password Authentication** en la consola de Firebase

### 3. Agregar dependencias

Asegúrate de añadir las siguientes dependencias en `gradle/libs.versions.toml` y `app/build.gradle.kts`:

//TODO with proper versions

### 4. Sincronizar y compilar

```bash
./gradlew build
```

## 🎮 Funcionalidad

### Flujo de la Aplicación

1. **Autenticación**
   - Registro de nuevos usuarios
   - Inicio de sesión con email y contraseña
   - Gestión de sesión persistente

2. **Sesión de Entrenamiento**
   - Se crea un nuevo mazo mediante la API
   - El usuario recibe 2 cartas aleatorias
   - Temporizador cuenta regresiva (configurable, ej: 5-10 segundos)
   - El usuario debe decidir: **Fold** o **Call**
   - La decisión se guarda junto con las cartas recibidas

3. **Análisis de Decisiones**
   - Visualización del historial de decisiones
   - Estadísticas por tipo de mano (parejas, cartas altas, suited, etc.)
   - Porcentajes de fold vs call
   - Identificación de patrones de juego

## 📊 Estructura de Datos

### Base de datos Room

**Entidad: Decision**
```kotlin
@Entity(tableName = "decisions")
data class Decision(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val userId: String,
    val card1: String,      // ej: "AS" (As de picas)
    val card2: String,      // ej: "KH" (Rey de corazones)
    val decision: String,   // "FOLD" o "CALL"
    val timestamp: Long,
    val timeToDecide: Int   // milisegundos
)
```

### API Endpoints (Deck of Cards API)

- `GET /api/deck/new/shuffle/?deck_count=1` - Crear mazo nuevo
- `GET /api/deck/{deck_id}/draw/?count=2` - Robar 2 cartas

## 🏗️ Arquitectura

```
app/
├── data/
│   ├── local/
│   │   ├── dao/           # Room DAOs
│   │   ├── database/      # Room Database
│   │   └── entities/      # Room Entities
│   ├── remote/
│   │   ├── api/           # Retrofit API Services
│   │   └── dto/           # Data Transfer Objects
│   └── repository/        # Repositorios (patrón Repository)
├── domain/
│   ├── model/             # Modelos de dominio
│   └── usecase/           # Casos de uso
├── ui/
│   ├── auth/              # Pantallas de autenticación
│   ├── game/              # Pantallas de juego
│   ├── stats/             # Pantallas de estadísticas
│   └── theme/             # Tema de la aplicación
└── util/                  # Utilidades y extensiones
```

## 🎯 Objetivos Académicos

Este proyecto demuestra el uso de:

- ✅ **Room Database** para persistencia local
- ✅ **Retrofit** para consumo de APIs REST
- ✅ **Firebase Authentication** para gestión de usuarios
- ✅ **Jetpack Compose** para UI moderna
- ✅ **Arquitectura MVVM** con separación de capas
- ✅ **Coroutines** para operaciones asíncronas
- ✅ **Material Design 3** para diseño consistente

## 📝 Próximas Mejoras

- [ ] Agregar diferentes modos de juego (postflop, diferentes posiciones)
- [ ] Implementar sistema de puntuación basado en correctitud de decisiones
- [ ] Añadir recomendaciones basadas en rangos de manos
- [ ] Sincronización de datos con Firebase Firestore
- [ ] Modo multijugador para comparar estadísticas

## 👨‍💻 Autor

**Sergio Contreras**
IES Sochoa - Proyecto Académico

## 📄 Licencia

Este proyecto es de código abierto y está disponible bajo la licencia MIT para fines educativos.

## 🙏 Agradecimientos

- [Deck of Cards API](https://www.deckofcardsapi.com/) por proporcionar una API gratuita y fácil de usar
- Comunidad de Android Developers
- IES Sochoa

---

**Nota:** Este es un proyecto con fines educativos. No está destinado para juego real con dinero.
