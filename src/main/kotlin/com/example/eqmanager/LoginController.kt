package com.example.eqmanager

import com.example.eqmanager.domain.data.Response
import com.example.eqmanager.domain.data.user.UserService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*


@Controller
class LoginController(
    val userService: UserService
) {

    @PostMapping("/login")
    fun login(phone: String): ResponseEntity<Response> {
        return if (userService.isUserExistsByPhone(phone)) {
            ResponseEntity.ok(Response("exists"))
        } else {
            ResponseEntity.ok(Response("not found"))
        }
    }

    @PostMapping("/register")
    fun register(phone: String): ResponseEntity<Response> {
        val isUserCreationSuccess = userService.createUser(phone = phone)
        return if (isUserCreationSuccess == "ok") {
            ResponseEntity.ok(Response("ok"))
        } else {
            ResponseEntity.ok(Response(isUserCreationSuccess))
        }
    }

    @PostMapping("/authcode")
    fun checkAuthCode(code: String): ResponseEntity<Response> {
        return if (code == "2077") {
            ResponseEntity.ok(Response("ok"))
        } else {
            ResponseEntity.ok(Response("wrong code"))
        }
    }
}