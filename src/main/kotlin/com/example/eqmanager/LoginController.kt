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
    fun register(phone: String): ResponseEntity<String> {
        val isUserCreationSuccess = userService.createUser(phone = phone)
        return if (isUserCreationSuccess) {
            ResponseEntity.ok("user created")
        } else {
            ResponseEntity.ok("something wron")
        }
    }

    @PostMapping("/authcode")
    fun checkAuthCode(code: String): ResponseEntity<String> {
        return if (code == "2077") {
            ResponseEntity.ok("ok")
        } else {
            ResponseEntity.ok("wrong code")
        }
    }
}