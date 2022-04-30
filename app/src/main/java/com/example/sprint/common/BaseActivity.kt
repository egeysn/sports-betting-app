package com.example.sprint.common

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sprint.data.locale.CacheHelper
import com.example.sprint.utils.GeneralUtils
import com.example.sprint.utils.LoadingHelper
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
open class BaseActivity : AppCompatActivity() {

    @Inject
    lateinit var cacheHelper: CacheHelper

    private lateinit var loadingHelper: LoadingHelper
    private lateinit var generalUtils: GeneralUtils

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadingHelper = LoadingHelper.getInstance(this@BaseActivity)
        generalUtils = GeneralUtils.getInstance(this@BaseActivity)
    }

    fun showLoading() {
        runOnUiThread {
            loadingHelper.showDialog()
        }
    }

    fun hideLoading() {
        runOnUiThread { loadingHelper.hideDialog() }
    }
}
