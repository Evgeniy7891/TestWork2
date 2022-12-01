package com.example.testwork2.screens.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.testwork2.R
import com.example.testwork2.databinding.FragmentDetailsBinding


class DetailsFragment : Fragment() {

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: DetailsViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        val id = arguments?.getString("MyArg")!!.toInt()
        println("DETAILS - $id")
        viewModel.getCompany(id)
        viewModel.detailsList.observe(viewLifecycleOwner) {
            with(binding) {
                tvDetailsName.text = it.name
                if (it.phone.isNotEmpty()) {
                    tvNumberPhone.isVisible = true
                    tvNumberPhone.text = it.phone
                }
                if (it.www.isNotEmpty()) {
                    tvWww.isVisible = true
                    tvWww.text = it.www
                }
                tvContent.text = it.description
                tvContent.isAllCaps = false
                Glide.with(ivDetailsCompany)
                    .load("https://lifehack.studio/test_task/" + it.img)
                    .placeholder(R.drawable.ic_image_search)
                    .error(R.drawable.ic_image_search)
                    .timeout(500)
                    .into(ivDetailsCompany)
            }
        }
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}