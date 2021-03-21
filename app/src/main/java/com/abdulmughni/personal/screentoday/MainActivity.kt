package com.abdulmughni.personal.screentoday

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.abdulmughni.personal.screentoday.core.ui.main.TabPagerAdapter
import com.abdulmughni.personal.screentoday.core.ui.movie.MoviesFragment
import com.abdulmughni.personal.screentoday.databinding.ActivityMainBinding
import com.abdulmughni.personal.screentoday.databinding.TabLayoutBinding
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val binding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val adapter : TabPagerAdapter by lazy {
        TabPagerAdapter(this, arrayListOf(MoviesFragment(), MoviesFragment()))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupAdapter()
        setupSensitivity()
    }

    private fun setupAdapter() {
        binding.pager.adapter = adapter
        TabLayoutMediator(binding.tab, binding.pager) { tab, position ->
            when (position) {
                0 -> { tab.customView = getTabLayout(getString(R.string.title_tab_movie), R.drawable.ic_baseline_home_24) }
                1 -> { tab.customView = getTabLayout(getString(R.string.title_tab_tv_series), R.drawable.ic_baseline_insert_chart_24) }
            }
        }.attach()
        binding.pager.setCurrentItem(0, true)
    }

    private fun getTabLayout(title: String, icon: Int): View {
        val tabBinding = TabLayoutBinding.inflate(layoutInflater)
        tabBinding.title.text = title
        tabBinding.icon.setImageResource(icon)
        return tabBinding.root
    }

    private fun setupSensitivity() {
        try {
            val ff =
                ViewPager2::class.java.getDeclaredField("mRecyclerView")
            ff.isAccessible = true
            val recyclerView = ff[binding.pager] as RecyclerView
            val touchSlopField =
                RecyclerView::class.java.getDeclaredField("mTouchSlop")
            touchSlopField.isAccessible = true
            val touchSlop = touchSlopField[recyclerView] as Int
            touchSlopField[recyclerView] = touchSlop * 4
        } catch (e: NoSuchFieldException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        }
    }
}