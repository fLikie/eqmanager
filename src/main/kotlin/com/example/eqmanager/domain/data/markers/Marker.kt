package com.example.eqmanager.domain.data.markers

import com.fasterxml.jackson.annotation.JsonProperty

data class Marker(
    @JsonProperty("x_Coordinate")
    val X_Coordinate: String? = "",
    @JsonProperty("y_Coordinate")
    val Y_Coordinate: String? = "",
    @JsonProperty("comments")
    val comments: String? = "",
    @JsonProperty("plusCount")
    val plusCount: Int? = 0,
    @JsonProperty("minusCount")
    val minusCount: Int? = 0,
    @JsonProperty("approved")
    val approved: Boolean? = false
)