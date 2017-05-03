package com.sihua.rxjava.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sihua.rxjava.R;
import com.sihua.rxjava.application.OpenRiceApplication;
import com.sihua.rxjava.utils.StringUtil;


/**
 * Created by raychum on 28/5/15.
 */
public class ConnectionErrorFragment extends OpenriceSuperFragment {

    public static final String ERROR_TITLE_KEY = "ERROR_TITLE_KEY";
    public static final String ERROR_MESSAGE_KEY = "ERROR_MESSAGE_KEY";
    public static final String ERROR_BUTTON_LABEL_KEY = "ERROR_BUTTON_LABEL_KEY";
    public static final String ERROR_STATUS_KEY = "ERROR_STATUS_KEY";

    public static final int LOGIN_REQUEST_CODE = 12321;

    private View.OnClickListener onClickListener;
    private TextView retryButton;

    public static ConnectionErrorFragment newInstance(String title, String message, String buttonLabel) {
        final ConnectionErrorFragment connectionErrorFragment = new ConnectionErrorFragment();
        final Bundle bundle = new Bundle();
        bundle.putString(ERROR_TITLE_KEY, title);
        bundle.putString(ERROR_MESSAGE_KEY, message);
        bundle.putString(ERROR_BUTTON_LABEL_KEY, buttonLabel);
        connectionErrorFragment.setArguments(bundle);
        return connectionErrorFragment;
    }

    public static ConnectionErrorFragment newInstance(int httpStatus, String buttonLabel) {
        final ConnectionErrorFragment connectionErrorFragment = new ConnectionErrorFragment();
        final Bundle bundle = new Bundle();
        switch (httpStatus) {
            case 401:
                buttonLabel = OpenRiceApplication.getInstance().getString(R.string.login_sign_in);
                bundle.putString(ERROR_TITLE_KEY, null);
                bundle.putString(ERROR_MESSAGE_KEY, OpenRiceApplication.getInstance().getString(R.string.empty_private_push_message));
                break;
            case 403:
                bundle.putString(ERROR_TITLE_KEY, null);
                bundle.putString(ERROR_MESSAGE_KEY, OpenRiceApplication.getInstance().getString(R.string.empty_private_push_message));
                break;
            case 9999:
                bundle.putString(ERROR_TITLE_KEY, OpenRiceApplication.getInstance().getString(R.string.empty_wifi_no_connection_title));
                bundle.putString(ERROR_MESSAGE_KEY, OpenRiceApplication.getInstance().getString(R.string.empty_wifi_no_connection_message));
                break;
            case -1:
                bundle.putString(ERROR_TITLE_KEY, OpenRiceApplication.getInstance().getString(R.string.empty_network_unavailable_title));
                bundle.putString(ERROR_MESSAGE_KEY, OpenRiceApplication.getInstance().getString(R.string.empty_network_unavailable_message));
                break;
            default:
                bundle.putString(ERROR_TITLE_KEY, null);
                bundle.putString(ERROR_MESSAGE_KEY, OpenRiceApplication.getInstance().getString(R.string.empty_api_error_message, httpStatus));
                break;
        }
        bundle.putString(ERROR_BUTTON_LABEL_KEY, buttonLabel);
        bundle.putInt(ERROR_STATUS_KEY, httpStatus);
        connectionErrorFragment.setArguments(bundle);
        return connectionErrorFragment;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    @Override
    protected int getRootViewLayoutId() {
        return R.layout.fragment_connection_error;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = super.onCreateView(inflater, container, savedInstanceState);
        initView();
        return rootView;
    }

    protected void initView() {
        String title = null;
        String message = null;
        String buttonLabel = null;
        int httpStatus = -1;
        if (getArguments() != null) {
            title = getArguments().getString(ERROR_TITLE_KEY);
            message = getArguments().getString(ERROR_MESSAGE_KEY);
            buttonLabel = getArguments().getString(ERROR_BUTTON_LABEL_KEY);
            httpStatus = getArguments().getInt(ERROR_STATUS_KEY, -1);
        }
        final TextView errorTitle = (TextView) rootView.findViewById(R.id.connection_error_title);
        final TextView errorMessage = (TextView) rootView.findViewById(R.id.connection_error_content);
        retryButton = (TextView) rootView.findViewById(R.id.button_retry);
        if (!StringUtil.isStringEmpty(title)) {
            errorTitle.setVisibility(View.VISIBLE);
            errorTitle.setText(title);
        } else {
            errorTitle.setVisibility(View.GONE);
        }
        if (!StringUtil.isStringEmpty(message)) {
            errorMessage.setVisibility(View.VISIBLE);
            errorMessage.setText(message);
        } else {
            errorMessage.setVisibility(View.GONE);
        }
        if (httpStatus == 403)
            retryButton.setVisibility(View.GONE);
        else {
            if (buttonLabel != null) {
                retryButton.setText(buttonLabel);
            }
            if (httpStatus == 401) {

            } else {
                retryButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (isActive()) {
                            if (getFragmentManager().findFragmentByTag(ConnectionErrorFragment.class.getName()) != null) {
                                getFragmentManager().beginTransaction().remove(getFragmentManager()
                                        .findFragmentByTag(ConnectionErrorFragment.class.getName())).commitAllowingStateLoss();
                            } else if (getActivity().getSupportFragmentManager().findFragmentByTag(ConnectionErrorFragment.class.getName()) != null) {
                                getActivity().getSupportFragmentManager().beginTransaction()
                                        .remove(getActivity().getSupportFragmentManager()
                                                .findFragmentByTag(ConnectionErrorFragment.class.getName())).commitAllowingStateLoss();
                            }
                            if (onClickListener != null) {
                                onClickListener.onClick(view);
                            }
                        }
                    }
                });
            }
        }
    }

    @Override
    public void onDestroyView() {
        retryButton.setOnClickListener(null);
        super.onDestroyView();
    }

    @Override
    protected void loadData() {

    }

    public int getVisibility() {
        return rootView.getVisibility();
    }

    public void setVisibility(int visibility) {
        rootView.setVisibility(visibility);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == LOGIN_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                if (isActive()) {
                    if (getFragmentManager().findFragmentByTag(ConnectionErrorFragment.class.getName()) != null) {
                        getFragmentManager().beginTransaction().remove(getFragmentManager()
                                .findFragmentByTag(ConnectionErrorFragment.class.getName())).commitAllowingStateLoss();
                    } else if (getActivity().getSupportFragmentManager().findFragmentByTag(ConnectionErrorFragment.class.getName()) != null) {
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .remove(getActivity().getSupportFragmentManager()
                                        .findFragmentByTag(ConnectionErrorFragment.class.getName())).commitAllowingStateLoss();
                    }
                    if (onClickListener != null) {
                        onClickListener.onClick(null);
                    }
                }
            }
        }
    }
}
