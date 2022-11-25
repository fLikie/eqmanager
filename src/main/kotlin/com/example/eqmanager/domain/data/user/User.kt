package com.example.eqmanager.domain.data.user

import org.springframework.data.relational.core.mapping.Table

@Table(schema = "EQMANAGER", name = "USER_TBL")
data class User(
    val phone: String,
)