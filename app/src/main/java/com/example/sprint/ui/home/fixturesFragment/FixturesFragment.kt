package com.naylalabs.scorely.ui.main.home.fixturesFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sprint.common.BaseFragment
import com.example.sprint.databinding.FragmentFixturesBinding

class FixturesFragment() :
    BaseFragment() {

    private lateinit var binding: FragmentFixturesBinding
    private val viewModel: FixturesViewModel by activityViewModels()

    private lateinit var rvMyFixtures: RecyclerView
    private lateinit var dateRecyclerView: RecyclerView
    lateinit var layoutManager: LinearLayoutManager

    var isLoading = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFixturesBinding.inflate(inflater, container, false)

        // initDateRecyclerView()
        // initRecyclerView()
        setupObservers()

        return binding.root
    }

    private fun setupObservers() {

     /*   viewModel.fixtures.observe(viewLifecycleOwner) {
            isLoading = true
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    val fixtureList = it.data?.data

                    hideLoading()
                }
                Resource.Status.ERROR -> {
                    isLoading = false
                    hideLoading()
                }
                Resource.Status.LOADING -> {
                    isLoading = true
                    showLoading()
                }
            }
        }*/
    }

/*    private fun initDateRecyclerView() {
        dateRecyclerView = binding.dateRecyclerview
        dateAdapter = FixtureDatesAdapter(viewModel.getDates())
        dateRecyclerView.layoutManager =
            LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        dateRecyclerView.adapter = dateAdapter
        dateRecyclerView.scrollToPosition(2)
        dateAdapter.setListener(this)
    }*/

/*    private fun initRecyclerView() {
        layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        rvMyFixtures = binding.recyclerView
        rvMyFixtures.layoutManager = layoutManager
        rvMyFixtures.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val visibleItemCount = layoutManager.childCount
                val pastVisibleItem = layoutManager.findLastVisibleItemPosition()
                val total = layoutManager.itemCount
                if (!isLoading) {
                    if ((visibleItemCount + pastVisibleItem) >= total) {
                        viewModel.listScrolled()
                    }
                }
                super.onScrolled(recyclerView, dx, dy)
            }
        })
    }*/

    /*  *//**
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
