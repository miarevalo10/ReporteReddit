package com.raizlabs.android.dbflow.kotlinextensions;

import com.raizlabs.android.dbflow.annotation.Collate;
import com.raizlabs.android.dbflow.list.FlowCursorList;
import com.raizlabs.android.dbflow.list.FlowQueryList;
import com.raizlabs.android.dbflow.sql.Query;
import com.raizlabs.android.dbflow.sql.language.BaseModelQueriable;
import com.raizlabs.android.dbflow.sql.language.Case;
import com.raizlabs.android.dbflow.sql.language.CaseCondition;
import com.raizlabs.android.dbflow.sql.language.CompletedTrigger;
import com.raizlabs.android.dbflow.sql.language.CursorResult;
import com.raizlabs.android.dbflow.sql.language.From;
import com.raizlabs.android.dbflow.sql.language.Index;
import com.raizlabs.android.dbflow.sql.language.Insert;
import com.raizlabs.android.dbflow.sql.language.Join;
import com.raizlabs.android.dbflow.sql.language.Join.JoinType;
import com.raizlabs.android.dbflow.sql.language.NameAlias;
import com.raizlabs.android.dbflow.sql.language.OrderBy;
import com.raizlabs.android.dbflow.sql.language.SQLOperator;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.sql.language.Select;
import com.raizlabs.android.dbflow.sql.language.Set;
import com.raizlabs.android.dbflow.sql.language.Transformable;
import com.raizlabs.android.dbflow.sql.language.Trigger;
import com.raizlabs.android.dbflow.sql.language.TriggerMethod;
import com.raizlabs.android.dbflow.sql.language.Update;
import com.raizlabs.android.dbflow.sql.language.Where;
import com.raizlabs.android.dbflow.sql.language.property.IProperty;
import com.raizlabs.android.dbflow.sql.language.property.Property;
import com.raizlabs.android.dbflow.sql.queriable.AsyncQuery;
import com.raizlabs.android.dbflow.sql.queriable.ModelQueriable;
import com.raizlabs.android.dbflow.sql.queriable.Queriable;
import com.raizlabs.android.dbflow.structure.AsyncModel;
import com.raizlabs.android.dbflow.structure.Model;
import com.raizlabs.android.dbflow.structure.database.DatabaseStatement;
import com.raizlabs.android.dbflow.structure.database.FlowCursor;
import com.raizlabs.android.dbflow.structure.database.transaction.QueryTransaction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000Ê\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000f\u001a*\u00104\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0006H\u000605\"\b\b\u0000\u0010\u0006*\u00020\b2\n\u00106\u001a\u0006\u0012\u0002\b\u000307\u001a&\u00108\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0006H\u000609\"\b\b\u0000\u0010\u0006*\u00020\b2\u0006\u0010:\u001a\u00020;\u001aQ\u0010<\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\b\u0012\u0006\u0012\u0002\b\u000307\u0012\u0002\b\u00030>0=2.\u0010?\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\b\u0012\u0006\u0012\u0002\b\u000307\u0012\u0002\b\u00030>0=\"\u0010\u0012\b\u0012\u0006\u0012\u0002\b\u000307\u0012\u0002\b\u00030>¢\u0006\u0002\u0010@\u001a\u000e\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020D\u001a#\u0010E\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0006H\u00060F\"\n\b\u0000\u0010\u0006\u0018\u0001*\u00020\bH\b\u001a@\u0010E\u001a\b\u0012\u0004\u0012\u0002H\u00060G\"\n\b\u0000\u0010\u0006\u0018\u0001*\u00020\b2#\u0010H\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060F\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060G0I¢\u0006\u0002\bJH\b\u001a,\u0010E\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0006H\u00060F\"\b\b\u0000\u0010\u0006*\u00020\b2\f\u0010K\u001a\b\u0012\u0004\u0012\u0002H\u00060L\u001aL\u0010M\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0006H\u00060N\"\n\b\u0000\u0010\u0006\u0018\u0001*\u00020\b2\u0006\u0010O\u001a\u00020D2\u0006\u0010P\u001a\u00020Q2\u0012\u0010R\u001a\n\u0012\u0006\b\u0001\u0012\u00020Q0=\"\u00020QH\b¢\u0006\u0002\u0010S\u001aL\u0010M\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0006H\u00060N\"\n\b\u0000\u0010\u0006\u0018\u0001*\u00020\b2\u0006\u0010O\u001a\u00020D2\u001a\u0010T\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u0003070=\"\u0006\u0012\u0002\b\u000307H\b¢\u0006\u0002\u0010U\u001a#\u0010V\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0006H\u00060W\"\n\b\u0000\u0010\u0006\u0018\u0001*\u00020\bH\b\u001aB\u0010V\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0006H\u00060W\"\n\b\u0000\u0010\u0006\u0018\u0001*\u00020\b2\u001d\u0010X\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060W\u0012\u0004\u0012\u00020Y0I¢\u0006\u0002\bJH\b\u001a,\u0010V\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0006H\u00060W\"\b\b\u0000\u0010\u0006*\u00020\b2\f\u0010K\u001a\b\u0012\u0004\u0012\u0002H\u00060L\u001a5\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00060G\"\b\b\u0000\u0010\u0006*\u00020\b2\u001d\u0010Z\u001a\u0019\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060G0I¢\u0006\u0002\bJ\u001ab\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00060G\"\u0004\b\u0000\u0010\u00062*\u0010T\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u000307070=\"\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u000307072\u001d\u0010Z\u001a\u0019\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060G0I¢\u0006\u0002\bJ¢\u0006\u0002\u0010[\u001a#\u0010\\\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0006H\u00060]\"\n\b\u0000\u0010\u0006\u0018\u0001*\u00020\bH\b\u001a@\u0010\\\u001a\b\u0012\u0004\u0012\u0002H\u00060G\"\n\b\u0000\u0010\u0006\u0018\u0001*\u00020\b2#\u0010^\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060]\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060G0I¢\u0006\u0002\bJH\b\u001a3\u0010_\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0006H\u00060`\"\b\b\u0000\u0010\u0006*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00060`2\u0006\u0010a\u001a\u00020bH\u0004\u001a9\u0010_\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0006H\u00060c\"\b\b\u0000\u0010\u0006*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00060c2\f\u0010d\u001a\b\u0012\u0004\u0012\u00020;0eH\b\u001a3\u0010_\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0006H\u00060c\"\b\b\u0000\u0010\u0006*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00060c2\u0006\u0010f\u001a\u00020;H\u0004\u001a3\u0010g\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0006H\u00060F\"\b\b\u0000\u0010\u0006*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00060F2\u0006\u0010h\u001a\u00020DH\u0004\u001a3\u0010i\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0006H\u00060`\"\b\b\u0000\u0010\u0006*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00060j2\u0006\u0010k\u001a\u00020bH\u0004\u001a\u0015\u0010l\u001a\u00020m*\u00020m2\u0006\u0010l\u001a\u00020nH\u0004\u001aQ\u0010<\u001a\b\u0012\u0004\u0012\u0002H\u00060W\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060W2.\u0010?\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\b\u0012\u0006\u0012\u0002\b\u000307\u0012\u0002\b\u00030>0=\"\u0010\u0012\b\u0012\u0006\u0012\u0002\b\u000307\u0012\u0002\b\u00030>¢\u0006\u0002\u0010o\u001aA\u0010p\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002Hr0q\"\b\b\u0000\u0010\u0006*\u00020\b\"\b\b\u0001\u0010r*\u00020\b*\b\u0012\u0004\u0012\u0002Hr0F2\f\u0010s\u001a\b\u0012\u0004\u0012\u0002H\u00060LH\u0004\u001aC\u0010\u001c\u001a\u00020Y\"\b\b\u0000\u0010\u0006*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00060\u00052$\b\u0004\u0010t\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030v\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u001d\u0012\u0004\u0012\u00020Y0uH\f\u001a3\u0010E\u001a\u00020%\"\b\b\u0000\u0010\u0006*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00060\f2\u0014\b\u0004\u0010w\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u00020Y0IH\f\u001a3\u0010x\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0006H\u00060j\"\b\b\u0000\u0010\u0006*\u00020\b*\u00020B2\f\u0010y\u001a\b\u0012\u0004\u0012\u0002H\u00060LH\u0004\u001a:\u0010z\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0006H\u000605\"\b\b\u0000\u0010\u0006*\u00020\b*\b\u0012\u0004\u0012\u0002H\u0006052\b\u0010{\u001a\u0004\u0018\u0001H\u0006H\u0004¢\u0006\u0002\u0010|\u001aO\u0010}\u001a,\u0012(\u0012&\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0006H\u0006 \u0007*\u0012\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0006H\u0006\u0018\u000105050~\"\b\b\u0000\u0010\u0006*\u00020\b*\b\u0012\u0004\u0012\u0002H\u0006052\u0006\u0010\u001a\u00020DH\u0004\u001a(\u0010\u0001\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0006H\u00060F\"\n\b\u0000\u0010\u0006\u0018\u0001*\u00020\b*\u00020\u0001H\b\u001aF\u0010\u0001\u001a\b\u0012\u0004\u0012\u0002H\u00060c\"\n\b\u0000\u0010\u0006\u0018\u0001*\u00020\b*\u00020\u00012$\u0010\u0001\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060F\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060c0I¢\u0006\u0002\bJH\b\u001a4\u0010\u0001\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0006H\u00060F\"\b\b\u0000\u0010\u0006*\u00020\b*\u00020\u00012\f\u0010K\u001a\b\u0012\u0004\u0012\u0002H\u00060LH\u0004\u001a.\u0010\u0001\u001a\b\u0012\u0004\u0012\u0002H\u00060c\"\b\b\u0000\u0010\u0006*\u00020\b*\t\u0012\u0004\u0012\u0002H\u00060\u00012\u0007\u0010\u0001\u001a\u00020QH\u0004\u001a1\u0010\u0001\u001a\b\u0012\u0004\u0012\u0002H\u00060c\"\b\b\u0000\u0010\u0006*\u00020\b*\t\u0012\u0004\u0012\u0002H\u00060\u00012\n\u0010T\u001a\u0006\u0012\u0002\b\u000307H\u0004\u001a-\u0010\u0001\u001a\b\u0012\u0004\u0012\u0002H\u00060c\"\b\b\u0000\u0010\u0006*\u00020\b*\t\u0012\u0004\u0012\u0002H\u00060\u00012\u0006\u0010f\u001a\u00020;H\u0004\u001aB\u0010\u0001\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002Hr0q\"\b\b\u0000\u0010\u0006*\u00020\b\"\b\b\u0001\u0010r*\u00020\b*\b\u0012\u0004\u0012\u0002Hr0F2\f\u0010s\u001a\b\u0012\u0004\u0012\u0002H\u00060LH\u0004\u001a3\u0010V\u001a\u00020\u0010\"\b\b\u0000\u0010\u0006*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00060\f2\u0014\b\u0004\u0010w\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u00020Y0IH\f\u001a4\u0010\u0001\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0006H\u00060j\"\b\b\u0000\u0010\u0006*\u00020\b*\u00020B2\f\u0010y\u001a\b\u0012\u0004\u0012\u0002H\u00060LH\u0004\u001ab\u0010\u0001\u001a\b\u0012\u0004\u0012\u0002H\u00060c\"\b\b\u0000\u0010\u0006*\u00020\b\"\u000b\b\u0001\u0010\u0001\u0018\u0001*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00060F2\b\u0010\u0001\u001a\u00030\u00012%\u0010\u0001\u001a \u0012\u0011\u0012\u000f\u0012\u0005\u0012\u0003H\u0001\u0012\u0004\u0012\u0002H\u00060q\u0012\u0004\u0012\u00020Y0I¢\u0006\u0002\bJH\b\u001aB\u0010\u0001\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002Hr0q\"\b\b\u0000\u0010\u0006*\u00020\b\"\b\b\u0001\u0010r*\u00020\b*\b\u0012\u0004\u0012\u0002Hr0F2\f\u0010s\u001a\b\u0012\u0004\u0012\u0002H\u00060LH\u0004\u001a/\u0010\u0001\u001a\b\u0012\u0004\u0012\u0002H\u00060c\"\b\b\u0000\u0010\u0006*\u00020\b*\t\u0012\u0004\u0012\u0002H\u00060\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0004\u001aC\u0010(\u001a\u00020Y\"\b\b\u0000\u0010\u0006*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00060\u00052$\b\u0004\u0010t\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030v\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060)\u0012\u0004\u0012\u00020Y0uH\f\u001aB\u0010\u0001\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002Hr0q\"\b\b\u0000\u0010\u0006*\u00020\b\"\b\b\u0001\u0010r*\u00020\b*\b\u0012\u0004\u0012\u0002Hr0F2\f\u0010s\u001a\b\u0012\u0004\u0012\u0002H\u00060LH\u0004\u001a/\u0010\u0001\u001a\b\u0012\u0004\u0012\u0002H\u00060c\"\b\b\u0000\u0010\u0006*\u00020\b*\t\u0012\u0004\u0012\u0002H\u00060\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0004\u001a<\u0010\u0001\u001a\b\u0012\u0004\u0012\u0002Hr0F\"\b\b\u0000\u0010\u0006*\u00020\b\"\b\b\u0001\u0010r*\u00020\b*\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002Hr0q2\u0006\u0010f\u001a\u00020;H\u0004\u001aU\u0010\u0001\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0006H\u00060F\"\b\b\u0000\u0010\u0006*\u00020\b\"\t\b\u0001\u0010\u0001*\u00020\b*\u000f\u0012\u0005\u0012\u0003H\u0001\u0012\u0004\u0012\u0002H\u00060q2\u0015\u0010\u0001\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020;0=0eH\f\u001a:\u0010\u0001\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0006H\u00060c\"\b\b\u0000\u0010\u0006*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00060c2\f\u0010d\u001a\b\u0012\u0004\u0012\u00020;0eH\b\u001a4\u0010\u0001\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0006H\u00060c\"\b\b\u0000\u0010\u0006*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00060c2\u0006\u0010f\u001a\u00020;H\u0004\u001aP\u0010\u0001\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0006H\u00060W\"\b\b\u0000\u0010\u0006*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00060W2\u001d\u0010\u0001\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\b\u0012\u0006\u0012\u0002\b\u000307\u0012\u0002\b\u00030>0=H\u0004¢\u0006\u0002\u0010o\u001aP\u0010\u0001\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0006H\u00060W\"\b\b\u0000\u0010\u0006*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00060W2\u001d\u0010\u0001\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\b\u0012\u0006\u0012\u0002\b\u000307\u0012\u0002\b\u00030>0=H\u0004¢\u0006\u0002\u0010o\u001aP\u0010\u0001\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0006H\u00060W\"\b\b\u0000\u0010\u0006*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00060W2\u001d\u0010\u0001\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\b\u0012\u0006\u0012\u0002\b\u000307\u0012\u0002\b\u00030>0=H\u0004¢\u0006\u0002\u0010o\u001aP\u0010\u0001\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0006H\u00060W\"\b\b\u0000\u0010\u0006*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00060W2\u001d\u0010\u0001\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\b\u0012\u0006\u0012\u0002\b\u000307\u0012\u0002\b\u00030>0=H\u0004¢\u0006\u0002\u0010o\u001aP\u0010\u0001\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0006H\u00060W\"\b\b\u0000\u0010\u0006*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00060W2\u001d\u0010\u0001\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\b\u0012\u0006\u0012\u0002\b\u000307\u0012\u0002\b\u00030>0=H\u0004¢\u0006\u0002\u0010o\u001a.\u0010\u0001\u001a\b\u0012\u0004\u0012\u0002H\u00060c\"\b\b\u0000\u0010\u0006*\u00020\b*\t\u0012\u0004\u0012\u0002H\u00060\u00012\u0007\u0010\u0001\u001a\u00020mH\u0004\u001a?\u0010-\u001a\u00020Y\"\b\b\u0000\u0010\u0006*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00060\u00052 \b\u0004\u0010t\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030v\u0012\u0006\u0012\u0004\u0018\u0001H\u0006\u0012\u0004\u0012\u00020Y0uH\f\u001a4\u0010\u0001\u001a\u00020%\"\b\b\u0000\u0010\u0006*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00060\f2\u0014\b\u0004\u0010w\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u00020Y0IH\f\u001a0\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00060W\"\b\b\u0000\u0010\u0006*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00060W2\u000b\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030FH\u0004\u001a5\u0010\u0001\u001a\u0011\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0006H\u00060\u0001\"\b\b\u0000\u0010\u0006*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00060]2\u0006\u0010f\u001a\u00020;H\u0004\u001aK\u0010\u0001\u001a\b\u0012\u0004\u0012\u0002H\u00060c\"\b\b\u0000\u0010\u0006*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00060]2%\u0010\u0001\u001a \u0012\u000b\u0012\t\u0012\u0004\u0012\u0002H\u00060\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060c0I¢\u0006\u0002\bJH\b\u001a<\u0010 \u0001\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0006H\u000605\"\b\b\u0000\u0010\u0006*\u00020\b*\b\u0012\u0004\u0012\u0002H\u0006092\b\u0010{\u001a\u0004\u0018\u0001H\u0006H\u0004¢\u0006\u0003\u0010¡\u0001\u001a8\u0010 \u0001\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0006H\u000605\"\b\b\u0000\u0010\u0006*\u00020\b*\b\u0012\u0004\u0012\u0002H\u0006092\n\u0010T\u001a\u0006\u0012\u0002\b\u000307H\u0004\u001a@\u0010¢\u0001\u001a$\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0006H\u0006 \u0007*\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0006H\u00060*0)\"\n\b\u0000\u0010\u0006\u0018\u0001*\u00020\b*\u0006\u0012\u0002\b\u00030\u001dH\b\u001a@\u0010£\u0001\u001a$\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0006H\u0006 \u0007*\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0006H\u00060*0)\"\n\b\u0000\u0010\u0006\u0018\u0001*\u00020\b*\u0006\u0012\u0002\b\u00030\u001dH\b\u001a&\u0010¤\u0001\u001a\u0004\u0018\u0001H\u0006\"\n\b\u0000\u0010\u0006\u0018\u0001*\u00020\b*\u0006\u0012\u0002\b\u00030\u001dH\b¢\u0006\u0003\u0010¥\u0001\u001a&\u0010¦\u0001\u001a\u0004\u0018\u0001H\u0006\"\n\b\u0000\u0010\u0006\u0018\u0001*\u00020\b*\u0006\u0012\u0002\b\u00030\u001dH\b¢\u0006\u0003\u0010¥\u0001\u001a3\u0010\\\u001a\u00020%\"\b\b\u0000\u0010\u0006*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00060\f2\u0014\b\u0004\u0010w\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u00020Y0IH\f\u001a4\u0010§\u0001\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0006H\u00060j\"\b\b\u0000\u0010\u0006*\u00020\b*\u00020B2\f\u0010y\u001a\b\u0012\u0004\u0012\u0002H\u00060LH\u0004\u001a@\u0010¨\u0001\u001a\b\u0012\u0004\u0012\u0002Hr0F\"\b\b\u0000\u0010\u0006*\u00020\b\"\b\b\u0001\u0010r*\u00020\b*\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002Hr0q2\n\u0010T\u001a\u0006\u0012\u0002\b\u000307H\u0004\u001a<\u0010©\u0001\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0006H\u000609\"\b\b\u0000\u0010\u0006*\u00020\b*\b\u0012\u0004\u0012\u0002H\u0006052\b\u0010{\u001a\u0004\u0018\u0001H\u0006H\u0004¢\u0006\u0003\u0010ª\u0001\u001a4\u0010©\u0001\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0006H\u000609\"\b\b\u0000\u0010\u0006*\u00020\b*\b\u0012\u0004\u0012\u0002H\u0006052\u0006\u0010f\u001a\u00020;H\u0004\u001a8\u0010©\u0001\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0006H\u000609\"\b\b\u0000\u0010\u0006*\u00020\b*\b\u0012\u0004\u0012\u0002H\u0006052\n\u0010T\u001a\u0006\u0012\u0002\b\u000307H\u0004\u001a:\u0010«\u0001\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0006H\u00060c\"\b\b\u0000\u0010\u0006*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00060F2\f\u0010d\u001a\b\u0012\u0004\u0012\u00020;0eH\b\u001a4\u0010«\u0001\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0006H\u00060c\"\b\b\u0000\u0010\u0006*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00060F2\u0006\u0010f\u001a\u00020;H\u0004\u001a;\u0010«\u0001\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0006H\u00060c\"\b\b\u0000\u0010\u0006*\u00020\b*\t\u0012\u0004\u0012\u0002H\u00060\u00012\f\u0010d\u001a\b\u0012\u0004\u0012\u00020;0eH\b\u001a5\u0010«\u0001\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0006H\u00060c\"\b\b\u0000\u0010\u0006*\u00020\b*\t\u0012\u0004\u0012\u0002H\u00060\u00012\u0006\u0010f\u001a\u00020;H\u0004\u001a;\u0010¬\u0001\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0006H\u00060c\"\b\b\u0000\u0010\u0006*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00060F2\r\u0010«\u0001\u001a\b\u0012\u0004\u0012\u0002H\u00060cH\u0004\"\u0012\u0010\u0000\u001a\u00020\u00018Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"4\u0010\u0004\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0006H\u00060\u0005\"\b\b\u0000\u0010\u0006*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00060\t8Æ\u0002¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\"&\u0010\u0004\u001a\u0012\u0012\u000e\b\u0001\u0012\n \u0007*\u0004\u0018\u00010\r0\r0\f*\u00020\r8Æ\u0002¢\u0006\u0006\u001a\u0004\b\n\u0010\u000e\"\u0016\u0010\u000f\u001a\u00020\u0010*\u00020\u00118Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\"\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u0015*\u00020\u00118Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\"4\u0010\u0018\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0006H\u00060\u0019\"\b\b\u0000\u0010\u0006*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00060\t8Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\"4\u0010\u001c\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0006H\u00060\u001d\"\b\b\u0000\u0010\u0006*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00060\t8Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f\"4\u0010 \u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0006H\u00060!\"\b\b\u0000\u0010\u0006*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00060\t8Æ\u0002¢\u0006\u0006\u001a\u0004\b\"\u0010#\"\u0016\u0010$\u001a\u00020%*\u00020\u00118Æ\u0002¢\u0006\u0006\u001a\u0004\b&\u0010'\"H\u0010(\u001a$\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0006H\u0006 \u0007*\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0006H\u00060*0)\"\b\b\u0000\u0010\u0006*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00060\t8Æ\u0002¢\u0006\u0006\u001a\u0004\b+\u0010,\"(\u0010-\u001a\u0004\u0018\u0001H\u0006\"\b\b\u0000\u0010\u0006*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00060\t8Æ\u0002¢\u0006\u0006\u001a\u0004\b.\u0010/\"\u0016\u00100\u001a\u000201*\u00020\u00118Æ\u0002¢\u0006\u0006\u001a\u0004\b2\u00103¨\u0006­\u0001"}, d2 = {"select", "Lcom/raizlabs/android/dbflow/sql/language/Select;", "getSelect", "()Lcom/raizlabs/android/dbflow/sql/language/Select;", "async", "Lcom/raizlabs/android/dbflow/sql/queriable/AsyncQuery;", "T", "kotlin.jvm.PlatformType", "", "Lcom/raizlabs/android/dbflow/sql/queriable/ModelQueriable;", "getAsync", "(Lcom/raizlabs/android/dbflow/sql/queriable/ModelQueriable;)Lcom/raizlabs/android/dbflow/sql/queriable/AsyncQuery;", "Lcom/raizlabs/android/dbflow/structure/AsyncModel;", "Lcom/raizlabs/android/dbflow/structure/Model;", "(Lcom/raizlabs/android/dbflow/structure/Model;)Lcom/raizlabs/android/dbflow/structure/AsyncModel;", "count", "", "Lcom/raizlabs/android/dbflow/sql/queriable/Queriable;", "getCount", "(Lcom/raizlabs/android/dbflow/sql/queriable/Queriable;)J", "cursor", "Lcom/raizlabs/android/dbflow/structure/database/FlowCursor;", "getCursor", "(Lcom/raizlabs/android/dbflow/sql/queriable/Queriable;)Lcom/raizlabs/android/dbflow/structure/database/FlowCursor;", "cursorList", "Lcom/raizlabs/android/dbflow/list/FlowCursorList;", "getCursorList", "(Lcom/raizlabs/android/dbflow/sql/queriable/ModelQueriable;)Lcom/raizlabs/android/dbflow/list/FlowCursorList;", "cursorResult", "Lcom/raizlabs/android/dbflow/sql/language/CursorResult;", "getCursorResult", "(Lcom/raizlabs/android/dbflow/sql/queriable/ModelQueriable;)Lcom/raizlabs/android/dbflow/sql/language/CursorResult;", "flowQueryList", "Lcom/raizlabs/android/dbflow/list/FlowQueryList;", "getFlowQueryList", "(Lcom/raizlabs/android/dbflow/sql/queriable/ModelQueriable;)Lcom/raizlabs/android/dbflow/list/FlowQueryList;", "hasData", "", "getHasData", "(Lcom/raizlabs/android/dbflow/sql/queriable/Queriable;)Z", "list", "", "", "getList", "(Lcom/raizlabs/android/dbflow/sql/queriable/ModelQueriable;)Ljava/util/List;", "result", "getResult", "(Lcom/raizlabs/android/dbflow/sql/queriable/ModelQueriable;)Ljava/lang/Object;", "statement", "Lcom/raizlabs/android/dbflow/structure/database/DatabaseStatement;", "getStatement", "(Lcom/raizlabs/android/dbflow/sql/queriable/Queriable;)Lcom/raizlabs/android/dbflow/structure/database/DatabaseStatement;", "case", "Lcom/raizlabs/android/dbflow/sql/language/Case;", "caseColumn", "Lcom/raizlabs/android/dbflow/sql/language/property/IProperty;", "caseWhen", "Lcom/raizlabs/android/dbflow/sql/language/CaseCondition;", "operator", "Lcom/raizlabs/android/dbflow/sql/language/SQLOperator;", "columnValues", "", "Lkotlin/Pair;", "pairs", "([Lkotlin/Pair;)[Lkotlin/Pair;", "createTrigger", "Lcom/raizlabs/android/dbflow/sql/language/Trigger;", "name", "", "delete", "Lcom/raizlabs/android/dbflow/sql/language/From;", "Lcom/raizlabs/android/dbflow/sql/language/BaseModelQueriable;", "deleteClause", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "modelClass", "Lkotlin/reflect/KClass;", "indexOn", "Lcom/raizlabs/android/dbflow/sql/language/Index;", "indexName", "firstNameAlias", "Lcom/raizlabs/android/dbflow/sql/language/NameAlias;", "arrayOfNameAlias", "(Ljava/lang/String;Lcom/raizlabs/android/dbflow/sql/language/NameAlias;[Lcom/raizlabs/android/dbflow/sql/language/NameAlias;)Lcom/raizlabs/android/dbflow/sql/language/Index;", "property", "(Ljava/lang/String;[Lcom/raizlabs/android/dbflow/sql/language/property/IProperty;)Lcom/raizlabs/android/dbflow/sql/language/Index;", "insert", "Lcom/raizlabs/android/dbflow/sql/language/Insert;", "insertMethod", "", "init", "([Lcom/raizlabs/android/dbflow/sql/language/property/IProperty;Lkotlin/jvm/functions/Function1;)Lcom/raizlabs/android/dbflow/sql/language/BaseModelQueriable;", "update", "Lcom/raizlabs/android/dbflow/sql/language/Update;", "setMethod", "and", "Lcom/raizlabs/android/dbflow/sql/language/CompletedTrigger;", "nextStatement", "Lcom/raizlabs/android/dbflow/sql/Query;", "Lcom/raizlabs/android/dbflow/sql/language/Where;", "sqlOperatorClause", "Lkotlin/Function0;", "sqlOperator", "as", "alias", "begin", "Lcom/raizlabs/android/dbflow/sql/language/TriggerMethod;", "triggerStatement", "collate", "Lcom/raizlabs/android/dbflow/sql/language/OrderBy;", "Lcom/raizlabs/android/dbflow/annotation/Collate;", "(Lcom/raizlabs/android/dbflow/sql/language/Insert;[Lkotlin/Pair;)Lcom/raizlabs/android/dbflow/sql/language/Insert;", "crossJoin", "Lcom/raizlabs/android/dbflow/sql/language/Join;", "V", "joinTable", "callback", "Lkotlin/Function2;", "Lcom/raizlabs/android/dbflow/structure/database/transaction/QueryTransaction;", "listener", "deleteOn", "kClass", "else", "value", "(Lcom/raizlabs/android/dbflow/sql/language/Case;Ljava/lang/Object;)Lcom/raizlabs/android/dbflow/sql/language/Case;", "end", "Lcom/raizlabs/android/dbflow/sql/language/property/Property;", "columnName", "from", "fromClause", "groupBy", "Lcom/raizlabs/android/dbflow/sql/language/Transformable;", "nameAlias", "having", "innerJoin", "insertOn", "join", "TJoin", "joinType", "Lcom/raizlabs/android/dbflow/sql/language/Join$JoinType;", "function", "leftOuterJoin", "limit", "", "naturalJoin", "offset", "on", "operatorFunction", "or", "orAbort", "into", "orFail", "orIgnore", "orReplace", "orRollback", "orderBy", "save", "set", "Lcom/raizlabs/android/dbflow/sql/language/Set;", "setClause", "then", "(Lcom/raizlabs/android/dbflow/sql/language/CaseCondition;Ljava/lang/Object;)Lcom/raizlabs/android/dbflow/sql/language/Case;", "toCustomList", "toCustomListClose", "toCustomModel", "(Lcom/raizlabs/android/dbflow/sql/language/CursorResult;)Ljava/lang/Object;", "toCustomModelClose", "updateOn", "using", "when", "(Lcom/raizlabs/android/dbflow/sql/language/Case;Ljava/lang/Object;)Lcom/raizlabs/android/dbflow/sql/language/CaseCondition;", "where", "whereExists", "dbflow-kotlinextensions_release"}, k = 2, mv = {1, 1, 7})
/* compiled from: QueryExtensions.kt */
public final class QueryExtensionsKt {
    public static final Pair<IProperty<?>, ?>[] columnValues(Pair<? extends IProperty<?>, ?>... pairArr) {
        Intrinsics.b(pairArr, "pairs");
        return pairArr;
    }

