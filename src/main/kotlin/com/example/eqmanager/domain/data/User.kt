package com.example.eqmanager.domain.data

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import javax.xml.validation.Schema

@Table(schema = "EQMANAGER", name = "USER_TBL")
data class User(
    val phone: String,
)