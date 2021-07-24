package com.example.cleanarchitecture.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.cleanarchitecture.BR
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.base.BaseFragment
import com.example.cleanarchitecture.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    override val bindingVariable: Int
        get() = BR.viewModel

    override val viewModel: HomeViewModel by viewModels { viewModelFactory }

    override val layoutId: Int = R.layout.fragment_home

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.supportFragmentManager?.let {
            val adapter = ViewPagerAdapter(requireContext(), childFragmentManager)
            viewDataBinding.apply {
                viewPager.adapter = adapter
                tabLayout.setupWithViewPager(viewDataBinding.viewPager)
            }
            adapter.notifyDataSetChanged()
        }

    }

}