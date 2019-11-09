package com.example.cash_manager_front

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btn_change_activity =  findViewById<Button>(R.id.new_activity);
    btn_change_activity.setOnClickListener{
        val intent =Intent(this, CashActivity::class.java)
        startActivity(intent)
    }
    }


}
