package com.example.cash_manager_front


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ArticleAdapter(val articles :Array<String>, val prices:Array<String>,val itemClickListener: View.OnClickListener)
    : RecyclerView.Adapter<ArticleAdapter.ViewHolder> () {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            val Article=itemView.findViewById(R.id.NameArticle) as TextView
            val button = itemView.findViewById(R.id.AddCart) as TextView
            val nameTextView = itemView.findViewById(R.id.Price) as TextView


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewItem = LayoutInflater.from(parent.context)
                .inflate(R.layout.article, parent, false)
        return ViewHolder(viewItem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article = articles[position]
        val price = prices[position]
        holder.Article.text=article
        holder.nameTextView.text=price
        holder.button.tag=position
        holder.button.setOnClickListener(itemClickListener)

    }

    override fun getItemCount(): Int {
        return articles.size
    }

}
