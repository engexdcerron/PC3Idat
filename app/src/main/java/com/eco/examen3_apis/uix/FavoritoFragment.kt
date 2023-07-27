package com.eco.examen3_apis.uix

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.eco.examen3_apis.R
import com.eco.examen3_apis.databinding.FragmentFavoritoBinding
import com.eco.examen3_apis.model.DigimonViewModel

class FavoritoFragment : Fragment() {
    private lateinit var binding: FragmentFavoritoBinding
    private val viewModel by viewModels<DigimonViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoritoBinding.inflate(inflater, container, false)
        viewModel.digimonCards.observe(viewLifecycleOwner) { cards ->
            val card = cards.random()
            binding.nombre.text = "Nombre: " + card.name
            binding.nrocard.text = "Nro. de Serie: " + card.cardnumber
        }
        binding.imgDigimon.setImageResource(R.drawable.digimon)
        return binding.root
    }
}

