package com.reddit.datalibrary.frontpage.requests.models.v2;

import android.content.ContentValues;
import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.config.DatabaseHolder;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.converter.BooleanConverter;
import com.raizlabs.android.dbflow.converter.TypeConverter;
import com.raizlabs.android.dbflow.sql.language.OperatorGroup;
import com.raizlabs.android.dbflow.sql.language.SQLOperator;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.sql.language.property.IProperty;
import com.raizlabs.android.dbflow.sql.language.property.IndexProperty;
import com.raizlabs.android.dbflow.sql.language.property.Property;
import com.raizlabs.android.dbflow.sql.language.property.TypeConvertedProperty;
import com.raizlabs.android.dbflow.sql.language.property.TypeConvertedProperty.TypeConverterGetter;
import com.raizlabs.android.dbflow.structure.ModelAdapter;
import com.raizlabs.android.dbflow.structure.database.DatabaseStatement;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.FlowCursor;
import com.reddit.datalibrary.frontpage.requests.models.v1.ImageResolution;
import com.reddit.datalibrary.frontpage.requests.models.v1.ImageResolution_Table;
import com.reddit.frontpage.presentation.modtools.bottomsheet.modqueueoptions.ModQueueOptionsPresenter;
import net.hockeyapp.android.UpdateFragment;

public final class ClientLink_Table extends ModelAdapter<ClientLink> {
    public static final IProperty[] ALL_COLUMN_PROPERTIES = new IProperty[]{_id, id, name, created_utc, title, domain, url, score, likes, num_comments, view_count, subreddit_id, subreddit, subreddit_name_prefixed, link_flair_text, link_flair_id, author, author_cakeday, gilded, over_18, spoiler, suggested_sort, thumbnail, body, video_width, video_height, video_duration, video_dash_url, video_scrubber_media_url, video_is_gif, selftext, selftext_html, permalink, is_self, post_hint, author_flair_text, from_id, from_kind, websocket_url, archived, locked, quarantined, promoted, is_blank, hidden, saved, hide_score, stickied, distinguished, approved_by, approved, removed, spam, num_reports, brand_safe, scrubber_media_url, is_video, location_name, _sourcePreview_url, _nsfwPreview_url, _gifPreview_url, _mp4Preview_url, has_reddit_video_preview, rvp_height, rvp_width, rvp_dash_url, rvp_duration, rvp_hls_url, rvp_is_gif, rvp_fallback_url, rvp_scrubber_media_url, rvp_transcoder_status, read, readUtc, dirty, vote_key, is_betrayed, circlepost_websocket_url};
    public static final Property<String> _gifPreview_url = new Property(ClientLink.class, "_gifPreview_url");
    public static final Property<Long> _id = new Property(ClientLink.class, "_id");
    public static final Property<String> _mp4Preview_url = new Property(ClientLink.class, "_mp4Preview_url");
    public static final Property<String> _nsfwPreview_url = new Property(ClientLink.class, "_nsfwPreview_url");
    public static final Property<String> _sourcePreview_url = new Property(ClientLink.class, "_sourcePreview_url");
    public static final Property<Boolean> approved = new Property(ClientLink.class, "approved");
    public static final Property<String> approved_by = new Property(ClientLink.class, "approved_by");
    public static final Property<Boolean> archived = new Property(ClientLink.class, "archived");
    public static final Property<String> author = new Property(ClientLink.class, "author");
    public static final Property<Boolean> author_cakeday = new Property(ClientLink.class, "author_cakeday");
    public static final Property<String> author_flair_text = new Property(ClientLink.class, "author_flair_text");
    public static final Property<String> body = new Property(ClientLink.class, "body");
    public static final Property<Boolean> brand_safe = new Property(ClientLink.class, "brand_safe");
    public static final Property<String> circlepost_websocket_url = new Property(ClientLink.class, "circlepost_websocket_url");
    public static final Property<Long> created_utc = new Property(ClientLink.class, "created_utc");
    public static final Property<Boolean> dirty = new Property(ClientLink.class, "dirty");
    public static final Property<String> distinguished = new Property(ClientLink.class, "distinguished");
    public static final Property<String> domain = new Property(ClientLink.class, "domain");
    public static final Property<String> from_id = new Property(ClientLink.class, "from_id");
    public static final Property<String> from_kind = new Property(ClientLink.class, "from_kind");
    public static final Property<Integer> gilded = new Property(ClientLink.class, "gilded");
    public static final Property<Boolean> has_reddit_video_preview = new Property(ClientLink.class, "has_reddit_video_preview");
    public static final Property<Boolean> hidden = new Property(ClientLink.class, "hidden");
    public static final Property<Boolean> hide_score = new Property(ClientLink.class, "hide_score");
    public static final Property<String> id = new Property(ClientLink.class, "id");
    public static final IndexProperty<ClientLink> index_previously_read = new IndexProperty("previously_read", false, ClientLink.class, new IProperty[]{read, readUtc});
    public static final Property<Boolean> is_betrayed = new Property(ClientLink.class, "is_betrayed");
    public static final Property<Boolean> is_blank = new Property(ClientLink.class, "is_blank");
    public static final Property<Boolean> is_self = new Property(ClientLink.class, "is_self");
    public static final Property<Boolean> is_video = new Property(ClientLink.class, "is_video");
    public static final TypeConvertedProperty<Integer, Boolean> likes = new TypeConvertedProperty(ClientLink.class, "likes", true, new C22241());
    public static final Property<String> link_flair_id = new Property(ClientLink.class, "link_flair_id");
    public static final Property<String> link_flair_text = new Property(ClientLink.class, "link_flair_text");
    public static final Property<String> location_name = new Property(ClientLink.class, "location_name");
    public static final Property<Boolean> locked = new Property(ClientLink.class, "locked");
    public static final Property<String> name = new Property(ClientLink.class, "name");
    public static final Property<Long> num_comments = new Property(ClientLink.class, "num_comments");
    public static final Property<Integer> num_reports = new Property(ClientLink.class, "num_reports");
    public static final Property<Boolean> over_18 = new Property(ClientLink.class, "over_18");
    public static final Property<String> permalink = new Property(ClientLink.class, "permalink");
    public static final Property<String> post_hint = new Property(ClientLink.class, "post_hint");
    public static final Property<Boolean> promoted = new Property(ClientLink.class, "promoted");
    public static final Property<Boolean> quarantined = new Property(ClientLink.class, "quarantined");
    public static final Property<Boolean> read = new Property(ClientLink.class, "read");
    public static final Property<Long> readUtc = new Property(ClientLink.class, "readUtc");
    public static final Property<Boolean> removed = new Property(ClientLink.class, "removed");
    public static final Property<String> rvp_dash_url = new Property(ClientLink.class, "rvp_dash_url");
    public static final Property<Integer> rvp_duration = new Property(ClientLink.class, "rvp_duration");
    public static final Property<String> rvp_fallback_url = new Property(ClientLink.class, "rvp_fallback_url");
    public static final Property<Integer> rvp_height = new Property(ClientLink.class, "rvp_height");
    public static final Property<String> rvp_hls_url = new Property(ClientLink.class, "rvp_hls_url");
    public static final Property<Boolean> rvp_is_gif = new Property(ClientLink.class, "rvp_is_gif");
    public static final Property<String> rvp_scrubber_media_url = new Property(ClientLink.class, "rvp_scrubber_media_url");
    public static final Property<String> rvp_transcoder_status = new Property(ClientLink.class, "rvp_transcoder_status");
    public static final Property<Integer> rvp_width = new Property(ClientLink.class, "rvp_width");
    public static final Property<Boolean> saved = new Property(ClientLink.class, "saved");
    public static final Property<Integer> score = new Property(ClientLink.class, "score");
    public static final Property<String> scrubber_media_url = new Property(ClientLink.class, "scrubber_media_url");
    public static final Property<String> selftext = new Property(ClientLink.class, "selftext");
    public static final Property<String> selftext_html = new Property(ClientLink.class, "selftext_html");
    public static final Property<Boolean> spam = new Property(ClientLink.class, ModQueueOptionsPresenter.ACTION_SPAM);
    public static final Property<Boolean> spoiler = new Property(ClientLink.class, "spoiler");
    public static final Property<Boolean> stickied = new Property(ClientLink.class, "stickied");
    public static final Property<String> subreddit = new Property(ClientLink.class, "subreddit");
    public static final Property<String> subreddit_id = new Property(ClientLink.class, "subreddit_id");
    public static final Property<String> subreddit_name_prefixed = new Property(ClientLink.class, "subreddit_name_prefixed");
    public static final Property<String> suggested_sort = new Property(ClientLink.class, "suggested_sort");
    public static final Property<String> thumbnail = new Property(ClientLink.class, "thumbnail");
    public static final Property<String> title = new Property(ClientLink.class, "title");
    public static final Property<String> url = new Property(ClientLink.class, UpdateFragment.FRAGMENT_URL);
    public static final Property<String> video_dash_url = new Property(ClientLink.class, "video_dash_url");
    public static final Property<Integer> video_duration = new Property(ClientLink.class, "video_duration");
    public static final Property<Integer> video_height = new Property(ClientLink.class, "video_height");
    public static final Property<Boolean> video_is_gif = new Property(ClientLink.class, "video_is_gif");
    public static final Property<String> video_scrubber_media_url = new Property(ClientLink.class, "video_scrubber_media_url");
    public static final Property<Integer> video_width = new Property(ClientLink.class, "video_width");
    public static final Property<Long> view_count = new Property(ClientLink.class, "view_count");
    public static final Property<String> vote_key = new Property(ClientLink.class, "vote_key");
    public static final Property<String> websocket_url = new Property(ClientLink.class, "websocket_url");
    private final BooleanConverter global_typeConverterBooleanConverter;

