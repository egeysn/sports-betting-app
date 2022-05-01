package com.naylalabs.scorely.adapters

import android.view.LayoutInflater

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sprint.data.entities.MarketsItem
import com.example.sprint.data.entities.OddModel
import com.example.sprint.data.entities.OutcomesItem
import com.example.sprint.databinding.ItemMatchOddChildBinding


class OddsChildAdapter(
    private val bet: MarketsItem,
    private var itemListener: OddsChildAdapter.OddItemListener
) :
    RecyclerView.Adapter<OddsChildAdapter.MyViewHolder>() {


    interface OddItemListener {
        fun onOddItemSelected(oddModel: OutcomesItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemBinding =
            ItemMatchOddChildBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val values = bet.outcomes

        values?.get(position)?.let { holder.bind(it, itemListener) }
    }

    override fun getItemCount(): Int = bet.outcomes?.size!!

    inner class MyViewHolder(val binding: ItemMatchOddChildBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private var itemListener: OddItemListener? = null

        fun bind(outcomesItem: OutcomesItem, itemListener: OddItemListener) {
            this.itemListener = itemListener

            binding.apply {
                parentTv.text = outcomesItem.name
                oddTv.text = outcomesItem.price.toString()

                root.setOnClickListener {
                    itemListener.onOddItemSelected(outcomesItem)
                }
            }


        }


    }

}