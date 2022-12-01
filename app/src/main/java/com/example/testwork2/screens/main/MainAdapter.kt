package com.example.testwork2.screens.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavArgs
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.NavigatorProvider
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.testwork2.R
import com.example.testwork2.databinding.CardCompanyItemBinding
import com.example.testwork2.databinding.FragmentMainBinding
import com.example.testwork2.model.company.CompanyItem

class MainAdapter(private val listCompany: List<CompanyItem>) :
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            CardCompanyItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listCompany[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return listCompany.size
    }

    class ViewHolder(private val binding: CardCompanyItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(companyItem: CompanyItem) {
            binding.apply {
                itemView.setOnClickListener {
                    val id = companyItem.id.toString()
                    val bundle = Bundle()
                    bundle.putString("MyArg", id)
                    Navigation.createNavigateOnClickListener(
                        R.id.action_mainFragment_to_detailsFragment,
                        bundle
                    ).onClick(it)
                }
                tvCompanyName.text = companyItem.name
                Glide.with(ivPhotoCompany)
                    .load(companyItem.img)
                    .placeholder(R.drawable.ic_image_search)
                    .error(R.drawable.ic_image_search)
                    .circleCrop()
                    .timeout(500)
                    .into(ivPhotoCompany)
            }
        }
    }
}