    static class C22241 implements TypeConverterGetter {
        C22241() {
        }

        public final TypeConverter getTypeConverter(Class<?> cls) {
            return ((ClientLink_Table) FlowManager.getInstanceAdapter(cls)).global_typeConverterBooleanConverter;
        }
    }

    public final String getCompiledStatementQuery() {
        return "INSERT INTO `link`(`_id`,`id`,`name`,`created_utc`,`title`,`domain`,`url`,`score`,`likes`,`num_comments`,`view_count`,`subreddit_id`,`subreddit`,`subreddit_name_prefixed`,`link_flair_text`,`link_flair_id`,`author`,`author_cakeday`,`gilded`,`over_18`,`spoiler`,`suggested_sort`,`thumbnail`,`body`,`video_width`,`video_height`,`video_duration`,`video_dash_url`,`video_scrubber_media_url`,`video_is_gif`,`selftext`,`selftext_html`,`permalink`,`is_self`,`post_hint`,`author_flair_text`,`from_id`,`from_kind`,`websocket_url`,`archived`,`locked`,`quarantined`,`promoted`,`is_blank`,`hidden`,`saved`,`hide_score`,`stickied`,`distinguished`,`approved_by`,`approved`,`removed`,`spam`,`num_reports`,`brand_safe`,`scrubber_media_url`,`is_video`,`location_name`,`_sourcePreview_url`,`_nsfwPreview_url`,`_gifPreview_url`,`_mp4Preview_url`,`has_reddit_video_preview`,`rvp_height`,`rvp_width`,`rvp_dash_url`,`rvp_duration`,`rvp_hls_url`,`rvp_is_gif`,`rvp_fallback_url`,`rvp_scrubber_media_url`,`rvp_transcoder_status`,`read`,`readUtc`,`dirty`,`vote_key`,`is_betrayed`,`circlepost_websocket_url`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }

    public final String getDeleteStatementQuery() {
        return "DELETE FROM `link` WHERE `_id`=?";
    }

    public final String getTableName() {
        return "`link`";
    }

    public final String getUpdateStatementQuery() {
        return "UPDATE `link` SET `_id`=?,`id`=?,`name`=?,`created_utc`=?,`title`=?,`domain`=?,`url`=?,`score`=?,`likes`=?,`num_comments`=?,`view_count`=?,`subreddit_id`=?,`subreddit`=?,`subreddit_name_prefixed`=?,`link_flair_text`=?,`link_flair_id`=?,`author`=?,`author_cakeday`=?,`gilded`=?,`over_18`=?,`spoiler`=?,`suggested_sort`=?,`thumbnail`=?,`body`=?,`video_width`=?,`video_height`=?,`video_duration`=?,`video_dash_url`=?,`video_scrubber_media_url`=?,`video_is_gif`=?,`selftext`=?,`selftext_html`=?,`permalink`=?,`is_self`=?,`post_hint`=?,`author_flair_text`=?,`from_id`=?,`from_kind`=?,`websocket_url`=?,`archived`=?,`locked`=?,`quarantined`=?,`promoted`=?,`is_blank`=?,`hidden`=?,`saved`=?,`hide_score`=?,`stickied`=?,`distinguished`=?,`approved_by`=?,`approved`=?,`removed`=?,`spam`=?,`num_reports`=?,`brand_safe`=?,`scrubber_media_url`=?,`is_video`=?,`location_name`=?,`_sourcePreview_url`=?,`_nsfwPreview_url`=?,`_gifPreview_url`=?,`_mp4Preview_url`=?,`has_reddit_video_preview`=?,`rvp_height`=?,`rvp_width`=?,`rvp_dash_url`=?,`rvp_duration`=?,`rvp_hls_url`=?,`rvp_is_gif`=?,`rvp_fallback_url`=?,`rvp_scrubber_media_url`=?,`rvp_transcoder_status`=?,`read`=?,`readUtc`=?,`dirty`=?,`vote_key`=?,`is_betrayed`=?,`circlepost_websocket_url`=? WHERE `_id`=?";
    }

    public final /* synthetic */ void bindToDeleteStatement(DatabaseStatement databaseStatement, Object obj) {
        databaseStatement.bindLong(1, ((ClientLink) obj)._id);
    }

    public final /* synthetic */ void bindToInsertStatement(DatabaseStatement databaseStatement, Object obj, int i) {
        ClientLink clientLink = (ClientLink) obj;
        databaseStatement.bindLong(1 + i, clientLink._id);
        databaseStatement.bindStringOrNull(2 + i, clientLink.id);
        databaseStatement.bindStringOrNull(3 + i, clientLink.name);
        databaseStatement.bindLong(4 + i, clientLink.created_utc);
        databaseStatement.bindStringOrNull(5 + i, clientLink.title);
        databaseStatement.bindStringOrNull(6 + i, clientLink.domain);
        databaseStatement.bindStringOrNull(7 + i, clientLink.url);
        databaseStatement.bindLong(8 + i, (long) clientLink.score);
        databaseStatement.bindNumberOrNull(9 + i, clientLink.likes != null ? this.global_typeConverterBooleanConverter.getDBValue(clientLink.likes) : null);
        databaseStatement.bindLong(10 + i, clientLink.num_comments);
        databaseStatement.bindLong(11 + i, clientLink.view_count);
        databaseStatement.bindStringOrNull(12 + i, clientLink.subreddit_id);
        databaseStatement.bindStringOrNull(13 + i, clientLink.subreddit);
        databaseStatement.bindStringOrNull(14 + i, clientLink.subreddit_name_prefixed);
        databaseStatement.bindStringOrNull(15 + i, clientLink.link_flair_text);
        databaseStatement.bindStringOrNull(16 + i, clientLink.link_flair_id);
        databaseStatement.bindStringOrNull(17 + i, clientLink.author);
        long j = 0;
        databaseStatement.bindLong(18 + i, clientLink.author_cakeday ? 1 : 0);
        databaseStatement.bindLong(19 + i, (long) clientLink.gilded);
        databaseStatement.bindLong(20 + i, clientLink.over_18 ? 1 : 0);
        databaseStatement.bindLong(21 + i, clientLink.spoiler ? 1 : 0);
        databaseStatement.bindStringOrNull(22 + i, clientLink.suggested_sort);
        databaseStatement.bindStringOrNull(23 + i, clientLink.thumbnail);
        databaseStatement.bindStringOrNull(24 + i, clientLink.body);
        databaseStatement.bindLong(25 + i, (long) clientLink.video_width);
        databaseStatement.bindLong(26 + i, (long) clientLink.video_height);
        databaseStatement.bindLong(27 + i, (long) clientLink.video_duration);
        databaseStatement.bindStringOrNull(28 + i, clientLink.video_dash_url);
        databaseStatement.bindStringOrNull(29 + i, clientLink.video_scrubber_media_url);
        databaseStatement.bindLong(30 + i, clientLink.video_is_gif ? 1 : 0);
        databaseStatement.bindStringOrNull(31 + i, clientLink.selftext);
        databaseStatement.bindStringOrNull(32 + i, clientLink.selftext_html);
        databaseStatement.bindStringOrNull(33 + i, clientLink.permalink);
        databaseStatement.bindLong(34 + i, clientLink.is_self ? 1 : 0);
        databaseStatement.bindStringOrNull(35 + i, clientLink.post_hint);
        databaseStatement.bindStringOrNull(36 + i, clientLink.author_flair_text);
        databaseStatement.bindStringOrNull(37 + i, clientLink.from_id);
        databaseStatement.bindStringOrNull(38 + i, clientLink.from_kind);
        databaseStatement.bindStringOrNull(39 + i, clientLink.websocket_url);
        databaseStatement.bindLong(40 + i, clientLink.archived ? 1 : 0);
        databaseStatement.bindLong(41 + i, clientLink.locked ? 1 : 0);
        databaseStatement.bindLong(42 + i, clientLink.quarantined ? 1 : 0);
        databaseStatement.bindLong(43 + i, clientLink.promoted ? 1 : 0);
        databaseStatement.bindLong(44 + i, clientLink.is_blank ? 1 : 0);
        databaseStatement.bindLong(45 + i, clientLink.hidden ? 1 : 0);
        databaseStatement.bindLong(46 + i, clientLink.saved ? 1 : 0);
        databaseStatement.bindLong(47 + i, clientLink.hide_score ? 1 : 0);
        databaseStatement.bindLong(48 + i, clientLink.stickied ? 1 : 0);
        databaseStatement.bindStringOrNull(49 + i, clientLink.distinguished);
        databaseStatement.bindStringOrNull(50 + i, clientLink.approved_by);
        databaseStatement.bindLong(51 + i, clientLink.approved ? 1 : 0);
        databaseStatement.bindLong(52 + i, clientLink.removed ? 1 : 0);
        databaseStatement.bindLong(53 + i, clientLink.spam ? 1 : 0);
        databaseStatement.bindLong(54 + i, (long) clientLink.num_reports);
        databaseStatement.bindLong(55 + i, clientLink.brand_safe ? 1 : 0);
        databaseStatement.bindStringOrNull(56 + i, clientLink.scrubber_media_url);
        databaseStatement.bindLong(57 + i, clientLink.is_video ? 1 : 0);
        databaseStatement.bindStringOrNull(58 + i, clientLink.location_name);
        if (clientLink._sourcePreview != null) {
            databaseStatement.bindStringOrNull(59 + i, clientLink._sourcePreview.getUrl());
        } else {
            databaseStatement.bindNull(59 + i);
        }
        if (clientLink._nsfwPreview != null) {
            databaseStatement.bindStringOrNull(60 + i, clientLink._nsfwPreview.getUrl());
        } else {
            databaseStatement.bindNull(60 + i);
        }
        if (clientLink._gifPreview != null) {
            databaseStatement.bindStringOrNull(61 + i, clientLink._gifPreview.getUrl());
        } else {
            databaseStatement.bindNull(61 + i);
        }
        if (clientLink._mp4Preview != null) {
            databaseStatement.bindStringOrNull(62 + i, clientLink._mp4Preview.getUrl());
        } else {
            databaseStatement.bindNull(62 + i);
        }
        databaseStatement.bindLong(63 + i, clientLink.has_reddit_video_preview ? 1 : 0);
        databaseStatement.bindLong(64 + i, (long) clientLink.rvp_height);
        databaseStatement.bindLong(65 + i, (long) clientLink.rvp_width);
        databaseStatement.bindStringOrNull(66 + i, clientLink.rvp_dash_url);
        databaseStatement.bindLong(67 + i, (long) clientLink.rvp_duration);
        databaseStatement.bindStringOrNull(68 + i, clientLink.rvp_hls_url);
        databaseStatement.bindLong(69 + i, clientLink.rvp_is_gif ? 1 : 0);
        databaseStatement.bindStringOrNull(70 + i, clientLink.rvp_fallback_url);
        databaseStatement.bindStringOrNull(71 + i, clientLink.rvp_scrubber_media_url);
        databaseStatement.bindStringOrNull(72 + i, clientLink.rvp_transcoder_status);
        databaseStatement.bindLong(73 + i, clientLink._read ? 1 : 0);
        databaseStatement.bindLong(74 + i, clientLink._readUtc);
        databaseStatement.bindLong(75 + i, clientLink._dirty ? 1 : 0);
        databaseStatement.bindStringOrNull(76 + i, clientLink.vote_key);
        int i2 = 77 + i;
        if (clientLink.is_betrayed) {
            j = 1;
        }
        databaseStatement.bindLong(i2, j);
        databaseStatement.bindStringOrNull(78 + i, clientLink.circlepost_websocket_url);
    }

    public final /* synthetic */ void bindToInsertValues(ContentValues contentValues, Object obj) {
        ClientLink clientLink = (ClientLink) obj;
        contentValues.put("`_id`", Long.valueOf(clientLink._id));
        contentValues.put("`id`", clientLink.id);
        contentValues.put("`name`", clientLink.name);
        contentValues.put("`created_utc`", Long.valueOf(clientLink.created_utc));
        contentValues.put("`title`", clientLink.title);
        contentValues.put("`domain`", clientLink.domain);
        contentValues.put("`url`", clientLink.url);
        contentValues.put("`score`", Integer.valueOf(clientLink.score));
        contentValues.put("`likes`", clientLink.likes != null ? this.global_typeConverterBooleanConverter.getDBValue(clientLink.likes) : null);
        contentValues.put("`num_comments`", Long.valueOf(clientLink.num_comments));
        contentValues.put("`view_count`", Long.valueOf(clientLink.view_count));
        contentValues.put("`subreddit_id`", clientLink.subreddit_id);
        contentValues.put("`subreddit`", clientLink.subreddit);
        contentValues.put("`subreddit_name_prefixed`", clientLink.subreddit_name_prefixed);
        contentValues.put("`link_flair_text`", clientLink.link_flair_text);
        contentValues.put("`link_flair_id`", clientLink.link_flair_id);
        contentValues.put("`author`", clientLink.author);
        contentValues.put("`author_cakeday`", Integer.valueOf(clientLink.author_cakeday));
        contentValues.put("`gilded`", Integer.valueOf(clientLink.gilded));
        contentValues.put("`over_18`", Integer.valueOf(clientLink.over_18));
        contentValues.put("`spoiler`", Integer.valueOf(clientLink.spoiler));
        contentValues.put("`suggested_sort`", clientLink.suggested_sort);
        contentValues.put("`thumbnail`", clientLink.thumbnail);
        contentValues.put("`body`", clientLink.body);
        contentValues.put("`video_width`", Integer.valueOf(clientLink.video_width));
        contentValues.put("`video_height`", Integer.valueOf(clientLink.video_height));
        contentValues.put("`video_duration`", Integer.valueOf(clientLink.video_duration));
        contentValues.put("`video_dash_url`", clientLink.video_dash_url);
        contentValues.put("`video_scrubber_media_url`", clientLink.video_scrubber_media_url);
        contentValues.put("`video_is_gif`", Integer.valueOf(clientLink.video_is_gif));
        contentValues.put("`selftext`", clientLink.selftext);
        contentValues.put("`selftext_html`", clientLink.selftext_html);
        contentValues.put("`permalink`", clientLink.permalink);
        contentValues.put("`is_self`", Integer.valueOf(clientLink.is_self));
        contentValues.put("`post_hint`", clientLink.post_hint);
        contentValues.put("`author_flair_text`", clientLink.author_flair_text);
        contentValues.put("`from_id`", clientLink.from_id);
        contentValues.put("`from_kind`", clientLink.from_kind);
        contentValues.put("`websocket_url`", clientLink.websocket_url);
        contentValues.put("`archived`", Integer.valueOf(clientLink.archived));
        contentValues.put("`locked`", Integer.valueOf(clientLink.locked));
        contentValues.put("`quarantined`", Integer.valueOf(clientLink.quarantined));
        contentValues.put("`promoted`", Integer.valueOf(clientLink.promoted));
        contentValues.put("`is_blank`", Integer.valueOf(clientLink.is_blank));
        contentValues.put("`hidden`", Integer.valueOf(clientLink.hidden));
        contentValues.put("`saved`", Integer.valueOf(clientLink.saved));
        contentValues.put("`hide_score`", Integer.valueOf(clientLink.hide_score));
        contentValues.put("`stickied`", Integer.valueOf(clientLink.stickied));
        contentValues.put("`distinguished`", clientLink.distinguished);
        contentValues.put("`approved_by`", clientLink.approved_by);
        contentValues.put("`approved`", Integer.valueOf(clientLink.approved));
        contentValues.put("`removed`", Integer.valueOf(clientLink.removed));
        contentValues.put("`spam`", Integer.valueOf(clientLink.spam));
        contentValues.put("`num_reports`", Integer.valueOf(clientLink.num_reports));
        contentValues.put("`brand_safe`", Integer.valueOf(clientLink.brand_safe));
        contentValues.put("`scrubber_media_url`", clientLink.scrubber_media_url);
        contentValues.put("`is_video`", Integer.valueOf(clientLink.is_video));
        contentValues.put("`location_name`", clientLink.location_name);
        if (clientLink._sourcePreview != null) {
            contentValues.put("`_sourcePreview_url`", clientLink._sourcePreview.getUrl());
        } else {
            contentValues.putNull("`_sourcePreview_url`");
        }
        if (clientLink._nsfwPreview != null) {
            contentValues.put("`_nsfwPreview_url`", clientLink._nsfwPreview.getUrl());
        } else {
            contentValues.putNull("`_nsfwPreview_url`");
        }
        if (clientLink._gifPreview != null) {
            contentValues.put("`_gifPreview_url`", clientLink._gifPreview.getUrl());
        } else {
            contentValues.putNull("`_gifPreview_url`");
        }
        if (clientLink._mp4Preview != null) {
            contentValues.put("`_mp4Preview_url`", clientLink._mp4Preview.getUrl());
        } else {
            contentValues.putNull("`_mp4Preview_url`");
        }
        contentValues.put("`has_reddit_video_preview`", Integer.valueOf(clientLink.has_reddit_video_preview));
        contentValues.put("`rvp_height`", Integer.valueOf(clientLink.rvp_height));
        contentValues.put("`rvp_width`", Integer.valueOf(clientLink.rvp_width));
        contentValues.put("`rvp_dash_url`", clientLink.rvp_dash_url);
        contentValues.put("`rvp_duration`", Integer.valueOf(clientLink.rvp_duration));
        contentValues.put("`rvp_hls_url`", clientLink.rvp_hls_url);
        contentValues.put("`rvp_is_gif`", Integer.valueOf(clientLink.rvp_is_gif));
        contentValues.put("`rvp_fallback_url`", clientLink.rvp_fallback_url);
        contentValues.put("`rvp_scrubber_media_url`", clientLink.rvp_scrubber_media_url);
        contentValues.put("`rvp_transcoder_status`", clientLink.rvp_transcoder_status);
        contentValues.put("`read`", Integer.valueOf(clientLink._read));
        contentValues.put("`readUtc`", Long.valueOf(clientLink._readUtc));
        contentValues.put("`dirty`", Integer.valueOf(clientLink._dirty));
        contentValues.put("`vote_key`", clientLink.vote_key);
        contentValues.put("`is_betrayed`", Integer.valueOf(clientLink.is_betrayed));
        contentValues.put("`circlepost_websocket_url`", clientLink.circlepost_websocket_url);
    }

    public final /* synthetic */ void bindToUpdateStatement(DatabaseStatement databaseStatement, Object obj) {
        ClientLink clientLink = (ClientLink) obj;
        databaseStatement.bindLong(1, clientLink._id);
        databaseStatement.bindStringOrNull(2, clientLink.id);
        databaseStatement.bindStringOrNull(3, clientLink.name);
        databaseStatement.bindLong(4, clientLink.created_utc);
        databaseStatement.bindStringOrNull(5, clientLink.title);
        databaseStatement.bindStringOrNull(6, clientLink.domain);
        databaseStatement.bindStringOrNull(7, clientLink.url);
        databaseStatement.bindLong(8, (long) clientLink.score);
        databaseStatement.bindNumberOrNull(9, clientLink.likes != null ? this.global_typeConverterBooleanConverter.getDBValue(clientLink.likes) : null);
        databaseStatement.bindLong(10, clientLink.num_comments);
        databaseStatement.bindLong(11, clientLink.view_count);
        databaseStatement.bindStringOrNull(12, clientLink.subreddit_id);
        databaseStatement.bindStringOrNull(13, clientLink.subreddit);
        databaseStatement.bindStringOrNull(14, clientLink.subreddit_name_prefixed);
        databaseStatement.bindStringOrNull(15, clientLink.link_flair_text);
        databaseStatement.bindStringOrNull(16, clientLink.link_flair_id);
        databaseStatement.bindStringOrNull(17, clientLink.author);
        long j = 0;
        databaseStatement.bindLong(18, clientLink.author_cakeday ? 1 : 0);
        databaseStatement.bindLong(19, (long) clientLink.gilded);
        databaseStatement.bindLong(20, clientLink.over_18 ? 1 : 0);
        databaseStatement.bindLong(21, clientLink.spoiler ? 1 : 0);
        databaseStatement.bindStringOrNull(22, clientLink.suggested_sort);
        databaseStatement.bindStringOrNull(23, clientLink.thumbnail);
        databaseStatement.bindStringOrNull(24, clientLink.body);
        databaseStatement.bindLong(25, (long) clientLink.video_width);
        databaseStatement.bindLong(26, (long) clientLink.video_height);
        databaseStatement.bindLong(27, (long) clientLink.video_duration);
        databaseStatement.bindStringOrNull(28, clientLink.video_dash_url);
        databaseStatement.bindStringOrNull(29, clientLink.video_scrubber_media_url);
        databaseStatement.bindLong(30, clientLink.video_is_gif ? 1 : 0);
        databaseStatement.bindStringOrNull(31, clientLink.selftext);
        databaseStatement.bindStringOrNull(32, clientLink.selftext_html);
        databaseStatement.bindStringOrNull(33, clientLink.permalink);
        databaseStatement.bindLong(34, clientLink.is_self ? 1 : 0);
        databaseStatement.bindStringOrNull(35, clientLink.post_hint);
        databaseStatement.bindStringOrNull(36, clientLink.author_flair_text);
        databaseStatement.bindStringOrNull(37, clientLink.from_id);
        databaseStatement.bindStringOrNull(38, clientLink.from_kind);
        databaseStatement.bindStringOrNull(39, clientLink.websocket_url);
        databaseStatement.bindLong(40, clientLink.archived ? 1 : 0);
        databaseStatement.bindLong(41, clientLink.locked ? 1 : 0);
        databaseStatement.bindLong(42, clientLink.quarantined ? 1 : 0);
        databaseStatement.bindLong(43, clientLink.promoted ? 1 : 0);
        databaseStatement.bindLong(44, clientLink.is_blank ? 1 : 0);
        databaseStatement.bindLong(45, clientLink.hidden ? 1 : 0);
        databaseStatement.bindLong(46, clientLink.saved ? 1 : 0);
        databaseStatement.bindLong(47, clientLink.hide_score ? 1 : 0);
        databaseStatement.bindLong(48, clientLink.stickied ? 1 : 0);
        databaseStatement.bindStringOrNull(49, clientLink.distinguished);
        databaseStatement.bindStringOrNull(50, clientLink.approved_by);
        databaseStatement.bindLong(51, clientLink.approved ? 1 : 0);
        databaseStatement.bindLong(52, clientLink.removed ? 1 : 0);
        databaseStatement.bindLong(53, clientLink.spam ? 1 : 0);
        databaseStatement.bindLong(54, (long) clientLink.num_reports);
        databaseStatement.bindLong(55, clientLink.brand_safe ? 1 : 0);
        databaseStatement.bindStringOrNull(56, clientLink.scrubber_media_url);
        databaseStatement.bindLong(57, clientLink.is_video ? 1 : 0);
        databaseStatement.bindStringOrNull(58, clientLink.location_name);
        if (clientLink._sourcePreview != null) {
            databaseStatement.bindStringOrNull(59, clientLink._sourcePreview.getUrl());
        } else {
            databaseStatement.bindNull(59);
        }
        if (clientLink._nsfwPreview != null) {
            databaseStatement.bindStringOrNull(60, clientLink._nsfwPreview.getUrl());
        } else {
            databaseStatement.bindNull(60);
        }
        if (clientLink._gifPreview != null) {
            databaseStatement.bindStringOrNull(61, clientLink._gifPreview.getUrl());
        } else {
            databaseStatement.bindNull(61);
        }
        if (clientLink._mp4Preview != null) {
            databaseStatement.bindStringOrNull(62, clientLink._mp4Preview.getUrl());
        } else {
            databaseStatement.bindNull(62);
        }
        databaseStatement.bindLong(63, clientLink.has_reddit_video_preview ? 1 : 0);
        databaseStatement.bindLong(64, (long) clientLink.rvp_height);
        databaseStatement.bindLong(65, (long) clientLink.rvp_width);
        databaseStatement.bindStringOrNull(66, clientLink.rvp_dash_url);
        databaseStatement.bindLong(67, (long) clientLink.rvp_duration);
        databaseStatement.bindStringOrNull(68, clientLink.rvp_hls_url);
        databaseStatement.bindLong(69, clientLink.rvp_is_gif ? 1 : 0);
        databaseStatement.bindStringOrNull(70, clientLink.rvp_fallback_url);
        databaseStatement.bindStringOrNull(71, clientLink.rvp_scrubber_media_url);
        databaseStatement.bindStringOrNull(72, clientLink.rvp_transcoder_status);
        databaseStatement.bindLong(73, clientLink._read ? 1 : 0);
        databaseStatement.bindLong(74, clientLink._readUtc);
        databaseStatement.bindLong(75, clientLink._dirty ? 1 : 0);
        databaseStatement.bindStringOrNull(76, clientLink.vote_key);
        if (clientLink.is_betrayed) {
            j = 1;
        }
        databaseStatement.bindLong(77, j);
        databaseStatement.bindStringOrNull(78, clientLink.circlepost_websocket_url);
        databaseStatement.bindLong(79, clientLink._id);
    }

    public final /* synthetic */ boolean exists(Object obj, DatabaseWrapper databaseWrapper) {
        ClientLink clientLink = (ClientLink) obj;
        return SQLite.selectCountOf(new IProperty[0]).from(ClientLink.class).where(new SQLOperator[]{m36658a(clientLink)}).hasData(databaseWrapper);
    }

    public final /* synthetic */ OperatorGroup getPrimaryConditionClause(Object obj) {
        return m36658a((ClientLink) obj);
    }

    public final /* synthetic */ void loadFromCursor(FlowCursor flowCursor, Object obj) {
        ClientLink clientLink = (ClientLink) obj;
        clientLink._id = flowCursor.getLongOrDefault("_id");
        clientLink.id = flowCursor.getStringOrDefault("id");
        clientLink.name = flowCursor.getStringOrDefault("name");
        clientLink.created_utc = flowCursor.getLongOrDefault("created_utc");
        clientLink.title = flowCursor.getStringOrDefault("title");
        clientLink.domain = flowCursor.getStringOrDefault("domain");
        clientLink.url = flowCursor.getStringOrDefault(UpdateFragment.FRAGMENT_URL);
        clientLink.score = flowCursor.getIntOrDefault("score");
        int columnIndex = flowCursor.getColumnIndex("likes");
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            clientLink.likes = this.global_typeConverterBooleanConverter.getModelValue(null);
        } else {
            clientLink.likes = this.global_typeConverterBooleanConverter.getModelValue(Integer.valueOf(flowCursor.getInt(columnIndex)));
        }
        clientLink.num_comments = flowCursor.getLongOrDefault("num_comments");
        clientLink.view_count = flowCursor.getLongOrDefault("view_count");
        clientLink.subreddit_id = flowCursor.getStringOrDefault("subreddit_id");
        clientLink.subreddit = flowCursor.getStringOrDefault("subreddit");
        clientLink.subreddit_name_prefixed = flowCursor.getStringOrDefault("subreddit_name_prefixed");
        clientLink.link_flair_text = flowCursor.getStringOrDefault("link_flair_text");
        clientLink.link_flair_id = flowCursor.getStringOrDefault("link_flair_id");
        clientLink.author = flowCursor.getStringOrDefault("author");
        columnIndex = flowCursor.getColumnIndex("author_cakeday");
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            clientLink.author_cakeday = false;
        } else {
            clientLink.author_cakeday = flowCursor.getBoolean(columnIndex);
        }
        clientLink.gilded = flowCursor.getIntOrDefault("gilded");
        columnIndex = flowCursor.getColumnIndex("over_18");
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            clientLink.over_18 = false;
        } else {
            clientLink.over_18 = flowCursor.getBoolean(columnIndex);
        }
        columnIndex = flowCursor.getColumnIndex("spoiler");
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            clientLink.spoiler = false;
        } else {
            clientLink.spoiler = flowCursor.getBoolean(columnIndex);
        }
        clientLink.suggested_sort = flowCursor.getStringOrDefault("suggested_sort");
        clientLink.thumbnail = flowCursor.getStringOrDefault("thumbnail");
        clientLink.body = flowCursor.getStringOrDefault("body");
        clientLink.video_width = flowCursor.getIntOrDefault("video_width");
        clientLink.video_height = flowCursor.getIntOrDefault("video_height");
        clientLink.video_duration = flowCursor.getIntOrDefault("video_duration");
        clientLink.video_dash_url = flowCursor.getStringOrDefault("video_dash_url");
        clientLink.video_scrubber_media_url = flowCursor.getStringOrDefault("video_scrubber_media_url");
        columnIndex = flowCursor.getColumnIndex("video_is_gif");
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            clientLink.video_is_gif = false;
        } else {
            clientLink.video_is_gif = flowCursor.getBoolean(columnIndex);
        }
        clientLink.selftext = flowCursor.getStringOrDefault("selftext");
        clientLink.selftext_html = flowCursor.getStringOrDefault("selftext_html");
        clientLink.permalink = flowCursor.getStringOrDefault("permalink");
        columnIndex = flowCursor.getColumnIndex("is_self");
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            clientLink.is_self = false;
        } else {
            clientLink.is_self = flowCursor.getBoolean(columnIndex);
        }
        clientLink.post_hint = flowCursor.getStringOrDefault("post_hint");
        clientLink.author_flair_text = flowCursor.getStringOrDefault("author_flair_text");
        clientLink.from_id = flowCursor.getStringOrDefault("from_id");
        clientLink.from_kind = flowCursor.getStringOrDefault("from_kind");
        clientLink.websocket_url = flowCursor.getStringOrDefault("websocket_url");
        columnIndex = flowCursor.getColumnIndex("archived");
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            clientLink.archived = false;
        } else {
            clientLink.archived = flowCursor.getBoolean(columnIndex);
        }
        columnIndex = flowCursor.getColumnIndex("locked");
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            clientLink.locked = false;
        } else {
            clientLink.locked = flowCursor.getBoolean(columnIndex);
        }
        columnIndex = flowCursor.getColumnIndex("quarantined");
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            clientLink.quarantined = false;
        } else {
            clientLink.quarantined = flowCursor.getBoolean(columnIndex);
        }
        columnIndex = flowCursor.getColumnIndex("promoted");
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            clientLink.promoted = false;
        } else {
            clientLink.promoted = flowCursor.getBoolean(columnIndex);
        }
        columnIndex = flowCursor.getColumnIndex("is_blank");
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            clientLink.is_blank = false;
        } else {
            clientLink.is_blank = flowCursor.getBoolean(columnIndex);
        }
        columnIndex = flowCursor.getColumnIndex("hidden");
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            clientLink.hidden = false;
        } else {
            clientLink.hidden = flowCursor.getBoolean(columnIndex);
        }
        columnIndex = flowCursor.getColumnIndex("saved");
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            clientLink.saved = false;
        } else {
            clientLink.saved = flowCursor.getBoolean(columnIndex);
        }
        columnIndex = flowCursor.getColumnIndex("hide_score");
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            clientLink.hide_score = false;
        } else {
            clientLink.hide_score = flowCursor.getBoolean(columnIndex);
        }
        columnIndex = flowCursor.getColumnIndex("stickied");
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            clientLink.stickied = false;
        } else {
            clientLink.stickied = flowCursor.getBoolean(columnIndex);
        }
        clientLink.distinguished = flowCursor.getStringOrDefault("distinguished");
        clientLink.approved_by = flowCursor.getStringOrDefault("approved_by");
        columnIndex = flowCursor.getColumnIndex("approved");
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            clientLink.approved = false;
        } else {
            clientLink.approved = flowCursor.getBoolean(columnIndex);
        }
        columnIndex = flowCursor.getColumnIndex("removed");
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            clientLink.removed = false;
        } else {
            clientLink.removed = flowCursor.getBoolean(columnIndex);
        }
        columnIndex = flowCursor.getColumnIndex(ModQueueOptionsPresenter.ACTION_SPAM);
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            clientLink.spam = false;
        } else {
            clientLink.spam = flowCursor.getBoolean(columnIndex);
        }
        clientLink.num_reports = flowCursor.getIntOrDefault("num_reports");
        columnIndex = flowCursor.getColumnIndex("brand_safe");
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            clientLink.brand_safe = false;
        } else {
            clientLink.brand_safe = flowCursor.getBoolean(columnIndex);
        }
        clientLink.scrubber_media_url = flowCursor.getStringOrDefault("scrubber_media_url");
        columnIndex = flowCursor.getColumnIndex("is_video");
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            clientLink.is_video = false;
        } else {
            clientLink.is_video = flowCursor.getBoolean(columnIndex);
        }
        clientLink.location_name = flowCursor.getStringOrDefault("location_name");
        columnIndex = flowCursor.getColumnIndex("_sourcePreview_url");
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            clientLink._sourcePreview = null;
        } else {
            clientLink._sourcePreview = (ImageResolution) SQLite.select(new IProperty[0]).from(ImageResolution.class).where(new SQLOperator[0]).and(ImageResolution_Table.url.eq(flowCursor.getString(columnIndex))).querySingle();
        }
        columnIndex = flowCursor.getColumnIndex("_nsfwPreview_url");
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            clientLink._nsfwPreview = null;
        } else {
            clientLink._nsfwPreview = (ImageResolution) SQLite.select(new IProperty[0]).from(ImageResolution.class).where(new SQLOperator[0]).and(ImageResolution_Table.url.eq(flowCursor.getString(columnIndex))).querySingle();
        }
        columnIndex = flowCursor.getColumnIndex("_gifPreview_url");
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            clientLink._gifPreview = null;
        } else {
            clientLink._gifPreview = (ImageResolution) SQLite.select(new IProperty[0]).from(ImageResolution.class).where(new SQLOperator[0]).and(ImageResolution_Table.url.eq(flowCursor.getString(columnIndex))).querySingle();
        }
        columnIndex = flowCursor.getColumnIndex("_mp4Preview_url");
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            clientLink._mp4Preview = null;
        } else {
            clientLink._mp4Preview = (ImageResolution) SQLite.select(new IProperty[0]).from(ImageResolution.class).where(new SQLOperator[0]).and(ImageResolution_Table.url.eq(flowCursor.getString(columnIndex))).querySingle();
        }
        columnIndex = flowCursor.getColumnIndex("has_reddit_video_preview");
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            clientLink.has_reddit_video_preview = false;
        } else {
            clientLink.has_reddit_video_preview = flowCursor.getBoolean(columnIndex);
        }
        clientLink.rvp_height = flowCursor.getIntOrDefault("rvp_height");
        clientLink.rvp_width = flowCursor.getIntOrDefault("rvp_width");
        clientLink.rvp_dash_url = flowCursor.getStringOrDefault("rvp_dash_url");
        clientLink.rvp_duration = flowCursor.getIntOrDefault("rvp_duration");
        clientLink.rvp_hls_url = flowCursor.getStringOrDefault("rvp_hls_url");
        columnIndex = flowCursor.getColumnIndex("rvp_is_gif");
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            clientLink.rvp_is_gif = false;
        } else {
            clientLink.rvp_is_gif = flowCursor.getBoolean(columnIndex);
        }
        clientLink.rvp_fallback_url = flowCursor.getStringOrDefault("rvp_fallback_url");
        clientLink.rvp_scrubber_media_url = flowCursor.getStringOrDefault("rvp_scrubber_media_url");
        clientLink.rvp_transcoder_status = flowCursor.getStringOrDefault("rvp_transcoder_status");
        columnIndex = flowCursor.getColumnIndex("read");
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            clientLink._read = false;
        } else {
            clientLink._read = flowCursor.getBoolean(columnIndex);
        }
        clientLink._readUtc = flowCursor.getLongOrDefault("readUtc");
        columnIndex = flowCursor.getColumnIndex("dirty");
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            clientLink._dirty = false;
        } else {
            clientLink._dirty = flowCursor.getBoolean(columnIndex);
        }
        clientLink.vote_key = flowCursor.getStringOrDefault("vote_key");
        columnIndex = flowCursor.getColumnIndex("is_betrayed");
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            clientLink.is_betrayed = false;
        } else {
            clientLink.is_betrayed = flowCursor.getBoolean(columnIndex);
        }
        clientLink.circlepost_websocket_url = flowCursor.getStringOrDefault("circlepost_websocket_url");
    }

    public final /* synthetic */ void saveForeignKeys(Object obj, DatabaseWrapper databaseWrapper) {
        ClientLink clientLink = (ClientLink) obj;
        if (clientLink._sourcePreview != null) {
            clientLink._sourcePreview.save(databaseWrapper);
        }
        if (clientLink._nsfwPreview != null) {
            clientLink._nsfwPreview.save(databaseWrapper);
        }
        if (clientLink._gifPreview != null) {
            clientLink._gifPreview.save(databaseWrapper);
        }
        if (clientLink._mp4Preview != null) {
            clientLink._mp4Preview.save(databaseWrapper);
        }
    }

    public ClientLink_Table(DatabaseHolder databaseHolder, DatabaseDefinition databaseDefinition) {
        super(databaseDefinition);
        this.global_typeConverterBooleanConverter = (BooleanConverter) databaseHolder.getTypeConverterForClass(Boolean.class);
    }

    public final Class<ClientLink> getModelClass() {
        return ClientLink.class;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.raizlabs.android.dbflow.sql.language.property.Property getProperty(java.lang.String r2) {
        /*
        r1 = this;
        r2 = com.raizlabs.android.dbflow.sql.QueryBuilder.quoteIfNeeded(r2);
        r0 = r2.hashCode();
        switch(r0) {
            case -2133078291: goto L_0x0399;
            case -2065411647: goto L_0x038e;
            case -2049586851: goto L_0x0383;
            case -2038066278: goto L_0x0378;
            case -2030563538: goto L_0x036d;
            case -2017504392: goto L_0x0362;
            case -1827487932: goto L_0x0357;
            case -1801753468: goto L_0x034c;
            case -1692817628: goto L_0x0341;
            case -1608410343: goto L_0x0335;
            case -1606759314: goto L_0x032a;
            case -1592646753: goto L_0x031e;
            case -1586463085: goto L_0x0312;
            case -1572445848: goto L_0x0307;
            case -1479458378: goto L_0x02fb;
            case -1475384595: goto L_0x02ef;
            case -1462047947: goto L_0x02e3;
            case -1452656994: goto L_0x02d7;
            case -1446787384: goto L_0x02cb;
            case -1441983787: goto L_0x02c0;
            case -1438182102: goto L_0x02b4;
            case -1436930601: goto L_0x02a8;
            case -1411185403: goto L_0x029c;
            case -1346205144: goto L_0x0290;
            case -1327056866: goto L_0x0284;
            case -1283894348: goto L_0x0278;
            case -1187561074: goto L_0x026c;
            case -1169926517: goto L_0x0260;
            case -1154256006: goto L_0x0254;
            case -1132203806: goto L_0x0248;
            case -1115033284: goto L_0x023c;
            case -840440875: goto L_0x0230;
            case -837033125: goto L_0x0224;
            case -813284437: goto L_0x0218;
            case -773799366: goto L_0x020c;
            case -620905299: goto L_0x0200;
            case -562875557: goto L_0x01f4;
            case -537178343: goto L_0x01e8;
            case -477320885: goto L_0x01dc;
            case -393696621: goto L_0x01d1;
            case -161453273: goto L_0x01c5;
            case -160062807: goto L_0x01b9;
            case -111196217: goto L_0x01ad;
            case -107717697: goto L_0x01a1;
            case 2964037: goto L_0x0196;
            case 35227435: goto L_0x018a;
            case 91592262: goto L_0x017f;
            case 92256561: goto L_0x0174;
            case 144769590: goto L_0x0168;
            case 697424937: goto L_0x015c;
            case 718662550: goto L_0x0150;
            case 737077054: goto L_0x0144;
            case 863603354: goto L_0x0138;
            case 885811352: goto L_0x012c;
            case 913824262: goto L_0x0120;
            case 937471143: goto L_0x0114;
            case 943599710: goto L_0x0108;
            case 960015512: goto L_0x00fc;
            case 1070708531: goto L_0x00f0;
            case 1193410428: goto L_0x00e4;
            case 1242693306: goto L_0x00d8;
            case 1333696752: goto L_0x00cc;
            case 1457469743: goto L_0x00c0;
            case 1523242978: goto L_0x00b4;
            case 1540505589: goto L_0x00a8;
            case 1552693130: goto L_0x009c;
            case 1613097355: goto L_0x0090;
            case 1638293072: goto L_0x0084;
            case 1643616188: goto L_0x0079;
            case 1687007713: goto L_0x006d;
            case 1688833318: goto L_0x0061;
            case 1710531154: goto L_0x0055;
            case 1731064595: goto L_0x0049;
            case 1784337111: goto L_0x003d;
            case 1810323420: goto L_0x0031;
            case 1883166036: goto L_0x0025;
            case 2006709246: goto L_0x0019;
            case 2065208416: goto L_0x000d;
            default: goto L_0x000b;
        };
    L_0x000b:
        goto L_0x03a4;
    L_0x000d:
        r0 = "`removed`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x0015:
        r2 = 51;
        goto L_0x03a5;
    L_0x0019:
        r0 = "`video_width`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x0021:
        r2 = 24;
        goto L_0x03a5;
    L_0x0025:
        r0 = "`thumbnail`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x002d:
        r2 = 22;
        goto L_0x03a5;
    L_0x0031:
        r0 = "`promoted`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x0039:
        r2 = 42;
        goto L_0x03a5;
    L_0x003d:
        r0 = "`from_kind`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x0045:
        r2 = 37;
        goto L_0x03a5;
    L_0x0049:
        r0 = "`num_comments`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x0051:
        r2 = 9;
        goto L_0x03a5;
    L_0x0055:
        r0 = "`readUtc`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x005d:
        r2 = 73;
        goto L_0x03a5;
    L_0x0061:
        r0 = "`rvp_height`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x0069:
        r2 = 63;
        goto L_0x03a5;
    L_0x006d:
        r0 = "`is_blank`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x0075:
        r2 = 43;
        goto L_0x03a5;
    L_0x0079:
        r0 = "`domain`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x0081:
        r2 = 5;
        goto L_0x03a5;
    L_0x0084:
        r0 = "`author_cakeday`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x008c:
        r2 = 17;
        goto L_0x03a5;
    L_0x0090:
        r0 = "`scrubber_media_url`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x0098:
        r2 = 55;
        goto L_0x03a5;
    L_0x009c:
        r0 = "`quarantined`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x00a4:
        r2 = 41;
        goto L_0x03a5;
    L_0x00a8:
        r0 = "`video_height`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x00b0:
        r2 = 25;
        goto L_0x03a5;
    L_0x00b4:
        r0 = "`subreddit`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x00bc:
        r2 = 12;
        goto L_0x03a5;
    L_0x00c0:
        r0 = "`selftext_html`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x00c8:
        r2 = 31;
        goto L_0x03a5;
    L_0x00cc:
        r0 = "`from_id`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x00d4:
        r2 = 36;
        goto L_0x03a5;
    L_0x00d8:
        r0 = "`post_hint`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x00e0:
        r2 = 34;
        goto L_0x03a5;
    L_0x00e4:
        r0 = "`distinguished`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x00ec:
        r2 = 48;
        goto L_0x03a5;
    L_0x00f0:
        r0 = "`link_flair_text`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x00f8:
        r2 = 14;
        goto L_0x03a5;
    L_0x00fc:
        r0 = "`has_reddit_video_preview`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x0104:
        r2 = 62;
        goto L_0x03a5;
    L_0x0108:
        r0 = "`archived`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x0110:
        r2 = 39;
        goto L_0x03a5;
    L_0x0114:
        r0 = "`selftext`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x011c:
        r2 = 30;
        goto L_0x03a5;
    L_0x0120:
        r0 = "`suggested_sort`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x0128:
        r2 = 21;
        goto L_0x03a5;
    L_0x012c:
        r0 = "`circlepost_websocket_url`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x0134:
        r2 = 77;
        goto L_0x03a5;
    L_0x0138:
        r0 = "`_mp4Preview_url`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x0140:
        r2 = 61;
        goto L_0x03a5;
    L_0x0144:
        r0 = "`spoiler`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x014c:
        r2 = 20;
        goto L_0x03a5;
    L_0x0150:
        r0 = "`hidden`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x0158:
        r2 = 44;
        goto L_0x03a5;
    L_0x015c:
        r0 = "`approved`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x0164:
        r2 = 50;
        goto L_0x03a5;
    L_0x0168:
        r0 = "`locked`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x0170:
        r2 = 40;
        goto L_0x03a5;
    L_0x0174:
        r0 = "`url`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x017c:
        r2 = 6;
        goto L_0x03a5;
    L_0x017f:
        r0 = "`_id`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x0187:
        r2 = 0;
        goto L_0x03a5;
    L_0x018a:
        r0 = "`rvp_dash_url`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x0192:
        r2 = 65;
        goto L_0x03a5;
    L_0x0196:
        r0 = "`id`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x019e:
        r2 = 1;
        goto L_0x03a5;
    L_0x01a1:
        r0 = "`rvp_transcoder_status`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x01a9:
        r2 = 71;
        goto L_0x03a5;
    L_0x01ad:
        r0 = "`video_scrubber_media_url`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x01b5:
        r2 = 28;
        goto L_0x03a5;
    L_0x01b9:
        r0 = "`websocket_url`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x01c1:
        r2 = 38;
        goto L_0x03a5;
    L_0x01c5:
        r0 = "`gilded`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x01cd:
        r2 = 18;
        goto L_0x03a5;
    L_0x01d1:
        r0 = "`created_utc`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x01d9:
        r2 = 3;
        goto L_0x03a5;
    L_0x01dc:
        r0 = "`hide_score`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x01e4:
        r2 = 46;
        goto L_0x03a5;
    L_0x01e8:
        r0 = "`rvp_duration`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x01f0:
        r2 = 66;
        goto L_0x03a5;
    L_0x01f4:
        r0 = "`rvp_fallback_url`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x01fc:
        r2 = 69;
        goto L_0x03a5;
    L_0x0200:
        r0 = "`rvp_width`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x0208:
        r2 = 64;
        goto L_0x03a5;
    L_0x020c:
        r0 = "`video_dash_url`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x0214:
        r2 = 27;
        goto L_0x03a5;
    L_0x0218:
        r0 = "`view_count`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x0220:
        r2 = 10;
        goto L_0x03a5;
    L_0x0224:
        r0 = "`brand_safe`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x022c:
        r2 = 54;
        goto L_0x03a5;
    L_0x0230:
        r0 = "`author`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x0238:
        r2 = 16;
        goto L_0x03a5;
    L_0x023c:
        r0 = "`subreddit_name_prefixed`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x0244:
        r2 = 13;
        goto L_0x03a5;
    L_0x0248:
        r0 = "`_sourcePreview_url`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x0250:
        r2 = 58;
        goto L_0x03a5;
    L_0x0254:
        r0 = "`num_reports`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x025c:
        r2 = 53;
        goto L_0x03a5;
    L_0x0260:
        r0 = "`location_name`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x0268:
        r2 = 57;
        goto L_0x03a5;
    L_0x026c:
        r0 = "`over_18`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x0274:
        r2 = 19;
        goto L_0x03a5;
    L_0x0278:
        r0 = "`rvp_hls_url`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x0280:
        r2 = 67;
        goto L_0x03a5;
    L_0x0284:
        r0 = "`rvp_is_gif`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x028c:
        r2 = 68;
        goto L_0x03a5;
    L_0x0290:
        r0 = "`video_duration`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x0298:
        r2 = 26;
        goto L_0x03a5;
    L_0x029c:
        r0 = "`link_flair_id`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x02a4:
        r2 = 15;
        goto L_0x03a5;
    L_0x02a8:
        r0 = "`spam`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x02b0:
        r2 = 52;
        goto L_0x03a5;
    L_0x02b4:
        r0 = "`read`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x02bc:
        r2 = 72;
        goto L_0x03a5;
    L_0x02c0:
        r0 = "`name`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x02c8:
        r2 = 2;
        goto L_0x03a5;
    L_0x02cb:
        r0 = "`stickied`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x02d3:
        r2 = 47;
        goto L_0x03a5;
    L_0x02d7:
        r0 = "`body`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x02df:
        r2 = 23;
        goto L_0x03a5;
    L_0x02e3:
        r0 = "`permalink`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x02eb:
        r2 = 32;
        goto L_0x03a5;
    L_0x02ef:
        r0 = "`video_is_gif`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x02f7:
        r2 = 29;
        goto L_0x03a5;
    L_0x02fb:
        r0 = "`vote_key`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x0303:
        r2 = 75;
        goto L_0x03a5;
    L_0x0307:
        r0 = "`title`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x030f:
        r2 = 4;
        goto L_0x03a5;
    L_0x0312:
        r0 = "`is_betrayed`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x031a:
        r2 = 76;
        goto L_0x03a5;
    L_0x031e:
        r0 = "`is_self`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x0326:
        r2 = 33;
        goto L_0x03a5;
    L_0x032a:
        r0 = "`score`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x0332:
        r2 = 7;
        goto L_0x03a5;
    L_0x0335:
        r0 = "`saved`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x033d:
        r2 = 45;
        goto L_0x03a5;
    L_0x0341:
        r0 = "`subreddit_id`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x0349:
        r2 = 11;
        goto L_0x03a5;
    L_0x034c:
        r0 = "`likes`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x0354:
        r2 = 8;
        goto L_0x03a5;
    L_0x0357:
        r0 = "`author_flair_text`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x035f:
        r2 = 35;
        goto L_0x03a5;
    L_0x0362:
        r0 = "`rvp_scrubber_media_url`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x036a:
        r2 = 70;
        goto L_0x03a5;
    L_0x036d:
        r0 = "`dirty`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x0375:
        r2 = 74;
        goto L_0x03a5;
    L_0x0378:
        r0 = "`is_video`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x0380:
        r2 = 56;
        goto L_0x03a5;
    L_0x0383:
        r0 = "`_nsfwPreview_url`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x038b:
        r2 = 59;
        goto L_0x03a5;
    L_0x038e:
        r0 = "`approved_by`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x0396:
        r2 = 49;
        goto L_0x03a5;
    L_0x0399:
        r0 = "`_gifPreview_url`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x03a4;
    L_0x03a1:
        r2 = 60;
        goto L_0x03a5;
    L_0x03a4:
        r2 = -1;
    L_0x03a5:
        switch(r2) {
            case 0: goto L_0x0497;
            case 1: goto L_0x0494;
            case 2: goto L_0x0491;
            case 3: goto L_0x048e;
            case 4: goto L_0x048b;
            case 5: goto L_0x0488;
            case 6: goto L_0x0485;
            case 7: goto L_0x0482;
            case 8: goto L_0x047f;
            case 9: goto L_0x047c;
            case 10: goto L_0x0479;
            case 11: goto L_0x0476;
            case 12: goto L_0x0473;
            case 13: goto L_0x0470;
            case 14: goto L_0x046d;
            case 15: goto L_0x046a;
            case 16: goto L_0x0467;
            case 17: goto L_0x0464;
            case 18: goto L_0x0461;
            case 19: goto L_0x045e;
            case 20: goto L_0x045b;
            case 21: goto L_0x0458;
            case 22: goto L_0x0455;
            case 23: goto L_0x0452;
            case 24: goto L_0x044f;
            case 25: goto L_0x044c;
            case 26: goto L_0x0449;
            case 27: goto L_0x0446;
            case 28: goto L_0x0443;
            case 29: goto L_0x0440;
            case 30: goto L_0x043d;
            case 31: goto L_0x043a;
            case 32: goto L_0x0437;
            case 33: goto L_0x0434;
            case 34: goto L_0x0431;
            case 35: goto L_0x042e;
            case 36: goto L_0x042b;
            case 37: goto L_0x0428;
            case 38: goto L_0x0425;
            case 39: goto L_0x0422;
            case 40: goto L_0x041f;
            case 41: goto L_0x041c;
            case 42: goto L_0x0419;
            case 43: goto L_0x0416;
            case 44: goto L_0x0413;
            case 45: goto L_0x0410;
            case 46: goto L_0x040d;
            case 47: goto L_0x040a;
            case 48: goto L_0x0407;
            case 49: goto L_0x0404;
            case 50: goto L_0x0401;
            case 51: goto L_0x03fe;
            case 52: goto L_0x03fb;
            case 53: goto L_0x03f8;
            case 54: goto L_0x03f5;
            case 55: goto L_0x03f2;
            case 56: goto L_0x03ef;
            case 57: goto L_0x03ec;
            case 58: goto L_0x03e9;
            case 59: goto L_0x03e6;
            case 60: goto L_0x03e3;
            case 61: goto L_0x03e0;
            case 62: goto L_0x03dd;
            case 63: goto L_0x03da;
            case 64: goto L_0x03d7;
            case 65: goto L_0x03d4;
            case 66: goto L_0x03d1;
            case 67: goto L_0x03ce;
            case 68: goto L_0x03cb;
            case 69: goto L_0x03c8;
            case 70: goto L_0x03c5;
            case 71: goto L_0x03c2;
            case 72: goto L_0x03bf;
            case 73: goto L_0x03bc;
            case 74: goto L_0x03b9;
            case 75: goto L_0x03b6;
            case 76: goto L_0x03b3;
            case 77: goto L_0x03b0;
            default: goto L_0x03a8;
        };
    L_0x03a8:
        r2 = new java.lang.IllegalArgumentException;
        r0 = "Invalid column name passed. Ensure you are calling the correct table's column";
        r2.<init>(r0);
        throw r2;
    L_0x03b0:
        r2 = circlepost_websocket_url;
        return r2;
    L_0x03b3:
        r2 = is_betrayed;
        return r2;
    L_0x03b6:
        r2 = vote_key;
        return r2;
    L_0x03b9:
        r2 = dirty;
        return r2;
    L_0x03bc:
        r2 = readUtc;
        return r2;
    L_0x03bf:
        r2 = read;
        return r2;
    L_0x03c2:
        r2 = rvp_transcoder_status;
        return r2;
    L_0x03c5:
        r2 = rvp_scrubber_media_url;
        return r2;
    L_0x03c8:
        r2 = rvp_fallback_url;
        return r2;
    L_0x03cb:
        r2 = rvp_is_gif;
        return r2;
    L_0x03ce:
        r2 = rvp_hls_url;
        return r2;
    L_0x03d1:
        r2 = rvp_duration;
        return r2;
    L_0x03d4:
        r2 = rvp_dash_url;
        return r2;
    L_0x03d7:
        r2 = rvp_width;
        return r2;
    L_0x03da:
        r2 = rvp_height;
        return r2;
    L_0x03dd:
        r2 = has_reddit_video_preview;
        return r2;
    L_0x03e0:
        r2 = _mp4Preview_url;
        return r2;
    L_0x03e3:
        r2 = _gifPreview_url;
        return r2;
    L_0x03e6:
        r2 = _nsfwPreview_url;
        return r2;
    L_0x03e9:
        r2 = _sourcePreview_url;
        return r2;
    L_0x03ec:
        r2 = location_name;
        return r2;
    L_0x03ef:
        r2 = is_video;
        return r2;
    L_0x03f2:
        r2 = scrubber_media_url;
        return r2;
    L_0x03f5:
        r2 = brand_safe;
        return r2;
    L_0x03f8:
        r2 = num_reports;
        return r2;
    L_0x03fb:
        r2 = spam;
        return r2;
    L_0x03fe:
        r2 = removed;
        return r2;
    L_0x0401:
        r2 = approved;
        return r2;
    L_0x0404:
        r2 = approved_by;
        return r2;
    L_0x0407:
        r2 = distinguished;
        return r2;
    L_0x040a:
        r2 = stickied;
        return r2;
    L_0x040d:
        r2 = hide_score;
        return r2;
    L_0x0410:
        r2 = saved;
        return r2;
    L_0x0413:
        r2 = hidden;
        return r2;
    L_0x0416:
        r2 = is_blank;
        return r2;
    L_0x0419:
        r2 = promoted;
        return r2;
    L_0x041c:
        r2 = quarantined;
        return r2;
    L_0x041f:
        r2 = locked;
        return r2;
    L_0x0422:
        r2 = archived;
        return r2;
    L_0x0425:
        r2 = websocket_url;
        return r2;
    L_0x0428:
        r2 = from_kind;
        return r2;
    L_0x042b:
        r2 = from_id;
        return r2;
    L_0x042e:
        r2 = author_flair_text;
        return r2;
    L_0x0431:
        r2 = post_hint;
        return r2;
    L_0x0434:
        r2 = is_self;
        return r2;
    L_0x0437:
        r2 = permalink;
        return r2;
    L_0x043a:
        r2 = selftext_html;
        return r2;
    L_0x043d:
        r2 = selftext;
        return r2;
    L_0x0440:
        r2 = video_is_gif;
        return r2;
    L_0x0443:
        r2 = video_scrubber_media_url;
        return r2;
    L_0x0446:
        r2 = video_dash_url;
        return r2;
    L_0x0449:
        r2 = video_duration;
        return r2;
    L_0x044c:
        r2 = video_height;
        return r2;
    L_0x044f:
        r2 = video_width;
        return r2;
    L_0x0452:
        r2 = body;
        return r2;
    L_0x0455:
        r2 = thumbnail;
        return r2;
    L_0x0458:
        r2 = suggested_sort;
        return r2;
    L_0x045b:
        r2 = spoiler;
        return r2;
    L_0x045e:
        r2 = over_18;
        return r2;
    L_0x0461:
        r2 = gilded;
        return r2;
    L_0x0464:
        r2 = author_cakeday;
        return r2;
    L_0x0467:
        r2 = author;
        return r2;
    L_0x046a:
        r2 = link_flair_id;
        return r2;
    L_0x046d:
        r2 = link_flair_text;
        return r2;
    L_0x0470:
        r2 = subreddit_name_prefixed;
        return r2;
    L_0x0473:
        r2 = subreddit;
        return r2;
    L_0x0476:
        r2 = subreddit_id;
        return r2;
    L_0x0479:
        r2 = view_count;
        return r2;
    L_0x047c:
        r2 = num_comments;
        return r2;
    L_0x047f:
        r2 = likes;
        return r2;
    L_0x0482:
        r2 = score;
        return r2;
    L_0x0485:
        r2 = url;
        return r2;
    L_0x0488:
        r2 = domain;
        return r2;
    L_0x048b:
        r2 = title;
        return r2;
    L_0x048e:
        r2 = created_utc;
        return r2;
    L_0x0491:
        r2 = name;
        return r2;
    L_0x0494:
        r2 = id;
        return r2;
    L_0x0497:
        r2 = _id;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.datalibrary.frontpage.requests.models.v2.ClientLink_Table.getProperty(java.lang.String):com.raizlabs.android.dbflow.sql.language.property.Property");
    }

    public final IProperty[] getAllColumnProperties() {
        return ALL_COLUMN_PROPERTIES;
    }

    public final String getCreationQuery() {
        StringBuilder stringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS `link`(`_id` INTEGER, `id` TEXT, `name` TEXT, `created_utc` INTEGER, `title` TEXT, `domain` TEXT, `url` TEXT, `score` INTEGER, `likes` INTEGER, `num_comments` INTEGER, `view_count` INTEGER, `subreddit_id` TEXT, `subreddit` TEXT, `subreddit_name_prefixed` TEXT, `link_flair_text` TEXT, `link_flair_id` TEXT, `author` TEXT, `author_cakeday` INTEGER, `gilded` INTEGER, `over_18` INTEGER, `spoiler` INTEGER, `suggested_sort` TEXT, `thumbnail` TEXT, `body` TEXT, `video_width` INTEGER, `video_height` INTEGER, `video_duration` INTEGER, `video_dash_url` TEXT, `video_scrubber_media_url` TEXT, `video_is_gif` INTEGER, `selftext` TEXT, `selftext_html` TEXT, `permalink` TEXT, `is_self` INTEGER, `post_hint` TEXT, `author_flair_text` TEXT, `from_id` TEXT, `from_kind` TEXT, `websocket_url` TEXT, `archived` INTEGER, `locked` INTEGER, `quarantined` INTEGER, `promoted` INTEGER, `is_blank` INTEGER, `hidden` INTEGER, `saved` INTEGER, `hide_score` INTEGER, `stickied` INTEGER, `distinguished` TEXT, `approved_by` TEXT, `approved` INTEGER, `removed` INTEGER, `spam` INTEGER, `num_reports` INTEGER, `brand_safe` INTEGER, `scrubber_media_url` TEXT, `is_video` INTEGER, `location_name` TEXT, `_sourcePreview_url` TEXT, `_nsfwPreview_url` TEXT, `_gifPreview_url` TEXT, `_mp4Preview_url` TEXT, `has_reddit_video_preview` INTEGER, `rvp_height` INTEGER, `rvp_width` INTEGER, `rvp_dash_url` TEXT, `rvp_duration` INTEGER, `rvp_hls_url` TEXT, `rvp_is_gif` INTEGER, `rvp_fallback_url` TEXT, `rvp_scrubber_media_url` TEXT, `rvp_transcoder_status` TEXT, `read` INTEGER, `readUtc` INTEGER, `dirty` INTEGER, `vote_key` TEXT, `is_betrayed` INTEGER, `circlepost_websocket_url` TEXT, PRIMARY KEY(`_id`), FOREIGN KEY(`_sourcePreview_url`) REFERENCES ");
        stringBuilder.append(FlowManager.getTableName(ImageResolution.class));
        stringBuilder.append("(`url`) ON UPDATE NO ACTION ON DELETE NO ACTION, FOREIGN KEY(`_nsfwPreview_url`) REFERENCES ");
        stringBuilder.append(FlowManager.getTableName(ImageResolution.class));
        stringBuilder.append("(`url`) ON UPDATE NO ACTION ON DELETE NO ACTION, FOREIGN KEY(`_gifPreview_url`) REFERENCES ");
        stringBuilder.append(FlowManager.getTableName(ImageResolution.class));
        stringBuilder.append("(`url`) ON UPDATE NO ACTION ON DELETE NO ACTION, FOREIGN KEY(`_mp4Preview_url`) REFERENCES ");
        stringBuilder.append(FlowManager.getTableName(ImageResolution.class));
        stringBuilder.append("(`url`) ON UPDATE NO ACTION ON DELETE NO ACTION);");
        return stringBuilder.toString();
    }

    private static OperatorGroup m36658a(ClientLink clientLink) {
        OperatorGroup clause = OperatorGroup.clause();
        clause.and(_id.eq(Long.valueOf(clientLink._id)));
        return clause;
    }

    public final /* synthetic */ Object newInstance() {
        return new ClientLink();
    }
}
