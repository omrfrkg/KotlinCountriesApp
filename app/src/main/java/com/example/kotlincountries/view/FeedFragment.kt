package com.example.kotlincountries.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlincountries.adapter.CountryAdapter
import com.example.kotlincountries.databinding.FragmentFeedBinding
import com.example.kotlincountries.viewmodel.FeedViewModel

class FeedFragment : Fragment() {

    private lateinit var viewModel : FeedViewModel
    private var countryAdapter = CountryAdapter(arrayListOf())

    private var _binding: FragmentFeedBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFeedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //viewModel = ViewModelProviders.of(this).get(FeedViewModel::class.java)
        viewModel = ViewModelProvider(requireActivity()).get(FeedViewModel::class.java)
        viewModel.refreshData()

        binding.countryList.layoutManager = LinearLayoutManager(context)
        binding.countryList.adapter = countryAdapter


        binding.swipeRefreshLayout.setOnRefreshListener {
            binding.countryList.visibility = View.GONE
            binding.countryError.visibility = View.GONE
            binding.countryLoading.visibility = View.VISIBLE
            viewModel.refreshFromAPI()

            binding.swipeRefreshLayout.isRefreshing = false
        }

        observeLiveData()





       /* binding.fragmentButton.setOnClickListener {
            val action = FeedFragmentDirections.actionFeedFragmentToCountryFragment()
            Navigation.findNavController(it).navigate(action)
        }*/

    }

    fun observeLiveData(){

        viewModel.countries.observe(viewLifecycleOwner,Observer{countries ->
            countries?.let {
                binding.countryList.visibility = View.VISIBLE
                countryAdapter.updateCountryList(countries)
            }
        })

        viewModel.countryError.observe(viewLifecycleOwner,Observer{error ->

            error?.let {
                if (it){
                    binding.countryError.visibility = View.VISIBLE
                }
                else{
                    binding.countryError.visibility = View.GONE
                }
            }

        })

        viewModel.countryLoading.observe(viewLifecycleOwner,Observer{loading ->
            loading?.let {
                if (it){
                    binding.countryError.visibility = View.GONE
                    binding.countryLoading.visibility = View.VISIBLE
                    binding.countryList.visibility = View.GONE
                }
                else{
                    binding.countryLoading.visibility = View.GONE
                }
            }
        })


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}