package com.nikhil.uitest.adapter

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.nikhil.uitest.databinding.RecyclerViewDateLayoutBinding
import com.nikhil.uitest.databinding.RecyclerViewLayoutBinding
import com.nikhil.uitest.model.DashboardDataItem
import com.nikhil.uitest.utils.Constants

class DashboardAdapter() :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val diffCallBack = object : DiffUtil.ItemCallback<DashboardDataItem>() {
        override fun areItemsTheSame(
            oldItem: DashboardDataItem,
            newItem: DashboardDataItem
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: DashboardDataItem,
            newItem: DashboardDataItem
        ): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallBack)
    var dataItem: List<DashboardDataItem>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }

    //ui for dashboard data
    inner class DashboardViewHolder(val binding: RecyclerViewLayoutBinding):RecyclerView.ViewHolder(binding.root)

    //ui for Date
    inner class DashboardDateViewHolder(val binding: RecyclerViewDateLayoutBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when(viewType){
            0 -> {
                return DashboardDateViewHolder(
                    RecyclerViewDateLayoutBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent, false
                    )
                )
            }
            else ->{
                return DashboardViewHolder(
                    RecyclerViewLayoutBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent, false
                    )
                )
            }
        }
    }

    override fun getItemCount(): Int = dataItem.size

    override fun getItemViewType(position: Int): Int {
        return position % 4
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder.itemViewType){
            0 -> {
                val holder: DashboardDateViewHolder = holder as DashboardDateViewHolder
                holder.binding.apply {
                    val data = dataItem[position]
                    tvDate.text = data.dateOfOrder
                }
            }
            else ->{
                val holder: DashboardViewHolder = holder as DashboardViewHolder
                holder.binding.apply {
                    val data = dataItem[position]
                    tvBrandName.text = data.brandName
                    when (data.mode){
                        Constants.SELL ->{
                            tvMode.text = Constants.SELL
                            tvAmount.setTextColor(Color.GREEN)
                        }
                        Constants.BUY -> {
                            tvMode.text = Constants.BUY
                            tvAmount.setTextColor(Color.RED)
                        }
                        Constants.DEPOSIT -> {
                            tvMode.text = Constants.DEPOSIT
                            tvAmount.setTextColor(Color.GREEN)
                        }
                        Constants.WITHDRAW ->{
                            tvMode.text = Constants.WITHDRAW
                            tvAmount.setTextColor(Color.RED)
                        }
                    }
                    tvAmount.text = data.amount
                    tvAmountTime.text = data.time
                }
            }
        }
    }
}