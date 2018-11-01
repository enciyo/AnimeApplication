package enciyo.animeapplication.Fragments


import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.*
import enciyo.animeapplication.R
import enciyo.animeapplication.Adapters.ViewPager
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {

    var mViewPager: ViewPager? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        ((activity as AppCompatActivity)).setSupportActionBar(toolbar)
        return view!!
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mViewPager= ViewPager(childFragmentManager)
        mViewPager!!.addFragment(TrendFragment(),"Trend")
        mViewPager!!.addFragment(MagazineFragment(),"Magazine")
        viewPager.adapter = mViewPager
        tabLayout.setupWithViewPager(viewPager)
        toolbar.inflateMenu(R.menu.toolbar_menu)
        setHasOptionsMenu(true)

        toolbar.setOnMenuItemClickListener {
           when(it.itemId){
               R.id.toolbarSearch -> { Snackbar.make(toolbar,"Succes",Snackbar.LENGTH_SHORT).show()
                   true}
               else -> {
                   true
               }

           }

        }




    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater!!.inflate(R.menu.toolbar_menu,menu)
        Log.i("Toolbar","onCreated")
    }
}
