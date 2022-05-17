package com.example.tablayoutviewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter(fm:FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 2;
    }

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> {
                Fragment1()
            }
            1 -> {
                Fragment2()
            }
            else -> {
                Fragment1()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position) {
            0 -> {
                return "Login Tab"
            }
            1 -> {
                return "User Details"
            }

        }
        return super.getPageTitle(position)
    }

}
