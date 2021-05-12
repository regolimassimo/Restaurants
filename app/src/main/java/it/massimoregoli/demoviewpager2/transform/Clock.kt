package it.massimoregoli.demoviewpager2.transform

import android.view.View
import androidx.viewpager2.widget.ViewPager2
import kotlin.math.abs


class Clock : ViewPager2.PageTransformer {
    override fun transformPage(page: View, position: Float) {
        page.translationX = -position * page.width
        if (abs(position) <= 0.5) {
            page.visibility = View.VISIBLE
            page.scaleX = 1 - abs(position)
            page.scaleY = 1 - abs(position)
        } else if (abs(position) > 0.5) {
            page.visibility = View.GONE
        }
        when {
            position < -1 -> page.alpha = 0f
            position <= 0 -> {   // [-1,0]
                page.alpha = 1f
                page.rotation = 360 * abs(position)
            }
            position <= 1 -> {   // (0,1]
                page.alpha = 1f
                page.rotation = -360 * abs(position)
            }
            else -> page.alpha = 0f
        }
    }
}