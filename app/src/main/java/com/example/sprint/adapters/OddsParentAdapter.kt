package com.naylalabs.scorely.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sprint.data.entities.MarketsItem
import com.example.sprint.data.locale.MarketType
import com.example.sprint.databinding.ItemMatchOddParentBinding
import com.example.sprint.utils.GeneralUtils


class OddsParentAdapter(
    private val context: Context,
    private val items: ArrayList<MarketsItem>,
    private var itemListener: OddsChildAdapter.OddItemListener,

    ) : RecyclerView.Adapter<OddsParentAdapter.MyViewHolder>() {


    //TODO burada inject edilmiyor sorunu çözemedim
    /*  @Inject
       lateinit var generalUtils: GeneralUtils*/

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemBinding =
            ItemMatchOddParentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(items[position], itemListener)
    }

    override fun getItemCount() = items.size


    inner class MyViewHolder(val binding: ItemMatchOddParentBinding) :
        RecyclerView.ViewHolder(binding.root) {


        private var itemListener: OddsChildAdapter.OddItemListener? = null

        fun bind(bet: MarketsItem, itemListener: OddsChildAdapter.OddItemListener) {
            this.itemListener = itemListener

            val position = adapterPosition
            val params = binding.root.layoutParams as RecyclerView.LayoutParams
            if (position == items.lastIndex) {
                params.bottomMargin =
                    GeneralUtils.getInstance(context = context).convertDpToPixel(60,context)
                binding.root.layoutParams = params
            } else {
                params.bottomMargin = 0
                binding.root.layoutParams = params
            }

            binding.childRv.visibility = View.VISIBLE

            var labelTv = ""
            when (bet.key) {
                MarketType.H2H -> labelTv = "Match Winner"
                MarketType.SPREADS -> labelTv = "Handicap"
                MarketType.TOTALS -> labelTv = "Goals Over/Under"
                MarketType.OUTRIGHTS -> labelTv = "Outrights, Futures"
                MarketType.H2H_LAY -> labelTv = "Head to head, Moneyline"
                MarketType.OUTRIGHTS_LAY -> "Outrights, Futures"
                else -> { // Note the block
                }
            }
            binding.labelTv.text = labelTv
            val childLayoutManager =
                LinearLayoutManager(binding.childRv.context, RecyclerView.HORIZONTAL, false)
            binding.childRv.apply {
                layoutManager = childLayoutManager
                //  adapter = OddsChildAdapter(bet.values as ArrayList<Value>)
                adapter = this@MyViewHolder.itemListener?.let { OddsChildAdapter(bet, it) }
            }
        }
    }

}