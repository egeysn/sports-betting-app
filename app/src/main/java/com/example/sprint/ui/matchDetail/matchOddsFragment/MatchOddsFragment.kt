package com.example.sprint.ui.matchDetail.matchOddsFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sprint.common.BaseFragment
import com.example.sprint.data.entities.OddModel
import com.example.sprint.databinding.FragmentMatchOddsBinding
import com.naylalabs.scorely.adapters.FixturesParentAdapter

class MatchOddsFragment(val matchDetail: OddModel?) :
    BaseFragment() {

    private lateinit var binding: FragmentMatchOddsBinding
    private val viewModel: MatchOddsFragmentViewModel by activityViewModels()

    private lateinit var adapter: FixturesParentAdapter
    lateinit var layoutManager: LinearLayoutManager


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMatchOddsBinding.inflate(inflater, container, false)


        setupObservers()
        return binding.root
    }


    private fun setupObservers() {
    /*    viewModel.fetchFixtures().observe(viewLifecycleOwner) {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    val fixtureList = it.data
                    if (!fixtureList.isNullOrEmpty()) {
                        onFixtureListFetched(fixtureList)
                    } else {
                        binding.emptyList.visibility = View.VISIBLE
                    }
                    hideLoading()
                }
                Resource.Status.ERROR -> {
                    binding.emptyList.visibility = View.VISIBLE
                    hideLoading()
                }
                Resource.Status.LOADING -> {
                    showLoading()
                }
            }
        }*/

    }


/*
    private fun onFixtureListFetched(fixtureList: ArrayList<ScoreModel>) {
        val groupList = fixtureList.groupBy { it.sportTitle }
        initRecyclerView(groupList as HashMap<String, List<ScoreModel>>)
    }

    private fun initRecyclerView(hashMap: HashMap<String, List<ScoreModel>>) {
        layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding.fixtureRv.layoutManager = layoutManager
        if (::adapter.isInitialized) {
            adapter.setItems(hashMap)
        } else {
            adapter = FixturesParentAdapter(requireContext())
            binding.fixtureRv.adapter = adapter
            adapter.setItems(hashMap)
        }

    }*/

}
