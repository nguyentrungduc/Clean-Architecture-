package com.example.cleanarchitecture.ui.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.cleanarchitecture.BR
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.base.BaseFragment
import com.example.cleanarchitecture.databinding.FragmentDetailFeedBinding
import com.example.cleanarchitecture.ui.detail.adapter.SectionAdapter
import com.example.cleanarchitecture.util.autoCleared

class DetailFeedFragment : BaseFragment<FragmentDetailFeedBinding, DetailFeedViewModel>() {

    override val bindingVariable: Int
        get() = BR.viewModel

    override val viewModel: DetailFeedViewModel by viewModels { viewModelFactory }

    override val layoutId: Int = R.layout.fragment_detail_feed

    private var sectionAdapter by autoCleared<SectionAdapter>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getDetailFeed()
        bindViews()
        subscribeUI()
    }

    private fun bindViews() {
        sectionAdapter = SectionAdapter()
        with(viewDataBinding) {
            layoutAppbar.imvBack.setOnClickListener {
                findNavController().popBackStack()
            }
            listAnotherNews.adapter = sectionAdapter
            listAnotherNews.addItemDecoration(
                DividerItemDecoration(
                    context,
                    DividerItemDecoration.VERTICAL
                )
            )
        }
    }

    private fun subscribeUI() = with(viewModel) {
        loading.observe(viewLifecycleOwner) { loading ->
            viewDataBinding.loading.visibility = if (loading) View.VISIBLE else View.GONE
        }
        detail.observe(viewLifecycleOwner) {
            viewDataBinding.newsFeed = it
            sectionAdapter.submitList(it.sectionItems)
        }
    }
}