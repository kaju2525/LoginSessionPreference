package com.demo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // var sp:SharedPreferences
        val sp = getSharedPreferences("login", Context.MODE_PRIVATE)
        if (sp.contains("username") && sp.contains("password")) {
            startActivity(Intent(this@MainActivity, Welcome::class.java))
            finish()
        }



        setContentView(R.layout.activity_main)


        btn_login.setOnClickListener {

            val names=name.text.toString()
            val passs=pass.text.toString()

            if(names.equals("kk") && passs.equals("nk")){
                val e = sp.edit()
                e.putString("username",names )
                e.putString("password",passs )
                e.apply()

                val intent=Intent(this@MainActivity,Welcome::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
            }
            else
                Toast.makeText(this,"Please try again",Toast.LENGTH_SHORT).show()


            name.text.clear()
            pass.text.clear()
        }

    }
}
