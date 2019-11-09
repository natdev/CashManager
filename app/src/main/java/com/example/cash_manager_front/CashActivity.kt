package com.example.cash_manager_front

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_cash.*


class CashActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cash)

        val fragmentAdapter = PageAdapter(supportFragmentManager)
        viewpager_id.adapter = fragmentAdapter
        tabLayout.setupWithViewPager(viewpager_id)
    }
}
