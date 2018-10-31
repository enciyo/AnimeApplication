package enciyo.animeapplication

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter


class ViewPager(fragmentManager: FragmentManager) :FragmentStatePagerAdapter(fragmentManager) {

    val mFragmentList:ArrayList<Fragment>? = ArrayList()
    val mFragmentTitle: ArrayList<String>? = ArrayList()


    fun addFragment(fragment:Fragment,title:String) {
        mFragmentList!!.add(fragment)
        mFragmentTitle!!.add(title)
    }

    override fun getItem(position: Int): Fragment {
        return mFragmentList!![position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mFragmentTitle!![position]
    }

    override fun getCount(): Int {
       return mFragmentList!!.size
    }



}