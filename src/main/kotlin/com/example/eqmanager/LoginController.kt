package com.example.eqmanager

import com.example.eqmanager.domain.data.Code
import com.example.eqmanager.domain.data.Response
import com.example.eqmanager.domain.data.user.User
import com.example.eqmanager.domain.data.user.UserService
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import java.sql.SQLException
import javax.sql.DataSource


@Controller
class LoginController(
    val userService: UserService
) {

    @PostMapping("/login")
    fun login(phone: String): ResponseEntity<Response> {
        return if (userService.isUserExistsByPhone(phone)) {
            ResponseEntity.ok(Response("ok"))
        } else {
            ResponseEntity.ok(Response("not found"))
        }
    }

    @PostMapping("/register")
    fun register(@RequestBody user: User): ResponseEntity<Response> {
        val isUserCreationSuccess = userService.createUser(user)
        return if (isUserCreationSuccess == "ok") {
            ResponseEntity.ok(Response("ok"))
        } else {
            ResponseEntity.ok(Response(isUserCreationSuccess))
        }
    }

    @PostMapping("/authcode")
    fun checkAuthCode(@RequestBody code: Code): ResponseEntity<Response> {
        return if (code.code == "2077") {
            ResponseEntity.ok(Response("ok"))
        } else {
            ResponseEntity.ok(Response("wrong code"))
        }
    }

    @GetMapping("/getusers")
    fun getUsers(): ResponseEntity<List<User>> {
        val users = userService.getUsers()
        return ResponseEntity.ok(users)
    }
}