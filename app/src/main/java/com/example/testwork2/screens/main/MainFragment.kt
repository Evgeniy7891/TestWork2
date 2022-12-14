package com.example.testwork2.screens.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.testwork2.R
import com.example.testwork2.databinding.FragmentMainBinding
import com.example.testwork2.model.company.CompanyItem

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by viewModels()
    var scroll = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        viewModel.getCompany()
        viewModel.companyList.observe(viewLifecycleOwner) {
            initialCompany(it)
            binding.recyclerviewCompany.scrollToPosition(scroll)
        }
        return binding.root
    }

    private fun initialCompany(item: List<CompanyItem>) {
       binding.recyclerviewCompany.layoutManager = GridLayoutManager(context, 2)
        val adapter = MainAdapter(item)
        binding.recyclerviewCompany.adapter = adapter

    }

    override fun onStop() {
        super.onStop()
        scroll = (binding.recyclerviewCompany.layoutManager as GridLayoutManager).findFirstCompletelyVisibleItemPosition()
    }

    override fun onPause() {
        super.onPause()
        scroll = (binding.recyclerviewCompany.layoutManager as GridLayoutManager).findFirstCompletelyVisibleItemPosition()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}