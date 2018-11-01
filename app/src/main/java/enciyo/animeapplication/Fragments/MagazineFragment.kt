package enciyo.animeapplication.Fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import enciyo.animeapplication.Adapters.magazineAdapter
import enciyo.animeapplication.Pojo.TrendRepo
import enciyo.animeapplication.R
import enciyo.animeapplication.Retrofit.ApiClient
import enciyo.animeapplication.Retrofit.myInterface
import kotlinx.android.synthetic.main.fragment_magazine.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MagazineFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_magazine,container,false)
        return view!!
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val retrofit = ApiClient.getClient()
        val mInterface = retrofit.create(myInterface::class.java)

        val call = mInterface.getMagazine()

       call.enqueue(object : Callback<TrendRepo>{
           override fun onFailure(call: Call<TrendRepo>, t: Throwable) {
               print("myTogger"+t.message)

           }

           override fun onResponse(call: Call<TrendRepo>, response: Response<TrendRepo>) {
               val result = response.body()!!.anime
               val adapter= magazineAdapter(context!!,result!!)
               val layoutManager= LinearLayoutManager(context!!)
               layoutManager.orientation= LinearLayoutManager.VERTICAL
               rcyclerMagazine.layoutManager=layoutManager
               rcyclerMagazine.adapter=adapter
           }

       })

    }

}