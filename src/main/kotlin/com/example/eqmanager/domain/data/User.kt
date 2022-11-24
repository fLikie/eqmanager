package com.example.eqmanager.domain.data

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("USER_TBL")
data class User(
    @Id val id: String? = null,
    val phone: String,
)