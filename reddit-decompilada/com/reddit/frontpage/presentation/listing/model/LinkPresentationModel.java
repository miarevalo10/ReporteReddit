package com.reddit.frontpage.presentation.listing.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.AdRequest;
import com.reddit.datalibrary.frontpage.data.feature.link.datasource.remote.DistinguishType;
import com.reddit.datalibrary.frontpage.requests.models.Reportable;
import com.reddit.datalibrary.frontpage.requests.models.Votable;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listable;
import com.reddit.frontpage.domain.model.AdEvent;
import com.reddit.frontpage.domain.model.Link;
import com.reddit.frontpage.domain.model.LinkMedia;
import com.reddit.frontpage.domain.model.LinkType;
import com.reddit.frontpage.domain.model.OutboundLink;
import com.reddit.frontpage.domain.model.Preview;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import net.hockeyapp.android.UpdateFragment;
import org.jcodec.codecs.common.biari.MQEncoder;
import org.jcodec.codecs.mpeg12.MPEGConst;
import paperparcel.PaperParcel;
import paperparcel.PaperParcelable;
import paperparcel.PaperParcelable.DefaultImpls;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b6\n\u0002\u0010\u0011\n\u0003\b\u0001\n\u0002\u0010\u0000\n\u0002\b\b\b\b\u0018\u0000 ¨\u00022\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002¨\u0002Bó\u0005\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u0012\u001a\u00020\u000b\u0012\u0006\u0010\u0013\u001a\u00020\b\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u0015\u001a\u00020\b\u0012\u0006\u0010\u0016\u001a\u00020\b\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u001a\u001a\u00020\u0018\u0012\u0006\u0010\u001b\u001a\u00020\u000e\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u001d\u001a\u00020\u0018\u0012\u0006\u0010\u001e\u001a\u00020\u001f\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\b\u0012\u0006\u0010!\u001a\u00020\u0018\u0012\b\b\u0002\u0010\"\u001a\u00020\u0018\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010$\u001a\u00020\u0018\u0012\u0006\u0010%\u001a\u00020\b\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010(\u001a\u00020\u0018\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010*\u001a\u00020\b\u0012\u0006\u0010+\u001a\u00020\u0018\u0012\b\u0010,\u001a\u0004\u0018\u00010-\u0012\b\u0010.\u001a\u0004\u0018\u00010/\u0012\b\u00100\u001a\u0004\u0018\u000101\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\b\u0012\u0006\u00103\u001a\u00020\b\u0012\b\u00104\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u00105\u001a\u00020\u0018\u0012\f\u00106\u001a\b\u0012\u0004\u0012\u00020807\u0012\b\b\u0002\u00109\u001a\u00020\u0018\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010;\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010=\u001a\u00020\u000e\u0012\u0006\u0010>\u001a\u00020\u0018\u0012\u0006\u0010?\u001a\u00020\u000b\u0012\b\u0010@\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010A\u001a\u00020\u0018\u0012\u0006\u0010B\u001a\u00020\u000e\u0012\u0012\u0010C\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0707\u0012\u0012\u0010D\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0707\u0012\b\b\u0002\u0010E\u001a\u00020\u0018\u0012\u0006\u0010F\u001a\u00020\u0018\u0012\b\b\u0002\u0010G\u001a\u00020\u0018\u0012\b\b\u0002\u0010H\u001a\u00020\u0018\u0012\b\b\u0002\u0010I\u001a\u00020\u0018\u0012\u0006\u0010J\u001a\u00020\b\u0012\u0006\u0010K\u001a\u00020\b\u0012\u0006\u0010L\u001a\u00020\b\u0012\u0006\u0010M\u001a\u00020\b\u0012\u0006\u0010N\u001a\u00020\b\u0012\b\u0010O\u001a\u0004\u0018\u00010\b\u0012\b\u0010P\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010Q\u001a\u00020\u0018\u0012\u0006\u0010R\u001a\u00020\u0018\u0012\u000e\b\u0002\u0010S\u001a\b\u0012\u0004\u0012\u00020\u000007\u0012\n\b\u0002\u0010T\u001a\u0004\u0018\u00010\u0000\u0012\b\u0010U\u001a\u0004\u0018\u00010\u0018\u0012\u0006\u0010V\u001a\u00020\u0018\u0012\b\u0010W\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010X\u001a\u00020\u0018\u0012\u0006\u0010Y\u001a\u00020\u0018\u0012\u0006\u0010Z\u001a\u00020\u0018\u0012\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\\\u0012\n\b\u0002\u0010]\u001a\u0004\u0018\u00010^\u0012\n\b\u0002\u0010_\u001a\u0004\u0018\u00010`¢\u0006\u0002\u0010aJ\n\u0010Ð\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010Ñ\u0001\u001a\u00020\u000bHÆ\u0003J\n\u0010Ò\u0001\u001a\u00020\bHÆ\u0003J\f\u0010Ó\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003J\n\u0010Ô\u0001\u001a\u00020\bHÆ\u0003J\n\u0010Õ\u0001\u001a\u00020\bHÆ\u0003J\n\u0010Ö\u0001\u001a\u00020\u0018HÆ\u0003J\f\u0010×\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003J\n\u0010Ø\u0001\u001a\u00020\u0018HÆ\u0003J\n\u0010Ù\u0001\u001a\u00020\u000eHÆ\u0003J\u0011\u0010Ú\u0001\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010|J\n\u0010Û\u0001\u001a\u00020\bHÆ\u0003J\n\u0010Ü\u0001\u001a\u00020\u0018HÆ\u0003J\n\u0010Ý\u0001\u001a\u00020\u001fHÆ\u0003J\f\u0010Þ\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003J\n\u0010ß\u0001\u001a\u00020\u0018HÆ\u0003J\n\u0010à\u0001\u001a\u00020\u0018HÆ\u0003J\f\u0010á\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003J\n\u0010â\u0001\u001a\u00020\u0018HÆ\u0003J\n\u0010ã\u0001\u001a\u00020\bHÆ\u0003J\f\u0010ä\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003J\f\u0010å\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003J\n\u0010æ\u0001\u001a\u00020\bHÆ\u0003J\n\u0010ç\u0001\u001a\u00020\u0018HÆ\u0003J\f\u0010è\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003J\n\u0010é\u0001\u001a\u00020\bHÆ\u0003J\n\u0010ê\u0001\u001a\u00020\u0018HÆ\u0003J\f\u0010ë\u0001\u001a\u0004\u0018\u00010-HÆ\u0003J\f\u0010ì\u0001\u001a\u0004\u0018\u00010/HÆ\u0003J\f\u0010í\u0001\u001a\u0004\u0018\u000101HÆ\u0003J\f\u0010î\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003J\n\u0010ï\u0001\u001a\u00020\bHÆ\u0003J\f\u0010ð\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003J\n\u0010ñ\u0001\u001a\u00020\u000bHÆ\u0003J\n\u0010ò\u0001\u001a\u00020\u0018HÆ\u0003J\u0010\u0010ó\u0001\u001a\b\u0012\u0004\u0012\u00020807HÆ\u0003J\n\u0010ô\u0001\u001a\u00020\u0018HÆ\u0003J\f\u0010õ\u0001\u001a\u0004\u0018\u00010;HÆ\u0003J\f\u0010ö\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003J\n\u0010÷\u0001\u001a\u00020\u000eHÆ\u0003J\n\u0010ø\u0001\u001a\u00020\u0018HÆ\u0003J\n\u0010ù\u0001\u001a\u00020\u000bHÆ\u0003J\u0012\u0010ú\u0001\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0003\u0010È\u0001J\n\u0010û\u0001\u001a\u00020\u0018HÆ\u0003J\n\u0010ü\u0001\u001a\u00020\bHÆ\u0003J\n\u0010ý\u0001\u001a\u00020\u000eHÆ\u0003J\u0016\u0010þ\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0707HÆ\u0003J\u0016\u0010ÿ\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0707HÆ\u0003J\n\u0010\u0002\u001a\u00020\u0018HÆ\u0003J\n\u0010\u0002\u001a\u00020\u0018HÆ\u0003J\n\u0010\u0002\u001a\u00020\u0018HÆ\u0003J\n\u0010\u0002\u001a\u00020\u0018HÆ\u0003J\n\u0010\u0002\u001a\u00020\u0018HÆ\u0003J\n\u0010\u0002\u001a\u00020\bHÆ\u0003J\n\u0010\u0002\u001a\u00020\bHÆ\u0003J\n\u0010\u0002\u001a\u00020\u000eHÆ\u0003J\n\u0010\u0002\u001a\u00020\bHÆ\u0003J\n\u0010\u0002\u001a\u00020\bHÆ\u0003J\n\u0010\u0002\u001a\u00020\bHÆ\u0003J\f\u0010\u0002\u001a\u0004\u0018\u00010\bHÆ\u0003J\f\u0010\u0002\u001a\u0004\u0018\u00010\bHÆ\u0003J\n\u0010\u0002\u001a\u00020\u0018HÆ\u0003J\n\u0010\u0002\u001a\u00020\u0018HÆ\u0003J\u0010\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u000007HÆ\u0003J\f\u0010\u0002\u001a\u0004\u0018\u00010\u0000HÆ\u0003J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0003\u0010\u0001J\n\u0010\u0002\u001a\u00020\bHÆ\u0003J\n\u0010\u0002\u001a\u00020\u0018HÆ\u0003J\f\u0010\u0002\u001a\u0004\u0018\u00010\bHÆ\u0003J\n\u0010\u0002\u001a\u00020\u0018HÆ\u0003J\n\u0010\u0002\u001a\u00020\u0018HÆ\u0003J\n\u0010\u0002\u001a\u00020\u0018HÆ\u0003J\f\u0010\u0002\u001a\u0004\u0018\u00010\\HÆ\u0003J\f\u0010\u0002\u001a\u0004\u0018\u00010^HÆ\u0003J\f\u0010\u0002\u001a\u0004\u0018\u00010`HÆ\u0003J\f\u0010\u0002\u001a\u0004\u0018\u00010\bHÆ\u0003J\f\u0010\u0002\u001a\u0004\u0018\u00010\bHÆ\u0003Jê\u0006\u0010\u0002\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\b\b\u0002\u0010\u0013\u001a\u00020\b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0015\u001a\u00020\b2\b\b\u0002\u0010\u0016\u001a\u00020\b2\b\b\u0002\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u001a\u001a\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u001d\u001a\u00020\u00182\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010!\u001a\u00020\u00182\b\b\u0002\u0010\"\u001a\u00020\u00182\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010$\u001a\u00020\u00182\b\b\u0002\u0010%\u001a\u00020\b2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010(\u001a\u00020\u00182\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010*\u001a\u00020\b2\b\b\u0002\u0010+\u001a\u00020\u00182\n\b\u0002\u0010,\u001a\u0004\u0018\u00010-2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/2\n\b\u0002\u00100\u001a\u0004\u0018\u0001012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\b2\b\b\u0002\u00103\u001a\u00020\b2\n\b\u0002\u00104\u001a\u0004\u0018\u00010\b2\b\b\u0002\u00105\u001a\u00020\u00182\u000e\b\u0002\u00106\u001a\b\u0012\u0004\u0012\u000208072\b\b\u0002\u00109\u001a\u00020\u00182\n\b\u0002\u0010:\u001a\u0004\u0018\u00010;2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010=\u001a\u00020\u000e2\b\b\u0002\u0010>\u001a\u00020\u00182\b\b\u0002\u0010?\u001a\u00020\u000b2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010A\u001a\u00020\u00182\b\b\u0002\u0010B\u001a\u00020\u000e2\u0014\b\u0002\u0010C\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b07072\u0014\b\u0002\u0010D\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b07072\b\b\u0002\u0010E\u001a\u00020\u00182\b\b\u0002\u0010F\u001a\u00020\u00182\b\b\u0002\u0010G\u001a\u00020\u00182\b\b\u0002\u0010H\u001a\u00020\u00182\b\b\u0002\u0010I\u001a\u00020\u00182\b\b\u0002\u0010J\u001a\u00020\b2\b\b\u0002\u0010K\u001a\u00020\b2\b\b\u0002\u0010L\u001a\u00020\b2\b\b\u0002\u0010M\u001a\u00020\b2\b\b\u0002\u0010N\u001a\u00020\b2\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010Q\u001a\u00020\u00182\b\b\u0002\u0010R\u001a\u00020\u00182\u000e\b\u0002\u0010S\u001a\b\u0012\u0004\u0012\u00020\u0000072\n\b\u0002\u0010T\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010U\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010V\u001a\u00020\u00182\n\b\u0002\u0010W\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010X\u001a\u00020\u00182\b\b\u0002\u0010Y\u001a\u00020\u00182\b\b\u0002\u0010Z\u001a\u00020\u00182\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\\2\n\b\u0002\u0010]\u001a\u0004\u0018\u00010^2\n\b\u0002\u0010_\u001a\u0004\u0018\u00010`HÆ\u0001¢\u0006\u0003\u0010\u0002J\u0016\u0010\u0002\u001a\u00020\u00182\n\u0010 \u0002\u001a\u0005\u0018\u00010¡\u0002HÖ\u0003J\t\u0010¢\u0002\u001a\u00020\u000bH\u0016J\u0007\u0010£\u0002\u001a\u00020\u0018J\n\u0010¤\u0002\u001a\u00020\u000eHÖ\u0001J\u0007\u0010¥\u0002\u001a\u00020\u0018J\u0007\u0010¦\u0002\u001a\u00020\u0018J\n\u0010§\u0002\u001a\u00020\bHÖ\u0001R\u0017\u00106\u001a\b\u0012\u0004\u0012\u00020807¢\u0006\b\n\u0000\u001a\u0004\bb\u0010cR\u0011\u0010\"\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\bd\u0010eR\u0013\u0010#\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\bf\u0010gR\u0011\u0010\u001a\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\bh\u0010eR\u0011\u0010\u0015\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\bi\u0010gR\u0011\u0010\u0016\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\bj\u0010gR\u0013\u00102\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\bk\u0010gR\u0013\u0010'\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\bl\u0010gR\u0011\u0010A\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\bm\u0010eR\u0011\u0010\u0012\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bn\u0010oR\u0017\u0010S\u001a\b\u0012\u0004\u0012\u00020\u000007¢\u0006\b\n\u0000\u001a\u0004\bp\u0010cR\u0016\u0010q\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\br\u0010gR\u0011\u0010\u001e\u001a\u00020\u001f¢\u0006\b\n\u0000\u001a\u0004\bs\u0010tR\u0013\u0010 \u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\bu\u0010gR\u0014\u0010L\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\bv\u0010gR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\bw\u0010gR\u0013\u0010<\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\bx\u0010gR\u0013\u0010T\u001a\u0004\u0018\u00010\u0000¢\u0006\b\n\u0000\u001a\u0004\by\u0010zR\u0015\u0010\u001c\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010}\u001a\u0004\b{\u0010|R\u0013\u0010&\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b~\u0010gR\u0012\u0010\u001b\u001a\u00020\u000e¢\u0006\t\n\u0000\u001a\u0005\b\u0010\u0001R\u0012\u0010F\u001a\u00020\u0018¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010eR\u0012\u0010>\u001a\u00020\u0018¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010eR\u0015\u0010,\u001a\u0004\u0018\u00010-¢\u0006\n\n\u0000\u001a\u0006\b\u0001\u0010\u0001R\u0018\u0010\u0001\u001a\u00020\b8\u0016XD¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010gR\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010eR\u0011\u00105\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b5\u0010eR\u0011\u0010Z\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010eR\u0011\u0010E\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\bE\u0010eR\u0011\u0010X\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\bX\u0010eR\u0018\u0010\u0001\u001a\u00020\u00188\u0016X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010eR\u0011\u0010V\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\bV\u0010eR\u0013\u0010\u0001\u001a\u00020\u00188F¢\u0006\u0007\u001a\u0005\b\u0001\u0010eR\u0011\u0010Y\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\bY\u0010eR\u0018\u0010U\u001a\u0004\u0018\u00010\u0018¢\u0006\r\n\u0003\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R\u0015\u0010_\u001a\u0004\u0018\u00010`¢\u0006\n\n\u0000\u001a\u0006\b\u0001\u0010\u0001R\u0014\u0010\u0011\u001a\u0004\u0018\u00010\b¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010gR\u0014\u0010\u0010\u001a\u0004\u0018\u00010\b¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010gR\u0012\u0010\t\u001a\u00020\b¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010gR\u0016\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0001\u0010\u0001R\u0014\u0010\u0019\u001a\u0004\u0018\u00010\b¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010gR\u0012\u0010!\u001a\u00020\u0018¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010eR\u0015\u0010]\u001a\u0004\u0018\u00010^¢\u0006\n\n\u0000\u001a\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u0010\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\b0\u00010\u00018\u0016X\u0004¢\u0006\r\n\u0003\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R\u001e\u0010D\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0707¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010cR\u0012\u0010\u0007\u001a\u00020\b¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010gR\u0015\u0010.\u001a\u0004\u0018\u00010/¢\u0006\n\n\u0000\u001a\u0006\b\u0001\u0010\u0001R\u0015\u0010\f\u001a\u00020\bX\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010gR\u0012\u0010?\u001a\u00020\u000b¢\u0006\t\n\u0000\u001a\u0005\b \u0001\u0010oR\u0016\u0010B\u001a\u00020\u000eX\u0004¢\u0006\n\n\u0000\u001a\u0006\b¡\u0001\u0010\u0001R\u0015\u0010:\u001a\u0004\u0018\u00010;¢\u0006\n\n\u0000\u001a\u0006\b¢\u0001\u0010£\u0001R\u0012\u0010(\u001a\u00020\u0018¢\u0006\t\n\u0000\u001a\u0005\b¤\u0001\u0010eR\u0012\u0010K\u001a\u00020\b¢\u0006\t\n\u0000\u001a\u0005\b¥\u0001\u0010gR\u0014\u0010W\u001a\u0004\u0018\u00010\b¢\u0006\t\n\u0000\u001a\u0005\b¦\u0001\u0010gR\u0015\u0010[\u001a\u0004\u0018\u00010\\¢\u0006\n\n\u0000\u001a\u0006\b§\u0001\u0010¨\u0001R\u0012\u00109\u001a\u00020\u0018¢\u0006\t\n\u0000\u001a\u0005\b©\u0001\u0010eR\u0012\u0010$\u001a\u00020\u0018¢\u0006\t\n\u0000\u001a\u0005\bª\u0001\u0010eR\u0012\u0010H\u001a\u00020\u0018¢\u0006\t\n\u0000\u001a\u0005\b«\u0001\u0010eR\u0012\u0010G\u001a\u00020\u0018¢\u0006\t\n\u0000\u001a\u0005\b¬\u0001\u0010eR\u0016\u0010=\u001a\u00020\u000eX\u0004¢\u0006\n\n\u0000\u001a\u0006\b­\u0001\u0010\u0001R\u0015\u00100\u001a\u0004\u0018\u000101¢\u0006\n\n\u0000\u001a\u0006\b®\u0001\u0010¯\u0001R\u0012\u00103\u001a\u00020\b¢\u0006\t\n\u0000\u001a\u0005\b°\u0001\u0010gR\u0014\u00104\u001a\u0004\u0018\u00010\b¢\u0006\t\n\u0000\u001a\u0005\b±\u0001\u0010gR\u0012\u0010I\u001a\u00020\u0018¢\u0006\t\n\u0000\u001a\u0005\b²\u0001\u0010eR\u0012\u0010+\u001a\u00020\u0018¢\u0006\t\n\u0000\u001a\u0005\b³\u0001\u0010eR\u0012\u0010\u001d\u001a\u00020\u0018¢\u0006\t\n\u0000\u001a\u0005\b´\u0001\u0010eR\u0012\u0010M\u001a\u00020\b¢\u0006\t\n\u0000\u001a\u0005\bµ\u0001\u0010gR\u0012\u0010\u000f\u001a\u00020\b¢\u0006\t\n\u0000\u001a\u0005\b¶\u0001\u0010gR\u0014\u0010P\u001a\u0004\u0018\u00010\b¢\u0006\t\n\u0000\u001a\u0005\b·\u0001\u0010gR\u0012\u0010N\u001a\u00020\b¢\u0006\t\n\u0000\u001a\u0005\b¸\u0001\u0010gR\u0014\u0010O\u001a\u0004\u0018\u00010\b¢\u0006\t\n\u0000\u001a\u0005\b¹\u0001\u0010gR\u0012\u0010Q\u001a\u00020\u0018¢\u0006\t\n\u0000\u001a\u0005\bº\u0001\u0010eR\u0012\u0010R\u001a\u00020\u0018¢\u0006\t\n\u0000\u001a\u0005\b»\u0001\u0010eR\u0014\u0010)\u001a\u0004\u0018\u00010\b¢\u0006\t\n\u0000\u001a\u0005\b¼\u0001\u0010gR\u0012\u0010*\u001a\u00020\b¢\u0006\t\n\u0000\u001a\u0005\b½\u0001\u0010gR\u0012\u0010\u0013\u001a\u00020\b¢\u0006\t\n\u0000\u001a\u0005\b¾\u0001\u0010gR\u0012\u0010%\u001a\u00020\b¢\u0006\t\n\u0000\u001a\u0005\b¿\u0001\u0010gR\u0013\u0010\u0005\u001a\u00020\u0006¢\u0006\n\n\u0000\u001a\u0006\bÀ\u0001\u0010Á\u0001R\u0012\u0010\n\u001a\u00020\u000b¢\u0006\t\n\u0000\u001a\u0005\bÂ\u0001\u0010oR\u0012\u0010J\u001a\u00020\b¢\u0006\t\n\u0000\u001a\u0005\bÃ\u0001\u0010gR*\u0010Ä\u0001\u001a\u0010\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\b0\u00010\u00018\u0016X\u0004¢\u0006\r\n\u0003\u0010\u0001\u001a\u0006\bÅ\u0001\u0010\u0001R\u001e\u0010C\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0707¢\u0006\t\n\u0000\u001a\u0005\bÆ\u0001\u0010cR\u0018\u0010@\u001a\u0004\u0018\u00010\u000b¢\u0006\r\n\u0003\u0010É\u0001\u001a\u0006\bÇ\u0001\u0010È\u0001R\u0018\u0010Ê\u0001\u001a\u00020\b8\u0016X\u0004¢\u0006\t\n\u0000\u001a\u0005\bË\u0001\u0010gR\u001f\u0010Ì\u0001\u001a\u00020\u000e8VX\u0004¢\u0006\u0010\u0012\u0006\bÍ\u0001\u0010Î\u0001\u001a\u0006\bÏ\u0001\u0010\u0001¨\u0006©\u0002"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/model/LinkPresentationModel;", "Lcom/reddit/datalibrary/frontpage/requests/models/Reportable;", "Lcom/reddit/datalibrary/frontpage/requests/models/Votable;", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listable;", "Lpaperparcel/PaperParcelable;", "type", "Lcom/reddit/frontpage/domain/model/LinkType;", "modelId", "", "linkId", "uniqueId", "", "name", "listableType", "", "subredditDisplayName", "linkFlairText", "linkFlairRichText", "createdUtc", "timePostedLabel", "domainLabel", "author", "authorDisplayName", "isAuthorCakeday", "", "location", "archived", "gildedCount", "flaggedCount", "stickied", "distinguishType", "Lcom/reddit/datalibrary/frontpage/data/feature/link/datasource/remote/DistinguishType;", "distinguished", "locked", "approved", "approvedBy", "quarantined", "title", "flair", "authorFlairRichText", "over18", "suggestedSort", "thumbnail", "spoiler", "imagePreview", "Lcom/reddit/frontpage/presentation/listing/model/ImageLinkPreviewPresentationModel;", "mp4Preview", "Lcom/reddit/frontpage/presentation/listing/model/Mp4LinkPreviewPresentationModel;", "selfImage", "Lcom/reddit/frontpage/presentation/listing/model/ImageResolutionPresentationModel;", "authorFlair", "selfText", "selfTextHtml", "isBlankAd", "adEvents", "", "Lcom/reddit/frontpage/domain/model/AdEvent;", "promoted", "outboundLink", "Lcom/reddit/frontpage/domain/model/OutboundLink;", "domainOverride", "score", "hideScore", "numComments", "viewCount", "canMod", "numReports", "userReportsList", "modReportsList", "isRead", "hidden", "saved", "removed", "spam", "url", "permalink", "domain", "subreddit", "subredditId", "subredditKeyColor", "subredditIconImage", "subredditOver18", "subredditUserIsModerator", "crossPostParentList", "firstCrossPostParent", "likes", "isSelf", "postHint", "isRedditVideo", "isVideoLinkType", "isImageLinkType", "preview", "Lcom/reddit/frontpage/domain/model/Preview;", "media", "Lcom/reddit/frontpage/domain/model/LinkMedia;", "link", "Lcom/reddit/frontpage/domain/model/Link;", "(Lcom/reddit/frontpage/domain/model/LinkType;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZILjava/lang/Integer;ZLcom/reddit/datalibrary/frontpage/data/feature/link/datasource/remote/DistinguishType;Ljava/lang/String;ZZLjava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ZLcom/reddit/frontpage/presentation/listing/model/ImageLinkPreviewPresentationModel;Lcom/reddit/frontpage/presentation/listing/model/Mp4LinkPreviewPresentationModel;Lcom/reddit/frontpage/presentation/listing/model/ImageResolutionPresentationModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;ZLcom/reddit/frontpage/domain/model/OutboundLink;Ljava/lang/String;IZJLjava/lang/Long;ZILjava/util/List;Ljava/util/List;ZZZZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/util/List;Lcom/reddit/frontpage/presentation/listing/model/LinkPresentationModel;Ljava/lang/Boolean;ZLjava/lang/String;ZZZLcom/reddit/frontpage/domain/model/Preview;Lcom/reddit/frontpage/domain/model/LinkMedia;Lcom/reddit/frontpage/domain/model/Link;)V", "getAdEvents", "()Ljava/util/List;", "getApproved", "()Z", "getApprovedBy", "()Ljava/lang/String;", "getArchived", "getAuthor", "getAuthorDisplayName", "getAuthorFlair", "getAuthorFlairRichText", "getCanMod", "getCreatedUtc", "()J", "getCrossPostParentList", "displayDomain", "getDisplayDomain", "getDistinguishType", "()Lcom/reddit/datalibrary/frontpage/data/feature/link/datasource/remote/DistinguishType;", "getDistinguished", "getDomain", "getDomainLabel", "getDomainOverride", "getFirstCrossPostParent", "()Lcom/reddit/frontpage/presentation/listing/model/LinkPresentationModel;", "getFlaggedCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getFlair", "getGildedCount", "()I", "getHidden", "getHideScore", "getImagePreview", "()Lcom/reddit/frontpage/presentation/listing/model/ImageLinkPreviewPresentationModel;", "instanceId", "getInstanceId", "isScoreHidden", "isSubscribed", "getLikes", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLink", "()Lcom/reddit/frontpage/domain/model/Link;", "getLinkFlairRichText", "getLinkFlairText", "getLinkId", "getListableType", "getLocation", "getLocked", "getMedia", "()Lcom/reddit/frontpage/domain/model/LinkMedia;", "modReports", "", "getModReports", "()[[Ljava/lang/String;", "[[Ljava/lang/String;", "getModReportsList", "getModelId", "getMp4Preview", "()Lcom/reddit/frontpage/presentation/listing/model/Mp4LinkPreviewPresentationModel;", "getName", "getNumComments", "getNumReports", "getOutboundLink", "()Lcom/reddit/frontpage/domain/model/OutboundLink;", "getOver18", "getPermalink", "getPostHint", "getPreview", "()Lcom/reddit/frontpage/domain/model/Preview;", "getPromoted", "getQuarantined", "getRemoved", "getSaved", "getScore", "getSelfImage", "()Lcom/reddit/frontpage/presentation/listing/model/ImageResolutionPresentationModel;", "getSelfText", "getSelfTextHtml", "getSpam", "getSpoiler", "getStickied", "getSubreddit", "getSubredditDisplayName", "getSubredditIconImage", "getSubredditId", "getSubredditKeyColor", "getSubredditOver18", "getSubredditUserIsModerator", "getSuggestedSort", "getThumbnail", "getTimePostedLabel", "getTitle", "getType", "()Lcom/reddit/frontpage/domain/model/LinkType;", "getUniqueId", "getUrl", "userReports", "getUserReports", "getUserReportsList", "getViewCount", "()Ljava/lang/Long;", "Ljava/lang/Long;", "votableType", "getVotableType", "voteDirection", "voteDirection$annotations", "()V", "getVoteDirection", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component4", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component5", "component50", "component51", "component52", "component53", "component54", "component55", "component56", "component57", "component58", "component59", "component6", "component60", "component61", "component62", "component63", "component64", "component65", "component66", "component67", "component68", "component69", "component7", "component70", "component71", "component72", "component73", "component74", "component75", "component76", "component77", "component8", "component9", "copy", "(Lcom/reddit/frontpage/domain/model/LinkType;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZILjava/lang/Integer;ZLcom/reddit/datalibrary/frontpage/data/feature/link/datasource/remote/DistinguishType;Ljava/lang/String;ZZLjava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ZLcom/reddit/frontpage/presentation/listing/model/ImageLinkPreviewPresentationModel;Lcom/reddit/frontpage/presentation/listing/model/Mp4LinkPreviewPresentationModel;Lcom/reddit/frontpage/presentation/listing/model/ImageResolutionPresentationModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;ZLcom/reddit/frontpage/domain/model/OutboundLink;Ljava/lang/String;IZJLjava/lang/Long;ZILjava/util/List;Ljava/util/List;ZZZZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/util/List;Lcom/reddit/frontpage/presentation/listing/model/LinkPresentationModel;Ljava/lang/Boolean;ZLjava/lang/String;ZZZLcom/reddit/frontpage/domain/model/Preview;Lcom/reddit/frontpage/domain/model/LinkMedia;Lcom/reddit/frontpage/domain/model/Link;)Lcom/reddit/frontpage/presentation/listing/model/LinkPresentationModel;", "equals", "other", "", "getUniqueID", "hasReports", "hashCode", "isDistinguished", "isXpost", "toString", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
@PaperParcel
/* compiled from: LinkPresentationModel.kt */
public final class LinkPresentationModel implements Reportable, Votable, Listable, PaperParcelable {
    public static final Creator<LinkPresentationModel> CREATOR = PaperParcelLinkPresentationModel.f20635p;
    public static final Companion aw = new Companion();
    public final String f33948A;
    public final String f33949B;
    public final boolean f33950C;
    public final String f33951D;
    public final String f33952E;
    public final boolean f33953F;
    public final ImageLinkPreviewPresentationModel f33954G;
    public final Mp4LinkPreviewPresentationModel f33955H;
    final ImageResolutionPresentationModel f33956I;
    final String f33957J;
    public final String f33958K;
    public final String f33959L;
    public final boolean f33960M;
    public final List<AdEvent> f33961N;
    public final boolean f33962O;
    public final OutboundLink f33963P;
    public final String f33964Q;
    public final boolean f33965R;
    public final long f33966S;
    public final Long f33967T;
    public final boolean f33968U;
    public final int f33969V;
    final List<List<String>> f33970W;
    final List<List<String>> f33971X;
    public final boolean f33972Y;
    public final boolean f33973Z;
    public final transient String f33974a;
    private final transient String[][] aA;
    private final transient String[][] aB;
    private final String aC;
    private final int aD;
    private final int aE;
    private final String aF;
    public final boolean aa;
    public final boolean ab;
    public final boolean ac;
    public final String ad;
    public final String ae;
    public final String af;
    public final String ag;
    public final String ah;
    public final String ai;
    public final boolean aj;
    final boolean ak;
    public final List<LinkPresentationModel> al;
    public final LinkPresentationModel am;
    public final Boolean an;
    public final boolean ao;
    public final String ap;
    public final boolean aq;
    public final boolean ar;
    public final boolean as;
    public final Preview at;
    public final LinkMedia au;
    public final Link av;
    private final transient boolean ax;
    private final transient String ay;
    private final transient String az;
    public final LinkType f33975b;
    public final String f33976c;
    public final String f33977d;
    final long f33978e;
    public final String f33979f;
    public final String f33980g;
    final String f33981h;
    public final long f33982i;
    public final String f33983j;
    public final String f33984k;
    public final String f33985l;
    public final String f33986m;
    public final boolean f33987n;
    public final String f33988o;
    public final boolean f33989p;
    public final int f33990q;
    final Integer f33991r;
    public final boolean f33992s;
    public final DistinguishType f33993t;
    public final String f33994u;
    public final boolean f33995v;
    public final boolean f33996w;
    public final String f33997x;
    public final boolean f33998y;
    public final String f33999z;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/model/LinkPresentationModel$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/reddit/frontpage/presentation/listing/model/LinkPresentationModel;", "kotlin.jvm.PlatformType", "VOTABLE_TYPE_LINK", "", "VOTABLE_TYPE_SELF", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: LinkPresentationModel.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final int getMinAndroidVersion() {
        return 0;
    }

    public LinkPresentationModel(LinkType linkType, String str, String str2, long j, String str3, int i, String str4, String str5, String str6, long j2, String str7, String str8, String str9, String str10, boolean z, String str11, boolean z2, int i2, Integer num, boolean z3, DistinguishType distinguishType, String str12, boolean z4, boolean z5, String str13, boolean z6, String str14, String str15, String str16, boolean z7, String str17, String str18, boolean z8, ImageLinkPreviewPresentationModel imageLinkPreviewPresentationModel, Mp4LinkPreviewPresentationModel mp4LinkPreviewPresentationModel, ImageResolutionPresentationModel imageResolutionPresentationModel, String str19, String str20, String str21, boolean z9, List<AdEvent> list, boolean z10, OutboundLink outboundLink, String str22, int i3, boolean z11, long j3, Long l, boolean z12, int i4, List<? extends List<String>> list2, List<? extends List<String>> list3, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17, String str23, String str24, String str25, String str26, String str27, String str28, String str29, boolean z18, boolean z19, List<LinkPresentationModel> list4, LinkPresentationModel linkPresentationModel, Boolean bool, boolean z20, String str30, boolean z21, boolean z22, boolean z23, Preview preview, LinkMedia linkMedia, Link link) {
        LinkPresentationModel linkPresentationModel2 = this;
        LinkType linkType2 = linkType;
        String str31 = str;
        String str32 = str2;
        String str33 = str3;
        String str34 = str4;
        String str35 = str7;
        String str36 = str9;
        String str37 = str10;
        DistinguishType distinguishType2 = distinguishType;
        String str38 = str14;
        String str39 = str18;
        String str40 = str20;
        List<AdEvent> list5 = list;
        List<? extends List<String>> list6 = list2;
        List<? extends List<String>> list7 = list3;
        String str41 = str23;
        Intrinsics.m26847b(linkType2, "type");
        Intrinsics.m26847b(str31, "modelId");
        Intrinsics.m26847b(str32, "linkId");
        Intrinsics.m26847b(str33, "name");
        Intrinsics.m26847b(str34, "subredditDisplayName");
        Intrinsics.m26847b(str35, "timePostedLabel");
        Intrinsics.m26847b(str36, "author");
        Intrinsics.m26847b(str37, "authorDisplayName");
        Intrinsics.m26847b(distinguishType2, "distinguishType");
        Intrinsics.m26847b(str38, "title");
        Intrinsics.m26847b(str39, "thumbnail");
        Intrinsics.m26847b(str40, "selfText");
        Intrinsics.m26847b(list5, "adEvents");
        Intrinsics.m26847b(list6, "userReportsList");
        Intrinsics.m26847b(list7, "modReportsList");
        Intrinsics.m26847b(str23, UpdateFragment.FRAGMENT_URL);
        Intrinsics.m26847b(str24, "permalink");
        Intrinsics.m26847b(str25, "domain");
        Intrinsics.m26847b(str26, "subreddit");
        Intrinsics.m26847b(str27, "subredditId");
        Intrinsics.m26847b(list4, "crossPostParentList");
        String str42 = str23;
        this.f33975b = linkType2;
        this.f33976c = str31;
        this.f33977d = str32;
        this.f33978e = j;
        this.aC = str33;
        this.aD = i;
        this.f33979f = str34;
        this.f33980g = str5;
        this.f33981h = str6;
        this.f33982i = j2;
        this.f33983j = str35;
        this.f33984k = str8;
        this.f33985l = str36;
        this.f33986m = str37;
        this.f33987n = z;
        this.f33988o = str11;
        this.f33989p = z2;
        this.f33990q = i2;
        this.f33991r = num;
        this.f33992s = z3;
        this.f33993t = distinguishType2;
        this.f33994u = str12;
        this.f33995v = z4;
        this.f33996w = z5;
        this.f33997x = str13;
        this.f33998y = z6;
        this.f33999z = str38;
        this.f33948A = str15;
        this.f33949B = str16;
        this.f33950C = z7;
        this.f33951D = str17;
        this.f33952E = str39;
        this.f33953F = z8;
        this.f33954G = imageLinkPreviewPresentationModel;
        this.f33955H = mp4LinkPreviewPresentationModel;
        this.f33956I = imageResolutionPresentationModel;
        this.f33957J = str19;
        this.f33958K = str40;
        this.f33959L = str21;
        this.f33960M = z9;
        this.f33961N = list5;
        this.f33962O = z10;
        this.f33963P = outboundLink;
        this.f33964Q = str22;
        this.aE = i3;
        this.f33965R = z11;
        this.f33966S = j3;
        this.f33967T = l;
        this.f33968U = z12;
        this.f33969V = i4;
        this.f33970W = list6;
        this.f33971X = list3;
        this.f33972Y = z13;
        this.f33973Z = z14;
        this.aa = z15;
        this.ab = z16;
        this.ac = z17;
        this.ad = str42;
        str31 = str25;
        this.ae = str24;
        this.aF = str31;
        str31 = str27;
        this.af = str26;
        this.ag = str31;
        this.ah = str28;
        this.ai = str29;
        this.aj = z18;
        this.ak = z19;
        this.al = list4;
        this.am = linkPresentationModel;
        this.an = bool;
        this.ao = z20;
        this.ap = str30;
        this.aq = z21;
        this.ar = z22;
        this.as = z23;
        this.at = preview;
        this.au = linkMedia;
        this.av = link;
        this.ax = this.f33965R;
        linkPresentationModel2.ay = this.ao ? "self" : "link";
        linkPresentationModel2.az = "fake_instance_id";
        Iterable<Collection> iterable = linkPresentationModel2.f33970W;
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        for (Collection collection : iterable) {
            if (collection == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.util.Collection<T>");
            }
            Object[] toArray = collection.toArray(new String[0]);
            if (toArray == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            arrayList.add((String[]) toArray);
        }
        Object[] toArray2 = ((List) arrayList).toArray(new String[0][]);
        if (toArray2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        linkPresentationModel2.aA = (String[][]) toArray2;
        iterable = linkPresentationModel2.f33971X;
        arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        for (Collection collection2 : iterable) {
            if (collection2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.util.Collection<T>");
            }
            toArray = collection2.toArray(new String[0]);
            if (toArray == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            arrayList.add((String[]) toArray);
        }
        toArray2 = ((List) arrayList).toArray(new String[0][]);
        if (toArray2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        linkPresentationModel2.aB = (String[][]) toArray2;
        String str43 = linkPresentationModel2.f33964Q;
        if (str43 == null) {
            str43 = getDomain();
        }
        linkPresentationModel2.f33974a = str43;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        Intrinsics.m26847b(parcel, "dest");
        DefaultImpls.writeToParcel(this, parcel, i);
    }

    public final String getName() {
        return this.aC;
    }

    public final int getListableType() {
        return this.aD;
    }

    public final int getScore() {
        return this.aE;
    }

    public final String getDomain() {
        return this.aF;
    }

    public final long getUniqueID() {
        return this.f33978e;
    }

    public final int getVoteDirection() {
        Object obj = this.an;
        if (Intrinsics.m26845a(obj, Boolean.valueOf(true))) {
            return 1;
        }
        if (Intrinsics.m26845a(obj, Boolean.valueOf(false))) {
            return -1;
        }
        if (obj == null) {
            return 0;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final boolean isScoreHidden() {
        return this.ax;
    }

    public final String getVotableType() {
        return this.ay;
    }

    public final String getInstanceId() {
        return this.az;
    }

    public final String[][] getUserReports() {
        return this.aA;
    }

    public final String[][] getModReports() {
        return this.aB;
    }

    public final boolean m34744a() {
        return Intrinsics.m26845a(this.f33993t, DistinguishType.b) ^ 1;
    }

    public static /* synthetic */ LinkPresentationModel m34743a(LinkPresentationModel linkPresentationModel, LinkType linkType, String str, String str2, long j, String str3, int i, String str4, String str5, String str6, long j2, String str7, String str8, String str9, String str10, boolean z, String str11, boolean z2, int i2, Integer num, boolean z3, DistinguishType distinguishType, String str12, boolean z4, boolean z5, String str13, boolean z6, String str14, String str15, String str16, boolean z7, String str17, String str18, boolean z8, ImageLinkPreviewPresentationModel imageLinkPreviewPresentationModel, Mp4LinkPreviewPresentationModel mp4LinkPreviewPresentationModel, ImageResolutionPresentationModel imageResolutionPresentationModel, String str19, String str20, String str21, boolean z9, List list, boolean z10, OutboundLink outboundLink, String str22, int i3, boolean z11, long j3, Long l, boolean z12, int i4, List list2, List list3, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17, String str23, String str24, String str25, String str26, String str27, String str28, String str29, boolean z18, boolean z19, List list4, LinkPresentationModel linkPresentationModel2, Boolean bool, boolean z20, String str30, boolean z21, boolean z22, boolean z23, Preview preview, LinkMedia linkMedia, Link link, int i5, int i6, int i7, Object obj) {
        String str31;
        String str32;
        int i8;
        String str33;
        long j4;
        String str34;
        List list5;
        long j5;
        int i9;
        List list6;
        boolean z24;
        String str35;
        String str36;
        String str37;
        String str38;
        String str39;
        LinkPresentationModel linkPresentationModel3 = linkPresentationModel;
        int i10 = i5;
        int i11 = i6;
        LinkType linkType2 = (i10 & 1) != 0 ? linkPresentationModel3.f33975b : linkType;
        String str40 = (i10 & 2) != 0 ? linkPresentationModel3.f33976c : str;
        String str41 = (i10 & 4) != 0 ? linkPresentationModel3.f33977d : str2;
        long j6 = (i10 & 8) != 0 ? linkPresentationModel3.f33978e : j;
        String name = (i10 & 16) != 0 ? linkPresentationModel.getName() : str3;
        int listableType = (i10 & 32) != 0 ? linkPresentationModel.getListableType() : i;
        String str42 = (i10 & 64) != 0 ? linkPresentationModel3.f33979f : str4;
        String str43 = (i10 & 128) != 0 ? linkPresentationModel3.f33980g : str5;
        String str44 = (i10 & 256) != 0 ? linkPresentationModel3.f33981h : str6;
        long j7 = (i10 & AdRequest.MAX_CONTENT_URL_LENGTH) != 0 ? linkPresentationModel3.f33982i : j2;
        String str45 = (i10 & 1024) != 0 ? linkPresentationModel3.f33983j : str7;
        String str46 = (i10 & MPEGConst.CODE_END) != 0 ? linkPresentationModel3.f33984k : str8;
        String str47 = (i10 & 4096) != 0 ? linkPresentationModel3.f33985l : str9;
        long j8 = j7;
        String str48 = (i10 & 8192) != 0 ? linkPresentationModel3.f33986m : str10;
        String str49 = str44;
        boolean z25 = (i10 & 16384) != 0 ? linkPresentationModel3.f33987n : z;
        String str50 = (32768 & i10) != 0 ? linkPresentationModel3.f33988o : str11;
        boolean z26 = (65536 & i10) != 0 ? linkPresentationModel3.f33989p : z2;
        int i12 = (131072 & i10) != 0 ? linkPresentationModel3.f33990q : i2;
        Integer num2 = (262144 & i10) != 0 ? linkPresentationModel3.f33991r : num;
        boolean z27 = (524288 & i10) != 0 ? linkPresentationModel3.f33992s : z3;
        DistinguishType distinguishType2 = (1048576 & i10) != 0 ? linkPresentationModel3.f33993t : distinguishType;
        if ((i10 & 2097152) != 0) {
            str31 = str43;
            str32 = linkPresentationModel3.f33994u;
        } else {
            str31 = str43;
            str32 = str12;
        }
        boolean z28 = (4194304 & i10) != 0 ? linkPresentationModel3.f33995v : z4;
        boolean z29 = (8388608 & i10) != 0 ? linkPresentationModel3.f33996w : z5;
        String str51 = (16777216 & i10) != 0 ? linkPresentationModel3.f33997x : str13;
        boolean z30 = (33554432 & i10) != 0 ? linkPresentationModel3.f33998y : z6;
        str43 = (67108864 & i10) != 0 ? linkPresentationModel3.f33999z : str14;
        if ((i10 & MQEncoder.CARRY_MASK) != 0) {
            i8 = listableType;
            str33 = linkPresentationModel3.f33948A;
        } else {
            i8 = listableType;
            str33 = str15;
        }
        String str52 = (268435456 & i10) != 0 ? linkPresentationModel3.f33949B : str16;
        boolean z31 = (536870912 & i10) != 0 ? linkPresentationModel3.f33950C : z7;
        String str53 = (1073741824 & i10) != 0 ? linkPresentationModel3.f33951D : str17;
        String str54 = (i10 & Integer.MIN_VALUE) != 0 ? linkPresentationModel3.f33952E : str18;
        boolean z32 = (i11 & 1) != 0 ? linkPresentationModel3.f33953F : z8;
        ImageLinkPreviewPresentationModel imageLinkPreviewPresentationModel2 = (i11 & 2) != 0 ? linkPresentationModel3.f33954G : imageLinkPreviewPresentationModel;
        Mp4LinkPreviewPresentationModel mp4LinkPreviewPresentationModel2 = (i11 & 4) != 0 ? linkPresentationModel3.f33955H : mp4LinkPreviewPresentationModel;
        ImageResolutionPresentationModel imageResolutionPresentationModel2 = (i11 & 8) != 0 ? linkPresentationModel3.f33956I : imageResolutionPresentationModel;
        String str55 = (i11 & 16) != 0 ? linkPresentationModel3.f33957J : str19;
        String str56 = (i11 & 32) != 0 ? linkPresentationModel3.f33958K : str20;
        if ((i11 & 64) != 0) {
            j4 = j6;
            str34 = linkPresentationModel3.f33959L;
        } else {
            j4 = j6;
            str34 = str21;
        }
        boolean z33 = (i11 & 128) != 0 ? linkPresentationModel3.f33960M : z9;
        List list7 = (i11 & 256) != 0 ? linkPresentationModel3.f33961N : list;
        boolean z34 = (i11 & AdRequest.MAX_CONTENT_URL_LENGTH) != 0 ? linkPresentationModel3.f33962O : z10;
        OutboundLink outboundLink2 = (i11 & 1024) != 0 ? linkPresentationModel3.f33963P : outboundLink;
        String str57 = (i11 & MPEGConst.CODE_END) != 0 ? linkPresentationModel3.f33964Q : str22;
        int score = (i11 & 4096) != 0 ? linkPresentationModel.getScore() : i3;
        boolean z35 = (i11 & 8192) != 0 ? linkPresentationModel3.f33965R : z11;
        if ((i11 & 16384) != 0) {
            list5 = list7;
            j5 = linkPresentationModel3.f33966S;
        } else {
            list5 = list7;
            j5 = j3;
        }
        Long l2 = (32768 & i11) != 0 ? linkPresentationModel3.f33967T : l;
        boolean z36 = (65536 & i11) != 0 ? linkPresentationModel3.f33968U : z12;
        if ((131072 & i11) != 0) {
            i9 = linkPresentationModel3.f33969V;
        } else {
            i9 = i4;
        }
        list7 = (262144 & i11) != 0 ? linkPresentationModel3.f33970W : list2;
        List list8 = (524288 & i11) != 0 ? linkPresentationModel3.f33971X : list3;
        if ((i11 & 1048576) != 0) {
            list6 = list8;
            z24 = linkPresentationModel3.f33972Y;
        } else {
            list6 = list8;
            z24 = z13;
        }
        boolean z37 = (2097152 & i11) != 0 ? linkPresentationModel3.f33973Z : z14;
        boolean z38 = (4194304 & i11) != 0 ? linkPresentationModel3.aa : z15;
        boolean z39 = (8388608 & i11) != 0 ? linkPresentationModel3.ab : z16;
        boolean z40 = (16777216 & i11) != 0 ? linkPresentationModel3.ac : z17;
        String str58 = (33554432 & i11) != 0 ? linkPresentationModel3.ad : str23;
        if ((i11 & 67108864) != 0) {
            str35 = str58;
            str58 = linkPresentationModel3.ae;
        } else {
            str35 = str58;
            str58 = str24;
        }
        String domain = (i11 & MQEncoder.CARRY_MASK) != 0 ? linkPresentationModel.getDomain() : str25;
        if ((i11 & 268435456) != 0) {
            str36 = str58;
            str58 = linkPresentationModel3.af;
        } else {
            str36 = str58;
            str58 = str26;
        }
        if ((i11 & 536870912) != 0) {
            str37 = str58;
            str58 = linkPresentationModel3.ag;
        } else {
            str37 = str58;
            str58 = str27;
        }
        if ((i11 & 1073741824) != 0) {
            str38 = str58;
            str39 = linkPresentationModel3.ah;
        } else {
            str38 = str58;
            str39 = str28;
        }
        String str59 = (i11 & Integer.MIN_VALUE) != 0 ? linkPresentationModel3.ai : str29;
        boolean z41 = linkPresentationModel3.aj;
        boolean z42 = linkPresentationModel3.ak;
        boolean z43 = z41;
        List list9 = linkPresentationModel3.al;
        boolean z44 = z42;
        LinkPresentationModel linkPresentationModel4 = linkPresentationModel3.am;
        Boolean bool2 = linkPresentationModel3.an;
        boolean z45 = linkPresentationModel3.ao;
        String str60 = linkPresentationModel3.ap;
        boolean z46 = linkPresentationModel3.aq;
        boolean z47 = linkPresentationModel3.ar;
        boolean z48 = linkPresentationModel3.as;
        Preview preview2 = linkPresentationModel3.at;
        LinkMedia linkMedia2 = linkPresentationModel3.au;
        Link link2 = linkPresentationModel3.av;
        LinkMedia linkMedia3 = linkMedia2;
        Intrinsics.m26847b(linkType2, "type");
        Intrinsics.m26847b(str40, "modelId");
        Intrinsics.m26847b(str41, "linkId");
        Intrinsics.m26847b(name, "name");
        Intrinsics.m26847b(str42, "subredditDisplayName");
        Intrinsics.m26847b(str45, "timePostedLabel");
        Intrinsics.m26847b(str47, "author");
        Intrinsics.m26847b(str48, "authorDisplayName");
        Intrinsics.m26847b(distinguishType2, "distinguishType");
        Intrinsics.m26847b(str43, "title");
        Intrinsics.m26847b(str54, "thumbnail");
        Intrinsics.m26847b(str56, "selfText");
        String str61 = str56;
        List list10 = list5;
        Intrinsics.m26847b(list10, "adEvents");
        Intrinsics.m26847b(list7, "userReportsList");
        List list11 = list7;
        list7 = list6;
        Intrinsics.m26847b(list7, "modReportsList");
        List list12 = list7;
        String str62 = str35;
        Intrinsics.m26847b(str62, UpdateFragment.FRAGMENT_URL);
        String str63 = str62;
        str62 = str36;
        Intrinsics.m26847b(str62, "permalink");
        Link link3 = link2;
        String str64 = domain;
        Intrinsics.m26847b(str64, "domain");
        String str65 = str62;
        str62 = str37;
        Intrinsics.m26847b(str62, "subreddit");
        String str66 = str62;
        str62 = str38;
        Intrinsics.m26847b(str62, "subredditId");
        Intrinsics.m26847b(list9, "crossPostParentList");
        return new LinkPresentationModel(linkType2, str40, str41, j4, name, i8, str42, str31, str49, j8, str45, str46, str47, str48, z25, str50, z26, i12, num2, z27, distinguishType2, str32, z28, z29, str51, z30, str43, str33, str52, z31, str53, str54, z32, imageLinkPreviewPresentationModel2, mp4LinkPreviewPresentationModel2, imageResolutionPresentationModel2, str55, str61, str34, z33, list10, z34, outboundLink2, str57, score, z35, j5, l2, z36, i9, list11, list12, z24, z37, z38, z39, z40, str63, str65, str64, str66, str62, str39, str59, z43, z44, list9, linkPresentationModel4, bool2, z45, str60, z46, z47, z48, preview2, linkMedia3, link3);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("LinkPresentationModel(type=");
        stringBuilder.append(this.f33975b);
        stringBuilder.append(", modelId=");
        stringBuilder.append(this.f33976c);
        stringBuilder.append(", linkId=");
        stringBuilder.append(this.f33977d);
        stringBuilder.append(", uniqueId=");
        stringBuilder.append(this.f33978e);
        stringBuilder.append(", name=");
        stringBuilder.append(getName());
        stringBuilder.append(", listableType=");
        stringBuilder.append(getListableType());
        stringBuilder.append(", subredditDisplayName=");
        stringBuilder.append(this.f33979f);
        stringBuilder.append(", linkFlairText=");
        stringBuilder.append(this.f33980g);
        stringBuilder.append(", linkFlairRichText=");
        stringBuilder.append(this.f33981h);
        stringBuilder.append(", createdUtc=");
        stringBuilder.append(this.f33982i);
        stringBuilder.append(", timePostedLabel=");
        stringBuilder.append(this.f33983j);
        stringBuilder.append(", domainLabel=");
        stringBuilder.append(this.f33984k);
        stringBuilder.append(", author=");
        stringBuilder.append(this.f33985l);
        stringBuilder.append(", authorDisplayName=");
        stringBuilder.append(this.f33986m);
        stringBuilder.append(", isAuthorCakeday=");
        stringBuilder.append(this.f33987n);
        stringBuilder.append(", location=");
        stringBuilder.append(this.f33988o);
        stringBuilder.append(", archived=");
        stringBuilder.append(this.f33989p);
        stringBuilder.append(", gildedCount=");
        stringBuilder.append(this.f33990q);
        stringBuilder.append(", flaggedCount=");
        stringBuilder.append(this.f33991r);
        stringBuilder.append(", stickied=");
        stringBuilder.append(this.f33992s);
        stringBuilder.append(", distinguishType=");
        stringBuilder.append(this.f33993t);
        stringBuilder.append(", distinguished=");
        stringBuilder.append(this.f33994u);
        stringBuilder.append(", locked=");
        stringBuilder.append(this.f33995v);
        stringBuilder.append(", approved=");
        stringBuilder.append(this.f33996w);
        stringBuilder.append(", approvedBy=");
        stringBuilder.append(this.f33997x);
        stringBuilder.append(", quarantined=");
        stringBuilder.append(this.f33998y);
        stringBuilder.append(", title=");
        stringBuilder.append(this.f33999z);
        stringBuilder.append(", flair=");
        stringBuilder.append(this.f33948A);
        stringBuilder.append(", authorFlairRichText=");
        stringBuilder.append(this.f33949B);
        stringBuilder.append(", over18=");
        stringBuilder.append(this.f33950C);
        stringBuilder.append(", suggestedSort=");
        stringBuilder.append(this.f33951D);
        stringBuilder.append(", thumbnail=");
        stringBuilder.append(this.f33952E);
        stringBuilder.append(", spoiler=");
        stringBuilder.append(this.f33953F);
        stringBuilder.append(", imagePreview=");
        stringBuilder.append(this.f33954G);
        stringBuilder.append(", mp4Preview=");
        stringBuilder.append(this.f33955H);
        stringBuilder.append(", selfImage=");
        stringBuilder.append(this.f33956I);
        stringBuilder.append(", authorFlair=");
        stringBuilder.append(this.f33957J);
        stringBuilder.append(", selfText=");
        stringBuilder.append(this.f33958K);
        stringBuilder.append(", selfTextHtml=");
        stringBuilder.append(this.f33959L);
        stringBuilder.append(", isBlankAd=");
        stringBuilder.append(this.f33960M);
        stringBuilder.append(", adEvents=");
        stringBuilder.append(this.f33961N);
        stringBuilder.append(", promoted=");
        stringBuilder.append(this.f33962O);
        stringBuilder.append(", outboundLink=");
        stringBuilder.append(this.f33963P);
        stringBuilder.append(", domainOverride=");
        stringBuilder.append(this.f33964Q);
        stringBuilder.append(", score=");
        stringBuilder.append(getScore());
        stringBuilder.append(", hideScore=");
        stringBuilder.append(this.f33965R);
        stringBuilder.append(", numComments=");
        stringBuilder.append(this.f33966S);
        stringBuilder.append(", viewCount=");
        stringBuilder.append(this.f33967T);
        stringBuilder.append(", canMod=");
        stringBuilder.append(this.f33968U);
        stringBuilder.append(", numReports=");
        stringBuilder.append(this.f33969V);
        stringBuilder.append(", userReportsList=");
        stringBuilder.append(this.f33970W);
        stringBuilder.append(", modReportsList=");
        stringBuilder.append(this.f33971X);
        stringBuilder.append(", isRead=");
        stringBuilder.append(this.f33972Y);
        stringBuilder.append(", hidden=");
        stringBuilder.append(this.f33973Z);
        stringBuilder.append(", saved=");
        stringBuilder.append(this.aa);
        stringBuilder.append(", removed=");
        stringBuilder.append(this.ab);
        stringBuilder.append(", spam=");
        stringBuilder.append(this.ac);
        stringBuilder.append(", url=");
        stringBuilder.append(this.ad);
        stringBuilder.append(", permalink=");
        stringBuilder.append(this.ae);
        stringBuilder.append(", domain=");
        stringBuilder.append(getDomain());
        stringBuilder.append(", subreddit=");
        stringBuilder.append(this.af);
        stringBuilder.append(", subredditId=");
        stringBuilder.append(this.ag);
        stringBuilder.append(", subredditKeyColor=");
        stringBuilder.append(this.ah);
        stringBuilder.append(", subredditIconImage=");
        stringBuilder.append(this.ai);
        stringBuilder.append(", subredditOver18=");
        stringBuilder.append(this.aj);
        stringBuilder.append(", subredditUserIsModerator=");
        stringBuilder.append(this.ak);
        stringBuilder.append(", crossPostParentList=");
        stringBuilder.append(this.al);
        stringBuilder.append(", firstCrossPostParent=");
        stringBuilder.append(this.am);
        stringBuilder.append(", likes=");
        stringBuilder.append(this.an);
        stringBuilder.append(", isSelf=");
        stringBuilder.append(this.ao);
        stringBuilder.append(", postHint=");
        stringBuilder.append(this.ap);
        stringBuilder.append(", isRedditVideo=");
        stringBuilder.append(this.aq);
        stringBuilder.append(", isVideoLinkType=");
        stringBuilder.append(this.ar);
        stringBuilder.append(", isImageLinkType=");
        stringBuilder.append(this.as);
        stringBuilder.append(", preview=");
        stringBuilder.append(this.at);
        stringBuilder.append(", media=");
        stringBuilder.append(this.au);
        stringBuilder.append(", link=");
        stringBuilder.append(this.av);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final int hashCode() {
        LinkType linkType = this.f33975b;
        int i = 0;
        int hashCode = (linkType != null ? linkType.hashCode() : 0) * 31;
        String str = this.f33976c;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        str = this.f33977d;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        long j = this.f33978e;
        hashCode = (hashCode + ((int) (j ^ (j >>> 32)))) * 31;
        str = getName();
        hashCode = (((hashCode + (str != null ? str.hashCode() : 0)) * 31) + getListableType()) * 31;
        str = this.f33979f;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        str = this.f33980g;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        str = this.f33981h;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        j = this.f33982i;
        hashCode = (hashCode + ((int) (j ^ (j >>> 32)))) * 31;
        str = this.f33983j;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        str = this.f33984k;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        str = this.f33985l;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        str = this.f33986m;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        int i2 = this.f33987n;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        str = this.f33988o;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        i2 = this.f33989p;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (((hashCode + i2) * 31) + this.f33990q) * 31;
        Integer num = this.f33991r;
        hashCode = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        i2 = this.f33992s;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        DistinguishType distinguishType = this.f33993t;
        hashCode = (hashCode + (distinguishType != null ? distinguishType.hashCode() : 0)) * 31;
        str = this.f33994u;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        i2 = this.f33995v;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        i2 = this.f33996w;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        str = this.f33997x;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        i2 = this.f33998y;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        str = this.f33999z;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        str = this.f33948A;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        str = this.f33949B;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        i2 = this.f33950C;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        str = this.f33951D;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        str = this.f33952E;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        i2 = this.f33953F;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        ImageLinkPreviewPresentationModel imageLinkPreviewPresentationModel = this.f33954G;
        hashCode = (hashCode + (imageLinkPreviewPresentationModel != null ? imageLinkPreviewPresentationModel.hashCode() : 0)) * 31;
        Mp4LinkPreviewPresentationModel mp4LinkPreviewPresentationModel = this.f33955H;
        hashCode = (hashCode + (mp4LinkPreviewPresentationModel != null ? mp4LinkPreviewPresentationModel.hashCode() : 0)) * 31;
        ImageResolutionPresentationModel imageResolutionPresentationModel = this.f33956I;
        hashCode = (hashCode + (imageResolutionPresentationModel != null ? imageResolutionPresentationModel.hashCode() : 0)) * 31;
        str = this.f33957J;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        str = this.f33958K;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        str = this.f33959L;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        i2 = this.f33960M;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        List list = this.f33961N;
        hashCode = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        i2 = this.f33962O;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        OutboundLink outboundLink = this.f33963P;
        hashCode = (hashCode + (outboundLink != null ? outboundLink.hashCode() : 0)) * 31;
        str = this.f33964Q;
        hashCode = (((hashCode + (str != null ? str.hashCode() : 0)) * 31) + getScore()) * 31;
        i2 = this.f33965R;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        long j2 = this.f33966S;
        hashCode = (hashCode + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        Long l = this.f33967T;
        hashCode = (hashCode + (l != null ? l.hashCode() : 0)) * 31;
        i2 = this.f33968U;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (((hashCode + i2) * 31) + this.f33969V) * 31;
        list = this.f33970W;
        hashCode = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        list = this.f33971X;
        hashCode = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        i2 = this.f33972Y;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        i2 = this.f33973Z;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        i2 = this.aa;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        i2 = this.ab;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        i2 = this.ac;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        str = this.ad;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        str = this.ae;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        str = getDomain();
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        str = this.af;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        str = this.ag;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        str = this.ah;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        str = this.ai;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        i2 = this.aj;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        i2 = this.ak;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        list = this.al;
        hashCode = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        LinkPresentationModel linkPresentationModel = this.am;
        hashCode = (hashCode + (linkPresentationModel != null ? linkPresentationModel.hashCode() : 0)) * 31;
        Boolean bool = this.an;
        hashCode = (hashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        i2 = this.ao;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        str = this.ap;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        i2 = this.aq;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        i2 = this.ar;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        i2 = this.as;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        Preview preview = this.at;
        hashCode = (hashCode + (preview != null ? preview.hashCode() : 0)) * 31;
        LinkMedia linkMedia = this.au;
        hashCode = (hashCode + (linkMedia != null ? linkMedia.hashCode() : 0)) * 31;
        Link link = this.av;
        if (link != null) {
            i = link.hashCode();
        }
        return hashCode + i;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof LinkPresentationModel) {
                LinkPresentationModel linkPresentationModel = (LinkPresentationModel) obj;
                if (Intrinsics.m26845a(this.f33975b, linkPresentationModel.f33975b) && Intrinsics.m26845a(this.f33976c, linkPresentationModel.f33976c) && Intrinsics.m26845a(this.f33977d, linkPresentationModel.f33977d)) {
                    if ((this.f33978e == linkPresentationModel.f33978e) && Intrinsics.m26845a(getName(), linkPresentationModel.getName())) {
                        if ((getListableType() == linkPresentationModel.getListableType()) && Intrinsics.m26845a(this.f33979f, linkPresentationModel.f33979f) && Intrinsics.m26845a(this.f33980g, linkPresentationModel.f33980g) && Intrinsics.m26845a(this.f33981h, linkPresentationModel.f33981h)) {
                            if ((this.f33982i == linkPresentationModel.f33982i) && Intrinsics.m26845a(this.f33983j, linkPresentationModel.f33983j) && Intrinsics.m26845a(this.f33984k, linkPresentationModel.f33984k) && Intrinsics.m26845a(this.f33985l, linkPresentationModel.f33985l) && Intrinsics.m26845a(this.f33986m, linkPresentationModel.f33986m)) {
                                if ((this.f33987n == linkPresentationModel.f33987n) && Intrinsics.m26845a(this.f33988o, linkPresentationModel.f33988o)) {
                                    if (this.f33989p == linkPresentationModel.f33989p) {
                                        if ((this.f33990q == linkPresentationModel.f33990q) && Intrinsics.m26845a(this.f33991r, linkPresentationModel.f33991r)) {
                                            if ((this.f33992s == linkPresentationModel.f33992s) && Intrinsics.m26845a(this.f33993t, linkPresentationModel.f33993t) && Intrinsics.m26845a(this.f33994u, linkPresentationModel.f33994u)) {
                                                if (this.f33995v == linkPresentationModel.f33995v) {
                                                    if ((this.f33996w == linkPresentationModel.f33996w) && Intrinsics.m26845a(this.f33997x, linkPresentationModel.f33997x)) {
                                                        if ((this.f33998y == linkPresentationModel.f33998y) && Intrinsics.m26845a(this.f33999z, linkPresentationModel.f33999z) && Intrinsics.m26845a(this.f33948A, linkPresentationModel.f33948A) && Intrinsics.m26845a(this.f33949B, linkPresentationModel.f33949B)) {
                                                            if ((this.f33950C == linkPresentationModel.f33950C) && Intrinsics.m26845a(this.f33951D, linkPresentationModel.f33951D) && Intrinsics.m26845a(this.f33952E, linkPresentationModel.f33952E)) {
                                                                if ((this.f33953F == linkPresentationModel.f33953F) && Intrinsics.m26845a(this.f33954G, linkPresentationModel.f33954G) && Intrinsics.m26845a(this.f33955H, linkPresentationModel.f33955H) && Intrinsics.m26845a(this.f33956I, linkPresentationModel.f33956I) && Intrinsics.m26845a(this.f33957J, linkPresentationModel.f33957J) && Intrinsics.m26845a(this.f33958K, linkPresentationModel.f33958K) && Intrinsics.m26845a(this.f33959L, linkPresentationModel.f33959L)) {
                                                                    if ((this.f33960M == linkPresentationModel.f33960M) && Intrinsics.m26845a(this.f33961N, linkPresentationModel.f33961N)) {
                                                                        if ((this.f33962O == linkPresentationModel.f33962O) && Intrinsics.m26845a(this.f33963P, linkPresentationModel.f33963P) && Intrinsics.m26845a(this.f33964Q, linkPresentationModel.f33964Q)) {
                                                                            if (getScore() == linkPresentationModel.getScore()) {
                                                                                if (this.f33965R == linkPresentationModel.f33965R) {
                                                                                    if ((this.f33966S == linkPresentationModel.f33966S) && Intrinsics.m26845a(this.f33967T, linkPresentationModel.f33967T)) {
                                                                                        if (this.f33968U == linkPresentationModel.f33968U) {
                                                                                            if ((this.f33969V == linkPresentationModel.f33969V) && Intrinsics.m26845a(this.f33970W, linkPresentationModel.f33970W) && Intrinsics.m26845a(this.f33971X, linkPresentationModel.f33971X)) {
                                                                                                if (this.f33972Y == linkPresentationModel.f33972Y) {
                                                                                                    if (this.f33973Z == linkPresentationModel.f33973Z) {
                                                                                                        if (this.aa == linkPresentationModel.aa) {
                                                                                                            if (this.ab == linkPresentationModel.ab) {
                                                                                                                if ((this.ac == linkPresentationModel.ac) && Intrinsics.m26845a(this.ad, linkPresentationModel.ad) && Intrinsics.m26845a(this.ae, linkPresentationModel.ae) && Intrinsics.m26845a(getDomain(), linkPresentationModel.getDomain()) && Intrinsics.m26845a(this.af, linkPresentationModel.af) && Intrinsics.m26845a(this.ag, linkPresentationModel.ag) && Intrinsics.m26845a(this.ah, linkPresentationModel.ah) && Intrinsics.m26845a(this.ai, linkPresentationModel.ai)) {
                                                                                                                    if (this.aj == linkPresentationModel.aj) {
                                                                                                                        if ((this.ak == linkPresentationModel.ak) && Intrinsics.m26845a(this.al, linkPresentationModel.al) && Intrinsics.m26845a(this.am, linkPresentationModel.am) && Intrinsics.m26845a(this.an, linkPresentationModel.an)) {
                                                                                                                            if ((this.ao == linkPresentationModel.ao) && Intrinsics.m26845a(this.ap, linkPresentationModel.ap)) {
                                                                                                                                if (this.aq == linkPresentationModel.aq) {
                                                                                                                                    if (this.ar == linkPresentationModel.ar) {
                                                                                                                                        if ((this.as == linkPresentationModel.as) && Intrinsics.m26845a(this.at, linkPresentationModel.at) && Intrinsics.m26845a(this.au, linkPresentationModel.au) && Intrinsics.m26845a(this.av, linkPresentationModel.av) != null) {
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
                    }
                }
            }
            return false;
        }
        return true;
    }
}
