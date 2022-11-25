package com.example.eqmanager.domain.data.markers

import com.example.eqmanager.MarkerRepository
import org.springframework.stereotype.Service

@Service
class MarkerService() {

    val markerRepository = MarkerRepository()

    fun getMarkers(): List<Marker> {
        return try {
            markerRepository.getMarkers()
        } catch (e: Exception) {
            throw e
        }
    }

    fun saveMarker(marker: Marker): String {
        return try {
            markerRepository.saveMarker(marker)
        } catch (e: Exception) {
            e.stackTraceToString()
        }
    }
}