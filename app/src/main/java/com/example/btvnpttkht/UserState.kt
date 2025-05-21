// UserState.kt
package com.example.userstate

sealed class UserState {
    object Idle : UserState()
    object Calling : UserState()
    object InCall : UserState()
    object Busy : UserState()
    object Offline : UserState()
}
