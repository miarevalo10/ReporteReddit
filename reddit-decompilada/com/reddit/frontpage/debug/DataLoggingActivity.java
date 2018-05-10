package com.reddit.frontpage.debug;

import android.app.Activity;
import android.app.DownloadManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.Filterable;
import android.widget.TextView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import com.jakewharton.threetenabp.AndroidThreeTen;
import com.reddit.data.events.models.Event;
import com.reddit.datalibrary.frontpage.requests.models.v1.Kind;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.RedditThemedActivity;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.util.BoundedLinkedList;
import com.reddit.frontpage.util.PermissionUtil;
import com.reddit.frontpage.util.PermissionUtil.Permission;
import com.reddit.frontpage.util.ViewUtils;
import com.reddit.frontpage.util.kotlin.MaybesKt;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi.Builder;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.threeten.bp.Instant;
import org.threeten.bp.ZoneId;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.jdk8.Jdk8Methods;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\t\u0018\u0000 32\u00020\u0001:\u000534567B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u00102\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u0010H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u0014\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00100\u0019H\u0002J*\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u00102\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00102\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010H\u0002J\u0012\u0010\u001d\u001a\u00020\u00172\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u0017H\u0014J\u0010\u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020'H\u0016J+\u0010(\u001a\u00020\u00172\u0006\u0010)\u001a\u00020*2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,2\u0006\u0010.\u001a\u00020/H\u0016¢\u0006\u0002\u00100J\u0010\u00101\u001a\u00020-2\u0006\u00102\u001a\u00020-H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/reddit/frontpage/debug/DataLoggingActivity;", "Lcom/reddit/frontpage/RedditThemedActivity;", "()V", "analyticsData", "", "Lcom/reddit/frontpage/debug/DataLoggingActivity$Data;", "disposable", "Lio/reactivex/disposables/Disposable;", "gson", "Lcom/google/gson/Gson;", "moshiAdapter", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/reddit/data/events/models/Event;", "parser", "Lcom/google/gson/JsonParser;", "convertV1Data", "", "data", "Lcom/reddit/frontpage/util/BoundedLinkedList;", "Lorg/json/JSONObject;", "convertV2Data", "events", "exportData", "", "getAnalyticsData", "Lio/reactivex/Maybe;", "mergeData", "data1", "data2", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "", "menu", "Landroid/view/Menu;", "onDestroy", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onRequestPermissionsResult", "requestCode", "", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "prettyPrint", "body", "Companion", "Data", "DataLoggingAdapter", "DataViewHolder", "EventFilter", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: DataLoggingActivity.kt */
public final class DataLoggingActivity extends RedditThemedActivity {
    public static final Companion f40731a = new Companion();
    private final Gson f40732b;
    private final JsonParser f40733c;
    private final JsonAdapter<Event> f40734d;
    private Disposable f40735h;
    private final List<Data> f40736i;
    private HashMap f40737j;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/reddit/frontpage/debug/DataLoggingActivity$Companion;", "", "()V", "LOG_SIZE", "", "PERMISSION_REQUEST_CODE", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: DataLoggingActivity.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\u0018\u00002\u00020\u0001B1\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/reddit/frontpage/debug/DataLoggingActivity$Data;", "", "position", "", "topic", "", "timestamp", "", "body", "isExpanded", "", "(Ljava/lang/Integer;Ljava/lang/String;JLjava/lang/String;Z)V", "getBody", "()Ljava/lang/String;", "()Z", "setExpanded", "(Z)V", "getPosition", "()Ljava/lang/Integer;", "setPosition", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getTimestamp", "setTimestamp", "(Ljava/lang/String;)V", "getTopic", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: DataLoggingActivity.kt */
    public static final class Data {
        String f20108a;
        Integer f20109b;
        final String f20110c;
        final String f20111d;
        boolean f20112e;

