package com.example.miniproject.user

data class User(
    val id: String = "",
    val email: String = "",
    val name: String = "",
    val userType: String = "student", // Default user type
    val displayId: String
)