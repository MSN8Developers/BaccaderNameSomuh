package com.example.baccadernamesomuh

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

@Suppress("DEPRECATION")
class ShowPageAdapter(
    private val myContext: Context,
    fm: FragmentManager,
    private var totalTabs: Int
) : FragmentPagerAdapter(fm){

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                //  val homeFragment: HomeFragment = HomeFragment()

                GirlsNameFragment()
            }
            1 -> {
                BoysNameFragment()
            }
            else -> null!!
        }
    }

    // this counts total number of tabs
    override fun getCount(): Int {
        return totalTabs
    }
}