package com.example.sprint.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.example.sprint.data.entities.SelectedMatchOdd
import com.example.sprint.data.locale.MarketType
import com.example.sprint.databinding.CouponMatchItemBinding
import com.example.sprint.utils.Constants
import com.example.sprint.utils.toDetailCardDate


class CouponsChildAdapter(val context: Context, private val items: ArrayList<SelectedMatchOdd>
) : ListAdapter<SelectedMatchOdd,CouponsChildAdapter.CouponsChildViewHolder>(REPO_COMPARATOR) {


    @SuppressLint("NotifyDataSetChanged")
    fun setItems(items: ArrayList<SelectedMatchOdd>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CouponsChildViewHolder {
        val itemBinding =
            com.example.sprint.databinding.CouponMatchItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return CouponsChildViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: CouponsChildViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    inner class CouponsChildViewHolder( val binding: CouponMatchItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: SelectedMatchOdd) {

            binding.apply {
                homeClubTv.text = item.homeTeam
                awayClubTv.text = item.awayTeam
                oddTv.text = item.outCome?.price.toString()
                priceTv.text = item.outCome?.name.toString()

                dateTv.text = item.commenceTime?.toDetailCardDate().toString()

                var labelTv = ""
                when (item.marketsItem?.key) {
                    MarketType.H2H -> labelTv = "Match Winner"
                    MarketType.SPREADS -> labelTv = "Handicap"
                    MarketType.TOTALS -> labelTv = "Goals Over/Under"
                    MarketType.OUTRIGHTS -> labelTv = "Outrights, Futures"
                    MarketType.H2H_LAY -> labelTv = "Head to head, Moneyline"
                    MarketType.OUTRIGHTS_LAY -> "Outrights, Futures"
                    else -> { // Note the block
                    }
                }
                binding.marketNameTv.text = labelTv

                Glide.with(binding.root.context)
                    .load(Constants.HOME_TEAM_LOGO)
                    .transform(CircleCrop())
                    .into(homeClubIv)

                Glide.with(binding.root.context)
                    .load(Constants.AWAY_TEAM_LOGO)
                    .transform(CircleCrop())
                    .into(awayClubIv)
            }




            itemView.setOnClickListener {
             /*   itemView.context.startActivity(
                    MatchDetailActivity.createSimpleIntent(
                        itemView.context,
                        fixture
                    )
                )*/
            }

        }
    }

    companion object {
        private val REPO_COMPARATOR = object : DiffUtil.ItemCallback<SelectedMatchOdd>() {
            override fun areItemsTheSame(oldItem: SelectedMatchOdd, newItem: SelectedMatchOdd): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: SelectedMatchOdd, newItem: SelectedMatchOdd): Boolean =
                oldItem == newItem
        }
    }
}
