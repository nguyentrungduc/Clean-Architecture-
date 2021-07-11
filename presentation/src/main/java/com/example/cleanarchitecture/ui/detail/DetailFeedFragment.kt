package com.example.cleanarchitecture.ui.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.example.cleanarchitecture.BR
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.base.BaseFragment
import com.example.cleanarchitecture.databinding.FragmentDetailFeedBinding

class DetailFeedFragment : BaseFragment<FragmentDetailFeedBinding, DetailFeedViewModel>() {

    override val bindingVariable: Int
        get() = BR.viewModel

    override val viewModel: DetailFeedViewModel by viewModels { viewModelFactory }

    override val layoutId: Int = R.layout.fragment_detail_feed

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getDetailFeed()
        subscribeUI()
    }

    private fun subscribeUI() = with(viewModel) {
        detail.observe(viewLifecycleOwner) {
            viewDataBinding.newsFeed = it
        }
    }
}