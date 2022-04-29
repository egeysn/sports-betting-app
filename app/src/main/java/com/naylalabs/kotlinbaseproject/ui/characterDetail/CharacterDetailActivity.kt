package com.naylalabs.kotlinbaseproject.ui.characterDetail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.naylalabs.kotlinbaseproject.common.BaseActivity
import com.naylalabs.kotlinbaseproject.data.entities.Character
import com.naylalabs.kotlinbaseproject.databinding.ActivityCharacterDetailBinding
import com.naylalabs.kotlinbaseproject.utils.AnalyticsHelper
import com.naylalabs.kotlinbaseproject.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CharacterDetailActivity : BaseActivity() {

    private val viewModel: CharacterDetailViewModel by viewModels()
    private lateinit var binding: ActivityCharacterDetailBinding
    private var id: Int? = null

    @Inject
    lateinit var analyticsHelper: AnalyticsHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        analyticsHelper.singleTrack("character_detail_entered", "characters", null)
        id = intent.getIntExtra("id",0)
        setupObservers()
    }

    companion object {
        fun createSimpleIntent(context: Context, id: Int): Intent {
            return Intent(context, CharacterDetailActivity::class.java).putExtra("id", id)
        }
    }

    private fun setupObservers() {
        viewModel.getCharacterDetail(id!!).observe(
            this
        ) {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    hideLoading()
                    if (it.data != null) drawUI(it.data)
                }
                Resource.Status.ERROR -> {
                    hideLoading()
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                }
                Resource.Status.LOADING -> {
                    showLoading()
                }
            }
        }
    }

    private fun drawUI(data: Character) {
        binding.name.text = data.name
        binding.speciesAndStatus.text = data.species
        Glide.with(this)
            .load(data.image)
            .into(binding.image)
    }


}