    public static final Select getSelect() {
        Select select = SQLite.select(new IProperty[0]);
        Intrinsics.a(select, "SQLite.select()");
        return select;
    }

    private static final <T> From<T> from(Select select) {
        Intrinsics.b();
        return select.from(Object.class);
    }

    public static final <T> From<T> delete(KClass<T> kClass) {
        Intrinsics.b(kClass, "modelClass");
        return SQLite.delete(JvmClassMappingKt.a(kClass));
    }

    public static final <T> From<T> from(Select select, KClass<T> kClass) {
        Intrinsics.b(select, "$receiver");
        Intrinsics.b(kClass, "modelClass");
        return select.from(JvmClassMappingKt.a(kClass));
    }

    public static final <T> Where<T> whereExists(From<T> from, Where<T> where) {
        Intrinsics.b(from, "$receiver");
        Intrinsics.b(where, "where");
        return from.where(new SQLOperator[0]).exists(where);
    }

    public static final <T> Where<T> where(From<T> from, SQLOperator sQLOperator) {
        Intrinsics.b(from, "$receiver");
        Intrinsics.b(sQLOperator, "sqlOperator");
        return from.where(sQLOperator);
    }

    public static final <T> From<T> as(From<T> from, String str) {
        Intrinsics.b(from, "$receiver");
        Intrinsics.b(str, "alias");
        return from.as(str);
    }

