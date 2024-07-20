package com.netzero.PrimeroBackSeller.apiPayload.exception;

import com.netzero.PrimeroBackSeller.apiPayload.code.BaseErrorCode;

public class S3Exception extends GeneralException{
    public S3Exception(BaseErrorCode code) {
        super(code);
    }
}
