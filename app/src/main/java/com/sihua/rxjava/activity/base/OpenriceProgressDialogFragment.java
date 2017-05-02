package com.sihua.rxjava.activity.base;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;

import com.sihua.rxjava.R;
import com.sihua.rxjava.utils.DeviceUtil;
import com.sihua.rxjava.utils.StringUtil;

/**
 * Created by sihuaxie on 17/4/28.
 */

public class OpenriceProgressDialogFragment extends DialogFragment {

    private View rootView;
    private View container;
    private String messageStr;
    private ImageView progressImageView;
    private TextView messageText;
    public static OpenriceProgressDialogFragment newInstance(String messageStr, boolean isCancelable){
        OpenriceProgressDialogFragment progressDialogFragment = new OpenriceProgressDialogFragment();
        progressDialogFragment.setCancelable(isCancelable);
        progressDialogFragment.messageStr = messageStr;
        return progressDialogFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.OpenRiceDialog);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.progress_dialog, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        initView();
        super.onViewCreated(view, savedInstanceState);
    }

    private void initView(){
        container = rootView.findViewById(R.id.dialog_container);
        progressImageView = (ImageView) rootView.findViewById(R.id.progress_icon);
        messageText = (TextView) rootView.findViewById(R.id.progress_message);
        if(!StringUtil.isStringEmpty(messageStr))
            messageText.setText(messageStr);
        final AnimationDrawable myAnimationDrawable = (AnimationDrawable) progressImageView.getDrawable();
        myAnimationDrawable.start();
        container.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (container.getWidth() > 0 && container.getHeight() > 0 && container.getY() > 0) {
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
                        container.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    } else {
                        container.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    }
                    final ObjectAnimator translateAnimator = ObjectAnimator.ofFloat(container, "Y",
                            (float) (DeviceUtil.getDeviceHeight(getContext()) * 0.6),
                            container.getY());
                    final ObjectAnimator fadeInAnimator = ObjectAnimator.ofFloat(container, View.ALPHA, 0.0f, 1.0f);
                    final AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playTogether(translateAnimator, fadeInAnimator);
                    animatorSet.setDuration(200);
                    animatorSet.addListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                        }
                    });
                    animatorSet.start();
                }
            }
        });
    }
    public synchronized boolean isActive() {
        return getActivity() != null && !getActivity().isFinishing() && isAdded() && !isRemoving();
    }
}
