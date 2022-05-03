package com.example.sprint.ui.home.cartFragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sprint.adapters.CartMatchAdapter
import com.example.sprint.common.BaseFragment
import com.example.sprint.data.entities.SelectedMatchOdd
import com.example.sprint.databinding.FragmentCartBinding
import com.example.sprint.ui.home.HomeActivity
import com.example.sprint.utils.OddUtilHelper
import com.example.sprint.utils.toast
import dagger.hilt.android.AndroidEntryPoint
import java.text.DecimalFormat
import javax.inject.Inject

@AndroidEntryPoint
class CartFragment() :
    BaseFragment() {

    @Inject
    lateinit var oddUtilHelper: OddUtilHelper

    private lateinit var binding: FragmentCartBinding
    private val viewModel: CartFragmentViewModel by activityViewModels()

    private lateinit var adapter: CartMatchAdapter

    private var initialPrice: Int = 3

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCartBinding.inflate(inflater, container, false)
        setupObservers()
        listeners()
        oddUtilHelper.selectedMatchOdds.value?.let { drawUI(it) }
        return binding.root
    }

    private fun listeners() {
        binding.emptyBody.setOnClickListener {
            (activity as HomeActivity).changeSelectedTab(0)
        }

        binding.priceEt.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val char = p0.toString()
                if (char.isNotEmpty()) {
                    initialPrice = Integer.parseInt(p0.toString())
                    updateCartInfoBox()
                }

            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })


    }


    private fun setupObservers() {
        oddUtilHelper.selectedMatchOdds.observe(viewLifecycleOwner) {
            drawUI(it)
        }
    }


    private fun drawUI(list:ArrayList<SelectedMatchOdd>) {
        if(list.isNullOrEmpty()){
            binding.body.visibility = View.GONE
            binding.emptyBody.visibility = View.VISIBLE
        }else{
            binding.body.visibility = View.VISIBLE
            binding.emptyBody.visibility = View.GONE
            initRecyclerView(matchList = list)
            updateCartInfoBox()
        }


    }
    private fun updateCartInfoBox(){
        binding.couponPriceTv.text = "$initialPrice TL"
        val df = DecimalFormat("#.##")
        binding.maxPriceTv.text = "${df.format(oddUtilHelper.getMaxPrice(initialPrice.toDouble()))} TL"
        binding.oddTv.text = df.format(oddUtilHelper.getMaxOdd())
    }


    private fun initRecyclerView(matchList: ArrayList<SelectedMatchOdd>) {


        if (::adapter.isInitialized) {
            adapter.setItems(matchList)
        } else {
            val layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            binding.matchRv.addItemDecoration(
                DividerItemDecoration(
                    context,
                    DividerItemDecoration.VERTICAL
                )
            )
            binding.matchRv.layoutManager = layoutManager
            adapter = CartMatchAdapter(requireContext(), matchList)
            adapter.setListener(object : CartMatchAdapter.CouponMatchItemListener {
                override fun onRemoveClicked(pos: Int, selectedMatchOdd: SelectedMatchOdd) {
                    val status = selectedMatchOdd.id?.let { oddUtilHelper.removeSelectedOdd(it) }
                    if (status == true)
                        adapter.notifyItemRemoved(pos)
                        context?.toast("Removed item")
                }

            })
            binding.matchRv.adapter = adapter
        }

    }

}
