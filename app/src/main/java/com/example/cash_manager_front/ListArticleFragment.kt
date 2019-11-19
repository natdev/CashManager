package com.example.cash_manager_front

import android.content.Context
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

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
    var prices = arrayOf<Int>(20, 5, 450)
   // var  gantDeBoxe= Article("Gant de Boxe","20€",)
    var datafinal= arrayListOf<Parcelable>()

    lateinit var comm: Communicator



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
                val price = prices[index]
                var article = Article(articles[index],prices[index],1)
                addTalble(article)
                comm = activity as Communicator
                comm.passDataCom(datafinal)
                val datafinal :ArrayList<Article> = datafinal as ArrayList<Article>
                Log.i("articlecheck",datafinal[0].quantity.toString())
                Toast.makeText(activity,"le numéro du boutton est  ${datafinal[0].quantity}",Toast.LENGTH_SHORT).show()

            }
        }
        else  Toast.makeText(activity,"tag est nul",Toast.LENGTH_SHORT).show()
        }

      fun addTalble(article: Article){
        var quantityAdd = false
        val datafinal :ArrayList<Article> = datafinal as ArrayList<Article>
        for (data in datafinal){
            if ( data.name == article.name) {
                data.quantity = data.quantity + 1
                Log.i("article",data.quantity.toString())
                quantityAdd = true
            }
        }
          if (quantityAdd==false)
              datafinal.add(article)
    }


    companion object {
        lateinit var mctx:Context
        fun newInstance(): ListArticleFragment = ListArticleFragment()
    }

}
