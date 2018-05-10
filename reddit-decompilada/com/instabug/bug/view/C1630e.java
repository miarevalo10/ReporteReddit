package com.instabug.bug.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v4.app.Fragment;
import android.util.Patterns;
import com.instabug.bug.BugPlugin;
import com.instabug.bug.C0474d;
import com.instabug.bug.extendedbugreport.ExtendedBugReport.State;
import com.instabug.bug.model.Bug;
import com.instabug.bug.model.Bug.BugState;
import com.instabug.bug.model.Bug.ViewHierarchyInspectionState;
import com.instabug.bug.p001b.C0468b;
import com.instabug.bug.p001b.C0468b.C12601;
import com.instabug.bug.p001b.C0468b.C12612;
import com.instabug.bug.screenshot.C1268a;
import com.instabug.bug.screenshot.viewhierarchy.C0484c.C0483a;
import com.instabug.bug.screenshot.viewhierarchy.utilities.ViewHierarchyInspectorEventBus;
import com.instabug.bug.settings.C0485a;
import com.instabug.bug.view.C0514d.C1289a;
import com.instabug.bug.view.C0514d.C1290b;
import com.instabug.bug.view.p003b.C0505a;
import com.instabug.library.C0593R;
import com.instabug.library.Instabug;
import com.instabug.library.InstabugCustomTextPlaceHolder.Key;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.eventbus.ScreenRecordingEventBus;
import com.instabug.library.core.eventbus.VideoProcessingServiceEventBus;
import com.instabug.library.core.ui.BasePresenter;
import com.instabug.library.internal.storage.AttachmentsUtility;
import com.instabug.library.internal.storage.cache.Cache;
import com.instabug.library.internal.storage.cache.CacheManager;
import com.instabug.library.internal.video.InternalScreenRecordHelper;
import com.instabug.library.internal.video.VideoProcessingService.Action;
import com.instabug.library.model.Attachment;
import com.instabug.library.model.Attachment.Type;
import com.instabug.library.screenshot.ExtraScreenshotHelper.OnCaptureListener;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.PermissionsUtils;
import com.instabug.library.util.PlaceHolderUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import rx.functions.Action1;
import rx.subscriptions.CompositeSubscription;

/* compiled from: BugReportingFragmentPresenter */
public class C1630e extends BasePresenter<C1290b> implements C1289a {
    private CompositeSubscription f18514a;
    private C0518a f18515b;

    /* compiled from: BugReportingFragmentPresenter */
    private enum C0518a {
        NONE,
        SEND_BUG,
        TAKE_EXTRA_SCREENSHOT,
        RECORD_VIDEO
    }

    /* compiled from: BugReportingFragmentPresenter */
    class C12912 implements Action1<C0483a> {
        final /* synthetic */ C1630e f15347a;

        C12912(C1630e c1630e) {
            this.f15347a = c1630e;
        }

        public final /* synthetic */ void m15255a(Object obj) {
            C0483a c0483a = (C0483a) obj;
            StringBuilder stringBuilder = new StringBuilder("receive a view hierarchy inspection action, action value: ");
            stringBuilder.append(c0483a);
            InstabugSDKLogger.m8360v(this, stringBuilder.toString());
            if ((c0483a == C0483a.COMPLETED || c0483a == C0483a.FAILED) && this.f15347a.view != null) {
                final C1290b c1290b = (C1290b) this.f15347a.view.get();
                if (c1290b != null) {
                    ((Fragment) c1290b.getViewContext()).getActivity().runOnUiThread(new Runnable(this) {
                        final /* synthetic */ C12912 f9198b;

                        public void run() {
                            c1290b.mo4326f();
                            switch (this.f9198b.f15347a.f18515b) {
                                case SEND_BUG:
                                    this.f9198b.f15347a.mo3644g();
                                    return;
                                case TAKE_EXTRA_SCREENSHOT:
                                    this.f9198b.f15347a.mo3642e();
                                    return;
                                case RECORD_VIDEO:
                                    this.f9198b.f15347a.mo3641d();
                                    break;
                                default:
                                    break;
                            }
                        }
                    });
                }
            }
        }
    }

    public C1630e(C1290b c1290b) {
        super(c1290b);
        if (this.view != null) {
            c1290b = (C1290b) this.view.get();
            if (c1290b != null && VERSION.SDK_INT < 23 && PermissionsUtils.isPermissionGranted(((Fragment) c1290b.getViewContext()).getContext(), "android.permission.RECORD_AUDIO") == null) {
                Instabug.setShouldAudioRecordingOptionAppear(null);
            }
        }
        this.f18515b = C0518a.NONE;
    }

