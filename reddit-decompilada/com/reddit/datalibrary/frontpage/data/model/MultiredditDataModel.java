package com.reddit.datalibrary.frontpage.data.model;

import com.raizlabs.android.dbflow.rx2.structure.BaseRXModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000bJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003JI\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010%\u001a\u00020\u00072\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013R\u001e\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0011\"\u0004\b\u001d\u0010\u0013¨\u0006+"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/model/MultiredditDataModel;", "Lcom/raizlabs/android/dbflow/rx2/structure/BaseRXModel;", "id", "", "name", "", "editable", "", "path", "iconUrl", "keyColor", "(JLjava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEditable", "()Z", "setEditable", "(Z)V", "getIconUrl", "()Ljava/lang/String;", "setIconUrl", "(Ljava/lang/String;)V", "getId", "()J", "setId", "(J)V", "getKeyColor", "setKeyColor", "getName", "setName", "getPath", "setPath", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: MultiredditDataModel.kt */
public final class MultiredditDataModel extends BaseRXModel {
    private boolean editable;
    private String iconUrl;
    private long id;
    private String keyColor;
    private String name;
    private String path;

    public MultiredditDataModel() {
        this(0, null, false, null, null, null, 63, null);
    }

    public static /* synthetic */ MultiredditDataModel copy$default(MultiredditDataModel multiredditDataModel, long j, String str, boolean z, String str2, String str3, String str4, int i, Object obj) {
        MultiredditDataModel multiredditDataModel2 = multiredditDataModel;
        return multiredditDataModel2.copy((i & 1) != 0 ? multiredditDataModel2.id : j, (i & 2) != 0 ? multiredditDataModel2.name : str, (i & 4) != 0 ? multiredditDataModel2.editable : z, (i & 8) != 0 ? multiredditDataModel2.path : str2, (i & 16) != 0 ? multiredditDataModel2.iconUrl : str3, (i & 32) != 0 ? multiredditDataModel2.keyColor : str4);
    }

    public final long component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final boolean component3() {
        return this.editable;
    }

    public final String component4() {
        return this.path;
    }

    public final String component5() {
        return this.iconUrl;
    }

    public final String component6() {
        return this.keyColor;
    }

    public final MultiredditDataModel copy(long j, String str, boolean z, String str2, String str3, String str4) {
        String str5 = str;
        Intrinsics.b(str5, "name");
        String str6 = str2;
        Intrinsics.b(str6, "path");
        return new MultiredditDataModel(j, str5, z, str6, str3, str4);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MultiredditDataModel) {
            MultiredditDataModel multiredditDataModel = (MultiredditDataModel) obj;
            if ((this.id == multiredditDataModel.id) && Intrinsics.a(this.name, multiredditDataModel.name)) {
                return (this.editable == multiredditDataModel.editable) && Intrinsics.a(this.path, multiredditDataModel.path) && Intrinsics.a(this.iconUrl, multiredditDataModel.iconUrl) && Intrinsics.a(this.keyColor, multiredditDataModel.keyColor);
            }
        }
    }

    public final int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.name;
        int i2 = 0;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        int i3 = this.editable;
        if (i3 != 0) {
            i3 = 1;
        }
        i = (i + i3) * 31;
        str = this.path;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.iconUrl;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.keyColor;
        if (str != null) {
            i2 = str.hashCode();
        }
        return i + i2;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("MultiredditDataModel(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", editable=");
        stringBuilder.append(this.editable);
        stringBuilder.append(", path=");
        stringBuilder.append(this.path);
        stringBuilder.append(", iconUrl=");
        stringBuilder.append(this.iconUrl);
        stringBuilder.append(", keyColor=");
        stringBuilder.append(this.keyColor);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final long getId() {
        return this.id;
    }

    public final void setId(long j) {
        this.id = j;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        Intrinsics.b(str, "<set-?>");
        this.name = str;
    }

    public final boolean getEditable() {
        return this.editable;
    }

    public final void setEditable(boolean z) {
        this.editable = z;
    }

    public final String getPath() {
        return this.path;
    }

    public final void setPath(String str) {
        Intrinsics.b(str, "<set-?>");
        this.path = str;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public /* synthetic */ MultiredditDataModel(long j, String str, boolean z, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0 : j, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? false : z, (i & 8) != 0 ? "" : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4);
    }

    public final String getKeyColor() {
        return this.keyColor;
    }

    public final void setKeyColor(String str) {
        this.keyColor = str;
    }

    public MultiredditDataModel(long j, String str, boolean z, String str2, String str3, String str4) {
        Intrinsics.b(str, "name");
        Intrinsics.b(str2, "path");
        this.id = j;
        this.name = str;
        this.editable = z;
        this.path = str2;
        this.iconUrl = str3;
        this.keyColor = str4;
    }
}
