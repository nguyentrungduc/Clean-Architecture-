package com.example.cleanarchitecture.ui.home

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.cleanarchitecture.ui.newsfeed.NewsfeedFragment
import com.example.cleanarchitecture.ui.tech.TechFragment

class ViewPagerAdapter(private val fragment: Fragment) :
    FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 9

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> TechFragment()
            1 -> NewsfeedFragment()
            else -> TechFragment()
        }
    }

}