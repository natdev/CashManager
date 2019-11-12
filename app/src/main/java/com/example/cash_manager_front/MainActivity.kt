package com.example.cash_manager_front

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btn_change_activity = findViewById<Button>(R.id.new_activity);
        var ipserver = findViewById(R.id.editText3) as TextView
        var password = findViewById(R.id.editText4) as TextView
        btn_change_activity.setOnClickListener {
            var text1 = ipserver.text.toString()
            var text2 = password.text.toString()
            val intent = Intent(this, CashActivity::class.java)
            if (text1 == "nathann" && text2 == "zenou") run {
                startActivity(intent)
            }
        }
    }

}
