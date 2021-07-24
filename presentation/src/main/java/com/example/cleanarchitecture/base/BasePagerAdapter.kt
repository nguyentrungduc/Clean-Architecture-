package com.example.cleanarchitecture.base

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BasePagerAdapter<T, V : ViewDataBinding> : RecyclerView.Adapter<PagerViewHolder<V>>() {

    protected var items: MutableList<T> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder<V> {
        val binding = createBinding(parent)
        return PagerViewHolder(binding)
    }

    protected abstract fun createBinding(parent: ViewGroup): V

    override fun onBindViewHolder(holder: PagerViewHolder<V>, position: Int) {
        bind(holder.binding, items[position], position)
        holder.binding.executePendingBindings()
    }

    protected abstract fun bind(binding: V, item: T, position: Int)

    override fun getItemCount(): Int {
        return items.size
    }
}

class PagerViewHolder<out T : ViewDataBinding>(val binding: T) : RecyclerView.ViewHolder(binding.root)