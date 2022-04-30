package com.example.vgeqapp.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vgeqapp.R
import com.example.vgeqapp.api.NetworkResult
import com.example.vgeqapp.databinding.FragmentSummaryBinding
import com.example.vgeqapp.viewmodel.EQViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SummaryFragment : Fragment() {

    private var _binding: FragmentSummaryBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewmodel: EQViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSummaryBinding.inflate(inflater, container, false)
        viewmodel = ViewModelProvider(this).get(EQViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView()
        getLatestEQData()
        observeLatestEQData()
    }

    fun setRecyclerView() {
        binding.rvEqSummaryList.layoutManager = LinearLayoutManager(activity)
    }

    fun getLatestEQData() {
        viewmodel.getLatestEQData()
    }

    fun observeLatestEQData() {
        viewmodel.getLatestEQData.observe(viewLifecycleOwner, { response ->
            when (response) {
                is NetworkResult.Success -> {
                    binding.progressBar.visibility = View.GONE
                    response.data?.let {
                        binding.rvEqSummaryList.adapter = EQSummaryAdapter(it,activity, {
                            naviagtetoDetails(it)
                        }
                        )
                    }
                }
                is NetworkResult.Error -> {
                    binding.progressBar.visibility = View.GONE

                    Toast.makeText(
                        requireContext(),
                        response.message.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }

                is NetworkResult.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
            }

        })
    }

    fun naviagtetoDetails(id: String) {

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}