package com.instabug.bug.screenshot.viewhierarchy;

import android.app.Activity;
import android.net.Uri;
import com.instabug.bug.C0474d;
import com.instabug.bug.model.Bug.ViewHierarchyInspectionState;
import com.instabug.bug.screenshot.viewhierarchy.C0484c.C0483a;
import com.instabug.bug.screenshot.viewhierarchy.utilities.BitmapUtils;
import com.instabug.bug.screenshot.viewhierarchy.utilities.ViewHierarchyDiskUtils;
import com.instabug.bug.screenshot.viewhierarchy.utilities.ViewHierarchyInspectorEventBus;
import com.instabug.library.C0593R;
import com.instabug.library.instacapture.screenshot.FieldHelper;
import com.instabug.library.instacapture.screenshot.RootViewInfo;
import com.instabug.library.internal.storage.DiskUtils;
import com.instabug.library.model.Attachment.Type;
import com.instabug.library.util.InstabugMemoryUtils;
import com.instabug.library.util.InstabugSDKLogger;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Actions;
import rx.functions.Func1;
import rx.internal.operators.OnSubscribeDoOnEach;
import rx.internal.operators.OperatorDoOnSubscribe;
import rx.internal.operators.OperatorDoOnUnsubscribe;
import rx.internal.util.ActionObserver;
import rx.schedulers.Schedulers;

/* compiled from: ActivityViewInspector */
public class C0481a {
    private static Subscription f9117a;

    /* compiled from: ActivityViewInspector */
    private static class C0480a {
        int f9116a;

        private C0480a() {
            this.f9116a = 0;
        }

        final boolean m7779a() {
            return this.f9116a > 0;
        }
    }

    /* compiled from: ActivityViewInspector */
    static class C12736 implements Func1<C0482b, Observable<C0482b>> {
        C12736() {
        }

        public final /* synthetic */ Object call(Object obj) {
            return !InstabugMemoryUtils.isLowMemory() ? BitmapUtils.captureViewHierarchyRx((C0482b) obj).b(AndroidSchedulers.a()).a(Schedulers.d()) : null;
        }
    }

