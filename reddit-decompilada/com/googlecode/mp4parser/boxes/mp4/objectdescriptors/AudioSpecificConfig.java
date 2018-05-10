package com.googlecode.mp4parser.boxes.mp4.objectdescriptors;

import com.coremedia.iso.Hex;
import io.fabric.sdk.android.services.events.EventsFilesManager;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Descriptor(a = {5}, b = 64)
public class AudioSpecificConfig extends BaseDescriptor {
    public static Map<Integer, Integer> f15132a = new HashMap();
    public static Map<Integer, String> f15133b = new HashMap();
    public int f15134A;
    public int f15135B;
    public boolean f15136C;
    public boolean f15137D;
    public boolean f15138E;
    public int f15139F;
    public boolean f15140G;
    public int f15141H;
    public int f15142I;
    public int f15143J;
    public int f15144K;
    public int f15145L;
    public int f15146M;
    public int f15147N;
    public int f15148O;
    public int f15149P;
    public int f15150Q;
    public int f15151R;
    public int f15152S;
    public int f15153T;
    public int f15154U;
    public boolean f15155V;
    byte[] f15156W;
    boolean f15157X;
    public ELDSpecificConfig f15158c;
    public int f15159d;
    public int f15160e;
    public int f15161f;
    public int f15162g;
    public int f15163h;
    public int f15164i;
    public boolean f15165j;
    public boolean f15166k;
    public int f15167l;
    public int f15168m;
    public int f15169n;
    public int f15170o;
    public int f15171p;
    public int f15172q;
    public int f15173r;
    public int f15174s;
    public int f15175t;
    public int f15176u;
    public int f15177v;
    public int f15178w;
    public int f15179x;
    public int f15180y;
    public int f15181z;

    public class ELDSpecificConfig {
        public boolean f8948a;
        public boolean f8949b;
        public boolean f8950c;
        public boolean f8951d;
        public boolean f8952e;
        public boolean f8953f;
        public boolean f8954g;
        final /* synthetic */ AudioSpecificConfig f8955h;

        public ELDSpecificConfig(AudioSpecificConfig audioSpecificConfig, int i, BitReaderBuffer bitReaderBuffer) {
            this.f8955h = audioSpecificConfig;
            this.f8948a = bitReaderBuffer.m7684a();
            this.f8949b = bitReaderBuffer.m7684a();
            this.f8950c = bitReaderBuffer.m7684a();
            this.f8951d = bitReaderBuffer.m7684a();
            this.f8952e = bitReaderBuffer.m7684a();
            if (this.f8952e != null) {
                this.f8953f = bitReaderBuffer.m7684a();
                this.f8954g = bitReaderBuffer.m7684a();
                m7676a(i, bitReaderBuffer);
            }
            while (bitReaderBuffer.m7683a(4) != 0) {
                audioSpecificConfig = bitReaderBuffer.m7683a(4);
                int i2 = 0;
                if (audioSpecificConfig == 15) {
                    i = bitReaderBuffer.m7683a(8);
                    audioSpecificConfig += i;
                } else {
                    i = 0;
                }
                if (i == 255) {
                    audioSpecificConfig += bitReaderBuffer.m7683a(16);
                }
                while (i2 < audioSpecificConfig) {
                    bitReaderBuffer.m7683a(8);
                    i2++;
                }
            }
        }

        private void m7676a(int i, BitReaderBuffer bitReaderBuffer) {
            int i2 = 0;
            switch (i) {
                case 1:
                case 2:
                    i = 1;
                    break;
                case 3:
                    i = 2;
                    break;
                case 4:
                case 5:
                case 6:
                    i = 3;
                    break;
                case 7:
                    i = 4;
                    break;
                default:
                    i = 0;
                    break;
            }
            while (i2 < i) {
                sbr_header com_googlecode_mp4parser_boxes_mp4_objectdescriptors_AudioSpecificConfig_sbr_header = new sbr_header(this.f8955h, bitReaderBuffer);
                i2++;
            }
        }
    }

    public class sbr_header {
        public boolean f8956a;
        public int f8957b;
        public int f8958c;
        public int f8959d;
        public int f8960e;
        public boolean f8961f;
        public boolean f8962g;
        public int f8963h;
        public boolean f8964i;
        public int f8965j;
        public int f8966k;
        public int f8967l;
        public boolean f8968m;
        public boolean f8969n;
        final /* synthetic */ AudioSpecificConfig f8970o;

