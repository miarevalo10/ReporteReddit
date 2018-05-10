package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Builder;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat.Action;
import android.util.Log;
import android.util.SparseArray;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RequiresApi(16)
class NotificationCompatJellybean {
    private static final Object f1149a = new Object();
    private static Field f1150b;
    private static boolean f1151c;
    private static final Object f1152d = new Object();

    public static SparseArray<Bundle> m689a(List<Bundle> list) {
        int size = list.size();
        SparseArray<Bundle> sparseArray = null;
        for (int i = 0; i < size; i++) {
            Bundle bundle = (Bundle) list.get(i);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                sparseArray.put(i, bundle);
            }
        }
        return sparseArray;
    }

    public static Bundle m688a(Notification notification) {
        synchronized (f1149a) {
            if (f1151c) {
                return null;
            }
            try {
                if (f1150b == null) {
                    Field declaredField = Notification.class.getDeclaredField("extras");
                    if (Bundle.class.isAssignableFrom(declaredField.getType())) {
                        declaredField.setAccessible(true);
                        f1150b = declaredField;
                    } else {
                        Log.e("NotificationCompat", "Notification.extras field is not of type Bundle");
                        f1151c = true;
                        return null;
                    }
                }
                Bundle bundle = (Bundle) f1150b.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    f1150b.set(notification, bundle);
                }
                return bundle;
            } catch (Notification notification2) {
                Log.e("NotificationCompat", "Unable to access notification extras", notification2);
                f1151c = true;
                return null;
            } catch (Notification notification22) {
                Log.e("NotificationCompat", "Unable to access notification extras", notification22);
                f1151c = true;
                return null;
            }
        }
    }

    private static Bundle[] m690a(RemoteInput[] remoteInputArr) {
        if (remoteInputArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[remoteInputArr.length];
        for (int i = 0; i < remoteInputArr.length; i++) {
            RemoteInput remoteInput = remoteInputArr[i];
            Bundle bundle = new Bundle();
            bundle.putString("resultKey", remoteInput.f11398a);
            bundle.putCharSequence("label", remoteInput.f11399b);
            bundle.putCharSequenceArray("choices", remoteInput.f11400c);
            bundle.putBoolean("allowFreeFormInput", remoteInput.f11401d);
            bundle.putBundle("extras", remoteInput.f11402e);
            Set<String> set = remoteInput.f11403f;
            if (!(set == null || set.isEmpty())) {
                ArrayList arrayList = new ArrayList(set.size());
                for (String add : set) {
                    arrayList.add(add);
                }
                bundle.putStringArrayList("allowedDataTypes", arrayList);
            }
            bundleArr[i] = bundle;
        }
        return bundleArr;
    }

    public static Bundle m687a(Builder builder, Action action) {
        builder.addAction(action.f1102e, action.f1103f, action.f1104g);
        builder = new Bundle(action.f1098a);
        if (action.f1099b != null) {
            builder.putParcelableArray("android.support.remoteInputs", m690a(action.f1099b));
        }
        if (action.f1100c != null) {
            builder.putParcelableArray("android.support.dataRemoteInputs", m690a(action.f1100c));
        }
        builder.putBoolean("android.support.allowGeneratedReplies", action.f1101d);
        return builder;
    }
}
