package com.naylalabs.kotlinbaseproject.common

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.naylalabs.kotlinbaseproject.data.locale.CacheHelper
import com.naylalabs.kotlinbaseproject.utils.LoadingHelper
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
open class BaseActivity : AppCompatActivity() {

    @Inject
    lateinit var cacheHelper: CacheHelper

    private lateinit var loadingHelper: LoadingHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadingHelper = LoadingHelper.getInstance(this@BaseActivity)
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