    public static synchronized void m7781a(final Activity activity) {
        synchronized (C0481a.class) {
            if (C0474d.m7762a().f9100a != null) {
                C0474d.m7762a().f9100a.f15318i = ViewHierarchyInspectionState.IN_PROGRESS;
            }
            int i = 0;
            final C0480a c0480a = new C0480a();
            ViewHierarchyInspectorEventBus.getInstance().post(C0483a.STARTED);
            StringBuilder stringBuilder = new StringBuilder("inspect activity view start, time in MS: ");
            stringBuilder.append(System.currentTimeMillis());
            InstabugSDKLogger.m8360v(C0481a.class, stringBuilder.toString());
            final C0482b c0482b = new C0482b();
            c0482b.f9131n = activity.getWindow().getDecorView();
            try {
                c0482b.f9122e = C0484c.m7786a(activity, C0481a.m7782b(activity));
            } catch (Throwable e) {
                StringBuilder stringBuilder2 = new StringBuilder("inspect activity frame got error");
                stringBuilder2.append(e.getMessage());
                stringBuilder2.append(", time in MS: ");
                stringBuilder2.append(System.currentTimeMillis());
                InstabugSDKLogger.m8358e(C0481a.class, stringBuilder2.toString(), e);
            }
            List rootViews = FieldHelper.getRootViews(activity, new int[]{C0593R.id.instabug_decor_view, C0593R.id.instabug_in_app_notification, C0593R.id.instabug_intro_dialog});
            StringBuilder stringBuilder3 = new StringBuilder("root views size: ");
            stringBuilder3.append(rootViews.size());
            InstabugSDKLogger.m8360v(C0481a.class, stringBuilder3.toString());
            if (rootViews.size() > 0) {
                c0482b.f9125h = true;
            }
            Observable[] observableArr = new Observable[rootViews.size()];
            while (i < rootViews.size()) {
                C0482b c0482b2 = new C0482b();
                c0482b2.f9118a = String.valueOf(i);
                c0482b2.f9131n = ((RootViewInfo) rootViews.get(i)).getView();
                c0482b2.f9126i = true;
                c0482b2.f9132o = C0481a.m7782b(activity);
                observableArr[i] = C0484c.m7787a(c0482b2);
                i++;
            }
            if (!(f9117a == null || f9117a.d())) {
                f9117a.c();
            }
            f9117a = Observable.a(new Subscriber<C0482b>() {
                public final /* synthetic */ void a_(Object obj) {
                    C0482b c0482b = (C0482b) obj;
                    StringBuilder stringBuilder = new StringBuilder("view hierarchy image saved successfully, uri: ");
                    stringBuilder.append(c0482b.f9128k);
                    InstabugSDKLogger.m8360v(C0481a.class, stringBuilder.toString());
                }

                public final void m19373b() {
                    StringBuilder stringBuilder = new StringBuilder("activity view inspection done successfully, time in MS: ");
                    stringBuilder.append(System.currentTimeMillis());
                    InstabugSDKLogger.m8360v(C0481a.class, stringBuilder.toString());
                    if (C0474d.m7762a().f9100a != null) {
                        C0474d.m7762a().f9100a.f15316g = C0481a.m7783b(c0482b).toString();
                        C0474d.m7762a().f9100a.f15318i = ViewHierarchyInspectionState.DONE;
                    }
                    ViewHierarchyInspectorEventBus.getInstance().post(C0483a.COMPLETED);
                }

                public final void m19372a(Throwable th) {
                    StringBuilder stringBuilder = new StringBuilder("activity view inspection got error: ");
                    stringBuilder.append(th.getMessage());
                    stringBuilder.append(", time in MS: ");
                    stringBuilder.append(System.currentTimeMillis());
                    InstabugSDKLogger.m8358e(C0481a.class, stringBuilder.toString(), th);
                    if (C0474d.m7762a().f9100a != null) {
                        C0474d.m7762a().f9100a.f15318i = ViewHierarchyInspectionState.FAILED;
                    }
                    ViewHierarchyInspectorEventBus.getInstance().post(C0483a.FAILED);
                }
            }, Observable.a(new OnSubscribeDoOnEach(Observable.a(new OnSubscribeDoOnEach(Observable.a(observableArr).a(new Func1<C0482b, Observable<C0482b>>() {
                public final /* synthetic */ Object call(Object obj) {
                    C0482b c0482b = (C0482b) obj;
                    c0482b.m7784a(c0482b);
                    return !InstabugMemoryUtils.isLowMemory() ? Observable.a(C0484c.m7789b(c0482b)) : null;
                }
            }).a(new C12736()), new ActionObserver(new Action1<C0482b>() {
                public final /* synthetic */ void m15221a(Object obj) {
                    C0482b c0482b = (C0482b) obj;
                    StringBuilder stringBuilder = new StringBuilder("doOnNext called, time in MS: ");
                    stringBuilder.append(System.currentTimeMillis());
                    InstabugSDKLogger.m8360v(C0481a.class, stringBuilder.toString());
                    if (c0480a.m7779a() && c0482b.f9127j != null) {
                        stringBuilder = new StringBuilder("viewHierarchy image not equal null, starting save image on disk, viewHierarchyId: ");
                        stringBuilder.append(c0482b.f9118a);
                        stringBuilder.append(", time in MS: ");
                        stringBuilder.append(System.currentTimeMillis());
                        InstabugSDKLogger.m8360v(C0481a.class, stringBuilder.toString());
                        ViewHierarchyDiskUtils.saveViewHierarchyImage(c0482b);
                        c0482b.f9127j = null;
                    }
                }
            }, Actions.a(), Actions.a()))), new ActionObserver(Actions.a(), Actions.a(), new Action0() {
                public final void m15220a() {
                    StringBuilder stringBuilder = new StringBuilder("doOnCompleted called, time in MS: ");
                    stringBuilder.append(System.currentTimeMillis());
                    InstabugSDKLogger.m8360v(C0481a.class, stringBuilder.toString());
                    if (c0480a.m7779a()) {
                        Uri zipViewHierarchyImages = ViewHierarchyDiskUtils.zipViewHierarchyImages(c0482b);
                        if (zipViewHierarchyImages != null) {
                            StringBuilder stringBuilder2 = new StringBuilder("viewHierarchy images zipped successfully, zip file uri: ");
                            stringBuilder2.append(zipViewHierarchyImages.toString());
                            stringBuilder2.append(", time in MS: ");
                            stringBuilder2.append(System.currentTimeMillis());
                            InstabugSDKLogger.m8360v(C0481a.class, stringBuilder2.toString());
                        }
                        if (C0474d.m7762a().f9100a != null && zipViewHierarchyImages != null) {
                            C0474d.m7762a().f9100a.m15214a(zipViewHierarchyImages, Type.VIEW_HIERARCHY);
                        }
                    }
                }
            }))).a(new OperatorDoOnSubscribe(new Action0() {
                public final void m15219a() {
                    StringBuilder stringBuilder = new StringBuilder("subscribe called, time in MS: ");
                    stringBuilder.append(System.currentTimeMillis());
                    InstabugSDKLogger.m8360v(C0481a.class, stringBuilder.toString());
                    C0480a c0480a = c0480a;
                    c0480a.f9116a++;
                }
            })).a(new OperatorDoOnUnsubscribe(new Action0() {
                public final void m15218a() {
                    StringBuilder stringBuilder = new StringBuilder("un-subscribe called, time in MS: ");
                    stringBuilder.append(System.currentTimeMillis());
                    InstabugSDKLogger.m8360v(C0481a.class, stringBuilder.toString());
                    C0480a c0480a = c0480a;
                    c0480a.f9116a--;
                    if (!c0480a.m7779a()) {
                        DiskUtils.cleanDirectory(ViewHierarchyDiskUtils.getViewHierarchyImagesDirectory(activity));
                    }
                }
            })).b(AndroidSchedulers.a()).a(Schedulers.d()));
        }
    }

