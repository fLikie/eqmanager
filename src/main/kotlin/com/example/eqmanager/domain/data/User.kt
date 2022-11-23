package com.example.eqmanager.domain.data

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("USER")
data class User(
    @Id val id: Int?,
    val phone: String,
)