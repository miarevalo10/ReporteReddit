package com.google.android.gms.internal;

import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.internal.zzffu.zzg;
import java.io.IOException;

public final class zziu {

    public static final class zza extends zzffu<zza, zza> implements zzfhg {
        private static final zza f19719a;
        private static volatile zzfhk<zza> f19720b;

        public enum zzb implements zzfga {
            UNKNOWN_EVENT_TYPE(0),
            AD_REQUEST(1),
            AD_LOADED(2),
            AD_FAILED_TO_LOAD(3),
            AD_FAILED_TO_LOAD_NO_FILL(4),
            AD_IMPRESSION(5),
            AD_FIRST_CLICK(6),
            AD_SUBSEQUENT_CLICK(7),
            REQUEST_WILL_START(8),
            REQUEST_DID_END(9),
            REQUEST_WILL_UPDATE_SIGNALS(10),
            REQUEST_DID_UPDATE_SIGNALS(11),
            REQUEST_WILL_BUILD_URL(12),
            REQUEST_DID_BUILD_URL(13),
            REQUEST_WILL_MAKE_NETWORK_REQUEST(14),
            REQUEST_DID_RECEIVE_NETWORK_RESPONSE(15),
            REQUEST_WILL_PROCESS_RESPONSE(16),
            REQUEST_DID_PROCESS_RESPONSE(17),
            REQUEST_WILL_RENDER(18),
            REQUEST_DID_RENDER(19),
            REQUEST_WILL_UPDATE_GMS_SIGNALS(1000),
            REQUEST_DID_UPDATE_GMS_SIGNALS(CredentialsApi.ACTIVITY_RESULT_OTHER_ACCOUNT),
            REQUEST_FAILED_TO_UPDATE_GMS_SIGNALS(1002),
            REQUEST_FAILED_TO_BUILD_URL(1003),
            REQUEST_FAILED_TO_MAKE_NETWORK_REQUEST(1004),
            REQUEST_FAILED_TO_PROCESS_RESPONSE(1005);
            
            private static final zzfgb<zzb> f14515B = null;
            final int f14542f;

            static {
                f14515B = new zziw();
            }

            private zzb(int i) {
                this.f14542f = i;
            }

            public final int mo1865a() {
                return this.f14542f;
            }
        }

        public static final class zza extends com.google.android.gms.internal.zzffu.zza<zza, zza> implements zzfhg {
            private zza() {
                super(zza.f19719a);
            }
        }

        private zza() {
        }

        public final void mo4039a(zzffg com_google_android_gms_internal_zzffg) throws IOException {
            this.g.m6090a(com_google_android_gms_internal_zzffg);
        }

        public final int mo4040c() {
            int i = this.h;
            if (i != -1) {
                return i;
            }
            i = 0 + this.g.m6093c();
            this.h = i;
            return i;
        }

        protected final Object mo4293a(int i, Object obj, Object obj2) {
            byte b = (byte) 0;
            switch (zziv.f7730a[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return f19719a;
                case 3:
                    return null;
                case 4:
                    return new zza();
                case 5:
                    return this;
                case 6:
                    zzffb com_google_android_gms_internal_zzffb = (zzffb) obj;
                    if (((zzffm) obj2) != null) {
                        while (b == (byte) 0) {
                            try {
                                i = com_google_android_gms_internal_zzffb.mo1878a();
                                if (i == 0 || m20442a(i, com_google_android_gms_internal_zzffb) == 0) {
                                    b = (byte) 1;
                                }
                            } catch (int i2) {
                                i2.f7422a = this;
                                throw new RuntimeException(i2);
                            } catch (int i22) {
                                obj2 = new zzfge(i22.getMessage());
                                obj2.f7422a = this;
                                throw new RuntimeException(obj2);
                            }
                        }
                        break;
                    }
                    throw new NullPointerException();
                    break;
                case 7:
                    break;
                case 8:
                    if (f19720b == 0) {
                        synchronized (zza.class) {
                            if (f19720b == null) {
                                f19720b = new com.google.android.gms.internal.zzffu.zzb(f19719a);
                            }
                        }
                    }
                    return f19720b;
                case 9:
                    return Byte.valueOf((byte) 1);
                case 10:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
            return f19719a;
        }

        static {
            zzffu com_google_android_gms_internal_zziu_zza = new zza();
            f19719a = com_google_android_gms_internal_zziu_zza;
            com_google_android_gms_internal_zziu_zza.mo4293a(zzg.f7408f, null, null);
            com_google_android_gms_internal_zziu_zza.f19235g.f7470e = false;
        }
    }
}
