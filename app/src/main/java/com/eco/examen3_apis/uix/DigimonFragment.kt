package com.eco.examen3_apis.uix

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.eco.examen3_apis.adapter.DigimonAdapter
import com.eco.examen3_apis.databinding.FragmentDigimonBinding
import com.eco.examen3_apis.model.DigimonViewModel

class DigimonFragment : Fragment() {
    private lateinit var binding: FragmentDigimonBinding
    private val viewModel by viewModels<DigimonViewModel>()
    private val adapter = DigimonAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDigimonBinding.inflate(inflater, container, false)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter
        viewModel.digimonCards.observe(viewLifecycleOwner) { cards ->
            adapter.submitList(cards)
        }
        return binding.root
    }

}



