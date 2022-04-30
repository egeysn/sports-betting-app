package com.example.sprint.common

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.sprint.utils.LoadingHelper
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
open class BaseFragment : Fragment() {

    lateinit var loadingHelper: LoadingHelper

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadingHelper = LoadingHelper.getInstance(requireContext())
    }

    fun showLoading() {
        loadingHelper.showDialog()
    }

    fun hideLoading() {
        loadingHelper.hideDialog()
    }

}