    public static final <T> Where<T> where(Set<T> set, SQLOperator sQLOperator) {
        Intrinsics.b(set, "$receiver");
        Intrinsics.b(sQLOperator, "sqlOperator");
        return set.where(sQLOperator);
    }

    public static final <T> Where<T> and(Where<T> where, SQLOperator sQLOperator) {
        Intrinsics.b(where, "$receiver");
        Intrinsics.b(sQLOperator, "sqlOperator");
        return where.and(sQLOperator);
    }

    public static final <T> Where<T> or(Where<T> where, SQLOperator sQLOperator) {
        Intrinsics.b(where, "$receiver");
        Intrinsics.b(sQLOperator, "sqlOperator");
        return where.or(sQLOperator);
    }

    public static final <T> CaseCondition<T> when(Case<T> caseR, SQLOperator sQLOperator) {
        Intrinsics.b(caseR, "$receiver");
        Intrinsics.b(sQLOperator, "sqlOperator");
        return caseR.when(sQLOperator);
    }

    public static final <T> CaseCondition<T> when(Case<T> caseR, IProperty<?> iProperty) {
        Intrinsics.b(caseR, "$receiver");
        Intrinsics.b(iProperty, "property");
        return caseR.when((IProperty) iProperty);
    }

    public static final <T> CaseCondition<T> when(Case<T> caseR, T t) {
        Intrinsics.b(caseR, "$receiver");
        return caseR.when((Object) t);
    }

