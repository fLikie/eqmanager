package com.example.eqmanager.domain.data.user

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class UserService() {

    @Autowired
    lateinit var userRepository: UserRepository

    // Делаем проверку на существование юзера в бд
    fun isUserExistsByPhone(phone: String): Boolean {
        val users = userRepository.findAllUsers()
        for (user in users) {
            if (user.phone == phone) {
                return true
            }
        }
        return false
    }

    fun createUser(phone: String): String {
        try {
            userRepository.save(phone)
        } catch (e: Exception) {
            return e.stackTraceToString()
        }
        return "ok"
    }

    fun getUsers(): List<User> {
        return userRepository.findAllUsers()
    }
}