package android.support.v4.app;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.app.SharedElementCallback.OnSharedElementsReadyListener;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import java.util.List;
import java.util.Map;

public class ActivityCompat extends ContextCompat {
    private static PermissionCompatDelegate f11250a;

    public interface OnRequestPermissionsResultCallback {
        void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);
    }

    public interface PermissionCompatDelegate {
        boolean m517a();

        boolean m518b();
    }

    public interface RequestPermissionsRequestCodeValidator {
        void validateRequestPermissionsRequestCode(int i);
    }

    @RequiresApi(21)
    private static class SharedElementCallback21Impl extends SharedElementCallback {
        protected SharedElementCallback f933a;

        public void onMapSharedElements(List<String> list, Map<String, View> map) {
        }

        public void onRejectSharedElements(List<View> list) {
        }

        public void onSharedElementEnd(List<String> list, List<View> list2, List<View> list3) {
        }

        public void onSharedElementStart(List<String> list, List<View> list2, List<View> list3) {
        }

        public SharedElementCallback21Impl(SharedElementCallback sharedElementCallback) {
            this.f933a = sharedElementCallback;
        }

        public Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectF) {
            SharedElementCallback sharedElementCallback = this.f933a;
            if (view instanceof ImageView) {
                ImageView imageView = (ImageView) view;
                Drawable drawable = imageView.getDrawable();
                Drawable background = imageView.getBackground();
                if (drawable != null && background == null) {
                    Parcelable a = SharedElementCallback.m703a(drawable);
                    if (a != null) {
                        view = new Bundle();
                        view.putParcelable("sharedElement:snapshot:bitmap", a);
                        view.putString("sharedElement:snapshot:imageScaleType", imageView.getScaleType().toString());
                        if (imageView.getScaleType() == ScaleType.MATRIX) {
                            rectF = new float[9];
                            imageView.getImageMatrix().getValues(rectF);
                            view.putFloatArray("sharedElement:snapshot:imageMatrix", rectF);
                        }
                        return view;
                    }
                }
            }
            int round = Math.round(rectF.width());
            int round2 = Math.round(rectF.height());
            Parcelable parcelable = null;
            if (round > 0 && round2 > 0) {
                float min = Math.min(1.0f, ((float) SharedElementCallback.f1175b) / ((float) (round * round2)));
                round = (int) (((float) round) * min);
                round2 = (int) (((float) round2) * min);
                if (sharedElementCallback.f1176a == null) {
                    sharedElementCallback.f1176a = new Matrix();
                }
                sharedElementCallback.f1176a.set(matrix);
                sharedElementCallback.f1176a.postTranslate(-rectF.left, -rectF.top);
                sharedElementCallback.f1176a.postScale(min, min);
                parcelable = Bitmap.createBitmap(round, round2, Config.ARGB_8888);
                matrix = new Canvas(parcelable);
                matrix.concat(sharedElementCallback.f1176a);
                view.draw(matrix);
            }
            return parcelable;
        }

        public View onCreateSnapshotView(Context context, Parcelable parcelable) {
            return SharedElementCallback.m704a(context, parcelable);
        }
    }

    @RequiresApi(23)
    private static class SharedElementCallback23Impl extends SharedElementCallback21Impl {
        public SharedElementCallback23Impl(SharedElementCallback sharedElementCallback) {
            super(sharedElementCallback);
        }

        public void onSharedElementsArrived(List<String> list, List<View> list2, final OnSharedElementsReadyListener onSharedElementsReadyListener) {
            SharedElementCallback.m705a(new SharedElementCallback.OnSharedElementsReadyListener(this) {
                final /* synthetic */ SharedElementCallback23Impl f11249b;

                public final void mo190a() {
                    onSharedElementsReadyListener.onSharedElementsReady();
                }
            });
        }
    }

    public static PermissionCompatDelegate m9751a() {
        return f11250a;
    }

    public static void m9753a(Activity activity, Intent intent, int i, Bundle bundle) {
        if (VERSION.SDK_INT >= 16) {
            activity.startActivityForResult(intent, i, bundle);
        } else {
            activity.startActivityForResult(intent, i);
        }
    }

    public static void m9754a(Activity activity, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws SendIntentException {
        if (VERSION.SDK_INT >= 16) {
            activity.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
        } else {
            activity.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
        }
    }

    public static void m9752a(Activity activity) {
        if (VERSION.SDK_INT >= 16) {
            activity.finishAffinity();
        } else {
            activity.finish();
        }
    }

    public static void m9758b(Activity activity) {
        if (VERSION.SDK_INT >= 21) {
            activity.finishAfterTransition();
        } else {
            activity.finish();
        }
    }

    public static void m9755a(Activity activity, SharedElementCallback sharedElementCallback) {
        SharedElementCallback sharedElementCallback2 = null;
        if (VERSION.SDK_INT >= 23) {
            if (sharedElementCallback != null) {
                sharedElementCallback2 = new SharedElementCallback23Impl(sharedElementCallback);
            }
            activity.setEnterSharedElementCallback(sharedElementCallback2);
            return;
        }
        if (VERSION.SDK_INT >= 21) {
            if (sharedElementCallback != null) {
                sharedElementCallback2 = new SharedElementCallback21Impl(sharedElementCallback);
            }
            activity.setEnterSharedElementCallback(sharedElementCallback2);
        }
    }

    public static void m9759b(Activity activity, SharedElementCallback sharedElementCallback) {
        SharedElementCallback sharedElementCallback2 = null;
        if (VERSION.SDK_INT >= 23) {
            if (sharedElementCallback != null) {
                sharedElementCallback2 = new SharedElementCallback23Impl(sharedElementCallback);
            }
            activity.setExitSharedElementCallback(sharedElementCallback2);
            return;
        }
        if (VERSION.SDK_INT >= 21) {
            if (sharedElementCallback != null) {
                sharedElementCallback2 = new SharedElementCallback21Impl(sharedElementCallback);
            }
            activity.setExitSharedElementCallback(sharedElementCallback2);
        }
    }

    public static void m9760c(Activity activity) {
        if (VERSION.SDK_INT >= 21) {
            activity.postponeEnterTransition();
        }
    }

    public static void m9761d(Activity activity) {
        if (VERSION.SDK_INT >= 21) {
            activity.startPostponedEnterTransition();
        }
    }

    public static void m9756a(final Activity activity, final String[] strArr, final int i) {
        if (f11250a != null && f11250a.m517a()) {
            return;
        }
        if (VERSION.SDK_INT >= 23) {
            if (activity instanceof RequestPermissionsRequestCodeValidator) {
                ((RequestPermissionsRequestCodeValidator) activity).validateRequestPermissionsRequestCode(i);
            }
            activity.requestPermissions(strArr, i);
            return;
        }
        if (activity instanceof OnRequestPermissionsResultCallback) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    int[] iArr = new int[strArr.length];
                    PackageManager packageManager = activity.getPackageManager();
                    String packageName = activity.getPackageName();
                    int length = strArr.length;
                    for (int i = 0; i < length; i++) {
                        iArr[i] = packageManager.checkPermission(strArr[i], packageName);
                    }
                    ((OnRequestPermissionsResultCallback) activity).onRequestPermissionsResult(i, strArr, iArr);
                }
            });
        }
    }

    public static boolean m9757a(Activity activity, String str) {
        return VERSION.SDK_INT >= 23 ? activity.shouldShowRequestPermissionRationale(str) : null;
    }
}