    private static JSONObject m7783b(C0482b c0482b) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (c0482b.f9118a != null) {
                jSONObject.put("id", c0482b.f9118a);
            }
            if (c0482b.f9119b != null) {
                jSONObject.put("icon", c0482b.f9119b);
            }
            if (c0482b.f9120c != null) {
                jSONObject.put("type", c0482b.f9120c);
            }
            if (c0482b.f9121d != null) {
                jSONObject.put("properties", c0482b.f9121d);
            }
            if (c0482b.f9122e != null) {
                jSONObject.put("frame", c0482b.f9122e);
            }
            if (c0482b.f9124g != null && c0482b.f9125h) {
                JSONArray jSONArray = new JSONArray();
                c0482b = c0482b.f9124g.iterator();
                while (c0482b.hasNext()) {
                    jSONArray.put(C0481a.m7783b((C0482b) c0482b.next()));
                }
                jSONObject.put("nodes", jSONArray);
            }
        } catch (C0482b c0482b2) {
            StringBuilder stringBuilder = new StringBuilder("convert seed view hierarchy to json got json exception: ");
            stringBuilder.append(c0482b2.getMessage());
            stringBuilder.append(", time in MS: ");
            stringBuilder.append(System.currentTimeMillis());
            InstabugSDKLogger.m8358e(C0481a.class, stringBuilder.toString(), c0482b2);
        }
        return jSONObject;
    }

    private static int m7782b(Activity activity) {
        activity = activity.getWindow().getDecorView();
        activity = activity.getHeight() > activity.getWidth() ? activity.getHeight() : activity.getWidth();
        return activity > 640 ? activity / 640 : 1;
    }
}
