package android.support.v7.widget;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri.Builder;
import android.support.v4.widget.ResourceCursorAdapter;
import android.support.v7.appcompat.C0164R;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.WeakHashMap;

class SuggestionsAdapter extends ResourceCursorAdapter implements OnClickListener {
    int f18868j = 1;
    private final SearchManager f18869k = ((SearchManager) this.d.getSystemService("search"));
    private final SearchView f18870l;
    private final SearchableInfo f18871m;
    private final Context f18872n;
    private final WeakHashMap<String, ConstantState> f18873o;
    private final int f18874p;
    private boolean f18875q = false;
    private ColorStateList f18876r;
    private int f18877s = -1;
    private int f18878t = -1;
    private int f18879u = -1;
    private int f18880v = -1;
    private int f18881w = -1;
    private int f18882x = -1;

    private static final class ChildViewCache {
        public final TextView f2531a;
        public final TextView f2532b;
        public final ImageView f2533c;
        public final ImageView f2534d;
        public final ImageView f2535e;

        public ChildViewCache(View view) {
            this.f2531a = (TextView) view.findViewById(16908308);
            this.f2532b = (TextView) view.findViewById(16908309);
            this.f2533c = (ImageView) view.findViewById(16908295);
            this.f2534d = (ImageView) view.findViewById(16908296);
            this.f2535e = (ImageView) view.findViewById(C0164R.id.edit_query);
        }
    }

    public boolean hasStableIds() {
        return false;
    }

