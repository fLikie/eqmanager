package com.example.eqmanager.domain.data

import com.example.eqmanager.domain.UserRepository
import org.springframework.stereotype.Service
import kotlin.random.Random

@Service
class UserService(
    private val userRepository: UserRepository
) {

    // Делаем проверку на существование юзера в бд
    fun isUserExistsByPhone(phone: String): Boolean {
        val users = userRepository.findAll()
        for (user in users) {
            if (user.phone == phone) {
                return true
            }
        }
        return false
    }

    fun createUser(phone: String): Boolean {
        try {
            userRepository.save(User(null, phone = phone))
        } catch (e: Exception) {
            return false
        }
        return true
    }
}