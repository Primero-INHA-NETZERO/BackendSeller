package com.netzero.PrimeroBackSeller.apiPayload.exception;

import com.netzero.PrimeroBackSeller.apiPayload.code.BaseErrorCode;

public class ConsumerException extends GeneralException{
    public ConsumerException(BaseErrorCode code) {
        super(code);
    }
}
