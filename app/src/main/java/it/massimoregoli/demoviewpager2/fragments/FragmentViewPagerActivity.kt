package it.massimoregoli.demoviewpager2.fragments

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import it.massimoregoli.demoviewpager2.R
import it.massimoregoli.demoviewpager2.databinding.ActivityFragmentViewPagerBinding
import it.massimoregoli.demoviewpager2.listeners.ChickenToMain
import it.massimoregoli.demoviewpager2.transform.ZoomOut
import it.massimoregoli.demoviewpager2.viewmodel.CommViewModel


class FragmentViewPagerActivity : AppCompatActivity(), ChickenToMain {
    private lateinit var binding: ActivityFragmentViewPagerBinding

    // tab titles
    private lateinit var titles: Array<String>
    private lateinit var icons: Array<Int>
    private val viewModel: CommViewModel by viewModels()
    private lateinit var adapter: ViewPagerFragmentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentViewPagerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
        viewModel.data.observe(this, {
            Log.w("OBSERVER", "FragmentViewPagerActivity")
        })
    }

    private fun init() {
        titles = arrayOf(
            getString(R.string.reservation),
            getString(R.string.first_dishes),
            getString(R.string.chicken)
        )
        icons = arrayOf(R.drawable.ic_reservation32,
        R.drawable.ic_pasta32,
        R.drawable.ic_pasta32)

        supportActionBar!!.elevation = 0f
        adapter = ViewPagerFragmentAdapter(this)

        binding.viewPager.adapter = adapter
        binding.viewPager.setPageTransformer(ZoomOut())

        // attaching tab mediator
        TabLayoutMediator(
            binding.tabLayout, binding.viewPager
        ) { tab: TabLayout.Tab, position: Int ->
            tab.text = titles[position]
            tab.icon =
                ContextCompat.getDrawable(this@FragmentViewPagerActivity,
                    icons[position])
        }.attach()
    }

    private inner class ViewPagerFragmentAdapter(
        fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
        override fun createFragment(position: Int): Fragment {
            when (position) {
                0 -> return ReservationFragment()
                1 -> return PastaFragment()
                2 -> return ChickenFragment()
            }
            return PastaFragment()
        }

        override fun getItemCount(): Int {
            return titles.size
        }
    }

    override fun chickenList(list: MutableList<String>) {
        viewModel.updateData(list)
        list.forEach {
            Log.w("MY_PAGER", it)
        }
    }
}