    public static final <T> Case<T> then(CaseCondition<T> caseCondition, T t) {
        Intrinsics.b(caseCondition, "$receiver");
        return caseCondition.then((Object) t);
    }

    public static final <T> Case<T> then(CaseCondition<T> caseCondition, IProperty<?> iProperty) {
        Intrinsics.b(caseCondition, "$receiver");
        Intrinsics.b(iProperty, "property");
        return caseCondition.then((IProperty) iProperty);
    }

    public static final <T> Case<T> m8716else(Case<T> caseR, T t) {
        Intrinsics.b(caseR, "$receiver");
        return caseR._else(t);
    }

    public static final <T> Property<Case<T>> end(Case<T> caseR, String str) {
        Intrinsics.b(caseR, "$receiver");
        Intrinsics.b(str, "columnName");
        return caseR.end(str);
    }

    public static final <T> Case<T> m8715case(IProperty<?> iProperty) {
        Intrinsics.b(iProperty, "caseColumn");
        return SQLite._case((IProperty) iProperty);
    }

    public static final <T> CaseCondition<T> caseWhen(SQLOperator sQLOperator) {
        Intrinsics.b(sQLOperator, "operator");
        return SQLite.caseWhen(sQLOperator);
    }

    private static final <T> Insert<T> insert() {
        Intrinsics.b();
        return new Insert(Object.class);
    }

