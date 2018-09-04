package com.example.lefter.tobedeleted

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UsersAdapter(val context: Context, var userItems: ArrayList<UserModel>) : RecyclerView.Adapter<UsersAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_model_item, parent, false)
        val viewHolder = MyViewHolder(itemView)

        return viewHolder
    }

    override fun getItemCount(): Int {
        return userItems.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val userModel: UserModel = userItems[position]
        holder.tvUserId.text = userModel.id.toString()
        holder.tvUserEmail.text = userModel.email
        holder.tvUserName.text = userModel.name
        holder.tvUserUsername.text = userModel.username
    }
    fun setData(users: ArrayList<UserModel>){

        Log.v("dawemn", users.toString())
        this.userItems = users
        notifyDataSetChanged()
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val tvUserName: TextView = view.findViewById(R.id.tv_name)
        val tvUserId: TextView = view.findViewById(R.id.tv_id)
        val tvUserUsername: TextView = view.findViewById(R.id.tv_username)
        val tvUserEmail: TextView = view.findViewById(R.id.tv_email)

    }
}