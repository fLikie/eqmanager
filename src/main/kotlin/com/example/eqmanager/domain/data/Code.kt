package com.example.eqmanager.domain.data

import com.fasterxml.jackson.annotation.JsonProperty

data class Code(
    @JsonProperty("code")
    val code: String
)