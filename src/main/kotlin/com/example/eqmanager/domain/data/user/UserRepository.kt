package com.example.eqmanager.domain.data.user

import com.example.eqmanager.DataSourceEnv

class UserRepository {

    fun save(user: User): String {
        return try {
            DataSourceEnv.dataSource?.connection.use {
                it?.createStatement()
                    ?.executeUpdate("INSERT INTO eqmanager.user_tbl(phone) VALUES (${user.phone})")
            }
            "ok"
        } catch (e: Exception) {
            e.stackTraceToString()
        }
    }

    fun findAllUsers(): List<User> {
        return try {
            DataSourceEnv.dataSource?.connection.use {
                val result = it?.createStatement()
                    ?.executeQuery("SELECT * FROM eqmanager.user_tbl")
                val users = mutableListOf<User>()
                while (result?.next() == true) {
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