package com.fitpal.app

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.fitpal.app.databinding.ItemRecipeBinding

/**
 * RecyclerView adapter for the recipe feed on the home screen.
 * Uses ListAdapter + DiffUtil for efficient list updates when the
 * active category chip changes.
 */
class RecipeAdapter : ListAdapter<Recipe, RecipeAdapter.RecipeViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<Recipe>() {
        override fun areItemsTheSame(oldItem: Recipe, newItem: Recipe) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Recipe, newItem: Recipe) = oldItem == newItem
    }

    inner class RecipeViewHolder(private val binding: ItemRecipeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(recipe: Recipe) {
            binding.tvRecipeName.text = recipe.name
            binding.tvRating.text = recipe.rating.toString()
            binding.tvTime.text = "${recipe.timeMinutes} min"
            binding.tvCalories.text = "${recipe.calories} kcal"
            binding.ivRecipeImage.setImageResource(recipe.imageResId)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val binding = ItemRecipeBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return RecipeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
