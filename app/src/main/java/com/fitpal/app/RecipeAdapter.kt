package com.fitpal.app

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.fitpal.app.databinding.ItemRecipeBinding

class RecipeAdapter(private val items: List<Recipe>) :
    RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

    inner class RecipeViewHolder(private val binding: ItemRecipeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(recipe: Recipe) {
            binding.tvRecipeName.text = recipe.name
            binding.tvRating.text = recipe.rating.toString()
            binding.tvTime.text = "${recipe.timeMinutes} min"
            binding.tvCalories.text = "${recipe.calories} kcal"

            // Load image with Glide
            Glide.with(binding.ivRecipeImage.context)
                .load(recipe.imageUrl)
                .apply(
                    RequestOptions()
                        .centerCrop()
                        .placeholder(R.color.input_bg)
                        .error(R.color.input_bg)
                )
                .into(binding.ivRecipeImage)

            binding.btnAdd.setOnClickListener {
                Toast.makeText(
                    binding.root.context,
                    "${recipe.name} añadido",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val binding = ItemRecipeBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return RecipeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size
}
