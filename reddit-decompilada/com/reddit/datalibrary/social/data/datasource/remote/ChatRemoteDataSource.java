package com.reddit.datalibrary.social.data.datasource.remote;

import android.util.LruCache;
import com.google.gson.JsonElement;
import com.reddit.datalibrary.social.data.session.ChatConnectionManager;
import com.reddit.datalibrary.social.model.ChannelMuteStatus;
import com.reddit.datalibrary.social.model.ChatEnabled;
import com.reddit.datalibrary.social.model.Contact;
import com.reddit.datalibrary.social.model.CreateChannelRequestBody;
import com.reddit.datalibrary.social.model.InviteToChannelRequestBody;
import com.reddit.datalibrary.social.model.User;
import com.reddit.datalibrary.social.model.UserBriefData;
import com.reddit.datalibrary.social.network.BaseplateClient;
import com.reddit.datalibrary.social.network.RedditAPIClient;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.util.kotlin.ObservablesKt;
import com.reddit.social.analytics.ChatPerformanceAnalyticsContract;
import com.reddit.social.domain.functions.CreateChannelResponseTransformer;
import com.reddit.social.domain.functions.RawMessagesBatch;
import com.reddit.social.presentation.presentationobjects.SentStatus;
import com.sendbird.android.BaseChannel;
import com.sendbird.android.BaseMessage;
import com.sendbird.android.FileMessage;
import com.sendbird.android.FileMessage.ThumbnailSize;
import com.sendbird.android.GroupChannel;
import com.sendbird.android.GroupChannel.MemberState;
import com.sendbird.android.GroupChannelListQuery;
import com.sendbird.android.GroupChannelListQuery.GroupChannelListQueryResultHandler;
import com.sendbird.android.Member;
import com.sendbird.android.PreviousMessageListQuery;
import com.sendbird.android.SendBird;
import com.sendbird.android.SendBird.ChannelHandler;
import com.sendbird.android.SendBirdException;
import com.sendbird.android.UserMessage;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.functions.Function;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u00106\u001a\b\u0012\u0004\u0012\u000208072\u0006\u00109\u001a\u00020\u000bH\u0003J\u0016\u00106\u001a\b\u0012\u0004\u0012\u000208072\u0006\u0010:\u001a\u00020\u0006H\u0017J$\u0010;\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0!072\u0006\u0010<\u001a\u00020\u00062\u0006\u0010=\u001a\u000208H\u0003J$\u0010>\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0!072\u0006\u0010<\u001a\u00020\u00062\u0006\u0010=\u001a\u000208H\u0017J\u001c\u0010?\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0!072\u0006\u0010<\u001a\u00020\u0006H\u0017J\u0016\u0010@\u001a\b\u0012\u0004\u0012\u000208072\u0006\u0010:\u001a\u00020\u0006H\u0017J\u0016\u0010A\u001a\b\u0012\u0004\u0012\u000208072\u0006\u0010<\u001a\u00020\u0006H\u0017J3\u0010B\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0!072\u0006\u0010<\u001a\u00020\u00062\b\u0010C\u001a\u0004\u0018\u00010\u00042\u0006\u0010=\u001a\u000208H\u0017¢\u0006\u0002\u0010DJ&\u0010E\u001a\b\u0012\u0004\u0012\u00020\u0006072\f\u0010F\u001a\b\u0012\u0004\u0012\u00020G0!2\b\u0010H\u001a\u0004\u0018\u00010\u0006H\u0017J.\u0010I\u001a\b\u0012\u0004\u0012\u0002HJ07\"\u0004\b\u0000\u0010J2\u0018\u0010K\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002HJ0M\u0012\u0004\u0012\u00020N0LH\u0003J.\u0010O\u001a\b\u0012\u0004\u0012\u0002HJ07\"\u0004\b\u0000\u0010J2\u0018\u0010K\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002HJ0M\u0012\u0004\u0012\u00020N0LH\u0003J\u0016\u0010P\u001a\b\u0012\u0004\u0012\u000208072\u0006\u00109\u001a\u00020\u000bH\u0003J\u0016\u0010P\u001a\b\u0012\u0004\u0012\u000208072\u0006\u0010:\u001a\u00020\u0006H\u0017J\u001e\u0010Q\u001a\b\u0012\u0004\u0012\u00020R072\u0006\u00109\u001a\u00020\u000b2\u0006\u0010S\u001a\u00020RH\u0003J\u001e\u0010Q\u001a\b\u0012\u0004\u0012\u00020R072\u0006\u0010:\u001a\u00020\u00062\u0006\u0010S\u001a\u00020RH\u0017J&\u0010T\u001a\u000208\"\u0004\b\u0000\u0010J2\f\u0010U\u001a\b\u0012\u0004\u0012\u0002HJ0M2\b\u0010V\u001a\u0004\u0018\u00010WH\u0003J\u0010\u0010X\u001a\u00020N2\u0006\u0010:\u001a\u00020\u0006H\u0017J\u0012\u0010Y\u001a\u0004\u0018\u00010&2\u0006\u0010S\u001a\u00020RH\u0002J\u0016\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u000b072\u0006\u0010:\u001a\u00020\u0006H\u0017J\u0016\u0010[\u001a\b\u0012\u0004\u0012\u00020\u000b072\u0006\u0010:\u001a\u00020\u0006H\u0003JB\u0010\\\u001a\u00020N2\u0012\u0010U\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0!0M2\u0006\u0010]\u001a\u00020\r2\f\u0010^\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010_\u001a\u0002082\u0006\u0010`\u001a\u00020aH\u0003J$\u0010b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020c0!072\u0006\u0010:\u001a\u00020\u00062\u0006\u0010=\u001a\u000208H\u0017J\u001a\u0010d\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\n2\b\u0010:\u001a\u0004\u0018\u00010\u0006H\u0003J2\u0010e\u001a\u00020N2\u0012\u0010U\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0!0M2\u0006\u0010]\u001a\u00020\r2\f\u0010^\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0003J\u001e\u0010f\u001a\b\u0012\u0004\u0012\u00020g072\u0006\u0010:\u001a\u00020\u00062\u0006\u0010=\u001a\u000208H\u0017J5\u0010h\u001a\u00020N\"\u0004\b\u0000\u0010J2\f\u0010U\u001a\b\u0012\u0004\u0012\u0002HJ0M2\b\u0010V\u001a\u0004\u0018\u00010W2\b\u0010i\u001a\u0004\u0018\u0001HJH\u0003¢\u0006\u0002\u0010jJ\b\u0010k\u001a\u000208H\u0017J\b\u0010l\u001a\u000208H\u0017J\b\u0010m\u001a\u000208H\u0017J\u0016\u0010n\u001a\b\u0012\u0004\u0012\u000208072\u0006\u0010:\u001a\u00020\u0006H\u0017J\b\u0010o\u001a\u00020NH\u0002J$\u0010p\u001a\b\u0012\u0004\u0012\u00020q072\u0006\u0010:\u001a\u00020\u00062\f\u0010F\u001a\b\u0012\u0004\u0012\u00020G0!H\u0017J\u0016\u0010r\u001a\b\u0012\u0004\u0012\u00020s072\u0006\u0010:\u001a\u00020\u0006H\u0017J\u000e\u0010t\u001a\b\u0012\u0004\u0012\u00020u07H\u0017J\b\u0010v\u001a\u000208H\u0017J\u0016\u0010w\u001a\b\u0012\u0004\u0012\u000208072\u0006\u0010:\u001a\u00020\u0006H\u0017J\u0016\u0010x\u001a\b\u0012\u0004\u0012\u000208072\u0006\u00109\u001a\u00020\u000bH\u0003J\u001e\u0010y\u001a\b\u0012\u0004\u0012\u00020g072\u0006\u00109\u001a\u00020\u000b2\u0006\u0010=\u001a\u000208H\u0003J\u0016\u0010z\u001a\b\u0012\u0004\u0012\u00020g072\u0006\u0010:\u001a\u00020\u0006H\u0017J\u0016\u0010{\u001a\b\u0012\u0004\u0012\u00020|072\u0006\u0010:\u001a\u00020\u0006H\u0017J\"\u0010}\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020&0)072\u0006\u0010:\u001a\u00020\u0006H\u0017J\u0016\u0010~\u001a\b\u0012\u0004\u0012\u00020\u000b072\u0006\u0010\u001a\u00020\u000bH\u0003J\u0001\u0010\u0001\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0005\u0012\u00030\u0001\u0012\u0004\u0012\u00020&0)072\u0006\u00109\u001a\u00020\u000b2\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u00062\u0007\u0010\u0001\u001a\u00020\u00062\u0007\u0010\u0001\u001a\u00020\u00042\t\u0010\u0001\u001a\u0004\u0018\u00010\u00062\t\u0010\u0001\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010!2 \u0010\u0001\u001a\u001b\u0012\u0017\u0012\u0015\u0012\u0005\u0012\u00030\u0001\u0012\u0005\u0012\u00030\u00010)j\u0003`\u00010(H\u0003J\u0001\u0010\u0001\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0005\u0012\u00030\u0001\u0012\u0004\u0012\u00020&0)072\u0006\u0010:\u001a\u00020\u00062\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u00062\u0007\u0010\u0001\u001a\u00020\u00062\u0007\u0010\u0001\u001a\u00020\u00042\t\u0010\u0001\u001a\u0004\u0018\u00010\u00062\t\u0010\u0001\u001a\u0004\u0018\u00010\u00062\u0010\u0010\u0001\u001a\u000b\u0012\u0007\b\u0001\u0012\u00030\u00010\n2 \u0010\u0001\u001a\u001b\u0012\u0017\u0012\u0015\u0012\u0005\u0012\u00030\u0001\u0012\u0005\u0012\u00030\u00010)j\u0003`\u00010(H\u0017J?\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u0001072\u0006\u00109\u001a\u00020\u000b2\t\u0010\u0001\u001a\u0004\u0018\u00010\u00062\t\u0010\u0001\u001a\u0004\u0018\u00010\u00062\u000f\u0010\u0001\u001a\n\u0012\u0005\u0012\u00030\u00010\u0001H\u0003J?\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u0001072\u0006\u0010:\u001a\u00020\u00062\t\u0010\u0001\u001a\u0004\u0018\u00010\u00062\t\u0010\u0001\u001a\u0004\u0018\u00010\u00062\u000f\u0010\u0001\u001a\n\u0012\u0005\u0012\u00030\u00010\u0001H\u0017J\u0011\u0010\u0001\u001a\u00020N2\u0006\u0010<\u001a\u00020\u0006H\u0016J \u0010\u0001\u001a\b\u0012\u0004\u0012\u000208072\u0006\u00109\u001a\u00020\u000b2\u0007\u0010\u0001\u001a\u00020\u0006H\u0003J \u0010\u0001\u001a\b\u0012\u0004\u0012\u000208072\u0006\u0010:\u001a\u00020\u00062\u0007\u0010\u0001\u001a\u00020\u0006H\u0017J\u000f\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020|07H\u0017J \u0010\u0001\u001a\b\u0012\u0004\u0012\u000208072\u0006\u0010:\u001a\u00020\u00062\u0007\u0010\u0001\u001a\u000208H\u0017J \u0010\u0001\u001a\b\u0012\u0004\u0012\u000208072\u0006\u0010\u001a\u00020\u000b2\u0007\u0010\u0001\u001a\u000208H\u0003J\u0011\u0010\u0001\u001a\u00020N2\u0006\u0010:\u001a\u00020\u0006H\u0017J\u000f\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u000407H\u0017J\u001d\u0010\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020c0!072\u0006\u0010:\u001a\u00020\u0006H\u0017J%\u0010\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0!072\u0006\u0010<\u001a\u00020\u00062\u0006\u0010=\u001a\u000208H\u0003J%\u0010\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0!072\u0006\u0010<\u001a\u00020\u00062\u0006\u0010=\u001a\u000208H\u0017J\u0017\u0010\u0001\u001a\b\u0012\u0004\u0012\u000208072\u0006\u0010<\u001a\u00020\u0006H\u0017J\u0017\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020|072\u0006\u0010:\u001a\u00020\u0006H\u0017J\u001d\u0010 \u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0!072\u0006\u0010<\u001a\u00020\u0006H\u0017J-\u0010¡\u0001\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0005\u0012\u00030£\u00010¢\u0001072\u000e\u0010¤\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060¥\u0001H\u0017R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001a\u001a\u00020\u001b8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0016\u0010 \u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R \u0010$\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0\n0%X\u0004¢\u0006\u0002\n\u0000Rb\u0010'\u001aV\u0012$\u0012\"\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020& +*\u0010\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020&\u0018\u00010)0) +**\u0012$\u0012\"\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020& +*\u0010\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020&\u0018\u00010)0)\u0018\u00010(0(X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0004¢\u0006\u0002\n\u0000R2\u00100\u001a&\u0012\f\u0012\n +*\u0004\u0018\u00010\u000b0\u000b +*\u0012\u0012\f\u0012\n +*\u0004\u0018\u00010\u000b0\u000b\u0018\u00010(0(X\u0004¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006¦\u0001"}, d2 = {"Lcom/reddit/datalibrary/social/data/datasource/remote/ChatRemoteDataSource;", "Lcom/reddit/datalibrary/social/data/datasource/remote/ChatRemoteDataSourceContract;", "()V", "CACHE_NUM_CHANNELS_LIMIT", "", "CHANNEL_HANDLER_ID", "", "CHANNEL_LIMIT", "MESSAGE_LIMIT", "acceptedGroupChannelList", "", "Lcom/sendbird/android/GroupChannel;", "acceptedGroupChannelListQuery", "Lcom/sendbird/android/GroupChannelListQuery;", "baseplateClient", "Lcom/reddit/datalibrary/social/network/BaseplateClient;", "getBaseplateClient", "()Lcom/reddit/datalibrary/social/network/BaseplateClient;", "setBaseplateClient", "(Lcom/reddit/datalibrary/social/network/BaseplateClient;)V", "chatConnectionManager", "Lcom/reddit/datalibrary/social/data/session/ChatConnectionManager;", "getChatConnectionManager", "()Lcom/reddit/datalibrary/social/data/session/ChatConnectionManager;", "setChatConnectionManager", "(Lcom/reddit/datalibrary/social/data/session/ChatConnectionManager;)V", "chatPerfAnalytics", "Lcom/reddit/social/analytics/ChatPerformanceAnalyticsContract;", "getChatPerfAnalytics", "()Lcom/reddit/social/analytics/ChatPerformanceAnalyticsContract;", "setChatPerfAnalytics", "(Lcom/reddit/social/analytics/ChatPerformanceAnalyticsContract;)V", "contactList", "", "Lcom/reddit/datalibrary/social/model/Contact;", "currentGroupChannelUrl", "messageCache", "Landroid/util/LruCache;", "Lcom/sendbird/android/BaseMessage;", "newMessageSubject", "Lio/reactivex/subjects/PublishSubject;", "Lkotlin/Pair;", "Lcom/sendbird/android/BaseChannel;", "kotlin.jvm.PlatformType", "prevMessageListQuery", "Lcom/sendbird/android/PreviousMessageListQuery;", "redditAPIClient", "Lcom/reddit/datalibrary/social/network/RedditAPIClient;", "typingStatusSubject", "unacceptedGroupChannelList", "unacceptedGroupChannelListQuery", "userIdForAcceptedChannels", "userIdForContacts", "userIdForUnacceptedChannels", "acceptInvite", "Lio/reactivex/Observable;", "", "groupChannel", "channelUrl", "acceptedGroupChannelListObservable", "userId", "refresh", "acceptedGroupChannels", "acceptedGroupChannelsWithMore", "areNotificationsEnabledSendbird", "blockUser", "contacts", "limit", "(Ljava/lang/String;Ljava/lang/Integer;Z)Lio/reactivex/Observable;", "createChannel", "users", "Lcom/reddit/datalibrary/social/model/User;", "channelName", "createObservableIgnoreConnection", "T", "func", "Lkotlin/Function1;", "Lio/reactivex/ObservableEmitter;", "", "createObservableWithConnection", "declineInvite", "deleteMessage", "", "messageId", "emitError", "emitter", "e", "Lcom/sendbird/android/SendBirdException;", "endTyping", "findMessage", "getGroupChannel", "getGroupChannelIgnoreConnection", "getGroupChannels", "groupChannelListQuery", "channels", "clearCachedValues", "memberState", "Lcom/sendbird/android/GroupChannel$MemberState;", "getMembers", "Lcom/sendbird/android/Member;", "getMessagesForChannelUrl", "getMoreGroupChannels", "groupMessages", "Lcom/reddit/social/domain/functions/RawMessagesBatch;", "handleResponse", "value", "(Lio/reactivex/ObservableEmitter;Lcom/sendbird/android/SendBirdException;Ljava/lang/Object;)V", "hasMoreAcceptedChannels", "hasMoreMessages", "hasMoreUnacceptedChannels", "hideChannel", "initChannelHandlers", "inviteToChannel", "Lcom/google/gson/JsonElement;", "isChannelMuted", "Lcom/reddit/datalibrary/social/model/ChannelMuteStatus;", "isChatEnabled", "Lcom/reddit/datalibrary/social/model/ChatEnabled;", "isLoadingUnacceptedChannels", "leaveChannel", "leaveChannelObservable", "messagesObservable", "moreGroupMessages", "muteChannel", "", "newMessageObservable", "refreshGroupChannel", "channel", "sendFileMessage", "Lcom/reddit/social/presentation/presentationobjects/SentStatus;", "file", "Ljava/io/File;", "name", "type", "size", "data", "customType", "thumbnailSizes", "Lcom/sendbird/android/FileMessage$ThumbnailSize;", "messagesStatus", "Lcom/sendbird/android/FileMessage;", "Lcom/reddit/social/presentation/groupchat/presentation/FileMessageStatus;", "sendMessage", "Lcom/sendbird/android/UserMessage;", "message", "tempMessage", "Lio/reactivex/subjects/BehaviorSubject;", "sessionChange", "setChannelName", "setChatEnabled", "setNotificationsEnabledSendbird", "enable", "setPushPreference", "startTyping", "totalUnreadMessageCount", "typingStatusObservable", "unacceptedGroupChannelListObservable", "unacceptedGroupChannels", "unblockUser", "unmuteChannel", "unnacceptedGroupChannelsWithMore", "userDataByAccountIds", "", "Lcom/reddit/datalibrary/social/model/UserBriefData;", "usersId", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ChatRemoteDataSource.kt */
public final class ChatRemoteDataSource implements ChatRemoteDataSourceContract {
    @Inject
    public ChatConnectionManager f33461a;
    @Inject
    public BaseplateClient f33462b;
    @Inject
    public ChatPerformanceAnalyticsContract f33463c;
    private final String f33464d = "REMOTE_DATA_SOURCE_CHANNEL_HANDLER";
    private final int f33465e = 30;
    private final int f33466f = 30;
    private final int f33467g = 10;
    private final RedditAPIClient f33468h = new RedditAPIClient();
    private GroupChannelListQuery f33469i;
    private GroupChannelListQuery f33470j;
    private final PublishSubject<GroupChannel> f33471k = PublishSubject.create();
    private final PublishSubject<Pair<BaseChannel, BaseMessage>> f33472l = PublishSubject.create();
    private List<GroupChannel> f33473m = new ArrayList();
    private List<GroupChannel> f33474n = new ArrayList();
    private final LruCache<String, List<BaseMessage>> f33475o = new LruCache(this.f33467g);
    private String f33476p;
    private PreviousMessageListQuery f33477q;
    private List<Contact> f33478r;
    private String f33479s;
    private String f33480t;
    private String f33481u;

    public ChatRemoteDataSource() {
        FrontpageApplication.m28878n().mo5077a(this);
        SendBird.m24969a(this.f33464d, (ChannelHandler) new ChatRemoteDataSource$initChannelHandlers$1(this));
    }

    private final <T> Observable<T> m34289a(Function1<? super ObservableEmitter<T>, Unit> function1) {
        ChatConnectionManager chatConnectionManager = this.f33461a;
        if (chatConnectionManager == null) {
            Intrinsics.m26844a("chatConnectionManager");
        }
        Object flatMap = chatConnectionManager.m21772b().flatMap(new ChatRemoteDataSource$createObservableWithConnection$1(function1));
        Intrinsics.m26843a(flatMap, "chatConnectionManager.co…ervable.create<T>(func) }");
        return flatMap;
    }

    private static <T> Observable<T> m34300b(Function1<? super ObservableEmitter<T>, Unit> function1) {
        Object create = Observable.create(new ChatRemoteDataSourceKt$sam$ObservableOnSubscribe$57128d7d(function1));
        Intrinsics.m26843a(create, "Observable.create<T>(func)");
        return create;
    }

    private static <T> boolean m34304b(ObservableEmitter<T> observableEmitter, SendBirdException sendBirdException) {
        if (sendBirdException == null) {
            return false;
        }
        if (!observableEmitter.mo5627b()) {
            observableEmitter.mo5642a((Throwable) sendBirdException);
        }
        Timber.e(sendBirdException.getMessage(), new Object[0]);
        return true;
    }

    public final Observable<String> mo6388a(List<User> list, String str) {
        Intrinsics.m26847b(list, "users");
        if (list.size() < 2) {
            Object error = Observable.error((Throwable) new IllegalArgumentException("Can't create channel with fewer than two users"));
            Intrinsics.m26843a(error, "Observable.error(Illegal…h fewer than two users\"))");
            return error;
        }
        BaseplateClient baseplateClient = this.f33462b;
        if (baseplateClient == null) {
            Intrinsics.m26844a("baseplateClient");
        }
        error = baseplateClient.m28843a(new CreateChannelRequestBody(str, null, null, null, list, list.size() == 2)).map((Function) new CreateChannelResponseTransformer());
        Intrinsics.m26843a(error, "baseplateClient.createCh…nelResponseTransformer())");
        return error;
    }

    public final Observable<JsonElement> mo6386a(String str, List<User> list) {
        Intrinsics.m26847b(str, "channelUrl");
        Intrinsics.m26847b(list, "users");
        BaseplateClient baseplateClient = this.f33462b;
        if (baseplateClient == null) {
            Intrinsics.m26844a("baseplateClient");
        }
        return baseplateClient.m28845a(str, new InviteToChannelRequestBody(list));
    }

    public final Observable<GroupChannel> mo6381a(String str) {
        Intrinsics.m26847b(str, "channelUrl");
        return m34289a((Function1) new ChatRemoteDataSource$getGroupChannel$1(this, str));
    }

    private final Observable<GroupChannel> m34319s(String str) {
        return m34300b((Function1) new ChatRemoteDataSource$getGroupChannelIgnoreConnection$1(this, str));
    }

    public final Observable<List<GroupChannel>> mo6387a(String str, boolean z) {
        Intrinsics.m26847b(str, "userId");
        if (z) {
            return m34312f(str, z);
        }
        Object just;
        if (!this.f33479s || StringsKt__StringsJVMKt.m41946a(str, (String) this.f33479s, true) == null) {
            just = Observable.just(CollectionsKt__CollectionsKt.m26790a());
        } else {
            just = Observable.just(CollectionsKt___CollectionsKt.m41449n((Iterable) this.f33473m));
        }
        Intrinsics.m26843a(just, "if (userIdForAcceptedCha…just(emptyList())\n      }");
        return just;
    }

    public final Observable<List<GroupChannel>> mo6391b(String str) {
        Intrinsics.m26847b(str, "userId");
        GroupChannelListQuery groupChannelListQuery = this.f33469i;
        if (!StringsKt__StringsJVMKt.m41946a(str, this.f33479s, true)) {
            if (groupChannelListQuery != null) {
                return m34289a((Function1) new ChatRemoteDataSource$acceptedGroupChannelsWithMore$1(this, groupChannelListQuery));
            }
        }
        return m34312f(str, false);
    }

    private final Observable<List<GroupChannel>> m34312f(String str, boolean z) {
        return m34289a((Function1) new ChatRemoteDataSource$acceptedGroupChannelListObservable$1(this, z, str));
    }

    public final boolean mo6390a() {
        GroupChannelListQuery groupChannelListQuery = this.f33469i;
        return groupChannelListQuery != null ? groupChannelListQuery.m24929b() : true;
    }

    public final Observable<List<GroupChannel>> mo6392b(String str, boolean z) {
        Intrinsics.m26847b(str, "userId");
        if (z) {
            return m34314g(str, z);
        }
        Object just;
        if (!this.f33480t || StringsKt__StringsJVMKt.m41946a(str, (String) this.f33480t, true) == null) {
            just = Observable.just(CollectionsKt__CollectionsKt.m26790a());
        } else {
            just = Observable.just(CollectionsKt___CollectionsKt.m41449n((Iterable) this.f33474n));
        }
        Intrinsics.m26843a(just, "if (userIdForUnacceptedC…just(emptyList())\n      }");
        return just;
    }

    private final Observable<List<GroupChannel>> m34314g(String str, boolean z) {
        return m34289a((Function1) new ChatRemoteDataSource$unacceptedGroupChannelListObservable$1(this, z, str));
    }

    public final Observable<List<GroupChannel>> mo6394c(String str) {
        Intrinsics.m26847b(str, "userId");
        GroupChannelListQuery groupChannelListQuery = this.f33470j;
        if (!StringsKt__StringsJVMKt.m41946a(str, this.f33480t, true)) {
            if (groupChannelListQuery != null) {
                return m34289a((Function1) new ChatRemoteDataSource$unnacceptedGroupChannelsWithMore$1(this, groupChannelListQuery));
            }
        }
        return m34314g(str, false);
    }

    public final boolean mo6393b() {
        GroupChannelListQuery groupChannelListQuery = this.f33470j;
        return groupChannelListQuery != null ? groupChannelListQuery.m24929b() : true;
    }

    public final boolean mo6396c() {
        GroupChannelListQuery groupChannelListQuery = this.f33470j;
        return groupChannelListQuery != null ? groupChannelListQuery.m24930c() : false;
    }

    public final Observable<List<Contact>> mo6398d(String str) {
        Intrinsics.m26847b(str, "userId");
        this.f33481u = str;
        str = this.f33462b;
        if (str == null) {
            Intrinsics.m26844a("baseplateClient");
        }
        Object doOnNext = str.m28850d().doOnNext(new ChatRemoteDataSource$contacts$1(this));
        Intrinsics.m26843a(doOnNext, "baseplateClient.contacts…{ this.contactList = it }");
        return doOnNext;
    }

    public final Observable<RawMessagesBatch> mo6395c(String str, boolean z) {
        Intrinsics.m26847b(str, "channelUrl");
        if (z) {
            Object flatMap = mo6381a(str).flatMap(new ChatRemoteDataSource$groupMessages$1(this, z));
            Intrinsics.m26843a(flatMap, "getGroupChannel(channelU…Observable(it, refresh) }");
            return flatMap;
        }
        str = m34320t(str);
        if (str == null) {
            str = CollectionsKt__CollectionsKt.m26790a();
        }
        flatMap = Observable.just(new RawMessagesBatch(str, mo6402e()));
        Intrinsics.m26843a(flatMap, "Observable.just(RawMessa…ages, hasMoreMessages()))");
        return flatMap;
    }

    public final Observable<Integer> mo6397d() {
        return m34289a((Function1) new ChatRemoteDataSource$totalUnreadMessageCount$1(this));
    }

    public final boolean mo6402e() {
        PreviousMessageListQuery previousMessageListQuery = this.f33477q;
        return previousMessageListQuery != null ? previousMessageListQuery.m24944a() : true;
    }

    public final Observable<RawMessagesBatch> mo6400e(String str) {
        Object flatMap;
        Intrinsics.m26847b(str, "channelUrl");
        if (this.f33476p != null) {
            if ((Intrinsics.m26845a(this.f33476p, (Object) str) ^ 1) == 0) {
                flatMap = mo6381a(str).flatMap(new ChatRemoteDataSource$moreGroupMessages$1(this));
                Intrinsics.m26843a(flatMap, "getGroupChannel(channelU…ervable(channel, false) }");
                return flatMap;
            }
        }
        Timber.e("GroupChannel verification error", new Object[0]);
        flatMap = Observable.just(new RawMessagesBatch(CollectionsKt__CollectionsKt.m26790a(), mo6402e()));
        Intrinsics.m26843a(flatMap, "Observable.just(RawMessa…st(), hasMoreMessages()))");
        return flatMap;
    }

    public final Observable<Boolean> mo6384a(String str, String str2) {
        Intrinsics.m26847b(str, "channelUrl");
        Intrinsics.m26847b(str2, "name");
        Object flatMap = mo6381a(str).flatMap(new ChatRemoteDataSource$setChannelName$1(this, str2));
        Intrinsics.m26843a(flatMap, "getGroupChannel(channelU…etChannelName(it, name) }");
        return flatMap;
    }

    public final Observable<Pair<BaseChannel, BaseMessage>> mo6404f(String str) {
        Intrinsics.m26847b(str, "channelUrl");
        Object doOnNext = this.f33472l.filter(new ChatRemoteDataSource$newMessageObservable$1(str)).doOnNext(new ChatRemoteDataSource$newMessageObservable$2(this));
        Intrinsics.m26843a(doOnNext, "newMessageSubject\n      …l.url)?.add(0, message) }");
        return doOnNext;
    }

    public final Observable<List<Member>> mo6406g(String str) {
        Intrinsics.m26847b(str, "channelUrl");
        Object map = this.f33471k.filter(new ChatRemoteDataSource$typingStatusObservable$1(str)).map(ChatRemoteDataSource$typingStatusObservable$2.f27338a);
        Intrinsics.m26843a(map, "typingStatusSubject\n    ….map { it.typingMembers }");
        return map;
    }

    public final Observable<UserMessage> mo6385a(String str, String str2, String str3, BehaviorSubject<UserMessage> behaviorSubject) {
        Intrinsics.m26847b(str, "channelUrl");
        Intrinsics.m26847b(behaviorSubject, "tempMessage");
        Object flatMap = m34319s(str).flatMap(new ChatRemoteDataSource$sendMessage$1(this, str2, str3, behaviorSubject));
        Intrinsics.m26843a(flatMap, "getGroupChannelIgnoreCon…age, data, tempMessage) }");
        return flatMap;
    }

    public final Observable<Pair<SentStatus, BaseMessage>> mo6383a(String str, File file, String str2, String str3, int i, List<? extends ThumbnailSize> list, PublishSubject<Pair<FileMessage, SentStatus>> publishSubject) {
        String str4 = str;
        Intrinsics.m26847b(str4, "channelUrl");
        File file2 = file;
        Intrinsics.m26847b(file2, "file");
        String str5 = str2;
        Intrinsics.m26847b(str5, "name");
        String str6 = str3;
        Intrinsics.m26847b(str6, "type");
        List<? extends ThumbnailSize> list2 = list;
        Intrinsics.m26847b(list2, "thumbnailSizes");
        PublishSubject<Pair<FileMessage, SentStatus>> publishSubject2 = publishSubject;
        Intrinsics.m26847b(publishSubject2, "messagesStatus");
        Object flatMap = m34319s(str4).flatMap(new ChatRemoteDataSource$sendFileMessage$1(this, file2, str5, str6, i, list2, publishSubject2));
        Intrinsics.m26843a(flatMap, "getGroupChannelIgnoreCon…lSizes, messagesStatus) }");
        return flatMap;
    }

    public final Observable<Long> mo6382a(String str, long j) {
        Intrinsics.m26847b(str, "channelUrl");
        Object flatMap = mo6381a(str).flatMap(new ChatRemoteDataSource$deleteMessage$1(this, j));
        Intrinsics.m26843a(flatMap, "getGroupChannel(channelU…eMessage(it, messageId) }");
        return flatMap;
    }

    public final Observable<Boolean> mo6407h(String str) {
        Intrinsics.m26847b(str, "channelUrl");
        Object flatMap = mo6381a(str).flatMap(new ChatRemoteDataSource$acceptInvite$1(this));
        Intrinsics.m26843a(flatMap, "getGroupChannel(channelU…{ this.acceptInvite(it) }");
        return flatMap;
    }

    public final Observable<Boolean> mo6408i(String str) {
        Intrinsics.m26847b(str, "channelUrl");
        Object flatMap = mo6381a(str).flatMap(new ChatRemoteDataSource$declineInvite$1(this));
        Intrinsics.m26843a(flatMap, "getGroupChannel(channelU… this.declineInvite(it) }");
        return flatMap;
    }

    public final Observable<Boolean> mo6409j(String str) {
        Intrinsics.m26847b(str, "channelUrl");
        Object map = mo6381a(str).map(ChatRemoteDataSource$areNotificationsEnabledSendbird$1.f27262a);
        Intrinsics.m26843a(map, "getGroupChannel(channelU….map { it.isPushEnabled }");
        return map;
    }

    public final Observable<Boolean> mo6399d(String str, boolean z) {
        Intrinsics.m26847b(str, "channelUrl");
        Object flatMap = mo6381a(str).flatMap(new ChatRemoteDataSource$setNotificationsEnabledSendbird$1(this, z));
        Intrinsics.m26843a(flatMap, "getGroupChannel(channelU…erence(channel, enable) }");
        return flatMap;
    }

    public final Observable<Boolean> mo6410k(String str) {
        Intrinsics.m26847b(str, "userId");
        return m34289a((Function1) new ChatRemoteDataSource$blockUser$1(this, str));
    }

    public final Observable<Boolean> mo6411l(String str) {
        Intrinsics.m26847b(str, "channelUrl");
        Object flatMap = mo6381a(str).flatMap(new ChatRemoteDataSource$leaveChannel$1(this));
        Intrinsics.m26843a(flatMap, "getGroupChannel(channelU…veChannelObservable(it) }");
        return flatMap;
    }

    public final Observable<Boolean> mo6412m(String str) {
        Intrinsics.m26847b(str, "channelUrl");
        Object flatMap = mo6381a(str).flatMap(ChatRemoteDataSource$hideChannel$1.f27295a);
        Intrinsics.m26843a(flatMap, "getGroupChannel(channelU…  }\n          }\n        }");
        return flatMap;
    }

    public final Observable<List<Member>> mo6401e(String str, boolean z) {
        Intrinsics.m26847b(str, "channelUrl");
        Object map = mo6381a(str).flatMap(new ChatRemoteDataSource$getMembers$1(this, z)).map((Function) ChatRemoteDataSource$getMembers$2.f27287a);
        Intrinsics.m26843a(map, "getGroupChannel(channelU…      .map { it.members }");
        return map;
    }

    private final List<BaseMessage> m34320t(String str) {
        if (str == null) {
            return null;
        }
        List<BaseMessage> list = (List) this.f33475o.get(str);
        if (list == null) {
            list = new ArrayList();
            this.f33475o.put(str, list);
        }
        return list;
    }

    public final Observable<Map<String, UserBriefData>> mo6389a(Set<String> set) {
        Intrinsics.m26847b(set, "usersId");
        return this.f33468h.m28856a((Set) set);
    }

    public final Observable<ChannelMuteStatus> mo6413n(String str) {
        Intrinsics.m26847b(str, "channelUrl");
        BaseplateClient baseplateClient = this.f33462b;
        if (baseplateClient == null) {
            Intrinsics.m26844a("baseplateClient");
        }
        return baseplateClient.m28844a(str);
    }

    public final Observable<Object> mo6414o(String str) {
        Intrinsics.m26847b(str, "channelUrl");
        BaseplateClient baseplateClient = this.f33462b;
        if (baseplateClient == null) {
            Intrinsics.m26844a("baseplateClient");
        }
        Object map = baseplateClient.m28847b(str).map(ChatRemoteDataSource$muteChannel$1.f27303a);
        Intrinsics.m26843a(map, "baseplateClient.muteChan…(channelUrl).map { Unit }");
        return map;
    }

    public final Observable<Object> mo6415p(String str) {
        Intrinsics.m26847b(str, "channelUrl");
        BaseplateClient baseplateClient = this.f33462b;
        if (baseplateClient == null) {
            Intrinsics.m26844a("baseplateClient");
        }
        Object map = baseplateClient.m28849c(str).map(ChatRemoteDataSource$unmuteChannel$1.f27339a);
        Intrinsics.m26843a(map, "baseplateClient.unmuteCh…(channelUrl).map { Unit }");
        return map;
    }

    public final Observable<ChatEnabled> mo6403f() {
        BaseplateClient baseplateClient = this.f33462b;
        if (baseplateClient == null) {
            Intrinsics.m26844a("baseplateClient");
        }
        return baseplateClient.m28851e();
    }

    public final Observable<Object> mo6405g() {
        BaseplateClient baseplateClient = this.f33462b;
        if (baseplateClient == null) {
            Intrinsics.m26844a("baseplateClient");
        }
        Object map = baseplateClient.m28852f().map(ChatRemoteDataSource$setChatEnabled$1.f27329a);
        Intrinsics.m26843a(map, "baseplateClient.setChatEnabled().map { Unit }");
        return map;
    }

    public final void mo6416q(String str) {
        Intrinsics.m26847b(str, "channelUrl");
        Observable map = mo6381a(str).map(ChatRemoteDataSource$startTyping$1.f27334a);
        Intrinsics.m26843a((Object) map, "getGroupChannel(channelU….map { it.startTyping() }");
        ObservablesKt.m24091a(map, (Function1) ChatRemoteDataSource$startTyping$2.f36306a);
    }

    public final void mo6417r(String str) {
        Intrinsics.m26847b(str, "channelUrl");
        Observable map = mo6381a(str).map(ChatRemoteDataSource$endTyping$1.f27274a);
        Intrinsics.m26843a((Object) map, "getGroupChannel(channelU…  .map { it.endTyping() }");
        ObservablesKt.m24091a(map, (Function1) ChatRemoteDataSource$endTyping$2.f36274a);
    }

    public static final /* synthetic */ void m34296a(ObservableEmitter observableEmitter, SendBirdException sendBirdException, Object obj) {
        if (m34304b(observableEmitter, sendBirdException) == null) {
            if (obj == null) {
                m34304b(observableEmitter, new SendBirdException("value should not be null"));
            } else {
                observableEmitter.mo5641a(obj);
                observableEmitter.aA_();
            }
        }
    }

    public static final /* synthetic */ void m34292a(ChatRemoteDataSource chatRemoteDataSource, ObservableEmitter observableEmitter, GroupChannelListQuery groupChannelListQuery, List list) {
        if (groupChannelListQuery.m24929b()) {
            groupChannelListQuery.m24927a((GroupChannelListQueryResultHandler) new ChatRemoteDataSource$getMoreGroupChannels$1(chatRemoteDataSource, observableEmitter, list));
            return;
        }
        observableEmitter.mo5641a((Object) CollectionsKt__CollectionsKt.m26790a());
        observableEmitter.aA_();
    }

    public static final /* synthetic */ void m34293a(ChatRemoteDataSource chatRemoteDataSource, ObservableEmitter observableEmitter, GroupChannelListQuery groupChannelListQuery, List list, boolean z, MemberState memberState) {
        if (groupChannelListQuery.m24929b()) {
            UUID randomUUID = UUID.randomUUID();
            ChatPerformanceAnalyticsContract chatPerformanceAnalyticsContract = chatRemoteDataSource.f33463c;
            if (chatPerformanceAnalyticsContract == null) {
                Intrinsics.m26844a("chatPerfAnalytics");
            }
            Intrinsics.m26843a((Object) randomUUID, "uuid");
            chatPerformanceAnalyticsContract.mo5101a(memberState, randomUUID);
            groupChannelListQuery.m24927a((GroupChannelListQueryResultHandler) new ChatRemoteDataSource$getGroupChannels$1(chatRemoteDataSource, memberState, randomUUID, observableEmitter, z, list));
            return;
        }
        observableEmitter.mo5641a((Object) list);
        observableEmitter.aA_();
    }

    public static final /* synthetic */ Observable m34288a(ChatRemoteDataSource chatRemoteDataSource, GroupChannel groupChannel, boolean z) {
        if (z || !chatRemoteDataSource.f33476p || (Intrinsics.m26845a(chatRemoteDataSource.f33476p, groupChannel.m24870d()) ^ 1)) {
            chatRemoteDataSource.f33477q = false;
            z = chatRemoteDataSource.m34320t(groupChannel.m24870d());
            if (z) {
                z.clear();
            }
        }
        if (!chatRemoteDataSource.f33477q) {
            chatRemoteDataSource.f33477q = groupChannel.m24873g();
        }
        chatRemoteDataSource.f33476p = groupChannel.m24870d();
        return chatRemoteDataSource.m34289a((Function1) new ChatRemoteDataSource$messagesObservable$1(chatRemoteDataSource, groupChannel));
    }

    public static final /* synthetic */ Observable m34284a(ChatRemoteDataSource chatRemoteDataSource, GroupChannel groupChannel, long j) {
        List t = chatRemoteDataSource.m34320t(chatRemoteDataSource.f33476p);
        BaseMessage baseMessage = null;
        if (t != null) {
            Object obj;
            for (Object next : t) {
                Object obj2;
                if (j == ((BaseMessage) next).m24878f()) {
                    obj2 = 1;
                    continue;
                } else {
                    obj2 = null;
                    continue;
                }
                if (obj2 != null) {
                    obj = next;
                    break;
                }
            }
            baseMessage = (BaseMessage) obj;
        }
        BaseMessage baseMessage2 = baseMessage;
        if (baseMessage2 != null) {
            return chatRemoteDataSource.m34289a((Function1) new ChatRemoteDataSource$deleteMessage$2(chatRemoteDataSource, groupChannel, baseMessage2, j));
        }
        Object error = Observable.error((Throwable) new IllegalStateException("Error: Could not find message to delete"));
        Intrinsics.m26843a(error, "Observable.error(Illegal…find message to delete\"))");
        return error;
    }
}