    public final void mo3632a() {
        this.f18514a = new CompositeSubscription();
        this.f18514a.a(ViewHierarchyInspectorEventBus.getInstance().subscribe(new C12912(this)));
    }

    public final void mo3637b() {
        this.f18514a.c();
    }

    public final void mo3635a(String str) {
        C0474d.m7762a().f9100a.getState().setUserEmail(str);
    }

    public final void mo3638b(String str) {
        C0474d.m7762a().f9100a.f15313d = str;
    }

    public final void mo3643f() {
        C0474d.m7762a().f9101b = true;
        if (this.view != null) {
            final C1290b c1290b = (C1290b) this.view.get();
            if (c1290b != null) {
                PermissionsUtils.requestPermission((Fragment) c1290b.getViewContext(), "android.permission.WRITE_EXTERNAL_STORAGE", 3873, null, new Runnable(this) {
                    final /* synthetic */ C1630e f9196b;

                    public void run() {
                        InstabugSDKLogger.m8359i(this.f9196b, "Permission granted");
                        C0474d.m7762a().m7769b();
                        c1290b.mo4324d();
                    }
                });
            }
        }
    }

    public final void mo3642e() {
        if (this.view != null) {
            C1290b c1290b = (C1290b) this.view.get();
            if (C0474d.m7762a().f9100a.f15317h && C0474d.m7762a().f9100a.f15318i == ViewHierarchyInspectionState.IN_PROGRESS) {
                this.f18515b = C0518a.TAKE_EXTRA_SCREENSHOT;
                if (c1290b != null) {
                    c1290b.mo4325e();
                    return;
                }
            }
            C0474d.m7762a().m7769b();
            C0474d.m7762a().f9100a.f15315f = BugState.IN_PROGRESS;
            BugPlugin bugPlugin = (BugPlugin) InstabugCore.getXPlugin(BugPlugin.class);
            if (bugPlugin != null) {
                bugPlugin.setState(2);
                OnCaptureListener a = C1268a.m15217a();
                a.f15330a = new WeakReference(bugPlugin.getAppContext());
                a.f15331b.init(a);
            }
            if (c1290b != null) {
                c1290b.finishActivity();
            }
        }
    }

    public final void mo3641d() {
        if (this.view != null) {
            C1290b c1290b = (C1290b) this.view.get();
            if (C0474d.m7762a().f9100a.f15317h && C0474d.m7762a().f9100a.f15318i == ViewHierarchyInspectionState.IN_PROGRESS) {
                this.f18515b = C0518a.RECORD_VIDEO;
                if (c1290b != null) {
                    c1290b.mo4325e();
                    return;
                }
            }
            C0474d.m7762a().m7769b();
            String id = C0474d.m7762a().f9100a.getId();
            C0468b a = C0468b.m7745a();
            InternalScreenRecordHelper.getInstance().init();
            if (a.f9095a == null || a.f9095a.d()) {
                a.f9095a = ScreenRecordingEventBus.getInstance().subscribe(new C12601(a, id));
            }
            VideoProcessingServiceEventBus.getInstance().subscribe(new C12612(a));
            if (c1290b != null) {
                c1290b.finishActivity();
            }
            BugPlugin bugPlugin = (BugPlugin) InstabugCore.getXPlugin(BugPlugin.class);
            if (bugPlugin != null) {
                bugPlugin.setState(2);
            }
        }
    }

    public final void mo3633a(int i, int i2, Intent intent) {
        if (i == 3862) {
            if (i2 == -1 && intent != null) {
                if (this.view != 0) {
                    C1290b c1290b = (C1290b) this.view.get();
                    if (c1290b != null) {
                        i2 = AttachmentsUtility.getGalleryImagePath(((Fragment) c1290b.getViewContext()).getActivity(), intent.getData());
                        if (i2 == 0) {
                            i2 = intent.getData().getPath();
                        }
                        if (i2 != 0) {
                            C0474d.m7762a().m7768a(((Fragment) c1290b.getViewContext()).getContext(), Uri.fromFile(new File(i2)), null, Type.IMAGE);
                        }
                    }
                }
                C0474d.m7762a().f9101b = false;
            }
        }
    }

    public final void mo3634a(Attachment attachment) {
        C0474d.m7762a().f9100a.f15314e.remove(attachment);
        File file = new File(attachment.getLocalPath());
        if (Type.VIDEO.equals(attachment.getType())) {
            InstabugSDKLogger.m8359i(this, "removing video attachment");
            Cache cache = CacheManager.getInstance().getCache(CacheManager.DEFAULT_IN_MEMORY_CACHE_KEY);
            if (!(cache == null || cache.delete("video.path") == null)) {
                InstabugSDKLogger.m8359i(this, "video attachment removed successfully");
            }
            C0474d.m7762a().f9100a.setHasVideo(false);
            VideoProcessingServiceEventBus.getInstance().post(Action.STOP);
        }
        if (file.delete()) {
            InstabugSDKLogger.m8359i(this, "attachment removed successfully");
        }
        if (this.view != null) {
            C1290b c1290b = (C1290b) this.view.get();
            if (c1290b != null) {
                c1290b.mo4318a(attachment);
            }
        }
    }

