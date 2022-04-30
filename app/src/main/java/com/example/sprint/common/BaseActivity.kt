package com.example.sprint.common

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.example.sprint.data.locale.CacheHelper
import com.example.sprint.utils.GeneralUtils
import com.example.sprint.utils.LoadingHelper
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
open class BaseActivity : AppCompatActivity() {

    @Inject
    lateinit var cacheHelper: CacheHelper

    private val loadingHelper by lazy { LoadingHelper() }
    private lateinit var generalUtils: GeneralUtils
    private var myContext: FragmentActivity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        generalUtils = GeneralUtils.getInstance(this@BaseActivity)
    }

    fun showLoading() {
        if (!loadingHelper.isAdded) {
            myContext?.let { loadingHelper.show(it.supportFragmentManager, "loading") }
        }
    }

    fun hideLoading() {
        if (loadingHelper.isAdded) {
            loadingHelper.dismissAllowingStateLoss()
        }
    }
}
