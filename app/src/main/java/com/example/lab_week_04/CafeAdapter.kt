package com.example.lab_week_04

import android.content.res.Resources // Added import
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

val TABS_FIXED = listOf(
    R.string.starbucks_title,
    R.string.janjijiwa_title,
    R.string.kopikenangan_title,
)

// List of description string resources, matching the order of TABS_FIXED
val TAB_DESCRIPTIONS = listOf(
    R.string.starbucks_desc,
    R.string.janjijiwa_desc,
    R.string.kopikenangan_desc
)

class CafeAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
    private val resources: Resources // Added resources parameter
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return TABS_FIXED.size
    }

    override fun createFragment(position: Int): Fragment {
        // Get the description string using the resources and position
        val descriptionString = resources.getString(TAB_DESCRIPTIONS[position])
        // Create a new instance of CafeDetailFragment with the description
        return CafeDetailFragment.newInstance(descriptionString)
    }
}