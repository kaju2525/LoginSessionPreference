package com.demo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_come.*

class Welcome : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_come)
        var sp = getSharedPreferences("login", Context.MODE_PRIVATE)

        tv.setText("Welcome : "+ sp.getString("username",null))
        btn_Logout.setOnClickListener {

            val e=sp.edit()
            e.clear()
            e.commit()

            startActivity(Intent(this@Welcome, MainActivity::class.java))
            finish()

        }

    }
}
