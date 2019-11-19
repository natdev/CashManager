package com.example.cash_manager_front

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_cash.*


class CashActivity : AppCompatActivity(),Communicator {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cash)
        val tableLayout_view = findViewById<TabLayout>(R.id.tabLayout);
        val fragmentAdapter = PageAdapter(supportFragmentManager)
        val tabLayout_icons = intArrayOf(R.drawable.shop, R.drawable.shopping_cart, R.drawable.logo_euro)
        viewpager_id.adapter = fragmentAdapter
        tabLayout.setupWithViewPager(viewpager_id)

        for ( i in tabLayout_icons.indices) {
            tableLayout_view.getTabAt(i)?.setIcon(tabLayout_icons[i]);
        }
    }
    override fun passDataCom(datafinal : ArrayList<Parcelable>) {
        val bundle = Bundle()
        bundle.putParcelableArrayList("datafinal",datafinal)
        Log.i("CashActivity","$datafinal")
        val transaction = this.supportFragmentManager.beginTransaction()
        val CartFragment = CartFragment()
        CartFragment.arguments = bundle

        transaction.replace(R.id.fragment_cart, CartFragment)
        transaction.addToBackStack(null)
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        transaction.commit()

    }
}
