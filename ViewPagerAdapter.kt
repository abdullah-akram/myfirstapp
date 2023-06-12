package com.example.myfirstapplication

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter(fm:FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount(): Int {
        return 2;
    }



    override fun getItem(position: Int): Fragment {
        when(position) {
            0 -> {
                return Fragment2()
            }
            1 -> {
                return Fragment3()
            }

            else -> {
                return Fragment2()
            }
        }

    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position) {
            0 -> {
                return "Tab 1"
            }
            1 -> {
                return "Tab 2"
            }

        }
        return super.getPageTitle(position)
    }

}