package com.example.cleanarchitecture.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.cleanarchitecture.BR
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.base.BaseFragment
import com.example.cleanarchitecture.databinding.FragmentHomeBinding
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    override val bindingVariable: Int
        get() = BR.viewModel

    override val viewModel: HomeViewModel by viewModels { viewModelFactory }

    override val layoutId: Int = R.layout.fragment_home

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = ViewPagerAdapter(this)
        viewDataBinding.viewPager.adapter = adapter
        with(viewDataBinding) {
            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                if (position == 1) tab.text = getString(R.string.title_newsfeed)
                else tab.text = getString(R.string.title_tech)
            }.attach()
        }

    }

}