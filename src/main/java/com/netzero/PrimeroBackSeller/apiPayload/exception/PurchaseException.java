package com.netzero.PrimeroBackSeller.apiPayload.exception;

import com.netzero.PrimeroBackSeller.apiPayload.code.BaseErrorCode;

public class PurchaseException extends GeneralException{
    public PurchaseException(BaseErrorCode code) {
        super(code);
    }
}
