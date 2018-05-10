package com.reddit.datalibrary.frontpage.data.model;

import com.reddit.datalibrary.frontpage.data.feature.common.Key;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J)\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/model/PathKey;", "Lcom/reddit/datalibrary/frontpage/data/feature/common/Key;", "path", "", "parameters", "", "(Ljava/lang/String;Ljava/util/Map;)V", "getParameters", "()Ljava/util/Map;", "getPath", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: PathKey.kt */
public final class PathKey implements Key {
    private final Map<String, String> parameters;
    private final String path;

    public static /* synthetic */ PathKey copy$default(PathKey pathKey, String str, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = pathKey.path;
        }
        if ((i & 2) != 0) {
            map = pathKey.parameters;
        }
        return pathKey.copy(str, map);
    }

    public final String component1() {
        return this.path;
    }

    public final Map<String, String> component2() {
        return this.parameters;
    }

    public final PathKey copy(String str, Map<String, String> map) {
        Intrinsics.b(str, "path");
        Intrinsics.b(map, "parameters");
        return new PathKey(str, map);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof PathKey) {
                PathKey pathKey = (PathKey) obj;
                if (Intrinsics.a(this.path, pathKey.path) && Intrinsics.a(this.parameters, pathKey.parameters)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.path;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Map map = this.parameters;
        if (map != null) {
            i = map.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("PathKey(path=");
        stringBuilder.append(this.path);
        stringBuilder.append(", parameters=");
        stringBuilder.append(this.parameters);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public PathKey(String str, Map<String, String> map) {
        Intrinsics.b(str, "path");
        Intrinsics.b(map, "parameters");
        this.path = str;
        this.parameters = map;
    }

    public /* synthetic */ PathKey(String str, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 2) != 0) {
            map = MapsKt.a();
        }
        this(str, map);
    }

    public final Map<String, String> getParameters() {
        return this.parameters;
    }

    public final String getPath() {
        return this.path;
    }
}
