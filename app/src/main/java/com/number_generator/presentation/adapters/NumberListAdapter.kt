package com.number_generator.presentation.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.numbergenerator.databinding.ItemNumberBinding
import java.math.BigInteger

class NumberListAdapter : PagingDataAdapter<BigInteger, NumbersViewHolder>(NumbersDiffCallBack()) {

    override fun onBindViewHolder(holder: NumbersViewHolder, position: Int) {
        position.let { pos ->
            getItem(position)?.let {
                holder.bind(it, pos)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumbersViewHolder {
        return NumbersViewHolder(
            ItemNumberBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }
}

class NumbersViewHolder(
    private val binding: ItemNumberBinding
) : RecyclerView.ViewHolder(binding.root) {

    private val backgroundColors = arrayOf(Color.WHITE, Color.GRAY)

    fun bind(number: BigInteger, position: Int) {
        binding.tvNumber.text = number.toString()
        val backgroundColor = backgroundColors[(position / 2 + position % 2) % 2]
        binding.tvNumber.setBackgroundColor(backgroundColor)

    }
}

class NumbersDiffCallBack : DiffUtil.ItemCallback<BigInteger>() {
    override fun areItemsTheSame(oldItem: BigInteger, newItem: BigInteger): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: BigInteger, newItem: BigInteger): Boolean {
        return oldItem == newItem
    }
}
