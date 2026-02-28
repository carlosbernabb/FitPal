package com.fitpal.app

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.fitpal.app.databinding.ActivityMainBinding

/**
 * Home screen: displays category chips (Seafood / Beef / Vegan) and
 * a filtered recipe feed powered by RecipeAdapter.
 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter = RecipeAdapter()

    // All available recipes —– swap imageResId for real drawables/urls
    private val allRecipes = listOf(
        Recipe(
            id = 1,
            name = "Ensalada Verde de Aguacate",
            imageResId = R.drawable.placeholder_food,   // add your image drawable
            rating = 4.8f,
            timeMinutes = 15,
            calories = 240,
            category = "Vegan"
        ),
        Recipe(
            id = 2,
            name = "Bol de Proteína a la Parrilla",
            imageResId = R.drawable.placeholder_food,
            rating = 4.9f,
            timeMinutes = 25,
            calories = 410,
            category = "Beef"
        ),
        Recipe(
            id = 3,
            name = "Batido de Frutos Rojos",
            imageResId = R.drawable.placeholder_food,
            rating = 4.7f,
            timeMinutes = 10,
            calories = 180,
            category = "Seafood"
        )
    )

    private var activeCategory = "Seafood"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        setupCategoryChips()
        setupBottomNav()

        // Show initial category
        filterRecipes(activeCategory)
    }

    // ── RecyclerView ──────────────────────────────────────────────────────────

    private fun setupRecyclerView() {
        binding.rvRecipes.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = this@MainActivity.adapter
            isNestedScrollingEnabled = false
        }
    }

    // ── Category chips ────────────────────────────────────────────────────────

    private fun setupCategoryChips() {
        val chips = mapOf(
            binding.chipSeafood to "Seafood",
            binding.chipBeef    to "Beef",
            binding.chipVegan   to "Vegan"
        )

        chips.forEach { (chip, category) ->
            chip.setOnClickListener {
                activeCategory = category
                filterRecipes(category)
                updateChipStyles(chips, chip)
            }
        }
    }

    private fun filterRecipes(category: String) {
        val filtered = allRecipes.filter { it.category == category }
        adapter.submitList(filtered)
    }

    private fun updateChipStyles(
        chips: Map<TextView, String>,
        activeChip: TextView
    ) {
        chips.keys.forEach { chip ->
            if (chip == activeChip) {
                chip.setBackgroundResource(R.drawable.bg_category_active)
                chip.setTextColor(getColor(android.R.color.white))
            } else {
                chip.setBackgroundResource(R.drawable.bg_category_inactive)
                chip.setTextColor(0xFFD1D5DB.toInt())
            }
        }
    }

    // ── Bottom navigation ─────────────────────────────────────────────────────

    private fun setupBottomNav() {
        binding.navHome.setOnClickListener {
            // Already on home — scroll to top
            binding.nsvContent.smoothScrollTo(0, 0)
        }
        binding.navProfile.setOnClickListener {
            Toast.makeText(this, "Perfil — próximamente", Toast.LENGTH_SHORT).show()
        }
    }
}
