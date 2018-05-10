package com.instabug.library.internal.storage.cache;

import com.instabug.library.model.AssetEntity;
import com.instabug.library.util.InstabugSDKLogger;

public class AssetCache extends InMemoryCache<String, AssetEntity> {
    public AssetCache(String str) {
        super(str);
    }

    public void invalidate() {
        for (AssetEntity assetEntity : getValues()) {
            StringBuilder stringBuilder = new StringBuilder("Delete file: ");
            stringBuilder.append(assetEntity.getFile().getPath());
            stringBuilder.append(",");
            stringBuilder.append(assetEntity.getFile().delete());
            InstabugSDKLogger.m8356d(AssetsCacheManager.class, stringBuilder.toString());
        }
        super.invalidate();
    }
}
