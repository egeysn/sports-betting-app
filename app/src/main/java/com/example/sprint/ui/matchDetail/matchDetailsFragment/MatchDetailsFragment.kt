package com.example.sprint.ui.matchDetail.matchDetailsFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sprint.common.BaseFragment
import com.example.sprint.data.entities.OddModel
import com.example.sprint.data.entities.ScoreModel
import com.example.sprint.databinding.FragmentMatchDetailBinding
import com.naylalabs.scorely.adapters.FixturesParentAdapter

class MatchDetailsFragment(val matchDetail: OddModel?) :
    BaseFragment() {

    private lateinit var binding: FragmentMatchDetailBinding
    private val viewModel: MatchDetailsFragmentViewModel by activityViewModels()

    private lateinit var adapter: FixturesParentAdapter
    lateinit var layoutManager: LinearLayoutManager


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMatchDetailBinding.inflate(inflater, container, false)

        adjustUI()
        return binding.root
    }

    private fun adjustUI() {
        binding.apply {
            calendarTv.text = matchDetail?.commenceTime
        }

    }


}
