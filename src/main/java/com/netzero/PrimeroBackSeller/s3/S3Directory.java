package com.netzero.PrimeroBackSeller.s3;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum S3Directory {
    RECREATION_THUMBNAIL("recreation/thumbnail"),
    RECREATION_WAY("recreation/way");

    private final String directory;
}
