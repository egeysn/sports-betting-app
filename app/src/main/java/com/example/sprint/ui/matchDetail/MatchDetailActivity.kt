package com.example.sprint.ui.matchDetail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.example.sprint.adapters.pagerAdapters.HomePagerAdapter
import com.example.sprint.common.BaseActivity
import com.example.sprint.data.entities.ScoreModel
import com.example.sprint.databinding.ActivityHomeBinding
import com.example.sprint.databinding.ActivityMatchDetailBinding
import com.example.sprint.utils.Constants
import com.example.sprint.utils.toHour
import com.example.sprint.utils.views.NavigationBar

class MatchDetailActivity : BaseActivity() {

    lateinit var binding: ActivityMatchDetailBinding
    private val viewModel: MatchDetailActivityViewModel by viewModels()

    private lateinit var scoreModel: ScoreModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMatchDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        scoreModel = intent.getParcelableExtra<ScoreModel>(MATCH_DETAIL_DATA)!!
        adjustUI()
    }

    private fun adjustUI() {
        if (!scoreModel.scores.isNullOrEmpty()) {
            binding.homeScoreTv.text = scoreModel.scores!![0].score
            binding.awayScoreTv.text = scoreModel.scores!![1].score
        }

        //need check other statuses
        if(scoreModel.completed == true){
            binding.matchStatusTv.text = "Finished"
        }else{
            binding.matchStatusTv.text = "Not Started"
        }

    Glide.with(binding.root.context)
    .load(Constants.HOME_TEAM_LOGO)
    .transform(CircleCrop())
    .into(binding.homeClubIv)

    Glide.with(binding.root.context)
    .load(Constants.AWAY_TEAM_LOGO)
    .transform(CircleCrop())
    .into(binding.awayClubIv)


}


companion object {
    var MATCH_DETAIL_DATA = "MATCH_DETAIL"
    fun createSimpleIntent(context: Context?, item: ScoreModel): Intent {
        return Intent(context, MatchDetailActivity::class.java).putExtra(
            MATCH_DETAIL_DATA,
            item
        )
    }
}
}
