package com.example.eqmanager.domain.data

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.springframework.beans.factory.annotation.Value
import java.sql.SQLException
import javax.sql.DataSource

class DataSourceEnv {

    companion object {

        @Value("\${spring.datasource.url}")
        private val dbUrl: String? = null

        @Throws(SQLException::class)
        fun dataSource(): DataSource {
            return if (dbUrl == null || dbUrl.isEmpty()) {
                HikariDataSource()
            } else {
                val config = HikariConfig()
                config.jdbcUrl = dbUrl
                HikariDataSource(config)
            }
        }
    }
}