package com.naylalabs.kotlinbaseproject.ui.splash

import android.app.Dialog
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.viewModels
import com.naylalabs.kotlinbaseproject.BuildConfig
import com.naylalabs.kotlinbaseproject.common.BaseActivity
import com.naylalabs.kotlinbaseproject.databinding.ActivitySplashBinding
import com.naylalabs.kotlinbaseproject.services.RemoteConfigService
import com.naylalabs.kotlinbaseproject.ui.characters.CharactersActivity
import com.naylalabs.kotlinbaseproject.utils.PopupHelper
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashActivity : BaseActivity() {

    private val viewModel: SplashActivityViewModel by viewModels()
    private lateinit var binding: ActivitySplashBinding

    @Inject
    lateinit var remoteConfigService: RemoteConfigService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (remoteConfigService.isUnderMaintenanceEnabled()) {
            showUnderMaintenance()
            return
        }
        if (controlVersion()) {
            showForceUpdateDialog()
            return
        }
        startActivity(CharactersActivity.createSimpleIntent(this))
        finish()
    }

    private fun controlVersion(): Boolean {
        return remoteConfigService
            .isForceUpdateEnabled() && BuildConfig.VERSION_CODE < RemoteConfigService.getInstance()
            .getForceUpdateVersionAndroid()
    }


    private fun showUnderMaintenance() {
        PopupHelper.getInstance()
            .showUnderMaintenanceDialog(this, object : PopupHelper.SingleButtonClickListener {
                override fun onPositiveClicked(dialog: Dialog?) {
                    dialog?.dismiss()
                    finish()
                }

            }
            )
    }

    private fun showForceUpdateDialog() {
        PopupHelper.getInstance()
            .showForceUpdateDialog(this, object : PopupHelper.TwoButtonClickListener {
                override fun onPositiveClicked(dialog: Dialog?) {
                    dialog?.dismiss()
                }

                override fun onNegativeClicked(dialog: Dialog?) {
                    dialog?.dismiss()
                }

            }
            )
    }


}
