package com.netzero.PrimeroBackSeller.apiPayload.exception;

import com.netzero.PrimeroBackSeller.apiPayload.code.BaseErrorCode;

public class SellerException extends GeneralException{
    public SellerException(BaseErrorCode code) {
        super(code);
    }
}
