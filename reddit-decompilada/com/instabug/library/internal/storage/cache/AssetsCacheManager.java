package com.instabug.library.internal.storage.cache;

import android.content.Context;
import android.os.Environment;
import com.instabug.library.model.AssetEntity;
import com.instabug.library.model.AssetEntity.AssetType;
import com.instabug.library.network.Request.Callbacks;
import com.instabug.library.network.p026a.C0743b;
import com.instabug.library.util.InstabugSDKLogger;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import rx.Subscription;

@SuppressFBWarnings({"RV_RETURN_VALUE_IGNORED_BAD_PRACTICE"})
public class AssetsCacheManager {
    private static final String ASSETS_MEMORY_CACHE_KEY = "assets_memory_cache";
    private static LinkedHashMap<String, C0681a> currentDownloadingFiles = new LinkedHashMap();

    public interface OnDownloadFinished {
        void onFailed(Throwable th);

        void onSuccess(AssetEntity assetEntity);
    }

    public static class C0681a {
        public AssetEntity f9612a;
        public Subscription f9613b;
        public List<OnDownloadFinished> f9614c = new ArrayList();
    }

    public static AssetCache getCache() {
        if (!CacheManager.getInstance().cacheExists(ASSETS_MEMORY_CACHE_KEY)) {
            InstabugSDKLogger.m8356d(AssetsCacheManager.class, "In-memory assets cache not found, create it");
            CacheManager.getInstance().addCache(new AssetCache(ASSETS_MEMORY_CACHE_KEY));
            InstabugSDKLogger.m8356d(AssetsCacheManager.class, "In-memory assets created successfully");
        }
        InstabugSDKLogger.m8356d(AssetsCacheManager.class, "In-memory assets cache found");
        return (AssetCache) CacheManager.getInstance().getCache(ASSETS_MEMORY_CACHE_KEY);
    }

    public static AssetEntity createEmptyEntity(Context context, String str, AssetType assetType) {
        return new AssetEntity(String.valueOf(str.hashCode()), assetType, str, new File(getCashDirectory(context), String.valueOf(str.hashCode())));
    }

    public static void getAssetEntity(Context context, AssetEntity assetEntity, OnDownloadFinished onDownloadFinished) {
        AssetCache cache = getCache();
        AssetEntity assetEntity2 = cache != null ? (AssetEntity) cache.get(assetEntity.getKey()) : null;
        if (assetEntity2 != null) {
            InstabugSDKLogger.m8356d(AssetsCacheManager.class, "Get file from cache");
            onDownloadFinished.onSuccess(assetEntity2);
        } else if (isDownloading(assetEntity.getKey())) {
            InstabugSDKLogger.m8356d(AssetsCacheManager.class, "File currently downloading, wait download to finish");
            waitDownloadToFinish(assetEntity, onDownloadFinished);
        } else {
            InstabugSDKLogger.m8356d(AssetsCacheManager.class, "File not exist download it");
            downloadAssetEntity(context, assetEntity, onDownloadFinished);
        }
    }

    public static void downloadAssetEntity(Context context, final AssetEntity assetEntity, OnDownloadFinished onDownloadFinished) {
        C0681a c0681a = new C0681a();
        c0681a.f9612a = assetEntity;
        List list = c0681a.f9614c;
        list.add(onDownloadFinished);
        c0681a.f9614c = list;
        c0681a.f9613b = C0743b.m8306a().m8307a(context, assetEntity, new Callbacks<AssetEntity, Throwable>() {
            public final /* synthetic */ void onFailed(Object obj) {
                Throwable th = (Throwable) obj;
                InstabugSDKLogger.m8358e(this, "downloading asset entity got error: ", th);
                AssetsCacheManager.notifyDownloadFailed(assetEntity, th);
            }

            public final /* synthetic */ void onSucceeded(Object obj) {
                AssetEntity assetEntity = (AssetEntity) obj;
                AssetsCacheManager.addAssetEntity(assetEntity);
                AssetsCacheManager.notifyDownloadFinishedSuccessfully(assetEntity);
            }
        });
        currentDownloadingFiles.put(c0681a.f9612a.getKey(), c0681a);
    }

    public static void addAssetEntity(AssetEntity assetEntity) {
        AssetCache cache = getCache();
        if (cache != null) {
            cache.put(assetEntity.getKey(), assetEntity);
        }
    }

    public static boolean isDownloading(String str) {
        return currentDownloadingFiles.get(str) != null ? true : null;
    }

    public static void waitDownloadToFinish(AssetEntity assetEntity, OnDownloadFinished onDownloadFinished) {
        List list = ((C0681a) currentDownloadingFiles.get(assetEntity.getKey())).f9614c;
        list.add(onDownloadFinished);
        ((C0681a) currentDownloadingFiles.get(assetEntity.getKey())).f9614c = list;
    }

    public static void notifyDownloadFinishedSuccessfully(AssetEntity assetEntity) {
        for (OnDownloadFinished onDownloadFinished : ((C0681a) currentDownloadingFiles.get(assetEntity.getKey())).f9614c) {
            if (onDownloadFinished != null) {
                onDownloadFinished.onSuccess(assetEntity);
                currentDownloadingFiles.remove(assetEntity.getKey());
            }
        }
    }

    public static void notifyDownloadFailed(AssetEntity assetEntity, Throwable th) {
        for (OnDownloadFinished onDownloadFinished : ((C0681a) currentDownloadingFiles.get(assetEntity.getKey())).f9614c) {
            if (onDownloadFinished != null) {
                onDownloadFinished.onFailed(th);
                currentDownloadingFiles.remove(assetEntity.getKey());
            }
        }
    }

    public static void stopRunningDownloads() {
        for (Entry value : currentDownloadingFiles.entrySet()) {
            ((C0681a) value.getValue()).f9613b.c();
        }
        currentDownloadingFiles.clear();
    }

    public static void clearRedundantFiles(Context context) {
        context = getCashDirectory(context).listFiles();
        if (context != null) {
            for (File delete : context) {
                delete.delete();
            }
        }
    }

    public static void cleanUpCache(Context context) {
        stopRunningDownloads();
        if (CacheManager.getInstance().cacheExists(ASSETS_MEMORY_CACHE_KEY)) {
            Cache cache = CacheManager.getInstance().getCache(ASSETS_MEMORY_CACHE_KEY);
            if (cache != null) {
                cache.invalidate();
            }
        }
        clearRedundantFiles(context);
    }

    public static File getCashDirectory(Context context) {
        if (!Environment.getExternalStorageState().equals("mounted") || context.getExternalCacheDir() == null) {
            InstabugSDKLogger.m8356d(AssetsCacheManager.class, "External storage not available, saving file to internal storage.");
            context = context.getCacheDir().getAbsolutePath();
        } else {
            InstabugSDKLogger.m8356d(AssetsCacheManager.class, "Media Mounted");
            context = context.getExternalCacheDir().getPath();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context);
        stringBuilder.append("/instabug/assetCache");
        File file = new File(stringBuilder.toString());
        if (file.exists() == null) {
            context = file.mkdirs();
            StringBuilder stringBuilder2 = new StringBuilder("Is created: ");
            stringBuilder2.append(context);
            InstabugSDKLogger.m8356d(AssetsCacheManager.class, stringBuilder2.toString());
            try {
                new File(file, ".nomedia").createNewFile();
            } catch (Context context2) {
                context2.printStackTrace();
            }
        }
        return file;
    }
}
