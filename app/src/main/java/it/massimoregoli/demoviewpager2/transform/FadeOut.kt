package it.massimoregoli.demoviewpager2.transform

import android.view.View
import androidx.viewpager2.widget.ViewPager2
import kotlin.math.abs


class FadeOut() : ViewPager2.PageTransformer {
    override fun transformPage(page: View, position: Float) {
        page.translationX = -position * page.width
        page.alpha = 1 - abs(position)
        page.scaleX = 1 - abs(position)
        page.scaleY = 1 - abs(position)
    }
}