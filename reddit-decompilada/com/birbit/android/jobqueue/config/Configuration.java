package com.birbit.android.jobqueue.config;

import android.content.Context;
import com.birbit.android.jobqueue.DefaultQueueFactory;
import com.birbit.android.jobqueue.QueueFactory;
import com.birbit.android.jobqueue.di.DependencyInjector;
import com.birbit.android.jobqueue.log.CustomLogger;
import com.birbit.android.jobqueue.log.JqLog.ErrorLogger;
import com.birbit.android.jobqueue.network.NetworkUtil;
import com.birbit.android.jobqueue.network.NetworkUtilImpl;
import com.birbit.android.jobqueue.scheduling.Scheduler;
import com.birbit.android.jobqueue.timer.SystemTimer;
import com.birbit.android.jobqueue.timer.Timer;
import java.util.concurrent.ThreadFactory;
import java.util.regex.Pattern;

public class Configuration {
    public String f2964a;
    public int f2965b;
    public int f2966c;
    public int f2967d;
    public int f2968e;
    public Context f2969f;
    public QueueFactory f2970g;
    public DependencyInjector f2971h;
    public NetworkUtil f2972i;
    public CustomLogger f2973j;
    public Timer f2974k;
    public Scheduler f2975l;
    public boolean f2976m;
    public boolean f2977n;
    public int f2978o;
    public boolean f2979p;
    public ThreadFactory f2980q;

    public static final class Builder {
        private Pattern f2962a = Pattern.compile("^([A-Za-z]|[0-9]|_|-)+$");
        private Configuration f2963b = new Configuration();

        public Builder(Context context) {
            this.f2963b.f2969f = context.getApplicationContext();
        }

        public final Builder m2546a() {
            this.f2963b.f2967d = 120;
            return this;
        }

        public final Builder m2548b() {
            this.f2963b.f2965b = 3;
            return this;
        }

        public final Builder m2549c() {
            this.f2963b.f2966c = 1;
            return this;
        }

        public final Builder m2547a(CustomLogger customLogger) {
            this.f2963b.f2973j = customLogger;
            return this;
        }

        public final Builder m2550d() {
            this.f2963b.f2968e = 3;
            return this;
        }

        public final Configuration m2551e() {
            if (this.f2963b.f2970g == null) {
                this.f2963b.f2970g = new DefaultQueueFactory();
            }
            if (this.f2963b.f2972i == null) {
                this.f2963b.f2972i = new NetworkUtilImpl(this.f2963b.f2969f);
            }
            if (this.f2963b.f2974k == null) {
                this.f2963b.f2974k = new SystemTimer();
            }
            return this.f2963b;
        }
    }

    private Configuration() {
        this.f2964a = "default_job_manager";
        this.f2965b = 5;
        this.f2966c = 0;
        this.f2967d = 15;
        this.f2968e = 3;
        this.f2973j = new ErrorLogger();
        this.f2976m = false;
        this.f2977n = false;
        this.f2978o = 5;
        this.f2979p = true;
        this.f2980q = null;
    }
}
