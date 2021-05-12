package it.massimoregoli.demoviewpager2.transform

import android.view.View
import androidx.viewpager2.widget.ViewPager2
import kotlin.math.abs


class FadeOutVert : ViewPager2.PageTransformer {
    override fun transformPage(page: View, position: Float) {
        page.translationY = -position * page.height
        page.alpha = 1 - abs(position)
    }
}