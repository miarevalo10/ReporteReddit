package kotlin.text;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CharIterator;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\f\n\u0002\u0010\u0019\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\u001a\u001c\u0010\t\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u001c\u0010\u000e\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u001f\u0010\u000f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\rH\u0002\u001a\u001f\u0010\u000f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\rH\u0002\u001a\u0015\u0010\u000f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\n\u001a\u001c\u0010\u0014\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u001c\u0010\u0014\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\r\u001a:\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017*\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001aE\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017*\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\rH\u0002¢\u0006\u0002\b\u001c\u001a:\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017*\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u0012\u0010\u001e\u001a\u00020\r*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0006\u001a&\u0010 \u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a;\u0010 \u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u001b\u001a\u00020\rH\u0002¢\u0006\u0002\b\"\u001a&\u0010 \u001a\u00020\u0006*\u00020\u00022\u0006\u0010#\u001a\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a&\u0010$\u001a\u00020\u0006*\u00020\u00022\u0006\u0010%\u001a\u00020&2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a,\u0010$\u001a\u00020\u0006*\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a\r\u0010'\u001a\u00020\r*\u00020\u0002H\b\u001a\r\u0010(\u001a\u00020\r*\u00020\u0002H\b\u001a\r\u0010)\u001a\u00020\r*\u00020\u0002H\b\u001a \u0010*\u001a\u00020\r*\u0004\u0018\u00010\u0002H\b\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a \u0010+\u001a\u00020\r*\u0004\u0018\u00010\u0002H\b\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a\r\u0010,\u001a\u00020-*\u00020\u0002H\u0002\u001a&\u0010.\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a&\u0010.\u001a\u00020\u0006*\u00020\u00022\u0006\u0010#\u001a\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a&\u0010/\u001a\u00020\u0006*\u00020\u00022\u0006\u0010%\u001a\u00020&2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a,\u0010/\u001a\u00020\u0006*\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u0010\u00100\u001a\b\u0012\u0004\u0012\u00020\n01*\u00020\u0002\u001a\u0010\u00102\u001a\b\u0012\u0004\u0012\u00020\n03*\u00020\u0002\u001a\u0015\u00104\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\f\u001a\u000f\u00105\u001a\u00020\n*\u0004\u0018\u00010\nH\b\u001a\u001c\u00106\u001a\u00020\u0002*\u00020\u00022\u0006\u00107\u001a\u00020\u00062\b\b\u0002\u00108\u001a\u00020\u0011\u001a\u001c\u00106\u001a\u00020\n*\u00020\n2\u0006\u00107\u001a\u00020\u00062\b\b\u0002\u00108\u001a\u00020\u0011\u001a\u001c\u00109\u001a\u00020\u0002*\u00020\u00022\u0006\u00107\u001a\u00020\u00062\b\b\u0002\u00108\u001a\u00020\u0011\u001a\u001c\u00109\u001a\u00020\n*\u00020\n2\u0006\u00107\u001a\u00020\u00062\b\b\u0002\u00108\u001a\u00020\u0011\u001aG\u0010:\u001a\b\u0012\u0004\u0012\u00020\u000101*\u00020\u00022\u000e\u0010;\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0<2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010=\u001a\u00020\u0006H\u0002¢\u0006\u0004\b>\u0010?\u001a=\u0010:\u001a\b\u0012\u0004\u0012\u00020\u000101*\u00020\u00022\u0006\u0010;\u001a\u00020&2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010=\u001a\u00020\u0006H\u0002¢\u0006\u0002\b>\u001a4\u0010@\u001a\u00020\r*\u00020\u00022\u0006\u0010A\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010B\u001a\u00020\u00062\u0006\u00107\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0000\u001a\u0012\u0010C\u001a\u00020\u0002*\u00020\u00022\u0006\u0010D\u001a\u00020\u0002\u001a\u0012\u0010C\u001a\u00020\n*\u00020\n2\u0006\u0010D\u001a\u00020\u0002\u001a\u001a\u0010E\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0006\u001a\u0012\u0010E\u001a\u00020\u0002*\u00020\u00022\u0006\u0010F\u001a\u00020\u0001\u001a\u001d\u0010E\u001a\u00020\n*\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0006H\b\u001a\u0015\u0010E\u001a\u00020\n*\u00020\n2\u0006\u0010F\u001a\u00020\u0001H\b\u001a\u0012\u0010G\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002\u001a\u0012\u0010G\u001a\u00020\n*\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0002\u001a\u0012\u0010H\u001a\u00020\u0002*\u00020\u00022\u0006\u0010I\u001a\u00020\u0002\u001a\u001a\u0010H\u001a\u00020\u0002*\u00020\u00022\u0006\u0010D\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002\u001a\u0012\u0010H\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\u0002\u001a\u001a\u0010H\u001a\u00020\n*\u00020\n2\u0006\u0010D\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002\u001a+\u0010J\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0014\b\b\u0010K\u001a\u000e\u0012\u0004\u0012\u00020M\u0012\u0004\u0012\u00020\u00020LH\b\u001a\u001d\u0010J\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010N\u001a\u00020\nH\b\u001a$\u0010O\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\u00112\u0006\u0010N\u001a\u00020\n2\b\b\u0002\u0010P\u001a\u00020\n\u001a$\u0010O\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\n2\u0006\u0010N\u001a\u00020\n2\b\b\u0002\u0010P\u001a\u00020\n\u001a$\u0010Q\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\u00112\u0006\u0010N\u001a\u00020\n2\b\b\u0002\u0010P\u001a\u00020\n\u001a$\u0010Q\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\n2\u0006\u0010N\u001a\u00020\n2\b\b\u0002\u0010P\u001a\u00020\n\u001a$\u0010R\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\u00112\u0006\u0010N\u001a\u00020\n2\b\b\u0002\u0010P\u001a\u00020\n\u001a$\u0010R\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\n2\u0006\u0010N\u001a\u00020\n2\b\b\u0002\u0010P\u001a\u00020\n\u001a$\u0010S\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\u00112\u0006\u0010N\u001a\u00020\n2\b\b\u0002\u0010P\u001a\u00020\n\u001a$\u0010S\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\n2\u0006\u0010N\u001a\u00020\n2\b\b\u0002\u0010P\u001a\u00020\n\u001a\u001d\u0010T\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010N\u001a\u00020\nH\b\u001a\"\u0010U\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00062\u0006\u0010N\u001a\u00020\u0002\u001a\u001a\u0010U\u001a\u00020\u0002*\u00020\u00022\u0006\u0010F\u001a\u00020\u00012\u0006\u0010N\u001a\u00020\u0002\u001a%\u0010U\u001a\u00020\n*\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00062\u0006\u0010N\u001a\u00020\u0002H\b\u001a\u001d\u0010U\u001a\u00020\n*\u00020\n2\u0006\u0010F\u001a\u00020\u00012\u0006\u0010N\u001a\u00020\u0002H\b\u001a=\u0010V\u001a\b\u0012\u0004\u0012\u00020\n03*\u00020\u00022\u0012\u0010;\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0<\"\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010=\u001a\u00020\u0006¢\u0006\u0002\u0010W\u001a0\u0010V\u001a\b\u0012\u0004\u0012\u00020\n03*\u00020\u00022\n\u0010;\u001a\u00020&\"\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010=\u001a\u00020\u0006\u001a/\u0010V\u001a\b\u0012\u0004\u0012\u00020\n03*\u00020\u00022\u0006\u0010I\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010=\u001a\u00020\u0006H\u0002¢\u0006\u0002\bX\u001a%\u0010V\u001a\b\u0012\u0004\u0012\u00020\n03*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010=\u001a\u00020\u0006H\b\u001a=\u0010Y\u001a\b\u0012\u0004\u0012\u00020\n01*\u00020\u00022\u0012\u0010;\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0<\"\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010=\u001a\u00020\u0006¢\u0006\u0002\u0010Z\u001a0\u0010Y\u001a\b\u0012\u0004\u0012\u00020\n01*\u00020\u00022\n\u0010;\u001a\u00020&\"\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010=\u001a\u00020\u0006\u001a\u001c\u0010[\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u001c\u0010[\u001a\u00020\r*\u00020\u00022\u0006\u0010D\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\r\u001a$\u0010[\u001a\u00020\r*\u00020\u00022\u0006\u0010D\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u0012\u0010\\\u001a\u00020\u0002*\u00020\u00022\u0006\u0010F\u001a\u00020\u0001\u001a\u001d\u0010\\\u001a\u00020\u0002*\u00020\n2\u0006\u0010]\u001a\u00020\u00062\u0006\u0010^\u001a\u00020\u0006H\b\u001a\u001f\u0010_\u001a\u00020\n*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010!\u001a\u00020\u0006H\b\u001a\u0012\u0010_\u001a\u00020\n*\u00020\u00022\u0006\u0010F\u001a\u00020\u0001\u001a\u0012\u0010_\u001a\u00020\n*\u00020\n2\u0006\u0010F\u001a\u00020\u0001\u001a\u001c\u0010`\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\u00112\b\b\u0002\u0010P\u001a\u00020\n\u001a\u001c\u0010`\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\n2\b\b\u0002\u0010P\u001a\u00020\n\u001a\u001c\u0010a\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\u00112\b\b\u0002\u0010P\u001a\u00020\n\u001a\u001c\u0010a\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\n2\b\b\u0002\u0010P\u001a\u00020\n\u001a\u001c\u0010b\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\u00112\b\b\u0002\u0010P\u001a\u00020\n\u001a\u001c\u0010b\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\n2\b\b\u0002\u0010P\u001a\u00020\n\u001a\u001c\u0010c\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\u00112\b\b\u0002\u0010P\u001a\u00020\n\u001a\u001c\u0010c\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\n2\b\b\u0002\u0010P\u001a\u00020\n\u001a\n\u0010d\u001a\u00020\u0002*\u00020\u0002\u001a!\u0010d\u001a\u00020\u0002*\u00020\u00022\u0012\u0010e\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0LH\b\u001a\u0016\u0010d\u001a\u00020\u0002*\u00020\u00022\n\u0010%\u001a\u00020&\"\u00020\u0011\u001a\r\u0010d\u001a\u00020\n*\u00020\nH\b\u001a!\u0010d\u001a\u00020\n*\u00020\n2\u0012\u0010e\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0LH\b\u001a\u0016\u0010d\u001a\u00020\n*\u00020\n2\n\u0010%\u001a\u00020&\"\u00020\u0011\u001a\n\u0010f\u001a\u00020\u0002*\u00020\u0002\u001a!\u0010f\u001a\u00020\u0002*\u00020\u00022\u0012\u0010e\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0LH\b\u001a\u0016\u0010f\u001a\u00020\u0002*\u00020\u00022\n\u0010%\u001a\u00020&\"\u00020\u0011\u001a\r\u0010f\u001a\u00020\n*\u00020\nH\b\u001a!\u0010f\u001a\u00020\n*\u00020\n2\u0012\u0010e\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0LH\b\u001a\u0016\u0010f\u001a\u00020\n*\u00020\n2\n\u0010%\u001a\u00020&\"\u00020\u0011\u001a\n\u0010g\u001a\u00020\u0002*\u00020\u0002\u001a!\u0010g\u001a\u00020\u0002*\u00020\u00022\u0012\u0010e\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0LH\b\u001a\u0016\u0010g\u001a\u00020\u0002*\u00020\u00022\n\u0010%\u001a\u00020&\"\u00020\u0011\u001a\r\u0010g\u001a\u00020\n*\u00020\nH\b\u001a!\u0010g\u001a\u00020\n*\u00020\n2\u0012\u0010e\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0LH\b\u001a\u0016\u0010g\u001a\u00020\n*\u00020\n2\n\u0010%\u001a\u00020&\"\u00020\u0011\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006h"}, d2 = {"indices", "Lkotlin/ranges/IntRange;", "", "getIndices", "(Ljava/lang/CharSequence;)Lkotlin/ranges/IntRange;", "lastIndex", "", "getLastIndex", "(Ljava/lang/CharSequence;)I", "commonPrefixWith", "", "other", "ignoreCase", "", "commonSuffixWith", "contains", "char", "", "regex", "Lkotlin/text/Regex;", "endsWith", "suffix", "findAnyOf", "Lkotlin/Pair;", "strings", "", "startIndex", "last", "findAnyOf$StringsKt__StringsKt", "findLastAnyOf", "hasSurrogatePairAt", "index", "indexOf", "endIndex", "indexOf$StringsKt__StringsKt", "string", "indexOfAny", "chars", "", "isEmpty", "isNotBlank", "isNotEmpty", "isNullOrBlank", "isNullOrEmpty", "iterator", "Lkotlin/collections/CharIterator;", "lastIndexOf", "lastIndexOfAny", "lineSequence", "Lkotlin/sequences/Sequence;", "lines", "", "matches", "orEmpty", "padEnd", "length", "padChar", "padStart", "rangesDelimitedBy", "delimiters", "", "limit", "rangesDelimitedBy$StringsKt__StringsKt", "(Ljava/lang/CharSequence;[Ljava/lang/String;IZI)Lkotlin/sequences/Sequence;", "regionMatchesImpl", "thisOffset", "otherOffset", "removePrefix", "prefix", "removeRange", "range", "removeSuffix", "removeSurrounding", "delimiter", "replace", "transform", "Lkotlin/Function1;", "Lkotlin/text/MatchResult;", "replacement", "replaceAfter", "missingDelimiterValue", "replaceAfterLast", "replaceBefore", "replaceBeforeLast", "replaceFirst", "replaceRange", "split", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Ljava/util/List;", "split$StringsKt__StringsKt", "splitToSequence", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Lkotlin/sequences/Sequence;", "startsWith", "subSequence", "start", "end", "substring", "substringAfter", "substringAfterLast", "substringBefore", "substringBeforeLast", "trim", "predicate", "trimEnd", "trimStart", "kotlin-stdlib"}, k = 5, mv = {1, 1, 9}, xi = 1, xs = "kotlin/text/StringsKt")
/* compiled from: Strings.kt */
public class StringsKt__StringsKt extends StringsKt__StringsJVMKt {
    public static final CharIterator m42463c(CharSequence charSequence) {
        Intrinsics.m26847b(charSequence, "$receiver");
        return new StringsKt__StringsKt$iterator$1(charSequence);
    }

