package com.example.cash_manager_front

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ListAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.article.*
import kotlinx.android.synthetic.main.fragment_list_article.*
import kotlinx.android.synthetic.main.fragment_pay_mode.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [ListArticleFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [ListArticleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListArticleFragment : Fragment(),View.OnClickListener {
    var articles = arrayOf<String>("gants de boxe", "chaussettes", "iphone")
    var prices = arrayOf<String>("20", "5", "450")
    var number = Array<Int>(articles.size){0}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        val rootView =  inflater.inflate(R.layout.fragment_list_article, container, false)
        val recyclerView= rootView.findViewById(R.id.articles_recycler_view) as RecyclerView
        recyclerView.layoutManager=LinearLayoutManager(activity)
        recyclerView.adapter =ArticleAdapter(articles,prices,this)
        return rootView
    }

    override fun onClick(button: View?) {
        if (button != null) {
            if (button.tag !=null){
                val index = button.tag as Int
                val article = articles[index]
                number[index]=number[index]+1
                Toast.makeText(activity,"le numéro du boutton est  $article",Toast.LENGTH_SHORT).show()
                Log.i("ListArticleFragment","${number[index].toString()}")
            }
        }
        else  Toast.makeText(activity,"tag est nul",Toast.LENGTH_SHORT).show()
        }


    companion object {
        fun newInstance(): ListArticleFragment = ListArticleFragment()
    }

}