        public sbr_header(AudioSpecificConfig audioSpecificConfig, BitReaderBuffer bitReaderBuffer) {
            this.f8970o = audioSpecificConfig;
            this.f8956a = bitReaderBuffer.m7684a();
            this.f8957b = bitReaderBuffer.m7683a(4);
            this.f8958c = bitReaderBuffer.m7683a(4);
            this.f8959d = bitReaderBuffer.m7683a(3);
            this.f8960e = bitReaderBuffer.m7683a(2);
            this.f8961f = bitReaderBuffer.m7684a();
            this.f8962g = bitReaderBuffer.m7684a();
            if (this.f8961f) {
                this.f8963h = bitReaderBuffer.m7683a(2);
                this.f8964i = bitReaderBuffer.m7684a();
                this.f8965j = bitReaderBuffer.m7683a(2);
            }
            if (this.f8962g) {
                this.f8966k = bitReaderBuffer.m7683a(2);
                this.f8967l = bitReaderBuffer.m7683a(2);
                this.f8968m = bitReaderBuffer.m7684a();
            }
            this.f8969n = bitReaderBuffer.m7684a();
        }
    }

    static {
        f15132a.put(Integer.valueOf(0), Integer.valueOf(96000));
        f15132a.put(Integer.valueOf(1), Integer.valueOf(88200));
        f15132a.put(Integer.valueOf(2), Integer.valueOf(64000));
        f15132a.put(Integer.valueOf(3), Integer.valueOf(48000));
        f15132a.put(Integer.valueOf(4), Integer.valueOf(44100));
        f15132a.put(Integer.valueOf(5), Integer.valueOf(32000));
        f15132a.put(Integer.valueOf(6), Integer.valueOf(24000));
        f15132a.put(Integer.valueOf(7), Integer.valueOf(22050));
        f15132a.put(Integer.valueOf(8), Integer.valueOf(16000));
        f15132a.put(Integer.valueOf(9), Integer.valueOf(12000));
        f15132a.put(Integer.valueOf(10), Integer.valueOf(11025));
        f15132a.put(Integer.valueOf(11), Integer.valueOf(EventsFilesManager.MAX_BYTE_SIZE_PER_FILE));
        f15133b.put(Integer.valueOf(1), "AAC main");
        f15133b.put(Integer.valueOf(2), "AAC LC");
        f15133b.put(Integer.valueOf(3), "AAC SSR");
        f15133b.put(Integer.valueOf(4), "AAC LTP");
        f15133b.put(Integer.valueOf(5), "SBR");
        f15133b.put(Integer.valueOf(6), "AAC Scalable");
        f15133b.put(Integer.valueOf(7), "TwinVQ");
        f15133b.put(Integer.valueOf(8), "CELP");
        f15133b.put(Integer.valueOf(9), "HVXC");
        f15133b.put(Integer.valueOf(10), "(reserved)");
        f15133b.put(Integer.valueOf(11), "(reserved)");
        f15133b.put(Integer.valueOf(12), "TTSI");
        f15133b.put(Integer.valueOf(13), "Main synthetic");
        f15133b.put(Integer.valueOf(14), "Wavetable synthesis");
        f15133b.put(Integer.valueOf(15), "General MIDI");
        f15133b.put(Integer.valueOf(16), "Algorithmic Synthesis and Audio FX");
        f15133b.put(Integer.valueOf(17), "ER AAC LC");
        f15133b.put(Integer.valueOf(18), "(reserved)");
        f15133b.put(Integer.valueOf(19), "ER AAC LTP");
        f15133b.put(Integer.valueOf(20), "ER AAC Scalable");
        f15133b.put(Integer.valueOf(21), "ER TwinVQ");
        f15133b.put(Integer.valueOf(22), "ER BSAC");
        f15133b.put(Integer.valueOf(23), "ER AAC LD");
        f15133b.put(Integer.valueOf(24), "ER CELP");
        f15133b.put(Integer.valueOf(25), "ER HVXC");
        f15133b.put(Integer.valueOf(26), "ER HILN");
        f15133b.put(Integer.valueOf(27), "ER Parametric");
        f15133b.put(Integer.valueOf(28), "SSC");
        f15133b.put(Integer.valueOf(29), "PS");
        f15133b.put(Integer.valueOf(30), "MPEG Surround");
        f15133b.put(Integer.valueOf(31), "(escape)");
        f15133b.put(Integer.valueOf(32), "Layer-1");
        f15133b.put(Integer.valueOf(33), "Layer-2");
        f15133b.put(Integer.valueOf(34), "Layer-3");
        f15133b.put(Integer.valueOf(35), "DST");
        f15133b.put(Integer.valueOf(36), "ALS");
        f15133b.put(Integer.valueOf(37), "SLS");
        f15133b.put(Integer.valueOf(38), "SLS non-core");
        f15133b.put(Integer.valueOf(39), "ER AAC ELD");
        f15133b.put(Integer.valueOf(40), "SMR Simple");
        f15133b.put(Integer.valueOf(41), "SMR Main");
    }