    private static final <T> Index<T> indexOn(String str, IProperty<?>... iPropertyArr) {
        Index index = new Index(str);
        Intrinsics.b();
        return index.on(Object.class, (IProperty[]) Arrays.copyOf(iPropertyArr, iPropertyArr.length));
    }

    private static final <T> Index<T> indexOn(String str, NameAlias nameAlias, NameAlias... nameAliasArr) {
        Index index = new Index(str);
        Intrinsics.b();
        return index.on(Object.class, nameAlias, (NameAlias[]) Arrays.copyOf(nameAliasArr, nameAliasArr.length));
    }

    public static final long getCount(Queriable queriable) {
        Intrinsics.b(queriable, "$receiver");
        return queriable.count();
    }

    public static final FlowCursor getCursor(Queriable queriable) {
        Intrinsics.b(queriable, "$receiver");
        return queriable.query();
    }

    public static final boolean getHasData(Queriable queriable) {
        Intrinsics.b(queriable, "$receiver");
        return queriable.hasData();
    }

    public static final DatabaseStatement getStatement(Queriable queriable) {
        Intrinsics.b(queriable, "$receiver");
        return queriable.compileStatement();
    }

    public static final <T> List<T> getList(ModelQueriable<T> modelQueriable) {
        Intrinsics.b(modelQueriable, "$receiver");
        return modelQueriable.queryList();
    }

