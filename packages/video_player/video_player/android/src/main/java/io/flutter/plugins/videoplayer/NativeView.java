package io.flutter.plugins.videoplayer;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import io.flutter.plugin.platform.PlatformView;

class NativeView implements PlatformView, OverlayView {

    ViewGroup view;

    @Override
    public View getView() {
        return view;
    }

    @Override
    public void dispose() {
        if (view != null) {
            view.removeAllViews();
        }
        view = null;
    }

    NativeView(Context context) {
        view = new FrameLayout(context);
    }

    NativeView(OverlayView overlayView) {
        view = overlayView.getContainer();
    }

    @Override
    public ViewGroup getContainer() {
        return view;
    }
}

