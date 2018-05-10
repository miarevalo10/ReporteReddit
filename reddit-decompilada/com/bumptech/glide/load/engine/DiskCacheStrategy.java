package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;

public abstract class DiskCacheStrategy {
    public static final DiskCacheStrategy f3410a = new C10581();
    public static final DiskCacheStrategy f3411b = new C10592();
    public static final DiskCacheStrategy f3412c = new C10603();
    public static final DiskCacheStrategy f3413d = new C10614();
    public static final DiskCacheStrategy f3414e = new C10625();

    class C10581 extends DiskCacheStrategy {
        public final boolean mo912a() {
            return true;
        }

        public final boolean mo915b() {
            return true;
        }

        C10581() {
        }

        public final boolean mo913a(DataSource dataSource) {
            return dataSource == DataSource.REMOTE ? true : null;
        }

        public final boolean mo914a(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return (dataSource == DataSource.RESOURCE_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
        }
    }

    class C10592 extends DiskCacheStrategy {
        public final boolean mo912a() {
            return false;
        }

        public final boolean mo913a(DataSource dataSource) {
            return false;
        }

        public final boolean mo914a(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return false;
        }

        public final boolean mo915b() {
            return false;
        }

        C10592() {
        }
    }

    class C10603 extends DiskCacheStrategy {
        public final boolean mo912a() {
            return false;
        }

        public final boolean mo914a(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return false;
        }

        public final boolean mo915b() {
            return true;
        }

        C10603() {
        }

        public final boolean mo913a(DataSource dataSource) {
            return (dataSource == DataSource.DATA_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? null : true;
        }
    }

    class C10614 extends DiskCacheStrategy {
        public final boolean mo912a() {
            return true;
        }

        public final boolean mo913a(DataSource dataSource) {
            return false;
        }

        public final boolean mo915b() {
            return false;
        }

        C10614() {
        }

        public final boolean mo914a(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return (dataSource == DataSource.RESOURCE_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
        }
    }

    class C10625 extends DiskCacheStrategy {
        public final boolean mo912a() {
            return true;
        }

        public final boolean mo915b() {
            return true;
        }

        C10625() {
        }

        public final boolean mo913a(DataSource dataSource) {
            return dataSource == DataSource.REMOTE ? true : null;
        }

        public final boolean mo914a(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return ((z && dataSource == DataSource.DATA_DISK_CACHE) || dataSource == DataSource.LOCAL) && encodeStrategy == EncodeStrategy.TRANSFORMED;
        }
    }

    public abstract boolean mo912a();

    public abstract boolean mo913a(DataSource dataSource);

    public abstract boolean mo914a(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy);

    public abstract boolean mo915b();
}
