package com.example.cleanarchitecture.ui.home

import android.content.Context
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.ui.newsfeed.NewsfeedFragment
import com.example.cleanarchitecture.ui.tech.TechFragment

class ViewPagerAdapter(
    val context: Context,
    fm: FragmentManager
) : FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    var currentFragment: Fragment? = null

    override fun getItem(position: Int): Fragment {
        return if (position == 1) NewsfeedFragment()
        else TechFragment()
    }

    override fun getCount() = 9

    override fun getPageTitle(position: Int): String {
        return if (position == 1) context.getString(R.string.title_newsfeed)
        else context.getString(R.string.title_tech)
    }

    override fun setPrimaryItem(container: ViewGroup, position: Int, `object`: Any) {
        if (currentFragment != `object`) {
            currentFragment = `object` as Fragment
        }
        super.setPrimaryItem(container, position, `object`)
    }

}
