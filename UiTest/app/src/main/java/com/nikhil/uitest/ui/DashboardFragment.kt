package com.nikhil.uitest.ui

import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.nikhil.uitest.adapter.DashboardAdapter
import com.nikhil.uitest.databinding.DashboardFragmentBinding
import com.nikhil.uitest.model.DashboardDataItem
import com.nikhil.uitest.utils.BaseFragment

class DashboardFragment: BaseFragment<DashboardFragmentBinding>() {

    lateinit var dashBoardAdapter: DashboardAdapter

    override fun getViewBinding(): DashboardFragmentBinding = DashboardFragmentBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Gradient Color for Logo
        val textView = binding.tvLogo
        val shader = LinearGradient(
            0f,
            0f,
            0f,
            textView.textSize,
            Color.GREEN,
            Color.BLUE,
            Shader.TileMode.CLAMP
        )
        textView.paint.shader = shader

        //recyclerView
        setUpRecyclerView()

        //add data in Model
        val items = ArrayList<DashboardDataItem>()
        items.add(DashboardDataItem(id = "1",brandName = "Samsung", mode = "sell",amount = "+W9876",time= "8:50 pm", isDate = true, dateOfOrder = "07/06/2021" ))
        items.add(DashboardDataItem(id = "2",brandName = "Asus", mode = "buy",amount = "-W9876",time= "9:58 pm", isDate = false))
        items.add(DashboardDataItem(id = "3",brandName = "Realme", mode = "deposit",amount = "+W9876",time= "6:30 pm", isDate = false))
        items.add(DashboardDataItem(id = "4",brandName = "Poco", mode = "withdraw",amount = "-W9876",time= "7:20 pm", isDate = false))

        items.add(DashboardDataItem(id = "5",brandName = "Sony", mode = "sell",amount = "+W9876",time= "8:50 pm", isDate = true, dateOfOrder = "06/06/2021" ))
        items.add(DashboardDataItem(id = "6",brandName = "Nvidia", mode = "buy",amount = "-W9876",time= "9:58 pm", isDate = false))
        items.add(DashboardDataItem(id = "7",brandName = "Intel", mode = "deposit",amount = "+W9876",time= "6:30 pm", isDate = false))
        items.add(DashboardDataItem(id = "8",brandName = "Amd", mode = "withdraw",amount = "-W9876",time= "7:20 pm", isDate = false))

        dashBoardAdapter.dataItem = items
    }

    private fun setUpRecyclerView() = binding.recyclerView.apply {
        dashBoardAdapter = DashboardAdapter()
        adapter = dashBoardAdapter
        layoutManager = LinearLayoutManager(context)
    }

}