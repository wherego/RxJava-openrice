package com.sihua.rxjava.base;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.sihua.rxjava.R;
import com.sihua.rxjava.callback.Callback;
import com.sihua.rxjava.utils.DataUtil;
import com.sihua.rxjava.utils.DeviceUtil;
import com.sihua.rxjava.utils.StringUtil;

/**
 * Created by raychum on 10/11/2016.
 */

public class OpenRiceDialogFragment extends DialogFragment {

    private View container;
    private View.OnClickListener okListener;
    private View.OnClickListener cancelListener;
    private Callback<Void> dismissListener;
    private View rootView;
    private String messageStr;
    private String okButtonStr;
    private String cancelButtonStr;
    private int delayDismissMillis;
    private int iconRes;

    public static OpenRiceDialogFragment newInstance(@DrawableRes int iconRes, String messageStr, String okButtonStr,
                                                     String cancelButtonStr, View.OnClickListener okListener,
                                                     View.OnClickListener cancelListener, Callback<Void> dismissListener, boolean isCancelable, int delayDismissMillis) {
        OpenRiceDialogFragment openRiceDialogFragment = new OpenRiceDialogFragment();
        openRiceDialogFragment.iconRes = iconRes;
        openRiceDialogFragment.messageStr = messageStr;
        openRiceDialogFragment.okButtonStr = okButtonStr;
        openRiceDialogFragment.cancelButtonStr = cancelButtonStr;
        openRiceDialogFragment.okListener = okListener;
        openRiceDialogFragment.cancelListener = cancelListener;
        openRiceDialogFragment.dismissListener = dismissListener;
        openRiceDialogFragment.delayDismissMillis = delayDismissMillis;
        openRiceDialogFragment.setCancelable(isCancelable);
        return openRiceDialogFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.OpenRiceDialog);
    }

    private int getRootViewLayoutId() {
        return R.layout.fragment_openricedialog;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(getRootViewLayoutId(), container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        initView();
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        if (dismissListener != null) {
            dismissListener.onCallback(null);
        }
    }

    private void initView() {
        container = rootView.findViewById(R.id.dialog_container);
        final Button okButton = (Button) rootView.findViewById(R.id.btn_ok);
        final TextView cancelButton = (TextView) rootView.findViewById(R.id.btn_cancel);
        final TextView message = (TextView) rootView.findViewById(R.id.message);
        final ImageView icon = (ImageView) rootView.findViewById(R.id.icon);
        container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // empty onClick implementation to prevent click to dismiss
            }
        });
        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isCancelable()) {
                    dismiss();
                }
            }
        });
        message.setText(messageStr);
        if (!StringUtil.isStringEmpty(okButtonStr)) {
            okButton.setText(okButtonStr);
        }
        if (iconRes > 0) {
            icon.setImageResource(iconRes);
        }
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (okListener != null) {
                    okListener.onClick(view);
                }
                dismiss();
            }
        });
        if (cancelListener == null) {
            cancelButton.setVisibility(View.GONE);
            message.setMinHeight((int) DataUtil.dip2px(getContext(), 82));
        } else {
            ViewCompat.setPaddingRelative(container, container.getPaddingTop(), container.getPaddingLeft(), container.getPaddingRight(), (int) DataUtil.dip2px(getContext(), 3));
            if (!StringUtil.isStringEmpty(cancelButtonStr)) {
                cancelButton.setText(cancelButtonStr);
            }
            cancelButton.setVisibility(View.VISIBLE);
            cancelButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cancelListener != null) {
                        cancelListener.onClick(view);
                    }
                    dismiss();
                }
            });
        }
        if (delayDismissMillis > 0) {
            rootView.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (isActive()) {
                        dismissAllowingStateLoss();
                    }
                }
            }, delayDismissMillis);
        }
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

    @Override
    public void onDestroy() {
        okListener = null;
        cancelListener = null;
        dismissListener = null;
        super.onDestroy();
    }
}