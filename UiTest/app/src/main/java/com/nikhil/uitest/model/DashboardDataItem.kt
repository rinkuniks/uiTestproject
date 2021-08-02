package com.nikhil.uitest.model

data class DashboardDataItem(
    val id: String,
    val brandName: String,
    val mode: String,
    val amount: String,
    val time: String,
    val isDate: Boolean ,
    val dateOfOrder: String? = null
)