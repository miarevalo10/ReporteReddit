package com.reddit.frontpage.domain.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.AdRequest;
import com.google.common.base.Enums;
import com.reddit.datalibrary.frontpage.data.feature.link.datasource.remote.DistinguishType;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.common.ContentTypeUtil;
import com.reddit.frontpage.presentation.common.DomainUtil;
import com.reddit.frontpage.util.AdUtil;
import com.reddit.frontpage.util.RichTextUtil;
import com.reddit.frontpage.util.Util;
import com.squareup.moshi.Json;
import java.util.EnumSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.hockeyapp.android.UpdateFragment;
import org.jcodec.codecs.common.biari.MQEncoder;
import org.jcodec.codecs.mpeg12.MPEGConst;
import paperparcel.PaperParcel;
import paperparcel.PaperParcelable;
import paperparcel.PaperParcelable.DefaultImpls;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0003\b\u0001\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\b\u0018\u0000 õ\u00012\u00020\u00012\u00020\u0002:\u0002õ\u0001B\u0005\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0010\u001a\u00020\f\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019\u0012\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019\u0012\u0006\u0010\u001c\u001a\u00020\u0004\u0012\u0006\u0010\u001d\u001a\u00020\u000e\u0012\u0006\u0010\u001e\u001a\u00020\f\u0012\u0006\u0010\u001f\u001a\u00020\u000e\u0012\u0006\u0010 \u001a\u00020\u000e\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\"\u001a\u00020\u0004\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'\u0012\u0006\u0010(\u001a\u00020\u0004\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010*\u001a\u00020\u0004\u0012\u0006\u0010+\u001a\u00020\u000e\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010.\u001a\u00020\u0004\u0012\u0006\u0010/\u001a\u00020\u000e\u0012\u0006\u00100\u001a\u00020\u000e\u0012\u0006\u00101\u001a\u00020\u000e\u0012\u0006\u00102\u001a\u00020\u000e\u0012\u0006\u00103\u001a\u00020\u000e\u0012\u0006\u00104\u001a\u00020\u000e\u0012\u0006\u00105\u001a\u00020\u000e\u0012\u0006\u00106\u001a\u00020\u000e\u0012\u0006\u00107\u001a\u00020\u000e\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010:\u001a\u00020\u000e\u0012\u0006\u0010;\u001a\u00020\u000e\u0012\u0006\u0010<\u001a\u00020\u000e\u0012\b\u0010=\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010>\u001a\u00020\u000e\u0012\u0006\u0010?\u001a\u00020\u000e\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u0004\u0012\u0012\u0010A\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00190\u0019\u0012\u0012\u0010B\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00190\u0019\u0012\u0010\b\u0002\u0010C\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0019\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010E\u0012\b\b\u0002\u0010F\u001a\u00020\u000e\u0012\b\b\u0002\u0010G\u001a\u00020\u000e\u0012\u0010\b\u0002\u0010H\u001a\n\u0012\u0004\u0012\u00020I\u0018\u00010\u0019\u0012\n\b\u0002\u0010J\u001a\u0004\u0018\u00010K\u0012\n\b\u0002\u0010L\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010M\u001a\u00020\u000e¢\u0006\u0002\u0010NJ\n\u0010¢\u0001\u001a\u00020\u0004HÆ\u0003J\n\u0010£\u0001\u001a\u00020\fHÆ\u0003J\n\u0010¤\u0001\u001a\u00020\u0007HÆ\u0003J\u0012\u0010¥\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0003\u0010\u0001J\n\u0010¦\u0001\u001a\u00020\u0004HÆ\u0003J\n\u0010§\u0001\u001a\u00020\u0004HÆ\u0003J\n\u0010¨\u0001\u001a\u00020\u0004HÆ\u0003J\f\u0010©\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010ª\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0012\u0010«\u0001\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019HÆ\u0003J\u0012\u0010¬\u0001\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019HÆ\u0003J\n\u0010­\u0001\u001a\u00020\u0004HÆ\u0003J\n\u0010®\u0001\u001a\u00020\u0004HÆ\u0003J\n\u0010¯\u0001\u001a\u00020\u000eHÆ\u0003J\n\u0010°\u0001\u001a\u00020\fHÆ\u0003J\n\u0010±\u0001\u001a\u00020\u000eHÆ\u0003J\n\u0010²\u0001\u001a\u00020\u000eHÆ\u0003J\f\u0010³\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\n\u0010´\u0001\u001a\u00020\u0004HÆ\u0003J\f\u0010µ\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010¶\u0001\u001a\u0004\u0018\u00010%HÆ\u0003J\f\u0010·\u0001\u001a\u0004\u0018\u00010'HÆ\u0003J\n\u0010¸\u0001\u001a\u00020\u0007HÆ\u0003J\n\u0010¹\u0001\u001a\u00020\u0004HÆ\u0003J\f\u0010º\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\n\u0010»\u0001\u001a\u00020\u0004HÆ\u0003J\n\u0010¼\u0001\u001a\u00020\u000eHÆ\u0003J\f\u0010½\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010¾\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\n\u0010¿\u0001\u001a\u00020\u0004HÆ\u0003J\n\u0010À\u0001\u001a\u00020\u000eHÆ\u0003J\n\u0010Á\u0001\u001a\u00020\u000eHÆ\u0003J\n\u0010Â\u0001\u001a\u00020\u000eHÆ\u0003J\n\u0010Ã\u0001\u001a\u00020\u0004HÆ\u0003J\n\u0010Ä\u0001\u001a\u00020\u000eHÆ\u0003J\n\u0010Å\u0001\u001a\u00020\u000eHÆ\u0003J\n\u0010Æ\u0001\u001a\u00020\u000eHÆ\u0003J\n\u0010Ç\u0001\u001a\u00020\u000eHÆ\u0003J\n\u0010È\u0001\u001a\u00020\u000eHÆ\u0003J\n\u0010É\u0001\u001a\u00020\u000eHÆ\u0003J\f\u0010Ê\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010Ë\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\n\u0010Ì\u0001\u001a\u00020\u000eHÆ\u0003J\n\u0010Í\u0001\u001a\u00020\u000eHÆ\u0003J\n\u0010Î\u0001\u001a\u00020\u0004HÆ\u0003J\n\u0010Ï\u0001\u001a\u00020\u000eHÆ\u0003J\u0011\u0010Ð\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010~J\n\u0010Ñ\u0001\u001a\u00020\u000eHÆ\u0003J\n\u0010Ò\u0001\u001a\u00020\u000eHÆ\u0003J\f\u0010Ó\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0016\u0010Ô\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00190\u0019HÆ\u0003J\u0016\u0010Õ\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00190\u0019HÆ\u0003J\u0012\u0010Ö\u0001\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0019HÆ\u0003J\f\u0010×\u0001\u001a\u0004\u0018\u00010EHÆ\u0003J\n\u0010Ø\u0001\u001a\u00020\u000eHÆ\u0003J\n\u0010Ù\u0001\u001a\u00020\u0004HÆ\u0003J\n\u0010Ú\u0001\u001a\u00020\u000eHÆ\u0003J\u0012\u0010Û\u0001\u001a\n\u0012\u0004\u0012\u00020I\u0018\u00010\u0019HÆ\u0003J\f\u0010Ü\u0001\u001a\u0004\u0018\u00010KHÆ\u0003J\f\u0010Ý\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\n\u0010Þ\u0001\u001a\u00020\u000eHÆ\u0003J\n\u0010ß\u0001\u001a\u00020\fHÆ\u0003J\u0011\u0010à\u0001\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010pJ\n\u0010á\u0001\u001a\u00020\fHÆ\u0003Jì\u0005\u0010â\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\f2\b\b\u0002\u0010\u0011\u001a\u00020\u00072\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u00042\b\b\u0002\u0010\u0014\u001a\u00020\u00042\b\b\u0002\u0010\u0015\u001a\u00020\u00042\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00192\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u00042\b\b\u0002\u0010\u001d\u001a\u00020\u000e2\b\b\u0002\u0010\u001e\u001a\u00020\f2\b\b\u0002\u0010\u001f\u001a\u00020\u000e2\b\b\u0002\u0010 \u001a\u00020\u000e2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\"\u001a\u00020\u00042\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'2\b\b\u0002\u0010(\u001a\u00020\u00042\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010*\u001a\u00020\u00042\b\b\u0002\u0010+\u001a\u00020\u000e2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010.\u001a\u00020\u00042\b\b\u0002\u0010/\u001a\u00020\u000e2\b\b\u0002\u00100\u001a\u00020\u000e2\b\b\u0002\u00101\u001a\u00020\u000e2\b\b\u0002\u00102\u001a\u00020\u000e2\b\b\u0002\u00103\u001a\u00020\u000e2\b\b\u0002\u00104\u001a\u00020\u000e2\b\b\u0002\u00105\u001a\u00020\u000e2\b\b\u0002\u00106\u001a\u00020\u000e2\b\b\u0002\u00107\u001a\u00020\u000e2\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010:\u001a\u00020\u000e2\b\b\u0002\u0010;\u001a\u00020\u000e2\b\b\u0002\u0010<\u001a\u00020\u000e2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010>\u001a\u00020\u000e2\b\b\u0002\u0010?\u001a\u00020\u000e2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u00042\u0014\b\u0002\u0010A\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00190\u00192\u0014\b\u0002\u0010B\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00190\u00192\u0010\b\u0002\u0010C\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u00192\n\b\u0002\u0010D\u001a\u0004\u0018\u00010E2\b\b\u0002\u0010F\u001a\u00020\u000e2\b\b\u0002\u0010G\u001a\u00020\u000e2\u0010\b\u0002\u0010H\u001a\n\u0012\u0004\u0012\u00020I\u0018\u00010\u00192\n\b\u0002\u0010J\u001a\u0004\u0018\u00010K2\n\b\u0002\u0010L\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010M\u001a\u00020\u000eHÆ\u0001¢\u0006\u0003\u0010ã\u0001J\u0016\u0010ä\u0001\u001a\u00020\u000e2\n\u0010å\u0001\u001a\u0005\u0018\u00010æ\u0001HÖ\u0003J\u0013\u0010ç\u0001\u001a\u0004\u0018\u00010\u00042\b\u0010è\u0001\u001a\u00030é\u0001J\b\u0010ê\u0001\u001a\u00030ë\u0001J\b\u0010ì\u0001\u001a\u00030í\u0001J\b\u0010î\u0001\u001a\u00030é\u0001J\u0007\u0010ï\u0001\u001a\u00020\u000eJ\n\u0010ð\u0001\u001a\u00020\fHÖ\u0001J\u0007\u0010ñ\u0001\u001a\u00020\u000eJ\u0007\u0010ò\u0001\u001a\u00020\u000eJ\u0007\u0010ó\u0001\u001a\u00020\u000eJ\n\u0010ô\u0001\u001a\u00020\u0004HÖ\u0001R\u0011\u0010:\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bO\u0010PR\u0018\u00109\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010RR\u0011\u0010/\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bS\u0010PR\u0011\u0010\u001c\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bT\u0010RR\u0016\u0010\u001d\u001a\u00020\u000e8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bU\u0010PR\u0013\u0010V\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\bW\u0010RR\u001e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00198\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bX\u0010YR\u0018\u0010-\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010RR\u0013\u0010#\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b[\u0010RR\u0016\u0010>\u001a\u00020\u000e8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010PR\u0016\u00106\u001a\u00020\u000e8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b]\u0010PR\u0016\u00107\u001a\u00020\u000e8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b^\u0010PR\u0016\u0010\u0006\u001a\u00020\u00078\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b_\u0010`R\u001e\u0010C\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u00198\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\ba\u0010YR\u0014\u0010b\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\bc\u0010RR\u0013\u00108\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\bd\u0010RR\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\be\u0010RR\u0018\u0010L\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bf\u0010RR\u0016\u0010\u0010\u001a\u00020\f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bg\u0010hR\u001e\u0010H\u001a\n\u0012\u0004\u0012\u00020I\u0018\u00010\u00198\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bi\u0010YR\u0011\u0010\u001e\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\bj\u0010hR\u0011\u00102\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bk\u0010PR\u0016\u00104\u001a\u00020\u000e8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bl\u0010PR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\bm\u0010RR\u0016\u0010G\u001a\u00020\u000e8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010PR\u0011\u0010M\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bM\u0010PR\u0016\u0010+\u001a\u00020\u000e8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010PR\u0016\u0010?\u001a\u00020\u000e8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010PR\u0016\u0010\u0005\u001a\u00020\u00048\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\bn\u0010RR\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010q\u001a\u0004\bo\u0010pR\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\br\u0010RR\u0013\u0010s\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\bt\u0010RR\u001e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00198\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bu\u0010YR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bv\u0010RR\u0018\u0010@\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bw\u0010RR\u0011\u00100\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bx\u0010PR\u0013\u0010&\u001a\u0004\u0018\u00010'¢\u0006\b\n\u0000\u001a\u0004\by\u0010zR\"\u0010A\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00190\u00198\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b{\u0010YR\u0016\u0010\u0011\u001a\u00020\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b|\u0010`R\u001a\u0010=\u001a\u0004\u0018\u00010\f8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u001a\u0004\b}\u0010~R\u001a\u0010J\u001a\u0004\u0018\u00010K8\u0006X\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0001\u0010\u0001R\u0017\u0010\u001f\u001a\u00020\u000e8\u0006X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010PR\u0012\u0010*\u001a\u00020\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010RR\u0019\u0010,\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010RR\u0015\u0010$\u001a\u0004\u0018\u00010%¢\u0006\n\n\u0000\u001a\u0006\b\u0001\u0010\u0001R\u0017\u0010F\u001a\u00020\u000e8\u0006X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010PR\u0012\u00101\u001a\u00020\u000e¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010PR\u0012\u0010;\u001a\u00020\u000e¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010PR\u0012\u00103\u001a\u00020\u000e¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010PR\u0012\u0010\u000b\u001a\u00020\f¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010hR\u0012\u0010(\u001a\u00020\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010RR\u0019\u0010)\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010RR\u0012\u0010<\u001a\u00020\u000e¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010PR\u0012\u0010 \u001a\u00020\u000e¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010PR\u0012\u00105\u001a\u00020\u000e¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010PR\u0012\u0010\u0013\u001a\u00020\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010RR\u001a\u0010D\u001a\u0004\u0018\u00010E8\u0006X\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0001\u0010\u0001R\u0017\u0010\u0014\u001a\u00020\u00048\u0006X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010RR\u0017\u0010\u0015\u001a\u00020\u00048\u0006X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010RR\u0019\u0010!\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010RR\u0012\u0010\"\u001a\u00020\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010RR\u0012\u0010\b\u001a\u00020\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010RR\u0013\u0010\u0001\u001a\u00020\u00048F¢\u0006\u0007\u001a\u0005\b\u0001\u0010RR\u0017\u0010\u000f\u001a\u00020\f8\u0006X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010hR\u0012\u0010\n\u001a\u00020\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010RR#\u0010B\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00190\u00198\u0006X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010YR\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\r\n\u0003\u0010 \u0001\u001a\u0006\b\u0001\u0010\u0001R\u0017\u0010.\u001a\u00020\u00048\u0006X\u0004¢\u0006\t\n\u0000\u001a\u0005\b¡\u0001\u0010R¨\u0006ö\u0001"}, d2 = {"Lcom/reddit/frontpage/domain/model/Link;", "Lcom/reddit/frontpage/domain/model/ILink;", "Lpaperparcel/PaperParcelable;", "id", "", "kindWithId", "createdUtc", "", "title", "domain", "url", "score", "", "likes", "", "upvoteCount", "downvoteCount", "numComments", "viewCount", "subreddit", "subredditId", "subredditNamePrefixed", "linkFlairText", "linkFlairId", "linkFlairRichTextObject", "", "Lcom/reddit/frontpage/domain/model/FlairRichTextItem;", "authorFlairRichTextObject", "author", "authorCakeday", "gilded", "over18", "spoiler", "suggestedSort", "thumbnail", "body", "preview", "Lcom/reddit/frontpage/domain/model/Preview;", "media", "Lcom/reddit/frontpage/domain/model/LinkMedia;", "selftext", "selftextHtml", "permalink", "isSelf", "postHint", "authorFlairText", "websocketUrl", "archived", "locked", "quarantine", "hidden", "saved", "hideScore", "stickied", "canGild", "canMod", "distinguished", "approvedBy", "approved", "removed", "spam", "numReports", "brandSafe", "isVideo", "locationName", "modReports", "userReports", "crossPostParentList", "subredditDetail", "Lcom/reddit/frontpage/domain/model/SubredditDetail;", "promoted", "isBlankAd", "events", "Lcom/reddit/frontpage/domain/model/AdEvent;", "outboundLink", "Lcom/reddit/frontpage/domain/model/OutboundLink;", "domainOverride", "isRead", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Boolean;IIJLjava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;ZIZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/reddit/frontpage/domain/model/Preview;Lcom/reddit/frontpage/domain/model/LinkMedia;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZZZZZZZLjava/lang/String;Ljava/lang/String;ZZZLjava/lang/Integer;ZZLjava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/reddit/frontpage/domain/model/SubredditDetail;ZZLjava/util/List;Lcom/reddit/frontpage/domain/model/OutboundLink;Ljava/lang/String;Z)V", "getApproved", "()Z", "getApprovedBy", "()Ljava/lang/String;", "getArchived", "getAuthor", "getAuthorCakeday", "authorFlairRichText", "getAuthorFlairRichText", "getAuthorFlairRichTextObject", "()Ljava/util/List;", "getAuthorFlairText", "getBody", "getBrandSafe", "getCanGild", "getCanMod", "getCreatedUtc", "()J", "getCrossPostParentList", "displayDomain", "getDisplayDomain", "getDistinguished", "getDomain", "getDomainOverride", "getDownvoteCount", "()I", "getEvents", "getGilded", "getHidden", "getHideScore", "getId", "getKindWithId", "getLikes", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLinkFlairId", "linkFlairRichText", "getLinkFlairRichText", "getLinkFlairRichTextObject", "getLinkFlairText", "getLocationName", "getLocked", "getMedia", "()Lcom/reddit/frontpage/domain/model/LinkMedia;", "getModReports", "getNumComments", "getNumReports", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getOutboundLink", "()Lcom/reddit/frontpage/domain/model/OutboundLink;", "getOver18", "getPermalink", "getPostHint", "getPreview", "()Lcom/reddit/frontpage/domain/model/Preview;", "getPromoted", "getQuarantine", "getRemoved", "getSaved", "getScore", "getSelftext", "getSelftextHtml", "getSpam", "getSpoiler", "getStickied", "getSubreddit", "getSubredditDetail", "()Lcom/reddit/frontpage/domain/model/SubredditDetail;", "getSubredditId", "getSubredditNamePrefixed", "getSuggestedSort", "getThumbnail", "getTitle", "uniqueId", "getUniqueId", "getUpvoteCount", "getUrl", "getUserReports", "getViewCount", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getWebsocketUrl", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component4", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component5", "component50", "component51", "component52", "component53", "component54", "component55", "component56", "component57", "component58", "component59", "component6", "component60", "component61", "component62", "component63", "component64", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Boolean;IIJLjava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;ZIZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/reddit/frontpage/domain/model/Preview;Lcom/reddit/frontpage/domain/model/LinkMedia;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZZZZZZZLjava/lang/String;Ljava/lang/String;ZZZLjava/lang/Integer;ZZLjava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/reddit/frontpage/domain/model/SubredditDetail;ZZLjava/util/List;Lcom/reddit/frontpage/domain/model/OutboundLink;Ljava/lang/String;Z)Lcom/reddit/frontpage/domain/model/Link;", "equals", "other", "", "generateDomainLabel", "type", "Lcom/reddit/frontpage/domain/model/LinkType;", "getAnalyticsPostType", "Lcom/reddit/frontpage/domain/model/AnalyticsPostType;", "getDistinguishType", "Lcom/reddit/datalibrary/frontpage/data/feature/link/datasource/remote/DistinguishType;", "getLinkType", "hasMp4Url", "hashCode", "isGifLinkType", "isImageLinkType", "isVideoLinkType", "toString", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
@PaperParcel
/* compiled from: Link.kt */
public final class Link extends ILink implements PaperParcelable {
    public static final Creator<Link> CREATOR = PaperParcelLink.CREATOR;
    public static final Companion Companion = new Companion();
    private static final EnumSet<LinkType> DOMAIN_TYPES = EnumSet.of(LinkType.IMAGE, LinkType.VIDEO);
    private static final String MODERATOR = "moderator";
    private final boolean approved;
    @Json(a = "approved_by")
    private final String approvedBy;
    private final boolean archived;
    private final String author;
    @Json(a = "author_cakeday")
    private final boolean authorCakeday;
    @Json(a = "author_flair_richtext")
    private final List<FlairRichTextItem> authorFlairRichTextObject;
    @Json(a = "author_flair_text")
    private final String authorFlairText;
    private final String body;
    @Json(a = "brand_safe")
    private final boolean brandSafe;
    @Json(a = "can_gild")
    private final boolean canGild;
    @Json(a = "can_mod_post")
    private final boolean canMod;
    @Json(a = "created_utc")
    private final long createdUtc;
    @Json(a = "crosspost_parent_list")
    private final List<Link> crossPostParentList;
    private final String distinguished;
    private final String domain;
    @Json(a = "domain_override")
    private final String domainOverride;
    @Json(a = "downs")
    private final int downvoteCount;
    @Json(a = "events")
    private final List<AdEvent> events;
    private final int gilded;
    private final boolean hidden;
    @Json(a = "hide_score")
    private final boolean hideScore;
    private final String id;
    @Json(a = "is_blank")
    private final boolean isBlankAd;
    private final boolean isRead;
    @Json(a = "is_self")
    private final boolean isSelf;
    @Json(a = "is_video")
    private final boolean isVideo;
    @Json(a = "name")
    private final String kindWithId;
    private final Boolean likes;
    @Json(a = "link_flair_template_id")
    private final String linkFlairId;
    @Json(a = "link_flair_richtext")
    private final List<FlairRichTextItem> linkFlairRichTextObject;
    @Json(a = "link_flair_text")
    private final String linkFlairText;
    @Json(a = "location_name")
    private final String locationName;
    private final boolean locked;
    private final LinkMedia media;
    @Json(a = "mod_reports")
    private final List<List<String>> modReports;
    @Json(a = "num_comments")
    private final long numComments;
    @Json(a = "num_reports")
    private final Integer numReports;
    @Json(a = "outbound_link")
    private final OutboundLink outboundLink;
    @Json(a = "over_18")
    private final boolean over18;
    private final String permalink;
    @Json(a = "post_hint")
    private final String postHint;
    private final Preview preview;
    @Json(a = "promoted")
    private final boolean promoted;
    private final boolean quarantine;
    private final boolean removed;
    private final boolean saved;
    private final int score;
    private final String selftext;
    @Json(a = "selftext_html")
    private final String selftextHtml;
    private final boolean spam;
    private final boolean spoiler;
    private final boolean stickied;
    private final String subreddit;
    @Json(a = "sr_detail")
    private final SubredditDetail subredditDetail;
    @Json(a = "subreddit_id")
    private final String subredditId;
    @Json(a = "subreddit_name_prefixed")
    private final String subredditNamePrefixed;
    @Json(a = "suggested_sort")
    private final String suggestedSort;
    private final String thumbnail;
    private final String title;
    @Json(a = "ups")
    private final int upvoteCount;
    private final String url;
    @Json(a = "user_reports")
    private final List<List<String>> userReports;
    @Json(a = "view_count")
    private final Long viewCount;
    @Json(a = "websocket_url")
    private final String websocketUrl;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R8\u0010\u0007\u001a&\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\t0\t \u0006*\u0012\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\t0\t\u0018\u00010\b0\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rXD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/reddit/frontpage/domain/model/Link$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/reddit/frontpage/domain/model/Link;", "kotlin.jvm.PlatformType", "DOMAIN_TYPES", "Ljava/util/EnumSet;", "Lcom/reddit/frontpage/domain/model/LinkType;", "getDOMAIN_TYPES", "()Ljava/util/EnumSet;", "MODERATOR", "", "getMODERATOR", "()Ljava/lang/String;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: Link.kt */
    public static final class Companion {
        private Companion() {
        }

