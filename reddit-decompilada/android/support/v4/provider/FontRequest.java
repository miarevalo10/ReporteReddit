package android.support.v4.provider;

import android.support.v4.util.Preconditions;
import android.util.Base64;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.util.List;

public final class FontRequest {
    private final List<List<byte[]>> mCertificates;
    private final int mCertificatesArray;
    private final String mIdentifier;
    private final String mProviderAuthority;
    private final String mProviderPackage;
    private final String mQuery;

    public FontRequest(String str, String str2, String str3, List<List<byte[]>> list) {
        this.mProviderAuthority = (String) Preconditions.m1042a((Object) str);
        this.mProviderPackage = (String) Preconditions.m1042a((Object) str2);
        this.mQuery = (String) Preconditions.m1042a((Object) str3);
        this.mCertificates = (List) Preconditions.m1042a((Object) list);
        this.mCertificatesArray = null;
        str = new StringBuilder(this.mProviderAuthority);
        str.append(Operation.MINUS);
        str.append(this.mProviderPackage);
        str.append(Operation.MINUS);
        str.append(this.mQuery);
        this.mIdentifier = str.toString();
    }

    public FontRequest(String str, String str2, String str3, int i) {
        this.mProviderAuthority = (String) Preconditions.m1042a((Object) str);
        this.mProviderPackage = (String) Preconditions.m1042a((Object) str2);
        this.mQuery = (String) Preconditions.m1042a((Object) str3);
        this.mCertificates = null;
        Preconditions.m1043a(i != 0 ? true : null);
        this.mCertificatesArray = i;
        str = new StringBuilder(this.mProviderAuthority);
        str.append(Operation.MINUS);
        str.append(this.mProviderPackage);
        str.append(Operation.MINUS);
        str.append(this.mQuery);
        this.mIdentifier = str.toString();
    }

    public final String getProviderAuthority() {
        return this.mProviderAuthority;
    }

    public final String getProviderPackage() {
        return this.mProviderPackage;
    }

    public final String getQuery() {
        return this.mQuery;
    }

    public final List<List<byte[]>> getCertificates() {
        return this.mCertificates;
    }

    public final int getCertificatesArrayResId() {
        return this.mCertificatesArray;
    }

    public final String getIdentifier() {
        return this.mIdentifier;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder("FontRequest {mProviderAuthority: ");
        stringBuilder2.append(this.mProviderAuthority);
        stringBuilder2.append(", mProviderPackage: ");
        stringBuilder2.append(this.mProviderPackage);
        stringBuilder2.append(", mQuery: ");
        stringBuilder2.append(this.mQuery);
        stringBuilder2.append(", mCertificates:");
        stringBuilder.append(stringBuilder2.toString());
        for (int i = 0; i < this.mCertificates.size(); i++) {
            stringBuilder.append(" [");
            List list = (List) this.mCertificates.get(i);
            for (int i2 = 0; i2 < list.size(); i2++) {
                stringBuilder.append(" \"");
                stringBuilder.append(Base64.encodeToString((byte[]) list.get(i2), 0));
                stringBuilder.append("\"");
            }
            stringBuilder.append(" ]");
        }
        stringBuilder.append("}");
        stringBuilder2 = new StringBuilder("mCertificatesArray: ");
        stringBuilder2.append(this.mCertificatesArray);
        stringBuilder.append(stringBuilder2.toString());
        return stringBuilder.toString();
    }
}
