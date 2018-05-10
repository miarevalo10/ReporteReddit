package com.reddit.datalibrary.frontpage.requests.models.v1;

import android.content.ContentValues;
import com.instabug.library.model.State;
import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.sql.language.OperatorGroup;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.sql.language.property.IProperty;
import com.raizlabs.android.dbflow.sql.language.property.Property;
import com.raizlabs.android.dbflow.sql.saveable.AutoIncrementModelSaver;
import com.raizlabs.android.dbflow.sql.saveable.ModelSaver;
import com.raizlabs.android.dbflow.structure.ModelAdapter;
import com.raizlabs.android.dbflow.structure.database.DatabaseStatement;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.FlowCursor;

public final class VideoUpload_Table extends ModelAdapter<VideoUpload> {
    public static final IProperty[] ALL_COLUMN_PROPERTIES = new IProperty[]{id, requestId, filePath, title, subreddit, uploadUrl, posterUrl, thumbnail, videoKey, timestamp, status, gif, attempts, originalDuration, duration, source, uploadDuration, uploadError, videoWidth, videoHeight};
    public static final Property<Integer> attempts = new Property(VideoUpload.class, "attempts");
    public static final Property<Integer> duration = new Property(VideoUpload.class, State.KEY_DURATION);
    public static final Property<String> filePath = new Property(VideoUpload.class, "filePath");
    public static final Property<Boolean> gif = new Property(VideoUpload.class, "gif");
    public static final Property<Integer> id = new Property(VideoUpload.class, "id");
    public static final Property<Integer> originalDuration = new Property(VideoUpload.class, "originalDuration");
    public static final Property<String> posterUrl = new Property(VideoUpload.class, "posterUrl");
    public static final Property<String> requestId = new Property(VideoUpload.class, "requestId");
    public static final Property<String> source = new Property(VideoUpload.class, "source");
    public static final Property<Integer> status = new Property(VideoUpload.class, "status");
    public static final Property<String> subreddit = new Property(VideoUpload.class, "subreddit");
    public static final Property<String> thumbnail = new Property(VideoUpload.class, "thumbnail");
    public static final Property<Long> timestamp = new Property(VideoUpload.class, "timestamp");
    public static final Property<String> title = new Property(VideoUpload.class, "title");
    public static final Property<Long> uploadDuration = new Property(VideoUpload.class, "uploadDuration");
    public static final Property<String> uploadError = new Property(VideoUpload.class, "uploadError");
    public static final Property<String> uploadUrl = new Property(VideoUpload.class, "uploadUrl");
    public static final Property<Integer> videoHeight = new Property(VideoUpload.class, "videoHeight");
    public static final Property<String> videoKey = new Property(VideoUpload.class, "videoKey");
    public static final Property<Integer> videoWidth = new Property(VideoUpload.class, "videoWidth");

    public final String getAutoIncrementingColumnName() {
        return "id";
    }

