package com.example.sprint.adapters.pagerAdapters
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.sprint.data.entities.ScoreModel
import com.example.sprint.ui.matchDetail.matchDetailsFragment.MatchDetailsFragment
import com.example.sprint.ui.matchDetail.matchOddsFragment.MatchOddsFragment


class MatchDetailPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {


    private var matchDetail : ScoreModel? = null

    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> MatchOddsFragment()
            else -> MatchDetailsFragment(matchDetail)
        }
    }

    fun setScoreModel(matchDetail : ScoreModel?){
        this.matchDetail = matchDetail
    }
}