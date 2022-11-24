package com.example.eqmanager.domain.data.markers

import com.example.eqmanager.domain.data.user.User
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.springframework.beans.factory.annotation.Value
import java.sql.SQLException
import javax.sql.DataSource

class MarkerRepository {

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

    fun getMarkers(): List<Marker> {
        return try {
            dataSource().connection.use {
                val result = it.createStatement()
                    .executeQuery("SELECT * FROM eqmanager.markers")
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
            emptyList()
        }
    }

    fun saveMarker(marker: Marker): String {
        return try {
            dataSource().connection.use {
                it.createStatement()
                    .executeUpdate(
                        "INSERT INTO eqmanager.markers(X_Coordinate, Y_Coordinate, comments, plusCount, minusCount, approved) " +
                                "VALUES ('${marker.X_Coordinate}', '${marker.Y_Coordinate}', '${marker.comments}', ${marker.plusCount}, ${marker.minusCount}', ${marker.approved})")
            }
            "ok"
        } catch (e: Exception) {
            e.stackTraceToString()
        }
    }
}