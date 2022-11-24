package com.example.eqmanager

import com.example.eqmanager.domain.data.Response
import com.example.eqmanager.domain.data.markers.Marker
import com.example.eqmanager.domain.data.markers.MarkerRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

@Controller
class MarkerController {

    val markerRepository: MarkerRepository = MarkerRepository()

    @GetMapping("/getmarkers")
    fun getMarkers(): List<Marker> {
        return markerRepository.getMarkers()
    }

    @PostMapping("/addmarker")
    fun addMarker(marker: Marker): ResponseEntity<Response> {
        return ResponseEntity.ok(Response(markerRepository.saveMarker(marker)))
    }
}