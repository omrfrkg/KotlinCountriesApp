package com.example.kotlincountries.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlincountries.databinding.FragmentCountryBinding




class CountryFragment : Fragment() {


    private var _binding: FragmentCountryBinding? = null
    private val binding get() = _binding!!

    private var countryUuid = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCountryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            countryUuid =  CountryFragmentArgs.fromBundle(it).countryUuid
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}