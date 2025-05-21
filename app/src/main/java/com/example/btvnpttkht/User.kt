// User.kt
package com.example.userstate

data class User(
    val name: String,
    val avatarResId: Int,
    var state: UserState
)
