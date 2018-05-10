package com.google.android.exoplayer2.extractor.mp4;

import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmInitData.SchemeData;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekMap.Unseekable;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.TrackOutput.CryptoData;
import com.google.android.exoplayer2.text.cea.CeaUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;
import com.google.android.gms.ads.AdRequest;
import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.UUID;
import org.jcodec.codecs.mpeg12.MPEGConst;

public final class FragmentedMp4Extractor implements Extractor {
    public static final ExtractorsFactory f12950a = new C11311();
    private static final int f12951b = Util.m4326g("seig");
    private static final byte[] f12952c = new byte[]{(byte) -94, (byte) 57, (byte) 79, (byte) 82, (byte) 90, (byte) -101, (byte) 79, (byte) 20, (byte) -94, (byte) 68, (byte) 108, (byte) 66, (byte) 124, (byte) 100, (byte) -115, (byte) -12};
    private int f12953A;
    private int f12954B;
    private int f12955C;
    private boolean f12956D;
    private ExtractorOutput f12957E;
    private TrackOutput f12958F;
    private TrackOutput[] f12959G;
    private boolean f12960H;
    private final int f12961d;
    private final Track f12962e;
    private final SparseArray<TrackBundle> f12963f;
    private final ParsableByteArray f12964g;
    private final ParsableByteArray f12965h;
    private final ParsableByteArray f12966i;
    private final ParsableByteArray f12967j;
    private final ParsableByteArray f12968k;
    private final TimestampAdjuster f12969l;
    private final ParsableByteArray f12970m;
    private final byte[] f12971n;
    private final Stack<ContainerAtom> f12972o;
    private final LinkedList<MetadataSampleInfo> f12973p;
    private int f12974q;
    private int f12975r;
    private long f12976s;
    private int f12977t;
    private ParsableByteArray f12978u;
    private long f12979v;
    private int f12980w;
    private long f12981x;
    private long f12982y;
    private TrackBundle f12983z;

    private static final class MetadataSampleInfo {
        public final long f4409a;
        public final int f4410b;

        public MetadataSampleInfo(long j, int i) {
            this.f4409a = j;
            this.f4410b = i;
        }
    }

    private static final class TrackBundle {
        public final TrackFragment f4411a = new TrackFragment();
        public final TrackOutput f4412b;
        public Track f4413c;
        public DefaultSampleValues f4414d;
        public int f4415e;
        public int f4416f;
        public int f4417g;

        public TrackBundle(TrackOutput trackOutput) {
            this.f4412b = trackOutput;
        }

        public final void m3807a(Track track, DefaultSampleValues defaultSampleValues) {
            this.f4413c = (Track) Assertions.m4182a((Object) track);
            this.f4414d = (DefaultSampleValues) Assertions.m4182a((Object) defaultSampleValues);
            this.f4412b.mo1345a(track.f4458f);
            m3806a();
        }

        public final void m3806a() {
            TrackFragment trackFragment = this.f4411a;
            trackFragment.f4473e = 0;
            trackFragment.f4487s = 0;
            trackFragment.f4481m = false;
            trackFragment.f4486r = false;
            trackFragment.f4483o = null;
            this.f4415e = 0;
            this.f4417g = 0;
            this.f4416f = 0;
        }
    }

    static class C11311 implements ExtractorsFactory {
        C11311() {
        }

        public final Extractor[] mo1342a() {
            return new Extractor[]{new FragmentedMp4Extractor()};
        }
    }

    public FragmentedMp4Extractor() {
        this(0);
    }

    public FragmentedMp4Extractor(int i) {
        this(i, null);
    }

    public FragmentedMp4Extractor(int i, TimestampAdjuster timestampAdjuster) {
        this(i, timestampAdjuster, null);
    }

    public FragmentedMp4Extractor(int i, TimestampAdjuster timestampAdjuster, Track track) {
        this.f12961d = i | (track != null ? 16 : 0);
        this.f12969l = timestampAdjuster;
        this.f12962e = track;
        this.f12970m = new ParsableByteArray(16);
        this.f12964g = new ParsableByteArray(NalUnitUtil.f5248a);
        this.f12965h = new ParsableByteArray(5);
        this.f12966i = new ParsableByteArray();
        this.f12967j = new ParsableByteArray(1);
        this.f12968k = new ParsableByteArray();
        this.f12971n = new byte[16];
        this.f12972o = new Stack();
        this.f12973p = new LinkedList();
        this.f12963f = new SparseArray();
        this.f12981x = -9223372036854775807L;
        this.f12982y = -9223372036854775807L;
        m12092a();
    }

    public final boolean mo1353a(ExtractorInput extractorInput) throws IOException, InterruptedException {
        return Sniffer.m3816a(extractorInput);
    }

    public final void mo1352a(ExtractorOutput extractorOutput) {
        this.f12957E = extractorOutput;
        if (this.f12962e != null) {
            TrackBundle trackBundle = new TrackBundle(extractorOutput.mo1415a(0, this.f12962e.f4454b));
            trackBundle.m3807a(this.f12962e, new DefaultSampleValues(0, 0, 0, 0));
            this.f12963f.put(0, trackBundle);
            m12096b();
            this.f12957E.mo1416a();
        }
    }

    public final void mo1351a(long j, long j2) {
        j = this.f12963f.size();
        for (j2 = 0; j2 < j; j2++) {
            ((TrackBundle) this.f12963f.valueAt(j2)).m3806a();
        }
        this.f12973p.clear();
        this.f12980w = 0;
        this.f12972o.clear();
        m12092a();
    }

