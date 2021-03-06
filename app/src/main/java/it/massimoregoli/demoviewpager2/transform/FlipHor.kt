package it.massimoregoli.demoviewpager2.transform

import android.view.View
import androidx.viewpager2.widget.ViewPager2
import kotlin.math.abs


class FlipHor : ViewPager2.PageTransformer {
    override fun transformPage(page: View, position: Float) {
        page.translationX = -position * page.width
        page.cameraDistance = 12000f
        if (position < 0.5 && position > -0.5) {
            page.visibility = View.VISIBLE
        } else {
            page.visibility = View.INVISIBLE
        }
        if (position < -1) {     // [-Infinity,-1)
            page.alpha = 0f
        } else if (position <= 0) {    // [-1,0]
            page.alpha = 1f
            page.rotationY = -360 * (1 - abs(position) + 1)
        } else if (position <= 1) {    // (0,1]
            page.alpha = 1f
            page.rotationY = 360 * (1 - abs(position) + 1)
        } else {
            page.alpha = 0f
        }
    }
}