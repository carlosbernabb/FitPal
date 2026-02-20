package com.fitpal.app

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.fitpal.app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val recipes = listOf(
        Recipe(
            id = 1,
            name = "Ensalada Verde de Aguacate",
            imageUrl = "https://images.unsplash.com/photo-1512621776951-a57141f2eefd?w=800",
            rating = 4.8f,
            timeMinutes = 15,
            calories = 240
        ),
        Recipe(
            id = 2,
            name = "Bol de Proteína a la Parrilla",
            imageUrl = "https://images.unsplash.com/photo-1467003909585-2f8a72700288?w=800",
            rating = 4.9f,
            timeMinutes = 25,
            calories = 410
        ),
        Recipe(
            id = 3,
            name = "Batido de Frutos Rojos",
            imageUrl = "https://images.unsplash.com/photo-1553530666-ba11a7da3888?w=800",
            rating = 4.7f,
            timeMinutes = 10,
            calories = 180
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        setupNavigation()
        setupFab()
    }

    private fun setupRecyclerView() {
        binding.rvRecipes.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = RecipeAdapter(recipes)
            isNestedScrollingEnabled = false
        }
    }

    private fun setupNavigation() {
        binding.navHome.setOnClickListener { /* already on home */ }
        binding.navExplore.setOnClickListener {
            binding.etSearch.requestFocus()
        }
        binding.navSaved.setOnClickListener {
            Toast.makeText(this, "Guardados — próximamente", Toast.LENGTH_SHORT).show()
        }
        binding.navProfile.setOnClickListener {
            Toast.makeText(this, "Perfil — próximamente", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupFab() {
        binding.fabAdd.setOnClickListener {
            Toast.makeText(this, "Añadir receta — próximamente", Toast.LENGTH_SHORT).show()
        }
    }
}
