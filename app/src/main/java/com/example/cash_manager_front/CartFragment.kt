package com.example.cash_manager_front

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.article2.*
import kotlinx.android.synthetic.main.fragment_cart.*
import java.util.zip.Inflater


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [CartFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [CartFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CartFragment : Fragment(), View.OnClickListener{
    var datafinal : ArrayList<Parcelable>? = arrayListOf()
    lateinit var adapter: CartAdapter
    lateinit var comm: Communicator
   // var price : String?=""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        datafinal = arguments?.getParcelableArrayList("datafinal")
        if (datafinal !=null) {
            var datafinal :ArrayList<Parcelable> = datafinal as ArrayList<Parcelable>
            for (data in datafinal) {
                Log.i("CartFragment", data.toString())
            }
            if (datafinal !=null) {
                var datafinal :ArrayList<Article> = datafinal as ArrayList<Article>
                var y = 0
                while (y < datafinal.size) {
                    println(datafinal[y].name)
                    println(datafinal[y].price)
                    y++
                }
            }
        }
        val RootView2 =  inflater.inflate(R.layout.fragment_cart, container, false)
        if (datafinal !=null) {
            var datafinal :ArrayList<Article> = datafinal as ArrayList<Article>
            adapter=CartAdapter(datafinal,this)
            val recyclerView2= RootView2.findViewById(R.id.articles2_recycler_view) as RecyclerView
            recyclerView2.layoutManager= LinearLayoutManager(activity)
            recyclerView2.adapter = adapter
            priceTotal(datafinal)
            var totalCart=RootView2.findViewById<TextView>(R.id.total)
            totalCart.setText(total.toString()).toString()
        }
        return RootView2

    }
    override fun onClick(button: View?) {
        if (button != null) {
            val datafinal: ArrayList<Article> = datafinal as ArrayList<Article>
            if (button.tag != null) {
                val index = button.tag as Int
                var article = Article(
                    datafinal[index].name,
                    datafinal[index].price,
                    datafinal[index].quantity
                )
                removeTalble(article,index)
            }
        }
    }
    fun removeTalble(article: Article,position:Int)  {
        val datafinal: ArrayList<Article> = datafinal as ArrayList<Article>
        for (data in datafinal) {
            if (data.name == article.name) {
                data.quantity = data.quantity - 1
                Log.i("remove",data.quantity.toString())
                val datafinal: ArrayList<Parcelable> = datafinal as ArrayList<Parcelable>
                comm = activity as Communicator
                comm.passDataCom(datafinal)
                adapter.notifyDataSetChanged()
            }
            }
        if (article.quantity == 1) {
            adapter.removeItem(position)
        }
        priceTotal(datafinal)
    }
    var total = 0


    fun priceTotal(datafinal:ArrayList<Article>) {
        total=0
        for (data in datafinal) {
            total += (data.price * data.quantity)
        }
            Log.i("panier","$total")
    }
    companion object {
        fun newInstance(): CartFragment {
            return CartFragment()
        }
    }

}




