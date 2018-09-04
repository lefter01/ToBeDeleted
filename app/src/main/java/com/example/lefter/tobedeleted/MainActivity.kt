package com.example.lefter.tobedeleted

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val userViewModel: UserViewModel = UserViewModel()
    lateinit var usersAdapter: UsersAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    override fun onStart() {
        super.onStart()
        userViewModel.downloadUsers()

        rv_users.apply {

            usersAdapter = UsersAdapter(context = applicationContext, userItems = ArrayList())
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = usersAdapter

        }
        registerDownloadListener()

    }

    fun registerDownloadListener() {
        userViewModel.userItems.observe(this, Observer {
            usersAdapter.setData(it!!)
            usersAdapter.notifyDataSetChanged()

        })

    }
}
