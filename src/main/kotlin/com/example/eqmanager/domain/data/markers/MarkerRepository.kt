package com.example.eqmanager.domain.data.markers

import com.example.eqmanager.DataSourceEnv

class MarkerRepository {

    fun getMarkers(): List<Marker> {
        return try {
            print("datasource is ${DataSourceEnv.dataSource}")
            DataSourceEnv.dataSource?.connection.use {
                val result = it?.createStatement()
                    ?.executeQuery("SELECT * FROM eqmanager.markers")
                val markers = mutableListOf<Marker>()
                while (result?.next() == true) {
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
            print("datasource is ${DataSourceEnv.dataSource}")
            DataSourceEnv.dataSource?.connection.use {
                it?.createStatement()
                    ?.executeUpdate(
                        "INSERT INTO eqmanager.markers(x_coordinate, y_coordinate, comments, plusCount, minusCount, approved) " +
                                "VALUES ('${marker.X_Coordinate}', '${marker.Y_Coordinate}', '${marker.comments}', ${marker.plusCount}, ${marker.minusCount}', ${marker.approved})")
            }

            "ok"
        } catch (e: Exception) {
            e.stackTraceToString()
        }
    }
}