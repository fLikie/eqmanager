package com.example.eqmanager

import com.example.eqmanager.domain.UserRepository
import com.example.eqmanager.domain.data.UserService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
class LoginController(
    val userService: UserService
) {

    @PostMapping("/login")
    fun login(@RequestBody phone: String): ResponseEntity.HeadersBuilder<*> {
        return if (userService.isUserExistsByPhone(phone)) {
            ResponseEntity.ok()
        } else {
            ResponseEntity.notFound()
        }
    }

    @PostMapping("/register")
    fun register(phone: String): ResponseEntity.BodyBuilder {
        val isUserCreationSuccess = userService.createUser(phone = phone)
        return if (isUserCreationSuccess) {
            ResponseEntity.ok()
        } else {
            ResponseEntity.status(503)
        }
    }

    @PostMapping("/authcode")
    fun checkAuthCode(@RequestBody code: String): ResponseEntity.BodyBuilder {
        return if (code == "2077") {
            ResponseEntity.ok()
        } else {
            ResponseEntity.status(400)
        }
    }
}