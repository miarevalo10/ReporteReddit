package org.jcodec.movtool.streaming;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import org.jcodec.common.NIOUtils;

public class ConcurrentMovieRangeService {
    private ExecutorService exec;
    private VirtualMovie movie;

    class C22131 implements ThreadFactory {
        final /* synthetic */ ConcurrentMovieRangeService f26835a;

        C22131(ConcurrentMovieRangeService concurrentMovieRangeService) {
            this.f26835a = concurrentMovieRangeService;
        }

        public Thread newThread(Runnable runnable) {
            runnable = Executors.defaultThreadFactory().newThread(runnable);
            runnable.setDaemon(true);
            return runnable;
        }
    }

    public class ConcurrentMovieRange extends InputStream {
        private static final int READ_AHEAD_SEGMENTS = 10;
        private int nextReadAheadNo;
        private long remaining;
        private List<Future<ByteBuffer>> segments = new ArrayList();
        private long to;

        public ConcurrentMovieRange(long j, long j2) throws IOException {
            if (j2 < j) {
                throw new IllegalArgumentException("from < to");
            }
            this.remaining = (j2 - j) + 1;
            this.to = j2;
            ConcurrentMovieRangeService packetAt = ConcurrentMovieRangeService.this.movie.getPacketAt(j);
            if (packetAt != null) {
                this.nextReadAheadNo = packetAt.getNo();
                scheduleSegmentRetrieve(packetAt);
                for (j2 = null; j2 < 10; j2++) {
                    tryReadAhead();
                }
                NIOUtils.skip(segmentData(), (int) (j - packetAt.getPos()));
            }
        }

        public int read(byte[] bArr, int i, int i2) throws IOException {
            if (this.segments.size() != 0) {
                if (this.remaining != 0) {
                    i2 = (int) Math.min((long) i2, this.remaining);
                    int i3 = 0;
                    while (i2 > 0 && this.segments.size() > 0) {
                        ByteBuffer segmentData = segmentData();
                        int min = Math.min(segmentData.remaining(), i2);
                        segmentData.get(bArr, i, min);
                        i3 += min;
                        i2 -= min;
                        i += min;
                        disposeReadAhead(segmentData);
                    }
                    this.remaining -= (long) i3;
                    return i3;
                }
            }
            return -1;
        }

        private void disposeReadAhead(ByteBuffer byteBuffer) {
            if (byteBuffer.hasRemaining() == null) {
                this.segments.remove(0);
                tryReadAhead();
            }
        }

        private void tryReadAhead() {
            MovieSegment packetByNo = ConcurrentMovieRangeService.this.movie.getPacketByNo(this.nextReadAheadNo);
            if (packetByNo != null && packetByNo.getPos() < this.to) {
                scheduleSegmentRetrieve(packetByNo);
            }
        }

        private void scheduleSegmentRetrieve(MovieSegment movieSegment) {
            this.segments.add(ConcurrentMovieRangeService.this.exec.submit(new GetCallable(movieSegment)));
            this.nextReadAheadNo++;
        }

        private ByteBuffer segmentData() throws IOException {
            try {
                return (ByteBuffer) ((Future) this.segments.get(0)).get();
            } catch (Throwable e) {
                throw new IOException(e);
            } catch (Throwable e2) {
                throw new IOException(e2);
            }
        }

        public void close() throws IOException {
            for (Future cancel : this.segments) {
                cancel.cancel(false);
            }
        }

        public int read() throws IOException {
            if (this.segments.size() != 0) {
                if (this.remaining != 0) {
                    ByteBuffer segmentData = segmentData();
                    int i = segmentData.get() & 255;
                    disposeReadAhead(segmentData);
                    this.remaining--;
                    return i;
                }
            }
            return -1;
        }
    }

    static class GetCallable implements Callable<ByteBuffer> {
        private MovieSegment f26836a;

        public GetCallable(MovieSegment movieSegment) {
            this.f26836a = movieSegment;
        }

        public /* synthetic */ Object call() throws Exception {
            return MovieRange.checkDataLen(this.f26836a.getData() == null ? null : this.f26836a.getData().duplicate(), this.f26836a.getDataLen());
        }
    }

    public ConcurrentMovieRangeService(VirtualMovie virtualMovie, int i) {
        this.exec = Executors.newFixedThreadPool(i, new C22131(this));
        this.movie = virtualMovie;
    }

    public void shutdown() {
        this.exec.shutdown();
    }

    public InputStream getRange(long j, long j2) throws IOException {
        return new ConcurrentMovieRange(j, j2);
    }
}
