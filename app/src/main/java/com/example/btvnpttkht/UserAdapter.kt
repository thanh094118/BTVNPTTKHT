package com.example.btvnpttkht

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.btvnpttkht.R
import com.example.userstate.User
import com.example.userstate.UserState

class UserAdapter(private val users: List<User>) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val avatar: ImageView = itemView.findViewById(R.id.userAvatar)
        val name: TextView = itemView.findViewById(R.id.userName)
        val status: TextView = itemView.findViewById(R.id.userStatus)
        val callButton: Button = itemView.findViewById(R.id.callButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_item, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = users[position]
        holder.avatar.setImageResource(user.avatarResId)
        holder.name.text = user.name

        when (user.state) {
            is UserState.Idle -> {
                holder.status.text = "Idle"
                holder.status.setTextColor(Color.GRAY)
                holder.callButton.text = "Call"
                holder.callButton.isEnabled = true
            }
            is UserState.Calling -> {
                holder.status.text = "Calling..."
                holder.status.setTextColor(Color.BLUE)
                holder.callButton.text = "Calling"
                holder.callButton.isEnabled = false
            }
            is UserState.InCall -> {
                holder.status.text = "In Call"
                holder.status.setTextColor(Color.GREEN)
                holder.callButton.text = "End"
                holder.callButton.isEnabled = true
            }
            is UserState.Busy -> {
                holder.status.text = "Busy"
                holder.status.setTextColor(Color.RED)
                holder.callButton.text = "Unavailable"
                holder.callButton.isEnabled = false
            }
            is UserState.Offline -> {
                holder.status.text = "Offline"
                holder.status.setTextColor(Color.DKGRAY)
                holder.callButton.text = "Offline"
                holder.callButton.isEnabled = false
            }
        }

        holder.callButton.setOnClickListener {
            when (user.state) {
                is UserState.Idle -> {
                    user.state = UserState.Calling
                    notifyItemChanged(position)
                }
                is UserState.InCall -> {
                    user.state = UserState.Idle
                    notifyItemChanged(position)
                }
                else -> {}
            }
        }
    }

    override fun getItemCount(): Int = users.size
}
