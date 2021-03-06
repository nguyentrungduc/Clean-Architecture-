package com.example.cleanarchitecture.ui.newsfeed

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.cleanarchitecture.BR
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.base.BaseFragment
import com.example.cleanarchitecture.databinding.FragmentNewsfeedBinding
import com.example.cleanarchitecture.extension.isConnected
import com.example.cleanarchitecture.ui.home.HomeFragmentDirections
import com.example.cleanarchitecture.ui.newsfeed.adapter.NewsFeedAdapter
import com.example.cleanarchitecture.util.autoCleared


class NewsfeedFragment : BaseFragment<FragmentNewsfeedBinding, NewsFeedViewModel>() {

    override val bindingVariable: Int
        get() = BR.viewModel

    override val viewModel: NewsFeedViewModel by viewModels { viewModelFactory }

    override val layoutId: Int = R.layout.fragment_newsfeed

    private var newsFeedAdapter by autoCleared<NewsFeedAdapter>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getNewsFeed(requireContext().isConnected)
        bindViews()
        subscribeUI()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.getNewsFeed(requireContext().isConnected)
        bindViews()
        subscribeUI()
    }

    private fun bindViews() {
        newsFeedAdapter = NewsFeedAdapter {
            findNavController().navigate(HomeFragmentDirections.openDetailFeed())
        }
        with(viewDataBinding) {
            listNewsfeed.addItemDecoration(
                DividerItemDecoration(
                    context,
                    DividerItemDecoration.VERTICAL
                )
            )
            listNewsfeed.adapter = newsFeedAdapter
            pullToRefresh.setOnRefreshListener {
                viewModel.getNewsFeed(requireContext().isConnected)
            }
        }
    }

    private fun subscribeUI() = with(viewModel) {
        loading.observe(viewLifecycleOwner) { loading ->
            viewDataBinding.loading.visibility = if (loading) View.VISIBLE else View.GONE
        }
        newsfeed.observe(viewLifecycleOwner) {
            newsFeedAdapter.submitList(it.listNewsFeedItem)
            viewDataBinding.pullToRefresh.isRefreshing = false
        }
    }
}