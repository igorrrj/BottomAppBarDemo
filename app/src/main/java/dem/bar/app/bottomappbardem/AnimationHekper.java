package dem.bar.app.bottomappbardem;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.util.Log;
import android.view.View;

public class AnimationHekper {

    private AnimatorSet animatorSet = new AnimatorSet();
    private boolean isHidden = false;

    public AnimationHekper() {

        animatorSet.addListener(

                new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {
                        Log.e("Anim", "onAnimationStart");

                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                        Log.e("Anim", "onAnimationEnd");
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                }
        );

    }

    public void animateFabHide(View view) {
        isHidden = !isHidden;

        animatorSet.removeAllListeners();
        animatorSet.end();
        animatorSet.cancel();

        animatorSet.setDuration(400)
                .playTogether(

                        ObjectAnimator.ofFloat(view, View.SCALE_X, 1f, 0f),
                        ObjectAnimator.ofFloat(view, View.SCALE_Y, 1f, 0f)

                );

        animatorSet.addListener(

                new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {
                        Log.e("Anim", "onAnimationStart");

                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                        Log.e("Anim", "onAnimationEnd");
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                }
        );

        animatorSet.start();

    }


    public void animateFabShow(View view) {
        isHidden = !isHidden;

        animatorSet.removeAllListeners();
        animatorSet.end();
        animatorSet.cancel();

        animatorSet.setDuration(400)
                .playTogether(

                        ObjectAnimator.ofFloat(view, View.SCALE_X, 0f, 1f),
                        ObjectAnimator.ofFloat(view, View.SCALE_Y, 0f, 1f)

                );

        animatorSet.addListener(

                new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {
                        Log.e("Anim", "onAnimationStart");

                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                        Log.e("Anim", "onAnimationEnd");
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                }
        );

        animatorSet.start();

    }

    public interface Callback {

        void onAnimationStart();

        void onAnimationEnd();

    }

}
