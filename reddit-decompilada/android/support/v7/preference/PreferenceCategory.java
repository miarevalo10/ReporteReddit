package android.support.v7.preference;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo;

public class PreferenceCategory extends PreferenceGroup {
    public final boolean mo3190j() {
        return false;
    }

    private PreferenceCategory(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private PreferenceCategory(Context context, AttributeSet attributeSet, int i, byte b) {
        this(context, attributeSet, i);
    }

    public PreferenceCategory(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, TypedArrayUtils.m776a(context, C0177R.attr.preferenceCategoryStyle, 16842892), (byte) 0);
    }

    protected final boolean mo3189a(Preference preference) {
        if (!(preference instanceof PreferenceCategory)) {
            return super.mo3189a(preference);
        }
        throw new IllegalArgumentException("Cannot add a PreferenceCategory directly to a PreferenceCategory");
    }

    public final boolean mo503d() {
        return !super.mo3190j();
    }

    public final void mo3188a(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        CollectionItemInfoCompat collectionItemInfoCompat;
        boolean z;
        super.mo3188a(accessibilityNodeInfoCompat);
        if (VERSION.SDK_INT >= 19) {
            CollectionItemInfo collectionItemInfo = accessibilityNodeInfoCompat.f1523a.getCollectionItemInfo();
            if (collectionItemInfo != null) {
                collectionItemInfoCompat = new CollectionItemInfoCompat(collectionItemInfo);
                if (collectionItemInfoCompat == null) {
                    z = false;
                    int rowIndex = VERSION.SDK_INT < 19 ? ((CollectionItemInfo) collectionItemInfoCompat.f1522a).getRowIndex() : 0;
                    int rowSpan = VERSION.SDK_INT < 19 ? ((CollectionItemInfo) collectionItemInfoCompat.f1522a).getRowSpan() : 0;
                    int columnIndex = VERSION.SDK_INT < 19 ? ((CollectionItemInfo) collectionItemInfoCompat.f1522a).getColumnIndex() : 0;
                    int columnSpan = VERSION.SDK_INT < 19 ? ((CollectionItemInfo) collectionItemInfoCompat.f1522a).getColumnSpan() : 0;
                    if (VERSION.SDK_INT >= 21) {
                        z = ((CollectionItemInfo) collectionItemInfoCompat.f1522a).isSelected();
                    }
                    accessibilityNodeInfoCompat.m1325a(CollectionItemInfoCompat.m1317a(rowIndex, rowSpan, columnIndex, columnSpan, true, z));
                }
            }
        }
        collectionItemInfoCompat = null;
        if (collectionItemInfoCompat == null) {
            z = false;
            if (VERSION.SDK_INT < 19) {
            }
            if (VERSION.SDK_INT < 19) {
            }
            if (VERSION.SDK_INT < 19) {
            }
            if (VERSION.SDK_INT < 19) {
            }
            if (VERSION.SDK_INT >= 21) {
                z = ((CollectionItemInfo) collectionItemInfoCompat.f1522a).isSelected();
            }
            accessibilityNodeInfoCompat.m1325a(CollectionItemInfoCompat.m1317a(rowIndex, rowSpan, columnIndex, columnSpan, true, z));
        }
    }
}
