package com.example.eqmanager.domain.data.markers

import com.example.eqmanager.domain.data.markers.Marker
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import java.sql.SQLException
import javax.sql.DataSource

@Controller
class MarkerRepository {

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

    fun getMarkers(): List<Marker> {
        return try {
            dataSource!!.connection.use {
                val stmt = it.createStatement()
                val result = stmt.executeQuery("SELECT * FROM eqmanager.markers")
                val markers = mutableListOf<Marker>()
                while (result.next()) {
                    val tempMarker = Marker(
                        X_Coordinate = result.getString(2),
                        Y_Coordinate = result.getString(3),
                        comments = result.getString("comments"),
                        approved = result.getBoolean("approved"),
                        plusCount = result.getInt("plusCount"),
                        minusCount = result.getInt("minusCount")
                    )
                    markers.add(tempMarker)
                }
                markers
            }
        } catch (e: Exception) {
            throw e
        }
    }

    fun saveMarker(marker: Marker): String {
        return try {
            dataSource!!.connection.use {
                val stmt = it.createStatement()
                stmt.executeUpdate(
                        "INSERT INTO eqmanager.markers(x_coordinate, y_coordinate, comments, plusCount, minusCount, approved) " +
                                "VALUES ('${marker.X_Coordinate}', '${marker.Y_Coordinate}', '${marker.comments}', ${marker.plusCount}, ${marker.minusCount}, ${marker.approved})")
            }
            "ok"
        } catch (e: Exception) {
            e.stackTraceToString()
        }
    }

    fun addComment(marker: Marker): String {
        return try {
            dataSource!!.connection.use {
                val stmt = it.createStatement()
                stmt.executeUpdate(
                    "update eqmanager.markers set comments = '${marker.comments}' where x_coordinate = '${marker.X_Coordinate}'"
                )
                "ok"
            }
        } catch (e: Exception) {
            e.stackTraceToString()
        }
    }
}