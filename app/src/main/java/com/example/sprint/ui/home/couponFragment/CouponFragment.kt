package com.example.sprint.ui.home.couponFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sprint.adapters.CouponsChildAdapter
import com.example.sprint.common.BaseFragment
import com.example.sprint.data.entities.OddModel
import com.example.sprint.data.entities.SelectedOddModel
import com.example.sprint.databinding.FragmentCouponBinding
import com.example.sprint.databinding.FragmentFixturesBinding
import com.example.sprint.utils.OddUtilHelper
import com.example.sprint.utils.Resource
import com.naylalabs.scorely.adapters.FixturesParentAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CouponFragment constructor() :
    BaseFragment() {

    @Inject
    lateinit var oddUtilHelper: OddUtilHelper

    private lateinit var binding: FragmentCouponBinding
    private val viewModel: CouponFragmentViewModel by activityViewModels()

    private lateinit var adapter: CouponsChildAdapter
    lateinit var layoutManager: LinearLayoutManager


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCouponBinding.inflate(inflater, container, false)


        setupObservers()
        return binding.root
    }


    private fun setupObservers() {
        oddUtilHelper.selectedOdds.observe(viewLifecycleOwner) {
            if (!it.isNullOrEmpty()) {
                initRecyclerView(matchList = it)
            }
        }

    }


    private fun initRecyclerView(matchList: ArrayList<SelectedOddModel>) {
        layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding.matchRv.layoutManager = layoutManager
        if (::adapter.isInitialized) {
            adapter.setItems(matchList)
        } else {
            adapter = CouponsChildAdapter(requireContext(), matchList)
            binding.matchRv.adapter = adapter
        }

    }

}
