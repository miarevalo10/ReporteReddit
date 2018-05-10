package com.reddit.datalibrary.frontpage.data.feature.legacy.remote;

import com.reddit.datalibrary.frontpage.data.provider.ListingRequestParams;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.redditauth.redditclient.RedditClient;
import com.reddit.datalibrary.frontpage.requests.models.v1.Account;
import com.reddit.datalibrary.frontpage.requests.models.v1.AccountPrefs;
import com.reddit.datalibrary.frontpage.requests.models.v1.AccountWrapper;
import com.reddit.datalibrary.frontpage.requests.models.v1.CommentEditResponse;
import com.reddit.datalibrary.frontpage.requests.models.v1.CommentListing;
import com.reddit.datalibrary.frontpage.requests.models.v1.CommentReplyResponse;
import com.reddit.datalibrary.frontpage.requests.models.v1.CommentResponse;
import com.reddit.datalibrary.frontpage.requests.models.v1.GenericResponse;
import com.reddit.datalibrary.frontpage.requests.models.v1.LinkEditResponse;
import com.reddit.datalibrary.frontpage.requests.models.v1.LinkListing;
import com.reddit.datalibrary.frontpage.requests.models.v1.MessageListing;
import com.reddit.datalibrary.frontpage.requests.models.v1.MoreCommentResponse;
import com.reddit.datalibrary.frontpage.requests.models.v1.SearchResponse;
import com.reddit.datalibrary.frontpage.requests.models.v1.SubmitImageResponse;
import com.reddit.datalibrary.frontpage.requests.models.v1.SubmitResponse;
import com.reddit.datalibrary.frontpage.requests.models.v1.SubmitVideoResponse;
import com.reddit.datalibrary.frontpage.requests.models.v1.SubredditListing;
import com.reddit.datalibrary.frontpage.requests.models.v1.ThingWrapperListing;
import com.reddit.datalibrary.frontpage.requests.models.v2.BadgeCount;
import com.reddit.datalibrary.frontpage.requests.models.v2.FileUploadLease;
import com.reddit.datalibrary.frontpage.requests.models.v2.FileUploadLease.Field;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.datalibrary.frontpage.requests.models.v2.LinkFlair;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listable;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listing;
import com.reddit.datalibrary.frontpage.requests.models.v2.LiveThread;
import com.reddit.datalibrary.frontpage.requests.models.v2.LiveUpdate;
import com.reddit.datalibrary.frontpage.requests.models.v2.Multireddit;
import com.reddit.datalibrary.frontpage.requests.models.v2.RedditLinkImageInfo;
import com.reddit.datalibrary.frontpage.requests.models.v2.Subreddit;
import com.reddit.datalibrary.frontpage.requests.models.v2.SubredditNameInfo;
import com.reddit.datalibrary.frontpage.service.api.FileUploadResponse;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import net.hockeyapp.android.UpdateFragment;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000Ú\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 Ã\u00012\u00020\u0001:\u0002Ã\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0016J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0004H\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0007H\u0016J\u001e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00072\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0013H\u0016J*\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00042\u0006\u0010\u0016\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0007H\u0016J\u001e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00042\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0007H\u0016J4\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\u00072\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0007H\u0016J4\u0010#\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030$0\u00042\u0006\u0010%\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00072\b\u0010'\u001a\u0004\u0018\u00010\u0007H\u0016J\u001e\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0)0\u00042\b\u0010\"\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010+\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u0007H\u0016J\u001e\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\u00042\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0007H\u0016J\u001e\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\u00042\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0007H\u0016J%\u00100\u001a\u00020\u000e2\b\u00101\u001a\u0004\u0018\u00010!2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u000703H\u0016¢\u0006\u0002\u00104J\u001c\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002060\u00130\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016JD\u00107\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u0002080)0\u00042\u0006\u00109\u001a\u00020:2\u001a\b\u0001\u0010;\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070<0\u00132\b\u0010\"\u001a\u0004\u0018\u00010\u0007H\u0016J\u001e\u0010=\u001a\b\u0012\u0004\u0012\u00020>0\u00042\u0006\u0010?\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u0007H\u0016J\u001e\u0010A\u001a\b\u0012\u0004\u0012\u00020>0\u00042\u0006\u0010?\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u0007H\u0016J\u0010\u0010B\u001a\u00020\u000e2\u0006\u0010C\u001a\u00020\u0007H\u0016J\u0016\u0010D\u001a\u00020\u000e2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00070FH\u0016J,\u0010G\u001a\b\u0012\u0004\u0012\u00020H0\u00042\b\u0010I\u001a\u0004\u0018\u00010\u00072\b\u0010J\u001a\u0004\u0018\u00010\u00072\b\u0010K\u001a\u0004\u0018\u00010\u0007H\u0016J \u0010L\u001a\b\u0012\u0004\u0012\u00020H0\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u00072\u0006\u0010 \u001a\u00020!H\u0016J\u001c\u0010M\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020N0\u00130\u00042\u0006\u0010\n\u001a\u00020\u0007H\u0016JD\u0010O\u001a\b\u0012\u0004\u0012\u00020P0\u00042\u0006\u0010Q\u001a\u00020\u00072\u0006\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020!2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00072\b\u0010U\u001a\u0004\u0018\u00010\u00072\b\u0010\"\u001a\u0004\u0018\u00010\u0007H\u0016J\u0016\u0010V\u001a\b\u0012\u0004\u0012\u00020W0\u00042\u0006\u0010X\u001a\u00020\u0007H\u0016J&\u0010Y\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020Z0)0\u00042\u0006\u0010X\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010[\u001a\u00020\u000e2\u0006\u0010\\\u001a\u00020\u0007H\u0016J\u0016\u0010]\u001a\u00020\u000e2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00070FH\u0016J\u000e\u0010^\u001a\b\u0012\u0004\u0012\u00020_0\u0004H\u0016J\u000e\u0010`\u001a\b\u0012\u0004\u0012\u00020a0\u0004H\u0016J\u0018\u0010b\u001a\b\u0012\u0004\u0012\u00020H0\u00042\b\u0010c\u001a\u0004\u0018\u00010\u0007H\u0016J(\u0010d\u001a\b\u0012\u0004\u0012\u00020H0\u00042\u0006\u0010e\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\u00072\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010f\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u0007H\u0016J\u0010\u0010g\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u0007H\u0016J\u0010\u0010h\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u0007H\u0016J\u0010\u0010i\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u0007H\u0016J\u0010\u0010j\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u0007H\u0016J\u0010\u0010k\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u0007H\u0016J\u0018\u0010l\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010m\u001a\u00020!H\u0016J\u0018\u0010n\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010o\u001a\u00020!H\u0016J\u0010\u0010p\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u0007H\u0016J\u0010\u0010q\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u0007H\u0016J\u0010\u0010r\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u0007H\u0016J\u0010\u0010s\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u0007H\u0016J\u001e\u0010t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0)0\u00042\b\u0010\"\u001a\u0004\u0018\u00010\u0007H\u0016J6\u0010u\u001a\b\u0012\u0004\u0012\u00020v0\u00042\u0006\u0010Q\u001a\u00020\u00072\f\u0010w\u001a\b\u0012\u0004\u0012\u00020\u00070\u00132\u0006\u0010R\u001a\u00020S2\b\u0010\"\u001a\u0004\u0018\u00010\u0007H\u0016J\u001e\u0010x\u001a\b\u0012\u0004\u0012\u00020y0\u00042\u0006\u0010z\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007H\u0016J0\u0010{\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u0002080)0\u00042\u0006\u0010{\u001a\u00020\u00072\u0006\u00109\u001a\u00020:2\b\u0010\"\u001a\u0004\u0018\u00010\u0007H\u0016J \u0010|\u001a\b\u0012\u0004\u0012\u00020}0\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010~\u001a\u00020\u0007H\u0016J\u001e\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020}0\u00130\u00042\b\u0010\"\u001a\u0004\u0018\u00010\u0007H\u0016J\u0019\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010\u00042\u0007\u0010\u0001\u001a\u00020\u0007H\u0016J\u0012\u0010\u0001\u001a\u00020\u000e2\u0007\u0010\u0001\u001a\u00020\u0007H\u0016J#\u0010\u0001\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u0007H\u0016J#\u0010\u0001\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u0007H\u0016J#\u0010\u0001\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u0007H\u0016J\u0011\u0010\u0001\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u0007H\u0016J*\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010\u00042\u0006\u0010\n\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\u00072\u0006\u0010 \u001a\u00020!H\u0016J*\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010\u00042\u0006\u0010\n\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\u00072\u0006\u0010 \u001a\u00020!H\u0016J6\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020y0\u00042\u0006\u0010\u0016\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u00072\t\u0010\u0001\u001a\u0004\u0018\u00010\u0007H\u0016J\u001e\u0010\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u00010\u00130\u00042\u0006\u0010\u0016\u001a\u00020\u0007H\u0016J4\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\u00072\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0007H\u0016J\u0018\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020a0\u00042\u0007\u0010\u0001\u001a\u00020aH\u0016Jo\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020!2\u0007\u0010\u0001\u001a\u00020!2\t\u0010\u0001\u001a\u0004\u0018\u00010\u00072\u0007\u0010 \u0001\u001a\u00020\u00072\u0007\u0010¡\u0001\u001a\u00020\u00072\t\u0010¢\u0001\u001a\u0004\u0018\u00010\u00072\t\u0010£\u0001\u001a\u0004\u0018\u00010\u0007H\u0016Jo\u0010¤\u0001\u001a\t\u0012\u0005\u0012\u00030¥\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020!2\u0007\u0010\u0001\u001a\u00020!2\t\u0010\u0001\u001a\u0004\u0018\u00010\u00072\u0007\u0010 \u0001\u001a\u00020\u00072\u0007\u0010¡\u0001\u001a\u00020\u00072\t\u0010¢\u0001\u001a\u0004\u0018\u00010\u00072\t\u0010£\u0001\u001a\u0004\u0018\u00010\u0007H\u0016Jn\u0010¦\u0001\u001a\t\u0012\u0005\u0012\u00030¥\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020!2\u0007\u0010\u0001\u001a\u00020!2\t\u0010\u0001\u001a\u0004\u0018\u00010\u00072\u0007\u0010 \u0001\u001a\u00020\u00072\u0007\u0010¡\u0001\u001a\u00020\u00072\t\u0010¢\u0001\u001a\u0004\u0018\u00010\u00072\t\u0010£\u0001\u001a\u0004\u0018\u00010\u0007H\u0016JW\u0010§\u0001\u001a\t\u0012\u0005\u0012\u00030¨\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u00072\u0007\u0010©\u0001\u001a\u00020\u00072\u0007\u0010ª\u0001\u001a\u00020\u00072\u0007\u0010«\u0001\u001a\u00020\u00072\u0007\u0010¬\u0001\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020!2\u0007\u0010\u0001\u001a\u00020!H\u0016J'\u0010­\u0001\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u0002080)0\u00042\u0006\u0010\n\u001a\u00020\u00072\u0006\u00109\u001a\u00020:H\u0016JL\u0010\u0006\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u0002080)0\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u00109\u001a\u00020:2\u001a\b\u0001\u0010;\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070<0\u00132\b\u0010\"\u001a\u0004\u0018\u00010\u0007H\u0016JF\u0010®\u0001\u001a\u0011\u0012\r\u0012\u000b\u0012\u0007\b\u0001\u0012\u00030¯\u00010)0\u00042\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\u00072\u001a\b\u0001\u0010;\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070<0\u0013H\u0016JG\u0010°\u0001\u001a\b\u0012\u0004\u0012\u00020y0\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u00072\b\u0010\"\u001a\u0004\u0018\u00010\u0007H\u0016J\u0018\u0010±\u0001\u001a\t\u0012\u0005\u0012\u00030²\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J)\u0010³\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0)0\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u00072\b\u0010\"\u001a\u0004\u0018\u00010\u0007H\u0016J\u0017\u0010´\u0001\u001a\u00020\u000e2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00070FH\u0016J\u0011\u0010µ\u0001\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u0007H\u0016J(\u0010¶\u0001\u001a\u00020\u000e2\t\u0010·\u0001\u001a\u0004\u0018\u0001062\t\u0010¸\u0001\u001a\u0004\u0018\u00010\u00072\u0007\u0010¹\u0001\u001a\u00020\u0007H\u0016J6\u0010º\u0001\u001a\u00030»\u00012\u0007\u0010¼\u0001\u001a\u00020\u00072\b\u0010½\u0001\u001a\u00030¾\u00012\u0007\u0010¿\u0001\u001a\u00020\u00072\u000e\u0010À\u0001\u001a\t\u0012\u0005\u0012\u00030Á\u00010\u0013H\u0016J\u001a\u0010Â\u0001\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u00072\u0007\u0010Â\u0001\u001a\u00020SH\u0016¨\u0006Ä\u0001"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/legacy/remote/RemoteRedditApiDataSource;", "Lcom/reddit/datalibrary/frontpage/data/feature/legacy/remote/RemoteRedditApiDataSourceContract;", "()V", "aboutSubreddit", "Lio/reactivex/Single;", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/SubredditWrapper;", "subreddit", "", "aboutUser", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/AccountWrapper;", "username", "badgeCount", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/BadgeCount;", "block", "Lio/reactivex/Completable;", "accoundId", "bulkMod", "action", "ids", "", "combinedSearch", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/SearchResponse;", "query", "sort", "timeframe", "comment", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/CommentReplyResponse;", "thingId", "text", "comments", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/CommentListing;", "after", "refresh", "", "correlationId", "compose", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/GenericResponse;", "subject", "to", "from_sr", "defaultSubreddits", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listing;", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Subreddit;", "delete", "editComment", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/CommentEditResponse;", "editLink", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/LinkEditResponse;", "favorite", "makeFavorite", "subreddits", "", "(Ljava/lang/Boolean;Ljava/util/Collection;)Lio/reactivex/Completable;", "flair", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/LinkFlair;", "frontpage", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Link;", "requestParams", "Lcom/reddit/datalibrary/frontpage/data/provider/ListingRequestParams;", "additionalParams", "Lkotlin/Pair;", "getFileUploadLease", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/FileUploadLease;", "filepath", "mimetype", "getVideoUploadLease", "giveGold", "thingName", "hide", "fullnames", "Ljava/util/ArrayList;", "inboxMessages", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/MessageListing;", "type", "trendingAfter", "inboxAfter", "inboxNoTrendingNotifications", "karmaList", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/KarmaItem;", "link", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/CommentResponse;", "linkId", "sortId", "", "freshLoad", "commentContext", "liveThread", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/LiveThread;", "id", "liveThreadUpdates", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/LiveUpdate;", "markNotificationRead", "messageId", "markRead", "me", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/Account;", "mePrefs", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/AccountPrefs;", "messageThread", "threadId", "messages", "where", "modApprove", "modDistinguish", "modLockComments", "modMarkNsfw", "modMarkSpoiler", "modPinDistinguish", "modRemove", "isSpam", "modSetStickyStatus", "isSticky", "modUndistinguish", "modUnlockComments", "modUnmarkNsfw", "modUnmarkSpoiler", "moderated", "moreComments", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/MoreCommentResponse;", "children", "multiSearchLinks", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/LinkListing;", "multi", "multireddit", "multiredditCommunities", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Multireddit;", "multiredditName", "multireddits", "redditLink", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/RedditLinkImageInfo;", "path", "registerPushToken", "pushToken", "report", "reason", "otherReason", "reportListing", "siteReason", "reportLogout", "accountType", "token", "save", "savedComments", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/ThingWrapperListing;", "savedLinks", "searchLinks", "linksAfter", "searchSubredditNames", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/SubredditNameInfo;", "searchSubreddits", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/SubredditListing;", "setMePrefs", "accountPrefs", "submitImage", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/SubmitImageResponse;", "title", "url", "resubmit", "sendReplies", "location", "latitude", "longitude", "flairText", "flairId", "submitLink", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/SubmitResponse;", "submitSelf", "submitVideo", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/SubmitVideoResponse;", "fileName", "videoUrl", "posterUrl", "kind", "submitted", "subredditModQueue", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listable;", "subredditSearchLinks", "subredditWiki", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/WikiPage;", "subscribed", "unhide", "unsave", "updatePostFlair", "linkFlair", "editedText", "postFullname", "uploadImage", "Lcom/reddit/datalibrary/frontpage/service/api/FileUploadResponse;", "uploadUri", "input", "Ljava/io/InputStream;", "filename", "awsKeys", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/FileUploadLease$Field;", "vote", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RemoteRedditApiDataSource.kt */
public final class RemoteRedditApiDataSource {
    public static final Companion f10653a = new Companion();

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/legacy/remote/RemoteRedditApiDataSource$Companion;", "", "()V", "INITIAL_LOAD_COMMENT_COUNT", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: RemoteRedditApiDataSource.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public static Single<RedditLinkImageInfo> m8885a(String str) {
        Intrinsics.b(str, "path");
        SessionManager b = SessionManager.m9191b();
        Intrinsics.a(b, "SessionManager.getInstance()");
        str = Single.fromCallable(new RemoteRedditApiDataSource$redditLink$1(RedditClient.m9216a(b.m9203c()), str)).doOnError(RemoteRedditApiDataSource$redditLink$2.f15968a).doOnSuccess(RemoteRedditApiDataSource$redditLink$3.f15969a);
        Intrinsics.a(str, "Single.fromCallable { re…Success: 0 redditLink\") }");
        return str;
    }

    public static Single<Listing<? extends Link>> m8883a(ListingRequestParams listingRequestParams, List<Pair<String, String>> list, String str) {
        Intrinsics.b(listingRequestParams, "requestParams");
        Intrinsics.b(list, "additionalParams");
        listingRequestParams = Single.fromCallable(new RemoteRedditApiDataSource$frontpage$1(RedditClient.m9217a(SessionManager.m9191b()), str, listingRequestParams, list)).doOnError((Consumer) RemoteRedditApiDataSource$frontpage$2.f15900a).doOnSuccess((Consumer) RemoteRedditApiDataSource$frontpage$3.f15901a);
        Intrinsics.a(listingRequestParams, "Single.fromCallable {\n  … Success: 1 frontpage\") }");
        return listingRequestParams;
    }

    public static Single<Listing<? extends Link>> m8889a(String str, ListingRequestParams listingRequestParams, List<Pair<String, String>> list, String str2) {
        Intrinsics.b(str, "subreddit");
        Intrinsics.b(listingRequestParams, "requestParams");
        Intrinsics.b(list, "additionalParams");
        SessionManager b = SessionManager.m9191b();
        Intrinsics.a(b, "SessionManager.getInstance()");
        str = Single.fromCallable(new RemoteRedditApiDataSource$subreddit$1(RedditClient.m9216a(b.m9203c()), str, str2, listingRequestParams, list)).doOnError((Consumer) RemoteRedditApiDataSource$subreddit$2.f16000a).doOnSuccess((Consumer) RemoteRedditApiDataSource$subreddit$3.f16001a);
        Intrinsics.a(str, "Single.fromCallable {\n  … Success: 3 subreddit\") }");
        return str;
    }

    public static Single<Listing<? extends Listable>> m8895a(String str, String str2, List<Pair<String, String>> list) {
        Intrinsics.b(str, "subreddit");
        Intrinsics.b(list, "additionalParams");
        SessionManager b = SessionManager.m9191b();
        Intrinsics.a(b, "SessionManager.getInstance()");
        str = Single.fromCallable(new RemoteRedditApiDataSource$subredditModQueue$1(RedditClient.m9216a(b.m9203c()), str, str2, list)).doOnError((Consumer) RemoteRedditApiDataSource$subredditModQueue$2.f16002a).doOnSuccess((Consumer) RemoteRedditApiDataSource$subredditModQueue$3.f16003a);
        Intrinsics.a(str, "Single.fromCallable {\n  …1 subreddit mod queue\") }");
        return str;
    }

    public static Single<Listing<? extends Link>> m8888a(String str, ListingRequestParams listingRequestParams, String str2) {
        Intrinsics.b(str, "multireddit");
        Intrinsics.b(listingRequestParams, "requestParams");
        SessionManager b = SessionManager.m9191b();
        Intrinsics.a(b, "SessionManager.getInstance()");
        str = Single.fromCallable(new RemoteRedditApiDataSource$multireddit$1(RedditClient.m9216a(b.m9203c()), str, str2, listingRequestParams)).doOnError((Consumer) RemoteRedditApiDataSource$multireddit$2.f15962a).doOnSuccess((Consumer) RemoteRedditApiDataSource$multireddit$3.f15963a);
        Intrinsics.a(str, "Single.fromCallable {\n  …uccess: 4 multireddit\") }");
        return str;
    }

    public static Single<Listing<Subreddit>> m8890a(String str, String str2) {
        str2 = SessionManager.m9191b();
        Intrinsics.a(str2, "SessionManager.getInstance()");
        str = Single.fromCallable(new RemoteRedditApiDataSource$subscribed$1(RedditClient.m9216a(str2.m9203c()), null, str)).doOnError((Consumer) RemoteRedditApiDataSource$subscribed$2.f16006a).doOnSuccess((Consumer) RemoteRedditApiDataSource$subscribed$3.f16007a);
        Intrinsics.a(str, "Single.fromCallable {\n  …Success: 5 subscribed\") }");
        return str;
    }

    public static Single<Listing<Subreddit>> m8903b(String str) {
        str = SessionManager.m9191b();
        Intrinsics.a(str, "SessionManager.getInstance()");
        str = Single.fromCallable(new RemoteRedditApiDataSource$moderated$1(RedditClient.m9216a(str.m9203c()), null)).doOnError(RemoteRedditApiDataSource$moderated$2.f15956a).doOnSuccess(RemoteRedditApiDataSource$moderated$3.f15957a);
        Intrinsics.a(str, "Single.fromCallable { re… Success: 6 moderated\") }");
        return str;
    }

    public static Single<Listing<Subreddit>> m8913c(String str) {
        str = SessionManager.m9191b();
        Intrinsics.a(str, "SessionManager.getInstance()");
        str = Single.fromCallable(new RemoteRedditApiDataSource$defaultSubreddits$1(RedditClient.m9216a(str.m9203c()), null)).doOnError(RemoteRedditApiDataSource$defaultSubreddits$2.f15888a).doOnSuccess(RemoteRedditApiDataSource$defaultSubreddits$3.f15889a);
        Intrinsics.a(str, "Single.fromCallable { re…: 7 defaultSubreddits\") }");
        return str;
    }

    public static Single<List<Multireddit>> m8882a() {
        SessionManager b = SessionManager.m9191b();
        Intrinsics.a(b, "SessionManager.getInstance()");
        Single<List<Multireddit>> doOnSuccess = Single.fromCallable(new RemoteRedditApiDataSource$multireddits$1(RedditClient.m9216a(b.m9203c()))).doOnError(RemoteRedditApiDataSource$multireddits$2.f15966a).doOnSuccess(RemoteRedditApiDataSource$multireddits$3.f15967a);
        Intrinsics.a(doOnSuccess, "Single.fromCallable { re…ccess: 8 multireddits\") }");
        return doOnSuccess;
    }

    public static Single<Multireddit> m8904b(String str, String str2) {
        Intrinsics.b(str2, "multiredditName");
        SessionManager b = SessionManager.m9191b();
        Intrinsics.a(b, "SessionManager.getInstance()");
        str = Single.fromCallable(new RemoteRedditApiDataSource$multiredditCommunities$1(RedditClient.m9216a(b.m9203c()), str, str2)).doOnError((Consumer) RemoteRedditApiDataSource$multiredditCommunities$2.f15964a).doOnSuccess((Consumer) RemoteRedditApiDataSource$multiredditCommunities$3.f15965a);
        Intrinsics.a(str, "Single.fromCallable { re…ultiredditCommunities\") }");
        return str;
    }

    public static Single<Listing<LiveUpdate>> m8914c(String str, String str2) {
        Intrinsics.b(str, "id");
        SessionManager b = SessionManager.m9191b();
        Intrinsics.a(b, "SessionManager.getInstance()");
        str = Single.fromCallable(new RemoteRedditApiDataSource$liveThreadUpdates$1(RedditClient.m9216a(b.m9203c()), str, str2)).doOnError((Consumer) RemoteRedditApiDataSource$liveThreadUpdates$2.f15918a).doOnSuccess((Consumer) RemoteRedditApiDataSource$liveThreadUpdates$3.f15919a);
        Intrinsics.a(str, "Single.fromCallable {\n  … 10 liveThreadUpdates\") }");
        return str;
    }

    public static Single<LiveThread> m8920d(String str) {
        Intrinsics.b(str, "id");
        SessionManager b = SessionManager.m9191b();
        Intrinsics.a(b, "SessionManager.getInstance()");
        str = Single.fromCallable(new RemoteRedditApiDataSource$liveThread$1(RedditClient.m9216a(b.m9203c()), str)).doOnError(RemoteRedditApiDataSource$liveThread$2.f15916a).doOnSuccess(RemoteRedditApiDataSource$liveThread$3.f15917a);
        Intrinsics.a(str, "Single.fromCallable { re…uccess: 11 liveThread\") }");
        return str;
    }

    public static Completable m8879a(Boolean bool, Collection<String> collection) {
        Intrinsics.b(collection, "subreddits");
        SessionManager b = SessionManager.m9191b();
        Intrinsics.a(b, "SessionManager.getInstance()");
        bool = Completable.fromCallable(new RemoteRedditApiDataSource$favorite$1(RedditClient.m9216a(b.m9203c()), bool, collection)).doOnError((Consumer) RemoteRedditApiDataSource$favorite$2.f15896a).doOnComplete((Action) RemoteRedditApiDataSource$favorite$3.f15897a);
        Intrinsics.a(bool, "Completable.fromCallable… Success: 15 favorite\") }");
        return bool;
    }

    public static Single<CommentResponse> m8886a(String str, int i, boolean z, String str2, String str3, String str4) {
        Intrinsics.b(str, "linkId");
        SessionManager b = SessionManager.m9191b();
        Intrinsics.a(b, "SessionManager.getInstance()");
        str = Single.fromCallable(new RemoteRedditApiDataSource$link$1(RedditClient.m9216a(b.m9203c()), str, str4, i, z, str2, str3)).doOnError((Consumer) RemoteRedditApiDataSource$link$2.f15914a).doOnSuccess((Consumer) RemoteRedditApiDataSource$link$3.f15915a);
        Intrinsics.a(str, "Single.fromCallable {\n  …RADS Success: 16 link\") }");
        return str;
    }

    public static Single<MoreCommentResponse> m8898a(String str, List<String> list, int i, String str2) {
        Intrinsics.b(str, "linkId");
        Intrinsics.b(list, "children");
        SessionManager b = SessionManager.m9191b();
        Intrinsics.a(b, "SessionManager.getInstance()");
        str = Single.fromCallable(new RemoteRedditApiDataSource$moreComments$1(RedditClient.m9216a(b.m9203c()), str, list, str2, i)).doOnError((Consumer) RemoteRedditApiDataSource$moreComments$2.f15958a).doOnSuccess((Consumer) RemoteRedditApiDataSource$moreComments$3.f15959a);
        Intrinsics.a(str, "Single.fromCallable {\n  …cess: 17 moreComments\") }");
        return str;
    }

    public static Single<MessageListing> m8896a(String str, String str2, boolean z) {
        Intrinsics.b(str, "where");
        SessionManager b = SessionManager.m9191b();
        Intrinsics.a(b, "SessionManager.getInstance()");
        str = Single.fromCallable(new RemoteRedditApiDataSource$messages$1(RedditClient.m9216a(b.m9203c()), str, str2, z)).doOnError((Consumer) RemoteRedditApiDataSource$messages$2.f15930a).doOnSuccess((Consumer) RemoteRedditApiDataSource$messages$3.f15931a);
        Intrinsics.a(str, "Single\n            .from… Success: 18 messages\") }");
        return str;
    }

    public static Single<MessageListing> m8923e(String str) {
        SessionManager b = SessionManager.m9191b();
        Intrinsics.a(b, "SessionManager.getInstance()");
        str = Single.fromCallable(new RemoteRedditApiDataSource$messageThread$1(RedditClient.m9216a(b.m9203c()), str)).doOnError(RemoteRedditApiDataSource$messageThread$2.f15928a).doOnSuccess(RemoteRedditApiDataSource$messageThread$3.f15929a);
        Intrinsics.a(str, "Single.fromCallable { re…ess: 19 messageThread\") }");
        return str;
    }

    public static Single<MessageListing> m8891a(String str, String str2, String str3) {
        SessionManager b = SessionManager.m9191b();
        Intrinsics.a(b, "SessionManager.getInstance()");
        str = Single.fromCallable(new RemoteRedditApiDataSource$inboxMessages$1(RedditClient.m9216a(b.m9203c()), str, str2, str3)).doOnError((Consumer) RemoteRedditApiDataSource$inboxMessages$2.f15910a).doOnSuccess((Consumer) RemoteRedditApiDataSource$inboxMessages$3.f15911a);
        Intrinsics.a(str, "Single\n            .from…ess: 20 inboxMessages\") }");
        return str;
    }

    public static Single<MessageListing> m8899a(String str, boolean z) {
        SessionManager b = SessionManager.m9191b();
        Intrinsics.a(b, "SessionManager.getInstance()");
        str = Single.fromCallable(new RemoteRedditApiDataSource$inboxNoTrendingNotifications$1(RedditClient.m9216a(b.m9203c()), str, z)).doOnError((Consumer) RemoteRedditApiDataSource$inboxNoTrendingNotifications$2.f15912a).doOnSuccess((Consumer) RemoteRedditApiDataSource$inboxNoTrendingNotifications$3.f15913a);
        Intrinsics.a(str, "Single\n            .from…TrendingNotifications\") }");
        return str;
    }

    public static Completable m8925f(String str) {
        Intrinsics.b(str, "messageId");
        SessionManager b = SessionManager.m9191b();
        Intrinsics.a(b, "SessionManager.getInstance()");
        str = Completable.fromCallable(new RemoteRedditApiDataSource$markNotificationRead$1(RedditClient.m9216a(b.m9203c()), str)).doOnError(RemoteRedditApiDataSource$markNotificationRead$2.f15920a).doOnComplete(RemoteRedditApiDataSource$markNotificationRead$3.f15921a);
        Intrinsics.a(str, "Completable.fromCallable… markNotificationRead\") }");
        return str;
    }

    public static Single<BadgeCount> m8902b() {
        SessionManager b = SessionManager.m9191b();
        Intrinsics.a(b, "SessionManager.getInstance()");
        Single<BadgeCount> doOnSuccess = Single.fromCallable(new RemoteRedditApiDataSource$badgeCount$1(RedditClient.m9216a(b.m9203c()))).doOnError(RemoteRedditApiDataSource$badgeCount$2.f15878a).doOnSuccess(RemoteRedditApiDataSource$badgeCount$3.f15879a);
        Intrinsics.a(doOnSuccess, "Single.fromCallable { re…uccess: 23 badgeCount\") }");
        return doOnSuccess;
    }

    public static Completable m8880a(String str, int i) {
        Intrinsics.b(str, "thingId");
        SessionManager b = SessionManager.m9191b();
        Intrinsics.a(b, "SessionManager.getInstance()");
        str = Completable.fromCallable(new RemoteRedditApiDataSource$vote$1(RedditClient.m9216a(b.m9203c()), str, i)).doOnError((Consumer) RemoteRedditApiDataSource$vote$2.f16014a).doOnComplete((Action) RemoteRedditApiDataSource$vote$3.f16015a);
        Intrinsics.a(str, "Completable.fromCallable…RADS Success: 24 vote\") }");
        return str;
    }

    public static Single<ThingWrapperListing> m8908b(String str, String str2, boolean z) {
        Intrinsics.b(str, "username");
        SessionManager b = SessionManager.m9191b();
        Intrinsics.a(b, "SessionManager.getInstance()");
        str = Single.fromCallable(new RemoteRedditApiDataSource$savedLinks$1(RedditClient.m9216a(b.m9203c()), str, str2, z)).doOnError((Consumer) RemoteRedditApiDataSource$savedLinks$2.f15980a).doOnSuccess((Consumer) RemoteRedditApiDataSource$savedLinks$3.f15981a);
        Intrinsics.a(str, "Single.fromCallable {\n  …uccess: 26 savedLinks\") }");
        return str;
    }

    public static Single<ThingWrapperListing> m8917c(String str, String str2, boolean z) {
        Intrinsics.b(str, "username");
        SessionManager b = SessionManager.m9191b();
        Intrinsics.a(b, "SessionManager.getInstance()");
        str = Single.fromCallable(new RemoteRedditApiDataSource$savedComments$1(RedditClient.m9216a(b.m9203c()), str, str2, z)).doOnError((Consumer) RemoteRedditApiDataSource$savedComments$2.f15978a).doOnSuccess((Consumer) RemoteRedditApiDataSource$savedComments$3.f15979a);
        Intrinsics.a(str, "Single.fromCallable {\n  …ess: 27 savedComments\") }");
        return str;
    }

    public static Single<Listing<? extends Link>> m8887a(String str, ListingRequestParams listingRequestParams) {
        Intrinsics.b(str, "username");
        Intrinsics.b(listingRequestParams, "requestParams");
        SessionManager b = SessionManager.m9191b();
        Intrinsics.a(b, "SessionManager.getInstance()");
        str = Single.fromCallable(new RemoteRedditApiDataSource$submitted$1(RedditClient.m9216a(b.m9203c()), str, listingRequestParams)).doOnError((Consumer) RemoteRedditApiDataSource$submitted$2.f15998a).doOnSuccess((Consumer) RemoteRedditApiDataSource$submitted$3.f15999a);
        Intrinsics.a(str, "Single.fromCallable {\n  …Success: 28 submitted\") }");
        return str;
    }

    public static Completable m8927g(String str) {
        Intrinsics.b(str, "thingId");
        SessionManager b = SessionManager.m9191b();
        Intrinsics.a(b, "SessionManager.getInstance()");
        str = Completable.fromCallable(new RemoteRedditApiDataSource$save$1(RedditClient.m9216a(b.m9203c()), str)).doOnError(RemoteRedditApiDataSource$save$2.f15976a).doOnComplete(RemoteRedditApiDataSource$save$3.f15977a);
        Intrinsics.a(str, "Completable.fromCallable…RADS Success: 31 save\") }");
        return str;
    }

    public static Completable m8929h(String str) {
        Intrinsics.b(str, "thingId");
        SessionManager b = SessionManager.m9191b();
        Intrinsics.a(b, "SessionManager.getInstance()");
        str = Completable.fromCallable(new RemoteRedditApiDataSource$unsave$1(RedditClient.m9216a(b.m9203c()), str)).doOnError(RemoteRedditApiDataSource$unsave$2.f16010a).doOnComplete(RemoteRedditApiDataSource$unsave$3.f16011a);
        Intrinsics.a(str, "Completable.fromCallable…DS Success: 32 unsave\") }");
        return str;
    }

    public static Single<Account> m8912c() {
        SessionManager b = SessionManager.m9191b();
        Intrinsics.a(b, "SessionManager.getInstance()");
        Single<Account> doOnSuccess = Single.fromCallable(new RemoteRedditApiDataSource$me$1(RedditClient.m9216a(b.m9203c()))).doOnError(RemoteRedditApiDataSource$me$2.f15924a).doOnSuccess(RemoteRedditApiDataSource$me$3.f15925a);
        Intrinsics.a(doOnSuccess, "Single.fromCallable { re…\"RRADS Success: 33 me\") }");
        return doOnSuccess;
    }

    public static Single<AccountPrefs> m8919d() {
        SessionManager b = SessionManager.m9191b();
        Intrinsics.a(b, "SessionManager.getInstance()");
        Single<AccountPrefs> doOnSuccess = Single.fromCallable(new RemoteRedditApiDataSource$mePrefs$1(RedditClient.m9216a(b.m9203c()))).doOnError(RemoteRedditApiDataSource$mePrefs$2.f15926a).doOnSuccess(RemoteRedditApiDataSource$mePrefs$3.f15927a);
        Intrinsics.a(doOnSuccess, "Single.fromCallable { re…S Success: 34 mePrefs\") }");
        return doOnSuccess;
    }

    public static Single<AccountPrefs> m8884a(AccountPrefs accountPrefs) {
        Intrinsics.b(accountPrefs, "accountPrefs");
        SessionManager b = SessionManager.m9191b();
        Intrinsics.a(b, "SessionManager.getInstance()");
        accountPrefs = Single.fromCallable(new RemoteRedditApiDataSource$setMePrefs$1(RedditClient.m9216a(b.m9203c()), accountPrefs)).doOnError(RemoteRedditApiDataSource$setMePrefs$2.f15988a).doOnSuccess(RemoteRedditApiDataSource$setMePrefs$3.f15989a);
        Intrinsics.a(accountPrefs, "Single.fromCallable { re…uccess: 35 setMePrefs\") }");
        return accountPrefs;
    }

    public static Single<AccountWrapper> m8931i(String str) {
        SessionManager b = SessionManager.m9191b();
        Intrinsics.a(b, "SessionManager.getInstance()");
        str = Single.fromCallable(new RemoteRedditApiDataSource$aboutUser$1(RedditClient.m9216a(b.m9203c()), str)).doOnError(RemoteRedditApiDataSource$aboutUser$2.f15876a).doOnSuccess(RemoteRedditApiDataSource$aboutUser$3.f15877a);
        Intrinsics.a(str, "Single.fromCallable { re…Success: 38 aboutUser\") }");
        return str;
    }

    public static Single<CommentListing> m8897a(String str, String str2, boolean z, String str3) {
        SessionManager b = SessionManager.m9191b();
        Intrinsics.a(b, "SessionManager.getInstance()");
        str = Single.fromCallable(new RemoteRedditApiDataSource$comments$1(RedditClient.m9216a(b.m9203c()), str, str3, str2, z)).doOnError((Consumer) RemoteRedditApiDataSource$comments$2.f15884a).doOnSuccess((Consumer) RemoteRedditApiDataSource$comments$3.f15885a);
        Intrinsics.a(str, "Single.fromCallable {\n  … Success: 39 comments\") }");
        return str;
    }

    public static Single<SearchResponse> m8905b(String str, String str2, String str3) {
        Intrinsics.b(str, "query");
        SessionManager b = SessionManager.m9191b();
        Intrinsics.a(b, "SessionManager.getInstance()");
        str = Single.fromCallable(new RemoteRedditApiDataSource$combinedSearch$1(RedditClient.m9216a(b.m9203c()), str, str2, str3)).doOnError((Consumer) RemoteRedditApiDataSource$combinedSearch$2.f15880a).doOnSuccess((Consumer) RemoteRedditApiDataSource$combinedSearch$3.f15881a);
        Intrinsics.a(str, "Single.fromCallable {\n  …ss: 40 combinedSearch\") }");
        return str;
    }

    public static Single<SubredditListing> m8909b(String str, String str2, boolean z, String str3) {
        Intrinsics.b(str, "query");
        SessionManager b = SessionManager.m9191b();
        Intrinsics.a(b, "SessionManager.getInstance()");
        str = Single.fromCallable(new RemoteRedditApiDataSource$searchSubreddits$1(RedditClient.m9216a(b.m9203c()), str, str3, str2, z)).doOnError((Consumer) RemoteRedditApiDataSource$searchSubreddits$2.f15986a).doOnSuccess((Consumer) RemoteRedditApiDataSource$searchSubreddits$3.f15987a);
        Intrinsics.a(str, "Single.fromCallable {\n  …: 41 searchSubreddits\") }");
        return str;
    }

    public static Single<List<SubredditNameInfo>> m8933j(String str) {
        Intrinsics.b(str, "query");
        SessionManager b = SessionManager.m9191b();
        Intrinsics.a(b, "SessionManager.getInstance()");
        str = Single.fromCallable(new RemoteRedditApiDataSource$searchSubredditNames$1(RedditClient.m9216a(b.m9203c()), str)).doOnError(RemoteRedditApiDataSource$searchSubredditNames$2.f15984a).doOnSuccess(RemoteRedditApiDataSource$searchSubredditNames$3.f15985a);
        Intrinsics.a(str, "Single.fromCallable { re… searchSubredditNames\") }");
        return str;
    }

    public static Single<LinkListing> m8892a(String str, String str2, String str3, String str4) {
        Intrinsics.b(str, "query");
        SessionManager b = SessionManager.m9191b();
        Intrinsics.a(b, "SessionManager.getInstance()");
        str = Single.fromCallable(new RemoteRedditApiDataSource$searchLinks$1(RedditClient.m9216a(b.m9203c()), str, str2, str3, str4)).doOnError((Consumer) RemoteRedditApiDataSource$searchLinks$2.f15982a).doOnSuccess((Consumer) RemoteRedditApiDataSource$searchLinks$3.f15983a);
        Intrinsics.a(str, "Single.fromCallable {\n  …ccess: 43 searchLinks\") }");
        return str;
    }

    public static Single<LinkListing> m8893a(String str, String str2, String str3, String str4, String str5, String str6) {
        Intrinsics.b(str, "subreddit");
        Intrinsics.b(str2, "query");
        SessionManager b = SessionManager.m9191b();
        Intrinsics.a(b, "SessionManager.getInstance()");
        str = Single.fromCallable(new RemoteRedditApiDataSource$subredditSearchLinks$1(RedditClient.m9216a(b.m9203c()), str, str2, str6, str4, str5, str3)).doOnError((Consumer) RemoteRedditApiDataSource$subredditSearchLinks$2.f16004a).doOnSuccess((Consumer) RemoteRedditApiDataSource$subredditSearchLinks$3.f16005a);
        Intrinsics.a(str, "Single.fromCallable {\n  … subredditSearchLinks\") }");
        return str;
    }

    public static Single<LinkListing> m8921d(String str, String str2) {
        Intrinsics.b(str, "multi");
        Intrinsics.b(str2, "query");
        SessionManager b = SessionManager.m9191b();
        Intrinsics.a(b, "SessionManager.getInstance()");
        str = Single.fromCallable(new RemoteRedditApiDataSource$multiSearchLinks$1(RedditClient.m9216a(b.m9203c()), str, str2)).doOnError((Consumer) RemoteRedditApiDataSource$multiSearchLinks$2.f15960a).doOnSuccess((Consumer) RemoteRedditApiDataSource$multiSearchLinks$3.f15961a);
        Intrinsics.a(str, "Single.fromCallable {\n  …ultiredditSearchLinks\") }");
        return str;
    }

    public static Single<SubmitResponse> m8894a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        String str9 = str;
        Intrinsics.b(str9, "subreddit");
        String str10 = str2;
        Intrinsics.b(str10, "title");
        String str11 = str3;
        Intrinsics.b(str11, UpdateFragment.FRAGMENT_URL);
        String str12 = str5;
        Intrinsics.b(str12, "latitude");
        String str13 = str6;
        Intrinsics.b(str13, "longitude");
        SessionManager b = SessionManager.m9191b();
        Intrinsics.a(b, "SessionManager.getInstance()");
        Single<SubmitResponse> doOnSuccess = Single.fromCallable(new RemoteRedditApiDataSource$submitLink$1(RedditClient.m9216a(b.m9203c()), str9, str10, str11, str4, str12, str13, str7, str8)).doOnError(RemoteRedditApiDataSource$submitLink$2.f15992a).doOnSuccess(RemoteRedditApiDataSource$submitLink$3.f15993a);
        Intrinsics.a(doOnSuccess, "Single.fromCallable { re…uccess: 46 submitLink\") }");
        return doOnSuccess;
    }

    public static Single<SubmitImageResponse> m8907b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        String str9 = str;
        Intrinsics.b(str9, "subreddit");
        String str10 = str2;
        Intrinsics.b(str10, "title");
        String str11 = str3;
        Intrinsics.b(str11, UpdateFragment.FRAGMENT_URL);
        String str12 = str5;
        Intrinsics.b(str12, "latitude");
        String str13 = str6;
        Intrinsics.b(str13, "longitude");
        SessionManager b = SessionManager.m9191b();
        Intrinsics.a(b, "SessionManager.getInstance()");
        Single<SubmitImageResponse> doOnSuccess = Single.fromCallable(new RemoteRedditApiDataSource$submitImage$1(RedditClient.m9216a(b.m9203c()), str9, str10, str11, str4, str12, str13, str7, str8)).doOnError(RemoteRedditApiDataSource$submitImage$2.f15990a).doOnSuccess(RemoteRedditApiDataSource$submitImage$3.f15991a);
        Intrinsics.a(doOnSuccess, "Single.fromCallable { re…ccess: 47 submitImage\") }");
        return doOnSuccess;
    }

    public static Single<SubmitVideoResponse> m8906b(String str, String str2, String str3, String str4, String str5, String str6) {
        Intrinsics.b(str, "subreddit");
        Intrinsics.b(str2, "title");
        Intrinsics.b(str3, "fileName");
        Intrinsics.b(str4, "videoUrl");
        Intrinsics.b(str5, "posterUrl");
        Intrinsics.b(str6, "kind");
        SessionManager b = SessionManager.m9191b();
        Intrinsics.a(b, "SessionManager.getInstance()");
        str = Single.fromCallable(new RemoteRedditApiDataSource$submitVideo$1(RedditClient.m9216a(b.m9203c()), str, str2, str3, str4, str5, str6)).doOnError((Consumer) RemoteRedditApiDataSource$submitVideo$2.f15996a).doOnSuccess((Consumer) RemoteRedditApiDataSource$submitVideo$3.f15997a);
        Intrinsics.a(str, "Single.fromCallable { re…ccess: 48 submitVideo\") }");
        return str;
    }

    public static Single<SubmitResponse> m8916c(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        String str9 = str;
        Intrinsics.b(str9, "subreddit");
        String str10 = str2;
        Intrinsics.b(str10, "title");
        String str11 = str3;
        Intrinsics.b(str11, "text");
        String str12 = str5;
        Intrinsics.b(str12, "latitude");
        String str13 = str6;
        Intrinsics.b(str13, "longitude");
        SessionManager b = SessionManager.m9191b();
        Intrinsics.a(b, "SessionManager.getInstance()");
        Single<SubmitResponse> doOnSuccess = Single.fromCallable(new RemoteRedditApiDataSource$submitSelf$1(RedditClient.m9216a(b.m9203c()), str9, str10, str11, str4, str12, str13, str7, str8)).doOnError(RemoteRedditApiDataSource$submitSelf$2.f15994a).doOnSuccess(RemoteRedditApiDataSource$submitSelf$3.f15995a);
        Intrinsics.a(doOnSuccess, "Single.fromCallable { re…uccess: 49 submitSelf\") }");
        return doOnSuccess;
    }

    public static Single<FileUploadLease> m8924e(String str, String str2) {
        Intrinsics.b(str, "filepath");
        Intrinsics.b(str2, "mimetype");
        SessionManager b = SessionManager.m9191b();
        Intrinsics.a(b, "SessionManager.getInstance()");
        str = Single.fromCallable(new RemoteRedditApiDataSource$getFileUploadLease$1(RedditClient.m9216a(b.m9203c()), str, str2)).doOnError((Consumer) RemoteRedditApiDataSource$getFileUploadLease$2.f15902a).doOnSuccess((Consumer) RemoteRedditApiDataSource$getFileUploadLease$3.f15903a);
        Intrinsics.a(str, "Single.fromCallable { re…50 getFileUploadLease\") }");
        return str;
    }

    public static Single<FileUploadLease> m8926f(String str, String str2) {
        Intrinsics.b(str, "filepath");
        Intrinsics.b(str2, "mimetype");
        SessionManager b = SessionManager.m9191b();
        Intrinsics.a(b, "SessionManager.getInstance()");
        str = Single.fromCallable(new RemoteRedditApiDataSource$getVideoUploadLease$1(RedditClient.m9216a(b.m9203c()), str, str2)).doOnError((Consumer) RemoteRedditApiDataSource$getVideoUploadLease$2.f15904a).doOnSuccess((Consumer) RemoteRedditApiDataSource$getVideoUploadLease$3.f15905a);
        Intrinsics.a(str, "Single.fromCallable { re…1 getVideoUploadLease\") }");
        return str;
    }

    public static Single<CommentReplyResponse> m8928g(String str, String str2) {
        Intrinsics.b(str, "thingId");
        Intrinsics.b(str2, "text");
        SessionManager b = SessionManager.m9191b();
        Intrinsics.a(b, "SessionManager.getInstance()");
        str = Single.fromCallable(new RemoteRedditApiDataSource$comment$1(RedditClient.m9216a(b.m9203c()), str, str2)).doOnError((Consumer) RemoteRedditApiDataSource$comment$2.f15882a).doOnSuccess((Consumer) RemoteRedditApiDataSource$comment$3.f15883a);
        Intrinsics.a(str, "Single.fromCallable { re…S Success: 52 comment\") }");
        return str;
    }

    public static Single<CommentEditResponse> m8930h(String str, String str2) {
        Intrinsics.b(str, "thingId");
        Intrinsics.b(str2, "text");
        SessionManager b = SessionManager.m9191b();
        Intrinsics.a(b, "SessionManager.getInstance()");
        str = Single.fromCallable(new RemoteRedditApiDataSource$editComment$1(RedditClient.m9216a(b.m9203c()), str, str2)).doOnError((Consumer) RemoteRedditApiDataSource$editComment$2.f15892a).doOnSuccess((Consumer) RemoteRedditApiDataSource$editComment$3.f15893a);
        Intrinsics.a(str, "Single.fromCallable { re…ccess: 53 editComment\") }");
        return str;
    }

    public static Single<LinkEditResponse> m8932i(String str, String str2) {
        Intrinsics.b(str, "thingId");
        Intrinsics.b(str2, "text");
        SessionManager b = SessionManager.m9191b();
        Intrinsics.a(b, "SessionManager.getInstance()");
        str = Single.fromCallable(new RemoteRedditApiDataSource$editLink$1(RedditClient.m9216a(b.m9203c()), str, str2)).doOnError((Consumer) RemoteRedditApiDataSource$editLink$2.f15894a).doOnSuccess((Consumer) RemoteRedditApiDataSource$editLink$3.f15895a);
        Intrinsics.a(str, "Single.fromCallable { re… Success: 54 editLink\") }");
        return str;
    }

    public static Single<GenericResponse<?>> m8915c(String str, String str2, String str3) {
        Intrinsics.b(str, "subject");
        Intrinsics.b(str2, "text");
        Intrinsics.b(str3, "to");
        SessionManager b = SessionManager.m9191b();
        Intrinsics.a(b, "SessionManager.getInstance()");
        str = Single.fromCallable(new RemoteRedditApiDataSource$compose$1(RedditClient.m9216a(b.m9203c()), str, str2, str3)).doOnError((Consumer) RemoteRedditApiDataSource$compose$2.f15886a).doOnSuccess((Consumer) RemoteRedditApiDataSource$compose$3.f15887a);
        Intrinsics.a(str, "Single.fromCallable { re…S Success: 55 compose\") }");
        return str;
    }

    public static Completable m8881a(ArrayList<String> arrayList) {
        Intrinsics.b(arrayList, "fullnames");
        SessionManager b = SessionManager.m9191b();
        Intrinsics.a(b, "SessionManager.getInstance()");
        arrayList = Completable.fromCallable(new RemoteRedditApiDataSource$hide$1(RedditClient.m9216a(b.m9203c()), arrayList)).doOnError(RemoteRedditApiDataSource$hide$2.f15908a).doOnComplete(RemoteRedditApiDataSource$hide$3.f15909a);
        Intrinsics.a(arrayList, "Completable.fromCallable…RADS Success: 56 hide\") }");
        return arrayList;
    }

    public static Completable m8901b(ArrayList<String> arrayList) {
        Intrinsics.b(arrayList, "fullnames");
        SessionManager b = SessionManager.m9191b();
        Intrinsics.a(b, "SessionManager.getInstance()");
        arrayList = Completable.fromCallable(new RemoteRedditApiDataSource$unhide$1(RedditClient.m9216a(b.m9203c()), arrayList)).doOnError(RemoteRedditApiDataSource$unhide$2.f16008a).doOnComplete(RemoteRedditApiDataSource$unhide$3.f16009a);
        Intrinsics.a(arrayList, "Completable.fromCallable…DS Success: 57 unhide\") }");
        return arrayList;
    }

    public static Completable m8918d(String str, String str2, String str3) {
        Intrinsics.b(str, "thingId");
        Intrinsics.b(str2, "reason");
        Intrinsics.b(str3, "otherReason");
        SessionManager b = SessionManager.m9191b();
        Intrinsics.a(b, "SessionManager.getInstance()");
        str = Completable.fromCallable(new RemoteRedditApiDataSource$report$1(RedditClient.m9216a(b.m9203c()), str, str2, str3)).doOnError((Consumer) RemoteRedditApiDataSource$report$2.f15972a).doOnComplete((Action) RemoteRedditApiDataSource$report$3.f15973a);
        Intrinsics.a(str, "Completable.fromCallable…DS Success: 58 report\") }");
        return str;
    }

    public static Completable m8911c(ArrayList<String> arrayList) {
        Intrinsics.b(arrayList, "fullnames");
        SessionManager b = SessionManager.m9191b();
        Intrinsics.a(b, "SessionManager.getInstance()");
        arrayList = Completable.fromCallable(new RemoteRedditApiDataSource$markRead$1(RedditClient.m9216a(b.m9203c()), arrayList)).doOnError(RemoteRedditApiDataSource$markRead$2.f15922a).doOnComplete(RemoteRedditApiDataSource$markRead$3.f15923a);
        Intrinsics.a(arrayList, "Completable.fromCallable… Success: 59 markRead\") }");
        return arrayList;
    }

    public static Completable m8934k(String str) {
        Intrinsics.b(str, "thingId");
        SessionManager b = SessionManager.m9191b();
        Intrinsics.a(b, "SessionManager.getInstance()");
        str = Completable.fromCallable(new RemoteRedditApiDataSource$modMarkNsfw$1(RedditClient.m9216a(b.m9203c()), str)).doOnError(RemoteRedditApiDataSource$modMarkNsfw$2.f15938a).doOnComplete(RemoteRedditApiDataSource$modMarkNsfw$3.f15939a);
        Intrinsics.a(str, "Completable.fromCallable…ccess: 60 modMarkNsfw\") }");
        return str;
    }

    public static Completable m8935l(String str) {
        Intrinsics.b(str, "thingId");
        SessionManager b = SessionManager.m9191b();
        Intrinsics.a(b, "SessionManager.getInstance()");
        str = Completable.fromCallable(new RemoteRedditApiDataSource$modUnmarkNsfw$1(RedditClient.m9216a(b.m9203c()), str)).doOnError(RemoteRedditApiDataSource$modUnmarkNsfw$2.f15952a).doOnComplete(RemoteRedditApiDataSource$modUnmarkNsfw$3.f15953a);
        Intrinsics.a(str, "Completable.fromCallable…ess: 61 modUnmarkNsfw\") }");
        return str;
    }

    public static Completable m8936m(String str) {
        Intrinsics.b(str, "thingId");
        SessionManager b = SessionManager.m9191b();
        Intrinsics.a(b, "SessionManager.getInstance()");
        str = Completable.fromCallable(new RemoteRedditApiDataSource$modMarkSpoiler$1(RedditClient.m9216a(b.m9203c()), str)).doOnError(RemoteRedditApiDataSource$modMarkSpoiler$2.f15940a).doOnComplete(RemoteRedditApiDataSource$modMarkSpoiler$3.f15941a);
        Intrinsics.a(str, "Completable.fromCallable…ss: 62 modMarkSpoiler\") }");
        return str;
    }

    public static Completable m8937n(String str) {
        Intrinsics.b(str, "thingId");
        SessionManager b = SessionManager.m9191b();
        Intrinsics.a(b, "SessionManager.getInstance()");
        str = Completable.fromCallable(new RemoteRedditApiDataSource$modUnmarkSpoiler$1(RedditClient.m9216a(b.m9203c()), str)).doOnError(RemoteRedditApiDataSource$modUnmarkSpoiler$2.f15954a).doOnComplete(RemoteRedditApiDataSource$modUnmarkSpoiler$3.f15955a);
        Intrinsics.a(str, "Completable.fromCallable…: 63 modUnmarkSpoiler\") }");
        return str;
    }

    public static Completable m8938o(String str) {
        Intrinsics.b(str, "thingId");
        SessionManager b = SessionManager.m9191b();
        Intrinsics.a(b, "SessionManager.getInstance()");
        str = Completable.fromCallable(new RemoteRedditApiDataSource$modLockComments$1(RedditClient.m9216a(b.m9203c()), str)).doOnError(RemoteRedditApiDataSource$modLockComments$2.f15936a).doOnComplete(RemoteRedditApiDataSource$modLockComments$3.f15937a);
        Intrinsics.a(str, "Completable.fromCallable…s: 64 modLockComments\") }");
        return str;
    }

    public static Completable m8939p(String str) {
        Intrinsics.b(str, "thingId");
        SessionManager b = SessionManager.m9191b();
        Intrinsics.a(b, "SessionManager.getInstance()");
        str = Completable.fromCallable(new RemoteRedditApiDataSource$modUnlockComments$1(RedditClient.m9216a(b.m9203c()), str)).doOnError(RemoteRedditApiDataSource$modUnlockComments$2.f15950a).doOnComplete(RemoteRedditApiDataSource$modUnlockComments$3.f15951a);
        Intrinsics.a(str, "Completable.fromCallable… 65 modUnlockComments\") }");
        return str;
    }

    public static Completable m8900b(String str, boolean z) {
        Intrinsics.b(str, "thingId");
        SessionManager b = SessionManager.m9191b();
        Intrinsics.a(b, "SessionManager.getInstance()");
        str = Completable.fromCallable(new RemoteRedditApiDataSource$modSetStickyStatus$1(RedditClient.m9216a(b.m9203c()), str, z)).doOnError((Consumer) RemoteRedditApiDataSource$modSetStickyStatus$2.f15946a).doOnComplete((Action) RemoteRedditApiDataSource$modSetStickyStatus$3.f15947a);
        Intrinsics.a(str, "Completable.fromCallable…66 modSetStickyStatus\") }");
        return str;
    }

    public static Completable m8940q(String str) {
        Intrinsics.b(str, "thingId");
        SessionManager b = SessionManager.m9191b();
        Intrinsics.a(b, "SessionManager.getInstance()");
        str = Completable.fromCallable(new RemoteRedditApiDataSource$modApprove$1(RedditClient.m9216a(b.m9203c()), str)).doOnError(RemoteRedditApiDataSource$modApprove$2.f15932a).doOnComplete(RemoteRedditApiDataSource$modApprove$3.f15933a);
        Intrinsics.a(str, "Completable.fromCallable…uccess: 67 modApprove\") }");
        return str;
    }

    public static Completable m8941r(String str) {
        Intrinsics.b(str, "thingId");
        SessionManager b = SessionManager.m9191b();
        Intrinsics.a(b, "SessionManager.getInstance()");
        str = Completable.fromCallable(new RemoteRedditApiDataSource$modDistinguish$1(RedditClient.m9216a(b.m9203c()), str)).doOnError(RemoteRedditApiDataSource$modDistinguish$2.f15934a).doOnComplete(RemoteRedditApiDataSource$modDistinguish$3.f15935a);
        Intrinsics.a(str, "Completable.fromCallable…ss: 68 modDistinguish\") }");
        return str;
    }

    public static Completable m8942s(String str) {
        Intrinsics.b(str, "thingId");
        SessionManager b = SessionManager.m9191b();
        Intrinsics.a(b, "SessionManager.getInstance()");
        str = Completable.fromCallable(new RemoteRedditApiDataSource$modPinDistinguish$1(RedditClient.m9216a(b.m9203c()), str)).doOnError(RemoteRedditApiDataSource$modPinDistinguish$2.f15942a).doOnComplete(RemoteRedditApiDataSource$modPinDistinguish$3.f15943a);
        Intrinsics.a(str, "Completable.fromCallable… 69 modPinDistinguish\") }");
        return str;
    }

    public static Completable m8943t(String str) {
        Intrinsics.b(str, "thingId");
        SessionManager b = SessionManager.m9191b();
        Intrinsics.a(b, "SessionManager.getInstance()");
        str = Completable.fromCallable(new RemoteRedditApiDataSource$modUndistinguish$1(RedditClient.m9216a(b.m9203c()), str)).doOnError(RemoteRedditApiDataSource$modUndistinguish$2.f15948a).doOnComplete(RemoteRedditApiDataSource$modUndistinguish$3.f15949a);
        Intrinsics.a(str, "Completable.fromCallable…: 70 modUndistinguish\") }");
        return str;
    }

    public static Completable m8910c(String str, boolean z) {
        Intrinsics.b(str, "thingId");
        SessionManager b = SessionManager.m9191b();
        Intrinsics.a(b, "SessionManager.getInstance()");
        str = Completable.fromCallable(new RemoteRedditApiDataSource$modRemove$1(RedditClient.m9216a(b.m9203c()), str, z)).doOnError((Consumer) RemoteRedditApiDataSource$modRemove$2.f15944a).doOnComplete((Action) RemoteRedditApiDataSource$modRemove$3.f15945a);
        Intrinsics.a(str, "Completable.fromCallable…Success: 71 modRemove\") }");
        return str;
    }

    public static Completable m8944u(String str) {
        Intrinsics.b(str, "thingId");
        SessionManager b = SessionManager.m9191b();
        Intrinsics.a(b, "SessionManager.getInstance()");
        str = Completable.fromCallable(new RemoteRedditApiDataSource$delete$1(RedditClient.m9216a(b.m9203c()), str)).doOnError(RemoteRedditApiDataSource$delete$2.f15890a).doOnComplete(RemoteRedditApiDataSource$delete$3.f15891a);
        Intrinsics.a(str, "Completable.fromCallable…DS Success: 72 delete\") }");
        return str;
    }

    public static Completable m8945v(String str) {
        Intrinsics.b(str, "thingName");
        SessionManager b = SessionManager.m9191b();
        Intrinsics.a(b, "SessionManager.getInstance()");
        str = Completable.fromCallable(new RemoteRedditApiDataSource$giveGold$1(RedditClient.m9216a(b.m9203c()), str)).doOnError(RemoteRedditApiDataSource$giveGold$2.f15906a).doOnComplete(RemoteRedditApiDataSource$giveGold$3.f15907a);
        Intrinsics.a(str, "Completable.fromCallable… Success: 73 giveGold\") }");
        return str;
    }

    public static Completable m8946w(String str) {
        Intrinsics.b(str, "pushToken");
        SessionManager b = SessionManager.m9191b();
        Intrinsics.a(b, "SessionManager.getInstance()");
        str = Completable.fromCallable(new RemoteRedditApiDataSource$registerPushToken$1(RedditClient.m9216a(b.m9203c()), str)).doOnError(RemoteRedditApiDataSource$registerPushToken$2.f15970a).doOnComplete(RemoteRedditApiDataSource$registerPushToken$3.f15971a);
        Intrinsics.a(str, "Completable.fromCallable… 75 registerPushToken\") }");
        return str;
    }

    public static Completable m8922e(String str, String str2, String str3) {
        Intrinsics.b(str, "username");
        Intrinsics.b(str2, "accountType");
        Intrinsics.b(str3, "token");
        str = Completable.fromCallable((Callable) new RemoteRedditApiDataSource$reportLogout$1(RedditClient.m9216a(new Session(str, str2, str3)))).doOnError((Consumer) RemoteRedditApiDataSource$reportLogout$2.f15974a).doOnComplete((Action) RemoteRedditApiDataSource$reportLogout$3.f15975a);
        Intrinsics.a(str, "Completable.fromCallable…cess: 76 reportLogout\") }");
        return str;
    }

    public static Single<List<LinkFlair>> m8947x(String str) {
        Intrinsics.b(str, "subreddit");
        SessionManager b = SessionManager.m9191b();
        Intrinsics.a(b, "SessionManager.getInstance()");
        str = Single.fromCallable(new RemoteRedditApiDataSource$flair$1(RedditClient.m9216a(b.m9203c()), str)).doOnError(RemoteRedditApiDataSource$flair$2.f15898a).doOnSuccess(RemoteRedditApiDataSource$flair$3.f15899a);
        Intrinsics.a(str, "Single.fromCallable { re…ADS Success: 77 flair\") }");
        return str;
    }

    public static Completable m8878a(LinkFlair linkFlair, String str, String str2) {
        Intrinsics.b(str2, "postFullname");
        SessionManager b = SessionManager.m9191b();
        Intrinsics.a(b, "SessionManager.getInstance()");
        linkFlair = Completable.fromCallable(new RemoteRedditApiDataSource$updatePostFlair$1(RedditClient.m9216a(b.m9203c()), linkFlair, str, str2)).doOnError((Consumer) RemoteRedditApiDataSource$updatePostFlair$2.f16012a).doOnComplete((Action) RemoteRedditApiDataSource$updatePostFlair$3.f16013a);
        Intrinsics.a(linkFlair, "Completable.fromCallable… 81 update post flair\") }");
        return linkFlair;
    }

    public static FileUploadResponse m8877a(String str, InputStream inputStream, String str2, List<? extends Field> list) {
        Intrinsics.b(str, "uploadUri");
        Intrinsics.b(inputStream, "input");
        Intrinsics.b(str2, "filename");
        Intrinsics.b(list, "awsKeys");
        SessionManager b = SessionManager.m9191b();
        Intrinsics.a(b, "SessionManager.getInstance()");
        RedditClient.m9216a(b.m9203c());
        str = RedditClient.m9219a(str, inputStream, str2, (List) list);
        Intrinsics.a(str, "RedditClient.getInstance…input, filename, awsKeys)");
        return str;
    }
}
