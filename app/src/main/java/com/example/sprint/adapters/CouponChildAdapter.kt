package com.example.sprint.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.example.sprint.data.entities.Character
import com.example.sprint.data.entities.SelectedOddModel
import com.example.sprint.databinding.CouponMatchItemBinding
import com.example.sprint.utils.Constants


class CouponsChildAdapter(val context: Context, private val items: ArrayList<SelectedOddModel>
) : RecyclerView.Adapter<CouponsChildAdapter.CouponsChildViewHolder>() {


    @SuppressLint("NotifyDataSetChanged")
    fun setItems(items: ArrayList<SelectedOddModel>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CouponsChildViewHolder {
        val itemBinding =
            CouponMatchItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return CouponsChildViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: CouponsChildViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    inner class CouponsChildViewHolder(private val binding: CouponMatchItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: SelectedOddModel) {


            Glide.with(binding.root.context)
                .load(Constants.HOME_TEAM_LOGO)
                .transform(CircleCrop())
                .into(binding.homeClubIv)

            Glide.with(binding.root.context)
                .load(Constants.AWAY_TEAM_LOGO)
                .transform(CircleCrop())
                .into(binding.awayClubIv)

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
}
