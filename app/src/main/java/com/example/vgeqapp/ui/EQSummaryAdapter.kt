package com.example.vgeqapp.ui

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.vgeqapp.R
import com.example.vgeqapp.data.EQData
import com.example.vgeqapp.databinding.EqLitsItemBinding
import com.example.vgeqapp.model.Feature

class EQSummaryAdapter(private val eqdataSumamryList:List<EQData>,
                       private val context: Context?,
                       private  val onclick :(String) -> Unit) : RecyclerView.Adapter<EQSummaryAdapter.EQViewHolder>() {

    class EQViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = EQViewHolder(
        EqLitsItemBinding.inflate(LayoutInflater.from(parent.context),parent,false).root
    )

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onBindViewHolder(holder: EQSummaryAdapter.EQViewHolder, position: Int) {
        var data = eqdataSumamryList.get(position)
        EqLitsItemBinding.bind(holder.itemView).apply {
            data.indicator?.let { context?.getColor(it) }
                ?.let { viewIndicator.setBackgroundColor(it) }
            txtMagnitude.text = "Magnitude: " + data.magnitude
            txtPlace.text  = "Place: " + data.place
            itemLayout.setOnClickListener {
                data.id?.let { it1 -> onclick.invoke(it1) }
            }
        }
    }

    override fun getItemCount(): Int {
        return eqdataSumamryList.size
    }

}