        private final EnumSet<LinkType> getDOMAIN_TYPES() {
            return Link.DOMAIN_TYPES;
        }

        public final String getMODERATOR() {
            return Link.MODERATOR;
        }
    }

    public static /* synthetic */ Link copy$default(Link link, String str, String str2, long j, String str3, String str4, String str5, int i, Boolean bool, int i2, int i3, long j2, Long l, String str6, String str7, String str8, String str9, String str10, List list, List list2, String str11, boolean z, int i4, boolean z2, boolean z3, String str12, String str13, String str14, Preview preview, LinkMedia linkMedia, String str15, String str16, String str17, boolean z4, String str18, String str19, String str20, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, String str21, String str22, boolean z14, boolean z15, boolean z16, Integer num, boolean z17, boolean z18, String str23, List list3, List list4, List list5, SubredditDetail subredditDetail, boolean z19, boolean z20, List list6, OutboundLink outboundLink, String str24, boolean z21, int i5, int i6, Object obj) {
        Link link2 = link;
        int i7 = i5;
        int i8 = i6;
        return link2.copy((i7 & 1) != 0 ? link.getId() : str, (i7 & 2) != 0 ? link.getKindWithId() : str2, (i7 & 4) != 0 ? link.getCreatedUtc() : j, (i7 & 8) != 0 ? link2.title : str3, (i7 & 16) != 0 ? link2.domain : str4, (i7 & 32) != 0 ? link2.url : str5, (i7 & 64) != 0 ? link2.score : i, (i7 & 128) != 0 ? link2.likes : bool, (i7 & 256) != 0 ? link2.upvoteCount : i2, (i7 & AdRequest.MAX_CONTENT_URL_LENGTH) != 0 ? link2.downvoteCount : i3, (i7 & 1024) != 0 ? link2.numComments : j2, (i7 & MPEGConst.CODE_END) != 0 ? link2.viewCount : l, (i7 & 4096) != 0 ? link2.subreddit : str6, (i7 & 8192) != 0 ? link2.subredditId : str7, (i7 & 16384) != 0 ? link2.subredditNamePrefixed : str8, (32768 & i7) != 0 ? link2.linkFlairText : str9, (65536 & i7) != 0 ? link2.linkFlairId : str10, (131072 & i7) != 0 ? link2.linkFlairRichTextObject : list, (262144 & i7) != 0 ? link2.authorFlairRichTextObject : list2, (524288 & i7) != 0 ? link2.author : str11, (1048576 & i7) != 0 ? link2.authorCakeday : z, (2097152 & i7) != 0 ? link2.gilded : i4, (4194304 & i7) != 0 ? link2.over18 : z2, (8388608 & i7) != 0 ? link2.spoiler : z3, (16777216 & i7) != 0 ? link2.suggestedSort : str12, (33554432 & i7) != 0 ? link2.thumbnail : str13, (67108864 & i7) != 0 ? link2.body : str14, (MQEncoder.CARRY_MASK & i7) != 0 ? link2.preview : preview, (268435456 & i7) != 0 ? link2.media : linkMedia, (536870912 & i7) != 0 ? link2.selftext : str15, (1073741824 & i7) != 0 ? link2.selftextHtml : str16, (i7 & Integer.MIN_VALUE) != 0 ? link2.permalink : str17, (i8 & 1) != 0 ? link2.isSelf : z4, (i8 & 2) != 0 ? link2.postHint : str18, (i8 & 4) != 0 ? link2.authorFlairText : str19, (i8 & 8) != 0 ? link2.websocketUrl : str20, (i8 & 16) != 0 ? link2.archived : z5, (i8 & 32) != 0 ? link2.locked : z6, (i8 & 64) != 0 ? link2.quarantine : z7, (i8 & 128) != 0 ? link2.hidden : z8, (i8 & 256) != 0 ? link2.saved : z9, (i8 & AdRequest.MAX_CONTENT_URL_LENGTH) != 0 ? link2.hideScore : z10, (i8 & 1024) != 0 ? link2.stickied : z11, (i8 & MPEGConst.CODE_END) != 0 ? link2.canGild : z12, (i8 & 4096) != 0 ? link2.canMod : z13, (i8 & 8192) != 0 ? link2.distinguished : str21, (i8 & 16384) != 0 ? link2.approvedBy : str22, (32768 & i8) != 0 ? link2.approved : z14, (65536 & i8) != 0 ? link2.removed : z15, (131072 & i8) != 0 ? link2.spam : z16, (262144 & i8) != 0 ? link2.numReports : num, (524288 & i8) != 0 ? link2.brandSafe : z17, (1048576 & i8) != 0 ? link2.isVideo : z18, (2097152 & i8) != 0 ? link2.locationName : str23, (4194304 & i8) != 0 ? link2.modReports : list3, (8388608 & i8) != 0 ? link2.userReports : list4, (16777216 & i8) != 0 ? link2.crossPostParentList : list5, (33554432 & i8) != 0 ? link2.subredditDetail : subredditDetail, (67108864 & i8) != 0 ? link2.promoted : z19, (MQEncoder.CARRY_MASK & i8) != 0 ? link2.isBlankAd : z20, (268435456 & i8) != 0 ? link2.events : list6, (536870912 & i8) != 0 ? link2.outboundLink : outboundLink, (1073741824 & i8) != 0 ? link2.domainOverride : str24, (Integer.MIN_VALUE & i8) != 0 ? link2.isRead : z21);
    }

