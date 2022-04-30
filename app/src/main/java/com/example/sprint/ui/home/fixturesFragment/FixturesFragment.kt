package com.naylalabs.scorely.ui.main.home.fixturesFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sprint.common.BaseFragment
import com.example.sprint.data.entities.ScoreModel
import com.example.sprint.databinding.FragmentFixturesBinding
import com.example.sprint.utils.Resource
import com.naylalabs.scorely.adapters.FixturesParentAdapter

class FixturesFragment() :
    BaseFragment() {

    private lateinit var binding: FragmentFixturesBinding
    private val viewModel: FixturesViewModel by activityViewModels()

    private lateinit var adapter: FixturesParentAdapter
    lateinit var layoutManager: LinearLayoutManager


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFixturesBinding.inflate(inflater, container, false)


        setupObservers()
        return binding.root
    }


    private fun setupObservers() {
        viewModel.fetchFixtures().observe(viewLifecycleOwner) {
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
        }

    }

    private fun onFixtureListFetched(fixtureList: ArrayList<ScoreModel>) {
        val groupList = fixtureList.groupBy { it.sportTitle }
        initRecyclerView(groupList as HashMap)
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

    }

    /*  */
    /**
    Maç tarihi değiştiğinde fixtureList sıfırlanacak ve yeni tarihe göre apiden istek yapılacak
     *//*
     fun onClickedDate(date: DateTime) {
        viewModel.page = 0
        myFixturesList.clear()
        rvMyFixtures.scrollToPosition(0)
        val date = formatter?.print(date)
        date?.let { viewModel.setDate(it) }
    }*/
}
