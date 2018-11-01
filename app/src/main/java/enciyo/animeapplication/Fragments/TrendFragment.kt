package enciyo.animeapplication.Fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import enciyo.animeapplication.Adapters.trendAdapter
import enciyo.animeapplication.Pojo.TrendRepo
import enciyo.animeapplication.R
import enciyo.animeapplication.Retrofit.ApiClient
import enciyo.animeapplication.Retrofit.myInterface
import kotlinx.android.synthetic.main.fragment_trend.*
import retrofit2.Call
import retrofit2.Callback

class TrendFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_trend,container,false)
        return view!!
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val retrofit = ApiClient.getClient()
        val mInterface = retrofit.create(myInterface::class.java)

        val call = mInterface.getTrend()

        call.enqueue(object: Callback<TrendRepo> {

            override fun onFailure(call: Call<TrendRepo>, t: Throwable) {
                print("myTogger"+t.message)
            }

            override fun onResponse(call: Call<TrendRepo>, response: retrofit2.Response<TrendRepo>) {
                Log.i("myResponse", response.body()!!.top!![0].malId.toString())
                val result = response.body()!!.top!!
                val adapter = trendAdapter(context!!, result)
                val layoutManager= LinearLayoutManager(context!!)
                layoutManager.orientation= LinearLayout.VERTICAL
                recyclerView.layoutManager=layoutManager
                recyclerView.adapter = adapter

            }
        })
    }

}