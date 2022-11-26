package com.example.eqmanager

import com.example.eqmanager.domain.data.Response
import com.example.eqmanager.domain.data.markers.Marker
import com.example.eqmanager.domain.data.markers.MarkerService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@Controller
class MarkerController(
    val markerService: MarkerService
) {

    @GetMapping("/getmarkers")
    fun getMarkers(): ResponseEntity<List<Marker>> {
        return try {
            ResponseEntity.ok(markerService.getMarkers())
        } catch (e: Exception) {
            ResponseEntity.ok(listOf())
        }
    }

    @PostMapping("/addmarker")
    fun addMarker(@RequestBody marker: Marker): ResponseEntity<Response> {
        return ResponseEntity.ok(Response(markerService.saveMarker(marker)))
    }
}