        private Data(String str, long j, String str2) {
            Intrinsics.m26847b(str, Kind.TOPIC);
            Intrinsics.m26847b(str2, "body");
            this.f20109b = null;
            this.f20110c = str;
            this.f20111d = str2;
            this.f20112e = null;
            if (j > 0) {
                Object format = new SimpleDateFormat("M-dd kk:mm:ss").format(new Date(j));
                Intrinsics.m26843a(format, "prettyTimestamp");
                this.f20108a = format;
                return;
            }
            this.f20108a = "timestamp?";
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B!\b\u0000\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0014J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\fH\u0014R\u0012\u0010\u0002\u001a\u00060\u0003R\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/reddit/frontpage/debug/DataLoggingActivity$EventFilter;", "Landroid/widget/Filter;", "adapter", "Lcom/reddit/frontpage/debug/DataLoggingActivity$DataLoggingAdapter;", "Lcom/reddit/frontpage/debug/DataLoggingActivity;", "originalData", "", "Lcom/reddit/frontpage/debug/DataLoggingActivity$Data;", "(Lcom/reddit/frontpage/debug/DataLoggingActivity$DataLoggingAdapter;Ljava/util/List;)V", "filteredData", "", "performFiltering", "Landroid/widget/Filter$FilterResults;", "constraint", "", "publishResults", "", "results", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: DataLoggingActivity.kt */
    private static final class EventFilter extends Filter {
        private final List<Data> f20118a = ((List) new ArrayList(this.f20120c.size()));
        private final DataLoggingAdapter f20119b;
        private final List<Data> f20120c;

        public EventFilter(DataLoggingAdapter dataLoggingAdapter, List<Data> list) {
            Intrinsics.m26847b(dataLoggingAdapter, "adapter");
            Intrinsics.m26847b(list, "originalData");
            this.f20119b = dataLoggingAdapter;
            this.f20120c = list;
        }

        protected final FilterResults performFiltering(CharSequence charSequence) {
            Intrinsics.m26847b(charSequence, "constraint");
            this.f20118a.clear();
            FilterResults filterResults = new FilterResults();
            if ((charSequence.length() == 0 ? 1 : 0) != 0) {
                this.f20118a.addAll(this.f20120c);
            } else {
                charSequence = charSequence.toString();
                if (charSequence == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                Object toLowerCase = charSequence.toLowerCase();
                Intrinsics.m26843a(toLowerCase, "(this as java.lang.String).toLowerCase()");
                charSequence = (CharSequence) toLowerCase;
                int length = charSequence.length() - 1;
                int i = 0;
                int i2 = i;
                while (i <= length) {
                    int i3 = charSequence.charAt(i2 == 0 ? i : length) <= ' ' ? 1 : 0;
                    if (i2 != 0) {
                        if (i3 == 0) {
                            break;
                        }
                        length--;
                    } else if (i3 == 0) {
                        i2 = 1;
                    } else {
                        i++;
                    }
                }
                charSequence = charSequence.subSequence(i, length + 1).toString();
                Collection collection = this.f20118a;
                for (Object next : this.f20120c) {
                    if (StringsKt__StringsKt.m42454a((CharSequence) ((Data) next).f20111d, charSequence, false)) {
                        collection.add(next);
                    }
                }
            }
            filterResults.values = this.f20118a;
            filterResults.count = this.f20118a.size();
            return filterResults;
        }

        protected final void publishResults(CharSequence charSequence, FilterResults filterResults) {
            Intrinsics.m26847b(charSequence, "constraint");
            Intrinsics.m26847b(filterResults, "results");
            this.f20119b.f27477b.clear();
            charSequence = this.f20119b.f27477b;
            filterResults = filterResults.values;
            if (filterResults == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<com.reddit.frontpage.debug.DataLoggingActivity.Data>");
            }
            charSequence.addAll((List) filterResults);
            this.f20119b.e();
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u00012\u00020\u0004B\u0015\b\u0000\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\b\u0010\u0013\u001a\u00020\nH\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u001c\u0010\u0016\u001a\u00020\u00172\n\u0010\u0018\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0015H\u0016J\u001c\u0010\u001a\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0015H\u0016R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/reddit/frontpage/debug/DataLoggingActivity$DataLoggingAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/reddit/frontpage/debug/DataLoggingActivity$DataViewHolder;", "Lcom/reddit/frontpage/debug/DataLoggingActivity;", "Landroid/widget/Filterable;", "originalData", "", "Lcom/reddit/frontpage/debug/DataLoggingActivity$Data;", "(Lcom/reddit/frontpage/debug/DataLoggingActivity;Ljava/util/List;)V", "eventFilter", "Landroid/widget/Filter;", "getEventFilter", "()Landroid/widget/Filter;", "eventFilter$delegate", "Lkotlin/Lazy;", "filteredData", "", "getFilteredData$app_standardRelease", "()Ljava/util/List;", "getFilter", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: DataLoggingActivity.kt */
    private final class DataLoggingAdapter extends Adapter<DataViewHolder> implements Filterable {
        static final /* synthetic */ KProperty[] f27476a = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(DataLoggingAdapter.class), "eventFilter", "getEventFilter()Landroid/widget/Filter;"))};
        final List<Data> f27477b = ((List) new ArrayList(this.f27480g));
        final /* synthetic */ DataLoggingActivity f27478c;
        private final Lazy f27479f = LazyKt.m26777a((Function0) new DataLoggingActivity$DataLoggingAdapter$eventFilter$2(this));
        private final List<Data> f27480g;

        public DataLoggingAdapter(DataLoggingActivity dataLoggingActivity, List<Data> list) {
            Intrinsics.m26847b(list, "originalData");
            this.f27478c = dataLoggingActivity;
            this.f27480g = list;
        }

        public final /* synthetic */ ViewHolder m28980a(ViewGroup viewGroup, int i) {
            Intrinsics.m26847b(viewGroup, "parent");
            Object inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C1761R.layout.data_item, viewGroup, false);
            DataLoggingActivity dataLoggingActivity = this.f27478c;
            Intrinsics.m26843a(inflate, "itemView");
            return (ViewHolder) new DataViewHolder(dataLoggingActivity, inflate);
        }

        public final /* synthetic */ void m28981a(ViewHolder viewHolder, int i) {
            DataViewHolder dataViewHolder = (DataViewHolder) viewHolder;
            Intrinsics.m26847b(dataViewHolder, "holder");
            dataViewHolder.c.setOnClickListener(new DataLoggingActivity$DataLoggingAdapter$onBindViewHolder$1(this, i));
            dataViewHolder.c.setOnLongClickListener(new DataLoggingActivity$DataLoggingAdapter$onBindViewHolder$2(this, i, dataViewHolder));
            Data data = (Data) this.f27477b.get(i);
            Intrinsics.m26847b(data, "data");
            StringCompanionObject stringCompanionObject = StringCompanionObject.f25295a;
            Object format = String.format("%d. %s: %s", Arrays.copyOf(new Object[]{data.f20109b, data.f20108a, data.f20110c}, 3));
            Intrinsics.m26843a(format, "java.lang.String.format(format, *args)");
            View view = dataViewHolder.c;
            Object obj = (TextView) view.findViewById(C1761R.id.title);
            Intrinsics.m26843a(obj, "title");
            obj.setText((CharSequence) format);
            format = (TextView) view.findViewById(C1761R.id.body);
            Intrinsics.m26843a(format, "body");
            format.setText(DataLoggingActivity.m42473a(dataViewHolder.f27481a, data.f20111d));
            Object obj2 = (TextView) view.findViewById(C1761R.id.body_preview);
            Intrinsics.m26843a(obj2, "body_preview");
            obj2.setText(data.f20111d);
            if (data.f20112e != null) {
                obj2 = (TextView) view.findViewById(C1761R.id.body);
                Intrinsics.m26843a(obj2, "body");
                obj2.setVisibility(0);
                obj2 = (TextView) view.findViewById(C1761R.id.body_preview);
                Intrinsics.m26843a(obj2, "body_preview");
                obj2.setVisibility(8);
                return;
            }
            obj2 = (TextView) view.findViewById(C1761R.id.body);
            Intrinsics.m26843a(obj2, "body");
            obj2.setVisibility(8);
            obj2 = (TextView) view.findViewById(C1761R.id.body_preview);
            Intrinsics.m26843a(obj2, "body_preview");
            obj2.setVisibility(0);
        }

        public final int m28979a() {
            return this.f27477b.size();
        }

        public final Filter getFilter() {
            return (Filter) this.f27479f.mo5678b();
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/reddit/frontpage/debug/DataLoggingActivity$DataViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/reddit/frontpage/debug/DataLoggingActivity;Landroid/view/View;)V", "bind", "", "data", "Lcom/reddit/frontpage/debug/DataLoggingActivity$Data;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: DataLoggingActivity.kt */
    public final class DataViewHolder extends ViewHolder {
        final /* synthetic */ DataLoggingActivity f27481a;

        public DataViewHolder(DataLoggingActivity dataLoggingActivity, View view) {
            Intrinsics.m26847b(view, "itemView");
            this.f27481a = dataLoggingActivity;
            super(view);
        }
    }

    public final View mo7727a(int i) {
        if (this.f40737j == null) {
            this.f40737j = new HashMap();
        }
        View view = (View) this.f40737j.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        view = findViewById(i);
        this.f40737j.put(Integer.valueOf(i), view);
        return view;
    }

    public DataLoggingActivity() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.c = true;
        Object a = gsonBuilder.a();
        Intrinsics.m26843a(a, "GsonBuilder().setPrettyPrinting().create()");
        this.f40732b = a;
        this.f40733c = new JsonParser();
        a = new Builder().m25714a().m25716a(Event.class);
        Intrinsics.m26843a(a, "Moshi.Builder().build().…Event>(Event::class.java)");
        this.f40734d = a;
        this.f40736i = new ArrayList();
    }

