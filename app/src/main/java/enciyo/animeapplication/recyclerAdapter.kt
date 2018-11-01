package enciyo.animeapplication

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import enciyo.animeapplication.Pojo.TrendRepo
import kotlinx.android.synthetic.main.item_list.view.*

class recyclerAdapter(val context: Context, val arrayList: List<TrendRepo.Top>) :
    RecyclerView.Adapter<recyclerAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false)
        return MyViewHolder(view!!)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.setData(arrayList[position])
    }


    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setData(result: TrendRepo.Top) {
            itemView.tvTitle.text = result.title.toString()
            itemView.tvTitle.setSingleLine(true)
            itemView.tvRank.text = "Rank: " + result.rank.toString()
            itemView.tvScore.text = "Type: " + result.typer.toString()
            itemView.tvStartDate.text = "Start date: " + result.startDate.toString()
            Picasso.get()
                .load(result.imageUrl.toString())
                .placeholder(R.drawable.loginscreen)
                .into(itemView.imageView)
        }
    }

}