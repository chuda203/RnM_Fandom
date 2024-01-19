package com.up45.rnmfandom

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import com.google.gson.reflect.TypeToken

class CharacterRepository(private val context: Context) {

    private val apiService = ApiClient.apiService
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("CharacterPrefs", Context.MODE_PRIVATE)

    suspend fun getAndSaveCharacters() {
        try {
            val apiResponse = apiService.getCharacters()
            val characters = apiResponse.results

            // Simpan data ke SharedPreferences
            saveCharactersToSharedPreferences(characters)
        } catch (e: Exception) {
            // Handle error
        }
    }

    private fun saveCharactersToSharedPreferences(characters: List<Character>) {
        val editor = sharedPreferences.edit()
        editor.putString("characters", Gson().toJson(characters))
        editor.apply()
        Log.d("CharacterRepository", "Data berhasil disimpan di SharedPreferences.")
    }

    fun getCharactersFromSharedPreferences(): List<Character> {
        val charactersJson = sharedPreferences.getString("characters", "")
        return if (charactersJson.isNullOrEmpty()) {
            emptyList()
        } else {
            try {
                // Langsung membaca sebagai list dari objek Character
                Gson().fromJson(charactersJson, object : TypeToken<List<Character>>() {}.type)
            } catch (e: JsonSyntaxException) {
                // Tangani kesalahan jika parsing gagal
                emptyList()
            }
        }
    }
}
