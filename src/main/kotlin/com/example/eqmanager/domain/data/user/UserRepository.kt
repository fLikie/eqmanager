package com.example.eqmanager.domain.data.user

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import java.sql.SQLException
import javax.sql.DataSource

class UserRepository {

    @Value("\${spring.datasource.url}")
    private val dbUrl: String? = null

    @Autowired
    val dataSource: DataSource? = null

    @Throws(SQLException::class)
    fun dataSource() {
        if (dbUrl == null || dbUrl.isEmpty()) {
            HikariDataSource()
        } else {
            val config = HikariConfig()
            config.jdbcUrl = dbUrl
            HikariDataSource(config)
        }
    }

    fun save(phone: String): String {
        return try {
            dataSource!!.connection.use {
                it.createStatement()
                    .executeUpdate("INSERT INTO eqmanager.user_tbl(phone) VALUES ($phone)")
            }
            "ok"
        } catch (e: Exception) {
            e.stackTraceToString()
        }
    }

    fun findAllUsers(): List<User> {
        return try {
            dataSource!!.connection.use {
                val result = it.createStatement()
                    .executeQuery("SELECT * FROM eqmanager.user_tbl")
                val users = mutableListOf<User>()
                while (result.next()) {
                    users.add(User(result.getString(2)))
                }
                users
            }
        } catch (e: Exception) {
            emptyList()
        }
    }

    fun findUser() {

    }
}