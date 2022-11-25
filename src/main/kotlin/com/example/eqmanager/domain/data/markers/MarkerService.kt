package com.example.eqmanager.domain.data.markers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MarkerService() {

    @Autowired
    lateinit var markerRepository: MarkerRepository

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