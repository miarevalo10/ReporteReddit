package com.google.android.gms.internal;

import com.facebook.stetho.server.http.HttpStatus;

public final class zzchc {
    public static zzchd<Long> f6852A = zzchd.m5673a("measurement.upload.stale_data_deletion_interval", 86400000, 86400000);
    public static zzchd<Long> f6853B = zzchd.m5673a("measurement.upload.refresh_blacklisted_config_interval", 604800000, 604800000);
    public static zzchd<Long> f6854C = zzchd.m5673a("measurement.upload.initial_upload_delay_time", 15000, 15000);
    public static zzchd<Long> f6855D = zzchd.m5673a("measurement.upload.retry_time", 1800000, 1800000);
    public static zzchd<Integer> f6856E = zzchd.m5672a("measurement.upload.retry_count", 6, 6);
    public static zzchd<Long> f6857F = zzchd.m5673a("measurement.upload.max_queue_time", 2419200000L, 2419200000L);
    public static zzchd<Integer> f6858G = zzchd.m5672a("measurement.lifetimevalue.max_currency_tracked", 4, 4);
    public static zzchd<Integer> f6859H = zzchd.m5672a("measurement.audience.filter_result_max_count", (int) HttpStatus.HTTP_OK, (int) HttpStatus.HTTP_OK);
    public static zzchd<Long> f6860I = zzchd.m5673a("measurement.service_client.idle_disconnect_millis", 5000, 5000);
    private static zzchd<Boolean> f6861J = zzchd.m5675a("measurement.service_enabled", true, true);
    private static zzchd<Boolean> f6862K = zzchd.m5675a("measurement.service_client_enabled", true, true);
    private static zzchd<Boolean> f6863L = zzchd.m5675a("measurement.log_third_party_store_events_enabled", false, false);
    private static zzchd<Boolean> f6864M = zzchd.m5675a("measurement.log_installs_enabled", false, false);
    private static zzchd<Boolean> f6865N = zzchd.m5675a("measurement.log_upgrades_enabled", false, false);
    private static zzchd<Boolean> f6866O = zzchd.m5675a("measurement.log_androidId_enabled", false, false);
    public static zzchd<Boolean> f6867a = zzchd.m5675a("measurement.upload_dsid_enabled", false, false);
    public static zzchd<Boolean> f6868b = zzchd.m5675a("measurement.event_sampling_enabled", false, false);
    public static zzchd<String> f6869c = zzchd.m5674a("measurement.log_tag", "FA", "FA-SVC");
    public static zzchd<Long> f6870d = zzchd.m5673a("measurement.ad_id_cache_time", 10000, 10000);
    public static zzchd<Long> f6871e = zzchd.m5673a("measurement.monitoring.sample_period_millis", 86400000, 86400000);
    public static zzchd<Long> f6872f = zzchd.m5673a("measurement.config.cache_time", 86400000, 3600000);
    public static zzchd<String> f6873g;
    public static zzchd<String> f6874h;
    public static zzchd<Integer> f6875i = zzchd.m5672a("measurement.upload.max_bundles", 100, 100);
    public static zzchd<Integer> f6876j = zzchd.m5672a("measurement.upload.max_batch_size", 65536, 65536);
    public static zzchd<Integer> f6877k = zzchd.m5672a("measurement.upload.max_bundle_size", 65536, 65536);
    public static zzchd<Integer> f6878l = zzchd.m5672a("measurement.upload.max_events_per_bundle", 1000, 1000);
    public static zzchd<Integer> f6879m = zzchd.m5672a("measurement.upload.max_events_per_day", 100000, 100000);
    public static zzchd<Integer> f6880n = zzchd.m5672a("measurement.upload.max_error_events_per_day", 1000, 1000);
    public static zzchd<Integer> f6881o = zzchd.m5672a("measurement.upload.max_public_events_per_day", 50000, 50000);
    public static zzchd<Integer> f6882p = zzchd.m5672a("measurement.upload.max_conversions_per_day", 500, 500);
    public static zzchd<Integer> f6883q = zzchd.m5672a("measurement.upload.max_realtime_events_per_day", 10, 10);
    public static zzchd<Integer> f6884r = zzchd.m5672a("measurement.store.max_stored_events_per_app", 100000, 100000);
    public static zzchd<String> f6885s;
    public static zzchd<Long> f6886t = zzchd.m5673a("measurement.upload.backoff_period", 43200000, 43200000);
    public static zzchd<Long> f6887u = zzchd.m5673a("measurement.upload.window_interval", 3600000, 3600000);
    public static zzchd<Long> f6888v = zzchd.m5673a("measurement.upload.interval", 3600000, 3600000);
    public static zzchd<Long> f6889w = zzchd.m5673a("measurement.upload.realtime_upload_interval", 10000, 10000);
    public static zzchd<Long> f6890x = zzchd.m5673a("measurement.upload.debug_upload_interval", 1000, 1000);
    public static zzchd<Long> f6891y = zzchd.m5673a("measurement.upload.minimum_delay", 500, 500);
    public static zzchd<Long> f6892z = zzchd.m5673a("measurement.alarm_manager.minimum_interval", 60000, 60000);

    static {
        String str = "https";
        f6873g = zzchd.m5674a("measurement.config.url_scheme", str, str);
        str = "app-measurement.com";
        f6874h = zzchd.m5674a("measurement.config.url_authority", str, str);
        str = "https://app-measurement.com/a";
        f6885s = zzchd.m5674a("measurement.upload.url", str, str);
    }
}
