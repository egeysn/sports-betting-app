package com.example.sprint.adapters.pagerAdapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.naylalabs.scorely.ui.main.home.fixturesFragment.FixturesFragment

class HomePagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FixturesFragment()
            1 -> FixturesFragment()
            else -> FixturesFragment()
        }
    }
}
