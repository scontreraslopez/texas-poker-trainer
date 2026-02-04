package net.iessochoa.joseantoniolopez.t14_firebase.data.repository

import kotlinx.serialization.json.Json
import net.iessochoa.joseantoniolopez.t14_firebase.data.firebase.AutenticacionFireBase
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

/**
 * Objeto Repository que actúa como una capa de abstracción para interactuar con el objeto AutenticacionFireBase.
 * Proporciona métodos suspendidos para las operaciones de autenticación y gestión del usuario actual.
 */
object Repository {

    /**
     * Inicia sesión con un correo electrónico y contraseña utilizando la capa de autenticación.
     * @param email El correo electrónico del usuario.
     * @param password La contraseña del usuario.
     * @return Un resultado de la operación de inicio de sesión.
     */
    suspend fun login(email: String, password: String) =
        AutenticacionFireBase.login(email, password)

    /**
     * Registra un nuevo usuario con correo electrónico, contraseña y opcionalmente un nombre para mostrar.
     * @param email El correo electrónico del usuario.
     * @param password La contraseña del usuario.
     * @param displayName El nombre para mostrar del usuario (opcional).
     * @return Un resultado de la operación de registro.
     */
    suspend fun register(email: String, password: String, displayName: String = "") =
        AutenticacionFireBase.register(email, password, displayName = displayName)

    /**
     * Obtiene el usuario actualmente autenticado a través de la capa de autenticación.
     * @return El usuario actual o null si no hay un usuario autenticado.
     */
    fun getCurrentUser() = AutenticacionFireBase.getCurrentUser()

    /**
     * Cierra la sesión del usuario actual utilizando la capa de autenticación.
     */
    fun logout() = AutenticacionFireBase.logout()

    /**
     * Envía un correo para restablecer la contraseña del usuario especificado.
     * @param email El correo electrónico del usuario.
     * @return Un resultado de la operación de restablecimiento de contraseña.
     */
    suspend fun resetPassword(email: String) =
        AutenticacionFireBase.resetPassword(email)

    fun estaLogueado()=AutenticacionFireBase.estaLogueado()


    private val baseUrl = "https://www.deckofcardsapi.com/api/"

    //Empezamos a inicializar primero Retrofit, siempre lazy.
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .addConverterFactory(Json {
                ignoreUnknownKeys = true
                coerceInputValues = true
            }.asConverterFactory("application/json".toMediaType()))
            .baseUrl(baseUrl)
            .build()
    }

    /*
    private val retrofitService: RickAndMortyApiService by lazy {
        retrofit.create(RickAndMortyApiService::class.java)
    }

    suspend fun getCharacters() = retrofitService.getCharacters()
    */




}

