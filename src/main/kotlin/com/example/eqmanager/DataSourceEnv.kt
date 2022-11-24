package com.example.eqmanager

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import java.sql.SQLException
import javax.sql.DataSource

class DataSourceEnv {

    companion object {

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
    }
}