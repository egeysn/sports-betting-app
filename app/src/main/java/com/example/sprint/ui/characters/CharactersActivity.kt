package com.example.sprint.ui.characters

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sprint.MainApplication
import com.example.sprint.R
import com.example.sprint.adapters.CharactersAdapter
import com.example.sprint.common.BaseActivity
import com.example.sprint.databinding.ActivityCharactersBinding
import com.example.sprint.ui.characterDetail.CharacterDetailActivity
import com.example.sprint.utils.AnalyticsHelper
import com.example.sprint.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


class CharactersActivity : BaseActivity() {

    private val viewModel: CharactersViewModel by viewModels()
    private lateinit var adapter: CharactersAdapter
    private lateinit var binding: ActivityCharactersBinding

    @Inject
    lateinit var analyticsHelper: AnalyticsHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharactersBinding.inflate(layoutInflater)
        setContentView(binding.root)
        listeners()
        setupRecyclerView()
        setupObservers()
        analyticsHelper.singleTrack("characters_entered", "characters", null)

    }

    private fun listeners() {
    }

    companion object {
        fun createSimpleIntent(context: Context): Intent {
            return Intent(context, CharactersActivity::class.java)
        }
    }


    private fun setupObservers() {
        viewModel.characters.observe(
            this
        ) {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    hideLoading()
                    if (!it.data?.results.isNullOrEmpty()) adapter.setItems(ArrayList(it.data?.results))
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

    private fun setupRecyclerView() {
        binding.appbarTitle.text = MainApplication.appContext.getString(R.string.app_name)
        adapter = CharactersAdapter(object : CharactersAdapter.CharacterItemListener {
            override fun onClickedCharacter(characterId: Int) {
                startActivity(
                    CharacterDetailActivity.createSimpleIntent(
                        this@CharactersActivity,
                        characterId
                    )
                )
            }
        })
        binding.charactersRv.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.charactersRv.adapter = adapter
    }


}
