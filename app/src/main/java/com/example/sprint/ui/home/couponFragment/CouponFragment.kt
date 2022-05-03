package com.example.sprint.ui.home.couponFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sprint.adapters.CouponMatchAdapter
import com.example.sprint.common.BaseFragment
import com.example.sprint.data.entities.SelectedMatchOdd
import com.example.sprint.databinding.FragmentCouponBinding
import com.example.sprint.ui.home.HomeActivity
import com.example.sprint.utils.OddUtilHelper
import com.example.sprint.utils.toast
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CouponFragment() :
    BaseFragment() {

    @Inject
    lateinit var oddUtilHelper: OddUtilHelper

    private lateinit var binding: FragmentCouponBinding
    private val viewModel: CouponFragmentViewModel by activityViewModels()

    private lateinit var adapter: CouponMatchAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCouponBinding.inflate(inflater, container, false)
        setupObservers()
        listeners()
        return binding.root
    }

    private fun listeners() {
        binding.emptyBody.setOnClickListener {
            (activity as HomeActivity).changeSelectedTab(0)
        }
    }


    private fun setupObservers() {
        oddUtilHelper.selectedMatchOdds.observe(viewLifecycleOwner) {
            if (!it.isNullOrEmpty()) {
                binding.matchRv.visibility = View.VISIBLE
                binding.emptyBody.visibility = View.GONE
                initRecyclerView(matchList = it)
            } else {
                binding.matchRv.visibility = View.GONE
                binding.emptyBody.visibility = View.VISIBLE
            }
        }

    }


    private fun initRecyclerView(matchList: ArrayList<SelectedMatchOdd>) {


        if (::adapter.isInitialized) {
            adapter.setItems(matchList)
        } else {
            val layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            binding.matchRv.addItemDecoration(   DividerItemDecoration(
                context,
                DividerItemDecoration.VERTICAL
            )
            )
            binding.matchRv.layoutManager = layoutManager
            adapter = CouponMatchAdapter(requireContext(), matchList)
            adapter.setListener(object : CouponMatchAdapter.CouponMatchItemListener {
                override fun onRemoveClicked(pos: Int, selectedMatchOdd: SelectedMatchOdd) {
                  val status =   selectedMatchOdd.id?.let { oddUtilHelper.removeSelectedOdd(it) }
                    if(status == true)
                    adapter.notifyItemRemoved(pos)
                    context?.toast("Removed item")
                }

            })
            binding.matchRv.adapter = adapter
        }

    }

}