    public SuggestionsAdapter(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout());
        this.f18870l = searchView;
        this.f18871m = searchableInfo;
        this.f18874p = searchView.getSuggestionCommitIconResId();
        this.f18872n = context;
        this.f18873o = weakHashMap;
    }

    public final Cursor mo384a(CharSequence charSequence) {
        charSequence = charSequence == null ? "" : charSequence.toString();
        if (this.f18870l.getVisibility() == 0) {
            if (this.f18870l.getWindowVisibility() == 0) {
                try {
                    SearchableInfo searchableInfo = this.f18871m;
                    if (searchableInfo != null) {
                        String suggestAuthority = searchableInfo.getSuggestAuthority();
                        if (suggestAuthority != null) {
                            String[] strArr;
                            Builder fragment = new Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
                            String suggestPath = searchableInfo.getSuggestPath();
                            if (suggestPath != null) {
                                fragment.appendEncodedPath(suggestPath);
                            }
                            fragment.appendPath("search_suggest_query");
                            String suggestSelection = searchableInfo.getSuggestSelection();
                            if (suggestSelection != null) {
                                strArr = new String[]{charSequence};
                            } else {
                                fragment.appendPath(charSequence);
                                strArr = null;
                            }
                            fragment.appendQueryParameter("limit", "50");
                            charSequence = this.d.getContentResolver().query(fragment.build(), null, suggestSelection, strArr, null);
                            if (charSequence != null) {
                                charSequence.getCount();
                                return charSequence;
                            }
                            return null;
                        }
                    }
                    charSequence = null;
                    if (charSequence != null) {
                        charSequence.getCount();
                        return charSequence;
                    }
                } catch (CharSequence charSequence2) {
                    Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", charSequence2);
                }
                return null;
            }
        }
        return null;
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        m19968c(mo383a());
    }

    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        m19968c(mo383a());
    }

    private static void m19968c(Cursor cursor) {
        cursor = cursor != null ? cursor.getExtras() : null;
        if (cursor != null && cursor.getBoolean("in_progress") == null) {
        }
    }

    public final void mo385a(Cursor cursor) {
        if (this.f18875q) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
            }
            return;
        }
        try {
            super.mo385a(cursor);
            if (cursor != null) {
                this.f18877s = cursor.getColumnIndex("suggest_text_1");
                this.f18878t = cursor.getColumnIndex("suggest_text_2");
                this.f18879u = cursor.getColumnIndex("suggest_text_2_url");
                this.f18880v = cursor.getColumnIndex("suggest_icon_1");
                this.f18881w = cursor.getColumnIndex("suggest_icon_2");
                this.f18882x = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Cursor cursor2) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", cursor2);
        }
    }

    public final View mo3158a(Context context, Cursor cursor, ViewGroup viewGroup) {
        context = super.mo3158a(context, cursor, viewGroup);
        context.setTag(new ChildViewCache(context));
        ((ImageView) context.findViewById(C0164R.id.edit_query)).setImageResource(this.f18874p);
        return context;
    }

    public final void mo3852a(View view, Cursor cursor) {
        Cursor cursor2 = cursor;
        ChildViewCache childViewCache = (ChildViewCache) view.getTag();
        int i = this.f18882x != -1 ? cursor2.getInt(r0.f18882x) : 0;
        if (childViewCache.f2531a != null) {
            m19964a(childViewCache.f2531a, m19961a(cursor2, r0.f18877s));
        }
        if (childViewCache.f2532b != null) {
            CharSequence spannableString;
            CharSequence a = m19961a(cursor2, r0.f18879u);
            if (a != null) {
                if (r0.f18876r == null) {
                    TypedValue typedValue = new TypedValue();
                    r0.d.getTheme().resolveAttribute(C0164R.attr.textColorSearchUrl, typedValue, true);
                    r0.f18876r = r0.d.getResources().getColorStateList(typedValue.resourceId);
                }
                spannableString = new SpannableString(a);
                TextAppearanceSpan textAppearanceSpan = r10;
                TextAppearanceSpan textAppearanceSpan2 = new TextAppearanceSpan(null, 0, 0, r0.f18876r, null);
                spannableString.setSpan(textAppearanceSpan, 0, a.length(), 33);
            } else {
                spannableString = m19961a(cursor2, r0.f18878t);
            }
            if (TextUtils.isEmpty(spannableString)) {
                if (childViewCache.f2531a != null) {
                    childViewCache.f2531a.setSingleLine(false);
                    childViewCache.f2531a.setMaxLines(2);
                }
            } else if (childViewCache.f2531a != null) {
                childViewCache.f2531a.setSingleLine(true);
                childViewCache.f2531a.setMaxLines(1);
            }
            m19964a(childViewCache.f2532b, spannableString);
        }
        Drawable drawable = null;
        if (childViewCache.f2533c != null) {
            Drawable drawable2;
            ImageView imageView = childViewCache.f2533c;
            if (r0.f18880v == -1) {
                drawable2 = null;
            } else {
                drawable2 = m19960a(cursor2.getString(r0.f18880v));
                if (drawable2 == null) {
                    ComponentName searchActivity = r0.f18871m.getSearchActivity();
                    String flattenToShortString = searchActivity.flattenToShortString();
                    if (r0.f18873o.containsKey(flattenToShortString)) {
                        ConstantState constantState = (ConstantState) r0.f18873o.get(flattenToShortString);
                        if (constantState == null) {
                            drawable2 = null;
                        } else {
                            drawable2 = constantState.newDrawable(r0.f18872n.getResources());
                        }
                    } else {
                        Object obj;
                        drawable2 = m19958a(searchActivity);
                        if (drawable2 == null) {
                            obj = null;
                        } else {
                            obj = drawable2.getConstantState();
                        }
                        r0.f18873o.put(flattenToShortString, obj);
                    }
                    if (drawable2 == null) {
                        drawable2 = r0.d.getPackageManager().getDefaultActivityIcon();
                    }
                }
            }
            m19963a(imageView, drawable2, 4);
        }
        if (childViewCache.f2534d != null) {
            imageView = childViewCache.f2534d;
            if (r0.f18881w != -1) {
                drawable = m19960a(cursor2.getString(r0.f18881w));
            }
            m19963a(imageView, drawable, 8);
        }
        if (r0.f18868j != 2) {
            if (r0.f18868j != 1 || (i & 1) == 0) {
                childViewCache.f2535e.setVisibility(8);
                return;
            }
        }
        childViewCache.f2535e.setVisibility(0);
        childViewCache.f2535e.setTag(childViewCache.f2531a.getText());
        childViewCache.f2535e.setOnClickListener(r0);
    }

    public void onClick(View view) {
        view = view.getTag();
        if (view instanceof CharSequence) {
            this.f18870l.onQueryRefine((CharSequence) view);
        }
    }

    private static void m19964a(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence) != null) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(null);
        }
    }

    private static void m19963a(ImageView imageView, Drawable drawable, int i) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    public final CharSequence mo386b(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        CharSequence a = m19962a(cursor, "suggest_intent_query");
        if (a != null) {
            return a;
        }
        if (this.f18871m.shouldRewriteQueryFromData()) {
            a = m19962a(cursor, "suggest_intent_data");
            if (a != null) {
                return a;
            }
        }
        if (this.f18871m.shouldRewriteQueryFromText()) {
            cursor = m19962a(cursor, "suggest_text_1");
            if (cursor != null) {
                return cursor;
            }
        }
        return null;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i, view, viewGroup);
        } catch (int i2) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", i2);
            view = mo3158a(this.d, this.c, viewGroup);
            if (view != null) {
                ((ChildViewCache) view.getTag()).f2531a.setText(i2.toString());
            }
            return view;
        }
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i, view, viewGroup);
        } catch (int i2) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", i2);
            view = mo3159b(this.d, this.c, viewGroup);
            if (view != null) {
                ((ChildViewCache) view.getTag()).f2531a.setText(i2.toString());
            }
            return view;
        }
    }

    private android.graphics.drawable.Drawable m19960a(java.lang.String r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r4 = this;
        r0 = 0;
        if (r5 == 0) goto L_0x006a;
    L_0x0003:
        r1 = r5.isEmpty();
        if (r1 != 0) goto L_0x006a;
    L_0x0009:
        r1 = "0";
        r1 = r1.equals(r5);
        if (r1 == 0) goto L_0x0012;
    L_0x0011:
        goto L_0x006a;
    L_0x0012:
        r1 = java.lang.Integer.parseInt(r5);	 Catch:{ NumberFormatException -> 0x0057, NotFoundException -> 0x0043 }
        r2 = new java.lang.StringBuilder;	 Catch:{ NumberFormatException -> 0x0057, NotFoundException -> 0x0043 }
        r3 = "android.resource://";	 Catch:{ NumberFormatException -> 0x0057, NotFoundException -> 0x0043 }
        r2.<init>(r3);	 Catch:{ NumberFormatException -> 0x0057, NotFoundException -> 0x0043 }
        r3 = r4.f18872n;	 Catch:{ NumberFormatException -> 0x0057, NotFoundException -> 0x0043 }
        r3 = r3.getPackageName();	 Catch:{ NumberFormatException -> 0x0057, NotFoundException -> 0x0043 }
        r2.append(r3);	 Catch:{ NumberFormatException -> 0x0057, NotFoundException -> 0x0043 }
        r3 = "/";	 Catch:{ NumberFormatException -> 0x0057, NotFoundException -> 0x0043 }
        r2.append(r3);	 Catch:{ NumberFormatException -> 0x0057, NotFoundException -> 0x0043 }
        r2.append(r1);	 Catch:{ NumberFormatException -> 0x0057, NotFoundException -> 0x0043 }
        r2 = r2.toString();	 Catch:{ NumberFormatException -> 0x0057, NotFoundException -> 0x0043 }
        r3 = r4.m19967b(r2);	 Catch:{ NumberFormatException -> 0x0057, NotFoundException -> 0x0043 }
        if (r3 == 0) goto L_0x0039;	 Catch:{ NumberFormatException -> 0x0057, NotFoundException -> 0x0043 }
    L_0x0038:
        return r3;	 Catch:{ NumberFormatException -> 0x0057, NotFoundException -> 0x0043 }
    L_0x0039:
        r3 = r4.f18872n;	 Catch:{ NumberFormatException -> 0x0057, NotFoundException -> 0x0043 }
        r1 = android.support.v4.content.ContextCompat.m714a(r3, r1);	 Catch:{ NumberFormatException -> 0x0057, NotFoundException -> 0x0043 }
        r4.m19965a(r2, r1);	 Catch:{ NumberFormatException -> 0x0057, NotFoundException -> 0x0043 }
        return r1;
    L_0x0043:
        r1 = "SuggestionsAdapter";
        r2 = new java.lang.StringBuilder;
        r3 = "Icon resource not found: ";
        r2.<init>(r3);
        r2.append(r5);
        r5 = r2.toString();
        android.util.Log.w(r1, r5);
        return r0;
    L_0x0057:
        r0 = r4.m19967b(r5);
        if (r0 == 0) goto L_0x005e;
    L_0x005d:
        return r0;
    L_0x005e:
        r0 = android.net.Uri.parse(r5);
        r0 = r4.m19959a(r0);
        r4.m19965a(r5, r0);
        return r0;
    L_0x006a:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.SuggestionsAdapter.a(java.lang.String):android.graphics.drawable.Drawable");
    }

    private android.graphics.drawable.Drawable m19959a(android.net.Uri r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r6 = this;
        r0 = 0;
        r1 = r7.getScheme();	 Catch:{ FileNotFoundException -> 0x007d }
        r2 = "android.resource";	 Catch:{ FileNotFoundException -> 0x007d }
        r1 = r2.equals(r1);	 Catch:{ FileNotFoundException -> 0x007d }
        if (r1 == 0) goto L_0x0026;
    L_0x000d:
        r1 = r6.m19966b(r7);	 Catch:{ NotFoundException -> 0x0012 }
        return r1;
    L_0x0012:
        r1 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x007d }
        r2 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x007d }
        r3 = "Resource does not exist: ";	 Catch:{ FileNotFoundException -> 0x007d }
        r2.<init>(r3);	 Catch:{ FileNotFoundException -> 0x007d }
        r2.append(r7);	 Catch:{ FileNotFoundException -> 0x007d }
        r2 = r2.toString();	 Catch:{ FileNotFoundException -> 0x007d }
        r1.<init>(r2);	 Catch:{ FileNotFoundException -> 0x007d }
        throw r1;	 Catch:{ FileNotFoundException -> 0x007d }
    L_0x0026:
        r1 = r6.f18872n;	 Catch:{ FileNotFoundException -> 0x007d }
        r1 = r1.getContentResolver();	 Catch:{ FileNotFoundException -> 0x007d }
        r1 = r1.openInputStream(r7);	 Catch:{ FileNotFoundException -> 0x007d }
        if (r1 != 0) goto L_0x0046;	 Catch:{ FileNotFoundException -> 0x007d }
    L_0x0032:
        r1 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x007d }
        r2 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x007d }
        r3 = "Failed to open ";	 Catch:{ FileNotFoundException -> 0x007d }
        r2.<init>(r3);	 Catch:{ FileNotFoundException -> 0x007d }
        r2.append(r7);	 Catch:{ FileNotFoundException -> 0x007d }
        r2 = r2.toString();	 Catch:{ FileNotFoundException -> 0x007d }
        r1.<init>(r2);	 Catch:{ FileNotFoundException -> 0x007d }
        throw r1;	 Catch:{ FileNotFoundException -> 0x007d }
    L_0x0046:
        r2 = android.graphics.drawable.Drawable.createFromStream(r1, r0);	 Catch:{ all -> 0x0063 }
        r1.close();	 Catch:{ IOException -> 0x004e }
        goto L_0x0062;
    L_0x004e:
        r1 = move-exception;
        r3 = "SuggestionsAdapter";	 Catch:{ FileNotFoundException -> 0x007d }
        r4 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x007d }
        r5 = "Error closing icon stream for ";	 Catch:{ FileNotFoundException -> 0x007d }
        r4.<init>(r5);	 Catch:{ FileNotFoundException -> 0x007d }
        r4.append(r7);	 Catch:{ FileNotFoundException -> 0x007d }
        r4 = r4.toString();	 Catch:{ FileNotFoundException -> 0x007d }
        android.util.Log.e(r3, r4, r1);	 Catch:{ FileNotFoundException -> 0x007d }
    L_0x0062:
        return r2;
    L_0x0063:
        r2 = move-exception;
        r1.close();	 Catch:{ IOException -> 0x0068 }
        goto L_0x007c;
    L_0x0068:
        r1 = move-exception;
        r3 = "SuggestionsAdapter";	 Catch:{ FileNotFoundException -> 0x007d }
        r4 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x007d }
        r5 = "Error closing icon stream for ";	 Catch:{ FileNotFoundException -> 0x007d }
        r4.<init>(r5);	 Catch:{ FileNotFoundException -> 0x007d }
        r4.append(r7);	 Catch:{ FileNotFoundException -> 0x007d }
        r4 = r4.toString();	 Catch:{ FileNotFoundException -> 0x007d }
        android.util.Log.e(r3, r4, r1);	 Catch:{ FileNotFoundException -> 0x007d }
    L_0x007c:
        throw r2;	 Catch:{ FileNotFoundException -> 0x007d }
    L_0x007d:
        r1 = move-exception;
        r2 = "SuggestionsAdapter";
        r3 = new java.lang.StringBuilder;
        r4 = "Icon not found: ";
        r3.<init>(r4);
        r3.append(r7);
        r7 = ", ";
        r3.append(r7);
        r7 = r1.getMessage();
        r3.append(r7);
        r7 = r3.toString();
        android.util.Log.w(r2, r7);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.SuggestionsAdapter.a(android.net.Uri):android.graphics.drawable.Drawable");
    }

    private Drawable m19967b(String str) {
        ConstantState constantState = (ConstantState) this.f18873o.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    private void m19965a(String str, Drawable drawable) {
        if (drawable != null) {
            this.f18873o.put(str, drawable.getConstantState());
        }
    }

    private Drawable m19958a(ComponentName componentName) {
        PackageManager packageManager = this.d.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            StringBuilder stringBuilder = new StringBuilder("Invalid icon resource ");
            stringBuilder.append(iconResource);
            stringBuilder.append(" for ");
            stringBuilder.append(componentName.flattenToShortString());
            Log.w("SuggestionsAdapter", stringBuilder.toString());
            return null;
        } catch (ComponentName componentName2) {
            Log.w("SuggestionsAdapter", componentName2.toString());
            return null;
        }
    }

    public static String m19962a(Cursor cursor, String str) {
        return m19961a(cursor, cursor.getColumnIndex(str));
    }

    private static String m19961a(Cursor cursor, int i) {
        if (i == -1) {
            return null;
        }
        try {
            return cursor.getString(i);
        } catch (Cursor cursor2) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", cursor2);
            return null;
        }
    }

    private android.graphics.drawable.Drawable m19966b(android.net.Uri r8) throws java.io.FileNotFoundException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r7 = this;
        r0 = r8.getAuthority();
        r1 = android.text.TextUtils.isEmpty(r0);
        if (r1 == 0) goto L_0x001e;
    L_0x000a:
        r0 = new java.io.FileNotFoundException;
        r1 = new java.lang.StringBuilder;
        r2 = "No authority: ";
        r1.<init>(r2);
        r1.append(r8);
        r8 = r1.toString();
        r0.<init>(r8);
        throw r0;
    L_0x001e:
        r1 = r7.d;	 Catch:{ NameNotFoundException -> 0x00ab }
        r1 = r1.getPackageManager();	 Catch:{ NameNotFoundException -> 0x00ab }
        r1 = r1.getResourcesForApplication(r0);	 Catch:{ NameNotFoundException -> 0x00ab }
        r2 = r8.getPathSegments();
        if (r2 != 0) goto L_0x0042;
    L_0x002e:
        r0 = new java.io.FileNotFoundException;
        r1 = new java.lang.StringBuilder;
        r2 = "No path: ";
        r1.<init>(r2);
        r1.append(r8);
        r8 = r1.toString();
        r0.<init>(r8);
        throw r0;
    L_0x0042:
        r3 = r2.size();
        r4 = 0;
        r5 = 1;
        if (r3 != r5) goto L_0x0069;
    L_0x004a:
        r0 = r2.get(r4);	 Catch:{ NumberFormatException -> 0x0055 }
        r0 = (java.lang.String) r0;	 Catch:{ NumberFormatException -> 0x0055 }
        r0 = java.lang.Integer.parseInt(r0);	 Catch:{ NumberFormatException -> 0x0055 }
        goto L_0x007c;
    L_0x0055:
        r0 = new java.io.FileNotFoundException;
        r1 = new java.lang.StringBuilder;
        r2 = "Single path segment is not a resource ID: ";
        r1.<init>(r2);
        r1.append(r8);
        r8 = r1.toString();
        r0.<init>(r8);
        throw r0;
    L_0x0069:
        r6 = 2;
        if (r3 != r6) goto L_0x0097;
    L_0x006c:
        r3 = r2.get(r5);
        r3 = (java.lang.String) r3;
        r2 = r2.get(r4);
        r2 = (java.lang.String) r2;
        r0 = r1.getIdentifier(r3, r2, r0);
    L_0x007c:
        if (r0 != 0) goto L_0x0092;
    L_0x007e:
        r0 = new java.io.FileNotFoundException;
        r1 = new java.lang.StringBuilder;
        r2 = "No resource found for: ";
        r1.<init>(r2);
        r1.append(r8);
        r8 = r1.toString();
        r0.<init>(r8);
        throw r0;
    L_0x0092:
        r8 = r1.getDrawable(r0);
        return r8;
    L_0x0097:
        r0 = new java.io.FileNotFoundException;
        r1 = new java.lang.StringBuilder;
        r2 = "More than two path segments: ";
        r1.<init>(r2);
        r1.append(r8);
        r8 = r1.toString();
        r0.<init>(r8);
        throw r0;
    L_0x00ab:
        r0 = new java.io.FileNotFoundException;
        r1 = new java.lang.StringBuilder;
        r2 = "No package found for authority: ";
        r1.<init>(r2);
        r1.append(r8);
        r8 = r1.toString();
        r0.<init>(r8);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.SuggestionsAdapter.b(android.net.Uri):android.graphics.drawable.Drawable");
    }
}
