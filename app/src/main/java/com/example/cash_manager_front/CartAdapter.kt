package com.example.cash_manager_front

import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CartAdapter(var finaldata:ArrayList<Article>,val ClickListener: View.OnClickListener)
    : RecyclerView.Adapter<CartAdapter.ViewHolder> () {

    fun removeItem(position: Int) {
        finaldata.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, finaldata.size)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val Article=itemView.findViewById(R.id.NameArticle2) as TextView
        val button = itemView.findViewById(R.id.RemoveCart) as TextView
        val nameTextView = itemView.findViewById(R.id.Price2) as TextView
        val quantity = itemView.findViewById(R.id.quantity) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewItem = LayoutInflater.from(parent.context)
            .inflate(R.layout.article2, parent, false)
        return ViewHolder(viewItem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article = finaldata[position].name
        var price = finaldata[position].price
        val quantity = finaldata[position].quantity
        holder.Article.text=article
        holder.nameTextView.text=price.toString()
        holder.quantity.text= quantity.toString()
        holder.button.tag=position
        holder.button.setOnClickListener(ClickListener)

    }


    override fun getItemCount(): Int {
        return finaldata.size
    }

}
