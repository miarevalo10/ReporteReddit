package com.google.android.exoplayer2.source.chunk;

import java.io.IOException;

public interface ChunkSource {
    void mo3359a() throws IOException;

    void mo3360a(Chunk chunk);

    void mo3361a(MediaChunk mediaChunk, long j, ChunkHolder chunkHolder);

    boolean mo3363a(Chunk chunk, boolean z, Exception exception);
}
