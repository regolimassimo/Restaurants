package it.massimoregoli.demoviewpager2.transform

import android.view.View
import androidx.viewpager2.widget.ViewPager2
import java.lang.Math.pow
import kotlin.math.abs
import kotlin.math.pow


class ZoomOut : ViewPager2.PageTransformer {
    override fun transformPage(view: View, position: Float) {

        view.cameraDistance = 12000f
        when {
            position < -1 -> { // [-Infinity,-1)
                // This page is way off-screen to the left.
                view.alpha = 0f
            }
            position <= 1 -> { // [-1,1]
                val scaleFactor = MIN_SCALE.coerceAtLeast(1 - abs(position)
                    .toDouble().pow(0.75).toFloat())
                view.pivotX = view.width.toFloat() / 2
                view.pivotY = view.height.toFloat() / 2
                view.rotation = 90f * position
                view.scaleX = scaleFactor
                view.scaleY = scaleFactor

                view.alpha = MIN_ALPHA.coerceAtLeast(1 - abs(position))
            }
            else -> { // (1,+Infinity]
                view.alpha = 0f
            }
        }
    }

    companion object {
        private const val MIN_SCALE = 0.1f
        private const val MIN_ALPHA = 0.1f
    }
}