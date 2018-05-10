package com.livefront.bridge;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Base64;
import com.livefront.bridge.wrapper.WrapperUtils;
import java.util.UUID;

public class Bridge {
    private static BridgeDelegate f10024a;

    private static void m8479a() {
        if (f10024a == null) {
            throw new IllegalStateException("You must first call initialize before calling any other methods");
        }
    }

    public static void m8480a(Context context) {
        context = f10024a != null ? f10024a : new BridgeDelegate(context, new NoOpSavedStateHandler());
        context.f10030e.clear();
        context.f10027b.clear();
        context.f10028c.clear();
        context.f10031f.edit().clear().apply();
    }

    public static void m8481a(Context context, SavedStateHandler savedStateHandler) {
        f10024a = new BridgeDelegate(context, savedStateHandler);
    }

    public static void m8482a(Object obj, Bundle bundle) {
        m8479a();
        BridgeDelegate bridgeDelegate = f10024a;
        boolean z = bridgeDelegate.f10026a;
        bridgeDelegate.f10026a = false;
        if (bundle == null) {
            if (z) {
                bridgeDelegate.f10031f.edit().clear().apply();
            }
            return;
        }
        String str;
        Bundle bundle2 = null;
        if (bridgeDelegate.f10028c.containsKey(obj)) {
            str = (String) bridgeDelegate.f10028c.get(obj);
        } else {
            str = bundle.getString(BridgeDelegate.m8484a(obj), null);
        }
        if (str != null) {
            bridgeDelegate.f10028c.put(obj, str);
            if (bridgeDelegate.f10027b.containsKey(str)) {
                bundle2 = (Bundle) bridgeDelegate.f10027b.get(str);
            } else {
                String string = bridgeDelegate.f10031f.getString(BridgeDelegate.m8486b(str), null);
                if (string != null) {
                    byte[] decode = Base64.decode(string, 0);
                    Parcel obtain = Parcel.obtain();
                    obtain.unmarshall(decode, 0, decode.length);
                    obtain.setDataPosition(0);
                    Bundle readBundle = obtain.readBundle(BridgeDelegate.class.getClassLoader());
                    obtain.recycle();
                    bundle2 = readBundle;
                }
            }
            if (bundle2 != null) {
                WrapperUtils.m8491a(bundle2);
                bridgeDelegate.f10029d.mo2633b(obj, bundle2);
                bridgeDelegate.m8488a(str);
            }
        }
    }

    public static void m8483b(Object obj, Bundle bundle) {
        m8479a();
        BridgeDelegate bridgeDelegate = f10024a;
        String str = (String) bridgeDelegate.f10028c.get(obj);
        if (str == null) {
            str = UUID.randomUUID().toString();
            bridgeDelegate.f10028c.put(obj, str);
        }
        bundle.putString(BridgeDelegate.m8484a(obj), str);
        bundle = new Bundle();
        bridgeDelegate.f10029d.mo2632a(obj, bundle);
        if (bundle.isEmpty() == null) {
            WrapperUtils.m8492b(bundle);
            bridgeDelegate.f10030e.add(str);
            bridgeDelegate.f10027b.put(str, bundle);
            obj = Parcel.obtain();
            obj.writeBundle(bundle);
            bridgeDelegate.f10031f.edit().putString(BridgeDelegate.m8486b(str), Base64.encodeToString(obj.marshall(), 0)).apply();
            obj.recycle();
            bridgeDelegate.m8487a();
        }
    }
}
