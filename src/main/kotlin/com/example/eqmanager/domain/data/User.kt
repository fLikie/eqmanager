package com.example.eqmanager.domain.data

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("EQMANAGER.USER_TBL")
data class User(
    val phone: String,
)