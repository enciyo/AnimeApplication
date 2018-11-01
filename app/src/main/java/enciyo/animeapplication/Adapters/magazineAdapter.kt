package enciyo.animeapplication.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import enciyo.animeapplication.Pojo.TrendRepo
import enciyo.animeapplication.R
import kotlinx.android.synthetic.main.item_magazine.view.*

class magazineAdapter(val context: Context,val list: List<TrendRepo.Magazine>) :
    RecyclerView.Adapter<magazineAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view= LayoutInflater.from(context).inflate(R.layout.item_magazine,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
       return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data=list[position]
        holder.getData(data)
    }


    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun getData(result:TrendRepo.Magazine) {

            itemView.apply {
                magazineTitle.text = result.title
                magazineType_Members.text = result.mtype + "\t" + result.member.toString() +" members"
                magazineAring.text =result.airing_start
                magazineSynopsis.text = result.synopsis
            }
            Picasso.get().load(result.imageUrl).into(itemView.magazineImage)

        }
    }
}