    public static final <T> T getResult(ModelQueriable<T> modelQueriable) {
        Intrinsics.b(modelQueriable, "$receiver");
        return modelQueriable.querySingle();
    }

    public static final <T> CursorResult<T> getCursorResult(ModelQueriable<T> modelQueriable) {
        Intrinsics.b(modelQueriable, "$receiver");
        return modelQueriable.queryResults();
    }

    public static final <T> FlowQueryList<T> getFlowQueryList(ModelQueriable<T> modelQueriable) {
        Intrinsics.b(modelQueriable, "$receiver");
        return modelQueriable.flowQueryList();
    }

    public static final <T> FlowCursorList<T> getCursorList(ModelQueriable<T> modelQueriable) {
        Intrinsics.b(modelQueriable, "$receiver");
        return modelQueriable.cursorList();
    }

    private static final <T> List<T> toCustomList(CursorResult<?> cursorResult) {
        Intrinsics.b();
        return cursorResult.toCustomList(Object.class);
    }

    private static final <T> List<T> toCustomListClose(CursorResult<?> cursorResult) {
        Intrinsics.b();
        return cursorResult.toCustomListClose(Object.class);
    }

    private static final <T> T toCustomModel(CursorResult<?> cursorResult) {
        Intrinsics.b();
        return cursorResult.toCustomModel(Object.class);
    }

    private static final <T> T toCustomModelClose(CursorResult<?> cursorResult) {
        Intrinsics.b();
        return cursorResult.toCustomModelClose(Object.class);
    }

    public static final <T> AsyncQuery<T> getAsync(ModelQueriable<T> modelQueriable) {
        Intrinsics.b(modelQueriable, "$receiver");
        return modelQueriable.async();
    }

    public static final <T> void list(AsyncQuery<T> asyncQuery, Function2<? super QueryTransaction<?>, ? super List<T>, Unit> function2) {
        Intrinsics.b(asyncQuery, "$receiver");
        Intrinsics.b(function2, "callback");
        asyncQuery.queryListResultCallback(new QueryExtensionsKt$list$1(function2)).execute();
    }

    public static final <T> void result(AsyncQuery<T> asyncQuery, Function2<? super QueryTransaction<?>, ? super T, Unit> function2) {
        Intrinsics.b(asyncQuery, "$receiver");
        Intrinsics.b(function2, "callback");
        asyncQuery.querySingleResultCallback(new QueryExtensionsKt$result$1(function2)).execute();
    }

    public static final <T> void cursorResult(AsyncQuery<T> asyncQuery, Function2<? super QueryTransaction<?>, ? super CursorResult<T>, Unit> function2) {
        Intrinsics.b(asyncQuery, "$receiver");
        Intrinsics.b(function2, "callback");
        asyncQuery.queryResultCallback(new QueryExtensionsKt$cursorResult$1(function2)).execute();
    }

    public static final AsyncModel<? extends Model> getAsync(Model model) {
        Intrinsics.b(model, "$receiver");
        return model.async();
    }

    public static final <T> long insert(AsyncModel<T> asyncModel, Function1<? super T, Unit> function1) {
        Intrinsics.b(asyncModel, "$receiver");
        Intrinsics.b(function1, "listener");
        return asyncModel.withListener(new QueryExtensionsKt$insert$1(function1)).insert();
    }

    public static final <T> boolean update(AsyncModel<T> asyncModel, Function1<? super T, Unit> function1) {
        Intrinsics.b(asyncModel, "$receiver");
        Intrinsics.b(function1, "listener");
        return asyncModel.withListener(new QueryExtensionsKt$update$1(function1)).update();
    }

    public static final <T> boolean delete(AsyncModel<T> asyncModel, Function1<? super T, Unit> function1) {
        Intrinsics.b(asyncModel, "$receiver");
        Intrinsics.b(function1, "listener");
        return asyncModel.withListener(new QueryExtensionsKt$delete$1(function1)).delete();
    }

    public static final <T> boolean save(AsyncModel<T> asyncModel, Function1<? super T, Unit> function1) {
        Intrinsics.b(asyncModel, "$receiver");
        Intrinsics.b(function1, "listener");
        return asyncModel.withListener(new QueryExtensionsKt$save$1(function1)).save();
    }

