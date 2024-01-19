package com.up45.rnmfandom

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var characterRepository: CharacterRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        characterRepository = CharacterRepository(this)

        // Ambil dan simpan data karakter
        lifecycleScope.launch {
            characterRepository.getAndSaveCharacters()

            // Ambil data dari SharedPreferences
            val characters = characterRepository.getCharactersFromSharedPreferences()
            // Gunakan data karakter sesuai kebutuhan
        }


        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_nav)

        bottomNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.menu_1 -> replaceFragment(HomeFragment())
                R.id.menu_2 -> replaceFragment(ProfileFragment())

                else -> {

                }

            }
            true
        }
        // Pilih item secara programatik
        bottomNav.selectedItemId = R.id.menu_1

    }

    private fun replaceFragment(fragment: Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container,fragment)
        fragmentTransaction.commit()

    }
    }

