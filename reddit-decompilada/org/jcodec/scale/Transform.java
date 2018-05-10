package org.jcodec.scale;

import org.jcodec.common.model.Picture;

public interface Transform {
    void transform(Picture picture, Picture picture2);
}
