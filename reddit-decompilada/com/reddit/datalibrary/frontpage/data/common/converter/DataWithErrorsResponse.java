package com.reddit.datalibrary.frontpage.data.common.converter;

import com.reddit.datalibrary.frontpage.data.model.Envelope;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi.Builder;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\b\u0018\u0000 \u00102\u00020\u0001:\u0003\u0010\u0011\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/common/converter/DataWithErrorsResponse;", "", "json", "Lcom/reddit/datalibrary/frontpage/data/common/converter/DataWithErrorsResponse$Json;", "(Lcom/reddit/datalibrary/frontpage/data/common/converter/DataWithErrorsResponse$Json;)V", "getJson", "()Lcom/reddit/datalibrary/frontpage/data/common/converter/DataWithErrorsResponse$Json;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "Data", "Json", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: DataWithErrorsResponse.kt */
public final class DataWithErrorsResponse {
    public static final Companion Companion = new Companion();
    private static final JsonAdapter<DataWithErrorsResponse> adapter;
    private final Json json;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/common/converter/DataWithErrorsResponse$Companion;", "", "()V", "adapter", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/reddit/datalibrary/frontpage/data/common/converter/DataWithErrorsResponse;", "getAdapter$app_standardRelease", "()Lcom/squareup/moshi/JsonAdapter;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: DataWithErrorsResponse.kt */
    public static final class Companion {
        private Companion() {
        }

        public final JsonAdapter<DataWithErrorsResponse> getAdapter$app_standardRelease() {
            return DataWithErrorsResponse.adapter;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u001e\u0010\u0002\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00050\u00040\u0003¢\u0006\u0002\u0010\u0007J!\u0010\n\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00050\u00040\u0003HÆ\u0003J+\u0010\u000b\u001a\u00020\u00002 \b\u0002\u0010\u0002\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00050\u00040\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0006HÖ\u0001R)\u0010\u0002\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00050\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/common/converter/DataWithErrorsResponse$Data;", "", "things", "", "Lcom/reddit/datalibrary/frontpage/data/model/Envelope;", "", "", "(Ljava/util/List;)V", "getThings", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: DataWithErrorsResponse.kt */
    public static final class Data {
        private final List<Envelope<Map<String, Object>>> things;

        public static /* synthetic */ Data copy$default(Data data, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = data.things;
            }
            return data.copy(list);
        }

        public final List<Envelope<Map<String, Object>>> component1() {
            return this.things;
        }

        public final Data copy(List<? extends Envelope<? extends Map<String, ? extends Object>>> list) {
            Intrinsics.b(list, "things");
            return new Data(list);
        }

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof Data) {
                    if (Intrinsics.a(this.things, ((Data) obj).things)) {
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            List list = this.things;
            return list != null ? list.hashCode() : 0;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("Data(things=");
            stringBuilder.append(this.things);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public Data(List<? extends Envelope<? extends Map<String, ? extends Object>>> list) {
            Intrinsics.b(list, "things");
            this.things = list;
        }

        public final List<Envelope<Map<String, Object>>> getThings() {
            return this.things;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0005HÆ\u0003J+\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001d\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/common/converter/DataWithErrorsResponse$Json;", "", "data", "Lcom/reddit/datalibrary/frontpage/data/common/converter/DataWithErrorsResponse$Data;", "errors", "", "", "(Lcom/reddit/datalibrary/frontpage/data/common/converter/DataWithErrorsResponse$Data;Ljava/util/List;)V", "getData", "()Lcom/reddit/datalibrary/frontpage/data/common/converter/DataWithErrorsResponse$Data;", "getErrors", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: DataWithErrorsResponse.kt */
    public static final class Json {
        private final Data data;
        private final List<List<String>> errors;

        public static /* synthetic */ Json copy$default(Json json, Data data, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                data = json.data;
            }
            if ((i & 2) != 0) {
                list = json.errors;
            }
            return json.copy(data, list);
        }

        public final Data component1() {
            return this.data;
        }

        public final List<List<String>> component2() {
            return this.errors;
        }

        public final Json copy(Data data, List<? extends List<String>> list) {
            Intrinsics.b(list, "errors");
            return new Json(data, list);
        }

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof Json) {
                    Json json = (Json) obj;
                    if (Intrinsics.a(this.data, json.data) && Intrinsics.a(this.errors, json.errors)) {
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            Data data = this.data;
            int i = 0;
            int hashCode = (data != null ? data.hashCode() : 0) * 31;
            List list = this.errors;
            if (list != null) {
                i = list.hashCode();
            }
            return hashCode + i;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("Json(data=");
            stringBuilder.append(this.data);
            stringBuilder.append(", errors=");
            stringBuilder.append(this.errors);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public Json(Data data, List<? extends List<String>> list) {
            Intrinsics.b(list, "errors");
            this.data = data;
            this.errors = list;
        }

        public final Data getData() {
            return this.data;
        }

        public final List<List<String>> getErrors() {
            return this.errors;
        }
    }

    public static /* synthetic */ DataWithErrorsResponse copy$default(DataWithErrorsResponse dataWithErrorsResponse, Json json, int i, Object obj) {
        if ((i & 1) != 0) {
            json = dataWithErrorsResponse.json;
        }
        return dataWithErrorsResponse.copy(json);
    }

    public final Json component1() {
        return this.json;
    }

    public final DataWithErrorsResponse copy(Json json) {
        Intrinsics.b(json, "json");
        return new DataWithErrorsResponse(json);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof DataWithErrorsResponse) {
                if (Intrinsics.a(this.json, ((DataWithErrorsResponse) obj).json)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        Json json = this.json;
        return json != null ? json.hashCode() : 0;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("DataWithErrorsResponse(json=");
        stringBuilder.append(this.json);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public DataWithErrorsResponse(Json json) {
        Intrinsics.b(json, "json");
        this.json = json;
    }

    public final Json getJson() {
        return this.json;
    }

    static {
        JsonAdapter a = new Builder().a().a(DataWithErrorsResponse.class);
        Intrinsics.a(a, "Moshi.Builder()\n        …rorsResponse::class.java)");
        adapter = a;
    }
}
