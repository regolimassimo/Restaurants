package it.massimoregoli.demoviewpager2.activities

import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import it.massimoregoli.demoviewpager2.R
import it.massimoregoli.demoviewpager2.Utils
import it.massimoregoli.demoviewpager2.databinding.ActivityViewsSliderBinding
import it.massimoregoli.demoviewpager2.fragments.FragmentViewPagerActivity


class ViewsSliderActivity: AppCompatActivity() {
    private lateinit var adapter: ViewsSliderAdapter
    private lateinit var dots: Array<TextView?>
    private lateinit var layouts: IntArray
    private lateinit var binding: ActivityViewsSliderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewsSliderBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        layouts = intArrayOf(R.layout.slide_one, R.layout.slide_two,
            R.layout.slide_three, R.layout.slide_four
        )
        adapter = ViewsSliderAdapter()
        binding.viewPager.adapter = adapter
        binding.viewPager.registerOnPageChangeCallback(pageChangeCallback)
        binding.btnSkip.setOnClickListener { launchHomeScreen() }
        binding.btnNext.setOnClickListener {
            val current = getNextItem()
            if (current < layouts.size) {
                binding.viewPager.currentItem = current
            } else {
                launchHomeScreen()
            }
        }
        binding.iconMore.setOnClickListener { view -> showMenu(view) }

        addBottomDots(0)
    }

    /*
     * Adds bottom dots indicator
     * */
    private fun addBottomDots(currentPage: Int) {
        dots = arrayOfNulls(layouts.size)
        val colorsActive = resources.getIntArray(R.array.array_dot_active)
        val colorsInactive = resources.getIntArray(R.array.array_dot_inactive)
        binding.layoutDots.removeAllViews()
        for (i in dots.indices) {
            dots[i] = TextView(this)
            dots[i]!!.text = Html.fromHtml("&#8226;", 0)
            dots[i]!!.textSize = 35f
            dots[i]!!.setTextColor(colorsInactive[currentPage])
            binding.layoutDots.addView(dots[i])
        }
        if (dots.isNotEmpty()) dots[currentPage]!!.setTextColor(colorsActive[currentPage])
    }

    private fun getNextItem(): Int {
        return binding.viewPager.currentItem + 1
    }

    private fun launchHomeScreen() {
        Toast.makeText(this, R.string.slides_ended, Toast.LENGTH_LONG).show()
        startActivity(Intent(this, FragmentViewPagerActivity::class.java))
        finish()
    }

    private fun showMenu(view: View) {
        val popup = PopupMenu(this, view)
        val inflater: MenuInflater = popup.menuInflater
        inflater.inflate(R.menu.pager_transformers, popup.menu)
        popup.setOnMenuItemClickListener { item ->
            if (item.itemId == R.id.action_orientation) {
                binding.viewPager.orientation =
                    if(binding.viewPager.orientation == ViewPager2.ORIENTATION_VERTICAL)
                        ViewPager2.ORIENTATION_HORIZONTAL
                else
                        ViewPager2.ORIENTATION_VERTICAL
            } else {
                binding.viewPager.setPageTransformer(Utils.getTransformer(item.itemId))
                binding.viewPager.currentItem = 0
                binding.viewPager.adapter?.notifyDataSetChanged()
            }
            false
        }
        popup.show()
    }

    /*
     * ViewPager page change listener
     */
    private var pageChangeCallback:
            OnPageChangeCallback = object : OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            addBottomDots(position)
            // changing the next button text 'NEXT' / 'GOT IT'
            if (position == layouts.size - 1) {
                // last page. make button text to GOT IT
                binding.btnNext.text = getString(R.string.start)
                binding.btnSkip.visibility = View.GONE
            } else {
                // still pages are left
                binding.btnNext.text = getString(R.string.next)
                binding.btnSkip.visibility = View.VISIBLE
            }
        }
    }

    inner class ViewsSliderAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            val view: View = LayoutInflater.from(parent.context)
                .inflate(viewType, parent, false)
            return SliderViewHolder(view)
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        }
        override fun getItemViewType(position: Int): Int {
            return layouts[position]
        }

        override fun getItemCount(): Int {
            return layouts.size
        }

        inner class SliderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            var title: TextView? = null
            var year: TextView? = null
            var genre: TextView? = null
        }
    }

}