package io.fabric.sdk.android.services.settings;

public class SettingsData {
    public final AppSettingsData f24924a;
    public final SessionSettingsData f24925b;
    public final PromptSettingsData f24926c;
    public final FeaturesSettingsData f24927d;
    public final AnalyticsSettingsData f24928e;
    public final BetaSettingsData f24929f;
    public final long f24930g;
    public final int f24931h;
    public final int f24932i;

    public SettingsData(long j, AppSettingsData appSettingsData, SessionSettingsData sessionSettingsData, PromptSettingsData promptSettingsData, FeaturesSettingsData featuresSettingsData, AnalyticsSettingsData analyticsSettingsData, BetaSettingsData betaSettingsData, int i, int i2) {
        this.f24930g = j;
        this.f24924a = appSettingsData;
        this.f24925b = sessionSettingsData;
        this.f24926c = promptSettingsData;
        this.f24927d = featuresSettingsData;
        this.f24931h = i;
        this.f24932i = i2;
        this.f24928e = analyticsSettingsData;
        this.f24929f = betaSettingsData;
    }
}
