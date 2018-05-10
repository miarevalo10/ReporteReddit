package com.instabug.bug.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.instabug.bug.BugPlugin;
import com.instabug.bug.C0465R;
import com.instabug.bug.C0469b;
import com.instabug.bug.C0470c;
import com.instabug.bug.C0474d;
import com.instabug.bug.model.C0478b;
import com.instabug.bug.model.ReportCategory;
import com.instabug.bug.view.actionList.C0499a;
import com.instabug.bug.view.actionList.C1707d;
import com.instabug.library.InstabugCustomTextPlaceHolder.Key;
import com.instabug.library._InstabugActivity;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.ui.BaseFragmentActivity;
import com.instabug.library.util.PlaceHolderUtils;
import java.util.ArrayList;
import java.util.List;

public class ReportCategoriesActivity extends BaseFragmentActivity implements _InstabugActivity {
    private BugPlugin f19833a;

    public static Intent m21609a(Context context, C0478b c0478b) {
        Intent intent = new Intent(context, ReportCategoriesActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("report_type", c0478b);
        return intent;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f19833a = (BugPlugin) InstabugCore.getXPlugin(BugPlugin.class);
        if (this.f19833a != null) {
            this.f19833a.setState(1);
        }
    }

    protected int getLayout() {
        return C0465R.layout.instabug_activity_bug_reporting;
    }

    public void onBackPressed() {
        super.onBackPressed();
        C0470c.m7757a();
        if (this.f19833a != null && this.f19833a.getState() != 2) {
            this.f19833a.setState(0);
        }
    }

    protected void initViews() {
        final C0478b c0478b = (C0478b) getIntent().getSerializableExtra("report_type");
        List<ReportCategory> subReportCategories = ReportCategory.getSubReportCategories(c0478b);
        ArrayList arrayList = new ArrayList();
        for (final ReportCategory reportCategory : subReportCategories) {
            arrayList.add(new C0499a(reportCategory.getLabel(), reportCategory.getIcon(), new Runnable(this) {
                final /* synthetic */ ReportCategoriesActivity f9154c;

                public void run() {
                    C0474d.m7762a().f9100a.m15215a(reportCategory.getLabel());
                    if (c0478b == C0478b.FEEDBACK) {
                        this.f9154c.startActivity(C0469b.m7754b(this.f9154c));
                        this.f9154c.finish();
                        return;
                    }
                    if (c0478b == C0478b.BUG) {
                        this.f9154c.startActivity(C0469b.m7753a(this.f9154c));
                        this.f9154c.finish();
                    }
                }
            }));
        }
        String str = null;
        if (c0478b == C0478b.BUG) {
            C0474d.m7762a().f9100a.f15312c = C0478b.BUG;
            str = PlaceHolderUtils.getPlaceHolder(Key.REPORT_BUG, getString(C0465R.string.instabug_str_bug_header));
        } else if (c0478b == C0478b.FEEDBACK) {
            C0474d.m7762a().f9100a.f15312c = C0478b.FEEDBACK;
            str = PlaceHolderUtils.getPlaceHolder(Key.REPORT_FEEDBACK, getString(C0465R.string.instabug_str_feedback_header));
        }
        getSupportFragmentManager().mo219a().mo200b(C0465R.id.instabug_fragment_container, C1707d.m20527a(str, arrayList)).mo203c();
    }
}
