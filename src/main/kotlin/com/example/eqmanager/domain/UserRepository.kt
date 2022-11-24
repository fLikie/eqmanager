package com.example.eqmanager.domain

import com.example.eqmanager.domain.data.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CrudRepository<User, String> {
}