    public final int mo1350a(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException, InterruptedException {
        FragmentedMp4Extractor fragmentedMp4Extractor = this;
        ExtractorInput extractorInput2 = extractorInput;
        while (true) {
            FragmentedMp4Extractor fragmentedMp4Extractor2;
            ExtractorInput extractorInput3;
            int i = 4;
            TrackBundle trackBundle = null;
            int i2;
            int size;
            int i3;
            int i4;
            ParsableByteArray parsableByteArray;
            int a;
            TrackFragment trackFragment;
            switch (fragmentedMp4Extractor.f12974q) {
                case 0:
                    long d;
                    fragmentedMp4Extractor2 = fragmentedMp4Extractor;
                    extractorInput3 = extractorInput2;
                    if (fragmentedMp4Extractor2.f12977t == 0) {
                        i2 = 0;
                        if (extractorInput3.mo1333a(fragmentedMp4Extractor2.f12970m.f5256a, 0, 8, true)) {
                            fragmentedMp4Extractor2.f12977t = 8;
                            fragmentedMp4Extractor2.f12970m.m4249c(0);
                            fragmentedMp4Extractor2.f12976s = fragmentedMp4Extractor2.f12970m.m4257h();
                            fragmentedMp4Extractor2.f12975r = fragmentedMp4Extractor2.f12970m.m4259j();
                        } else if (i2 == 0) {
                            return -1;
                        }
                    }
                    if (fragmentedMp4Extractor2.f12976s == 1) {
                        extractorInput3.mo1336b(fragmentedMp4Extractor2.f12970m.f5256a, 8, 8);
                        fragmentedMp4Extractor2.f12977t += 8;
                        fragmentedMp4Extractor2.f12976s = fragmentedMp4Extractor2.f12970m.m4265p();
                    } else if (fragmentedMp4Extractor2.f12976s == 0) {
                        d = extractorInput.mo1341d();
                        if (d == -1 && !fragmentedMp4Extractor2.f12972o.isEmpty()) {
                            d = ((ContainerAtom) fragmentedMp4Extractor2.f12972o.peek()).aQ;
                        }
                        if (d != -1) {
                            fragmentedMp4Extractor2.f12976s = (d - extractorInput.mo1338c()) + ((long) fragmentedMp4Extractor2.f12977t);
                        }
                    }
                    if (fragmentedMp4Extractor2.f12976s < ((long) fragmentedMp4Extractor2.f12977t)) {
                        throw new ParserException("Atom size less than header length (unsupported).");
                    }
                    d = extractorInput.mo1338c() - ((long) fragmentedMp4Extractor2.f12977t);
                    if (fragmentedMp4Extractor2.f12975r == Atom.f4334K) {
                        size = fragmentedMp4Extractor2.f12963f.size();
                        for (i3 = 0; i3 < size; i3++) {
                            TrackFragment trackFragment2 = ((TrackBundle) fragmentedMp4Extractor2.f12963f.valueAt(i3)).f4411a;
                            trackFragment2.f4470b = d;
                            trackFragment2.f4472d = d;
                            trackFragment2.f4471c = d;
                        }
                    }
                    if (fragmentedMp4Extractor2.f12975r == Atom.f4357h) {
                        fragmentedMp4Extractor2.f12983z = null;
                        fragmentedMp4Extractor2.f12979v = d + fragmentedMp4Extractor2.f12976s;
                        if (!fragmentedMp4Extractor2.f12960H) {
                            fragmentedMp4Extractor2.f12957E.mo1417a(new Unseekable(fragmentedMp4Extractor2.f12981x));
                            fragmentedMp4Extractor2.f12960H = true;
                        }
                        fragmentedMp4Extractor2.f12974q = 2;
                    } else {
                        Object obj;
                        i4 = fragmentedMp4Extractor2.f12975r;
                        if (!(i4 == Atom.f4325B || i4 == Atom.f4327D || i4 == Atom.f4328E || i4 == Atom.f4329F || i4 == Atom.f4330G || i4 == Atom.f4334K || i4 == Atom.f4335L || i4 == Atom.f4336M)) {
                            if (i4 != Atom.f4339P) {
                                obj = null;
                                if (obj == null) {
                                    d = (extractorInput.mo1338c() + fragmentedMp4Extractor2.f12976s) - 8;
                                    fragmentedMp4Extractor2.f12972o.add(new ContainerAtom(fragmentedMp4Extractor2.f12975r, d));
                                    if (fragmentedMp4Extractor2.f12976s != ((long) fragmentedMp4Extractor2.f12977t)) {
                                        fragmentedMp4Extractor2.m12093a(d);
                                    } else {
                                        m12092a();
                                    }
                                } else {
                                    i4 = fragmentedMp4Extractor2.f12975r;
                                    if (!(i4 == Atom.f4342S || i4 == Atom.f4341R || i4 == Atom.f4326C || i4 == Atom.f4324A || i4 == Atom.f4343T || i4 == Atom.f4372w || i4 == Atom.f4373x || i4 == Atom.f4338O || i4 == Atom.f4374y || i4 == Atom.f4375z || i4 == Atom.f4344U || i4 == Atom.ac || i4 == Atom.ad || i4 == Atom.ah || i4 == Atom.ag || i4 == Atom.ae || i4 == Atom.af || i4 == Atom.f4340Q || i4 == Atom.f4337N)) {
                                        if (i4 == Atom.aG) {
                                            obj = null;
                                            if (obj == null) {
                                                if (fragmentedMp4Extractor2.f12977t == 8) {
                                                    throw new ParserException("Leaf atom defines extended atom size (unsupported).");
                                                } else if (fragmentedMp4Extractor2.f12976s <= 2147483647L) {
                                                    throw new ParserException("Leaf atom with length > 2147483647 (unsupported).");
                                                } else {
                                                    fragmentedMp4Extractor2.f12978u = new ParsableByteArray((int) fragmentedMp4Extractor2.f12976s);
                                                    System.arraycopy(fragmentedMp4Extractor2.f12970m.f5256a, 0, fragmentedMp4Extractor2.f12978u.f5256a, 0, 8);
                                                    fragmentedMp4Extractor2.f12974q = 1;
                                                }
                                            } else if (fragmentedMp4Extractor2.f12976s <= 2147483647L) {
                                                throw new ParserException("Skipping atom with length > 2147483647 (unsupported).");
                                            } else {
                                                fragmentedMp4Extractor2.f12978u = null;
                                                fragmentedMp4Extractor2.f12974q = 1;
                                            }
                                        }
                                    }
                                    obj = 1;
                                    if (obj == null) {
                                        if (fragmentedMp4Extractor2.f12976s <= 2147483647L) {
                                            fragmentedMp4Extractor2.f12978u = null;
                                            fragmentedMp4Extractor2.f12974q = 1;
                                        } else {
                                            throw new ParserException("Skipping atom with length > 2147483647 (unsupported).");
                                        }
                                    } else if (fragmentedMp4Extractor2.f12977t == 8) {
                                        throw new ParserException("Leaf atom defines extended atom size (unsupported).");
                                    } else if (fragmentedMp4Extractor2.f12976s <= 2147483647L) {
                                        fragmentedMp4Extractor2.f12978u = new ParsableByteArray((int) fragmentedMp4Extractor2.f12976s);
                                        System.arraycopy(fragmentedMp4Extractor2.f12970m.f5256a, 0, fragmentedMp4Extractor2.f12978u.f5256a, 0, 8);
                                        fragmentedMp4Extractor2.f12974q = 1;
                                    } else {
                                        throw new ParserException("Leaf atom with length > 2147483647 (unsupported).");
                                    }
                                }
                            }
                        }
                        obj = 1;
                        if (obj == null) {
                            i4 = fragmentedMp4Extractor2.f12975r;
                            if (i4 == Atom.aG) {
                                obj = null;
                                if (obj == null) {
                                    if (fragmentedMp4Extractor2.f12977t == 8) {
                                        throw new ParserException("Leaf atom defines extended atom size (unsupported).");
                                    } else if (fragmentedMp4Extractor2.f12976s <= 2147483647L) {
                                        throw new ParserException("Leaf atom with length > 2147483647 (unsupported).");
                                    } else {
                                        fragmentedMp4Extractor2.f12978u = new ParsableByteArray((int) fragmentedMp4Extractor2.f12976s);
                                        System.arraycopy(fragmentedMp4Extractor2.f12970m.f5256a, 0, fragmentedMp4Extractor2.f12978u.f5256a, 0, 8);
                                        fragmentedMp4Extractor2.f12974q = 1;
                                    }
                                } else if (fragmentedMp4Extractor2.f12976s <= 2147483647L) {
                                    throw new ParserException("Skipping atom with length > 2147483647 (unsupported).");
                                } else {
                                    fragmentedMp4Extractor2.f12978u = null;
                                    fragmentedMp4Extractor2.f12974q = 1;
                                }
                            } else {
                                obj = 1;
                                if (obj == null) {
                                    if (fragmentedMp4Extractor2.f12976s <= 2147483647L) {
                                        fragmentedMp4Extractor2.f12978u = null;
                                        fragmentedMp4Extractor2.f12974q = 1;
                                    } else {
                                        throw new ParserException("Skipping atom with length > 2147483647 (unsupported).");
                                    }
                                } else if (fragmentedMp4Extractor2.f12977t == 8) {
                                    throw new ParserException("Leaf atom defines extended atom size (unsupported).");
                                } else if (fragmentedMp4Extractor2.f12976s <= 2147483647L) {
                                    fragmentedMp4Extractor2.f12978u = new ParsableByteArray((int) fragmentedMp4Extractor2.f12976s);
                                    System.arraycopy(fragmentedMp4Extractor2.f12970m.f5256a, 0, fragmentedMp4Extractor2.f12978u.f5256a, 0, 8);
                                    fragmentedMp4Extractor2.f12974q = 1;
                                } else {
                                    throw new ParserException("Leaf atom with length > 2147483647 (unsupported).");
                                }
                            }
                            break;
                        }
                        d = (extractorInput.mo1338c() + fragmentedMp4Extractor2.f12976s) - 8;
                        fragmentedMp4Extractor2.f12972o.add(new ContainerAtom(fragmentedMp4Extractor2.f12975r, d));
                        if (fragmentedMp4Extractor2.f12976s != ((long) fragmentedMp4Extractor2.f12977t)) {
                            m12092a();
                        } else {
                            fragmentedMp4Extractor2.m12093a(d);
                        }
                    }
                    i2 = 1;
                    if (i2 == 0) {
                        return -1;
                    }
                    break;
                case 1:
                    i2 = ((int) fragmentedMp4Extractor.f12976s) - fragmentedMp4Extractor.f12977t;
                    if (fragmentedMp4Extractor.f12978u != null) {
                        extractorInput2.mo1336b(fragmentedMp4Extractor.f12978u.f5256a, 8, i2);
                        LeafAtom leafAtom = new LeafAtom(fragmentedMp4Extractor.f12975r, fragmentedMp4Extractor.f12978u);
                        long c = extractorInput.mo1338c();
                        if (fragmentedMp4Extractor.f12972o.isEmpty()) {
                            if (leafAtom.aP == Atom.f4324A) {
                                long h;
                                parsableByteArray = leafAtom.aQ;
                                parsableByteArray.m4249c(8);
                                a = Atom.m3787a(parsableByteArray.m4259j());
                                parsableByteArray.m4251d(4);
                                long h2 = parsableByteArray.m4257h();
                                if (a == 0) {
                                    h = parsableByteArray.m4257h();
                                    c += parsableByteArray.m4257h();
                                } else {
                                    h = parsableByteArray.m4265p();
                                    c += parsableByteArray.m4265p();
                                }
                                long j = c;
                                c = h;
                                long a2 = Util.m4303a(c, 1000000, h2);
                                parsableByteArray.m4251d(2);
                                a = parsableByteArray.m4252e();
                                int[] iArr = new int[a];
                                long[] jArr = new long[a];
                                long[] jArr2 = new long[a];
                                long[] jArr3 = new long[a];
                                long j2 = c;
                                long j3 = a2;
                                size = 0;
                                while (size < a) {
                                    i3 = parsableByteArray.m4259j();
                                    if ((Integer.MIN_VALUE & i3) != 0) {
                                        throw new ParserException("Unhandled indirect reference");
                                    }
                                    long h3 = parsableByteArray.m4257h();
                                    iArr[size] = RedditJobManager.f10810d & i3;
                                    jArr[size] = j;
                                    jArr3[size] = j3;
                                    j2 += h3;
                                    long[] jArr4 = jArr;
                                    long[] jArr5 = jArr2;
                                    long j4 = a2;
                                    j3 = Util.m4303a(j2, 1000000, h2);
                                    jArr5[size] = j3 - jArr3[size];
                                    parsableByteArray.m4251d(4);
                                    j += (long) iArr[size];
                                    size++;
                                    a2 = j4;
                                    jArr = jArr4;
                                    jArr2 = jArr5;
                                    fragmentedMp4Extractor = this;
                                    extractorInput2 = extractorInput;
                                }
                                Pair create = Pair.create(Long.valueOf(a2), new ChunkIndex(iArr, jArr, jArr2, jArr3));
                                this.f12982y = ((Long) create.first).longValue();
                                this.f12957E.mo1417a((SeekMap) create.second);
                                this.f12960H = true;
                            } else {
                                fragmentedMp4Extractor2 = fragmentedMp4Extractor;
                                if (leafAtom.aP == Atom.aG) {
                                    ParsableByteArray parsableByteArray2 = leafAtom.aQ;
                                    if (fragmentedMp4Extractor2.f12958F != null) {
                                        parsableByteArray2.m4249c(12);
                                        parsableByteArray2.m4266q();
                                        parsableByteArray2.m4266q();
                                        long a3 = Util.m4303a(parsableByteArray2.m4257h(), 1000000, parsableByteArray2.m4257h());
                                        parsableByteArray2.m4249c(12);
                                        int b = parsableByteArray2.m4246b();
                                        fragmentedMp4Extractor2.f12958F.mo1346a(parsableByteArray2, b);
                                        if (fragmentedMp4Extractor2.f12982y != -9223372036854775807L) {
                                            fragmentedMp4Extractor2.f12958F.mo1344a(fragmentedMp4Extractor2.f12982y + a3, 1, b, 0, null);
                                        } else {
                                            fragmentedMp4Extractor2.f12973p.addLast(new MetadataSampleInfo(a3, b));
                                            fragmentedMp4Extractor2.f12980w += b;
                                        }
                                    }
                                }
                            }
                            extractorInput3 = extractorInput;
                        } else {
                            ((ContainerAtom) fragmentedMp4Extractor.f12972o.peek()).m12081a(leafAtom);
                            fragmentedMp4Extractor2 = fragmentedMp4Extractor;
                            extractorInput3 = extractorInput2;
                        }
                    } else {
                        fragmentedMp4Extractor2 = fragmentedMp4Extractor;
                        extractorInput3 = extractorInput2;
                        extractorInput3.mo1335b(i2);
                    }
                    fragmentedMp4Extractor2.m12093a(extractorInput.mo1338c());
                    break;
                case 2:
                    i2 = fragmentedMp4Extractor.f12963f.size();
                    long j5 = Long.MAX_VALUE;
                    for (size = 0; size < i2; size++) {
                        TrackFragment trackFragment3 = ((TrackBundle) fragmentedMp4Extractor.f12963f.valueAt(size)).f4411a;
                        if (trackFragment3.f4486r && trackFragment3.f4472d < j5) {
                            j5 = trackFragment3.f4472d;
                            trackBundle = (TrackBundle) fragmentedMp4Extractor.f12963f.valueAt(size);
                        }
                    }
                    if (trackBundle != null) {
                        i2 = (int) (j5 - extractorInput.mo1338c());
                        if (i2 >= 0) {
                            extractorInput2.mo1335b(i2);
                            trackFragment = trackBundle.f4411a;
                            extractorInput2.mo1336b(trackFragment.f4485q.f5256a, 0, trackFragment.f4484p);
                            trackFragment.f4485q.m4249c(0);
                            trackFragment.f4486r = false;
                            break;
                        }
                        throw new ParserException("Offset to encryption data was negative.");
                    }
                    fragmentedMp4Extractor.f12974q = 3;
                    continue;
                default:
                    int i5;
                    TrackBundle trackBundle2;
                    int a4;
                    CryptoData cryptoData;
                    fragmentedMp4Extractor2 = fragmentedMp4Extractor;
                    extractorInput3 = extractorInput2;
                    if (fragmentedMp4Extractor2.f12974q == 3) {
                        int c2;
                        if (fragmentedMp4Extractor2.f12983z == null) {
                            SparseArray sparseArray = fragmentedMp4Extractor2.f12963f;
                            i2 = sparseArray.size();
                            long j6 = Long.MAX_VALUE;
                            TrackBundle trackBundle3 = null;
                            for (size = 0; size < i2; size++) {
                                TrackBundle trackBundle4 = (TrackBundle) sparseArray.valueAt(size);
                                if (trackBundle4.f4417g != trackBundle4.f4411a.f4473e) {
                                    long j7 = trackBundle4.f4411a.f4475g[trackBundle4.f4417g];
                                    if (j7 < j6) {
                                        trackBundle3 = trackBundle4;
                                        j6 = j7;
                                    }
                                }
                            }
                            if (trackBundle3 == null) {
                                i4 = (int) (fragmentedMp4Extractor2.f12979v - extractorInput.mo1338c());
                                if (i4 < 0) {
                                    throw new ParserException("Offset to end of mdat was negative.");
                                }
                                extractorInput3.mo1335b(i4);
                                m12092a();
                                i2 = 0;
                                i5 = 0;
                                if (i5 != 0) {
                                    return i2;
                                }
                            }
                            c2 = (int) (trackBundle3.f4411a.f4475g[trackBundle3.f4417g] - extractorInput.mo1338c());
                            if (c2 < 0) {
                                Log.w("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                                c2 = 0;
                            }
                            extractorInput3.mo1335b(c2);
                            fragmentedMp4Extractor2.f12983z = trackBundle3;
                        }
                        fragmentedMp4Extractor2.f12953A = fragmentedMp4Extractor2.f12983z.f4411a.f4477i[fragmentedMp4Extractor2.f12983z.f4415e];
                        if (fragmentedMp4Extractor2.f12983z.f4411a.f4481m) {
                            TrackEncryptionBox trackEncryptionBox;
                            ParsableByteArray parsableByteArray3;
                            trackBundle2 = fragmentedMp4Extractor2.f12983z;
                            trackFragment = trackBundle2.f4411a;
                            size = trackFragment.f4469a.f4400a;
                            if (trackFragment.f4483o != null) {
                                trackEncryptionBox = trackFragment.f4483o;
                            } else {
                                trackEncryptionBox = trackBundle2.f4413c.m3819a(size);
                            }
                            if (trackEncryptionBox.f4467d != 0) {
                                parsableByteArray3 = trackFragment.f4485q;
                                size = trackEncryptionBox.f4467d;
                            } else {
                                byte[] bArr = trackEncryptionBox.f4468e;
                                fragmentedMp4Extractor2.f12968k.m4244a(bArr, bArr.length);
                                parsableByteArray3 = fragmentedMp4Extractor2.f12968k;
                                size = bArr.length;
                            }
                            boolean z = trackFragment.f4482n[trackBundle2.f4415e];
                            fragmentedMp4Extractor2.f12967j.f5256a[0] = (byte) ((z ? 128 : 0) | size);
                            fragmentedMp4Extractor2.f12967j.m4249c(0);
                            TrackOutput trackOutput = trackBundle2.f4412b;
                            trackOutput.mo1346a(fragmentedMp4Extractor2.f12967j, 1);
                            trackOutput.mo1346a(parsableByteArray3, size);
                            if (z) {
                                parsableByteArray = trackFragment.f4485q;
                                i3 = parsableByteArray.m4252e();
                                parsableByteArray.m4251d(-2);
                                c2 = (6 * i3) + 2;
                                trackOutput.mo1346a(parsableByteArray, c2);
                                i4 = (1 + size) + c2;
                            } else {
                                i4 = 1 + size;
                            }
                            fragmentedMp4Extractor2.f12954B = i4;
                            fragmentedMp4Extractor2.f12953A += fragmentedMp4Extractor2.f12954B;
                        } else {
                            fragmentedMp4Extractor2.f12954B = 0;
                        }
                        if (fragmentedMp4Extractor2.f12983z.f4413c.f4459g == 1) {
                            fragmentedMp4Extractor2.f12953A -= 8;
                            extractorInput3.mo1335b(8);
                        }
                        fragmentedMp4Extractor2.f12974q = 4;
                        fragmentedMp4Extractor2.f12955C = 0;
                    }
                    TrackFragment trackFragment4 = fragmentedMp4Extractor2.f12983z.f4411a;
                    Track track = fragmentedMp4Extractor2.f12983z.f4413c;
                    TrackOutput trackOutput2 = fragmentedMp4Extractor2.f12983z.f4412b;
                    size = fragmentedMp4Extractor2.f12983z.f4415e;
                    if (track.f4462j != 0) {
                        byte[] bArr2 = fragmentedMp4Extractor2.f12965h.f5256a;
                        bArr2[0] = (byte) 0;
                        bArr2[1] = (byte) 0;
                        bArr2[2] = (byte) 0;
                        int i6 = track.f4462j + 1;
                        int i7 = 4 - track.f4462j;
                        while (fragmentedMp4Extractor2.f12954B < fragmentedMp4Extractor2.f12953A) {
                            if (fragmentedMp4Extractor2.f12955C == 0) {
                                extractorInput3.mo1336b(bArr2, i7, i6);
                                fragmentedMp4Extractor2.f12965h.m4249c(0);
                                fragmentedMp4Extractor2.f12955C = fragmentedMp4Extractor2.f12965h.m4263n() - 1;
                                fragmentedMp4Extractor2.f12964g.m4249c(0);
                                trackOutput2.mo1346a(fragmentedMp4Extractor2.f12964g, i);
                                trackOutput2.mo1346a(fragmentedMp4Extractor2.f12965h, 1);
                                boolean z2 = fragmentedMp4Extractor2.f12959G != null && NalUnitUtil.m4226a(track.f4458f.f4018f, bArr2[i]);
                                fragmentedMp4Extractor2.f12956D = z2;
                                fragmentedMp4Extractor2.f12954B += 5;
                                fragmentedMp4Extractor2.f12953A += i7;
                            } else {
                                if (fragmentedMp4Extractor2.f12956D) {
                                    fragmentedMp4Extractor2.f12966i.m4242a(fragmentedMp4Extractor2.f12955C);
                                    extractorInput3.mo1336b(fragmentedMp4Extractor2.f12966i.f5256a, 0, fragmentedMp4Extractor2.f12955C);
                                    trackOutput2.mo1346a(fragmentedMp4Extractor2.f12966i, fragmentedMp4Extractor2.f12955C);
                                    a = fragmentedMp4Extractor2.f12955C;
                                    a4 = NalUnitUtil.m4221a(fragmentedMp4Extractor2.f12966i.f5256a, fragmentedMp4Extractor2.f12966i.f5258c);
                                    fragmentedMp4Extractor2.f12966i.m4249c("video/hevc".equals(track.f4458f.f4018f));
                                    fragmentedMp4Extractor2.f12966i.m4247b(a4);
                                    CeaUtil.m4064a(trackFragment4.m3821b(size) * 1000, fragmentedMp4Extractor2.f12966i, fragmentedMp4Extractor2.f12959G);
                                } else {
                                    a = trackOutput2.mo1343a(extractorInput3, fragmentedMp4Extractor2.f12955C, false);
                                }
                                fragmentedMp4Extractor2.f12954B += a;
                                fragmentedMp4Extractor2.f12955C -= a;
                                i = 4;
                            }
                        }
                    } else {
                        while (fragmentedMp4Extractor2.f12954B < fragmentedMp4Extractor2.f12953A) {
                            fragmentedMp4Extractor2.f12954B += trackOutput2.mo1343a(extractorInput3, fragmentedMp4Extractor2.f12953A - fragmentedMp4Extractor2.f12954B, false);
                        }
                    }
                    long b2 = trackFragment4.m3821b(size) * 1000;
                    if (fragmentedMp4Extractor2.f12969l != null) {
                        b2 = fragmentedMp4Extractor2.f12969l.m4288c(b2);
                    }
                    boolean z3 = trackFragment4.f4480l[size];
                    if (trackFragment4.f4481m) {
                        TrackEncryptionBox trackEncryptionBox2;
                        size = z3 | 1073741824;
                        if (trackFragment4.f4483o != null) {
                            trackEncryptionBox2 = trackFragment4.f4483o;
                        } else {
                            trackEncryptionBox2 = track.m3819a(trackFragment4.f4469a.f4400a);
                        }
                        a4 = size;
                        cryptoData = trackEncryptionBox2.f4466c;
                    } else {
                        a4 = z3;
                        cryptoData = null;
                    }
                    trackOutput2.mo1344a(b2, a4, fragmentedMp4Extractor2.f12953A, 0, cryptoData);
                    while (!fragmentedMp4Extractor2.f12973p.isEmpty()) {
                        MetadataSampleInfo metadataSampleInfo = (MetadataSampleInfo) fragmentedMp4Extractor2.f12973p.removeFirst();
                        fragmentedMp4Extractor2.f12980w -= metadataSampleInfo.f4410b;
                        fragmentedMp4Extractor2.f12958F.mo1344a(b2 + metadataSampleInfo.f4409a, 1, metadataSampleInfo.f4410b, fragmentedMp4Extractor2.f12980w, null);
                    }
                    TrackBundle trackBundle5 = fragmentedMp4Extractor2.f12983z;
                    trackBundle5.f4415e++;
                    trackBundle5 = fragmentedMp4Extractor2.f12983z;
                    trackBundle5.f4416f++;
                    if (fragmentedMp4Extractor2.f12983z.f4416f == trackFragment4.f4476h[fragmentedMp4Extractor2.f12983z.f4417g]) {
                        trackBundle2 = fragmentedMp4Extractor2.f12983z;
                        trackBundle2.f4417g++;
                        i2 = 0;
                        fragmentedMp4Extractor2.f12983z.f4416f = 0;
                        fragmentedMp4Extractor2.f12983z = null;
                    } else {
                        i2 = 0;
                    }
                    fragmentedMp4Extractor2.f12974q = 3;
                    i5 = 1;
                    if (i5 != 0) {
                        return i2;
                    }
                    break;
            }
            extractorInput2 = extractorInput3;
            fragmentedMp4Extractor = fragmentedMp4Extractor2;
        }
    }

    private void m12092a() {
        this.f12974q = 0;
        this.f12977t = 0;
    }

    private void m12093a(long j) throws ParserException {
        FragmentedMp4Extractor fragmentedMp4Extractor = this;
        while (!fragmentedMp4Extractor.f12972o.isEmpty() && ((ContainerAtom) fragmentedMp4Extractor.f12972o.peek()).aQ == j) {
            ContainerAtom containerAtom = (ContainerAtom) fragmentedMp4Extractor.f12972o.pop();
            if (containerAtom.aP == Atom.f4325B) {
                int i = 1;
                Assertions.m4187b(fragmentedMp4Extractor.f12962e == null, "Unexpected moov box.");
                DrmInitData a = m12091a(containerAtom.aR);
                ContainerAtom e = containerAtom.m12083e(Atom.f4336M);
                SparseArray sparseArray = new SparseArray();
                int size = e.aR.size();
                long j2 = -9223372036854775807L;
                int i2 = 0;
                while (i2 < size) {
                    LeafAtom leafAtom = (LeafAtom) e.aR.get(i2);
                    if (leafAtom.aP == Atom.f4374y) {
                        ParsableByteArray parsableByteArray = leafAtom.aQ;
                        parsableByteArray.m4249c(12);
                        Pair create = Pair.create(Integer.valueOf(parsableByteArray.m4259j()), new DefaultSampleValues(parsableByteArray.m4263n() - i, parsableByteArray.m4263n(), parsableByteArray.m4263n(), parsableByteArray.m4259j()));
                        sparseArray.put(((Integer) create.first).intValue(), create.second);
                    } else if (leafAtom.aP == Atom.f4337N) {
                        long h;
                        ParsableByteArray parsableByteArray2 = leafAtom.aQ;
                        parsableByteArray2.m4249c(8);
                        if (Atom.m3787a(parsableByteArray2.m4259j()) == 0) {
                            h = parsableByteArray2.m4257h();
                        } else {
                            h = parsableByteArray2.m4265p();
                        }
                        j2 = h;
                    }
                    i2++;
                    i = 1;
                }
                SparseArray sparseArray2 = new SparseArray();
                int size2 = containerAtom.aS.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    e = (ContainerAtom) containerAtom.aS.get(i3);
                    if (e.aP == Atom.f4327D) {
                        Track a2 = AtomParsers.m3802a(e, containerAtom.m12082d(Atom.f4326C), j2, a, false);
                        if (a2 != null) {
                            sparseArray2.put(a2.f4453a, a2);
                        }
                    }
                }
                int size3 = sparseArray2.size();
                int i4;
                Track track;
                if (fragmentedMp4Extractor.f12963f.size() == 0) {
                    for (i4 = 0; i4 < size3; i4++) {
                        track = (Track) sparseArray2.valueAt(i4);
                        TrackBundle trackBundle = new TrackBundle(fragmentedMp4Extractor.f12957E.mo1415a(i4, track.f4454b));
                        trackBundle.m3807a(track, (DefaultSampleValues) sparseArray.get(track.f4453a));
                        fragmentedMp4Extractor.f12963f.put(track.f4453a, trackBundle);
                        fragmentedMp4Extractor.f12981x = Math.max(fragmentedMp4Extractor.f12981x, track.f4457e);
                    }
                    m12096b();
                    fragmentedMp4Extractor.f12957E.mo1416a();
                } else {
                    Assertions.m4186b(fragmentedMp4Extractor.f12963f.size() == size3);
                    for (i4 = 0; i4 < size3; i4++) {
                        track = (Track) sparseArray2.valueAt(i4);
                        ((TrackBundle) fragmentedMp4Extractor.f12963f.get(track.f4453a)).m3807a(track, (DefaultSampleValues) sparseArray.get(track.f4453a));
                    }
                }
            } else if (containerAtom.aP == Atom.f4334K) {
                m12094a(containerAtom);
            } else if (!fragmentedMp4Extractor.f12972o.isEmpty()) {
                ((ContainerAtom) fragmentedMp4Extractor.f12972o.peek()).m12080a(containerAtom);
            }
        }
        m12092a();
    }

    private void m12094a(ContainerAtom containerAtom) throws ParserException {
        ContainerAtom containerAtom2 = containerAtom;
        SparseArray sparseArray = this.f12963f;
        int i = this.f12961d;
        byte[] bArr = this.f12971n;
        int size = containerAtom2.aS.size();
        int i2 = 0;
        while (i2 < size) {
            int i3;
            SparseArray sparseArray2;
            int i4;
            int n;
            int i5;
            FragmentedMp4Extractor fragmentedMp4Extractor;
            int i6;
            byte[] bArr2;
            ContainerAtom containerAtom3 = (ContainerAtom) containerAtom2.aS.get(i2);
            if (containerAtom3.aP == Atom.f4335L) {
                long p;
                ParsableByteArray parsableByteArray = containerAtom3.m12082d(Atom.f4373x).aQ;
                parsableByteArray.m4249c(8);
                int b = Atom.m3788b(parsableByteArray.m4259j());
                int j = parsableByteArray.m4259j();
                if ((i & 16) != 0) {
                    j = 0;
                }
                TrackBundle trackBundle = (TrackBundle) sparseArray.get(j);
                if (trackBundle == null) {
                    i3 = i2;
                    trackBundle = null;
                } else {
                    if ((b & 1) != 0) {
                        i3 = i2;
                        p = parsableByteArray.m4265p();
                        trackBundle.f4411a.f4471c = p;
                        trackBundle.f4411a.f4472d = p;
                    } else {
                        i3 = i2;
                    }
                    DefaultSampleValues defaultSampleValues = trackBundle.f4414d;
                    trackBundle.f4411a.f4469a = new DefaultSampleValues((b & 2) != 0 ? parsableByteArray.m4263n() - 1 : defaultSampleValues.f4400a, (b & 8) != 0 ? parsableByteArray.m4263n() : defaultSampleValues.f4401b, (b & 16) != 0 ? parsableByteArray.m4263n() : defaultSampleValues.f4402c, (b & 32) != 0 ? parsableByteArray.m4263n() : defaultSampleValues.f4403d);
                }
                if (trackBundle != null) {
                    LeafAtom leafAtom;
                    long j2;
                    ParsableByteArray parsableByteArray2;
                    int i7;
                    byte[] bArr3;
                    ContainerAtom containerAtom4;
                    long j3;
                    boolean z;
                    int d;
                    ParsableByteArray parsableByteArray3;
                    int i8;
                    TrackFragment trackFragment = trackBundle.f4411a;
                    long j4 = trackFragment.f4487s;
                    trackBundle.m3806a();
                    if (containerAtom3.m12082d(Atom.f4372w) != null && (i & 2) == 0) {
                        ParsableByteArray parsableByteArray4 = containerAtom3.m12082d(Atom.f4372w).aQ;
                        parsableByteArray4.m4249c(8);
                        j4 = Atom.m3787a(parsableByteArray4.m4259j()) == 1 ? parsableByteArray4.m4265p() : parsableByteArray4.m4257h();
                    }
                    List list = containerAtom3.aR;
                    b = list.size();
                    int i9 = 0;
                    int i10 = 0;
                    int i11 = 0;
                    while (i11 < b) {
                        sparseArray2 = sparseArray;
                        leafAtom = (LeafAtom) list.get(i11);
                        i4 = size;
                        j2 = j4;
                        if (leafAtom.aP == Atom.f4375z) {
                            parsableByteArray2 = leafAtom.aQ;
                            parsableByteArray2.m4249c(12);
                            n = parsableByteArray2.m4263n();
                            if (n > 0) {
                                i9 += n;
                                i10++;
                            }
                        }
                        i11++;
                        sparseArray = sparseArray2;
                        size = i4;
                        j4 = j2;
                    }
                    sparseArray2 = sparseArray;
                    i4 = size;
                    j2 = j4;
                    trackBundle.f4417g = 0;
                    trackBundle.f4416f = 0;
                    trackBundle.f4415e = 0;
                    TrackFragment trackFragment2 = trackBundle.f4411a;
                    trackFragment2.f4473e = i10;
                    trackFragment2.f4474f = i9;
                    if (trackFragment2.f4476h == null || trackFragment2.f4476h.length < i10) {
                        trackFragment2.f4475g = new long[i10];
                        trackFragment2.f4476h = new int[i10];
                    }
                    if (trackFragment2.f4477i == null || trackFragment2.f4477i.length < i9) {
                        i9 = (i9 * 125) / 100;
                        trackFragment2.f4477i = new int[i9];
                        trackFragment2.f4478j = new int[i9];
                        trackFragment2.f4479k = new long[i9];
                        trackFragment2.f4480l = new boolean[i9];
                        trackFragment2.f4482n = new boolean[i9];
                    }
                    n = 0;
                    size = 0;
                    i2 = 0;
                    while (n < b) {
                        List list2;
                        int i12;
                        TrackBundle trackBundle2;
                        int i13;
                        TrackFragment trackFragment3;
                        LeafAtom leafAtom2 = (LeafAtom) list.get(n);
                        int i14;
                        if (leafAtom2.aP == Atom.f4375z) {
                            Object obj;
                            Object obj2;
                            long a;
                            int[] iArr;
                            int[] iArr2;
                            long[] jArr;
                            boolean[] zArr;
                            Object obj3;
                            int i15;
                            Object obj4;
                            long[] jArr2;
                            long j5;
                            int n2;
                            int i16;
                            Object obj5;
                            DefaultSampleValues defaultSampleValues2;
                            ParsableByteArray parsableByteArray5;
                            i7 = size + 1;
                            ParsableByteArray parsableByteArray6 = leafAtom2.aQ;
                            parsableByteArray6.m4249c(8);
                            i10 = Atom.m3788b(parsableByteArray6.m4259j());
                            Track track = trackBundle.f4413c;
                            int i17 = i7;
                            TrackFragment trackFragment4 = trackBundle.f4411a;
                            list2 = list;
                            DefaultSampleValues defaultSampleValues3 = trackFragment4.f4469a;
                            i12 = b;
                            trackFragment4.f4476h[size] = parsableByteArray6.m4263n();
                            trackFragment4.f4475g[size] = trackFragment4.f4471c;
                            if ((i10 & 1) != 0) {
                                long[] jArr3 = trackFragment4.f4475g;
                                trackBundle2 = trackBundle;
                                jArr3[size] = jArr3[size] + ((long) parsableByteArray6.m4259j());
                            } else {
                                trackBundle2 = trackBundle;
                            }
                            Object obj6 = (i10 & 4) != 0 ? 1 : null;
                            int i18 = defaultSampleValues3.f4403d;
                            if (obj6 != null) {
                                i18 = parsableByteArray6.m4263n();
                            }
                            Object obj7 = (i10 & 256) != 0 ? 1 : null;
                            Object obj8 = (i10 & AdRequest.MAX_CONTENT_URL_LENGTH) != 0 ? 1 : null;
                            int i19 = i18;
                            Object obj9 = (i10 & 1024) != 0 ? 1 : null;
                            if ((i10 & MPEGConst.CODE_END) != 0) {
                                bArr3 = bArr;
                                obj = 1;
                            } else {
                                bArr3 = bArr;
                                obj = null;
                            }
                            if (track.f4460h != null) {
                                containerAtom4 = containerAtom3;
                                if (track.f4460h.length == 1 && track.f4460h[0] == 0) {
                                    obj2 = obj9;
                                    i13 = n;
                                    a = Util.m4303a(track.f4461i[0], 1000, track.f4455c);
                                    iArr = trackFragment4.f4477i;
                                    iArr2 = trackFragment4.f4478j;
                                    jArr = trackFragment4.f4479k;
                                    trackFragment3 = trackFragment;
                                    zArr = trackFragment4.f4480l;
                                    obj3 = (track.f4454b == 2 || (i & 1) == 0) ? null : 1;
                                    i15 = trackFragment4.f4476h[size] + i2;
                                    obj4 = obj3;
                                    i14 = i2;
                                    p = track.f4455c;
                                    if (size <= 0) {
                                        i5 = i;
                                        jArr2 = jArr;
                                        j5 = trackFragment4.f4487s;
                                    } else {
                                        i5 = i;
                                        jArr2 = jArr;
                                        j5 = j2;
                                    }
                                    j3 = j5;
                                    i = i14;
                                    while (i < i15) {
                                        i11 = obj7 == null ? parsableByteArray6.m4263n() : defaultSampleValues3.f4401b;
                                        if (obj8 == null) {
                                            n2 = parsableByteArray6.m4263n();
                                            i16 = i15;
                                        } else {
                                            i16 = i15;
                                            n2 = defaultSampleValues3.f4402c;
                                        }
                                        i15 = (i == 0 || obj6 == null) ? obj2 == null ? parsableByteArray6.m4259j() : defaultSampleValues3.f4403d : i19;
                                        if (obj == null) {
                                            obj5 = obj6;
                                            defaultSampleValues2 = defaultSampleValues3;
                                            parsableByteArray5 = parsableByteArray6;
                                            iArr2[i] = (int) ((((long) parsableByteArray6.m4259j()) * 1000) / p);
                                        } else {
                                            obj5 = obj6;
                                            defaultSampleValues2 = defaultSampleValues3;
                                            parsableByteArray5 = parsableByteArray6;
                                            iArr2[i] = 0;
                                        }
                                        jArr2[i] = Util.m4303a(j3, 1000, p) - a;
                                        iArr[i] = n2;
                                        z = ((i15 >> 16) & 1) != 0 && (obj4 == null || i == 0);
                                        zArr[i] = z;
                                        j3 += (long) i11;
                                        i++;
                                        i15 = i16;
                                        obj6 = obj5;
                                        parsableByteArray6 = parsableByteArray5;
                                        defaultSampleValues3 = defaultSampleValues2;
                                    }
                                    i16 = i15;
                                    trackFragment4.f4487s = j3;
                                    size = i17;
                                    i2 = i16;
                                } else {
                                    obj2 = obj9;
                                    i13 = n;
                                }
                            } else {
                                obj2 = obj9;
                                i13 = n;
                                containerAtom4 = containerAtom3;
                            }
                            a = 0;
                            iArr = trackFragment4.f4477i;
                            iArr2 = trackFragment4.f4478j;
                            jArr = trackFragment4.f4479k;
                            trackFragment3 = trackFragment;
                            zArr = trackFragment4.f4480l;
                            if (track.f4454b == 2) {
                            }
                            i15 = trackFragment4.f4476h[size] + i2;
                            obj4 = obj3;
                            i14 = i2;
                            p = track.f4455c;
                            if (size <= 0) {
                                i5 = i;
                                jArr2 = jArr;
                                j5 = j2;
                            } else {
                                i5 = i;
                                jArr2 = jArr;
                                j5 = trackFragment4.f4487s;
                            }
                            j3 = j5;
                            i = i14;
                            while (i < i15) {
                                if (obj7 == null) {
                                }
                                if (obj8 == null) {
                                    i16 = i15;
                                    n2 = defaultSampleValues3.f4402c;
                                } else {
                                    n2 = parsableByteArray6.m4263n();
                                    i16 = i15;
                                }
                                if (i == 0) {
                                }
                                if (obj2 == null) {
                                }
                                if (obj == null) {
                                    obj5 = obj6;
                                    defaultSampleValues2 = defaultSampleValues3;
                                    parsableByteArray5 = parsableByteArray6;
                                    iArr2[i] = 0;
                                } else {
                                    obj5 = obj6;
                                    defaultSampleValues2 = defaultSampleValues3;
                                    parsableByteArray5 = parsableByteArray6;
                                    iArr2[i] = (int) ((((long) parsableByteArray6.m4259j()) * 1000) / p);
                                }
                                jArr2[i] = Util.m4303a(j3, 1000, p) - a;
                                iArr[i] = n2;
                                if (((i15 >> 16) & 1) != 0) {
                                }
                                zArr[i] = z;
                                j3 += (long) i11;
                                i++;
                                i15 = i16;
                                obj6 = obj5;
                                parsableByteArray6 = parsableByteArray5;
                                defaultSampleValues3 = defaultSampleValues2;
                            }
                            i16 = i15;
                            trackFragment4.f4487s = j3;
                            size = i17;
                            i2 = i16;
                        } else {
                            i13 = n;
                            i5 = i;
                            bArr3 = bArr;
                            trackFragment3 = trackFragment;
                            i14 = i2;
                            containerAtom4 = containerAtom3;
                            list2 = list;
                            i12 = b;
                            trackBundle2 = trackBundle;
                        }
                        n = i13 + 1;
                        list = list2;
                        b = i12;
                        trackBundle = trackBundle2;
                        bArr = bArr3;
                        containerAtom3 = containerAtom4;
                        trackFragment = trackFragment3;
                        i = i5;
                        fragmentedMp4Extractor = this;
                        containerAtom2 = containerAtom;
                    }
                    i5 = i;
                    bArr3 = bArr;
                    containerAtom4 = containerAtom3;
                    TrackFragment trackFragment5 = trackFragment;
                    TrackEncryptionBox a2 = trackBundle.f4413c.m3819a(trackFragment5.f4469a.f4400a);
                    leafAtom = containerAtom3.m12082d(Atom.ac);
                    if (leafAtom != null) {
                        parsableByteArray2 = leafAtom.aQ;
                        i = a2.f4467d;
                        parsableByteArray2.m4249c(8);
                        if ((Atom.m3788b(parsableByteArray2.m4259j()) & 1) == 1) {
                            parsableByteArray2.m4251d(8);
                        }
                        d = parsableByteArray2.m4250d();
                        size = parsableByteArray2.m4263n();
                        if (size != trackFragment5.f4474f) {
                            StringBuilder stringBuilder = new StringBuilder("Length mismatch: ");
                            stringBuilder.append(size);
                            stringBuilder.append(", ");
                            stringBuilder.append(trackFragment5.f4474f);
                            throw new ParserException(stringBuilder.toString());
                        }
                        if (d == 0) {
                            boolean[] zArr2 = trackFragment5.f4482n;
                            i2 = 0;
                            for (i6 = 0; i6 < size; i6++) {
                                i7 = parsableByteArray2.m4250d();
                                i2 += i7;
                                zArr2[i6] = i7 > i;
                            }
                        } else {
                            i2 = 0 + (d * size);
                            Arrays.fill(trackFragment5.f4482n, 0, size, d > i);
                        }
                        trackFragment5.m3820a(i2);
                    }
                    leafAtom = containerAtom3.m12082d(Atom.ad);
                    if (leafAtom != null) {
                        parsableByteArray2 = leafAtom.aQ;
                        parsableByteArray2.m4249c(8);
                        d = parsableByteArray2.m4259j();
                        if ((Atom.m3788b(d) & 1) == 1) {
                            parsableByteArray2.m4251d(8);
                        }
                        i = parsableByteArray2.m4263n();
                        if (i != 1) {
                            StringBuilder stringBuilder2 = new StringBuilder("Unexpected saio entry count: ");
                            stringBuilder2.append(i);
                            throw new ParserException(stringBuilder2.toString());
                        }
                        long h;
                        i = Atom.m3787a(d);
                        j3 = trackFragment5.f4472d;
                        if (i == 0) {
                            h = parsableByteArray2.m4257h();
                        } else {
                            h = parsableByteArray2.m4265p();
                        }
                        trackFragment5.f4472d = j3 + h;
                    }
                    leafAtom = containerAtom3.m12082d(Atom.ah);
                    if (leafAtom != null) {
                        m12095a(leafAtom.aQ, 0, trackFragment5);
                    }
                    leafAtom = containerAtom3.m12082d(Atom.ae);
                    LeafAtom d2 = containerAtom3.m12082d(Atom.af);
                    if (!(leafAtom == null || d2 == null)) {
                        String str;
                        parsableByteArray2 = leafAtom.aQ;
                        parsableByteArray3 = d2.aQ;
                        if (a2 != null) {
                            str = a2.f4465b;
                            i8 = 8;
                        } else {
                            i8 = 8;
                            str = null;
                        }
                        parsableByteArray2.m4249c(i8);
                        i8 = parsableByteArray2.m4259j();
                        if (parsableByteArray2.m4259j() == f12951b) {
                            if (Atom.m3787a(i8) == 1) {
                                parsableByteArray2.m4251d(4);
                            }
                            if (parsableByteArray2.m4259j() != 1) {
                                throw new ParserException("Entry count in sbgp != 1 (unsupported).");
                            }
                            parsableByteArray3.m4249c(8);
                            i8 = parsableByteArray3.m4259j();
                            if (parsableByteArray3.m4259j() == f12951b) {
                                i8 = Atom.m3787a(i8);
                                if (i8 == 1) {
                                    if (parsableByteArray3.m4257h() == 0) {
                                        throw new ParserException("Variable length description in sgpd found (unsupported)");
                                    }
                                } else if (i8 >= 2) {
                                    parsableByteArray3.m4251d(4);
                                }
                                if (parsableByteArray3.m4257h() != 1) {
                                    throw new ParserException("Entry count in sgpd != 1 (unsupported).");
                                }
                                parsableByteArray3.m4251d(1);
                                n = parsableByteArray3.m4250d();
                                int i20 = (n & 240) >> 4;
                                int i21 = n & 15;
                                if ((parsableByteArray3.m4250d() == 1 ? 1 : null) != null) {
                                    byte[] bArr4;
                                    int d3 = parsableByteArray3.m4250d();
                                    byte[] bArr5 = new byte[16];
                                    parsableByteArray3.m4245a(bArr5, 0, 16);
                                    if (d3 == 0) {
                                        i8 = parsableByteArray3.m4250d();
                                        byte[] bArr6 = new byte[i8];
                                        parsableByteArray3.m4245a(bArr6, 0, i8);
                                        bArr4 = bArr6;
                                        z = true;
                                    } else {
                                        z = true;
                                        bArr4 = null;
                                    }
                                    trackFragment5.f4481m = z;
                                    trackFragment5.f4483o = new TrackEncryptionBox(true, str, d3, bArr5, i20, i21, bArr4);
                                }
                            }
                        }
                    }
                    i8 = containerAtom3.aR.size();
                    n = 0;
                    while (n < i8) {
                        d2 = (LeafAtom) containerAtom3.aR.get(n);
                        if (d2.aP == Atom.ag) {
                            parsableByteArray3 = d2.aQ;
                            parsableByteArray3.m4249c(8);
                            bArr2 = bArr3;
                            parsableByteArray3.m4245a(bArr2, 0, 16);
                            if (Arrays.equals(bArr2, f12952c)) {
                                m12095a(parsableByteArray3, 16, trackFragment5);
                            }
                        } else {
                            bArr2 = bArr3;
                        }
                        n++;
                        bArr3 = bArr2;
                    }
                    bArr2 = bArr3;
                    i2 = i3 + 1;
                    bArr = bArr2;
                    sparseArray = sparseArray2;
                    size = i4;
                    i = i5;
                    fragmentedMp4Extractor = this;
                    containerAtom2 = containerAtom;
                } else {
                    sparseArray2 = sparseArray;
                    i5 = i;
                    i4 = size;
                }
            } else {
                sparseArray2 = sparseArray;
                i5 = i;
                i4 = size;
                i3 = i2;
            }
            bArr2 = bArr;
            i2 = i3 + 1;
            bArr = bArr2;
            sparseArray = sparseArray2;
            size = i4;
            i = i5;
            fragmentedMp4Extractor = this;
            containerAtom2 = containerAtom;
        }
        DrmInitData a3 = m12091a(containerAtom2.aR);
        if (a3 != null) {
            n = this.f12963f.size();
            for (i6 = 0; i6 < n; i6++) {
                FragmentedMp4Extractor fragmentedMp4Extractor2;
                TrackBundle trackBundle3 = (TrackBundle) fragmentedMp4Extractor2.f12963f.valueAt(i6);
                TrackEncryptionBox a4 = trackBundle3.f4413c.m3819a(trackBundle3.f4411a.f4469a.f4400a);
                trackBundle3.f4412b.mo1345a(trackBundle3.f4413c.f4458f.m3576a(a3.m3725a(a4 != null ? a4.f4465b : null)));
            }
            return;
        }
        fragmentedMp4Extractor2 = this;
    }

    private void m12096b() {
        if ((this.f12961d & 4) != 0 && this.f12958F == null) {
            this.f12958F = this.f12957E.mo1415a(this.f12963f.size(), 4);
            this.f12958F.mo1345a(Format.m3554a("application/x-emsg", Long.MAX_VALUE));
        }
        if ((this.f12961d & 8) != 0 && this.f12959G == null) {
            this.f12957E.mo1415a(this.f12963f.size() + 1, 3).mo1345a(Format.m3555a(null, "application/cea-608"));
            this.f12959G = new TrackOutput[]{r0};
        }
    }

    private static void m12095a(ParsableByteArray parsableByteArray, int i, TrackFragment trackFragment) throws ParserException {
        parsableByteArray.m4249c(8 + i);
        i = Atom.m3788b(parsableByteArray.m4259j());
        if ((i & 1) != 0) {
            throw new ParserException("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        i = (i & 2) != 0 ? 1 : 0;
        int n = parsableByteArray.m4263n();
        if (n != trackFragment.f4474f) {
            i = new StringBuilder("Length mismatch: ");
            i.append(n);
            i.append(", ");
            i.append(trackFragment.f4474f);
            throw new ParserException(i.toString());
        }
        Arrays.fill(trackFragment.f4482n, 0, n, i);
        trackFragment.m3820a(parsableByteArray.m4246b());
        parsableByteArray.m4245a(trackFragment.f4485q.f5256a, 0, trackFragment.f4484p);
        trackFragment.f4485q.m4249c(0);
        trackFragment.f4486r = false;
    }

    private static DrmInitData m12091a(List<LeafAtom> list) {
        int size = list.size();
        List list2 = null;
        for (int i = 0; i < size; i++) {
            LeafAtom leafAtom = (LeafAtom) list.get(i);
            if (leafAtom.aP == Atom.f4344U) {
                if (list2 == null) {
                    list2 = new ArrayList();
                }
                byte[] bArr = leafAtom.aQ.f5256a;
                UUID a = PsshAtomUtil.m3814a(bArr);
                if (a == null) {
                    Log.w("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    list2.add(new SchemeData(a, "video/mp4", bArr));
                }
            }
        }
        if (list2 == null) {
            return null;
        }
        return new DrmInitData(list2);
    }
}
