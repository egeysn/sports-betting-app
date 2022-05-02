package com.naylalabs.scorely.adapters

import android.view.LayoutInflater

import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.sprint.R
import com.example.sprint.data.entities.MarketsItem
import com.example.sprint.data.entities.OutcomesItem
import com.example.sprint.databinding.ItemMatchOddChildBinding
import com.example.sprint.utils.OddUtilHelper


class OddsChildAdapter(
    private val bet: MarketsItem,
    private var itemListener: OddsChildAdapter.OddItemListener
) :
    RecyclerView.Adapter<OddsChildAdapter.MyViewHolder>() {

    private var oddUtilHelper: OddUtilHelper = OddUtilHelper.getInstance()

    private var lastSelectedItem: Int = -1

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

                if (bet.key?.let {
                        outcomesItem.betId?.let { it1 ->
                            oddUtilHelper.isHaveSelectedOdd(
                                it,
                                it1
                            )
                        }
                    } == true) {
                    binding.oddsContainer.setCardBackgroundColor(
                        ContextCompat.getColor(
                            binding.root.context,
                            R.color.color_secondary
                        )
                    )
                } else {
                    binding.oddsContainer.setCardBackgroundColor(
                        ContextCompat.getColor(
                            binding.root.context,
                            R.color.odd_background_gray
                        )
                    )
                }


                root.setOnClickListener {



                }
            }


        }


    }

}