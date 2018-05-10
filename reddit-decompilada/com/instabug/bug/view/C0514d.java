package com.instabug.bug.view;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.instabug.library.core.ui.BaseContract.Presenter;
import com.instabug.library.core.ui.BaseContract.View;
import com.instabug.library.model.Attachment;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BugReportingFragmentContract */
public interface C0514d {

    /* compiled from: BugReportingFragmentContract */
    public interface C1289a extends Presenter {
        Attachment mo3631a(ArrayList<Attachment> arrayList);

        void mo3632a();

        void mo3633a(int i, int i2, Intent intent);

        void mo3634a(Attachment attachment);

        void mo3635a(String str);

        void mo3636a(ArrayList<Attachment> arrayList, String str);

        void mo3637b();

        void mo3638b(String str);

        String mo3639c(String str);

        void mo3640c();

        void mo3641d();

        void mo3642e();

        void mo3643f();

        void mo3644g();
    }

    /* compiled from: BugReportingFragmentContract */
    public interface C1290b extends View<Fragment> {
        void mo4316a();

        void mo4318a(Attachment attachment);

        void mo4319a(String str);

        void mo4320a(List<Attachment> list);

        void mo4321b();

        void mo4322b(String str);

        void mo4323c();

        void mo4324d();

        void mo4325e();

        void mo4326f();
    }
}
