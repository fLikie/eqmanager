package com.example.eqmanager.domain.data.markers

data class Marker(
    val X_Coordinate: String? = "",
    val Y_Coordinate: String? = "",
    val comments: String? = "",
    val plusCount: Int? = 0,
    val minusCount: Int? = 0,
    val approved: Boolean? = false
)