    public final String getCompiledStatementQuery() {
        return "INSERT INTO `video_upload`(`id`,`requestId`,`filePath`,`title`,`subreddit`,`uploadUrl`,`posterUrl`,`thumbnail`,`videoKey`,`timestamp`,`status`,`gif`,`attempts`,`originalDuration`,`duration`,`source`,`uploadDuration`,`uploadError`,`videoWidth`,`videoHeight`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }

    public final String getCreationQuery() {
        return "CREATE TABLE IF NOT EXISTS `video_upload`(`id` INTEGER PRIMARY KEY AUTOINCREMENT, `requestId` TEXT, `filePath` TEXT, `title` TEXT, `subreddit` TEXT, `uploadUrl` TEXT, `posterUrl` TEXT, `thumbnail` TEXT, `videoKey` TEXT, `timestamp` INTEGER, `status` INTEGER, `gif` INTEGER, `attempts` INTEGER, `originalDuration` INTEGER, `duration` INTEGER, `source` TEXT, `uploadDuration` INTEGER, `uploadError` TEXT, `videoWidth` INTEGER, `videoHeight` INTEGER)";
    }

    public final String getDeleteStatementQuery() {
        return "DELETE FROM `video_upload` WHERE `id`=?";
    }

    public final String getInsertStatementQuery() {
        return "INSERT INTO `video_upload`(`requestId`,`filePath`,`title`,`subreddit`,`uploadUrl`,`posterUrl`,`thumbnail`,`videoKey`,`timestamp`,`status`,`gif`,`attempts`,`originalDuration`,`duration`,`source`,`uploadDuration`,`uploadError`,`videoWidth`,`videoHeight`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }

    public final String getTableName() {
        return "`video_upload`";
    }

    public final String getUpdateStatementQuery() {
        return "UPDATE `video_upload` SET `id`=?,`requestId`=?,`filePath`=?,`title`=?,`subreddit`=?,`uploadUrl`=?,`posterUrl`=?,`thumbnail`=?,`videoKey`=?,`timestamp`=?,`status`=?,`gif`=?,`attempts`=?,`originalDuration`=?,`duration`=?,`source`=?,`uploadDuration`=?,`uploadError`=?,`videoWidth`=?,`videoHeight`=? WHERE `id`=?";
    }

    public final /* synthetic */ void bindToContentValues(ContentValues contentValues, Object obj) {
        VideoUpload videoUpload = (VideoUpload) obj;
        contentValues.put("`id`", Integer.valueOf(videoUpload.id));
        m20727a(contentValues, videoUpload);
    }

    public final /* synthetic */ void bindToDeleteStatement(DatabaseStatement databaseStatement, Object obj) {
        databaseStatement.bindLong(1, (long) ((VideoUpload) obj).id);
    }

    public final /* synthetic */ void bindToInsertStatement(DatabaseStatement databaseStatement, Object obj, int i) {
        m20728a(databaseStatement, (VideoUpload) obj, i);
    }

    public final /* synthetic */ void bindToInsertValues(ContentValues contentValues, Object obj) {
        m20727a(contentValues, (VideoUpload) obj);
    }

    public final /* synthetic */ void bindToStatement(DatabaseStatement databaseStatement, Object obj) {
        VideoUpload videoUpload = (VideoUpload) obj;
        databaseStatement.bindLong(1, (long) videoUpload.id);
        m20728a(databaseStatement, videoUpload, 1);
    }

    public final /* synthetic */ void bindToUpdateStatement(DatabaseStatement databaseStatement, Object obj) {
        VideoUpload videoUpload = (VideoUpload) obj;
        databaseStatement.bindLong(1, (long) videoUpload.id);
        databaseStatement.bindStringOrNull(2, videoUpload.requestId);
        databaseStatement.bindStringOrNull(3, videoUpload.filePath);
        databaseStatement.bindStringOrNull(4, videoUpload.title);
        databaseStatement.bindStringOrNull(5, videoUpload.subreddit);
        databaseStatement.bindStringOrNull(6, videoUpload.uploadUrl);
        databaseStatement.bindStringOrNull(7, videoUpload.posterUrl);
        databaseStatement.bindStringOrNull(8, videoUpload.thumbnail);
        databaseStatement.bindStringOrNull(9, videoUpload.videoKey);
        databaseStatement.bindLong(10, videoUpload.timestamp);
        databaseStatement.bindLong(11, (long) videoUpload.status);
        databaseStatement.bindLong(12, videoUpload.gif ? 1 : 0);
        databaseStatement.bindLong(13, (long) videoUpload.attempts);
        databaseStatement.bindLong(14, (long) videoUpload.originalDuration);
        databaseStatement.bindLong(15, (long) videoUpload.duration);
        databaseStatement.bindStringOrNull(16, videoUpload.source);
        databaseStatement.bindLong(17, videoUpload.uploadDuration);
        databaseStatement.bindStringOrNull(18, videoUpload.uploadError);
        databaseStatement.bindLong(19, (long) videoUpload.videoWidth);
        databaseStatement.bindLong(20, (long) videoUpload.videoHeight);
        databaseStatement.bindLong(21, (long) videoUpload.id);
    }

    public final /* synthetic */ boolean exists(Object obj, DatabaseWrapper databaseWrapper) {
        if (((VideoUpload) obj).id > 0) {
            if (SQLite.selectCountOf(new IProperty[0]).from(VideoUpload.class).where(m20726a(r5)).hasData(databaseWrapper) != null) {
                return true;
            }
        }
        return false;
    }

    public final /* synthetic */ Number getAutoIncrementingId(Object obj) {
        return Integer.valueOf(((VideoUpload) obj).id);
    }

    public final /* synthetic */ OperatorGroup getPrimaryConditionClause(Object obj) {
        return m20726a((VideoUpload) obj);
    }

    public final /* synthetic */ void loadFromCursor(FlowCursor flowCursor, Object obj) {
        VideoUpload videoUpload = (VideoUpload) obj;
        videoUpload.id = flowCursor.getIntOrDefault("id");
        videoUpload.requestId = flowCursor.getStringOrDefault("requestId");
        videoUpload.filePath = flowCursor.getStringOrDefault("filePath");
        videoUpload.title = flowCursor.getStringOrDefault("title");
        videoUpload.subreddit = flowCursor.getStringOrDefault("subreddit");
        videoUpload.uploadUrl = flowCursor.getStringOrDefault("uploadUrl");
        videoUpload.posterUrl = flowCursor.getStringOrDefault("posterUrl");
        videoUpload.thumbnail = flowCursor.getStringOrDefault("thumbnail");
        videoUpload.videoKey = flowCursor.getStringOrDefault("videoKey");
        videoUpload.timestamp = flowCursor.getLongOrDefault("timestamp");
        videoUpload.status = flowCursor.getIntOrDefault("status");
        int columnIndex = flowCursor.getColumnIndex("gif");
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            videoUpload.gif = false;
        } else {
            videoUpload.gif = flowCursor.getBoolean(columnIndex);
        }
        videoUpload.attempts = flowCursor.getIntOrDefault("attempts");
        videoUpload.originalDuration = flowCursor.getIntOrDefault("originalDuration");
        videoUpload.duration = flowCursor.getIntOrDefault(State.KEY_DURATION);
        videoUpload.source = flowCursor.getStringOrDefault("source");
        videoUpload.uploadDuration = flowCursor.getLongOrDefault("uploadDuration");
        videoUpload.uploadError = flowCursor.getStringOrDefault("uploadError");
        videoUpload.videoWidth = flowCursor.getIntOrDefault("videoWidth");
        videoUpload.videoHeight = flowCursor.getIntOrDefault("videoHeight");
    }

    public final /* synthetic */ void updateAutoIncrement(Object obj, Number number) {
        ((VideoUpload) obj).id = number.intValue();
    }

    public VideoUpload_Table(DatabaseDefinition databaseDefinition) {
        super(databaseDefinition);
    }

    public final Class<VideoUpload> getModelClass() {
        return VideoUpload.class;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.raizlabs.android.dbflow.sql.language.property.Property getProperty(java.lang.String r2) {
        /*
        r1 = this;
        r2 = com.raizlabs.android.dbflow.sql.QueryBuilder.quoteIfNeeded(r2);
        r0 = r2.hashCode();
        switch(r0) {
            case -2091056562: goto L_0x00e0;
            case -2040410758: goto L_0x00d5;
            case -1862712805: goto L_0x00ca;
            case -1741252738: goto L_0x00bf;
            case -1572445848: goto L_0x00b5;
            case -951678254: goto L_0x00ab;
            case -671549962: goto L_0x00a1;
            case -352752484: goto L_0x0096;
            case -192637671: goto L_0x008b;
            case 2964037: goto L_0x0081;
            case 91830652: goto L_0x0075;
            case 653920085: goto L_0x0069;
            case 986697964: goto L_0x005d;
            case 1000276586: goto L_0x0051;
            case 1278850143: goto L_0x0046;
            case 1423111198: goto L_0x003b;
            case 1523242978: goto L_0x0030;
            case 1549786091: goto L_0x0024;
            case 1883166036: goto L_0x0019;
            case 2079158085: goto L_0x000d;
            default: goto L_0x000b;
        };
    L_0x000b:
        goto L_0x00eb;
    L_0x000d:
        r0 = "`source`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00eb;
    L_0x0015:
        r2 = 15;
        goto L_0x00ec;
    L_0x0019:
        r0 = "`thumbnail`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00eb;
    L_0x0021:
        r2 = 7;
        goto L_0x00ec;
    L_0x0024:
        r0 = "`uploadDuration`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00eb;
    L_0x002c:
        r2 = 16;
        goto L_0x00ec;
    L_0x0030:
        r0 = "`subreddit`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00eb;
    L_0x0038:
        r2 = 4;
        goto L_0x00ec;
    L_0x003b:
        r0 = "`posterUrl`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00eb;
    L_0x0043:
        r2 = 6;
        goto L_0x00ec;
    L_0x0046:
        r0 = "`filePath`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00eb;
    L_0x004e:
        r2 = 2;
        goto L_0x00ec;
    L_0x0051:
        r0 = "`timestamp`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00eb;
    L_0x0059:
        r2 = 9;
        goto L_0x00ec;
    L_0x005d:
        r0 = "`duration`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00eb;
    L_0x0065:
        r2 = 14;
        goto L_0x00ec;
    L_0x0069:
        r0 = "`videoWidth`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00eb;
    L_0x0071:
        r2 = 18;
        goto L_0x00ec;
    L_0x0075:
        r0 = "`gif`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00eb;
    L_0x007d:
        r2 = 11;
        goto L_0x00ec;
    L_0x0081:
        r0 = "`id`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00eb;
    L_0x0089:
        r2 = 0;
        goto L_0x00ec;
    L_0x008b:
        r0 = "`uploadError`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00eb;
    L_0x0093:
        r2 = 17;
        goto L_0x00ec;
    L_0x0096:
        r0 = "`videoKey`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00eb;
    L_0x009e:
        r2 = 8;
        goto L_0x00ec;
    L_0x00a1:
        r0 = "`requestId`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00eb;
    L_0x00a9:
        r2 = 1;
        goto L_0x00ec;
    L_0x00ab:
        r0 = "`uploadUrl`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00eb;
    L_0x00b3:
        r2 = 5;
        goto L_0x00ec;
    L_0x00b5:
        r0 = "`title`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00eb;
    L_0x00bd:
        r2 = 3;
        goto L_0x00ec;
    L_0x00bf:
        r0 = "`videoHeight`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00eb;
    L_0x00c7:
        r2 = 19;
        goto L_0x00ec;
    L_0x00ca:
        r0 = "`originalDuration`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00eb;
    L_0x00d2:
        r2 = 13;
        goto L_0x00ec;
    L_0x00d5:
        r0 = "`attempts`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00eb;
    L_0x00dd:
        r2 = 12;
        goto L_0x00ec;
    L_0x00e0:
        r0 = "`status`";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00eb;
    L_0x00e8:
        r2 = 10;
        goto L_0x00ec;
    L_0x00eb:
        r2 = -1;
    L_0x00ec:
        switch(r2) {
            case 0: goto L_0x0130;
            case 1: goto L_0x012d;
            case 2: goto L_0x012a;
            case 3: goto L_0x0127;
            case 4: goto L_0x0124;
            case 5: goto L_0x0121;
            case 6: goto L_0x011e;
            case 7: goto L_0x011b;
            case 8: goto L_0x0118;
            case 9: goto L_0x0115;
            case 10: goto L_0x0112;
            case 11: goto L_0x010f;
            case 12: goto L_0x010c;
            case 13: goto L_0x0109;
            case 14: goto L_0x0106;
            case 15: goto L_0x0103;
            case 16: goto L_0x0100;
            case 17: goto L_0x00fd;
            case 18: goto L_0x00fa;
            case 19: goto L_0x00f7;
            default: goto L_0x00ef;
        };
    L_0x00ef:
        r2 = new java.lang.IllegalArgumentException;
        r0 = "Invalid column name passed. Ensure you are calling the correct table's column";
        r2.<init>(r0);
        throw r2;
    L_0x00f7:
        r2 = videoHeight;
        return r2;
    L_0x00fa:
        r2 = videoWidth;
        return r2;
    L_0x00fd:
        r2 = uploadError;
        return r2;
    L_0x0100:
        r2 = uploadDuration;
        return r2;
    L_0x0103:
        r2 = source;
        return r2;
    L_0x0106:
        r2 = duration;
        return r2;
    L_0x0109:
        r2 = originalDuration;
        return r2;
    L_0x010c:
        r2 = attempts;
        return r2;
    L_0x010f:
        r2 = gif;
        return r2;
    L_0x0112:
        r2 = status;
        return r2;
    L_0x0115:
        r2 = timestamp;
        return r2;
    L_0x0118:
        r2 = videoKey;
        return r2;
    L_0x011b:
        r2 = thumbnail;
        return r2;
    L_0x011e:
        r2 = posterUrl;
        return r2;
    L_0x0121:
        r2 = uploadUrl;
        return r2;
    L_0x0124:
        r2 = subreddit;
        return r2;
    L_0x0127:
        r2 = title;
        return r2;
    L_0x012a:
        r2 = filePath;
        return r2;
    L_0x012d:
        r2 = requestId;
        return r2;
    L_0x0130:
        r2 = id;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.datalibrary.frontpage.requests.models.v1.VideoUpload_Table.getProperty(java.lang.String):com.raizlabs.android.dbflow.sql.language.property.Property");
    }

    public final ModelSaver<VideoUpload> createSingleModelSaver() {
        return new AutoIncrementModelSaver();
    }

    public final IProperty[] getAllColumnProperties() {
        return ALL_COLUMN_PROPERTIES;
    }

    private static void m20727a(ContentValues contentValues, VideoUpload videoUpload) {
        contentValues.put("`requestId`", videoUpload.requestId);
        contentValues.put("`filePath`", videoUpload.filePath);
        contentValues.put("`title`", videoUpload.title);
        contentValues.put("`subreddit`", videoUpload.subreddit);
        contentValues.put("`uploadUrl`", videoUpload.uploadUrl);
        contentValues.put("`posterUrl`", videoUpload.posterUrl);
        contentValues.put("`thumbnail`", videoUpload.thumbnail);
        contentValues.put("`videoKey`", videoUpload.videoKey);
        contentValues.put("`timestamp`", Long.valueOf(videoUpload.timestamp));
        contentValues.put("`status`", Integer.valueOf(videoUpload.status));
        contentValues.put("`gif`", Integer.valueOf(videoUpload.gif));
        contentValues.put("`attempts`", Integer.valueOf(videoUpload.attempts));
        contentValues.put("`originalDuration`", Integer.valueOf(videoUpload.originalDuration));
        contentValues.put("`duration`", Integer.valueOf(videoUpload.duration));
        contentValues.put("`source`", videoUpload.source);
        contentValues.put("`uploadDuration`", Long.valueOf(videoUpload.uploadDuration));
        contentValues.put("`uploadError`", videoUpload.uploadError);
        contentValues.put("`videoWidth`", Integer.valueOf(videoUpload.videoWidth));
        contentValues.put("`videoHeight`", Integer.valueOf(videoUpload.videoHeight));
    }

    private static void m20728a(DatabaseStatement databaseStatement, VideoUpload videoUpload, int i) {
        databaseStatement.bindStringOrNull(1 + i, videoUpload.requestId);
        databaseStatement.bindStringOrNull(2 + i, videoUpload.filePath);
        databaseStatement.bindStringOrNull(3 + i, videoUpload.title);
        databaseStatement.bindStringOrNull(4 + i, videoUpload.subreddit);
        databaseStatement.bindStringOrNull(5 + i, videoUpload.uploadUrl);
        databaseStatement.bindStringOrNull(6 + i, videoUpload.posterUrl);
        databaseStatement.bindStringOrNull(7 + i, videoUpload.thumbnail);
        databaseStatement.bindStringOrNull(8 + i, videoUpload.videoKey);
        databaseStatement.bindLong(9 + i, videoUpload.timestamp);
        databaseStatement.bindLong(10 + i, (long) videoUpload.status);
        databaseStatement.bindLong(11 + i, videoUpload.gif ? 1 : 0);
        databaseStatement.bindLong(12 + i, (long) videoUpload.attempts);
        databaseStatement.bindLong(13 + i, (long) videoUpload.originalDuration);
        databaseStatement.bindLong(14 + i, (long) videoUpload.duration);
        databaseStatement.bindStringOrNull(15 + i, videoUpload.source);
        databaseStatement.bindLong(16 + i, videoUpload.uploadDuration);
        databaseStatement.bindStringOrNull(17 + i, videoUpload.uploadError);
        databaseStatement.bindLong(18 + i, (long) videoUpload.videoWidth);
        databaseStatement.bindLong(19 + i, (long) videoUpload.videoHeight);
    }

    private static OperatorGroup m20726a(VideoUpload videoUpload) {
        OperatorGroup clause = OperatorGroup.clause();
        clause.and(id.eq(Integer.valueOf(videoUpload.id)));
        return clause;
    }

    public final /* synthetic */ Object newInstance() {
        return new VideoUpload();
    }
}