    public static final <T> Where<T> groupBy(Transformable<T> transformable, NameAlias nameAlias) {
        Intrinsics.b(transformable, "$receiver");
        Intrinsics.b(nameAlias, "nameAlias");
        transformable = transformable.groupBy(nameAlias);
        Intrinsics.a(transformable, "groupBy(nameAlias)");
        return transformable;
    }

    public static final <T> Where<T> groupBy(Transformable<T> transformable, IProperty<?> iProperty) {
        Intrinsics.b(transformable, "$receiver");
        Intrinsics.b(iProperty, "property");
        transformable = transformable.groupBy(iProperty);
        Intrinsics.a(transformable, "groupBy(property)");
        return transformable;
    }

    public static final <T> Where<T> orderBy(Transformable<T> transformable, OrderBy orderBy) {
        Intrinsics.b(transformable, "$receiver");
        Intrinsics.b(orderBy, "orderBy");
        transformable = transformable.orderBy(orderBy);
        Intrinsics.a(transformable, "orderBy(orderBy)");
        return transformable;
    }

    public static final <T> Where<T> limit(Transformable<T> transformable, int i) {
        Intrinsics.b(transformable, "$receiver");
        transformable = transformable.limit(i);
        Intrinsics.a(transformable, "limit(limit)");
        return transformable;
    }

    public static final <T> Where<T> offset(Transformable<T> transformable, int i) {
        Intrinsics.b(transformable, "$receiver");
        transformable = transformable.offset(i);
        Intrinsics.a(transformable, "offset(offset)");
        return transformable;
    }

    public static final <T> Where<T> having(Transformable<T> transformable, SQLOperator sQLOperator) {
        Intrinsics.b(transformable, "$receiver");
        Intrinsics.b(sQLOperator, "sqlOperator");
        transformable = transformable.having(sQLOperator);
        Intrinsics.a(transformable, "having(sqlOperator)");
        return transformable;
    }

    public static final OrderBy collate(OrderBy orderBy, Collate collate) {
        Intrinsics.b(orderBy, "$receiver");
        Intrinsics.b(collate, "collate");
        return orderBy.collate(collate);
    }

    public static final <T, V> Join<T, V> innerJoin(From<V> from, KClass<T> kClass) {
        Intrinsics.b(from, "$receiver");
        Intrinsics.b(kClass, "joinTable");
        from = from.join(JvmClassMappingKt.a(kClass), JoinType.INNER);
        Intrinsics.a(from, "join(joinTable.java, Join.JoinType.INNER)");
        return from;
    }

    public static final <T, V> Join<T, V> crossJoin(From<V> from, KClass<T> kClass) {
        Intrinsics.b(from, "$receiver");
        Intrinsics.b(kClass, "joinTable");
        from = from.join(JvmClassMappingKt.a(kClass), JoinType.CROSS);
        Intrinsics.a(from, "join(joinTable.java, Join.JoinType.CROSS)");
        return from;
    }

    public static final <T, V> Join<T, V> leftOuterJoin(From<V> from, KClass<T> kClass) {
        Intrinsics.b(from, "$receiver");
        Intrinsics.b(kClass, "joinTable");
        from = from.join(JvmClassMappingKt.a(kClass), JoinType.LEFT_OUTER);
        Intrinsics.a(from, "join(joinTable.java, Join.JoinType.LEFT_OUTER)");
        return from;
    }

    public static final <T, V> Join<T, V> naturalJoin(From<V> from, KClass<T> kClass) {
        Intrinsics.b(from, "$receiver");
        Intrinsics.b(kClass, "joinTable");
        from = from.join(JvmClassMappingKt.a(kClass), JoinType.NATURAL);
        Intrinsics.a(from, "join(joinTable.java, Join.JoinType.NATURAL)");
        return from;
    }

    public static final <T, V> From<V> on(Join<T, V> join, SQLOperator sQLOperator) {
        Intrinsics.b(join, "$receiver");
        Intrinsics.b(sQLOperator, "sqlOperator");
        join = join.on(sQLOperator);
        Intrinsics.a(join, "on(sqlOperator)");
        return join;
    }

    public static final <T, V> From<V> using(Join<T, V> join, IProperty<?> iProperty) {
        Intrinsics.b(join, "$receiver");
        Intrinsics.b(iProperty, "property");
        join = join.using(iProperty);
        Intrinsics.a(join, "using(property)");
        return join;
    }

    private static final <T> Update<T> update() {
        Intrinsics.b();
        return SQLite.update(Object.class);
    }

    public static final <T> Set<T> set(Update<T> update, SQLOperator sQLOperator) {
        Intrinsics.b(update, "$receiver");
        Intrinsics.b(sQLOperator, "sqlOperator");
        return update.set(sQLOperator);
    }

    private static final <T> From<T> delete() {
        Intrinsics.b();
        return SQLite.delete(Object.class);
    }

    private static final <T> BaseModelQueriable<T> delete(Function1<? super From<T>, ? extends BaseModelQueriable<T>> function1) {
        Intrinsics.b();
        From delete = SQLite.delete(Object.class);
        Intrinsics.a(delete, "SQLite.delete(T::class.java)");
        return (BaseModelQueriable) function1.a(delete);
    }

    public static final <T> Insert<T> insert(KClass<T> kClass) {
        Intrinsics.b(kClass, "modelClass");
        return SQLite.insert(JvmClassMappingKt.a(kClass));
    }

    public static final <T> Insert<T> orReplace(Insert<T> insert, Pair<? extends IProperty<?>, ?>[] pairArr) {
        Intrinsics.b(insert, "$receiver");
        Intrinsics.b(pairArr, "into");
        return columnValues(insert.orReplace(), (Pair[]) Arrays.copyOf(pairArr, pairArr.length));
    }

    public static final <T> Insert<T> orRollback(Insert<T> insert, Pair<? extends IProperty<?>, ?>[] pairArr) {
        Intrinsics.b(insert, "$receiver");
        Intrinsics.b(pairArr, "into");
        return columnValues(insert.orRollback(), (Pair[]) Arrays.copyOf(pairArr, pairArr.length));
    }

    public static final <T> Insert<T> orAbort(Insert<T> insert, Pair<? extends IProperty<?>, ?>[] pairArr) {
        Intrinsics.b(insert, "$receiver");
        Intrinsics.b(pairArr, "into");
        return columnValues(insert.orAbort(), (Pair[]) Arrays.copyOf(pairArr, pairArr.length));
    }

    public static final <T> Insert<T> orFail(Insert<T> insert, Pair<? extends IProperty<?>, ?>[] pairArr) {
        Intrinsics.b(insert, "$receiver");
        Intrinsics.b(pairArr, "into");
        return columnValues(insert.orFail(), (Pair[]) Arrays.copyOf(pairArr, pairArr.length));
    }

