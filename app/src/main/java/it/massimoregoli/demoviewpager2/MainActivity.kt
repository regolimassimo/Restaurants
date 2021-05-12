package it.massimoregoli.demoviewpager2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import it.massimoregoli.demoviewpager2.activities.ViewsSliderActivity
import it.massimoregoli.demoviewpager2.databinding.ActivityMainBinding
import it.massimoregoli.demoviewpager2.fragments.FragmentViewPagerActivity


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.getRoot())
        supportActionBar?.elevation = 0f
        binding.btnViewsDemo.setOnClickListener {
            view -> startActivity(Intent(this@MainActivity, ViewsSliderActivity::class.java)) }

        binding.btnFragmentDemo.setOnClickListener {
                view -> startActivity(Intent(this@MainActivity, FragmentViewPagerActivity::class.java)) }
    }
}