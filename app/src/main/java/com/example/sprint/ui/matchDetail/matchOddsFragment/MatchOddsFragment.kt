package com.example.sprint.ui.matchDetail.matchOddsFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sprint.common.BaseFragment
import com.example.sprint.data.entities.MarketsItem
import com.example.sprint.data.entities.OddModel
import com.example.sprint.databinding.FragmentMatchOddsBinding
import com.naylalabs.scorely.adapters.OddsChildAdapter
import com.naylalabs.scorely.adapters.OddsParentAdapter

class MatchOddsFragment(val oddModel: OddModel?) :
    BaseFragment() {

    private lateinit var binding: FragmentMatchOddsBinding
    private val viewModel: MatchOddsFragmentViewModel by activityViewModels()

    private lateinit var adapter: OddsParentAdapter
    lateinit var layoutManager: LinearLayoutManager


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMatchOddsBinding.inflate(inflater, container, false)

        initOddsRecyclerView()
        return binding.root
    }

    private fun initOddsRecyclerView() {
        binding.oddsRv.layoutManager = LinearLayoutManager(requireContext(),RecyclerView.VERTICAL,false)
        if (!oddModel?.bookmakers.isNullOrEmpty()) {
            adapter = OddsParentAdapter(requireContext(),
                oddModel?.bookmakers?.get(0)?.markets as ArrayList<MarketsItem>,
                object : OddsChildAdapter.OddItemListener {
                    override fun onOddItemSelected() {
                        TODO("Not yet implemented")
                    }

                })
            binding.oddsRv.adapter = adapter

        } else {
            //show error widget
        }
    }


}
