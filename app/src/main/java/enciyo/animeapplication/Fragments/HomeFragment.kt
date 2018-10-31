package enciyo.animeapplication.Fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import enciyo.animeapplication.Pojo.TrendRepo
import enciyo.animeapplication.R
import enciyo.animeapplication.Retrofit.ApiClient
import enciyo.animeapplication.ViewPager
import enciyo.animeapplication.myInterface
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_trend.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException


class HomeFragment : Fragment() {

    var mViewPager: ViewPager? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        return view!!
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mViewPager= ViewPager(childFragmentManager)
        mViewPager!!.addFragment(TrendFragment(),"Trend")
        mViewPager!!.addFragment(MagazineFragment(),"Magazine")
        viewPager.adapter = mViewPager
        tabLayout.setupWithViewPager(viewPager)
        val retrofit = ApiClient.getClient()
        val mInterface = retrofit.create(myInterface::class.java)

        val call = mInterface.getTrend()

        call.enqueue(object: Callback<TrendRepo>{

            override fun onFailure(call: Call<TrendRepo>, t: Throwable) {
                        print(t.message)
            }

            override fun onResponse(call: Call<TrendRepo>, response: retrofit2.Response<TrendRepo>) {
                Log.i("myResponse", response.body()!!.top!![0].malId.toString())
                val result = response.body()!!.top!![0]
                trendtext.text= result.title + "\n" + result.imageUrl + "\n" + result.rank.toString() +
                        "\n" + result.url
            }
        })






    }
}