    public AudioSpecificConfig() {
        this.f15167l = -1;
        this.f15174s = -1;
        this.f15175t = -1;
        this.f15176u = -1;
        this.f15157X = false;
        this.Y = 5;
    }

    public final void mo2524a(ByteBuffer byteBuffer) throws IOException {
        int i;
        int i2;
        this.f15157X = true;
        ByteBuffer slice = byteBuffer.slice();
        slice.limit(this.Z);
        byteBuffer.position(byteBuffer.position() + this.Z);
        this.f15156W = new byte[this.Z];
        slice.get(this.f15156W);
        slice.rewind();
        BitReaderBuffer bitReaderBuffer = new BitReaderBuffer(slice);
        int a = m15152a(bitReaderBuffer);
        this.f15159d = a;
        this.f15160e = a;
        this.f15161f = bitReaderBuffer.m7683a(4);
        if (this.f15161f == 15) {
            this.f15162g = bitReaderBuffer.m7683a(24);
        }
        this.f15163h = bitReaderBuffer.m7683a(4);
        if (this.f15159d != 5) {
            if (this.f15159d != 29) {
                this.f15164i = 0;
                switch (this.f15159d) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 6:
                    case 7:
                    case 17:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        i = this.f15163h;
                        i2 = this.f15159d;
                        this.f15177v = bitReaderBuffer.m7683a(1);
                        this.f15178w = bitReaderBuffer.m7683a(1);
                        if (this.f15178w == 1) {
                            this.f15179x = bitReaderBuffer.m7683a(14);
                        }
                        this.f15180y = bitReaderBuffer.m7683a(1);
                        if (i == 0) {
                            if (i2 == 6 || i2 == 20) {
                                this.f15181z = bitReaderBuffer.m7683a(3);
                            }
                            if (this.f15180y == 1) {
                                if (i2 == 22) {
                                    this.f15134A = bitReaderBuffer.m7683a(5);
                                    this.f15135B = bitReaderBuffer.m7683a(11);
                                }
                                if (i2 == 17 || i2 == 19 || i2 == 20 || i2 == 23) {
                                    this.f15136C = bitReaderBuffer.m7684a();
                                    this.f15137D = bitReaderBuffer.m7684a();
                                    this.f15138E = bitReaderBuffer.m7684a();
                                }
                                this.f15139F = bitReaderBuffer.m7683a(1);
                                if (this.f15139F == 1) {
                                    throw new RuntimeException("not yet implemented");
                                }
                            }
                            this.f15140G = true;
                            break;
                        }
                        throw new UnsupportedOperationException("can't parse program_config_element yet");
                    case 8:
                        throw new UnsupportedOperationException("can't parse CelpSpecificConfig yet");
                    case 9:
                        throw new UnsupportedOperationException("can't parse HvxcSpecificConfig yet");
                    case 12:
                        throw new UnsupportedOperationException("can't parse TTSSpecificConfig yet");
                    case 13:
                    case 14:
                    case 15:
                    case 16:
                        throw new UnsupportedOperationException("can't parse StructuredAudioSpecificConfig yet");
                    case 24:
                        throw new UnsupportedOperationException("can't parse ErrorResilientCelpSpecificConfig yet");
                    case 25:
                        throw new UnsupportedOperationException("can't parse ErrorResilientHvxcSpecificConfig yet");
                    case 26:
                    case 27:
                        this.f15141H = bitReaderBuffer.m7683a(1);
                        if (this.f15141H != 1) {
                            this.f15153T = bitReaderBuffer.m7683a(1);
                            if (this.f15153T == 1) {
                                this.f15154U = bitReaderBuffer.m7683a(2);
                                break;
                            }
                        }
                        this.f15142I = bitReaderBuffer.m7683a(2);
                        if (this.f15142I != 1) {
                            this.f15144K = bitReaderBuffer.m7683a(1);
                            this.f15145L = bitReaderBuffer.m7683a(2);
                            this.f15146M = bitReaderBuffer.m7683a(1);
                            if (this.f15146M == 1) {
                                this.f15147N = bitReaderBuffer.m7683a(1);
                            }
                        }
                        if (this.f15142I != 0) {
                            this.f15148O = bitReaderBuffer.m7683a(1);
                            this.f15149P = bitReaderBuffer.m7683a(8);
                            this.f15150Q = bitReaderBuffer.m7683a(4);
                            this.f15151R = bitReaderBuffer.m7683a(12);
                            this.f15152S = bitReaderBuffer.m7683a(2);
                        }
                        this.f15143J = bitReaderBuffer.m7683a(1);
                        this.f15155V = true;
                        break;
                        break;
                    case 28:
                        throw new UnsupportedOperationException("can't parse SSCSpecificConfig yet");
                    case 30:
                        this.f15170o = bitReaderBuffer.m7683a(1);
                        throw new UnsupportedOperationException("can't parse SpatialSpecificConfig yet");
                    case 32:
                    case 33:
                    case 34:
                        throw new UnsupportedOperationException("can't parse MPEG_1_2_SpecificConfig yet");
                    case 35:
                        throw new UnsupportedOperationException("can't parse DSTSpecificConfig yet");
                    case 36:
                        this.f15171p = bitReaderBuffer.m7683a(5);
                        throw new UnsupportedOperationException("can't parse ALSSpecificConfig yet");
                    case 37:
                    case 38:
                        throw new UnsupportedOperationException("can't parse SLSSpecificConfig yet");
                    case 39:
                        this.f15158c = new ELDSpecificConfig(this, this.f15163h, bitReaderBuffer);
                        break;
                    case 40:
                    case 41:
                        throw new UnsupportedOperationException("can't parse SymbolicMusicSpecificConfig yet");
                    default:
                        break;
                }
                i = this.f15159d;
                if (!(i == 17 || i == 39)) {
                    switch (i) {
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 26:
                        case 27:
                            break;
                        default:
                            break;
                    }
                }
                this.f15172q = bitReaderBuffer.m7683a(2);
                if (this.f15172q != 2) {
                    if (this.f15172q == 3) {
                        if (this.f15172q == 3) {
                            this.f15173r = bitReaderBuffer.m7683a(1);
                            if (this.f15173r == 0) {
                                throw new RuntimeException("not implemented");
                            }
                        }
                        if (this.f15164i != 5 && bitReaderBuffer.m7685b() >= 16) {
                            int a2 = bitReaderBuffer.m7683a(11);
                            this.f15174s = a2;
                            this.f15176u = a2;
                            if (this.f15174s == 695) {
                                this.f15164i = m15152a(bitReaderBuffer);
                                if (this.f15164i == 5) {
                                    this.f15165j = bitReaderBuffer.m7684a();
                                    if (this.f15165j) {
                                        this.f15167l = bitReaderBuffer.m7683a(4);
                                        if (this.f15167l == 15) {
                                            this.f15168m = bitReaderBuffer.m7683a(24);
                                        }
                                        if (bitReaderBuffer.m7685b() >= 12) {
                                            a2 = bitReaderBuffer.m7683a(11);
                                            this.f15174s = a2;
                                            this.f15175t = a2;
                                            if (this.f15174s == 1352) {
                                                this.f15166k = bitReaderBuffer.m7684a();
                                            }
                                        }
                                    }
                                }
                                if (this.f15164i == 22) {
                                    this.f15165j = bitReaderBuffer.m7684a();
                                    if (this.f15165j) {
                                        this.f15167l = bitReaderBuffer.m7683a(4);
                                        if (this.f15167l == 15) {
                                            this.f15168m = bitReaderBuffer.m7683a(24);
                                        }
                                    }
                                    this.f15169n = bitReaderBuffer.m7683a(4);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
                throw new UnsupportedOperationException("can't parse ErrorProtectionSpecificConfig yet");
            }
        }
        this.f15164i = 5;
        this.f15165j = true;
        if (this.f15159d == 29) {
            this.f15166k = true;
        }
        this.f15167l = bitReaderBuffer.m7683a(4);
        if (this.f15167l == 15) {
            this.f15168m = bitReaderBuffer.m7683a(24);
        }
        this.f15159d = m15152a(bitReaderBuffer);
        if (this.f15159d == 22) {
            this.f15169n = bitReaderBuffer.m7683a(4);
        }
        switch (this.f15159d) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 6:
            case 7:
            case 17:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                i = this.f15163h;
                i2 = this.f15159d;
                this.f15177v = bitReaderBuffer.m7683a(1);
                this.f15178w = bitReaderBuffer.m7683a(1);
                if (this.f15178w == 1) {
                    this.f15179x = bitReaderBuffer.m7683a(14);
                }
                this.f15180y = bitReaderBuffer.m7683a(1);
                if (i == 0) {
                    this.f15181z = bitReaderBuffer.m7683a(3);
                    if (this.f15180y == 1) {
                        if (i2 == 22) {
                            this.f15134A = bitReaderBuffer.m7683a(5);
                            this.f15135B = bitReaderBuffer.m7683a(11);
                            break;
                        }
                        this.f15136C = bitReaderBuffer.m7684a();
                        this.f15137D = bitReaderBuffer.m7684a();
                        this.f15138E = bitReaderBuffer.m7684a();
                        this.f15139F = bitReaderBuffer.m7683a(1);
                        if (this.f15139F == 1) {
                            throw new RuntimeException("not yet implemented");
                        }
                    }
                    this.f15140G = true;
                    break;
                }
                throw new UnsupportedOperationException("can't parse program_config_element yet");
            case 8:
                throw new UnsupportedOperationException("can't parse CelpSpecificConfig yet");
            case 9:
                throw new UnsupportedOperationException("can't parse HvxcSpecificConfig yet");
            case 12:
                throw new UnsupportedOperationException("can't parse TTSSpecificConfig yet");
            case 13:
            case 14:
            case 15:
            case 16:
                throw new UnsupportedOperationException("can't parse StructuredAudioSpecificConfig yet");
            case 24:
                throw new UnsupportedOperationException("can't parse ErrorResilientCelpSpecificConfig yet");
            case 25:
                throw new UnsupportedOperationException("can't parse ErrorResilientHvxcSpecificConfig yet");
            case 26:
            case 27:
                this.f15141H = bitReaderBuffer.m7683a(1);
                if (this.f15141H != 1) {
                    this.f15142I = bitReaderBuffer.m7683a(2);
                    if (this.f15142I != 1) {
                        this.f15144K = bitReaderBuffer.m7683a(1);
                        this.f15145L = bitReaderBuffer.m7683a(2);
                        this.f15146M = bitReaderBuffer.m7683a(1);
                        if (this.f15146M == 1) {
                            this.f15147N = bitReaderBuffer.m7683a(1);
                        }
                    }
                    if (this.f15142I != 0) {
                        this.f15148O = bitReaderBuffer.m7683a(1);
                        this.f15149P = bitReaderBuffer.m7683a(8);
                        this.f15150Q = bitReaderBuffer.m7683a(4);
                        this.f15151R = bitReaderBuffer.m7683a(12);
                        this.f15152S = bitReaderBuffer.m7683a(2);
                    }
                    this.f15143J = bitReaderBuffer.m7683a(1);
                    this.f15155V = true;
                    break;
                }
                this.f15153T = bitReaderBuffer.m7683a(1);
                if (this.f15153T == 1) {
                    this.f15154U = bitReaderBuffer.m7683a(2);
                    break;
                }
                break;
            case 28:
                throw new UnsupportedOperationException("can't parse SSCSpecificConfig yet");
            case 30:
                this.f15170o = bitReaderBuffer.m7683a(1);
                throw new UnsupportedOperationException("can't parse SpatialSpecificConfig yet");
            case 32:
            case 33:
            case 34:
                throw new UnsupportedOperationException("can't parse MPEG_1_2_SpecificConfig yet");
            case 35:
                throw new UnsupportedOperationException("can't parse DSTSpecificConfig yet");
            case 36:
                this.f15171p = bitReaderBuffer.m7683a(5);
                throw new UnsupportedOperationException("can't parse ALSSpecificConfig yet");
            case 37:
            case 38:
                throw new UnsupportedOperationException("can't parse SLSSpecificConfig yet");
            case 39:
                this.f15158c = new ELDSpecificConfig(this, this.f15163h, bitReaderBuffer);
                break;
            case 40:
            case 41:
                throw new UnsupportedOperationException("can't parse SymbolicMusicSpecificConfig yet");
            default:
                break;
        }
        i = this.f15159d;
        switch (i) {
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
                break;
            default:
                break;
        }
        this.f15172q = bitReaderBuffer.m7683a(2);
        if (this.f15172q != 2) {
            if (this.f15172q == 3) {
                if (this.f15172q == 3) {
                    this.f15173r = bitReaderBuffer.m7683a(1);
                    if (this.f15173r == 0) {
                        throw new RuntimeException("not implemented");
                    }
                }
                if (this.f15164i != 5) {
                    return;
                }
                return;
            }
        }
        throw new UnsupportedOperationException("can't parse ErrorProtectionSpecificConfig yet");
    }

    public final int mo2523a() {
        int i = (this.f15160e > 30 ? 11 : 5) + 4;
        if (this.f15161f == 15) {
            i += 24;
        }
        i += 4;
        if (this.f15159d == 5 || this.f15159d == 29) {
            i += 4;
            if (this.f15167l == 15) {
                i += 24;
            }
        }
        if (this.f15159d == 22) {
            i += 4;
        }
        if (this.f15140G) {
            int i2 = 2;
            if (this.f15178w == 1) {
                i2 = 16;
            }
            i2++;
            if (this.f15163h == 0) {
                throw new UnsupportedOperationException("can't parse program_config_element yet");
            }
            if (this.f15159d == 6 || this.f15159d == 20) {
                i2 += 3;
            }
            if (this.f15180y == 1) {
                if (this.f15159d == 22) {
                    i2 = (i2 + 5) + 11;
                }
                if (this.f15159d == 17 || this.f15159d == 19 || this.f15159d == 20 || this.f15159d == 23) {
                    i2 = ((i2 + 1) + 1) + 1;
                }
                i2++;
                if (this.f15139F == 1) {
                    throw new RuntimeException("Not implemented");
                }
            }
            i += i2;
        }
        if (this.f15176u >= 0) {
            i += 11;
            if (this.f15176u == 695) {
                i += 5;
                if (this.f15164i > 30) {
                    i += 6;
                }
                if (this.f15164i == 5) {
                    i++;
                    if (this.f15165j) {
                        i += 4;
                        if (this.f15167l == 15) {
                            i += 24;
                        }
                        if (this.f15175t >= 0) {
                            i += 11;
                            if (this.f15175t == 1352) {
                                i++;
                            }
                        }
                    }
                }
                if (this.f15164i == 22) {
                    i++;
                    if (this.f15165j) {
                        i += 4;
                        if (this.f15167l == 15) {
                            i += 24;
                        }
                    }
                    i += 4;
                }
            }
        }
        return (int) Math.ceil(((double) i) / 8.0d);
    }

    public static void m15153a(int i, BitWriterBuffer bitWriterBuffer) {
        if (i >= 32) {
            bitWriterBuffer.m7686a(31, 5);
            bitWriterBuffer.m7686a(i - 32, 6);
            return;
        }
        bitWriterBuffer.m7686a(i, 5);
    }

    private static int m15152a(BitReaderBuffer bitReaderBuffer) throws IOException {
        int a = bitReaderBuffer.m7683a(5);
        return a == 31 ? 32 + bitReaderBuffer.m7683a(6) : a;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AudioSpecificConfig");
        stringBuilder.append("{configBytes=");
        stringBuilder.append(Hex.m3277a(this.f15156W));
        stringBuilder.append(", audioObjectType=");
        stringBuilder.append(this.f15159d);
        stringBuilder.append(" (");
        stringBuilder.append((String) f15133b.get(Integer.valueOf(this.f15159d)));
        stringBuilder.append(")");
        stringBuilder.append(", samplingFrequencyIndex=");
        stringBuilder.append(this.f15161f);
        stringBuilder.append(" (");
        stringBuilder.append(f15132a.get(Integer.valueOf(this.f15161f)));
        stringBuilder.append(")");
        stringBuilder.append(", samplingFrequency=");
        stringBuilder.append(this.f15162g);
        stringBuilder.append(", channelConfiguration=");
        stringBuilder.append(this.f15163h);
        if (this.f15164i > 0) {
            stringBuilder.append(", extensionAudioObjectType=");
            stringBuilder.append(this.f15164i);
            stringBuilder.append(" (");
            stringBuilder.append((String) f15133b.get(Integer.valueOf(this.f15164i)));
            stringBuilder.append(")");
            stringBuilder.append(", sbrPresentFlag=");
            stringBuilder.append(this.f15165j);
            stringBuilder.append(", psPresentFlag=");
            stringBuilder.append(this.f15166k);
            stringBuilder.append(", extensionSamplingFrequencyIndex=");
            stringBuilder.append(this.f15167l);
            stringBuilder.append(" (");
            stringBuilder.append(f15132a.get(Integer.valueOf(this.f15167l)));
            stringBuilder.append(")");
            stringBuilder.append(", extensionSamplingFrequency=");
            stringBuilder.append(this.f15168m);
            stringBuilder.append(", extensionChannelConfiguration=");
            stringBuilder.append(this.f15169n);
        }
        stringBuilder.append(", syncExtensionType=");
        stringBuilder.append(this.f15174s);
        if (this.f15140G) {
            stringBuilder.append(", frameLengthFlag=");
            stringBuilder.append(this.f15177v);
            stringBuilder.append(", dependsOnCoreCoder=");
            stringBuilder.append(this.f15178w);
            stringBuilder.append(", coreCoderDelay=");
            stringBuilder.append(this.f15179x);
            stringBuilder.append(", extensionFlag=");
            stringBuilder.append(this.f15180y);
            stringBuilder.append(", layerNr=");
            stringBuilder.append(this.f15181z);
            stringBuilder.append(", numOfSubFrame=");
            stringBuilder.append(this.f15134A);
            stringBuilder.append(", layer_length=");
            stringBuilder.append(this.f15135B);
            stringBuilder.append(", aacSectionDataResilienceFlag=");
            stringBuilder.append(this.f15136C);
            stringBuilder.append(", aacScalefactorDataResilienceFlag=");
            stringBuilder.append(this.f15137D);
            stringBuilder.append(", aacSpectralDataResilienceFlag=");
            stringBuilder.append(this.f15138E);
            stringBuilder.append(", extensionFlag3=");
            stringBuilder.append(this.f15139F);
        }
        if (this.f15155V) {
            stringBuilder.append(", isBaseLayer=");
            stringBuilder.append(this.f15141H);
            stringBuilder.append(", paraMode=");
            stringBuilder.append(this.f15142I);
            stringBuilder.append(", paraExtensionFlag=");
            stringBuilder.append(this.f15143J);
            stringBuilder.append(", hvxcVarMode=");
            stringBuilder.append(this.f15144K);
            stringBuilder.append(", hvxcRateMode=");
            stringBuilder.append(this.f15145L);
            stringBuilder.append(", erHvxcExtensionFlag=");
            stringBuilder.append(this.f15146M);
            stringBuilder.append(", var_ScalableFlag=");
            stringBuilder.append(this.f15147N);
            stringBuilder.append(", hilnQuantMode=");
            stringBuilder.append(this.f15148O);
            stringBuilder.append(", hilnMaxNumLine=");
            stringBuilder.append(this.f15149P);
            stringBuilder.append(", hilnSampleRateCode=");
            stringBuilder.append(this.f15150Q);
            stringBuilder.append(", hilnFrameLength=");
            stringBuilder.append(this.f15151R);
            stringBuilder.append(", hilnContMode=");
            stringBuilder.append(this.f15152S);
            stringBuilder.append(", hilnEnhaLayer=");
            stringBuilder.append(this.f15153T);
            stringBuilder.append(", hilnEnhaQuantMode=");
            stringBuilder.append(this.f15154U);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                AudioSpecificConfig audioSpecificConfig = (AudioSpecificConfig) obj;
                return this.f15137D == audioSpecificConfig.f15137D && this.f15136C == audioSpecificConfig.f15136C && this.f15138E == audioSpecificConfig.f15138E && this.f15159d == audioSpecificConfig.f15159d && this.f15163h == audioSpecificConfig.f15163h && this.f15179x == audioSpecificConfig.f15179x && this.f15178w == audioSpecificConfig.f15178w && this.f15173r == audioSpecificConfig.f15173r && this.f15172q == audioSpecificConfig.f15172q && this.f15146M == audioSpecificConfig.f15146M && this.f15164i == audioSpecificConfig.f15164i && this.f15169n == audioSpecificConfig.f15169n && this.f15180y == audioSpecificConfig.f15180y && this.f15139F == audioSpecificConfig.f15139F && this.f15168m == audioSpecificConfig.f15168m && this.f15167l == audioSpecificConfig.f15167l && this.f15171p == audioSpecificConfig.f15171p && this.f15177v == audioSpecificConfig.f15177v && this.f15140G == audioSpecificConfig.f15140G && this.f15152S == audioSpecificConfig.f15152S && this.f15153T == audioSpecificConfig.f15153T && this.f15154U == audioSpecificConfig.f15154U && this.f15151R == audioSpecificConfig.f15151R && this.f15149P == audioSpecificConfig.f15149P && this.f15148O == audioSpecificConfig.f15148O && this.f15150Q == audioSpecificConfig.f15150Q && this.f15145L == audioSpecificConfig.f15145L && this.f15144K == audioSpecificConfig.f15144K && this.f15141H == audioSpecificConfig.f15141H && this.f15181z == audioSpecificConfig.f15181z && this.f15135B == audioSpecificConfig.f15135B && this.f15134A == audioSpecificConfig.f15134A && this.f15143J == audioSpecificConfig.f15143J && this.f15142I == audioSpecificConfig.f15142I && this.f15155V == audioSpecificConfig.f15155V && this.f15166k == audioSpecificConfig.f15166k && this.f15170o == audioSpecificConfig.f15170o && this.f15162g == audioSpecificConfig.f15162g && this.f15161f == audioSpecificConfig.f15161f && this.f15165j == audioSpecificConfig.f15165j && this.f15174s == audioSpecificConfig.f15174s && this.f15147N == audioSpecificConfig.f15147N && Arrays.equals(this.f15156W, audioSpecificConfig.f15156W) != null;
            }
        }
        return false;
    }

    public int hashCode() {
        return (31 * (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((this.f15156W != null ? Arrays.hashCode(this.f15156W) : 0) * 31) + this.f15159d) * 31) + this.f15161f) * 31) + this.f15162g) * 31) + this.f15163h) * 31) + this.f15164i) * 31) + this.f15165j) * 31) + this.f15166k) * 31) + this.f15167l) * 31) + this.f15168m) * 31) + this.f15169n) * 31) + this.f15170o) * 31) + this.f15171p) * 31) + this.f15172q) * 31) + this.f15173r) * 31) + this.f15174s) * 31) + this.f15177v) * 31) + this.f15178w) * 31) + this.f15179x) * 31) + this.f15180y) * 31) + this.f15181z) * 31) + this.f15134A) * 31) + this.f15135B) * 31) + this.f15136C) * 31) + this.f15137D) * 31) + this.f15138E) * 31) + this.f15139F) * 31) + this.f15140G) * 31) + this.f15141H) * 31) + this.f15142I) * 31) + this.f15143J) * 31) + this.f15144K) * 31) + this.f15145L) * 31) + this.f15146M) * 31) + this.f15147N) * 31) + this.f15148O) * 31) + this.f15149P) * 31) + this.f15150Q) * 31) + this.f15151R) * 31) + this.f15152S) * 31) + this.f15153T) * 31) + this.f15154U)) + this.f15155V;
    }
}
