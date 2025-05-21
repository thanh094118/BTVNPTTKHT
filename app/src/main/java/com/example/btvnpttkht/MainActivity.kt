// MainActivity.kt
package com.example.btvnpttkht

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.btvnpttkht.R
import com.example.userstate.User
import com.example.btvnpttkht.UserAdapter
import com.example.userstate.UserState

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.userRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val users = listOf(
            User("Bùi Ngọc Thanh 20225399", R.drawable.avatar1, UserState.Idle),
            User("Bùi Ngọc Thanh 20225399", R.drawable.avatar2, UserState.Busy),
            User("Bùi Ngọc Thanh", R.drawable.avatar3, UserState.Offline),
            User("Bùi Ngọc Thanh", R.drawable.avatar4, UserState.Idle),
            User("Bùi Ngọc Thanh", R.drawable.avatar5, UserState.InCall)
        )

        adapter = UserAdapter(users)
        recyclerView.adapter = adapter
    }
}