    public final String component1() {
        return getId();
    }

    public final int component10() {
        return this.downvoteCount;
    }

    public final long component11() {
        return this.numComments;
    }

    public final Long component12() {
        return this.viewCount;
    }

    public final String component13() {
        return this.subreddit;
    }

    public final String component14() {
        return this.subredditId;
    }

    public final String component15() {
        return this.subredditNamePrefixed;
    }

    public final String component16() {
        return this.linkFlairText;
    }

    public final String component17() {
        return this.linkFlairId;
    }

    public final List<FlairRichTextItem> component18() {
        return this.linkFlairRichTextObject;
    }

    public final List<FlairRichTextItem> component19() {
        return this.authorFlairRichTextObject;
    }

    public final String component2() {
        return getKindWithId();
    }

    public final String component20() {
        return this.author;
    }

    public final boolean component21() {
        return this.authorCakeday;
    }

    public final int component22() {
        return this.gilded;
    }

    public final boolean component23() {
        return this.over18;
    }

    public final boolean component24() {
        return this.spoiler;
    }

    public final String component25() {
        return this.suggestedSort;
    }

    public final String component26() {
        return this.thumbnail;
    }

    public final String component27() {
        return this.body;
    }

    public final Preview component28() {
        return this.preview;
    }

    public final LinkMedia component29() {
        return this.media;
    }

