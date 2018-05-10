package com.instabug.survey.ui.p031a.p037a;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.instabug.survey.ui.p031a.C1712b;
import java.util.List;

/* compiled from: QuestionsPagerAdapter */
public class C1671a extends FragmentPagerAdapter {
    private List<C1712b> f18591b;

    public final /* synthetic */ Fragment mo3683a(int i) {
        return m19531c(i);
    }

    public C1671a(FragmentManager fragmentManager, List<C1712b> list) {
        super(fragmentManager);
        this.f18591b = list;
    }

    public final int mo3684c() {
        return this.f18591b.size();
    }

    public final C1712b m19531c(int i) {
        return (C1712b) this.f18591b.get(i);
    }
}
