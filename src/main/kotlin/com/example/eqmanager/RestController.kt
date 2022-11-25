package com.example.eqmanager

import com.example.eqmanager.domain.data.Response
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import java.sql.ResultSet
import java.sql.SQLException
import java.sql.Statement
import javax.sql.DataSource


@Controller
class RestController() {

    @GetMapping("/ping")
    fun ping(): ResponseEntity<String> {
        return ResponseEntity.ok("pong")
    }

    @RequestMapping("/db")
    fun db(model: MutableMap<String?, Any?>): ResponseEntity<Response> {
        try {
            dataSource?.connection.use { connection ->
                val stmt: Statement? = connection?.createStatement()
                stmt?.executeUpdate("INSERT INTO eqmanager.user_tbl(phone) VALUES (321)")
                val rs: ResultSet? = stmt?.executeQuery("SELECT * FROM eqmanager.user_tbl")
                val output = ArrayList<String>()
                while (rs?.next() == true) {
                    output.add("Read from DB: " + rs.getString(2))
                }
                model["records"] = output
                return ResponseEntity.ok(Response(output.toString()))
            }
        } catch (e: Exception) {
            model["message"] = e.message
            return ResponseEntity.ok(Response(e.stackTraceToString()))
        }
    }

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