    public final long component3() {
        return getCreatedUtc();
    }

    public final String component30() {
        return this.selftext;
    }

    public final String component31() {
        return this.selftextHtml;
    }

    public final String component32() {
        return this.permalink;
    }

    public final boolean component33() {
        return this.isSelf;
    }

    public final String component34() {
        return this.postHint;
    }

    public final String component35() {
        return this.authorFlairText;
    }

    public final String component36() {
        return this.websocketUrl;
    }

    public final boolean component37() {
        return this.archived;
    }

    public final boolean component38() {
        return this.locked;
    }

    public final boolean component39() {
        return this.quarantine;
    }

    public final String component4() {
        return this.title;
    }

    public final boolean component40() {
        return this.hidden;
    }

    public final boolean component41() {
        return this.saved;
    }

    public final boolean component42() {
        return this.hideScore;
    }

    public final boolean component43() {
        return this.stickied;
    }

    public final boolean component44() {
        return this.canGild;
    }

    public final boolean component45() {
        return this.canMod;
    }

    public final String component46() {
        return this.distinguished;
    }

    public final String component47() {
        return this.approvedBy;
    }

    public final boolean component48() {
        return this.approved;
    }

    public final boolean component49() {
        return this.removed;
    }

    public final String component5() {
        return this.domain;
    }

    public final boolean component50() {
        return this.spam;
    }

    public final Integer component51() {
        return this.numReports;
    }

    public final boolean component52() {
        return this.brandSafe;
    }

    public final boolean component53() {
        return this.isVideo;
    }

    public final String component54() {
        return this.locationName;
    }

    public final List<List<String>> component55() {
        return this.modReports;
    }

    public final List<List<String>> component56() {
        return this.userReports;
    }

    public final List<Link> component57() {
        return this.crossPostParentList;
    }

    public final SubredditDetail component58() {
        return this.subredditDetail;
    }

    public final boolean component59() {
        return this.promoted;
    }

    public final String component6() {
        return this.url;
    }

    public final boolean component60() {
        return this.isBlankAd;
    }

    public final List<AdEvent> component61() {
        return this.events;
    }

    public final OutboundLink component62() {
        return this.outboundLink;
    }

    public final String component63() {
        return this.domainOverride;
    }

    public final boolean component64() {
        return this.isRead;
    }

    public final int component7() {
        return this.score;
    }

    public final Boolean component8() {
        return this.likes;
    }

    public final int component9() {
        return this.upvoteCount;
    }

