package com.example.eqmanager

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus

@Controller
class LoginController {

    @PostMapping("/login")
    fun login(): ResponseEntity<String> {
        return ResponseEntity.ok("login")
    }

    @PostMapping("/signup")
    fun signUp(): Result<String> {
        return Result.success("signup")
    }
}