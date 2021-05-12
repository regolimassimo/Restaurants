package it.massimoregoli.demoviewpager2.transform

import android.view.View
import androidx.viewpager2.widget.ViewPager2
import kotlin.math.abs

class Diagonal : ViewPager2.PageTransformer {
    override fun transformPage(page: View, position: Float) {
        page.translationX = -position * page.width
        page.translationY = -position * page.width
        if (abs(position) <= 0.75) {
            page.visibility = View.VISIBLE
        } else if (abs(position) > 0.75) {
            page.visibility = View.GONE
        }
        when {
            position < -1 -> {  // [-Infinity,-1)
                // Out.
                page.alpha = 0f
            }
            position <= 0 -> {   // [-1,0]
                page.alpha = 1f + position
            }
            position <= 1 -> {   // (0,1]
                page.alpha = 1f - position
            }
            else -> {  // (1,+Infinity]
                // Out
                page.alpha = 0f
            }
        }
    }
}