    protected final void onDestroy() {
        super.onDestroy();
        Disposable disposable = this.f40735h;
        if (disposable == null) {
            Intrinsics.m26844a("disposable");
        }
        disposable.mo5626a();
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1761R.layout.layout_data_logging);
        AndroidThreeTen.a(this);
        a((Toolbar) mo7727a(C1761R.id.toolbar));
        Object zipWith = AppAnalytics.m21874k().zipWith(AppAnalytics.m21878o(), new DataLoggingActivity$getAnalyticsData$1(this));
        Intrinsics.m26843a(zipWith, "AppAnalytics.v1EventLogs…              }\n        )");
        zipWith = MaybesKt.m24088b(zipWith, FrontpageApplication.m28875k().mo4633u()).subscribe((Consumer) new DataLoggingActivity$onCreate$1(this));
        Intrinsics.m26843a(zipWith, "getAnalyticsData()\n     …     }\n                })");
        this.f40735h = zipWith;
    }

    public final boolean onCreateOptionsMenu(Menu menu) {
        Intrinsics.m26847b(menu, "menu");
        getMenuInflater().inflate(C1761R.menu.menu_data_logging, menu);
        return true;
    }

    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        Intrinsics.m26847b(menuItem, "item");
        if (menuItem.getItemId() != C1761R.id.action_export) {
            return super.onOptionsItemSelected(menuItem);
        }
        if (PermissionUtil.m23862a((Activity) this, 55930) != null) {
            m42479d();
        }
        return true;
    }

    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Intrinsics.m26847b(strArr, "permissions");
        Intrinsics.m26847b(iArr, "grantResults");
        if (i != 55930) {
            super.onRequestPermissionsResult(i, strArr, iArr);
        } else if (PermissionUtil.m23866a(iArr)) {
            m42479d();
        } else {
            if (VERSION.SDK_INT >= 23 && !PermissionUtil.m23868b(this, Permission.STORAGE)) {
                super.onRequestPermissionsResult(i, strArr, iArr);
            }
        }
    }

    private final void m42479d() {
        try {
            DateTimeFormatter dateTimeFormatter;
            JSONArray jSONArray = new JSONArray();
            for (Data data : this.f40736i) {
                jSONArray.put(new JSONObject(data.f20111d));
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("events", jSONArray);
            File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            Instant a = Instant.a();
            DateTimeFormatter a2 = DateTimeFormatter.a("yyyyMMdd-HHmmss");
            Locale locale = Locale.US;
            if (a2.q.equals(locale)) {
                dateTimeFormatter = a2;
            } else {
                DateTimeFormatter dateTimeFormatter2 = new DateTimeFormatter(a2.p, locale, a2.r, a2.s, a2.t, a2.u, a2.v);
            }
            ZoneId a3 = ZoneId.a();
            if (!Jdk8Methods.a(dateTimeFormatter.v, a3)) {
                dateTimeFormatter = new DateTimeFormatter(dateTimeFormatter.p, dateTimeFormatter.q, dateTimeFormatter.r, dateTimeFormatter.s, dateTimeFormatter.t, dateTimeFormatter.u, a3);
            }
            StringBuilder stringBuilder = new StringBuilder("export_analytics_");
            stringBuilder.append(dateTimeFormatter.a(a));
            stringBuilder.append(".json");
            File file = new File(externalStoragePublicDirectory, stringBuilder.toString());
            if (file.createNewFile()) {
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write(jSONObject.toString(4));
                fileWriter.close();
                Object systemService = getSystemService("download");
                if (systemService == null) {
                    throw new TypeCastException("null cannot be cast to non-null type android.app.DownloadManager");
                }
                ((DownloadManager) systemService).addCompletedDownload(file.getName(), file.getName(), false, "text/json", file.getAbsolutePath(), file.length(), true);
                Timber.c("Analytics data exported: %s", new Object[]{file.getAbsolutePath()});
                View view = (Toolbar) mo7727a(C1761R.id.toolbar);
                StringBuilder stringBuilder2 = new StringBuilder("Analytics data exported: ");
                stringBuilder2.append(file.getName());
                ViewUtils.m24060a(view, (CharSequence) stringBuilder2.toString(), 0).a();
            }
        } catch (IOException e) {
            Timber.c(e, "Failed creating export", new Object[0]);
        } catch (JSONException e2) {
            Timber.c(e2, "Failed creating export", new Object[0]);
        }
    }

    private static List<Data> m42478b(BoundedLinkedList<JSONObject> boundedLinkedList) {
        List<Data> arrayList = new ArrayList();
        for (JSONObject jSONObject : boundedLinkedList) {
            String str;
            long j;
            String str2 = "topic?";
            try {
                String string = jSONObject.getString("event_topic");
                Intrinsics.m26843a((Object) string, "item.getString(\"event_topic\")");
                str = string;
            } catch (JSONException e) {
                Timber.e("Issue converting JsonObject into data: %s", new Object[]{e.toString()});
                str = str2;
            }
            try {
                j = jSONObject.getLong("event_ts");
            } catch (JSONException e2) {
                Timber.e("Issue converting JsonObject into data: %s", new Object[]{e2.toString()});
                j = -1;
            }
            Object jSONObject2 = jSONObject.toString();
            Intrinsics.m26843a(jSONObject2, "item.toString()");
            arrayList.add(new Data(str, j, jSONObject2));
        }
        return arrayList;
    }

    public static final /* synthetic */ String m42473a(DataLoggingActivity dataLoggingActivity, String str) {
        Object a = dataLoggingActivity.f40732b.a(JsonParser.a(str));
        Intrinsics.m26843a(a, "gson.toJson(parser.parse(body))");
        return a;
    }

    public static final /* synthetic */ List m42477a(List list, List list2) {
        list = CollectionsKt___CollectionsKt.m41428c(list);
        list.addAll(list2);
        if (list.size() > 1) {
            CollectionsKt__MutableCollectionsKt.m38191a(list, (Comparator) new DataLoggingActivity$$special$$inlined$sortByDescending$1());
        }
        Iterable<Data> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        int i = 0;
        for (Data data : iterable) {
            int i2 = i + 1;
            data.f20109b = Integer.valueOf(i);
            arrayList.add(data);
            i = i2;
        }
        return list;
    }

    public static final /* synthetic */ List m42475a(DataLoggingActivity dataLoggingActivity, List list) {
        Iterable<Event> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        for (Event event : iterable) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(event.source);
            stringBuilder.append("__");
            stringBuilder.append(event.action);
            stringBuilder.append('_');
            stringBuilder.append(event.noun);
            String stringBuilder2 = stringBuilder.toString();
            Object obj = event.client_timestamp;
            Intrinsics.m26843a(obj, "event.client_timestamp");
            long longValue = obj.longValue();
            Object toJson = dataLoggingActivity.f40734d.toJson(event);
            Intrinsics.m26843a(toJson, "moshiAdapter.toJson(event)");
            arrayList.add(new Data(stringBuilder2, longValue, toJson));
        }
        return (List) arrayList;
    }
}
