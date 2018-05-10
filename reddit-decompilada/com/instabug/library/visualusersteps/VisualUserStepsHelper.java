package com.instabug.library.visualusersteps;

import android.content.Context;
import android.net.Uri;
import com.instabug.library.internal.storage.AttachmentManager;
import com.instabug.library.tracking.InstabugInternalTrackingDelegate;
import com.instabug.library.util.DiskUtils;
import java.io.File;
import java.util.ArrayList;
import rx.Observable;
import rx.functions.Func0;

public class VisualUserStepsHelper {
    private static Uri getVisualUserStepsFile(Context context, String str) {
        ArrayList listFilesInDirectory = DiskUtils.listFilesInDirectory(getVisualUserStepsDirectory(InstabugInternalTrackingDelegate.getInstance().getTargetActivity()));
        StringBuilder stringBuilder = new StringBuilder("usersteps_");
        stringBuilder.append(str);
        return DiskUtils.zipFiles(context, stringBuilder.toString(), listFilesInDirectory);
    }

    static File getVisualUserStepsDirectory(Context context) {
        return AttachmentManager.getNewDirectory(context, "usersteps");
    }

    public static Observable<Uri> getVisualUserStepsFileObservable(final Context context, final String str) {
        return Observable.a(new Func0<Observable<Uri>>() {
            public final /* synthetic */ Object call() {
                return Observable.b(VisualUserStepsHelper.getVisualUserStepsFile(context, str));
            }
        });
    }
}