    public final Link copy(String str, String str2, long j, String str3, String str4, String str5, int i, Boolean bool, int i2, int i3, long j2, Long l, String str6, String str7, String str8, String str9, String str10, List<FlairRichTextItem> list, List<FlairRichTextItem> list2, String str11, boolean z, int i4, boolean z2, boolean z3, String str12, String str13, String str14, Preview preview, LinkMedia linkMedia, String str15, String str16, String str17, boolean z4, String str18, String str19, String str20, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, String str21, String str22, boolean z14, boolean z15, boolean z16, Integer num, boolean z17, boolean z18, String str23, List<? extends List<String>> list3, List<? extends List<String>> list4, List<Link> list5, SubredditDetail subredditDetail, boolean z19, boolean z20, List<AdEvent> list6, OutboundLink outboundLink, String str24, boolean z21) {
        String str25 = str;
        Intrinsics.m26847b(str25, "id");
        String str26 = str2;
        Intrinsics.m26847b(str26, "kindWithId");
        String str27 = str3;
        Intrinsics.m26847b(str27, "title");
        String str28 = str4;
        Intrinsics.m26847b(str28, "domain");
        String str29 = str5;
        Intrinsics.m26847b(str29, UpdateFragment.FRAGMENT_URL);
        Intrinsics.m26847b(str6, "subreddit");
        Intrinsics.m26847b(str7, "subredditId");
        Intrinsics.m26847b(str8, "subredditNamePrefixed");
        Intrinsics.m26847b(str11, "author");
        Intrinsics.m26847b(str13, "thumbnail");
        Intrinsics.m26847b(str15, "selftext");
        Intrinsics.m26847b(str17, "permalink");
        Intrinsics.m26847b(str20, "websocketUrl");
        Intrinsics.m26847b(list3, "modReports");
        Intrinsics.m26847b(list4, "userReports");
        return new Link(str25, str26, j, str27, str28, str29, i, bool, i2, i3, j2, l, str6, str7, str8, str9, str10, list, list2, str11, z, i4, z2, z3, str12, str13, str14, preview, linkMedia, str15, str16, str17, z4, str18, str19, str20, z5, z6, z7, z8, z9, z10, z11, z12, z13, str21, str22, z14, z15, z16, num, z17, z18, str23, list3, list4, list5, subredditDetail, z19, z20, list6, outboundLink, str24, z21);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Link) {
            Link link = (Link) obj;
            if (Intrinsics.m26845a(getId(), link.getId()) && Intrinsics.m26845a(getKindWithId(), link.getKindWithId())) {
                if ((getCreatedUtc() == link.getCreatedUtc()) && Intrinsics.m26845a(this.title, link.title) && Intrinsics.m26845a(this.domain, link.domain) && Intrinsics.m26845a(this.url, link.url)) {
                    if ((this.score == link.score) && Intrinsics.m26845a(this.likes, link.likes)) {
                        if (this.upvoteCount == link.upvoteCount) {
                            if (this.downvoteCount == link.downvoteCount) {
                                if ((this.numComments == link.numComments) && Intrinsics.m26845a(this.viewCount, link.viewCount) && Intrinsics.m26845a(this.subreddit, link.subreddit) && Intrinsics.m26845a(this.subredditId, link.subredditId) && Intrinsics.m26845a(this.subredditNamePrefixed, link.subredditNamePrefixed) && Intrinsics.m26845a(this.linkFlairText, link.linkFlairText) && Intrinsics.m26845a(this.linkFlairId, link.linkFlairId) && Intrinsics.m26845a(this.linkFlairRichTextObject, link.linkFlairRichTextObject) && Intrinsics.m26845a(this.authorFlairRichTextObject, link.authorFlairRichTextObject) && Intrinsics.m26845a(this.author, link.author)) {
                                    if (this.authorCakeday == link.authorCakeday) {
                                        if (this.gilded == link.gilded) {
                                            if (this.over18 == link.over18) {
                                                if ((this.spoiler == link.spoiler) && Intrinsics.m26845a(this.suggestedSort, link.suggestedSort) && Intrinsics.m26845a(this.thumbnail, link.thumbnail) && Intrinsics.m26845a(this.body, link.body) && Intrinsics.m26845a(this.preview, link.preview) && Intrinsics.m26845a(this.media, link.media) && Intrinsics.m26845a(this.selftext, link.selftext) && Intrinsics.m26845a(this.selftextHtml, link.selftextHtml) && Intrinsics.m26845a(this.permalink, link.permalink)) {
                                                    if ((this.isSelf == link.isSelf) && Intrinsics.m26845a(this.postHint, link.postHint) && Intrinsics.m26845a(this.authorFlairText, link.authorFlairText) && Intrinsics.m26845a(this.websocketUrl, link.websocketUrl)) {
                                                        if (this.archived == link.archived) {
                                                            if (this.locked == link.locked) {
                                                                if (this.quarantine == link.quarantine) {
                                                                    if (this.hidden == link.hidden) {
                                                                        if (this.saved == link.saved) {
                                                                            if (this.hideScore == link.hideScore) {
                                                                                if (this.stickied == link.stickied) {
                                                                                    if (this.canGild == link.canGild) {
                                                                                        if ((this.canMod == link.canMod) && Intrinsics.m26845a(this.distinguished, link.distinguished) && Intrinsics.m26845a(this.approvedBy, link.approvedBy)) {
                                                                                            if (this.approved == link.approved) {
                                                                                                if (this.removed == link.removed) {
                                                                                                    if ((this.spam == link.spam) && Intrinsics.m26845a(this.numReports, link.numReports)) {
                                                                                                        if (this.brandSafe == link.brandSafe) {
                                                                                                            if ((this.isVideo == link.isVideo) && Intrinsics.m26845a(this.locationName, link.locationName) && Intrinsics.m26845a(this.modReports, link.modReports) && Intrinsics.m26845a(this.userReports, link.userReports) && Intrinsics.m26845a(this.crossPostParentList, link.crossPostParentList) && Intrinsics.m26845a(this.subredditDetail, link.subredditDetail)) {
                                                                                                                if (this.promoted == link.promoted) {
                                                                                                                    if ((this.isBlankAd == link.isBlankAd) && Intrinsics.m26845a(this.events, link.events) && Intrinsics.m26845a(this.outboundLink, link.outboundLink) && Intrinsics.m26845a(this.domainOverride, link.domainOverride)) {
                                                                                                                        if (this.isRead == link.isRead) {
                                                                                                                            return true;
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        String id = getId();
        int i = 0;
        int hashCode = (id != null ? id.hashCode() : 0) * 31;
        String kindWithId = getKindWithId();
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        long createdUtc = getCreatedUtc();
        hashCode = (hashCode + ((int) (createdUtc ^ (createdUtc >>> 32)))) * 31;
        kindWithId = this.title;
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        kindWithId = this.domain;
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        kindWithId = this.url;
        hashCode = (((hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31) + this.score) * 31;
        Boolean bool = this.likes;
        hashCode = (((((hashCode + (bool != null ? bool.hashCode() : 0)) * 31) + this.upvoteCount) * 31) + this.downvoteCount) * 31;
        createdUtc = this.numComments;
        hashCode = (hashCode + ((int) (createdUtc ^ (createdUtc >>> 32)))) * 31;
        Long l = this.viewCount;
        hashCode = (hashCode + (l != null ? l.hashCode() : 0)) * 31;
        kindWithId = this.subreddit;
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        kindWithId = this.subredditId;
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        kindWithId = this.subredditNamePrefixed;
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        kindWithId = this.linkFlairText;
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        kindWithId = this.linkFlairId;
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        List list = this.linkFlairRichTextObject;
        hashCode = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        list = this.authorFlairRichTextObject;
        hashCode = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        kindWithId = this.author;
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        int i2 = this.authorCakeday;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (((hashCode + i2) * 31) + this.gilded) * 31;
        i2 = this.over18;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        i2 = this.spoiler;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        kindWithId = this.suggestedSort;
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        kindWithId = this.thumbnail;
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        kindWithId = this.body;
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        Preview preview = this.preview;
        hashCode = (hashCode + (preview != null ? preview.hashCode() : 0)) * 31;
        LinkMedia linkMedia = this.media;
        hashCode = (hashCode + (linkMedia != null ? linkMedia.hashCode() : 0)) * 31;
        kindWithId = this.selftext;
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        kindWithId = this.selftextHtml;
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        kindWithId = this.permalink;
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        i2 = this.isSelf;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        kindWithId = this.postHint;
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        kindWithId = this.authorFlairText;
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        kindWithId = this.websocketUrl;
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        i2 = this.archived;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        i2 = this.locked;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        i2 = this.quarantine;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        i2 = this.hidden;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        i2 = this.saved;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        i2 = this.hideScore;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        i2 = this.stickied;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        i2 = this.canGild;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        i2 = this.canMod;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        kindWithId = this.distinguished;
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        kindWithId = this.approvedBy;
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        i2 = this.approved;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        i2 = this.removed;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        i2 = this.spam;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        Integer num = this.numReports;
        hashCode = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        i2 = this.brandSafe;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        i2 = this.isVideo;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        kindWithId = this.locationName;
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        list = this.modReports;
        hashCode = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        list = this.userReports;
        hashCode = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        list = this.crossPostParentList;
        hashCode = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        SubredditDetail subredditDetail = this.subredditDetail;
        hashCode = (hashCode + (subredditDetail != null ? subredditDetail.hashCode() : 0)) * 31;
        i2 = this.promoted;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        i2 = this.isBlankAd;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        list = this.events;
        hashCode = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        OutboundLink outboundLink = this.outboundLink;
        hashCode = (hashCode + (outboundLink != null ? outboundLink.hashCode() : 0)) * 31;
        kindWithId = this.domainOverride;
        if (kindWithId != null) {
            i = kindWithId.hashCode();
        }
        hashCode = (hashCode + i) * 31;
        i = this.isRead;
        if (i != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Link(id=");
        stringBuilder.append(getId());
        stringBuilder.append(", kindWithId=");
        stringBuilder.append(getKindWithId());
        stringBuilder.append(", createdUtc=");
        stringBuilder.append(getCreatedUtc());
        stringBuilder.append(", title=");
        stringBuilder.append(this.title);
        stringBuilder.append(", domain=");
        stringBuilder.append(this.domain);
        stringBuilder.append(", url=");
        stringBuilder.append(this.url);
        stringBuilder.append(", score=");
        stringBuilder.append(this.score);
        stringBuilder.append(", likes=");
        stringBuilder.append(this.likes);
        stringBuilder.append(", upvoteCount=");
        stringBuilder.append(this.upvoteCount);
        stringBuilder.append(", downvoteCount=");
        stringBuilder.append(this.downvoteCount);
        stringBuilder.append(", numComments=");
        stringBuilder.append(this.numComments);
        stringBuilder.append(", viewCount=");
        stringBuilder.append(this.viewCount);
        stringBuilder.append(", subreddit=");
        stringBuilder.append(this.subreddit);
        stringBuilder.append(", subredditId=");
        stringBuilder.append(this.subredditId);
        stringBuilder.append(", subredditNamePrefixed=");
        stringBuilder.append(this.subredditNamePrefixed);
        stringBuilder.append(", linkFlairText=");
        stringBuilder.append(this.linkFlairText);
        stringBuilder.append(", linkFlairId=");
        stringBuilder.append(this.linkFlairId);
        stringBuilder.append(", linkFlairRichTextObject=");
        stringBuilder.append(this.linkFlairRichTextObject);
        stringBuilder.append(", authorFlairRichTextObject=");
        stringBuilder.append(this.authorFlairRichTextObject);
        stringBuilder.append(", author=");
        stringBuilder.append(this.author);
        stringBuilder.append(", authorCakeday=");
        stringBuilder.append(this.authorCakeday);
        stringBuilder.append(", gilded=");
        stringBuilder.append(this.gilded);
        stringBuilder.append(", over18=");
        stringBuilder.append(this.over18);
        stringBuilder.append(", spoiler=");
        stringBuilder.append(this.spoiler);
        stringBuilder.append(", suggestedSort=");
        stringBuilder.append(this.suggestedSort);
        stringBuilder.append(", thumbnail=");
        stringBuilder.append(this.thumbnail);
        stringBuilder.append(", body=");
        stringBuilder.append(this.body);
        stringBuilder.append(", preview=");
        stringBuilder.append(this.preview);
        stringBuilder.append(", media=");
        stringBuilder.append(this.media);
        stringBuilder.append(", selftext=");
        stringBuilder.append(this.selftext);
        stringBuilder.append(", selftextHtml=");
        stringBuilder.append(this.selftextHtml);
        stringBuilder.append(", permalink=");
        stringBuilder.append(this.permalink);
        stringBuilder.append(", isSelf=");
        stringBuilder.append(this.isSelf);
        stringBuilder.append(", postHint=");
        stringBuilder.append(this.postHint);
        stringBuilder.append(", authorFlairText=");
        stringBuilder.append(this.authorFlairText);
        stringBuilder.append(", websocketUrl=");
        stringBuilder.append(this.websocketUrl);
        stringBuilder.append(", archived=");
        stringBuilder.append(this.archived);
        stringBuilder.append(", locked=");
        stringBuilder.append(this.locked);
        stringBuilder.append(", quarantine=");
        stringBuilder.append(this.quarantine);
        stringBuilder.append(", hidden=");
        stringBuilder.append(this.hidden);
        stringBuilder.append(", saved=");
        stringBuilder.append(this.saved);
        stringBuilder.append(", hideScore=");
        stringBuilder.append(this.hideScore);
        stringBuilder.append(", stickied=");
        stringBuilder.append(this.stickied);
        stringBuilder.append(", canGild=");
        stringBuilder.append(this.canGild);
        stringBuilder.append(", canMod=");
        stringBuilder.append(this.canMod);
        stringBuilder.append(", distinguished=");
        stringBuilder.append(this.distinguished);
        stringBuilder.append(", approvedBy=");
        stringBuilder.append(this.approvedBy);
        stringBuilder.append(", approved=");
        stringBuilder.append(this.approved);
        stringBuilder.append(", removed=");
        stringBuilder.append(this.removed);
        stringBuilder.append(", spam=");
        stringBuilder.append(this.spam);
        stringBuilder.append(", numReports=");
        stringBuilder.append(this.numReports);
        stringBuilder.append(", brandSafe=");
        stringBuilder.append(this.brandSafe);
        stringBuilder.append(", isVideo=");
        stringBuilder.append(this.isVideo);
        stringBuilder.append(", locationName=");
        stringBuilder.append(this.locationName);
        stringBuilder.append(", modReports=");
        stringBuilder.append(this.modReports);
        stringBuilder.append(", userReports=");
        stringBuilder.append(this.userReports);
        stringBuilder.append(", crossPostParentList=");
        stringBuilder.append(this.crossPostParentList);
        stringBuilder.append(", subredditDetail=");
        stringBuilder.append(this.subredditDetail);
        stringBuilder.append(", promoted=");
        stringBuilder.append(this.promoted);
        stringBuilder.append(", isBlankAd=");
        stringBuilder.append(this.isBlankAd);
        stringBuilder.append(", events=");
        stringBuilder.append(this.events);
        stringBuilder.append(", outboundLink=");
        stringBuilder.append(this.outboundLink);
        stringBuilder.append(", domainOverride=");
        stringBuilder.append(this.domainOverride);
        stringBuilder.append(", isRead=");
        stringBuilder.append(this.isRead);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        Intrinsics.m26847b(parcel, "dest");
        DefaultImpls.writeToParcel(this, parcel, i);
    }

    public final String getId() {
        return this.id;
    }

    public final String getKindWithId() {
        return this.kindWithId;
    }

    public final long getCreatedUtc() {
        return this.createdUtc;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getDomain() {
        return this.domain;
    }

    public final String getUrl() {
        return this.url;
    }

    public final int getScore() {
        return this.score;
    }

    public final Boolean getLikes() {
        return this.likes;
    }

    public final int getUpvoteCount() {
        return this.upvoteCount;
    }

    public final int getDownvoteCount() {
        return this.downvoteCount;
    }

    public final long getNumComments() {
        return this.numComments;
    }

    public final Long getViewCount() {
        return this.viewCount;
    }

    public final String getSubreddit() {
        return this.subreddit;
    }

    public final String getSubredditId() {
        return this.subredditId;
    }

    public final String getSubredditNamePrefixed() {
        return this.subredditNamePrefixed;
    }

    public final String getLinkFlairText() {
        return this.linkFlairText;
    }

    public final String getLinkFlairId() {
        return this.linkFlairId;
    }

    public final List<FlairRichTextItem> getLinkFlairRichTextObject() {
        return this.linkFlairRichTextObject;
    }

    public final List<FlairRichTextItem> getAuthorFlairRichTextObject() {
        return this.authorFlairRichTextObject;
    }

    public final String getAuthor() {
        return this.author;
    }

    public final boolean getAuthorCakeday() {
        return this.authorCakeday;
    }

    public final int getGilded() {
        return this.gilded;
    }

    public final boolean getOver18() {
        return this.over18;
    }

    public final boolean getSpoiler() {
        return this.spoiler;
    }

    public final String getSuggestedSort() {
        return this.suggestedSort;
    }

    public final String getThumbnail() {
        return this.thumbnail;
    }

    public final String getBody() {
        return this.body;
    }

    public final Preview getPreview() {
        return this.preview;
    }

    public final LinkMedia getMedia() {
        return this.media;
    }

    public final String getSelftext() {
        return this.selftext;
    }

    public final String getSelftextHtml() {
        return this.selftextHtml;
    }

    public final String getPermalink() {
        return this.permalink;
    }

    public final boolean isSelf() {
        return this.isSelf;
    }

    public final String getPostHint() {
        return this.postHint;
    }

    public final String getAuthorFlairText() {
        return this.authorFlairText;
    }

    public final String getWebsocketUrl() {
        return this.websocketUrl;
    }

    public final boolean getArchived() {
        return this.archived;
    }

    public final boolean getLocked() {
        return this.locked;
    }

    public final boolean getQuarantine() {
        return this.quarantine;
    }

    public final boolean getHidden() {
        return this.hidden;
    }

    public final boolean getSaved() {
        return this.saved;
    }

    public final boolean getHideScore() {
        return this.hideScore;
    }

    public final boolean getStickied() {
        return this.stickied;
    }

    public final boolean getCanGild() {
        return this.canGild;
    }

    public final boolean getCanMod() {
        return this.canMod;
    }

    public final String getDistinguished() {
        return this.distinguished;
    }

    public final String getApprovedBy() {
        return this.approvedBy;
    }

    public final boolean getApproved() {
        return this.approved;
    }

    public final boolean getRemoved() {
        return this.removed;
    }

    public final boolean getSpam() {
        return this.spam;
    }

    public final Integer getNumReports() {
        return this.numReports;
    }

    public final boolean getBrandSafe() {
        return this.brandSafe;
    }

    public final boolean isVideo() {
        return this.isVideo;
    }

    public final String getLocationName() {
        return this.locationName;
    }

    public final List<List<String>> getModReports() {
        return this.modReports;
    }

    public final List<List<String>> getUserReports() {
        return this.userReports;
    }

    public final List<Link> getCrossPostParentList() {
        return this.crossPostParentList;
    }

    public final SubredditDetail getSubredditDetail() {
        return this.subredditDetail;
    }

    public final boolean getPromoted() {
        return this.promoted;
    }

    public final boolean isBlankAd() {
        return this.isBlankAd;
    }

    public final List<AdEvent> getEvents() {
        return this.events;
    }

    public final OutboundLink getOutboundLink() {
        return this.outboundLink;
    }

    public final String getDomainOverride() {
        return this.domainOverride;
    }

    public /* synthetic */ Link(String str, String str2, long j, String str3, String str4, String str5, int i, Boolean bool, int i2, int i3, long j2, Long l, String str6, String str7, String str8, String str9, String str10, List list, List list2, String str11, boolean z, int i4, boolean z2, boolean z3, String str12, String str13, String str14, Preview preview, LinkMedia linkMedia, String str15, String str16, String str17, boolean z4, String str18, String str19, String str20, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, String str21, String str22, boolean z14, boolean z15, boolean z16, Integer num, boolean z17, boolean z18, String str23, List list3, List list4, List list5, SubredditDetail subredditDetail, boolean z19, boolean z20, List list6, OutboundLink outboundLink, String str24, boolean z21, int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        int i7 = i5;
        int i8 = i6;
        this(str, str2, j, str3, str4, str5, i, (i7 & 128) != 0 ? null : bool, i2, i3, j2, l, str6, str7, str8, (32768 & i7) != 0 ? null : str9, (65536 & i7) != 0 ? null : str10, (131072 & i7) != 0 ? null : list, (262144 & i7) != 0 ? null : list2, str11, z, i4, z2, z3, (i7 & 16777216) != 0 ? null : str12, str13, (i7 & 67108864) != 0 ? null : str14, (i7 & MQEncoder.CARRY_MASK) != 0 ? null : preview, (i7 & 268435456) != 0 ? null : linkMedia, str15, (i7 & 1073741824) != 0 ? null : str16, str17, z4, (i8 & 2) != 0 ? null : str18, (i8 & 4) != 0 ? null : str19, str20, z5, z6, z7, z8, z9, z10, z11, z12, z13, (i8 & 8192) != 0 ? null : str21, (i8 & 16384) != 0 ? null : str22, z14, z15, z16, num, z17, z18, (2097152 & i8) != 0 ? null : str23, list3, list4, (i8 & 16777216) != 0 ? null : list5, (33554432 & i8) != 0 ? null : subredditDetail, (i8 & 67108864) != 0 ? false : z19, (i8 & MQEncoder.CARRY_MASK) != 0 ? false : z20, (i8 & 268435456) != 0 ? null : list6, (536870912 & i8) != 0 ? null : outboundLink, (i8 & 1073741824) != 0 ? null : str24, (Integer.MIN_VALUE & i8) != 0 ? false : z21);
    }

    public final boolean isRead() {
        return this.isRead;
    }

    public Link(String str, String str2, long j, String str3, String str4, String str5, int i, Boolean bool, int i2, int i3, long j2, Long l, String str6, String str7, String str8, String str9, String str10, List<FlairRichTextItem> list, List<FlairRichTextItem> list2, String str11, boolean z, int i4, boolean z2, boolean z3, String str12, String str13, String str14, Preview preview, LinkMedia linkMedia, String str15, String str16, String str17, boolean z4, String str18, String str19, String str20, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, String str21, String str22, boolean z14, boolean z15, boolean z16, Integer num, boolean z17, boolean z18, String str23, List<? extends List<String>> list3, List<? extends List<String>> list4, List<Link> list5, SubredditDetail subredditDetail, boolean z19, boolean z20, List<AdEvent> list6, OutboundLink outboundLink, String str24, boolean z21) {
        Link link = this;
        String str25 = str;
        String str26 = str2;
        String str27 = str3;
        String str28 = str4;
        String str29 = str5;
        String str30 = str6;
        String str31 = str7;
        String str32 = str8;
        String str33 = str11;
        String str34 = str13;
        String str35 = str15;
        String str36 = str17;
        String str37 = str20;
        List<? extends List<String>> list7 = list3;
        List<? extends List<String>> list8 = list4;
        Intrinsics.m26847b(str25, "id");
        Intrinsics.m26847b(str26, "kindWithId");
        Intrinsics.m26847b(str27, "title");
        Intrinsics.m26847b(str28, "domain");
        Intrinsics.m26847b(str29, UpdateFragment.FRAGMENT_URL);
        Intrinsics.m26847b(str30, "subreddit");
        Intrinsics.m26847b(str31, "subredditId");
        Intrinsics.m26847b(str32, "subredditNamePrefixed");
        Intrinsics.m26847b(str33, "author");
        Intrinsics.m26847b(str34, "thumbnail");
        Intrinsics.m26847b(str35, "selftext");
        Intrinsics.m26847b(str36, "permalink");
        Intrinsics.m26847b(str37, "websocketUrl");
        Intrinsics.m26847b(list7, "modReports");
        Intrinsics.m26847b(list8, "userReports");
        super();
        this.id = str25;
        this.kindWithId = str26;
        this.createdUtc = j;
        this.title = str27;
        this.domain = str28;
        this.url = str29;
        this.score = i;
        this.likes = bool;
        this.upvoteCount = i2;
        this.downvoteCount = i3;
        this.numComments = j2;
        this.viewCount = l;
        this.subreddit = str30;
        this.subredditId = str31;
        this.subredditNamePrefixed = str32;
        this.linkFlairText = str9;
        this.linkFlairId = str10;
        this.linkFlairRichTextObject = list;
        this.authorFlairRichTextObject = list2;
        this.author = str33;
        this.authorCakeday = z;
        this.gilded = i4;
        this.over18 = z2;
        this.spoiler = z3;
        this.suggestedSort = str12;
        this.thumbnail = str34;
        this.body = str14;
        this.preview = preview;
        this.media = linkMedia;
        this.selftext = str35;
        this.selftextHtml = str16;
        this.permalink = str36;
        this.isSelf = z4;
        this.postHint = str18;
        this.authorFlairText = str19;
        this.websocketUrl = str37;
        this.archived = z5;
        this.locked = z6;
        this.quarantine = z7;
        this.hidden = z8;
        this.saved = z9;
        this.hideScore = z10;
        this.stickied = z11;
        this.canGild = z12;
        this.canMod = z13;
        this.distinguished = str21;
        this.approvedBy = str22;
        this.approved = z14;
        this.removed = z15;
        this.spam = z16;
        this.numReports = num;
        this.brandSafe = z17;
        this.isVideo = z18;
        this.locationName = str23;
        this.modReports = list7;
        this.userReports = list4;
        this.crossPostParentList = list5;
        this.subredditDetail = subredditDetail;
        this.promoted = z19;
        this.isBlankAd = z20;
        this.events = list6;
        this.outboundLink = outboundLink;
        this.domainOverride = str24;
        this.isRead = z21;
    }

    private final String getDisplayDomain() {
        String str = this.domainOverride;
        return str == null ? this.domain : str;
    }

    public final LinkType getLinkType() {
        List list = this.crossPostParentList;
        Object obj = null;
        if (!(list == null || list.isEmpty())) {
            obj = 1;
        }
        if (obj != null) {
            return LinkType.CROSSPOST;
        }
        if (this.isSelf && this.preview == null) {
            return LinkType.SELF;
        }
        if (this.isSelf && this.preview != null) {
            return LinkType.SELF_IMAGE;
        }
        if (this.preview != null && isVideoLinkType()) {
            return LinkType.VIDEO;
        }
        if (this.preview == null || isVideoLinkType() || !isImageLinkType()) {
            return LinkType.WEBSITE;
        }
        return LinkType.IMAGE;
    }

    public final AnalyticsPostType getAnalyticsPostType() {
        if (this.crossPostParentList != null && (this.crossPostParentList.isEmpty() ^ 1) != 0) {
            return AnalyticsPostType.CROSSPOST;
        }
        if (this.isSelf && this.preview == null) {
            return AnalyticsPostType.TEXT;
        }
        if (this.isSelf && this.preview != null) {
            return AnalyticsPostType.IMAGE;
        }
        if (this.preview != null && isVideoLinkType() && isGifLinkType()) {
            return AnalyticsPostType.GIF;
        }
        if (this.preview != null && isVideoLinkType() && !isGifLinkType()) {
            return AnalyticsPostType.VIDEO;
        }
        if (this.preview == null || isVideoLinkType() || !isImageLinkType()) {
            return AnalyticsPostType.LINK;
        }
        return AnalyticsPostType.IMAGE;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isVideoLinkType() {
        /*
        r5 = this;
        r0 = r5.isVideo;
        r1 = 1;
        if (r0 == 0) goto L_0x0006;
    L_0x0005:
        return r1;
    L_0x0006:
        r0 = com.reddit.frontpage.presentation.common.ContentTypeUtil.f20363a;
        r0 = com.reddit.frontpage.presentation.common.ContentTypeUtil.m22699c();
        if (r0 == 0) goto L_0x0016;
    L_0x000e:
        r0 = com.reddit.frontpage.presentation.common.ContentTypeUtil.f20363a;
        r0 = com.reddit.frontpage.presentation.common.ContentTypeUtil.m22701d();
        if (r0 != 0) goto L_0x002d;
    L_0x0016:
        r0 = com.reddit.frontpage.sync.routine.AppConfigSyncRoutine.f28854f;
        r0 = com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings.a();
        r2 = "FrontpageSettings.getInstance()";
        kotlin.jvm.internal.Intrinsics.m26843a(r0, r2);
        r0 = r0.t();
        r2 = "FrontpageSettings.getInstance().appConfig";
        kotlin.jvm.internal.Intrinsics.m26843a(r0, r2);
        com.reddit.frontpage.sync.routine.AppConfigSyncRoutine.Companion.m23265a(r0);
    L_0x002d:
        r0 = r5.url;
        r2 = com.reddit.frontpage.presentation.common.ContentTypeUtil.f20363a;
        r2 = com.reddit.frontpage.presentation.common.ContentTypeUtil.m22694a(r0);
        r3 = 0;
        if (r2 != 0) goto L_0x0040;
    L_0x0038:
        r2 = com.reddit.frontpage.presentation.common.ContentTypeUtil.f20363a;
        r2 = com.reddit.frontpage.presentation.common.ContentTypeUtil.m22698b(r0);
        if (r2 == 0) goto L_0x0048;
    L_0x0040:
        r2 = r5.hasMp4Url();
        if (r2 == 0) goto L_0x0048;
    L_0x0046:
        r2 = r1;
        goto L_0x0049;
    L_0x0048:
        r2 = r3;
    L_0x0049:
        r4 = r5.preview;
        if (r4 == 0) goto L_0x0078;
    L_0x004d:
        if (r2 != 0) goto L_0x0077;
    L_0x004f:
        r2 = r5.postHint;
        r4 = "rich:video";
        r2 = kotlin.jvm.internal.Intrinsics.m26845a(r2, r4);
        if (r2 != 0) goto L_0x0077;
    L_0x0059:
        r2 = com.reddit.frontpage.presentation.common.ContentTypeUtil.f20363a;
        r2 = com.reddit.frontpage.presentation.common.ContentTypeUtil.f20363a;
        r2 = com.reddit.frontpage.presentation.common.ContentTypeUtil.m22699c();
        if (r2 != 0) goto L_0x0066;
    L_0x0063:
        kotlin.jvm.internal.Intrinsics.m26842a();
    L_0x0066:
        r4 = com.reddit.frontpage.presentation.common.ContentTypeUtil.f20363a;
        r4 = com.reddit.frontpage.presentation.common.ContentTypeUtil.m22701d();
        if (r4 != 0) goto L_0x0071;
    L_0x006e:
        kotlin.jvm.internal.Intrinsics.m26842a();
    L_0x0071:
        r0 = com.reddit.frontpage.presentation.common.ContentTypeUtil.m22695a(r0, r2, r4);
        if (r0 == 0) goto L_0x0078;
    L_0x0077:
        return r1;
    L_0x0078:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.frontpage.domain.model.Link.isVideoLinkType():boolean");
    }

    public final boolean isGifLinkType() {
        if (this.preview != null) {
            ContentTypeUtil contentTypeUtil = ContentTypeUtil.f20363a;
            if (ContentTypeUtil.m22698b(this.url) && hasMp4Url()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isImageLinkType() {
        /*
        r3 = this;
        r0 = com.reddit.frontpage.presentation.common.ContentTypeUtil.f20363a;
        r0 = com.reddit.frontpage.presentation.common.ContentTypeUtil.m22691a();
        if (r0 == 0) goto L_0x0010;
    L_0x0008:
        r0 = com.reddit.frontpage.presentation.common.ContentTypeUtil.f20363a;
        r0 = com.reddit.frontpage.presentation.common.ContentTypeUtil.m22696b();
        if (r0 != 0) goto L_0x0027;
    L_0x0010:
        r0 = com.reddit.frontpage.sync.routine.AppConfigSyncRoutine.f28854f;
        r0 = com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings.a();
        r1 = "FrontpageSettings.getInstance()";
        kotlin.jvm.internal.Intrinsics.m26843a(r0, r1);
        r0 = r0.t();
        r1 = "FrontpageSettings.getInstance().appConfig";
        kotlin.jvm.internal.Intrinsics.m26843a(r0, r1);
        com.reddit.frontpage.sync.routine.AppConfigSyncRoutine.Companion.m23265a(r0);
    L_0x0027:
        r0 = r3.preview;
        if (r0 == 0) goto L_0x0061;
    L_0x002b:
        r0 = r3.isVideoLinkType();
        if (r0 != 0) goto L_0x0061;
    L_0x0031:
        r0 = r3.postHint;
        r0 = (java.lang.CharSequence) r0;
        r1 = "image";
        r1 = (java.lang.CharSequence) r1;
        r0 = android.text.TextUtils.equals(r0, r1);
        if (r0 != 0) goto L_0x005f;
    L_0x003f:
        r0 = com.reddit.frontpage.presentation.common.ContentTypeUtil.f20363a;
        r0 = r3.url;
        r1 = com.reddit.frontpage.presentation.common.ContentTypeUtil.f20363a;
        r1 = com.reddit.frontpage.presentation.common.ContentTypeUtil.m22691a();
        if (r1 != 0) goto L_0x004e;
    L_0x004b:
        kotlin.jvm.internal.Intrinsics.m26842a();
    L_0x004e:
        r2 = com.reddit.frontpage.presentation.common.ContentTypeUtil.f20363a;
        r2 = com.reddit.frontpage.presentation.common.ContentTypeUtil.m22696b();
        if (r2 != 0) goto L_0x0059;
    L_0x0056:
        kotlin.jvm.internal.Intrinsics.m26842a();
    L_0x0059:
        r0 = com.reddit.frontpage.presentation.common.ContentTypeUtil.m22695a(r0, r1, r2);
        if (r0 == 0) goto L_0x0061;
    L_0x005f:
        r0 = 1;
        return r0;
    L_0x0061:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.frontpage.domain.model.Link.isImageLinkType():boolean");
    }

    public final boolean hasMp4Url() {
        if (this.isVideo) {
            return (this.media == null || this.media.getRedditVideo() == null) ? false : true;
        } else {
            Preview preview = this.preview;
            return (preview == null || ((Image) CollectionsKt___CollectionsKt.m41430d(preview.getImages())).getVariants().getMp4() == null) ? false : true;
        }
    }

    public final DistinguishType getDistinguishType() {
        if (this.distinguished == null) {
            return DistinguishType.b;
        }
        if (Intrinsics.m26845a(this.distinguished, Companion.getMODERATOR())) {
            return DistinguishType.a;
        }
        Class cls = DistinguishType.class;
        String str = this.distinguished;
        if (str == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        Object toUpperCase = str.toUpperCase();
        Intrinsics.m26843a(toUpperCase, "(this as java.lang.String).toUpperCase()");
        Object a = Enums.a(cls, toUpperCase).a(DistinguishType.b);
        Intrinsics.m26843a(a, "Enums.getIfPresent(Disti…  .or(DistinguishType.NO)");
        return (DistinguishType) a;
    }

    public final String generateDomainLabel(LinkType linkType) {
        Intrinsics.m26847b(linkType, "type");
        if (Companion.getDOMAIN_TYPES().contains(linkType) != null) {
            Object obj;
            String f;
            StringBuilder stringBuilder;
            linkType = DomainUtil.m22714a(getDisplayDomain());
            CharSequence charSequence = (CharSequence) linkType;
            if (charSequence != null) {
                if (charSequence.length() != 0) {
                    obj = null;
                    if (obj == null) {
                        f = Util.m24027f((int) C1761R.string.unicode_delimiter);
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(f);
                        stringBuilder.append(linkType);
                        return stringBuilder.toString();
                    }
                }
            }
            obj = 1;
            if (obj == null) {
                f = Util.m24027f((int) C1761R.string.unicode_delimiter);
                stringBuilder = new StringBuilder();
                stringBuilder.append(f);
                stringBuilder.append(linkType);
                return stringBuilder.toString();
            }
        }
        return null;
    }

    public final String getUniqueId() {
        return this.promoted ? AdUtil.m23634a(this) : getId();
    }

    public final String getLinkFlairRichText() {
        if (this.linkFlairRichTextObject != null) {
            return RichTextUtil.m23884b(this.linkFlairRichTextObject);
        }
        String str = this.linkFlairText;
        if (str == null) {
            str = "";
        }
        return str;
    }

    public final String getAuthorFlairRichText() {
        if (this.authorFlairRichTextObject != null) {
            return RichTextUtil.m23884b(this.authorFlairRichTextObject);
        }
        String str = this.authorFlairText;
        if (str == null) {
            str = "";
        }
        return str;
    }
}
