package com.example.eqmanager.domain.data.user

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.relational.core.mapping.Table

@Table(schema = "EQMANAGER", name = "USER_TBL")
data class User(
    @JsonProperty("phone")
    val phone: String,
)