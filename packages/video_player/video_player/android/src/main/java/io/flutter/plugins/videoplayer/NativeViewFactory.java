package io.flutter.plugins.videoplayer;

import android.content.Context;

import io.flutter.Log;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugin.platform.PlatformView;
import io.flutter.plugin.platform.PlatformViewFactory;

class NativeViewFactory extends PlatformViewFactory {

    final OverlayRegistrant registrant;

    NativeViewFactory(OverlayRegistrant registrant) {
        super(StandardMessageCodec.INSTANCE);
        this.registrant = registrant;
    }

    @Override
    public PlatformView create(Context context, int id, Object args) {
        Log.i("SSSS", "Create PlatformView  " + id);

        OverlayView overlay = registrant.fetchOverlay(id);
        if (overlay != null) {
            Log.i("SSSS", "Overlay exists " + id);
            return new NativeView(overlay);
        } else {
            Log.i("SSSS", "Overlay DOES NTO EXIST " + id);
            final NativeView nativeView = new NativeView(context);

            registrant.registerOverlay(id, nativeView);

            return nativeView;
        }
    }
}

