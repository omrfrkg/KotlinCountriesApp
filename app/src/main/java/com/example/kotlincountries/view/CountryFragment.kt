package com.example.kotlincountries.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.kotlincountries.databinding.FragmentCountryBinding
import com.example.kotlincountries.util.downloadFromURL
import com.example.kotlincountries.util.placeHolderProgressBar
import com.example.kotlincountries.viewmodel.CountryViewModel


class CountryFragment : Fragment() {


    private lateinit var viewModel : CountryViewModel


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


        viewModel = ViewModelProvider(requireActivity()).get(CountryViewModel::class.java)
        viewModel.getDataFromRoom(countryUuid)


        observeLiveData()


    }

    private fun observeLiveData(){
        viewModel.countryLiveData.observe(viewLifecycleOwner, Observer { country ->
            country?.let {
                binding.countryName.text = country.countryName
                binding.countryCapital.text = country.countryCapital
                binding.countryCurrency.text = country.countryCurrency
                binding.countryRegion.text = country.countryRegion
                binding.countryLanguage.text = country.countryLanguage
                context?.let {
                    binding.countryImage.downloadFromURL(country.imageURL, placeHolderProgressBar(it))
                }

            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}