package com.eco.examen3_apis.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.eco.examen3_apis.R
import com.eco.examen3_apis.databinding.ItemDigimonCardBinding
import com.eco.examen3_apis.model.DigimonCard


class DigimonAdapter : ListAdapter<DigimonCard, DigimonViewHolder>(DiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DigimonViewHolder {
        val binding = ItemDigimonCardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return DigimonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DigimonViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class DigimonViewHolder(private val binding: ItemDigimonCardBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(card: DigimonCard) {
        binding.nombre.text = "Nombre: " + card.name
        binding.numerocard.text = "Nro. de serie: " + card.cardnumber
        Glide.with(binding.root)
            .load(R.drawable.digimon)
            .into(binding.imgDigimon)
    }
}

class DiffCallback : DiffUtil.ItemCallback<DigimonCard>() {
    override fun areItemsTheSame(oldItem: DigimonCard, newItem: DigimonCard): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: DigimonCard, newItem: DigimonCard): Boolean {
        return oldItem == newItem
    }
}



