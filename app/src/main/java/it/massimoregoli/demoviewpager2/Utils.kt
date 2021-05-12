package it.massimoregoli.demoviewpager2

import androidx.viewpager2.widget.ViewPager2
import it.massimoregoli.demoviewpager2.transform.*

class Utils {
    companion object {
        fun getTransformer(id: Int): ViewPager2.PageTransformer {
            when (id) {
                R.id.action_anti_clock_spin -> return AntiClock()
                R.id.action_clock_spin -> return Clock()
                R.id.action_cube_in_depth -> return Cube1()
                R.id.action_cube_in_rotate -> return Cube2()
                R.id.action_vertical_flip -> return FlipVert()
                R.id.action_depth -> return Diagonal()
                R.id.action_horizontal_flip -> return FlipHor()
                R.id.action_fade_out -> return FadeOut()
                R.id.action_fade_out_vert -> return FadeOutVert()
//            return new CubeInRotationTransformation();
//            case R.id.action_cube_out_depth:
//            return new CubeOutDepthTransformation();
//            case R.id.action_cube_out_rotate:
//            return new CubeOutRotationTransformation();
//            case R.id.action_cube_out_scaling:
//            return new CubeOutScalingTransformation();
//            case R.id.action_depth_page:
//            return new DepthPageTransformer();
//            case R.id.action_depth:
//            return new DepthTransformation();
//            case R.id.action_fade_out:
//            return new FadeOutTransformation();
//            case R.id.action_fan:
//            return new FanTransformation();
//            case R.id.action_gate:
//            return new GateTransformation();
//            case R.id.action_hinge:
//            return new HingeTransformation();
//            case R.id.action_horizontal_flip:
//            return new VerticalFlipTransformation();
//            case R.id.action_pop:
//            return new PopTransformation();
//            case R.id.action_simple_transformation:
//            return new SimpleTransformation();
//            case R.id.action_spinner:
//            return new SpinnerTransformation();
//            case R.id.action_toss:
//            return new TossTransformation();
//            case R.id.action_vertical_flip:
//            return new HorizontalFlipTransformation();
//            case R.id.action_vertical_shut:
//            return new VerticalShutTransformation();
//            case R.id.action_zoom_out:
//            return new ZoomOutPageTransformer();
            }
            return AntiClock()
        }

    }
}