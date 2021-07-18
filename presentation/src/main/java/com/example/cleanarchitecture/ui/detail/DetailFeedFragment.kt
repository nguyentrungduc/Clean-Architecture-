package com.example.cleanarchitecture.ui.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
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
        bindViews()
        subscribeUI()
    }

    private fun bindViews() {
        with(viewDataBinding) {
            imvBack.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }

    private fun subscribeUI() = with(viewModel) {
        loading.observe(viewLifecycleOwner) { loading ->
            viewDataBinding.loading.visibility = if (loading) View.VISIBLE else View.GONE
        }
        detail.observe(viewLifecycleOwner) {
            viewDataBinding.newsFeed = it
        }
    }
}