package com.example.vgeqapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.vgeqapp.R
import com.example.vgeqapp.databinding.FragmentDetailsBinding
import com.example.vgeqapp.databinding.FragmentSummaryBinding
import com.example.vgeqapp.viewmodel.EQViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailsFragment : Fragment() {

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewmodel: EQViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        viewmodel = ViewModelProvider(requireActivity()).get(EQViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObservables()
    }

    fun setObservables() {
        viewmodel.getSelectedEQData.observe(viewLifecycleOwner, {
            binding.txtMagnitude.text = getString(R.string.magnitude) +" "+ it?.magnitude
            binding.txtDateTime.text = getString(R.string.date_and_time) +" "+ it?.date
            binding.txtPlace.text = getString(R.string.Place) +" "+ it?.place
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}