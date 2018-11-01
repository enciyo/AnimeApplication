package enciyo.animeapplication.Fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import enciyo.animeapplication.Pojo.TrendRepo
import enciyo.animeapplication.R
import enciyo.animeapplication.Retrofit.ApiClient
import enciyo.animeapplication.ViewPager
import enciyo.animeapplication.myInterface
import enciyo.animeapplication.Adapters.trendAdapter
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_trend.*
import retrofit2.Call
import retrofit2.Callback


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


    }
}
