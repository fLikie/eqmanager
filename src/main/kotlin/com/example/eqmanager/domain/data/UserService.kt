package com.example.eqmanager.domain.data

import com.example.eqmanager.domain.UserRepository
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Service
import java.sql.SQLException
import javax.sql.DataSource


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
            userRepository.save(User(phone = phone))
        } catch (e: Exception) {
            return false
        }
        return true
    }
}