    public static final IntRange m42466d(CharSequence charSequence) {
        Intrinsics.m26847b(charSequence, "$receiver");
        return new IntRange(0, charSequence.length() - 1);
    }

    public static final int m42467e(CharSequence charSequence) {
        Intrinsics.m26847b(charSequence, "$receiver");
        return charSequence.length() - 1;
    }

    public static /* synthetic */ String m42445a(String str, char c) {
        Intrinsics.m26847b(str, "$receiver");
        Intrinsics.m26847b(str, "missingDelimiterValue");
        c = m42439a((CharSequence) str, c, 0, 6);
        if (c == '￿') {
            return str;
        }
        Object substring = str.substring(0, c);
        Intrinsics.m26843a(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String m42461c(String str, String str2) {
        Intrinsics.m26847b(str, "$receiver");
        Intrinsics.m26847b(str2, "delimiter");
        Intrinsics.m26847b(str, "missingDelimiterValue");
        str2 = m42442a((CharSequence) str, str2, 0, false, 6);
        if (str2 == -1) {
            return str;
        }
        Object substring = str.substring(0, str2);
        Intrinsics.m26843a(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static final String m42446a(String str, char c, String str2) {
        Intrinsics.m26847b(str, "$receiver");
        Intrinsics.m26847b(str2, "missingDelimiterValue");
        c = m42439a((CharSequence) str, c, 0, 6);
        if (c == '￿') {
            return str2;
        }
        Object substring = str.substring(c + 1, str.length());
        Intrinsics.m26843a(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String m42465d(String str, String str2) {
        Intrinsics.m26847b(str, "$receiver");
        Intrinsics.m26847b(str2, "delimiter");
        Intrinsics.m26847b(str, "missingDelimiterValue");
        int a = m42442a((CharSequence) str, str2, 0, false, 6);
        if (a == -1) {
            return str;
        }
        Object substring = str.substring(a + str2.length(), str.length());
        Intrinsics.m26843a(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static final String m42462c(String str, String str2, String str3) {
        Intrinsics.m26847b(str, "$receiver");
        Intrinsics.m26847b(str2, "delimiter");
        Intrinsics.m26847b(str3, "missingDelimiterValue");
        CharSequence charSequence = str;
        int e = m42467e(charSequence);
        Intrinsics.m26847b(charSequence, "$receiver");
        Intrinsics.m26847b(str2, "string");
        if (charSequence instanceof String) {
            str2 = ((String) charSequence).lastIndexOf(str2, e);
        } else {
            str2 = m42440a(charSequence, str2, e, 0, false, true);
        }
        if (str2 == -1) {
            return str3;
        }
        Object substring = str.substring(null, str2);
        Intrinsics.m26843a(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String m42458b(String str, char c) {
        Intrinsics.m26847b(str, "$receiver");
        Intrinsics.m26847b(str, "missingDelimiterValue");
        c = m42438a((CharSequence) str, c);
        if (c == '￿') {
            return str;
        }
        Object substring = str.substring(c + 1, str.length());
        Intrinsics.m26843a(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static final CharSequence m42443a(CharSequence charSequence, int i, int i2, CharSequence charSequence2) {
        Intrinsics.m26847b(charSequence, "$receiver");
        Intrinsics.m26847b(charSequence2, "replacement");
        if (i2 < i) {
            charSequence2 = new StringBuilder("End index (");
            charSequence2.append(i2);
            charSequence2.append(") is less than start index (");
            charSequence2.append(i);
            charSequence2.append(").");
            throw ((Throwable) new IndexOutOfBoundsException(charSequence2.toString()));
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(charSequence, 0, i);
        stringBuilder.append(charSequence2);
        stringBuilder.append(charSequence, i2, charSequence.length());
        return stringBuilder;
    }

    public static final String m42447a(String str, CharSequence charSequence) {
        boolean b;
        Intrinsics.m26847b(str, "$receiver");
        Intrinsics.m26847b(charSequence, "prefix");
        CharSequence charSequence2 = str;
        Intrinsics.m26847b(charSequence2, "$receiver");
        Intrinsics.m26847b(charSequence, "prefix");
        if ((charSequence2 instanceof String) && (charSequence instanceof String)) {
            b = StringsKt__StringsJVMKt.m41949b((String) charSequence2, (String) charSequence, false);
        } else {
            b = m42453a(charSequence2, charSequence, 0, charSequence.length(), false);
        }
        if (!b) {
            return str;
        }
        Object substring = str.substring(charSequence.length());
        Intrinsics.m26843a(substring, "(this as java.lang.String).substring(startIndex)");
        return substring;
    }

    public static final boolean m42453a(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z) {
        Intrinsics.m26847b(charSequence, "$receiver");
        Intrinsics.m26847b(charSequence2, "other");
        if (i >= 0 && charSequence.length() - i2 >= 0) {
            if (i <= charSequence2.length() - i2) {
                for (int i3 = 0; i3 < i2; i3++) {
                    if (!CharsKt__CharKt.m33728a(charSequence.charAt(0 + i3), charSequence2.charAt(i + i3), z)) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean m42468f(CharSequence charSequence) {
        Intrinsics.m26847b(charSequence, "$receiver");
        return charSequence.length() > 0 && CharsKt__CharKt.m33728a(charSequence.charAt(m42467e(charSequence)), ';', false) != null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final int m42440a(java.lang.CharSequence r3, java.lang.CharSequence r4, int r5, int r6, boolean r7, boolean r8) {
        /*
        r0 = 0;
        if (r8 != 0) goto L_0x0017;
    L_0x0003:
        r5 = kotlin.ranges.RangesKt___RangesKt.m32855c(r5, r0);
        r8 = new kotlin.ranges.IntRange;
        r0 = r3.length();
        r6 = kotlin.ranges.RangesKt___RangesKt.m32856d(r6, r0);
        r8.<init>(r5, r6);
        r8 = (kotlin.ranges.IntProgression) r8;
        goto L_0x0027;
    L_0x0017:
        r8 = m42467e(r3);
        r5 = kotlin.ranges.RangesKt___RangesKt.m32856d(r5, r8);
        r6 = kotlin.ranges.RangesKt___RangesKt.m32855c(r6, r0);
        r8 = kotlin.ranges.RangesKt___RangesKt.m32853a(r5, r6);
    L_0x0027:
        r5 = r3 instanceof java.lang.String;
        if (r5 == 0) goto L_0x0051;
    L_0x002b:
        r5 = r4 instanceof java.lang.String;
        if (r5 == 0) goto L_0x0051;
    L_0x002f:
        r5 = r8.f32536a;
        r6 = r8.f32537b;
        r8 = r8.f32538c;
        if (r8 <= 0) goto L_0x003a;
    L_0x0037:
        if (r5 > r6) goto L_0x006d;
    L_0x0039:
        goto L_0x003c;
    L_0x003a:
        if (r5 < r6) goto L_0x006d;
    L_0x003c:
        r0 = r4;
        r0 = (java.lang.String) r0;
        r1 = r3;
        r1 = (java.lang.String) r1;
        r2 = r4.length();
        r0 = kotlin.text.StringsKt__StringsJVMKt.m41945a(r0, r1, r5, r2, r7);
        if (r0 == 0) goto L_0x004d;
    L_0x004c:
        return r5;
    L_0x004d:
        if (r5 == r6) goto L_0x006d;
    L_0x004f:
        r5 = r5 + r8;
        goto L_0x003c;
    L_0x0051:
        r5 = r8.f32536a;
        r6 = r8.f32537b;
        r8 = r8.f32538c;
        if (r8 <= 0) goto L_0x005c;
    L_0x0059:
        if (r5 > r6) goto L_0x006d;
    L_0x005b:
        goto L_0x005e;
    L_0x005c:
        if (r5 < r6) goto L_0x006d;
    L_0x005e:
        r0 = r4.length();
        r0 = m42453a(r4, r3, r5, r0, r7);
        if (r0 == 0) goto L_0x0069;
    L_0x0068:
        return r5;
    L_0x0069:
        if (r5 == r6) goto L_0x006d;
    L_0x006b:
        r5 = r5 + r8;
        goto L_0x005e;
    L_0x006d:
        r3 = -1;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.StringsKt__StringsKt.a(java.lang.CharSequence, java.lang.CharSequence, int, int, boolean, boolean):int");
    }

    public static /* synthetic */ int m42439a(CharSequence charSequence, char c, int i, int i2) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        Intrinsics.m26847b(charSequence, "$receiver");
        i2 = charSequence instanceof String;
        if (i2 != 0) {
            return ((String) charSequence).indexOf(c, i);
        }
        Object obj = new char[]{c};
        Intrinsics.m26847b(charSequence, "$receiver");
        Intrinsics.m26847b(obj, "chars");
        if (i2 != 0) {
            return ((String) charSequence).indexOf(ArraysKt___ArraysKt.m36079a((char[]) obj), i);
        }
        c = RangesKt___RangesKt.m32855c(i, 0);
        char e = m42467e(charSequence);
        if (c <= e) {
            while (true) {
                i2 = charSequence.charAt(c);
                for (int i3 = 0; i3 <= 0; i3++) {
                    if (CharsKt__CharKt.m33728a(obj[i3], i2, false)) {
                        i2 = 1;
                        break;
                    }
                }
                i2 = 0;
                if (i2 == 0) {
                    if (c == e) {
                        break;
                    }
                    c++;
                } else {
                    return c;
                }
            }
        }
        return -1;
    }

    public static final int m42441a(CharSequence charSequence, String str, int i, boolean z) {
        Intrinsics.m26847b(charSequence, "$receiver");
        Intrinsics.m26847b(str, "string");
        if (!z) {
            if (charSequence instanceof String) {
                return ((String) charSequence).indexOf(str, i);
            }
        }
        return m42440a(charSequence, str, i, charSequence.length(), z, false);
    }

    public static /* synthetic */ int m42438a(CharSequence charSequence, char c) {
        int e = m42467e(charSequence);
        Intrinsics.m26847b(charSequence, "$receiver");
        boolean z = charSequence instanceof String;
        if (z) {
            return ((String) charSequence).lastIndexOf(c, e);
        }
        Object obj = new char[]{c};
        Intrinsics.m26847b(charSequence, "$receiver");
        Intrinsics.m26847b(obj, "chars");
        if (z) {
            return ((String) charSequence).lastIndexOf(ArraysKt___ArraysKt.m36079a((char[]) obj), e);
        }
        for (c = RangesKt___RangesKt.m32856d(e, m42467e(charSequence)); c >= '\u0000'; c--) {
            char charAt = charSequence.charAt(c);
            for (int i = 0; i <= 0; i++) {
                if (CharsKt__CharKt.m33728a(obj[i], charAt, false)) {
                    e = 1;
                    break;
                }
            }
            e = false;
            if (e != 0) {
                return c;
            }
        }
        return -1;
    }

    public static final boolean m42454a(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        Intrinsics.m26847b(charSequence, "$receiver");
        Intrinsics.m26847b(charSequence2, "other");
        return charSequence2 instanceof String ? m42442a(charSequence, (String) charSequence2, 0, z, 2) >= null : m42440a(charSequence, charSequence2, 0, charSequence.length(), z, false) >= null;
    }

    public static /* synthetic */ boolean m42460b(CharSequence charSequence, char c) {
        Intrinsics.m26847b(charSequence, "$receiver");
        return m42439a(charSequence, c, 0, 2) >= null;
    }

    public static /* synthetic */ Sequence m42451a(CharSequence charSequence, String[] strArr) {
        Intrinsics.m26847b(charSequence, "$receiver");
        Intrinsics.m26847b(strArr, "delimiters");
        return SequencesKt___SequencesKt.m33716e(new DelimitedRangesSequence(charSequence, new StringsKt__StringsKt$rangesDelimitedBy$4(ArraysKt___ArraysKt.m36106f((Object[]) strArr))), new StringsKt__StringsKt$splitToSequence$1(charSequence));
    }

    public static /* synthetic */ java.util.List m42459b(java.lang.CharSequence r4, java.lang.String[] r5) {
        /* JADX: method processing error */
/*
Error: java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:410)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.fixIterableType(LoopRegionVisitor.java:308)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.checkIterableForEach(LoopRegionVisitor.java:249)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.processLoopRegion(LoopRegionVisitor.java:68)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.enterRegion(LoopRegionVisitor.java:52)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:56)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:18)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.visit(LoopRegionVisitor.java:46)
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
        r0 = "$receiver";
        kotlin.jvm.internal.Intrinsics.m26847b(r4, r0);
        r0 = "delimiters";
        kotlin.jvm.internal.Intrinsics.m26847b(r5, r0);
        r0 = r5;
        r0 = (java.lang.Object[]) r0;
        r1 = 1;
        r0 = r0.length;
        if (r0 != r1) goto L_0x0025;
    L_0x0011:
        r0 = 0;
        r2 = r5[r0];
        r3 = r2;
        r3 = (java.lang.CharSequence) r3;
        r3 = r3.length();
        if (r3 != 0) goto L_0x001e;
    L_0x001d:
        r0 = r1;
    L_0x001e:
        if (r0 != 0) goto L_0x0025;
    L_0x0020:
        r4 = m42448a(r4, r2);
        return r4;
    L_0x0025:
        r5 = new kotlin.text.DelimitedRangesSequence(r4, new kotlin.text.StringsKt__StringsKt$rangesDelimitedBy$4(kotlin.collections.ArraysKt___ArraysKt.m36106f((java.lang.Object[]) r5)));
        r5 = kotlin.sequences.SequencesKt___SequencesKt.m33720h(r5);
        r0 = new java.util.ArrayList;
        r1 = kotlin.collections.CollectionsKt__IterablesKt.m32812b(r5);
        r0.<init>(r1);
        r0 = (java.util.Collection) r0;
        r5 = r5.iterator();
    L_0x003c:
        r1 = r5.hasNext();
        if (r1 == 0) goto L_0x0050;
    L_0x0042:
        r1 = r5.next();
        r1 = (kotlin.ranges.IntRange) r1;
        r1 = m42444a(r4, r1);
        r0.add(r1);
        goto L_0x003c;
    L_0x0050:
        r0 = (java.util.List) r0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.StringsKt__StringsKt.b(java.lang.CharSequence, java.lang.String[]):java.util.List");
    }

    public static /* synthetic */ List m42449a(CharSequence charSequence, char[] cArr) {
        Intrinsics.m26847b(charSequence, "$receiver");
        Intrinsics.m26847b(cArr, "delimiters");
        return m42448a(charSequence, String.valueOf(cArr[0]));
    }

    private static final List<String> m42448a(CharSequence charSequence, String str) {
        int a = m42441a(charSequence, str, 0, false);
        if (a == -1) {
            return CollectionsKt__CollectionsKt.m26791a((Object) charSequence.toString());
        }
        ArrayList arrayList = new ArrayList(10);
        int i = a;
        a = 0;
        do {
            arrayList.add(charSequence.subSequence(a, i).toString());
            a = str.length() + i;
            i = m42441a(charSequence, str, a, false);
        } while (i != -1);
        arrayList.add(charSequence.subSequence(a, charSequence.length()).toString());
        return arrayList;
    }

    public static final CharSequence m42456b(CharSequence charSequence) {
        Intrinsics.m26847b(charSequence, "$receiver");
        int length = charSequence.length() - 1;
        int i = 0;
        int i2 = 0;
        while (i <= length) {
            boolean a = CharsKt__CharJVMKt.m28145a(charSequence.charAt(i2 == 0 ? i : length));
            if (i2 != 0) {
                if (!a) {
                    break;
                }
                length--;
            } else if (a) {
                i++;
            } else {
                i2 = 1;
            }
        }
        return charSequence.subSequence(i, length + 1);
    }

    public static final String m42444a(CharSequence charSequence, IntRange intRange) {
        Intrinsics.m26847b(charSequence, "$receiver");
        Intrinsics.m26847b(intRange, "range");
        return charSequence.subSequence(Integer.valueOf(intRange.f32536a).intValue(), Integer.valueOf(intRange.f32537b).intValue() + 1).toString();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ kotlin.Pair m42450a(java.lang.CharSequence r8, java.util.Collection r9, int r10, boolean r11) {
        /*
        r0 = 0;
        r1 = 0;
        if (r11 != 0) goto L_0x0023;
    L_0x0004:
        r2 = r9.size();
        r3 = 1;
        if (r2 != r3) goto L_0x0023;
    L_0x000b:
        r9 = (java.lang.Iterable) r9;
        r9 = kotlin.collections.CollectionsKt___CollectionsKt.m41440h(r9);
        r9 = (java.lang.String) r9;
        r11 = 4;
        r8 = m42442a(r8, r9, r10, r0, r11);
        if (r8 < 0) goto L_0x00b8;
    L_0x001a:
        r8 = java.lang.Integer.valueOf(r8);
        r8 = kotlin.TuplesKt.m26780a(r8, r9);
        return r8;
    L_0x0023:
        r10 = kotlin.ranges.RangesKt___RangesKt.m32855c(r10, r0);
        r0 = new kotlin.ranges.IntRange;
        r2 = r8.length();
        r0.<init>(r10, r2);
        r0 = (kotlin.ranges.IntProgression) r0;
        r10 = r8 instanceof java.lang.String;
        if (r10 == 0) goto L_0x0077;
    L_0x0036:
        r10 = r0.f32536a;
        r2 = r0.f32537b;
        r0 = r0.f32538c;
        if (r0 <= 0) goto L_0x0041;
    L_0x003e:
        if (r10 > r2) goto L_0x00b8;
    L_0x0040:
        goto L_0x0043;
    L_0x0041:
        if (r10 < r2) goto L_0x00b8;
    L_0x0043:
        r3 = r9;
        r3 = (java.lang.Iterable) r3;
        r3 = r3.iterator();
    L_0x004a:
        r4 = r3.hasNext();
        if (r4 == 0) goto L_0x0065;
    L_0x0050:
        r4 = r3.next();
        r5 = r4;
        r5 = (java.lang.String) r5;
        r6 = r8;
        r6 = (java.lang.String) r6;
        r7 = r5.length();
        r5 = kotlin.text.StringsKt__StringsJVMKt.m41945a(r5, r6, r10, r7, r11);
        if (r5 == 0) goto L_0x004a;
    L_0x0064:
        goto L_0x0066;
    L_0x0065:
        r4 = r1;
    L_0x0066:
        r4 = (java.lang.String) r4;
        if (r4 == 0) goto L_0x0073;
    L_0x006a:
        r8 = java.lang.Integer.valueOf(r10);
        r8 = kotlin.TuplesKt.m26780a(r8, r4);
        return r8;
    L_0x0073:
        if (r10 == r2) goto L_0x00b8;
    L_0x0075:
        r10 = r10 + r0;
        goto L_0x0043;
    L_0x0077:
        r10 = r0.f32536a;
        r2 = r0.f32537b;
        r0 = r0.f32538c;
        if (r0 <= 0) goto L_0x0082;
    L_0x007f:
        if (r10 > r2) goto L_0x00b8;
    L_0x0081:
        goto L_0x0084;
    L_0x0082:
        if (r10 < r2) goto L_0x00b8;
    L_0x0084:
        r3 = r9;
        r3 = (java.lang.Iterable) r3;
        r3 = r3.iterator();
    L_0x008b:
        r4 = r3.hasNext();
        if (r4 == 0) goto L_0x00a6;
    L_0x0091:
        r4 = r3.next();
        r5 = r4;
        r5 = (java.lang.String) r5;
        r6 = r5;
        r6 = (java.lang.CharSequence) r6;
        r5 = r5.length();
        r5 = m42453a(r6, r8, r10, r5, r11);
        if (r5 == 0) goto L_0x008b;
    L_0x00a5:
        goto L_0x00a7;
    L_0x00a6:
        r4 = r1;
    L_0x00a7:
        r4 = (java.lang.String) r4;
        if (r4 == 0) goto L_0x00b4;
    L_0x00ab:
        r8 = java.lang.Integer.valueOf(r10);
        r8 = kotlin.TuplesKt.m26780a(r8, r4);
        return r8;
    L_0x00b4:
        if (r10 == r2) goto L_0x00b8;
    L_0x00b6:
        r10 = r10 + r0;
        goto L_0x0084;
    L_0x00b8:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.StringsKt__StringsKt.a(java.lang.CharSequence, java.util.Collection, int, boolean):kotlin.Pair");
    }
}