    public static final <T> Insert<T> orIgnore(Insert<T> insert, Pair<? extends IProperty<?>, ?>[] pairArr) {
        Intrinsics.b(insert, "$receiver");
        Intrinsics.b(pairArr, "into");
        return columnValues(insert.orIgnore(), (Pair[]) Arrays.copyOf(pairArr, pairArr.length));
    }

    public static final <T> Insert<T> select(Insert<T> insert, From<?> from) {
        Intrinsics.b(insert, "$receiver");
        Intrinsics.b(from, "from");
        insert = insert.select(from);
        Intrinsics.a(insert, "select(from)");
        return insert;
    }

    public static final <T> Insert<T> columnValues(Insert<T> insert, Pair<? extends IProperty<?>, ?>... pairArr) {
        Intrinsics.b(insert, "$receiver");
        Intrinsics.b(pairArr, "pairs");
        List arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Object[] objArr = (Object[]) pairArr;
        for (Object obj : objArr) {
            Pair pair = (Pair) obj;
            arrayList.add(pair.a);
            arrayList2.add(pair.b);
        }
        insert.columns(arrayList).values((Collection) arrayList2);
        return insert;
    }

    public static final Trigger createTrigger(String str) {
        Intrinsics.b(str, "name");
        return Trigger.create(str);
    }

    public static final <T> TriggerMethod<T> deleteOn(Trigger trigger, KClass<T> kClass) {
        Intrinsics.b(trigger, "$receiver");
        Intrinsics.b(kClass, "kClass");
        return trigger.deleteOn(JvmClassMappingKt.a(kClass));
    }

    public static final <T> TriggerMethod<T> insertOn(Trigger trigger, KClass<T> kClass) {
        Intrinsics.b(trigger, "$receiver");
        Intrinsics.b(kClass, "kClass");
        return trigger.insertOn(JvmClassMappingKt.a(kClass));
    }

    public static final <T> TriggerMethod<T> updateOn(Trigger trigger, KClass<T> kClass) {
        Intrinsics.b(trigger, "$receiver");
        Intrinsics.b(kClass, "kClass");
        return trigger.updateOn(JvmClassMappingKt.a(kClass), new IProperty[0]);
    }

    public static final <T> CompletedTrigger<T> begin(TriggerMethod<T> triggerMethod, Query query) {
        Intrinsics.b(triggerMethod, "$receiver");
        Intrinsics.b(query, "triggerStatement");
        return triggerMethod.begin(query);
    }

    public static final <T> CompletedTrigger<T> and(CompletedTrigger<T> completedTrigger, Query query) {
        Intrinsics.b(completedTrigger, "$receiver");
        Intrinsics.b(query, "nextStatement");
        return completedTrigger.and(query);
    }

    public static final <T> BaseModelQueriable<T> select(IProperty<? extends IProperty<?>>[] iPropertyArr, Function1<? super Select, ? extends BaseModelQueriable<T>> function1) {
        Intrinsics.b(iPropertyArr, "property");
        Intrinsics.b(function1, "init");
        iPropertyArr = SQLite.select((IProperty[]) Arrays.copyOf(iPropertyArr, iPropertyArr.length));
        Intrinsics.a(iPropertyArr, "select");
        return (BaseModelQueriable) function1.a(iPropertyArr);
    }

    public static final <T> BaseModelQueriable<T> select(Function1<? super Select, ? extends BaseModelQueriable<T>> function1) {
        Intrinsics.b(function1, "init");
        Select select = SQLite.select(new IProperty[0]);
        Intrinsics.a(select, "SQLite.select()");
        return (BaseModelQueriable) function1.a(select);
    }

    private static final <T> Where<T> from(Select select, Function1<? super From<T>, ? extends Where<T>> function1) {
        Intrinsics.b();
        select = select.from(Object.class);
        Intrinsics.a(select, "from(T::class.java)");
        return (Where) function1.a(select);
    }

    public static final <T> Where<T> where(From<T> from, Function0<? extends SQLOperator> function0) {
        Intrinsics.b(from, "$receiver");
        Intrinsics.b(function0, "sqlOperatorClause");
        return from.where((SQLOperator) function0.invoke());
    }

    public static final <T> Where<T> where(Set<T> set, Function0<? extends SQLOperator> function0) {
        Intrinsics.b(set, "$receiver");
        Intrinsics.b(function0, "sqlOperatorClause");
        return set.where((SQLOperator) function0.invoke());
    }

    public static final <T> Where<T> and(Where<T> where, Function0<? extends SQLOperator> function0) {
        Intrinsics.b(where, "$receiver");
        Intrinsics.b(function0, "sqlOperatorClause");
        return where.and((SQLOperator) function0.invoke());
    }

    public static final <T> Where<T> or(Where<T> where, Function0<? extends SQLOperator> function0) {
        Intrinsics.b(where, "$receiver");
        Intrinsics.b(function0, "sqlOperatorClause");
        return where.or((SQLOperator) function0.invoke());
    }

    private static final <T, TJoin> Where<T> join(From<T> from, JoinType joinType, Function1<? super Join<TJoin, T>, Unit> function1) {
        Intrinsics.b();
        joinType = from.join(Object.class, joinType);
        Intrinsics.a(joinType, "join(TJoin::class.java, joinType)");
        function1.a(joinType);
        from = from.where(new SQLOperator[null]);
        Intrinsics.a(from, "where()");
        return from;
    }

    private static final <T> Insert<T> insert(Function1<? super Insert<T>, Unit> function1) {
        Intrinsics.b();
        Insert<T> insert = SQLite.insert(Object.class);
        Intrinsics.a(insert, "this");
        function1.a(insert);
        return insert;
    }

    public static final <T, TJoin> From<T> on(Join<TJoin, T> join, Function0<? extends SQLOperator[]> function0) {
        Intrinsics.b(join, "$receiver");
        Intrinsics.b(function0, "operatorFunction");
        SQLOperator[] sQLOperatorArr = (SQLOperator[]) function0.invoke();
        return join.on((SQLOperator[]) Arrays.copyOf(sQLOperatorArr, sQLOperatorArr.length));
    }

    private static final <T> BaseModelQueriable<T> update(Function1<? super Update<T>, ? extends BaseModelQueriable<T>> function1) {
        Intrinsics.b();
        Update update = SQLite.update(Object.class);
        Intrinsics.a(update, "SQLite.update(T::class.java)");
        return (BaseModelQueriable) function1.a(update);
    }

    public static final <T> Where<T> set(Update<T> update, Function1<? super Set<T>, ? extends Where<T>> function1) {
        Intrinsics.b(update, "$receiver");
        Intrinsics.b(function1, "setClause");
        update = update.set(new SQLOperator[0]);
        Intrinsics.a(update, "set()");
        return (Where) function1.a(update);
    }
}
