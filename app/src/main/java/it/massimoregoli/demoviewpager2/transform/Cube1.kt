package it.massimoregoli.demoviewpager2.transform

import android.view.View
import androidx.viewpager2.widget.ViewPager2
import kotlin.math.abs


class Cube1 : ViewPager2.PageTransformer {
    override fun transformPage(page: View, position: Float) {
        page.cameraDistance = 20000f
        when {
            position < -1 -> {
                page.alpha = 0f
            }
            position <= 0 -> {
                page.alpha = 1f
                page.pivotX = page.width.toFloat()
                page.rotationY = 90 * abs(position)
            }
            position <= 1 -> {
                page.alpha = 1f
                page.pivotX = 0f
                page.rotationY = -90 * abs(position)
            }
            else -> {
                page.alpha = 0f
            }
        }
        val max = Math.max(.4f, 1 - abs(position))
        if (abs(position) <= 0.5) {
            page.scaleY = max
        } else if (abs(position) <= 1) {
            page.scaleY = max
        }
    }
}