    public final void mo3640c() {
        Bug bug = C0474d.m7762a().f9100a;
        if (bug != null && this.view != null) {
            C1290b c1290b = (C1290b) this.view.get();
            if (c1290b != null) {
                c1290b.mo4320a(bug.f15314e);
            }
        }
    }

    public final String mo3639c(String str) {
        return C0505a.m7842a(C0505a.m7843a(str, InstabugCore.getPrimaryColor()));
    }

    public final void mo3644g() {
        if (this.view != null) {
            C1290b c1290b = (C1290b) this.view.get();
            if (c1290b != null) {
                if (C0474d.m7762a().f9100a.f15317h && C0474d.m7762a().f9100a.f15318i == ViewHierarchyInspectionState.IN_PROGRESS) {
                    this.f18515b = C0518a.SEND_BUG;
                    c1290b.mo4325e();
                    return;
                }
                Object obj;
                C1290b c1290b2 = (C1290b) this.view.get();
                String userEmail = C0474d.m7762a().f9100a.getState().getUserEmail();
                C0485a.m7793a();
                Object obj2 = 1;
                if (C0485a.m7815f()) {
                    C0485a.m7793a();
                    if (C0485a.m7818i() && (userEmail == null || !Patterns.EMAIL_ADDRESS.matcher(userEmail).matches())) {
                        c1290b2.mo4319a(PlaceHolderUtils.getPlaceHolder(Key.INVALID_EMAIL_MESSAGE, ((Fragment) c1290b2.getViewContext()).getString(C0593R.string.instabug_err_invalid_email)));
                        obj = null;
                        if (obj == null) {
                            c1290b2 = (C1290b) this.view.get();
                            userEmail = C0474d.m7762a().f9100a.f15313d;
                            C0485a.m7793a();
                            if (C0485a.m7820k() || !(userEmail == null || userEmail.trim().length() == 0)) {
                                obj = 1;
                            } else {
                                c1290b2.mo4322b(PlaceHolderUtils.getPlaceHolder(Key.INVALID_COMMENT_MESSAGE, ((Fragment) c1290b2.getViewContext()).getString(C0593R.string.instabug_err_invalid_comment)));
                                obj = null;
                            }
                            if (obj == null) {
                                C0485a.m7793a();
                                if (C0485a.m7825p().isEmpty()) {
                                    C0485a.m7793a();
                                    if (C0485a.m7826q() != State.DISABLED) {
                                        obj2 = null;
                                    }
                                }
                                if (obj2 != null) {
                                    C0474d.m7762a().m7770b(((Fragment) c1290b.getViewContext()).getContext());
                                    c1290b.mo4321b();
                                } else {
                                    c1290b.mo4323c();
                                }
                                c1290b.mo4316a();
                            }
                        }
                    }
                }
                C0485a.m7793a();
                C0485a.m7806b(userEmail);
                obj = 1;
                if (obj == null) {
                    c1290b2 = (C1290b) this.view.get();
                    userEmail = C0474d.m7762a().f9100a.f15313d;
                    C0485a.m7793a();
                    if (C0485a.m7820k()) {
                    }
                    obj = 1;
                    if (obj == null) {
                        C0485a.m7793a();
                        if (C0485a.m7825p().isEmpty()) {
                            C0485a.m7793a();
                            if (C0485a.m7826q() != State.DISABLED) {
                                obj2 = null;
                            }
                        }
                        if (obj2 != null) {
                            c1290b.mo4323c();
                        } else {
                            C0474d.m7762a().m7770b(((Fragment) c1290b.getViewContext()).getContext());
                            c1290b.mo4321b();
                        }
                        c1290b.mo4316a();
                    }
                }
            }
        }
    }

    public final Attachment mo3631a(ArrayList<Attachment> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            Attachment attachment = (Attachment) arrayList.get(size);
            if (attachment.getType() == Type.VIDEO) {
                return attachment;
            }
        }
        return null;
    }

    public final void mo3636a(ArrayList<Attachment> arrayList, String str) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            Attachment attachment = (Attachment) arrayList.get(size);
            if (attachment.getType() == Type.VIDEO) {
                attachment.setLocalPath(str);
                attachment.setVideoEncoded(true);
                return;
            }
        }
    }
}
